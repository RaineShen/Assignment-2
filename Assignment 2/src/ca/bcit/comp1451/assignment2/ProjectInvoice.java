/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Rain
 *
 */
public abstract class ProjectInvoice implements Comparable<ProjectInvoice>{
	
	private static int num = 1000;
	private String invoiceNumber;
	private String projectName;
	private double numberOfWorkingHours;
	private double hourlyRate;
	
	/**
	 * @param projectName
	 * @param numberOfWorkingHours
	 * @param hourlyRate
	 */
	public ProjectInvoice(String projectName, double numberOfWorkingHours, double hourlyRate) {
	
		setProjectName(projectName);
		setNumberOfWorkingHours(numberOfWorkingHours);
		setHourlyRate(hourlyRate);
		
		createInvoiceNumber();
	}

	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		if(projectName != null && projectName.length() > 0) {
		this.projectName = projectName;
		} else {
			System.out.println("project name cannot be null or empty");
		}
	}

	/**
	 * @return the numberOfWorkingHours
	 */
	public double getNumberOfWorkingHours() {
		return numberOfWorkingHours;
	}

	/**
	 * @param numberOfWorkingHours the numberOfWorkingHours to set
	 */
	public void setNumberOfWorkingHours(double numberOfWorkingHours) {
		if(numberOfWorkingHours >= 0) {
		this.numberOfWorkingHours = numberOfWorkingHours;
		} else {
			System.out.println("number of working hours cannot be negative");
		}
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		if(hourlyRate >= 0) {
		this.hourlyRate = hourlyRate;
		} else {
			System.out.println("hourly rate cannot be negative");
		}
	}

	/**
	 * method to create the invoice number
	 */
	private void createInvoiceNumber() {
		invoiceNumber = "INVC" + num;
		num++;
	}
	
	public abstract double calculateTotalcost();
	
	@Override
	public int compareTo(ProjectInvoice obj) {
		return (int) (this.calculateTotalcost() - obj.calculateTotalcost());
	}
	
	@Override
	public String toString() {
		return "Invoice number: " + getInvoiceNumber() + "\n" + "Project name: " + getProjectName() 
		+ "\n" + "Number of working hours: " + getNumberOfWorkingHours() + "\n"
		+ "Hourly rate: " + getHourlyRate();
	}
	
}
