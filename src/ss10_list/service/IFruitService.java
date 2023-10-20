package ss10_list.service;

import ss10_list.model.Fruit;

import java.util.List;

public interface IFruitService {
    List<Fruit> getList();

    void delete(String name);

    void add(Fruit fruit);

    void edit(String name, Fruit fruit);

}
