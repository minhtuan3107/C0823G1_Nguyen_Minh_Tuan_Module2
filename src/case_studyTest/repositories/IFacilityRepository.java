package case_studyTest.repositories;

import case_studyTest.model.facility.Facility;

import java.util.List;

public interface IFacilityRepository extends IFuramaRepository<Facility>{
    List<Facility> displayListMaintenance();
}
