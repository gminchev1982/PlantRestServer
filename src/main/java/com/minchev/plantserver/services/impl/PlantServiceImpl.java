package com.minchev.plantserver.services.impl;


import com.minchev.plantserver.database.repository.PlantRepository;
import com.minchev.plantserver.models.PlantListViewModel;
import com.minchev.plantserver.services.api.PlantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository,
                            ModelMapper modelMapper) {
        this.plantRepository = plantRepository;

        this.modelMapper = modelMapper;

    }

       @Override
    public List<PlantListViewModel> findAllPlants() {

            return this.plantRepository.findAll()
                    .stream()
                    .map(u -> this.modelMapper.map(u, PlantListViewModel.class))
                    .collect(Collectors.toList());
    }




}
