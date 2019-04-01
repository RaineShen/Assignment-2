/**
 * 
 */
package ca.bcit.comp1451.assignment2;

import java.util.Scanner;

/**
 * @author Rain
 *
 */
public class Driver {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InsuranceCompany insuranceObj = new InsuranceCompany("Sunlife");
		
		insuranceObj.addProjectInvoice(new Labour("First labour project", 230, 20, 150, 
				"regular", "experienced"));
		insuranceObj.addProjectInvoice(new Labour("Second labour project", 178, 16, 220, 
				"regular", "inexperienced"));

		insuranceObj.addProjectInvoice(new LabourAndMaterial("First labour and material project", 
				145, 23, 98, "overtime", "experienced", 231.5, 50.0, 65));
		insuranceObj.addProjectInvoice(new LabourAndMaterial("Second labour and material project", 
				214, 21, 145, "regular", "inexperienced", 327.3, 30.0, 70));
		
		insuranceObj.addProjectInvoice(new LabourAndMaterialAndEquipment("First labour and material "
				+ "and equipment project", 100, 24, 124, "holiday",
				"experienced", 96.5, 24.0, 50, 156.8, 20));
		insuranceObj.addProjectInvoice(new LabourAndMaterialAndEquipment("Second labour and material "
				+ "and equipment project", 210, 18, 200, "regular",
				"inexperienced", 190.5, 60.0, 100, 250.8, 30));
		
		insuranceObj.displayAllProjectInvoices();
		
		System.out.println("the total insurance fees of all projects is: " 
				+ insuranceObj.calculateTotalInsuranceFees());
		
		Scanner input = new Scanner(System.in);
		String answer = "";
		
		do {
		
		System.out.println("Enter an invoice number: ");
		String num = input.next();
		
		try {
		insuranceObj.displayProjectInvoice(num);
		}
		catch (InvalidInvoiceNumberException exc) {
			System.out.println(exc.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

			System.out.println("do you want to enter another number? (Y/N)");
			answer = input.next();

		} while (answer.equalsIgnoreCase("y"));
		input.close();
	}

}
