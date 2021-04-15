package shkabrov.farms;

import shkabrov.fruits.Fruit;
import shkabrov.varieties.FruitVariety;
import shkabrov.varieties.VarietyException;

/**
 * Ферма
 */
public abstract class Farm {
    protected Farm() {

    }

    /**
     * @param fruitVariety сорт фруктов
     * @return фрукт
     * @throws VarietyException некорректный сорт фруктов
     */
    public abstract Fruit createFruit(FruitVariety fruitVariety) throws VarietyException;

    /**
     * @param fruitVariety сорт фруктов
     * @param quantity     количество фруктов
     * @return фрукт
     * @throws VarietyException некорректный сорт фруктов
     */
    public Fruit[] createFruits(FruitVariety fruitVariety, int quantity) throws VarietyException {
        Fruit[] fruits = new Fruit[quantity];
        for (int i = 0; i < quantity; i++) {
            fruits[i] = createFruit(fruitVariety);
        }
        return fruits;
    }
}
