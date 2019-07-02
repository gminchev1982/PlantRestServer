package com.minchev.plantserver.models;

import lombok.Data;

@Data
public class PlantServiceModel  extends BaseServiceModel {
    private String barcode;
    private String dateAt;
    private String active;


}
