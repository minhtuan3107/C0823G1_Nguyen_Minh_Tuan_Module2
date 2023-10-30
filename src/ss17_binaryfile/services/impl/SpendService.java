package ss17_binaryfile.services.impl;

import ss17_binaryfile.models.Spend;
import ss17_binaryfile.repositories.ISpendRepository;
import ss17_binaryfile.repositories.impl.SpendRepository;
import ss17_binaryfile.services.ISpendService;

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
