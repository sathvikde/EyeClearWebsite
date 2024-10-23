package com.eye.clear.controller;

import com.eye.clear.model.Prescription;
import com.eye.clear.view.PrescriptionView;

public class PrescriptionController {
	private Prescription model;
	private PrescriptionView view;

	public PrescriptionController(Prescription model, PrescriptionView view) {
		this.model = model;
		this.view = view;
	}

	public void addPrescription() {
		Prescription prescription = view.getPrescriptionDetails();
		boolean result = prescription.addPrescription();
		view.displayResult(result);
	}

	public void addRemark() {
		String remark = view.getRemark();
		String type = view.getRemarkType();
		boolean result = model.addRemark(remark, type);
		view.displayResult(result);
	}
}
