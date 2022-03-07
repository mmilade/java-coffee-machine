package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int amountOfWaterAvailable = 400;
    int amountOfMilkAvailable = 540;
    int amountOfCoffeeBeansAvailable = 120;
    int numberOfDisposableCupsAvailable = 9;
    int moneyAvailable = 550;
    int numberOfCupsRequired = 1;
    int numberOfCupsWhichCanBeMade;

    boolean quit = false;

    Scanner scanner = new Scanner(System.in);

    private Coffee coffeeType(int coffeeOption) {
        Coffee coffee = null;
        if (coffeeOption == 1) {
            coffee = new Coffee(250, 0, 16, 4);
        } else if (coffeeOption == 2) {
            coffee = new Coffee(350, 75, 20, 7);
        } else if (coffeeOption == 3) {
            coffee = new Coffee(200, 100, 12, 6);
        }

        return coffee;
    }

    private int howManyCupsOfCoffeeCanBeMade(int amountOfWaterAvailable,
                                             int amountOfMilkAvailable,
                                             int amountOfCoffeeBeansAvailable,
                                             int coffeeOption) {

        Coffee coffee = coffeeType(coffeeOption);
        int numberOfCupsWhichCanBeMade = 0;

        if (coffee.amountOfMilkNeededPerCup == 0) {
            numberOfCupsWhichCanBeMade = Math.min(amountOfWaterAvailable / coffee.amountOfWaterNeededPerCup, amountOfCoffeeBeansAvailable / coffee.amountOfCoffeeBeansNeededPerCup);
            return numberOfCupsWhichCanBeMade;
        }

        if (amountOfWaterAvailable / coffee.amountOfWaterNeededPerCup <= amountOfMilkAvailable / coffee.amountOfMilkNeededPerCup
                && amountOfWaterAvailable / coffee.amountOfWaterNeededPerCup <= amountOfCoffeeBeansAvailable / coffee.amountOfCoffeeBeansNeededPerCup) {
            numberOfCupsWhichCanBeMade = amountOfWaterAvailable / coffee.amountOfWaterNeededPerCup;
        } else
            numberOfCupsWhichCanBeMade = Math.min(amountOfMilkAvailable / coffee.amountOfMilkNeededPerCup, amountOfCoffeeBeansAvailable / coffee.amountOfCoffeeBeansNeededPerCup);

        return numberOfCupsWhichCanBeMade;
    }


    private String displayMessage(int numberOfCupsRequired,
                                  int amountOfWaterAvailable,
                                  int amountOfMilkAvailable,
                                  int amountOfCoffeeBeansAvailable,
                                  int coffeeOption) {

        String message = "";
        int numberOfCupsWhichCanBeMade = howManyCupsOfCoffeeCanBeMade(amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption);

        if (numberOfCupsRequired > numberOfCupsWhichCanBeMade) {

            if (amountOfWaterAvailable < coffeeType(coffeeOption).amountOfWaterNeededPerCup) {
                message = "Sorry, not enough water!\n";
            } else if (amountOfMilkAvailable < coffeeType(coffeeOption).amountOfMilkNeededPerCup) {
                message = "Sorry, not enough milk!\n";
            } else {
                message = "Sorry, not enough coffee beans!\n";
            }

        } else if (numberOfCupsRequired < numberOfCupsWhichCanBeMade) {
            message = "I have enough resources, making you a coffee!\n";
        } else {
            message = "I have enough resources, making you a coffee!\n";
        }

        return message;
    }


    private void updateStock(int coffeeOption) {

        Coffee coffee = coffeeType(coffeeOption);

        amountOfWaterAvailable -= coffee.amountOfWaterNeededPerCup;
        amountOfMilkAvailable -= coffee.amountOfMilkNeededPerCup;
        amountOfCoffeeBeansAvailable -= coffee.amountOfCoffeeBeansNeededPerCup;
        numberOfDisposableCupsAvailable--;
        moneyAvailable += coffee.cost;
    }

    public void run() {
        while (!quit) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String userOption = scanner.nextLine();

            switch (userOption) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");

                    if (scanner.hasNext("back")) {
                        continue;
                    }

                    int coffeeOption = Integer.parseInt(scanner.nextLine());

                    if (coffeeOption == 1) {

                        System.out.println(displayMessage(numberOfCupsRequired, amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption));

                        // Does not seem to work
                        // updateStock(amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, numberOfDisposableCupsAvailable, moneyAvailable, coffeeOption);

                        numberOfCupsWhichCanBeMade = howManyCupsOfCoffeeCanBeMade(amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption);

                        if (numberOfCupsRequired <= numberOfCupsWhichCanBeMade) {

                            updateStock(coffeeOption);
                        }

                    } else if (coffeeOption == 2) {

                        System.out.println(displayMessage(1, amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption));

                        numberOfCupsWhichCanBeMade = howManyCupsOfCoffeeCanBeMade(amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption);

                        if (numberOfCupsRequired <= numberOfCupsWhichCanBeMade) {

                            updateStock(coffeeOption);
                        }

                    } else if (coffeeOption == 3) {

                        System.out.println(displayMessage(1, amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption));

                        numberOfCupsWhichCanBeMade = howManyCupsOfCoffeeCanBeMade(amountOfWaterAvailable, amountOfMilkAvailable, amountOfCoffeeBeansAvailable, coffeeOption);

                        if (numberOfCupsRequired <= numberOfCupsWhichCanBeMade) {

                            updateStock(coffeeOption);
                        }

                    } else {
                        System.out.println("Wrong option entered, please entered 1, 2 or 3");
                        System.out.println();
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add: ");
                    //parsing in order to avoid issues with white spaces
                    amountOfWaterAvailable += Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many ml of milk you want to add: ");
                    amountOfMilkAvailable += Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    amountOfCoffeeBeansAvailable += Integer.parseInt(scanner.nextLine());
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    numberOfDisposableCupsAvailable += Integer.parseInt(scanner.nextLine());

                    break;

                case "take":
                    System.out.println("I gave you " + moneyAvailable);
                    moneyAvailable = 0;
                    break;

                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(amountOfWaterAvailable + " ml of water");
                    System.out.println(amountOfMilkAvailable + " ml of milk");
                    System.out.println(amountOfCoffeeBeansAvailable + " g of coffee beans");
                    System.out.println(numberOfDisposableCupsAvailable + " disposable cups");
                    System.out.println("$" + moneyAvailable + " of money");
                    System.out.println();
                    break;

                case "exit":
                    quit = true;
                    break;

                default:
                    System.out.println("wrong option entered, please enter buy, fill or take");
            }

        }
    }
}
