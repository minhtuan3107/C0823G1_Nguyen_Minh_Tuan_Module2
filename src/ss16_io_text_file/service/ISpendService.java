package ss16_io_text_file.service;

import ss16_io_text_file.model.Spend;

import java.util.List;

public interface ISpendService<E> {
    void add(Spend spend);

    List<Spend> getList();

    void remove(int id);

    void edit(int id, Spend spend);

    void searchId(int id);

    void searchName(String name);

    void sortName();

    void sortPrice();
}
