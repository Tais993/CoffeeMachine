import java.util.Scanner;

class CoffeeMachine {
    Stock stock = new Stock();
    Coffee coffee = new Coffee();

    private int cupsofCoffee = 0;

    private int totalCupsWater = stock.milliLiterWater / 200;
    private int totalCupsMilk = stock.milliLiterMilk / 50;
    private int totalCupsCoffeeBeans = stock.gramsOfCoffeeBeans / 15;
    private int totalCupsCoffee = 0;

    private Scanner scanner = new Scanner(System.in);

    public void makeCoffee() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String action = " ";
        assert false;
        while (!action.equals("exit")) {
            System.out.println("action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            reCalculateRemainingCoffeeCups();
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    stock.fillCoffeeMachine();
                    break;
                case "remaining":
                    calculateCoffeeRemaining();
                    break;
            }
        }
        calculateBoughtCoffee();
    }

    private void buyCoffee() throws InterruptedException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        int sortOfCoffee = Integer.parseInt(scanner.nextLine());
        String sortOfCoffeeString = "coffee";
        System.out.println("How many cups of coffee would you like? max " + totalCupsCoffee);
        stock.amountCoffeeCupsWanted = Integer.parseInt(scanner.nextLine());
        stock.amountCoffeeCups += -stock.amountCoffeeCupsWanted;
        switch (sortOfCoffee) {
            case 1:
                stock.coffeeChoosen = new Espresso();
                stock.takeStockCoffeeMachine();
                informUserAboutCoffee(stock.coffeeChoosen.sortOfCoffeeString);
                break;
            case 2:
                stock.coffeeChoosen = new Latte();
                stock.takeStockCoffeeMachine();
                informUserAboutCoffee(stock.coffeeChoosen.sortOfCoffeeString);
                break;
            case 3:
                stock.coffeeChoosen = new Cappuccino();
                stock.takeStockCoffeeMachine();
                informUserAboutCoffee(stock.coffeeChoosen.sortOfCoffeeString);
                break;
        }
        reCalculateRemainingAmountCoffee();
    }

    private void calculateCoffeeRemaining () {
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
        System.out.println("Total cups coffee remaining: " + totalCupsCoffee + ".\n" +
                "Total ml water remaining: " + stock.milliLiterWater + "ml equal to " + totalCupsWater + " cups coffee.\n" +
                "Total ml milk remaining: " + stock.milliLiterMilk + "ml equal to " + totalCupsMilk + " cups of coffee.\n" +
                "Total g coffee beans remaining: " + stock.gramsOfCoffeeBeans + "ml equal to " + totalCupsCoffeeBeans + " cups of coffee.\n" +
                "Total disposable coffee cups remaining: " + stock.amountCoffeeCups + ".\n" +
                "There's also a total of €" + stock.totalMoneyinCoffeeMachine + " inside the coffee machine.\n");
    }

    private void reCalculateRemainingCoffeeCups () {
        if (totalCupsWater == totalCupsMilk && totalCupsCoffeeBeans == totalCupsWater) {
            totalCupsCoffee = totalCupsWater;
        } else if (totalCupsMilk >= totalCupsWater && totalCupsCoffeeBeans >= totalCupsWater) {
            totalCupsCoffee = totalCupsWater;
        } else if (totalCupsWater >= totalCupsMilk && totalCupsCoffeeBeans >= totalCupsMilk) {
            totalCupsCoffee = totalCupsMilk;
        } else if (totalCupsMilk >= totalCupsCoffeeBeans && totalCupsWater >= totalCupsCoffeeBeans) {
            totalCupsCoffee = totalCupsCoffeeBeans;
        }
        if (totalCupsCoffee > stock.amountCoffeeCups) {
            totalCupsCoffee = stock.amountCoffeeCups;
        }
    }

    private void calculateBoughtCoffee() throws InterruptedException {
        int mlofWater = cupsofCoffee*200;
        int mlofMilk = cupsofCoffee*50;
        int gofCoffeeBeans = cupsofCoffee*15;
        System.out.println("I can make " + " cup(s) of coffee");
        System.out.println("For " + cupsofCoffee + " cups of coffee you will need:\n" +
                mlofWater + "ml of water\n" +
                mlofMilk + "ml of milk\n" +
                gofCoffeeBeans + "g of coffee beans");
        Thread.sleep(1000);
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

    private void reCalculateRemainingAmountCoffee() {
        totalCupsWater = stock.milliLiterWater / 200;
        totalCupsMilk = stock.milliLiterMilk / 50;
        totalCupsCoffeeBeans = stock.gramsOfCoffeeBeans / 15;
        reCalculateRemainingCoffeeCups();
    }
}
