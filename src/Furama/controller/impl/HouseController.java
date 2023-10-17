package Furama.controller.impl;

import Furama.controller.IHouseController;
import Furama.model.House;
import Furama.service.IHouseService;
import Furama.service.impl.HouseService;

public class HouseController implements IHouseController {
    private IHouseService houseService = new HouseService();

    @Override
    public void add(House house) {
        houseService.add(house);
    }
}
