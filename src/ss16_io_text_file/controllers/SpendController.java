package ss16_io_text_file.controllers;

import ss16_io_text_file.models.Spend;
import ss16_io_text_file.services.ISpendService;
import ss16_io_text_file.services.impl.SpendService;

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
