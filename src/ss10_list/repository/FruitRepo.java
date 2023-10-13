package ss10_list.repository;

import ss10_list.Utils.ReadAndWrite;
import ss10_list.model.Fruit;
import ss10_list.view.FruitView;

import java.util.ArrayList;
import java.util.List;

public class FruitRepo implements IFruitRepo {
    private final String COMMA = ",";
    private final String FILE = "D:\\module2Again\\src\\ss10_list\\Utils\\data.csv";

    @Override
    public List<Fruit> getList() {
        return convertToObj(ReadAndWrite.read(FILE));
    }

    public List<Fruit> convertToObj(List<String> stringList) {
        List<Fruit> fruitList = new ArrayList<>();
        for (String str : stringList) {
            String[] strList = str.split(COMMA);
            fruitList.add(new Fruit(strList[0], strList[1], strList[2], strList[3], strList[4], strList[5]));
        }
        return fruitList;
    }

    @Override
    public void add(Fruit fruit) {
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(fruit);
        ReadAndWrite.write(convertToString(fruitList), FILE);
    }

    @Override
    public void delete(String name) {
        List<Fruit> fruitList = convertToObj(ReadAndWrite.read(FILE));
        for (Fruit fruit : fruitList) {
            if (fruit.getNameFruit().equals(name)) {
                fruitList.remove(fruit);
                break;
            }
        }
        ReadAndWrite.write(convertToString(fruitList), FILE);
    }

    public List<String> convertToString(List<Fruit> fruitList) {
        List<String> stringList = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            stringList.add(fruit.getNameFruit() + COMMA
                    + fruit.getTypeFruit() + COMMA
                    + fruit.getDate() + COMMA
                    + fruit.getExpiry() + COMMA
                    + fruit.getOrigin() + COMMA
                    + fruit.getPrice());
        }
        return stringList;
    }
}
