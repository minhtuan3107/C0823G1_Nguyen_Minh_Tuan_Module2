package Furama.controller.impl;

import Furama.model.House;
import Furama.service.IHouseService;
import Furama.service.impl.HouseService;

public class HouseController {
    private IHouseService houseService = new HouseService();

    public void add(House house) {
        houseService.add(house);
    }
}
