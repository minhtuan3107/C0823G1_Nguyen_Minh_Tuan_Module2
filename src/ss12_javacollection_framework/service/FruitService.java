package ss12_javacollection_framework.service;

import ss12_javacollection_framework.model.Fruit;
import ss12_javacollection_framework.repository.FruitRepo;

import java.util.HashMap;

public class FruitService implements IFruitService {
    private final FruitRepo fruitRepo = new FruitRepo();

    @Override
    public void remove(Integer price) {
        fruitRepo.remove(price);
    }

    @Override
    public void edit(Integer price, Fruit fruit) {
        fruitRepo.edit(price, fruit);
    }

    @Override
    public HashMap<Integer, Fruit> getList() {
        return fruitRepo.getList();
    }

    @Override
    public void add(Fruit fruit) {
        fruitRepo.add(fruit);
    }
}
