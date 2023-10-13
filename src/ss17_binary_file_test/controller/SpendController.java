package ss17_binary_file_test.controller;

import ss17_binary_file_test.model.Spend;
import ss17_binary_file_test.service.ISpendService;
import ss17_binary_file_test.service.SpendService;

import java.util.List;

public class SpendController implements ISpendController {
    private final ISpendService spendService = new SpendService();

    @Override
    public void add(Spend spend) {
        spendService.add(spend);
    }

    @Override
    public List<Spend> getList() {
        return spendService.getList();
    }

    @Override
    public void remove(int id) {
        spendService.remove(id);
    }

    @Override
    public void edit(int id, Spend spend) {
        spendService.edit(id, spend);
    }

    @Override
    public void searchId(int id) {
        spendService.searchId(id);
    }

    @Override
    public void searchName(String name) {
        spendService.searchName(name);
    }

    public void sortName() {
        spendService.sortName();
    }

    public void sortPrice() {
        spendService.sortPrice();
    }
}
