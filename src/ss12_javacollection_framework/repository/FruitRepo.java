package ss12_javacollection_framework.repository;

import ss12_javacollection_framework.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitRepo implements IFruitRepo {
    private final Map<Integer, Fruit> fruitMap = new HashMap<>();
    private int count;

    @Override
    public void remove(Integer price) {
        for (Map.Entry<Integer, Fruit> value : fruitMap.entrySet()) {
            if (price.equals(value.getValue().getNameFruit())) {
                fruitMap.remove(value.getKey());
                break;
            }
        }
    }

    @Override
    public void edit(Integer price, Fruit fruit) {
        for (Map.Entry<Integer, Fruit> value : fruitMap.entrySet()){
            if (price.equals(value.getValue().getNameFruit())) {
                fruitMap.put(price,fruit);
                break;
            }
        }
    }

    @Override
    public HashMap<Integer, Fruit> getList() {
        return (HashMap<Integer, Fruit>) fruitMap;
    }

    @Override
    public void add(Fruit fruit) {
        count++;
        fruitMap.put(count, fruit);
    }
}
