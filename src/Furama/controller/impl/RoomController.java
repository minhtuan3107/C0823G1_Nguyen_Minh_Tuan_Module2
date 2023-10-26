package Furama.controller.impl;

import Furama.model.Room;
import Furama.service.IRoomService;
import Furama.service.impl.RoomService;

public class RoomController {
    private IRoomService roomService = new RoomService();

    public void add(Room room) {
        roomService.add(room);
    }
}
