package ss10_list.service;

import ss10_list.model.Fruit;
import ss10_list.repository.FruitRepo;
import ss10_list.repository.IFruitRepo;

import java.util.List;

public class FruitService implements IFruitService {
   private IFruitRepo fruitRepo = new FruitRepo();

    @Override
    public List<Fruit> getList() {
        return fruitRepo.getList();
    }

    @Override
    public void add(Fruit fruit) {
        fruitRepo.add(fruit);
    }
    public void delete(String name) {
        fruitRepo.delete(name);
    }
}
