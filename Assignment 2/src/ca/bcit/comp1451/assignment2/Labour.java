/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Rain
 *
 */
public class Labour extends ProjectInvoice {
	
	public static final double COST_PER_KM = 1.2;
	public static final double OT_RATE = 1.5;
	public static final double HOLIDAY_RATE = 2.0;
	public static final double ADD_SALES_TAX = 1.05;
	private double distanceOfTransportationInKilometers;
	private String hourlyRateCriteria;
	private String typeOfLabour;
	
	/**
	 * @param projectName
	 * @param numberOfWorkingHours
	 * @param hourlyRate
	 * @param distanceOfTransportationInKilometers
	 * @param hourlyRateCriteria
	 * @param typeOfLabour
	 */
	public Labour(String projectName, double numberOfWorkingHours, double hourlyRate,
			double distanceOfTransportationInKilometers, String hourlyRateCriteria, String typeOfLabour) {
		super(projectName, numberOfWorkingHours, hourlyRate);
		setDistanceOfTransportationInKilometers(distanceOfTransportationInKilometers);
		setHourlyRateCriteria(hourlyRateCriteria);
		setTypeOfLabour(typeOfLabour);
	}

	/**
	 * @return the distanceOfTransportationInKilometers
	 */
	public double getDistanceOfTransportationInKilometers() {
		return distanceOfTransportationInKilometers;
	}

	/**
	 * @param distanceOfTransportationInKilometers the distanceOfTransportationInKilometers to set
	 */
	public void setDistanceOfTransportationInKilometers(double distanceOfTransportationInKilometers) {
		if(distanceOfTransportationInKilometers >= 0) {
		this.distanceOfTransportationInKilometers = distanceOfTransportationInKilometers;
		} else {
			System.out.println("distance of transportation cannot be negateive");
		}
	}

	/**
	 * @return the hourlyRateCriteria
	 */
	public String getHourlyRateCriteria() {
		return hourlyRateCriteria;
	}

	/**
	 * @param hourlyRateCriteria the hourlyRateCriteria to set
	 */
	public void setHourlyRateCriteria(String hourlyRateCriteria) {
		if(hourlyRateCriteria.equals("regular") || hourlyRateCriteria.equals("overtime")
				|| hourlyRateCriteria.equals("holiday")) {
		this.hourlyRateCriteria = hourlyRateCriteria;
		} else {
			hourlyRateCriteria = "regular";
		}
	}

	/**
	 * @return the typeOfLabour
	 */
	public String getTypeOfLabour() {
		return typeOfLabour;
	}

	/**
	 * @param typeOfLabour the typeOfLabour to set
	 */
	public void setTypeOfLabour(String typeOfLabour) {
		if((typeOfLabour != null && typeOfLabour.equals("experienced"))
				|| (typeOfLabour != null && typeOfLabour.equals("inexperienced"))) {
		this.typeOfLabour = typeOfLabour;
		} else {
			typeOfLabour = "inexperienced";
		}
	}

	/**
	 * method to calculate transportation cost
	 */
	public double calculateTransportationCost() {
		return getDistanceOfTransportationInKilometers() * COST_PER_KM; 
	}

	/**
	 * method to calculate total transportation cost
	 */
	public double calculateTotalcost() {
		double hoursCost = getHourlyRate() * getNumberOfWorkingHours();
		double addFees = calculateTransportationCost() * ADD_SALES_TAX;
		double totalCost = 0.0;
		if(getHourlyRateCriteria().equals("regular")) {
			totalCost = hoursCost + addFees;
		} else if(getHourlyRateCriteria().equals("overtime")) {
			totalCost = OT_RATE * hoursCost + addFees;
		} else if(getHourlyRateCriteria().equals("holiday")) {
			totalCost = HOLIDAY_RATE * hoursCost + addFees;
		}
		return totalCost;
	}
	
	@Override
	public String toString() {
		String statement = "";
		if (this.getClass() == Labour.class) {
		statement = super.toString() + "\n" + "Hourly rate criteria: " + getHourlyRateCriteria()
		+ "\n" + "Type of labour: " + getTypeOfLabour() + "\n" + "Cost of labour transportation: "
		+ calculateTransportationCost() + "\n" + "Total cost including 5% tax: " + calculateTotalcost();
	} else {
		statement = super.toString() + "\n" + "Hourly rate criteria: " + getHourlyRateCriteria()
		+ "\n" + "Type of labour: " + getTypeOfLabour() + "\n" + "Cost of labour transportation: "
		+ calculateTransportationCost();
	}
		return statement;
	}
	
}
