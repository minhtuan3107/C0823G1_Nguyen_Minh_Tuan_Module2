package ss12_java_collection.controller;

import ss12_java_collection.model.Fruit;

import java.util.Map;

public interface IFruitController {
    Map<Integer, Fruit> getList();

    void add(Fruit fruit);

    void remove(Integer id);

    void edit(Integer id, Fruit fruit);
}
