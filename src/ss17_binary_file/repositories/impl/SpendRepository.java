package ss17_binary_file.repositories.impl;

import ss17_binary_file.models.Spend;
import ss17_binary_file.repositories.ISpendRepository;
import ss17_binary_file.utils.ReadAndWrite;

import java.util.List;

public class SpendRepository implements ISpendRepository {
    private final String FILE = "D:\\module2Again\\src\\ss17_binary_file\\utils\\data.txt";

    @Override
    public void add(Spend spend) {
        List<Spend> spendList = getList();
        spendList.add(spend);
        ReadAndWrite.write(FILE, spendList);
    }

    @Override
    public List<Spend> getList() {
        List<Spend> spendList = ReadAndWrite.read(FILE);
        return spendList;
    }

    @Override
    public void remove(int id) {
        List<Spend> spendList = getList();
        for (Spend spend : spendList) {
            if (spend.getId() == id) {
                spendList.remove(id);
                break;
            }
        }
        ReadAndWrite.write(FILE, spendList);
    }

    @Override
    public void edit(int id, Spend spend) {
        List<Spend> spendList = getList();
        for (int i = 0; i < spendList.size(); i++) {
            if (spendList.get(i).getId() == id) {
                spendList.get(i).setName(spend.getName());
                spendList.get(i).setDate(spend.getDate());
                spendList.get(i).setPrice(spend.getPrice());
                spendList.get(i).setDes(spend.getDes());
            }
        }
        ReadAndWrite.write(FILE, spendList);
    }

    @Override
    public void searchId(int id) {
        List<Spend> spendList = getList();
        for (Spend spend : spendList) {
            if (spend.getId() == id) {
                System.out.println(spend);
            }
        }
    }

    @Override
    public void searchName(String name) {
        List<Spend> spendList = getList();
        for (Spend spend : spendList) {
            if (spend.getName().contains(name)) {
                System.out.println(spend);
            }
        }
    }
}
