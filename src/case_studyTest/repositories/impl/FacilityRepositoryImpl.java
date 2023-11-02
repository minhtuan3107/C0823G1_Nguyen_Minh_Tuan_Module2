package case_studyTest.repositories.impl;

import case_studyTest.model.facility.Facility;
import case_studyTest.model.facility.House;
import case_studyTest.model.facility.Room;
import case_studyTest.model.facility.Villa;
import case_studyTest.repositories.IFacilityRepository;

import java.util.*;
import java.util.stream.Collectors;

public class FacilityRepositoryImpl implements IFacilityRepository {
    private static final Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
static {
    facilityMap.put(new Villa("SVVL-0001","Vip",20,2000,4,"day",20,"President",4),5);
    facilityMap.put(new House("SVHO-0000","Normal",10,1000,3,"month","normal",2),3);
    facilityMap.put(new Room("SVRO-0002","Luxury",15,1500,2,"day","free"),0);
}
    @Override
    public List<Facility> displayListMaintenance() {
        List<Facility> facilityList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() >= 5) {
                facilityList.add(entry.getKey());
            }
        }
        return facilityList;
    }

    @Override
    public void add(Facility facility) {
        facilityMap.put(facility, 0);
    }

    @Override
    public void delete(String id) {
        List<Facility> facilityList = display();
        for (Facility facility : facilityList) {
            if (facility.getServiceCode().equals(id)) {
                facilityList.remove(facility);
            }
        }
    }

    @Override
    public List<Facility> display() {
        return facilityMap.keySet().stream().collect(Collectors.toList());
    }
}
