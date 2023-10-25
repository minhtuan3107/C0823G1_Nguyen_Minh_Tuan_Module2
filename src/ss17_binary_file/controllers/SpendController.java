package ss17_binary_file.controllers;

import ss17_binary_file.models.Spend;
import ss17_binary_file.services.ISpendService;
import ss17_binary_file.services.impl.SpendService;

import java.util.List;

public class SpendController {
    private final ISpendService spendService = new SpendService();

    public void add(Spend spend) {
        spendService.add(spend);
    }

    public List<Spend> getList() {
        return spendService.getList();
    }

    public void remove(int id) {
        spendService.remove(id);
    }

    public void edit(int id, Spend spend) {
        spendService.edit(id, spend);
    }

    public void searchId(int id) {
        spendService.searchId(id);
    }

    public void searchName(String name) {
        spendService.searchName(name);
    }

}
