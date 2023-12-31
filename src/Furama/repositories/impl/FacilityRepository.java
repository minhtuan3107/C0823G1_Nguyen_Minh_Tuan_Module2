package Furama.repositories.impl;

import Furama.models.facility.Facility;
import Furama.models.facility.House;
import Furama.models.facility.Room;
import Furama.models.facility.Villa;
import Furama.repositories.IFacilityRepository;
import Furama.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private int count;
    private final String FILE = "D:\\Module2.1\\src\\Furama\\utils\\DataFacility.csv";
    private final String COMMA = ",";

    public int getCount() {
        Map<Facility, Integer> facilityIntegerMap = getList();
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            count = map.getValue();
        }
        return count + 1;
    }

    @Override
    public void add(Facility facility) {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        facilityMap.put(facility, 0);
        ReadAndWrite.write(covertToString(facilityMap), FILE, true);
    }

    public void edit(String id, Facility facility) {
        Map<Facility, Integer> facilityIntegerMap = getList();
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : facilityIntegerMap.entrySet()) {
            if (facilityIntegerEntry.getKey().getId().equals(id)) {
                facilityIntegerEntry.setValue(facilityIntegerEntry.getValue() + 1);
            }
        }
        ReadAndWrite.write(covertToString(facilityIntegerMap), FILE, false);
    }

    @Override
    public void delete(String id) {
        Map<Facility, Integer> facilityIntegerMap = getList();
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
            if (id.equals(map.getKey().getId())) {
                facilityIntegerMap.remove(map);
                ReadAndWrite.write(covertToString(facilityIntegerMap), FILE, false);
                break;
            }
        }
    }

    @Override
    public Map<Facility, Integer> getList() {
        List<String> stringList = ReadAndWrite.read(FILE);
        Map<Facility, Integer> facilityIntegerMap = convertToE(stringList);
        return facilityIntegerMap;
    }

    @Override
    public Map<Facility, Integer> displayListMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = getList();
        Map<Facility, Integer> integerMap = new LinkedHashMap<>();
        for (Map.Entry<Facility, Integer> map : facilityIntegerMap.entrySet()) {
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
                        ((House) facility).getFloor() + COMMA + id);
            } else if (facility instanceof Villa) {
                strings.add(facility.getId() + COMMA +
                        facility.getName() + COMMA +
                        facility.getAcreage() + COMMA +
                        facility.getPrice() + COMMA +
                        facility.getPeople() + COMMA +
                        facility.getType() + COMMA +
                        ((Villa) facility).getStandard() + COMMA +
                        ((Villa) facility).getAreaPool() + COMMA +
                        ((Villa) facility).getFloor() + COMMA +
                        id);
            } else {
                strings.add(facility.getId() + COMMA +
                        facility.getName() + COMMA +
                        facility.getAcreage() + COMMA +
                        facility.getPrice() + COMMA +
                        facility.getPeople() + COMMA +
                        facility.getType() + COMMA +
                        ((Room) facility).getServiceFree() + COMMA +
                        id);
            }
        });
        return strings;
    }

    public Map<Facility, Integer> convertToE(List<String> strings) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        String[] data;
        String[] data1;
        for (String str : strings) {
            data = str.split(COMMA);
            data1 = data[0].split("-");
            if (data1[0].equals("SVVL")) {
                facilityIntegerMap.put(new Villa(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8])), Integer.parseInt(data[9]));
            } else if (data1[0].equals("SVHO")) {
                facilityIntegerMap.put(new House(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6], Integer.parseInt(data[7])), Integer.parseInt(data[8]));
            } else {
                facilityIntegerMap.put(new Room(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6]), Integer.parseInt(data[7]));
            }
        }
        return facilityIntegerMap;
    }
}
