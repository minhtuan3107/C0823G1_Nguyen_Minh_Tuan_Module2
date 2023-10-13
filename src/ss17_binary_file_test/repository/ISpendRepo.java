package ss17_binary_file_test.repository;

import ss17_binary_file_test.model.Spend;

import java.util.List;

public interface ISpendRepo {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    void searchId(int id);

    void searchName(String name);

    void sortName();

    void sortPrice();
}