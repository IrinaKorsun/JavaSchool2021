package shkabrov.farms;

import shkabrov.fruits.Fruit;
import shkabrov.fruits.apples.GoldenDelicious;
import shkabrov.fruits.apples.ReinetteSimirenko;
import shkabrov.fruits.grapes.Arcadia;
import shkabrov.fruits.grapes.Helios;
import shkabrov.fruits.grapes.Rizamat;
import shkabrov.varieties.FruitVariety;
import shkabrov.varieties.VarietyErrorCode;
import shkabrov.varieties.VarietyException;

/**
 * Севастопольская ферма
 */
public class SevastopolFarm extends Farm {
    public SevastopolFarm() {

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
            case ARCADIA:
                return new Arcadia();
            case RIZAMAT:
                return new Rizamat();
            case HELIOS:
                return new Helios();
            default:
                throw new VarietyException(VarietyErrorCode.VARIETY_INCORRECT);
        }
    }
}
