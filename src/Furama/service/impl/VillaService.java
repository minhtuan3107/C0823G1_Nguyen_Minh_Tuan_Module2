package Furama.service.impl;

import Furama.model.Facility;
import Furama.model.Villa;
import Furama.repository.IVillaRepo;
import Furama.repository.impl.VillaRepo;
import Furama.service.IVillaService;

import java.util.LinkedHashMap;

public class VillaService implements IVillaService {
    private IVillaRepo villaRepo = new VillaRepo();

    @Override
    public void add(Villa villa) {
        villaRepo.add(villa);
    }

    @Override
    public void delete(String id) {
        villaRepo.delete(id);
    }

    @Override
    public LinkedHashMap<Facility, Villa> getList() {
        return villaRepo.getList();
    }

    @Override
    public void edit(String id, Villa villa) {
        villaRepo.edit(id, villa);
    }
}
