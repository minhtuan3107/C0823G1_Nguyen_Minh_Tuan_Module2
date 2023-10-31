package ss17_binaryfile.repositories.impl;

import ss17_binaryfile.models.Spend;
import ss17_binaryfile.repositories.ISpendRepository;
import ss17_binaryfile.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpendRepository implements ISpendRepository {
    private final String FILE = "D:\\module2Again\\src\\ss17_binaryfile\\utils\\data.csv";


    @Override
    public void add(Spend spend) {
        List<Spend> spends = getList();
        spends.add(spend);
        ReadAndWrite.write(spends, FILE);
    }

    @Override
    public List<Spend> getList() {
        List<Spend> spends = ReadAndWrite.read(FILE);
        return spends;
    }

    @Override
    public void remove(int id) {
        List<Spend> spends = getList();
        for (Spend spend : spends) {
            if (spend.getId() == id) {
                spends.remove(spend);
                break;
            }
        }
        ReadAndWrite.write(spends, FILE);
    }

    @Override
    public void edit(int id, Spend spend) {
        List<Spend> spends = getList();
        for (Spend spend1 : spends) {
            if (spend.getId() == id) {
                spend1.setName(spend.getName());
                spend1.setDate(spend.getDate());
                spend1.setPrice(spend.getPrice());
                spend1.setDes(spend.getDes());
                break;
            }
        }
        ReadAndWrite.write(spends, FILE);
    }

    @Override
    public List<Spend> searchId(int id) {
        List<Spend> spends = getList();
        List<Spend> spendList = new ArrayList<>();
        for (Spend spend : spends) {
            if (spend.getId() == id) {
                spendList.add(spend);
            }
        }
        return spendList;
    }

    @Override
    public List<Spend> searchName(String name) {
        List<Spend> spends = getList();
        List<Spend> spendList = new ArrayList<>();
        for (Spend spend : spends) {
            if (spend.getName().contains(name)) {
                spendList.add(spend);
            }
        }
        return spendList;
    }

    @Override
    public void sortName() {
        List<Spend> spends = getList();
        spends.sort(new Comparator<Spend>() {
            @Override
            public int compare(Spend o1, Spend o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    @Override
    public void sortPrice() {
        List<Spend> spends = getList();
        spends.sort(new Comparator<Spend>() {
            @Override
            public int compare(Spend o1, Spend o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }
}
