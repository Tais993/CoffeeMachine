import java.util.Scanner;

class Stock {
    int milliLiterWater = 6000;
    int milliLiterMilk = 1500;
    int gramsOfCoffeeBeans = 450;
    int amountCoffeeCups = 30;
    int amountCoffeeCupsWanted = 0;
    int totalMoneyinCoffeeMachine = 0;

    int totalCupsWater = milliLiterWater / 200;
    int totalCupsMilk = milliLiterMilk / 50;
    int totalCupsCoffeeBeans = gramsOfCoffeeBeans / 15;
    int totalCupsCoffee = 0;

    Coffee coffeeChoosen = null;

    private Scanner scanner = new Scanner(System.in);

    void fillCoffeeMachine() {
        System.out.println("Write how many ml of water do you want to add: ");
        int mlWatertoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        milliLiterWater += mlWatertoAddCoffeeMachine;
        System.out.println("Write how many ml of milk do you want to add: ");
        int mlMilktoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        milliLiterMilk += mlMilktoAddCoffeeMachine;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int gCoffeeBeanstoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        gramsOfCoffeeBeans += gCoffeeBeanstoAddCoffeeMachine;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int disposableCupstoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        amountCoffeeCups += disposableCupstoAddCoffeeMachine;
    }

    void takeMoneyCoffeeMachine() {
        System.out.println("I gave you €" + totalMoneyinCoffeeMachine);
        totalMoneyinCoffeeMachine = 0;
    }

    void removeStockCoffeeMachine() {
        milliLiterWater += -coffeeChoosen.milliLiterWaterCoffee * amountCoffeeCupsWanted;
        milliLiterMilk += -coffeeChoosen.milliLiterMilkCoffee * amountCoffeeCupsWanted;
        gramsOfCoffeeBeans += -coffeeChoosen.gramsOfCoffeeBeansCoffee * amountCoffeeCupsWanted;
        totalMoneyinCoffeeMachine += coffeeChoosen.price * amountCoffeeCupsWanted;
    }

    void CalculateRemainingCoffeeCups(String sortOfCoffee) {

        switch (sortOfCoffee) {
            case "0":
                totalCupsWater = milliLiterWater / 200;
                totalCupsMilk = milliLiterMilk / 50;
                totalCupsCoffeeBeans = gramsOfCoffeeBeans / 15;
                break;
            case "1":
                totalCupsWater = milliLiterWater / 250;
                totalCupsMilk = milliLiterMilk / 1;
                totalCupsCoffeeBeans = gramsOfCoffeeBeans / 16;
                break;
            case "2":
                totalCupsWater = milliLiterWater / 350;
                totalCupsMilk = milliLiterMilk / 75;
                totalCupsCoffeeBeans = gramsOfCoffeeBeans / 20;
                break;
            case "3":
                totalCupsWater = milliLiterWater / 200;
                totalCupsMilk = milliLiterMilk / 100;
                totalCupsCoffeeBeans = gramsOfCoffeeBeans / 12;
                break;
        }
        if (totalCupsWater == totalCupsMilk && totalCupsCoffeeBeans == totalCupsWater) {
            totalCupsCoffee = totalCupsWater;
        } else if (totalCupsMilk >= totalCupsWater && totalCupsCoffeeBeans >= totalCupsWater) {
            totalCupsCoffee = totalCupsWater;
        } else if (totalCupsWater >= totalCupsMilk && totalCupsCoffeeBeans >= totalCupsMilk) {
            totalCupsCoffee = totalCupsMilk;
        } else if (totalCupsMilk >= totalCupsCoffeeBeans && totalCupsWater >= totalCupsCoffeeBeans) {
            totalCupsCoffee = totalCupsCoffeeBeans;
        } else {
            System.err.println("Ah shit here we go again\n" +
                    totalCupsWater + "\n" +
                    totalCupsMilk + "\n" +
                    totalCupsCoffeeBeans + "\n" +
                    totalCupsCoffee);
        }
        if (totalCupsCoffee > amountCoffeeCups) {
            totalCupsCoffee = amountCoffeeCups;
        }
    }
}
