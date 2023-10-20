package Furama.service.impl;

import Furama.model.Villa;
import Furama.repository.IVillaRepo;
import Furama.repository.impl.VillaRepo;
import Furama.service.IVillaService;

public class VillaService implements IVillaService {
    private final IVillaRepo villaRepo = new VillaRepo();

    @Override
    public void add(Villa villa) {
        villaRepo.add(villa);
    }

}
