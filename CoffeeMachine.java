import java.util.Scanner;

public class CoffeeMachine {
    public int cupsofCoffee = 0;
    public int totalMlWaterinCoffeeMachine = 6200;
    public int totalMlMilkinCoffeeMachine = 1500;
    public int totalGCoffeeBeansinCoffeeMachine = 465;
    public int totalAmountDisposableCoffeecups = 30;
    public int amountCoffeeCupsWanted = 0;

    public int totalMoneyinCoffeeMachine = 0;

    public int totalCupsWater = totalMlWaterinCoffeeMachine / 200;
    public int totalCupsMilk = totalMlMilkinCoffeeMachine / 50;
    public int totalCupsCoffeeBeans = totalGCoffeeBeansinCoffeeMachine / 15;
    public int totalCupsCoffee = 0;

    public Scanner scanner = new Scanner(System.in);

    public void makeCoffee() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String action = null;
        while (action != "exit") {
            System.out.println("action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            reCalculateRemainingCoffeeCups();
            switch (action) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillCoffeeMachine();
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
        String sortOfCoffeeString = null;
        System.out.println("How many cups of coffee would you like? max " + totalCupsCoffee);
        amountCoffeeCupsWanted = Integer.parseInt(scanner.nextLine());
        totalAmountDisposableCoffeecups += -amountCoffeeCupsWanted;
        switch (sortOfCoffee) {
            case 1:
                totalMlWaterinCoffeeMachine += - 250*amountCoffeeCupsWanted;
                totalGCoffeeBeansinCoffeeMachine += - 16*amountCoffeeCupsWanted;
                totalMoneyinCoffeeMachine += 4*amountCoffeeCupsWanted;
                sortOfCoffeeString = "Espresso";
                informUserAboutCoffee(sortOfCoffeeString);
                break;
            case 2:
                totalMlWaterinCoffeeMachine += - 350*amountCoffeeCupsWanted;
                totalMlMilkinCoffeeMachine += - 75*amountCoffeeCupsWanted;
                totalGCoffeeBeansinCoffeeMachine += - 20*amountCoffeeCupsWanted;
                totalMoneyinCoffeeMachine += 7*amountCoffeeCupsWanted;
                sortOfCoffeeString = "Latte";
                informUserAboutCoffee(sortOfCoffeeString);
                break;
            case 3:
                totalMlWaterinCoffeeMachine += - 200*amountCoffeeCupsWanted;
                totalMlMilkinCoffeeMachine += - 100*amountCoffeeCupsWanted;
                totalGCoffeeBeansinCoffeeMachine += - 12*amountCoffeeCupsWanted;
                totalMoneyinCoffeeMachine += 6*amountCoffeeCupsWanted;
                sortOfCoffeeString = "Cappuccino";
                informUserAboutCoffee(sortOfCoffeeString);
                break;
        }
    }
    private void fillCoffeeMachine () {
        System.out.println("Write how many ml of water do you want to add: ");
        int mlWatertoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        totalMlWaterinCoffeeMachine += mlWatertoAddCoffeeMachine;
        System.out.println("Write how many ml of milk do you want to add: ");
        int mlMilktoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        totalMlMilkinCoffeeMachine += mlMilktoAddCoffeeMachine;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int gCoffeeBeanstoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        totalGCoffeeBeansinCoffeeMachine += gCoffeeBeanstoAddCoffeeMachine;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int disposableCupstoAddCoffeeMachine = Integer.parseInt(scanner.nextLine());
        totalAmountDisposableCoffeecups += disposableCupstoAddCoffeeMachine;
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
                "Total ml water remaining: " + totalMlWaterinCoffeeMachine + "ml equal to " + totalCupsWater + " cups coffee.\n" +
                "Total ml milk remaining: " + totalMlMilkinCoffeeMachine + "ml equal to " + totalCupsMilk + " cups of coffee.\n" +
                "Total g coffee beans remaining: " + totalGCoffeeBeansinCoffeeMachine + "ml equal to " + totalCupsCoffeeBeans + " cups of coffee.\n" +
                "Total disposable coffee cups remaining: " + totalAmountDisposableCoffeecups + ".");
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
        if (totalCupsCoffee > totalAmountDisposableCoffeecups) {
            totalCupsCoffee = totalAmountDisposableCoffeecups;
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
        return;
    }

    private void informUserAboutCoffee(String sortOfCoffeeString) throws InterruptedException {
        System.out.println("Starting to make " + amountCoffeeCupsWanted + " " + sortOfCoffeeString);
        Thread.sleep(300);
        System.out.println("Ginding coffee beans");
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
        return;
    }

    private void reCalculateRemainingAmountCoffee() {
        totalCupsWater = totalMlWaterinCoffeeMachine / 200;
        totalCupsMilk = totalMlMilkinCoffeeMachine / 50;
        totalCupsCoffeeBeans = totalGCoffeeBeansinCoffeeMachine / 15;
        reCalculateRemainingCoffeeCups();
    }
}