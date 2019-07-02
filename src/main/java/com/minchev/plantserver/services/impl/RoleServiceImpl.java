package com.minchev.plantserver.services.impl;

import com.minchev.plantserver.database.entity.RoleEntity;
import com.minchev.plantserver.database.repository.RoleRepository;
import com.minchev.plantserver.models.RoleServiceModel;
import com.minchev.plantserver.services.api.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedRolesInDb() {
        if (this.roleRepository.count() == 0) {
            this.roleRepository.saveAndFlush(new RoleEntity("role_user"));
            this.roleRepository.saveAndFlush(new RoleEntity("role_manager"));
            this.roleRepository.saveAndFlush(new RoleEntity("role_admin"));
            this.roleRepository.saveAndFlush(new RoleEntity("role_root"));
        }
    }

//    @Override
//    public void assignUserRoles(UserServiceModel userServiceModel, long numberOfUsers) {
//        if (numberOfUsers == 0) {
//            userServiceModel
//                    .setAuthorities(this.roleRepository
//                            .findAll()
//                            .stream()
//                            .map(r -> this.modelMapper.map(r, RoleServiceModel.class))
//                            .collect(Collectors.toSet()));
//        }
//    }


    @Override
    public Set<RoleServiceModel> findAllRoles() {
        this.seedRolesInDb();


        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, RoleServiceModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public RoleServiceModel findByAuthority(String authority) {
        return this.modelMapper.map(this.roleRepository.findByAuthority(authority), RoleServiceModel.class);
    }

    public RoleServiceModel findById(String id) {
        Optional<RoleEntity> role = this.roleRepository.findById(id);

        if (role.isPresent()) {
            return this.modelMapper.map(role.get(), RoleServiceModel.class);
        } else return null;

    }

}
