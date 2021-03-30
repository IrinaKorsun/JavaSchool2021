package my.inheritance;

public class F1Car extends Car {
    public void pitStop() {
        //... пит-стоп делают только гоночные машины
    }

    public F1Car(String model, int maxSpeed, int yearOfManufacture) {
        super(model, maxSpeed, yearOfManufacture);
    }

    public F1Car() {
        System.out.println("Invoked F1");
    }

    @Override
    public void gas() {
        System.out.println("Invoked gas in F1");
        super.gas();
    }
}
