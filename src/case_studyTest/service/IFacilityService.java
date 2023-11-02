package case_studyTest.service;

import case_studyTest.model.facility.Facility;

import java.util.List;

public interface IFacilityService extends IFuramaService<Facility> {
    List<Facility> displayListMaintenance();

}
