package ss12_java_collection.repository;

import ss12_java_collection.model.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitRepo implements IFruitRepo {
    private final Map<Integer, Fruit> fruitMap = new HashMap<>();
    private int count;

    @Override
    public Map<Integer, Fruit> getList() {
        return fruitMap;
    }

    @Override
    public void add(Fruit fruit) {
        count++;
        fruitMap.put(count, fruit);
    }

    @Override
    public void remove(Integer id) {
        for (Map.Entry<Integer, Fruit> fruitMap1 : fruitMap.entrySet()) {
            if (id.equals(fruitMap1.getValue().getIdFruit())) {
                fruitMap.remove(fruitMap1.getKey());
                break;
            }
        }
    }

    @Override
    public void edit(Integer id, Fruit fruit) {
        for (Map.Entry<Integer, Fruit> fruitEntry : fruitMap.entrySet()) {
            if (id.equals(fruitEntry.getValue().getIdFruit())) {
                fruitMap.put(id, fruit);
            }
        }
    }

}
