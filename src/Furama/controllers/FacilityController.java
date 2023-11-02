package Furama.controllers;

import Furama.models.Facility;
import Furama.services.IFacilityService;
import Furama.services.impl.FacilityService;

import java.util.Map;

public class FacilityController {
    private final IFacilityService facilityService = new FacilityService();

    public void add(Facility facility) {
        facilityService.add(facility);
    }

    public void delete(String id) {
        facilityService.delete(id);
    }

    public Map<Facility, Integer> getList() {
        return facilityService.getList();
    }

    public Map<Facility, Integer> displayListMaintenance() {
        return facilityService.displayListMaintenance();
    }
}
