package ss16_io_text_file.service;

import ss16_io_text_file.model.Spend;
import ss16_io_text_file.repository.ISpendRepo;
import ss16_io_text_file.repository.SpendRepo;

import java.util.List;

public class SpendService implements ISpendService {
    private final ISpendRepo spendRepo = new SpendRepo();

    @Override
    public void add(Spend spend) {
        spendRepo.add(spend);
    }

    @Override
    public List<Spend> getList() {
        return spendRepo.getList();
    }

    @Override
    public void remove(int id) {
        spendRepo.remove(id);
    }

    @Override
    public void edit(int id, Spend spend) {
        spendRepo.edit(id, spend);
    }

    @Override
    public void searchId(int id) {
        spendRepo.searchId(id);
    }

    @Override
    public void searchName(String name) {
        spendRepo.searchName(name);
    }

    @Override
    public void sortName() {
        spendRepo.sortName();
    }

    @Override
    public void sortPrice() {
        spendRepo.sortPrice();
    }
}