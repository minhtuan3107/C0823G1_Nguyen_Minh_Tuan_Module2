package ss04_class_object.repository;

import ss04_class_object.model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface IDoctorRepo {
    void add(Doctor doctor);
    List<Doctor> getList();
}
