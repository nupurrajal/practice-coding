package temp;

public class MMTTruckProblem {

	public static void main(String[] args) {
		System.out.println(10 * calculateMaximumTruckDistance(100.0, 35.0, 1.0, 0.35));
	}
	
	static int calculateMaximumTruckDistance(double mainTankSize, double subTankSize, double flowRateMain, double flowRateSub) {
//		int noOfFlows = 0;
//		if (mainTankSize >= subTankSize) {
//			noOfFlows = (int) Math.floor(subTankSize / flowRateSub);
//			
//		} else {
//			double flowDifference = flowRateMain - flowRateSub;
//			if (flowDifference > 0)
//				noOfFlows = (int) Math.floor(mainTankSize / flowDifference);
//			else {
//				noOfFlows = (int) ((mainTankSize + subTankSize) / flowRateMain);
//			}
//		}
		int count = 0;
		double tempMain = mainTankSize;
		while (tempMain >= 0) {
			if (mainTankSize > flowRateMain) {
				count += (int) mainTankSize / flowRateMain;
				tempMain -= count * flowRateMain;
				tempMain += flowRateSub * Math.min(subTankSize, count);
				subTankSize -= flowRateSub * count;
			}
		}
		return count;
	}
}
