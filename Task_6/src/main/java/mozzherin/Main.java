package mozzherin;

import mozzherin.factory.HomeAppliancesFactory;
import mozzherin.factory.MieleFactory;
import mozzherin.factory.SamsungFactory;

public class Main {
    public static void main(String[] args) {
        HomeAppliancesFactory samsungFactory = new SamsungFactory();
        HomeAppliancesFactory mieleFactory = new MieleFactory();

        samsungFactory.createDishwasher(4.4, 6);
        samsungFactory.createFridge(50, 2);

        mieleFactory.createDishwasher(5.0, 8);
        mieleFactory.createFridge(45, 2);
    }
}
