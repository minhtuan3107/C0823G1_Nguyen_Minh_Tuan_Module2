package ss12_java_collection.controller;

import ss12_java_collection.model.Fruit;
import ss12_java_collection.service.FruitService;
import ss12_java_collection.service.IFruitService;

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
