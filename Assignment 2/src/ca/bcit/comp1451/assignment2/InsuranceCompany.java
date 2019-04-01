/**
 * 
 */
package ca.bcit.comp1451.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Rain
 *
 */
public class InsuranceCompany {
	
	private static int NUM = 7;
	private static double LABOUR_PERCENT = 0.05;
	private static double LM_PERCENT = 0.07;
	private static double LME_PERCENT = 0.10;
	private String name;
	private ArrayList<ProjectInvoice> projectList;
	
	/**
	 * @param name
	 */
	public InsuranceCompany(String name) {
		setName(name);
		projectList = new ArrayList<ProjectInvoice>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name != null && name.length() > 0) {
		this.name = name;
		} else {
			this.name = "unknown";
		}
	}

	/**
	 * method to add a project invoice object to collection
	 */
	public void addProjectInvoice(ProjectInvoice obj) {
		if (obj != null) {
		projectList.add(obj);
		}
	}
	
	/**
	 * method to display project invoice based on invoice number
	 * @throws InvalidInvoiceNumberException 
	 */
	public void displayProjectInvoice(String invoiceNumber) throws InvalidInvoiceNumberException {
		Iterator<ProjectInvoice> it = projectList.iterator();

		if (invoiceNumber == null || invoiceNumber.length() < NUM) {
			throw new InvalidInvoiceNumberException("Invalid invoice number, "
					+ "invoice number cannot be null or less than 7 characters");
		}
		boolean invoiceFound = false;
		while (it.hasNext()) {
			ProjectInvoice invoiceInfo = it.next();
			if (invoiceNumber.equals(invoiceInfo.getInvoiceNumber())) {
				invoiceFound = true;
				System.out.println(invoiceInfo.toString());
			}
		}
		if (invoiceFound == false) {
			System.out.println("invoice was not found");
		}
	}

	/**
	 * method to calculate total insurance fees
	 */
	public double calculateTotalInsuranceFees() {
		double insuranceFees = 0.0;
		Iterator<ProjectInvoice> it = projectList.iterator();
		while (it.hasNext()) {
			ProjectInvoice invoiceInfo = it.next();
			if (invoiceInfo instanceof Labour) {
				Labour labourInfo = (Labour) invoiceInfo;
				insuranceFees = LABOUR_PERCENT * labourInfo.calculateTotalcost();
			} else if (invoiceInfo instanceof LabourAndMaterial) {
				LabourAndMaterial lmInfo = (LabourAndMaterial) invoiceInfo;
				insuranceFees = LM_PERCENT * lmInfo.calculateTotalcost();
			} else if (invoiceInfo instanceof LabourAndMaterialAndEquipment) {
				LabourAndMaterialAndEquipment lmeInfo = (LabourAndMaterialAndEquipment) invoiceInfo;
				insuranceFees = LME_PERCENT * lmeInfo.calculateTotalcost();
			}
			}
		return insuranceFees;
	}
	
	/**
	 * method to display only invoice number of all project invoices sorted by total cost
	 */
	public void displayAllProjectInvoices() {
		Collections.sort(projectList);
		
		for(ProjectInvoice p: projectList) {
			System.out.println(p.getInvoiceNumber());
		}
	}
}
