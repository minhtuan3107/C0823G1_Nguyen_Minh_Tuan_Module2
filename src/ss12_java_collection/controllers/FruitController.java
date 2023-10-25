package ss12_java_collection.controllers;

import ss12_java_collection.models.Fruit;
import ss12_java_collection.services.impl.FruitService;
import ss12_java_collection.services.IFruitService;

import java.util.Map;

public class FruitController implements IFruitController {
    private final IFruitService fruitService = new FruitService();

    @Override
    public Map<Integer, Fruit> getList() {
        return fruitService.getList();
    }

    @Override
    public void add(Fruit fruit) {
        fruitService.add(fruit);
    }

    @Override
    public void remove(Integer id) {
        fruitService.remove(id);
    }

    @Override
    public void edit(Integer id, Fruit fruit) {
        fruitService.edit(id, fruit);
    }
}
