package ss13_search.service;

import ss13_search.model.Spend;

import java.util.List;

public interface ISpendService<E> {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    void searchId(int id);

    void searchName(String name);

}
