package Furama.repository.impl;

import Furama.model.Facility;
import Furama.model.House;
import Furama.model.Room;
import Furama.model.Villa;
import Furama.repository.IFacilityRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private int count;
    private final String FILE = "D:\\module2Again\\src\\Furama\\utils\\DataFacility.txt";

    static {
        facilityMap.put(new Villa("SVVL-1000", "Vip", 10, 100, 3, "month", "3 sao", 1000, 10), 2);
        facilityMap.put(new House("SVHO-0000", "Normal", 10, 1000, 3, "month", "normal", 2), 3);
        facilityMap.put(new Room("SVRO-0002", "Luxury", 15, 1500, 2, "day", "free"), 0);
    }

    @Override
    public void add(Facility facility) {
        count++;
        facilityMap.put(facility, count);
    }

    @Override
    public void delete(String id) {
        for (Map.Entry<Facility, Integer> map : facilityMap.entrySet()) {
            if (id.equals(map.getKey().getId())) {
                facilityMap.remove(map.getKey());
                break;
            }
        }
    }

    @Override
    public Map<Facility, Integer> getList() {
        return facilityMap;
    }

    @Override
    public Map<Facility, Integer> displayListMaintenance() {
        Map<Facility, Integer> integerMap = new LinkedHashMap<>();
        for (Map.Entry<Facility, Integer> map : facilityMap.entrySet()) {
            if (map.getValue() >= 5) {
                integerMap.put(map.getKey(), map.getValue());
            }
        }
        return integerMap;
    }

}
