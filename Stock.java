import java.util.Scanner;

public class Stock {
    public int milliLiterWater = 6000;
    public int milliLiterMilk = 1500;
    public int gramsOfCoffeeBeans = 450;
    public int amountCoffeeCups = 30;
    public int amountCoffeeCupsWanted = 0;
    public int totalMoneyinCoffeeMachine = 0;

    Coffee coffeeChoosen = null;

    private Scanner scanner = new Scanner(System.in);

    public void fillCoffeeMachine () {
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

    public void takeStockCoffeeMachine () {
        milliLiterWater += coffeeChoosen.milliLiterWaterCoffee * amountCoffeeCupsWanted;
        milliLiterMilk += coffeeChoosen.milliLiterMilkCoffee * amountCoffeeCupsWanted;
        gramsOfCoffeeBeans += coffeeChoosen.gramsOfCoffeeBeansCoffee * amountCoffeeCupsWanted;
        totalMoneyinCoffeeMachine += coffeeChoosen.price * amountCoffeeCupsWanted;
    }
}
