package Furama.controller.impl;

import Furama.controller.IRoomController;
import Furama.model.Room;
import Furama.service.IRoomService;
import Furama.service.impl.RoomService;

public class RoomController implements IRoomController {
    private IRoomService roomService = new RoomService();

    @Override
    public void add(Room room) {
        roomService.add(room);
    }
}
