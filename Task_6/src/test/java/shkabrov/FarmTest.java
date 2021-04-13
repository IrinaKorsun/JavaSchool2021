package shkabrov;

import org.junit.jupiter.api.Test;
import shkabrov.farms.Farm;
import shkabrov.farms.KrasnodarFarm;
import shkabrov.farms.SevastopolFarm;
import shkabrov.fruits.Fruit;
import shkabrov.fruits.apples.Dream;
import shkabrov.fruits.apples.GoldenDelicious;
import shkabrov.fruits.apples.ReinetteSimirenko;
import shkabrov.fruits.grapes.Arcadia;
import shkabrov.fruits.grapes.Helios;
import shkabrov.fruits.grapes.Rizamat;
import shkabrov.varieties.FruitVariety;
import shkabrov.varieties.VarietyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FarmTest {
    @Test
    public void farmWork() throws VarietyException {
        Farm krasnodarFarm = new KrasnodarFarm();
        assertEquals(KrasnodarFarm.class, krasnodarFarm.getClass());
        assertThrows(VarietyException.class, () -> krasnodarFarm.createFruits(FruitVariety.HELIOS, 5));
        Fruit[] krasnodarApples = krasnodarFarm.createFruits(FruitVariety.GOLDEN_DELICIOUS, 5);
        assertEquals(5, krasnodarApples.length);
        assertEquals(GoldenDelicious.class, krasnodarApples[0].getClass());

        krasnodarApples = krasnodarFarm.createFruits(FruitVariety.REINETTE_SIMIRENKO, 5);
        assertEquals(5, krasnodarApples.length);
        assertEquals(ReinetteSimirenko.class, krasnodarApples[0].getClass());

        krasnodarApples = krasnodarFarm.createFruits(FruitVariety.DREAM, 5);
        assertEquals(5, krasnodarApples.length);
        assertEquals(Dream.class, krasnodarApples[0].getClass());

        Fruit[] krasnodarGrapes = krasnodarFarm.createFruits(FruitVariety.ARCADIA, 5);
        assertEquals(5, krasnodarGrapes.length);
        assertEquals(Arcadia.class, krasnodarGrapes[0].getClass());

        krasnodarGrapes = krasnodarFarm.createFruits(FruitVariety.RIZAMAT, 5);
        assertEquals(5, krasnodarGrapes.length);
        assertEquals(Rizamat.class, krasnodarGrapes[0].getClass());

        Farm sevastopolFarm = new SevastopolFarm();
        assertEquals(SevastopolFarm.class, sevastopolFarm.getClass());
        assertThrows(VarietyException.class, () -> sevastopolFarm.createFruits(FruitVariety.DREAM, 5));
        Fruit[] sevastopolApples = sevastopolFarm.createFruits(FruitVariety.GOLDEN_DELICIOUS, 5);
        assertEquals(5, sevastopolApples.length);
        assertEquals(GoldenDelicious.class, sevastopolApples[0].getClass());

        sevastopolApples = sevastopolFarm.createFruits(FruitVariety.REINETTE_SIMIRENKO, 5);
        assertEquals(5, sevastopolApples.length);
        assertEquals(ReinetteSimirenko.class, sevastopolApples[0].getClass());

        Fruit[] sevastopolGrapes = sevastopolFarm.createFruits(FruitVariety.ARCADIA, 5);
        assertEquals(5, sevastopolGrapes.length);
        assertEquals(Arcadia.class, sevastopolGrapes[0].getClass());

        sevastopolGrapes = sevastopolFarm.createFruits(FruitVariety.RIZAMAT, 5);
        assertEquals(5, sevastopolGrapes.length);
        assertEquals(Rizamat.class, sevastopolGrapes[0].getClass());

        sevastopolGrapes = sevastopolFarm.createFruits(FruitVariety.HELIOS, 5);
        assertEquals(5, sevastopolGrapes.length);
        assertEquals(Helios.class, sevastopolGrapes[0].getClass());
    }
}
