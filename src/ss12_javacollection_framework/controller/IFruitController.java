package ss12_javacollection_framework.controller;

import ss12_javacollection_framework.model.Fruit;

import java.util.HashMap;

public interface IFruitController {
    public void remove(Integer price);

    public void edit(Integer price, Fruit fruit);

    public HashMap<Integer, Fruit> getList();

    public void add(Fruit fruit);
}
