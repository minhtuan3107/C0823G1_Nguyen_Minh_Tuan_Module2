package ss13_search.controller;

import ss13_search.model.Spend;
import ss13_search.service.ISpendService;
import ss13_search.service.SpendService;

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
}
