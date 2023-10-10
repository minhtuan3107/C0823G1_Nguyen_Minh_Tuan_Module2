package ss04_class_object.service;

import ss04_class_object.model.Doctor;
import ss04_class_object.repository.DoctorRepo;

import javax.print.Doc;
import java.util.List;

public class DoctorService implements IDoctorService{
    DoctorRepo doctorRepo = new DoctorRepo();
    @Override
    public void add(Doctor doctor) {
        doctorRepo.add(doctor);
    }

    @Override
    public List<Doctor> getList() {
        return doctorRepo.getList();
    }
}
