/**
 * 
 */
package ca.bcit.comp1451.assignment2;

/**
 * @author Rain
 *
 */
public class LabourAndMaterial extends Labour implements Transferable {
	
	public static final double ADD_MAKEUP = 1.15;
	public static final int CRITICAL_VOL = 10;
	public static final double MAT_RATE1 = 2;
	public static final double MAT_RATE2 = 1.5;
	public static final double ADD_SALES_TAX = 1.05;
	private double materialPurchasePrice;
	private double volumeInCubicFoot;
	private double mDistanceOfTransportationInKm;
	
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
	 */
	public LabourAndMaterial(String projectName, double numberOfWorkingHours, double hourlyRate,
			double distanceOfTransportationInKilometers, String hourlyRateCriteria, String typeOfLabour,
			double materialPurchasePrice, double volumeInCubicFoot, double mDistanceOfTransportationInKm) {
		super(projectName, numberOfWorkingHours, hourlyRate, distanceOfTransportationInKilometers, 
				hourlyRateCriteria, typeOfLabour);
		setMaterialPurchasePrice(materialPurchasePrice);
		setVolumeInCubicFoot(volumeInCubicFoot);
		setMDistanceOfTransportationInKm(mDistanceOfTransportationInKm);
	}

	/**
	 * @return the materialPurchasePrice
	 */
	public double getMaterialPurchasePrice() {
		return materialPurchasePrice;
	}

	/**
	 * @param materialPurchasePrice the materialPurchasePrice to set
	 */
	public void setMaterialPurchasePrice(double materialPurchasePrice) {
		if(materialPurchasePrice >= 0) {
		this.materialPurchasePrice = materialPurchasePrice;
		} else {
			System.out.println("material purchase price cannot be negative");
		}
	}

	/**
	 * @return the volumeInCubicFoot
	 */
	public double getVolumeInCubicFoot() {
		return volumeInCubicFoot;
	}

	/**
	 * @param volumeInCubicFoot the volumeInCubicFoot to set
	 */
	public void setVolumeInCubicFoot(double volumeInCubicFoot) {
		if(volumeInCubicFoot >= 0) {
		this.volumeInCubicFoot = volumeInCubicFoot;
		} else {
			System.out.println("volume in cubic foot cannot be negative");
		}
	}

	/**
	 * @return the distanceOfTransportationInKm
	 */
	public double getMDistanceOfTransportationInKm() {
		return mDistanceOfTransportationInKm;
	}

	/**
	 * @param distanceOfTransportationInKm the distanceOfTransportationInKm to set
	 */
	public void setMDistanceOfTransportationInKm(double mDistanceOfTransportationInKm) {
		if(mDistanceOfTransportationInKm >= 0) {
		this.mDistanceOfTransportationInKm = mDistanceOfTransportationInKm;
		} else {
		System.out.println("material distance of transportation cannot be negative");
		}
	}

	/**
	 * method to calculate total material cost
	 */
	public double calculateTotalMaterialCost() {
		return ADD_MAKEUP * getMaterialPurchasePrice();
	}
	
	@Override
	public double calculateTransportationFees() {
		double transCost = 0.0;
		if(getVolumeInCubicFoot() >= CRITICAL_VOL) {
			transCost = getMDistanceOfTransportationInKm() * MAT_RATE1;
		} if(getVolumeInCubicFoot() < CRITICAL_VOL) {
			transCost = getMDistanceOfTransportationInKm() * MAT_RATE2; 
		}
		return transCost;
	}
	
	@Override
	public double calculateTotalcost() {
		return super.calculateTotalcost() + ADD_SALES_TAX *(calculateTransportationCost() 
		+ getMaterialPurchasePrice());
	}
	
	@Override
	public String toString() {
		String statement = "";
		if (this.getClass() == LabourAndMaterial.class) {
			statement = super.toString() + "\n" + "The material cost is: " + getMaterialPurchasePrice() + "\n"
					+ "The material transportation fees is: " + calculateTransportationFees() + "\n"
					+ "The total cost including 5% tax is: " + calculateTotalcost();
		} else {
			statement = super.toString() + "\n" + "The material cost is: " + getMaterialPurchasePrice() + "\n"
					+ "The material transportation fees is: " + calculateTransportationFees();
		}
		return statement;
	}

}
