package ss14_sort.repositories;

import ss14_sort.models.Spend;

import java.util.List;

public interface ISpendRepository {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    void searchId(int id);

    void searchName(String name);

    void sortName();

    void sortPrice();
}