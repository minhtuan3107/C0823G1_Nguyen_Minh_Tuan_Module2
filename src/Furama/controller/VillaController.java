package Furama.controller;

import Furama.model.Villa;
import Furama.service.IVillaService;
import Furama.service.impl.VillaService;

public class VillaController {
    private final IVillaService villaService = new VillaService();

    public void add(Villa villa) {
        villaService.add(villa);
    }
}
