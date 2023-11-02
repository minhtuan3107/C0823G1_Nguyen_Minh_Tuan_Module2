package case_studyTest.controller;

import case_studyTest.model.facility.Facility;
import case_studyTest.service.IFacilityService;
import case_studyTest.service.impl.FacilityServiceImpl;

import java.util.List;

public class FacilityController {
    private final IFacilityService facilityService = new FacilityServiceImpl();

    public List<Facility> displayListMaintenance() {
        return facilityService.displayListMaintenance();
    }

    public void add(Facility facility) {
        facilityService.add(facility);
    }

    public void delete(String id) {
        facilityService.delete(id);
    }

    public List<Facility> display() {
        return facilityService.display();
    }
}
