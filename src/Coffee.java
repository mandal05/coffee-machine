import java.util.Map;

public class Coffee {
    private final String name;
    private final Map<Ingredient,Integer> receipe;
    private final double price;

    public Coffee(String name, Map<Ingredient, Integer> receipe, double price) {
        this.name = name;
        this.receipe = receipe;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public Map<Ingredient,Integer> getReceipe(){
        return receipe;
    }
}
