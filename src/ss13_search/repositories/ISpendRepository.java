package ss13_search.repositories;

import ss13_search.models.Spend;

import java.util.List;

public interface ISpendRepository {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    List<Spend> searchId(int id);

    List<Spend> searchName(String name);

    void sortName();

    void sortPrice();
}
