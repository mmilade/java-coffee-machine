package machine;

public class Coffee {
    int amountOfWaterNeededPerCup;
    int amountOfMilkNeededPerCup;
    int amountOfCoffeeBeansNeededPerCup;
    int cost;

    public Coffee(int amountOfWaterNeededPerCup, int amountOfMilkNeededPerCup, int amountOfCoffeeBeansNeededPerCup, int cost) {
        this.amountOfWaterNeededPerCup = amountOfWaterNeededPerCup;
        this.amountOfMilkNeededPerCup = amountOfMilkNeededPerCup;
        this.amountOfCoffeeBeansNeededPerCup = amountOfCoffeeBeansNeededPerCup;
        this.cost = cost;
    }

    public int getAmountOfWaterNeededPerCup() {
        return amountOfWaterNeededPerCup;
    }

    public int getAmountOfMilkNeededPerCup() {
        return amountOfMilkNeededPerCup;
    }

    public int getAmountOfCoffeeBeansNeededPerCup() {
        return amountOfCoffeeBeansNeededPerCup;
    }

    public int getCost() {
        return cost;
    }
}
