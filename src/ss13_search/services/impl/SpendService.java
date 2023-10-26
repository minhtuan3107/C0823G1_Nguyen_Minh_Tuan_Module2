package ss13_search.services.impl;

import ss13_search.models.Spend;
import ss13_search.repositories.ISpendRepository;
import ss13_search.repositories.impl.SpendRepository;
import ss13_search.services.ISpendService;

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
    public List<Spend> searchId(int id) {
        return spendRepo.searchId(id);
    }

    @Override
    public List<Spend> searchName(String name) {
        return spendRepo.searchName(name);
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
