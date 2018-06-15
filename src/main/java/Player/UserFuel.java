package src.main.java.Player;
import src.main.java.*;
import java.lang.Math;

enum engineType {diesel, bunker, lowSulfur}

public class UserFuel extends UserLocation{
	private double currentFuel;
	private double maximumFuel;
	private double fuelPrice;
	private double fuelConsumption;

	private final static int fuelPriceChange = 15;

	public UserFuel(){
		this.currentFuel = 140;
		this.maximumFuel = 140;
		this.fuelPrice = 343;

		// Bunker fuel price per ton $343
		//Burns 1.2 tons per day
		//Max Fuel capacity 140 tons
	}

	public UserFuel(double UserDefinedCurrentFuel, double UserDefinedMaxFuel, double UserDefinedFuelPrice){
		this.currentFuel = UserDefinedCurrentFuel;
		this.maximumFuel = UserDefinedMaxFuel;
		this.fuelPrice = UserDefinedFuelPrice;
	}

	public void DecreaseFuel(double fuelUsage){
		//Abstract.DecreaseValue(this.currentFuel, fuelUsage);
		this.currentFuel -= fuelUsage;
	}

	public void DecreaseFuel(){
		//Abstract.DecreaseValue(this.currentFuel, this.fuelConsumption);
		this.currentFuel -= this.fuelConsumption;
	}

	public void IncreaseFuel(double fuelUsage){
		//Abstract.IncreaseValue(this.currentFuel, fuelUsage);
		this.currentFuel += fuelUsage;
	}

	public void IncreaseFuel(){
		//Abstract.IncreaseValue(this.currentFuel, this.fuelConsumption);
		this.currentFuel += this.fuelConsumption;
	}

	public void SetCurrentFuel(int userDefinedFuel){
		this.currentFuel = (double)userDefinedFuel;
	}

	public void SetCurrentFuel(double passedUserFuel){
		this.currentFuel = passedUserFuel;
	}

	public void SetFuelConsumption(double userDefinedConsumption){
		this.fuelConsumption = userDefinedConsumption;
	}

	public void SetMaximumFuel(int userDefinedFuel){
		this.maximumFuel = (double)userDefinedFuel;
	}

	public double GetCurrentFuel(){
		return Math.round(this.currentFuel);
	}

	public double GetMaximumFuel(){
		return Math.round(this.maximumFuel);
	}

	public double GetFuelConsumption(){
		return Math.round(this.fuelConsumption);
	}

	public String GetFuelPercentage(){
		return "" + GetCurrentFuel() + " / " + GetMaximumFuel();
	}

	public void DisplayFuelGauge(){
		System.out.print("E |");
		for(int i = 0; i < 11; i++){
			if(((GetCurrentFuel() / GetMaximumFuel()) * 11) >= i){
				System.out.print("#");
			} else {
				System.out.print(" ");
			}
		}
		System.out.print("| F");
		System.out.println("\n  |=====|=====|");
	}

	public void DisplayFuelPercentage(){
		System.out.println(GetCurrentFuel() + " / " + GetMaximumFuel());
	}

	public void DisplayFormattedFuelPercentage(){
		System.out.println("Fuel: " + GetFuelPercentage());
	}

	public void DisplayFuelConsumption(){
		System.out.print("Fuel Consumption: " + GetFuelConsumption());
	}

	public void DisplayMaximumFuel(){
		System.out.println("Maximum Fuel: " + GetMaximumFuel());
	}

	public void DisplayCurrentFuel(){
		System.out.println("Current Fuel: " + GetCurrentFuel());
	}

/*	public void fuelMeasureAndConsumption(int ){

	}*/


	private double getVariedFuelConsumption(){
		//Abstract.IncreaseDecrease();
		if(Abstract.GetRandomValue(100, 0) > 51){
			return GetFuelConsumption() + (Abstract.GetRandomValue(20, 0) * .010);
		} else {
			return GetFuelConsumption() - (Abstract.GetRandomValue(20, 0) * .010);
		}
	}

	public void FuelMeasureAndConsumption(Boat playerObject){
		if(IsOutOfFuel() == false){
			DecreaseFuel(getVariedFuelConsumption());
		} else{
			new RandomEvent().noFuel(playerObject);
		}
	}

	private boolean FullFuelTank(){
		if(this.currentFuel >= this.maximumFuel){
			return true;
		}
		return false;
	}

	public boolean IsOutOfFuel(){
		if(this.currentFuel <= 0){
			this.currentFuel = 0;
			return true;
		}
		return false;
			/*System.out.println("Out of fuel");*/
	}

	private void IncreaseDecreaseFuelPrice(){
		this.fuelPrice += Abstract.IncreaseDecrease(fuelPriceChange);
		/*int dailyUpDown = Abstract.GetRandomValue(100);
		if(dailyUpDown >= 51){
			this.fuelPrice += Abstract.GetRandomValue(fuelPriceChange);
		} else{
			this.fuelPrice -= Abstract.GetRandomValue(fuelPriceChange);
		}*/
	}

}
