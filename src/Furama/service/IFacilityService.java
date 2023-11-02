package Furama.service;

import Furama.model.Facility;

import java.util.Map;

public interface IFacilityService {
    void add(Facility facility);

    void delete(String id);

    Map<Facility, Integer> getList();

    Map<Facility, Integer> displayListMaintenance();
}
