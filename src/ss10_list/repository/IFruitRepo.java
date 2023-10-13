package ss10_list.repository;

import ss10_list.model.Fruit;

import java.util.List;

public interface IFruitRepo {
    List<Fruit>getList();
    void add(Fruit fruit);
    void delete(String name);
}
