package ss10_list.controller;

import ss10_list.model.Fruit;

import java.util.List;

public interface IFruitController {
    List<Fruit> getList();

    void add(Fruit fruit);

    void delete(String name);

    void edit(String name, Fruit fruit);

}
