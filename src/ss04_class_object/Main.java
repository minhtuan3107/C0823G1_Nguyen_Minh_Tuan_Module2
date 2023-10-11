package ss04_class_object;

import ss04_class_object.controller.DoctorController;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {
        DoctorController doctorController = new DoctorController();
        doctorController.displayMenu();
    }
}
