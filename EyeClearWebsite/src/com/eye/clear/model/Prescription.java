package com.eye.clear.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
	private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private int axis;
    private Date examinationDate;
    private String optometrist;
    private ArrayList<String> remarks = new ArrayList<>();

    public boolean addPrescription() {
        if (isValidPrescription()) {
            try (FileWriter writer = new FileWriter("presc.txt", true)) {
                writer.write(this.toString() + "\n");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addRemark(String remark, String type) {
        if (isValidRemark(remark, type)) {
            try (FileWriter writer = new FileWriter("remark.txt", true)) {
                writer.write(remark + "\n");
                remarks.add(remark);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean isValidPrescription() {
        if (firstName == null || firstName.length() < 4 || firstName.length() > 15) return false;
        if (lastName == null || lastName.length() < 4 || lastName.length() > 15) return false;
        if (address == null || address.length() < 20) return false;
        if (sphere < -20.00 || sphere > 20.00) return false;
        if (cylinder < -4.00 || cylinder > 4.00) return false;
        if (axis < 0 || axis > 180) return false;
        if (optometrist == null || optometrist.length() < 8 || optometrist.length() > 25) return false;
        return true;
    }

    private boolean isValidRemark(String remark, String type) {
        if (remarks.size() >= 2) return false;
        if (remark == null) return false;
        String[] words = remark.split(" ");
        if (words.length < 6 || words.length > 20) return false;
        if (!Character.isUpperCase(words[0].charAt(0))) return false;
        if (!type.equalsIgnoreCase("client") && !type.equalsIgnoreCase("optometrist")) return false;
        return true;
    }

    @Override
    public String toString() {
        // Convert the prescription details to a string
        return "Prescription ID: " + prescID + ", First Name: " + firstName + ", Last Name: " + lastName + ", Address: " + address + 
               ", Sphere: " + sphere + ", Cylinder: " + cylinder + ", Axis: " + axis + 
               ", Examination Date: " + examinationDate + ", Optometrist: " + optometrist;
    }

    // Setters for all the fields
    public void setPrescID(int prescID) {
        this.prescID = prescID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSphere(float sphere) {
        this.sphere = sphere;
    }

    public void setCylinder(float cylinder) {
        this.cylinder = cylinder;
    }

    public void setAxis(int axis) {
        this.axis = axis;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public void setOptometrist(String optometrist) {
        this.optometrist = optometrist;
    }
}
