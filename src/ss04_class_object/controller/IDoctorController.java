package ss04_class_object.controller;

import ss04_class_object.model.Doctor;

import java.util.List;

public interface IDoctorController {
    void add(Doctor doctor);

    List<Doctor> getList();
}
