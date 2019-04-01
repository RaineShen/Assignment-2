/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Rain
 *
 */
public class LabourAndMaterialAndEquipment extends LabourAndMaterial {
	
	public static final double PER_VALUE = 0.05;
	public static final double ADD_TRAINING = 1.02;
	public static final double ADD_SALES_TAX = 1.05;
	private double equipmentValueInCAD;
	private double numberOfRentedHours;
	
	/**
	 * @param projectName
	 * @param numberOfWorkingHours
	 * @param hourlyRate
	 * @param distanceOfTransportationInKilometers
	 * @param hourlyRateCriteria
	 * @param typeOfLabour
	 * @param materialPurchasePrice
	 * @param volumeInCubicFoot
	 * @param mDistanceOfTransportationInKm
	 * @param equipmentValueInCAD
	 * @param numberOfRentedHours
	 */
	public LabourAndMaterialAndEquipment(String projectName, double numberOfWorkingHours, double hourlyRate,
			double distanceOfTransportationInKilometers, String hourlyRateCriteria, String typeOfLabour,
			double materialPurchasePrice, double volumeInCubicFoot, double mDistanceOfTransportationInKm,
			double equipmentValueInCAD, double numberOfRentedHours) {
		super(projectName, numberOfWorkingHours, hourlyRate, distanceOfTransportationInKilometers, 
				hourlyRateCriteria, typeOfLabour, materialPurchasePrice, volumeInCubicFoot, 
				mDistanceOfTransportationInKm);
		setEquipmentValueInCAD(equipmentValueInCAD);
		setNumberOfRentedHours(numberOfRentedHours);
	}

	/**
	 * @return the equipmentValueInCAD
	 */
	public double getEquipmentValueInCAD() {
		return equipmentValueInCAD;
	}

	/**
	 * @param equipmentValueInCAD the equipmentValueInCAD to set
	 */
	public void setEquipmentValueInCAD(double equipmentValueInCAD) {
		if(equipmentValueInCAD >= 0) {
		this.equipmentValueInCAD = equipmentValueInCAD;
		} else {
			System.out.println("equipment value cannot be negative");
		}
	}

	/**
	 * @return the numberOfRentedHours
	 */
	public double getNumberOfRentedHours() {
		return numberOfRentedHours;
	}

	/**
	 * @param numberOfRentedHours the numberOfRentedHours to set
	 */
	public void setNumberOfRentedHours(double numberOfRentedHours) {
		if(numberOfRentedHours >= 0) {
		this.numberOfRentedHours = numberOfRentedHours;
		} else {
			System.out.println("number of rented hours cannot be negative");
		}
	}

	/**
	 * method to calculate total rental fees
	 */
	public double calculateTotalRentalFees() {
		double ratePerHour = PER_VALUE * getEquipmentValueInCAD();
		return ratePerHour * getNumberOfRentedHours();
	}


	/**
	 * method to calculate training fees
	 */
	public double calculateTrainingFees() {
		double trainingFee = 0.0;
		if(getTypeOfLabour().equals("experienced")) {
			trainingFee = 0.0;
		} else if(getTypeOfLabour().equals("inexperienced")) {
			trainingFee = ADD_TRAINING * getEquipmentValueInCAD();
		}
		return trainingFee;
	}
	
	@Override
	public double calculateTotalcost() {
		return super.calculateTotalcost() + ADD_SALES_TAX *(calculateTotalRentalFees()
				+ calculateTrainingFees());
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + "Equipment number of rented hours: " + getNumberOfRentedHours()
		+ "\n" + "Equipment rental fees: " + calculateTotalRentalFees() + "\n"
		+ "Training fees: " + calculateTrainingFees() + "\n"
		+ "The total cost including 5% tax is: " + calculateTotalcost();
	}
	
}
