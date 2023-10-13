package ss15_exception.repository;

import ss15_exception.Utils.ReadAndWrite;
import ss15_exception.model.Spend;

import java.util.ArrayList;
import java.util.List;

public class SpendRepo implements ISpendRepo {
    private final String FILE = "D:\\module2Again\\src\\ss15_exception\\Utils\\data";
    private final String COMMA = ",";

    @Override
    public void add(Spend spend) {
        List<Spend> spendList = new ArrayList<>();
        spendList.add(spend);
        ReadAndWrite.write(convertToString(spendList), FILE);
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
                spendList.remove(id);
                break;
            }
        }
        ReadAndWrite.write(convertToString(spendList), FILE);
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
                ReadAndWrite.write(convertToString(spendList), FILE);
            }
        }

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

    @Override
    public void sortName() {
        List<String> strings = ReadAndWrite.read(FILE);
        List<Spend> spendList = convertToObj(strings);
        spendList.sort((o1, o2) -> Integer.parseInt(o1.getName()) > Integer.parseInt(o2.getName()) ? 1 : -1);
        ReadAndWrite.write(convertToString(spendList), FILE);
    }

    @Override
    public void sortPrice() {
        List<String> strings = ReadAndWrite.read(FILE);
        List<Spend> spendList = convertToObj(strings);
        spendList.sort((o1, o2) -> o1.getPrice() > o2.getPrice() ? -1 : 1);
        ReadAndWrite.write(convertToString(spendList), FILE);
    }

    public List<String> convertToString(List<Spend> spendList) {
        List<String> stringList = new ArrayList<>();
        for (Spend spend : spendList) {
            stringList.add(spend.getId() + COMMA
                    + spend.getName() + COMMA
                    + spend.getDate() + COMMA
                    + spend.getPrice() + COMMA
                    + spend.getDes());
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
