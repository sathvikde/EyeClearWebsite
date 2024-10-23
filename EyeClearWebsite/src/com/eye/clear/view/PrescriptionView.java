package com.eye.clear.view;

import java.util.Date;
import java.util.Scanner;

import com.eye.clear.model.Prescription;

public class PrescriptionView {
	 private Scanner scanner = new Scanner(System.in);

	    public Prescription getPrescriptionDetails() {
	        Prescription prescription = new Prescription();

	        System.out.println("Enter Prescription ID: ");
	        prescription.setPrescID(scanner.nextInt());
	        scanner.nextLine();  // Consume newline

	        System.out.println("Enter First Name (4-15 characters): ");
	        prescription.setFirstName(scanner.nextLine());

	        System.out.println("Enter Last Name (4-15 characters): ");
	        prescription.setLastName(scanner.nextLine());

	        System.out.println("Enter Address (minimum 20 characters): ");
	        prescription.setAddress(scanner.nextLine());

	        System.out.println("Enter Sphere (-20.00 to 20.00): ");
	        prescription.setSphere(scanner.nextFloat());

	        System.out.println("Enter Cylinder (-4.00 to 4.00): ");
	        prescription.setCylinder(scanner.nextFloat());

	        System.out.println("Enter Axis (0 to 180): ");
	        prescription.setAxis(scanner.nextInt());
	        scanner.nextLine();  // Consume newline

	        System.out.println("Enter Optometrist Name (8-25 characters): ");
	        prescription.setOptometrist(scanner.nextLine());

	        // Set the current date as the examination date
	        prescription.setExaminationDate(new Date());

	        return prescription;
	    }

	    public String getRemark() {
	        System.out.println("Enter Remark (6-20 words, first word must start with an uppercase letter): ");
	        return scanner.nextLine();
	    }

	    public String getRemarkType() {
	        System.out.println("Enter Remark Type (client/optometrist): ");
	        return scanner.nextLine();
	    }

	    public void displayResult(boolean result) {
	        if (result) {
	            System.out.println("Operation was successful.");
	        } else {
	            System.out.println("Operation failed. Please ensure all inputs are valid.");
	        }
	    }
}
