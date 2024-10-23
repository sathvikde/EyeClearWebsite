package com.eye.clear;

import java.util.Scanner;

import com.eye.clear.controller.PrescriptionController;
import com.eye.clear.model.Prescription;
import com.eye.clear.view.PrescriptionView;

public class Main {
	public static void main(String[] args) {
        Prescription model = new Prescription();
        PrescriptionView view = new PrescriptionView();
        PrescriptionController controller = new PrescriptionController(model, view);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Prescription");
            System.out.println("2. Add Remark");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    controller.addPrescription();
                    break;
                case 2:
                    controller.addRemark();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
