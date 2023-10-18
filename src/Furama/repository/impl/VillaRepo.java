package Furama.repository.impl;

import Furama.Utils.ReadAndWrite;
import Furama.model.Villa;
import Furama.repository.IVillaRepo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VillaRepo implements IVillaRepo {
    private final String COMA = ",";
    private final String FILE = "D:\\module2Again\\src\\Furama\\Utils\\DataVilla";
    private int count;

    @Override
    public void add(Villa villa) {
        Map<String, Villa> villaMap = convertToE(ReadAndWrite.read(FILE));
        villaMap.put(villa.getId(), villa);
        ReadAndWrite.write(convertToString(villaMap), FILE, true);
    }

    public List<String> convertToString(Map<String, Villa> e) {
        List<String> strings = new ArrayList<>();
        e.forEach((String id, Villa villa) -> {
            strings.add(villa.getId() + COMA +
                    villa.getName() + COMA +
                    villa.getAcreage() + COMA +
                    villa.getPrice() + COMA +
                    villa.getPeople() + COMA +
                    villa.getType() + COMA +
                    villa.getStandard() + COMA +
                    villa.getAreaPool() + COMA +
                    villa.getFloor());
        });
        return strings;
    }

    public Map<String, Villa> convertToE(List<String> strings) {
        Map<String, Villa> villas = new LinkedHashMap();
        for (String str : strings) {
            if (str.isEmpty()) {
                continue;
            }
            String[] data = str.split(COMA);
            if (data.length < 9) {
                continue;
            }
            villas.put(data[0], new Villa(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8])));
        }
        return villas;
    }
}
