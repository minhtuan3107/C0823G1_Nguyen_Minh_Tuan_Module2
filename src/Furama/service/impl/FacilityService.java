package Furama.service.impl;

import Furama.model.Facility;
import Furama.repository.IFacilityRepository;
import Furama.repository.impl.FacilityRepository;
import Furama.service.IFacilityService;

import java.util.Map;

public class FacilityService implements IFacilityService {
    private final IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void add(Facility facility) {
        facilityRepository.add(facility);
    }

    @Override
    public void delete(String id) {
        facilityRepository.delete(id);
    }

    @Override
    public Map<Facility, Integer> getList() {
        return facilityRepository.getList();
    }

    @Override
    public Map<Facility, Integer> displayListMaintenance() {
        return facilityRepository.displayListMaintenance();
    }
}
