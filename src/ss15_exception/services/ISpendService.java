package ss15_exception.services;

import ss15_exception.models.Spend;

import java.util.List;

public interface ISpendService {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    void searchId(int id);

    void searchName(String name);

    void sortName();

    void sortPrice();
}
