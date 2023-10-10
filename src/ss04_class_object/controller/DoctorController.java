package ss04_class_object.controller;

import ss04_class_object.service.DoctorService;
import ss04_class_object.view.DoctorView;

import java.util.Scanner;

public class DoctorController {
    Scanner scanner = new Scanner(System.in);
    DoctorView doctorView = new DoctorView();
    DoctorService doctorService = new DoctorService();
    public void displayMenu(){
        do{
            try{
                doctorView.showMenu();
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        doctorService.add(doctorView.add());
                        break;
                    case 2:
                       doctorView.display();
                       break;
                }
            }catch (NumberFormatException e){
                System.out.println("Vui lòng nhập số");
            }
        }while (true);
    }
}
