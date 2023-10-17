package Furama.repository.impl;

import Furama.Utils.ReadAndWrite;
import Furama.model.House;
import Furama.repository.IHouseRepo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HouseRepo implements IHouseRepo {
    private final String COMA = ",";
    private final String FILE = "D:\\module2Again\\src\\Furama\\Utils\\Facility";

    @Override
    public void add(House house) {
        Map<String, House> houseList = convertToE(ReadAndWrite.read(FILE));
        houseList.put(house.getId(), house);
        ReadAndWrite.write(covertToString(houseList), FILE, true);
    }

    public List<String> covertToString(Map<String, House> e) {
        List<String> strings = new ArrayList<>();
        e.forEach((String id, House house) -> {
            strings.add(house.getId() + COMA +
                    house.getName() + COMA +
                    house.getAcreage() + COMA +
                    house.getPrice() + COMA +
                    house.getPeople() + COMA +
                    house.getType() + COMA +
                    house.getStandard() + COMA +
                    house.getFloor());
        });
        return strings;
    }

    public Map<String, House> convertToE(List<String> strings) {
        Map<String, House> houses = new LinkedHashMap<>();
        for (String str : strings) {
            if (str.isEmpty()) {
                continue;
            }
            String[] data = str.split(COMA);
            if (data.length < 8) {
                continue;
            }
            houses.put(data[0], new House(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6], Integer.parseInt(data[7])));

        }
        return houses;
    }
}
