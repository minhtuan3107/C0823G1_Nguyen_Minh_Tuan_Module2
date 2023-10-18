package Furama.controller.impl;

import Furama.controller.IVillaController;
import Furama.model.Villa;
import Furama.service.IVillaService;
import Furama.service.impl.VillaService;

public class VillaController implements IVillaController {
    private IVillaService villaService = new VillaService();

    @Override
    public void add(Villa villa) {
        villaService.add(villa);
    }
}
