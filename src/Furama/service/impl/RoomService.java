package Furama.service.impl;

import Furama.model.Room;
import Furama.repository.IRoomRepo;
import Furama.repository.impl.RoomRepo;
import Furama.service.IRoomService;

public class RoomService implements IRoomService {
    private final IRoomRepo roomRepo = new RoomRepo();

    @Override
    public void add(Room room) {
        roomRepo.add(room);
    }
}
