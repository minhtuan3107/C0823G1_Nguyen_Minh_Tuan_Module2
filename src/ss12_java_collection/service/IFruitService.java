package ss12_java_collection.service;

import ss12_java_collection.model.Fruit;

import java.util.Map;

public interface IFruitService {
    Map<Integer, Fruit> getList();

    void add(Fruit fruit);

    void remove(Integer id);

    void edit(Integer id, Fruit fruit);
}
