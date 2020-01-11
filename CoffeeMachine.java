import java.util.Scanner;

class CoffeeMachine {
    private Stock stock = new Stock();
    private Scanner scanner = new Scanner(System.in);

    private String sortOfCoffee = "0";

    void makeCoffee() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String action = " ";
        assert false;
        while (!action.equals("exit")) {
            System.out.println("action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            stock.CalculateRemainingCoffeeCups(sortOfCoffee);
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    stock.fillCoffeeMachine();
                    break;
                case "take":
                    stock.takeMoneyCoffeeMachine();
                    break;
                case "remaining":
                    calculateCoffeeRemaining();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("I'm sorry, we didn't get your command");
                    break;
            }
        }
    }

    private void buyCoffee() throws InterruptedException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        sortOfCoffee = scanner.nextLine();
        if (sortOfCoffee.equals("back")){
            return;
        }
        stock.CalculateRemainingCoffeeCups(sortOfCoffee);
        System.out.println("How many cups of coffee would you like? max " + stock.totalCupsCoffee);
        stock.amountCoffeeCupsWanted = Integer.parseInt(scanner.nextLine());
        if (stock.amountCoffeeCupsWanted > stock.totalCupsCoffee) {
            System.err.println("I don't have enough recourse's");
            return;
        }
        stock.amountCoffeeCups += -stock.amountCoffeeCupsWanted;
        switch (sortOfCoffee) {
            case "1":
                stock.coffeeChoosen = new Espresso();
                break;
            case "2":
                stock.coffeeChoosen = new Latte();
                break;
            case "3":
                stock.coffeeChoosen = new Cappuccino();
                break;
            default:
                System.err.println("I'm sorry, something went wrong.");
                return;
        }
        stock.removeStockCoffeeMachine();
        informUserAboutCoffee(stock.coffeeChoosen.sortOfCoffeeString);
    }

    private void calculateCoffeeRemaining () {
        stock.CalculateRemainingCoffeeCups(sortOfCoffee);
        System.out.println("Total cups coffee remaining: " + stock.totalCupsCoffee + ".\n" +
                "Total ml water remaining: " + stock.milliLiterWater + "ml equal to " + stock.totalCupsWater + " cups coffee.\n" +
                "Total ml milk remaining: " + stock.milliLiterMilk + "ml equal to " + stock.totalCupsMilk + " cups of coffee.\n" +
                "Total g coffee beans remaining: " + stock.gramsOfCoffeeBeans + "ml equal to " + stock.totalCupsCoffeeBeans + " cups of coffee.\n" +
                "Total disposable coffee cups remaining: " + stock.amountCoffeeCups + ".\n" +
                "There's also a total of €" + stock.totalMoneyinCoffeeMachine + " inside the coffee machine.\n");
    }

    private void informUserAboutCoffee(String sortOfCoffeeString) throws InterruptedException {
        System.out.println("Starting to make " + stock.amountCoffeeCupsWanted + " " + sortOfCoffeeString);
        Thread.sleep(300);
        System.out.println("Grinding coffee beans");
        Thread.sleep(900);
        System.out.println("Boiling water");
        Thread.sleep(600);
        System.out.println("Mixing boiled water with crushed coffee beans");
        Thread.sleep(900);
        System.out.println("Pouring " + sortOfCoffeeString + " into the cup");
        Thread.sleep(3000);
        System.out.println("Pouring some milk into the cup");
        Thread.sleep(1800);
        System.out.println(sortOfCoffeeString + " is ready!");
    }
}
