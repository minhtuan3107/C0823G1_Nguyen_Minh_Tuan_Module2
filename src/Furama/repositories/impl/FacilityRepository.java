package Furama.repositories.impl;

import Furama.models.Facility;
import Furama.models.House;
import Furama.models.Room;
import Furama.models.Villa;
import Furama.repositories.IFacilityRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private int count;
    private final String FILE = "D:\\module2Again\\src\\Furama\\utils\\DataFacility.csv";
    private final String COMMA = ",";

    static {
        facilityMap.put(new Villa("SVVL-1000", "Vip", 10, 100, 3, "month", "3 sao", 1000, 10), 2);
        facilityMap.put(new House("SVHO-0000", "Normal", 10, 1000, 3, "month", "normal", 2), 3);
        facilityMap.put(new Room("SVRO-0002", "Luxury", 15, 1500, 2, "day", "free"), 0);
    }

    @Override
    public void add(Facility facility) {
        count++;
        facilityMap.put(facility, count);
        ReadAndWrite.write(covertToString(facilityMap), FILE, true);
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

    public List<String> covertToString(Map<Facility, Integer> e) {
        List<String> strings = new ArrayList<>();
        e.forEach((Facility facility, Integer id) -> {
            if (facility instanceof House) {
                strings.add(facility.getId() + COMMA +
                        facility.getName() + COMMA +
                        facility.getAcreage() + COMMA +
                        facility.getPrice() + COMMA +
                        facility.getPeople() + COMMA +
                        facility.getType() + COMMA +
                        ((House) facility).getStandard() + COMMA +
                        ((House) facility).getFloor());
            } else if (facility instanceof Villa) {
                strings.add(facility.getId() + COMMA +
                        facility.getName() + COMMA +
                        facility.getAcreage() + COMMA +
                        facility.getPrice() + COMMA +
                        facility.getPeople() + COMMA +
                        facility.getType() + COMMA +
                        ((Villa) facility).getStandard() + COMMA +
                        ((Villa) facility).getAreaPool() + COMMA +
                        ((Villa) facility).getFloor());
            } else {
                strings.add(facility.getId() + COMMA +
                        facility.getName() + COMMA +
                        facility.getAcreage() + COMMA +
                        facility.getPrice() + COMMA +
                        facility.getPeople() + COMMA +
                        facility.getType() + COMMA +
                        ((Room) facility).getServiceFree());
            }
        });
        return strings;
    }

    public Map<String, House> convertToE(List<String> strings) {
        Map<String, House> houses = new LinkedHashMap<>();
        for (String str : strings) {
            if (str.isEmpty()) {
                continue;
            }
            String[] data = str.split(COMMA);
            if (data.length < 8) {
                continue;
            }
            houses.put(data[0], new House(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6], Integer.parseInt(data[7])));

        }
        return houses;
    }
}
