//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.displayMenu();

        Coffee espresso = coffeeMachine.selectCoffee("espresso");
        coffeeMachine.dispenseCoffee(espresso,new Payment(2.5));

        Coffee cappucino = coffeeMachine.selectCoffee("Cappucino");
        coffeeMachine.dispenseCoffee(cappucino,new Payment(10.0));

        Coffee latte = coffeeMachine.selectCoffee("latte");
        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));

        coffeeMachine.dispenseCoffee(espresso,new Payment(2.5));

        coffeeMachine.dispenseCoffee(cappucino,new Payment(10.0));

        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));

        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));
        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));
        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));
        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));
        coffeeMachine.dispenseCoffee(latte,new Payment(11.0));


    }
}