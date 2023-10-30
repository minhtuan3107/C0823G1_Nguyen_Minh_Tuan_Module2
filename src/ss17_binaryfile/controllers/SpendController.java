package ss17_binaryfile.controllers;

import ss17_binaryfile.models.Spend;
import ss17_binaryfile.services.ISpendService;
import ss17_binaryfile.services.impl.SpendService;

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

    public List<Spend> searchId(int id) {
        return spendService.searchId(id);
    }

    public List<Spend> searchName(String name) {
        return spendService.searchName(name);
    }

    public void sortName() {
        spendService.sortName();
    }

    public void sortPrice() {
        spendService.sortPrice();
    }
}
