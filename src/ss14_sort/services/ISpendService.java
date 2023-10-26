package ss14_sort.services;

import ss14_sort.models.Spend;

import java.util.List;

public interface ISpendService {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    List<Spend> searchId(int id);

    List<Spend> searchName(String name);

    void sortName();

    void sortPrice();
}
