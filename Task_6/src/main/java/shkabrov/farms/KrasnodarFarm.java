package shkabrov.farms;

import shkabrov.fruits.Fruit;
import shkabrov.fruits.apples.Dream;
import shkabrov.fruits.grapes.Arcadia;
import shkabrov.fruits.grapes.Rizamat;
import shkabrov.fruits.apples.GoldenDelicious;
import shkabrov.fruits.apples.ReinetteSimirenko;
import shkabrov.varieties.FruitVariety;
import shkabrov.varieties.VarietyErrorCode;
import shkabrov.varieties.VarietyException;

/**
 * Краснодарская ферма
 */
public class KrasnodarFarm extends Farm {
    public KrasnodarFarm() {

    }

    /**
     * @param fruitVariety сорт фруктов
     * @return фрукт
     * @throws VarietyException некорректный сорт фруктов
     */
    @Override
    public Fruit createFruit(FruitVariety fruitVariety) throws VarietyException {
        switch (fruitVariety) {
            case REINETTE_SIMIRENKO:
                return new ReinetteSimirenko();
            case GOLDEN_DELICIOUS:
                return new GoldenDelicious();
            case DREAM:
                return new Dream();
            case ARCADIA:
                return new Arcadia();
            case RIZAMAT:
                return new Rizamat();
            default:
                throw new VarietyException(VarietyErrorCode.VARIETY_INCORRECT);
        }
    }
}
