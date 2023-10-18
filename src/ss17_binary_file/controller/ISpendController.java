package ss17_binary_file.controller;

import ss17_binary_file.model.Spend;

import java.util.List;

public interface ISpendController {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    void searchId(int id);

    void searchName(String name);

    void sortName();

    void sortPrice();
}
