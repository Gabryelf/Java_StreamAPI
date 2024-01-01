package org.example.sem_1_streamAPI.market;


import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;
    public boolean fats;
    public boolean carbohydrates;
    public boolean proteins;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Cart(ArrayList<T> foodstuffs, UMarket market, Class<T> clazz, boolean fats, boolean carbohydrates, boolean proteins) {
        this.foodstuffs = foodstuffs;
        this.market = market;
        this.clazz = clazz;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
    }

    public void cardBalancing()
    {


        proteins = foodstuffs.stream()
                .filter(food -> !proteins && food.getProteins())
                .peek(food -> proteins = true)
                .count() > 0;

       

        fats = foodstuffs.stream()
                .filter(food -> !fats && food.getFats())
                .peek(food -> fats = true)
                .count() > 0;

        carbohydrates = foodstuffs.stream()
                .filter(food -> !carbohydrates && food.getCarbohydrates())
                .peek(food -> carbohydrates = true)
                .count() > 0;

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(clazz).stream()
                .filter(thing -> !proteins && thing.getProteins())
                .peek(thing -> {
                    proteins = true;
                    foodstuffs.add(thing);
                })
                .count();

        market.getThings(clazz).stream()
                .filter(thing -> !fats && thing.getFats())
                .peek(thing -> {
                    fats = true;
                    foodstuffs.add(thing);
                })
                .count();

        market.getThings(clazz).stream()
                .filter(thing -> !carbohydrates && thing.getCarbohydrates())
                .peek(thing -> {
                    carbohydrates = true;
                    foodstuffs.add(thing);
                })
                .count();

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

        /* proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodstuffs)
        {
            if (!proteins && food.getProteins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing : market.getThings(clazz))
        {
            if (!proteins && thing.getProteins())
            {
                proteins = true;
                foodstuffs.add(thing);
            }
            else if (!fats && thing.getFats())
            {
                fats = true;
                foodstuffs.add(thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates())
            {
                carbohydrates = true;
                foodstuffs.add(thing);
            }
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");*/

    }

    //endregion

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }



    public void printFoodstuffs()
    {
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");*/


        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }
}
