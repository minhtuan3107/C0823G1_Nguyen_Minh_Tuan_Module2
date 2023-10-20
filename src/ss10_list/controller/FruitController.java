package ss10_list.controller;

import ss10_list.model.Fruit;
import ss10_list.service.FruitService;
import ss10_list.service.IFruitService;

import java.util.List;

public class FruitController implements IFruitController {
    private final IFruitService fruitService = new FruitService();

    @Override
    public List<Fruit> getList() {
        return fruitService.getList();
    }

    @Override
    public void add(Fruit fruit) {
        fruitService.add(fruit);
    }

    @Override
    public void delete(String name) {
        fruitService.delete(name);
    }

    @Override
    public void edit(String name, Fruit fruit) {
        fruitService.edit(name, fruit);
    }
}
