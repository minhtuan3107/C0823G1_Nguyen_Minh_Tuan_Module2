package Furama.repositories;

import Furama.models.Facility;

import java.util.Map;

public interface IFacilityRepository {
    void add(Facility facility);

    void delete(String id);

    Map<Facility, Integer> getList();

    Map<Facility, Integer> displayListMaintenance();

    void edit(String id, Facility facility);
}
