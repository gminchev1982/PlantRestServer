package com.minchev.plantserver.controllers;


import com.minchev.plantserver.models.PlantListViewModel;
import com.minchev.plantserver.services.api.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class HomeApi {

   @Autowired
   PlantService plantService;



    @GetMapping(value="/all", produces = "application/json")
    public List<PlantListViewModel> allPlant() {

        return plantService.findAllPlants();


    }
/*
    public  ArrayList<String> allPlant() {

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Seat");
        cars.add("BMV");
        return  cars;
    }
*/

}
