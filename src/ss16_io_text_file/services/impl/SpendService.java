package ss16_io_text_file.services.impl;

import ss16_io_text_file.models.Spend;
import ss16_io_text_file.repositories.ISpendRepository;
import ss16_io_text_file.repositories.impl.SpendRepository;
import ss16_io_text_file.services.ISpendService;

import java.util.List;

public class SpendService implements ISpendService {
    private final ISpendRepository spendRepo = new SpendRepository();

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