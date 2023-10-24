package ss12_java_collection.service;

import ss12_java_collection.model.Fruit;
import ss12_java_collection.repository.FruitRepo;
import ss12_java_collection.repository.IFruitRepo;

import java.util.Map;

public class FruitService implements IFruitService {
    private final IFruitRepo fruitRepo = new FruitRepo();

    @Override
    public Map<Integer, Fruit> getList() {
        return fruitRepo.getList();
    }

    @Override
    public void add(Fruit fruit) {
        fruitRepo.add(fruit);
    }

    @Override
    public void remove(Integer id) {
        fruitRepo.remove(id);
    }

    @Override
    public void edit(Integer id, Fruit fruit) {
        fruitRepo.edit(id, fruit);
    }
}
