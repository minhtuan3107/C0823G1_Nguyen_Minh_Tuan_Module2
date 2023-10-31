package Furama.controller;

import Furama.model.House;
import Furama.service.IHouseService;
import Furama.service.impl.HouseService;

public class HouseController {
    private final IHouseService houseService = new HouseService();

    public void add(House house) {
        houseService.add(house);
    }
}
