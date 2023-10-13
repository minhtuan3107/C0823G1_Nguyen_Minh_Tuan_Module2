package ss12_javacollection_framework.controller;

import ss12_javacollection_framework.model.Fruit;
import ss12_javacollection_framework.service.FruitService;
import ss12_javacollection_framework.service.IFruitService;

import java.util.HashMap;

public class FruitController implements IFruitController {
    private final IFruitService fruitService = new FruitService();

    @Override
    public void remove(Integer price) {
        fruitService.remove(price);
    }

    @Override
    public void edit(Integer name, Fruit fruit) {
        fruitService.edit(name, fruit);
    }

    @Override
    public HashMap<Integer, Fruit> getList() {
        return fruitService.getList();
    }

    @Override
    public void add(Fruit fruit) {
        fruitService.add(fruit);
    }
}
