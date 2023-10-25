package ss17_binary_file.services.impl;

import ss17_binary_file.models.Spend;
import ss17_binary_file.repositories.ISpendRepository;
import ss17_binary_file.repositories.impl.SpendRepository;
import ss17_binary_file.services.ISpendService;

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


}
