package ss14_sort.services.impl;

import ss14_sort.models.Spend;
import ss14_sort.repositories.ISpendRepository;
import ss14_sort.repositories.impl.SpendRepository;
import ss14_sort.services.ISpendService;

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
