package ss12_javacollection_framework.repository;

import ss12_javacollection_framework.model.Fruit;

import java.util.HashMap;

public interface IFruitRepo {
     void remove(Integer price);

     void edit(Integer price, Fruit fruit);

     HashMap<Integer, Fruit> getList();

     void add(Fruit fruit);
}
