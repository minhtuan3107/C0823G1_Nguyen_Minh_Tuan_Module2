package ss04_class_object.service;

import ss04_class_object.model.Doctor;

import java.util.List;

public interface IDoctorService {
    void add(Doctor doctor);
    List<Doctor> getList();
}
