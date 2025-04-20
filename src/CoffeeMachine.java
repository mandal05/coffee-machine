import java.util.*;

public class CoffeeMachine {


    private final List<Coffee> coffeeList;
    private final Map<String,Ingredient> ingredients;

    public CoffeeMachine(){
        coffeeList = new ArrayList<>();
        ingredients = new HashMap<>();

        initializeIngredients();
        initializeMenu();
    }

    private void initializeIngredients(){

        ingredients.put("coffee", new Ingredient("coffee",10));
        ingredients.put("milk", new Ingredient("milk",10));
        ingredients.put("water", new Ingredient("water",10));
        return;
    }
    private void  initializeMenu(){

        Map<Ingredient,Integer> cappucinoReceipe = new HashMap<>();
        cappucinoReceipe.put(ingredients.get("coffee"),1);
        cappucinoReceipe.put(ingredients.get("milk"),1);

        Map<Ingredient,Integer> espressoReceipe = new HashMap<>();
        espressoReceipe.put(ingredients.get("coffee"),1);
        espressoReceipe.put(ingredients.get("water"),1);

        Map<Ingredient,Integer> latteReceipe = new HashMap<>();
        latteReceipe.put(ingredients.get("coffee"),1);
        latteReceipe.put(ingredients.get("milk"),2);
        latteReceipe.put(ingredients.get("water"),1);

        coffeeList.add(new Coffee("Cappucino",cappucinoReceipe,3.5));
        coffeeList.add(new Coffee("Espresso",espressoReceipe,2));
        coffeeList.add(new Coffee("Latte",latteReceipe,4));

    }

    public void displayMenu(){
        for(Coffee coffee:coffeeList){
            System.out.println(coffee.getName()+ " -> $" +coffee.getPrice() );
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName){
        for(Coffee coffee : coffeeList){
            if(coffee.getName().equalsIgnoreCase(coffeeName))
                return coffee;
        }
        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment){
        if(payment.getAmount() > coffee.getPrice()){
            if(hasEnoughCoffee(coffee)){
                updateIngredient(coffee);
                System.out.println("Dispensing your choice of "+ coffee.getName());
                Double change = payment.getAmount()-coffee.getPrice();
                if(change>0){
                    System.out.println("Please Take your change "+ change);
                }
            }else{
                System.out.println("Insufficient ingredients for your choice");
            }
        }else{
            System.out.println("Insufficient Payment for your selection");
        }
    }

    private boolean hasEnoughCoffee(Coffee coffee){
        for(Map.Entry<Ingredient,Integer> entry : coffee.getReceipe().entrySet()){
            Ingredient ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();

            if(ingredient.getQuantity() < requiredAmount) return false;
        }
        return true;
    }

    private void updateIngredient(Coffee coffee){
        for(Map.Entry<Ingredient,Integer> entry : coffee.getReceipe().entrySet()){
            Ingredient ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
            ingredient.updateQuantity(-requiredAmount);

            if(ingredient.getQuantity() < 3)
                System.out.println(ingredient.getName() + " quantity low");
        }
        return;
    }



}
