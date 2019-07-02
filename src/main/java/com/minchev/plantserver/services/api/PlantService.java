package com.minchev.plantserver.services.api;


import com.minchev.plantserver.models.PlantListViewModel;

import java.util.List;

public interface PlantService {

    List<PlantListViewModel> findAllPlants();


}
