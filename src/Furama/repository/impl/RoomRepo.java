package Furama.repository.impl;

import Furama.Utils.ReadAndWrite;
import Furama.model.Room;
import Furama.repository.IRoomRepo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoomRepo implements IRoomRepo {
    private final String COMA = ",";
    private final String FILE = "D:\\module2Again\\src\\Furama\\Utils\\DataRoom";
    @Override
    public void add(Room room) {
        Map<String, Room> roomList = convertToE(ReadAndWrite.read(FILE));
        roomList.put(room.getId(), room);
        ReadAndWrite.write(convertToString(roomList),FILE,true);
    }
    public List<String> convertToString(Map<String, Room> e) {
        List<String> strings = new ArrayList<>();
        e.forEach((String id, Room room) -> {
            strings.add(room.getId() + COMA+
                    room.getName() + COMA +
                    room.getAcreage() + COMA +
                    room.getPrice() + COMA+
                    room.getPeople() + COMA +
                    room.getType() + COMA +
                    room.getServiceFree());
        });
        return strings;
    }

    public Map<String, Room> convertToE(List<String> strings) {
        Map<String, Room> rooms = new LinkedHashMap<>();
        for (String str : strings) {
            if (str.isEmpty()) {
                continue;
            }
            String[] data = str.split(COMA);
            if (data.length < 7) {
                continue;
            }
            rooms.put(data[0], new Room(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6]));
        }
        return rooms;
    }
}

