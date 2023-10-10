package ss04_class_object.repository;

import ss04_class_object.Utils.ReadAndWrite;
import ss04_class_object.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepo implements IDoctorRepo {
    private final String FILE = "D:\\module2Again\\src\\ss04_class_object\\Utils\\data.csv";
    private final String COMA = ",";

    public List<String> convertToString(List<Doctor> doctorList) {
        List<String> stringList = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            stringList.add(doctor.getName() + COMA + doctor.getOld() + COMA + doctor.getLocation() + COMA + doctor.getEmail() + doctor.getPhone() + COMA + doctor.getWorkPosition());
        }
        return stringList;
    }

    @Override
    public void add(Doctor doctor) {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList.add(doctor);
        ReadAndWrite.write(convertToString(doctorList), FILE);
    }

    @Override
    public List<Doctor> getList() {
        List<Doctor> doctorList = new ArrayList<>();
        List<String> strings = ReadAndWrite.read(FILE);
        String[] strArr = null;
        for (String str : strings) {
            strArr = str.split("");
            doctorList.add(new Doctor(strArr[0], Integer.parseInt(strArr[1]), strArr[2], strArr[3], Integer.parseInt(strArr[4]), strArr[5]));
        }
        return doctorList;
    }
}
