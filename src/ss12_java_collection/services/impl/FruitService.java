package ss12_java_collection.services.impl;

import ss12_java_collection.models.Fruit;
import ss12_java_collection.repositories.impl.FruitRepository;
import ss12_java_collection.repositories.IFruitRepository;
import ss12_java_collection.services.IFruitService;

import java.util.Map;

public class FruitService implements IFruitService {
    private final IFruitRepository fruitRepo = new FruitRepository();

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
