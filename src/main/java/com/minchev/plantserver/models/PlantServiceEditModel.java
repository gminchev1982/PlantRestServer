package com.minchev.plantserver.models;

import lombok.Data;

@Data
public class PlantServiceEditModel extends BaseServiceModel {

    private String barcode;
    private boolean active;


}
