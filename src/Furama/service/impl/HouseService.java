package Furama.service.impl;

import Furama.model.House;
import Furama.repository.IHouseRepo;
import Furama.repository.impl.HouseRepo;
import Furama.service.IHouseService;

public class HouseService implements IHouseService {
    private final IHouseRepo houseRepo = new HouseRepo();

    @Override
    public void add(House house) {
        houseRepo.add(house);
    }
}
