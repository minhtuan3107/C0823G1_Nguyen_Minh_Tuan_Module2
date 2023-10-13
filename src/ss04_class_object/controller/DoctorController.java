package ss04_class_object.controller;

import ss04_class_object.model.Doctor;
import ss04_class_object.service.DoctorService;
import ss04_class_object.service.IDoctorService;

import java.util.List;

public class DoctorController implements IDoctorController {
    private IDoctorService doctorService = new DoctorService();

    @Override
    public void add(Doctor doctor) {
        doctorService.add(doctor);
    }

    @Override
    public List<Doctor> getList() {
        return doctorService.getList();
    }
}
