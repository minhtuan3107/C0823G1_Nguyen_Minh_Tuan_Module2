package ss16_io_text_file.repositories.impl;

import ss16_io_text_file.models.Spend;
import ss16_io_text_file.repositories.ISpendRepository;
import ss16_io_text_file.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpendRepository implements ISpendRepository {
    private final String FILE = "D:\\module2Again\\src\\ss16_io_text_file\\utils\\data.txt";
    private final String COMMA = ",";

    @Override
    public void add(Spend spend) {
        List<Spend> spendList = new ArrayList<>();
        spendList.add(spend);
        ReadAndWrite.write(convertToString(spendList), FILE, true);
    }

    @Override
    public List<Spend> getList() {
        List<String> strings = ReadAndWrite.read(FILE);
        List<Spend> spendList = convertToObj(strings);
        return spendList;
    }

    @Override
    public void remove(int id) {
        List<Spend> spendList = getList();
        for (Spend spend : spendList) {
            if (spend.getId() == id) {
                spendList.remove(spend);
                break;
            }
        }
        ReadAndWrite.write(convertToString(spendList), FILE, false);
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
                ReadAndWrite.write(convertToString(spendList), FILE, false);
            }
        }

    }

    @Override
    public List<Spend> searchId(int id) {
        List<Spend> spendList = getList();
        List<Spend> spends = new ArrayList<>();
        for (Spend spend : spendList) {
            if (spend.getId() == id) {
                spends.add(spend);
            }
        }
        return spends;
    }

    @Override
    public List<Spend> searchName(String name) {
        List<Spend> spendList = getList();
        List<Spend> spends = new ArrayList<>();
        for (Spend spend : spendList) {
            if (spend.getName().contains(name)) {
                spends.add(spend);
            }
        }
        return spends;
    }

    @Override
    public void sortName() {
        List<String> strings = ReadAndWrite.read(FILE);
        List<Spend> spendList = convertToObj(strings);
        spendList.sort(new Comparator<Spend>() {
            @Override
            public int compare(Spend o1, Spend o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
    }

    @Override
    public void sortPrice() {
        List<String> strings = ReadAndWrite.read(FILE);
        List<Spend> spendList = convertToObj(strings);
        spendList.sort(new Comparator<Spend>() {
            @Override
            public int compare(Spend o1, Spend o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    public List<String> convertToString(List<Spend> spendList) {
        List<String> stringList = new ArrayList<>();
        for (Spend spend : spendList) {
            stringList.add(spend.getId() + COMMA + spend.getName() + COMMA + spend.getDate() + COMMA + spend.getPrice() + COMMA + spend.getDes());
        }
        return stringList;
    }

    public List<Spend> convertToObj(List<String> strings) {
        List<Spend> spendList = new ArrayList<>();
        String[] arr;
        for (String str : strings) {
            arr = str.split(",");
            spendList.add(new Spend(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3]), arr[4]));
        }
        return spendList;
    }
}
