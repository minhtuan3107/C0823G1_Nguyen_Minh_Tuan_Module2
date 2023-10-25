package ss12_java_collection.services;

import ss12_java_collection.models.Fruit;

import java.util.Map;

public interface IFruitService {
    Map<Integer, Fruit> getList();

    void add(Fruit fruit);

    void remove(Integer id);

    void edit(Integer id, Fruit fruit);
}
