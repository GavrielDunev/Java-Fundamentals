package VehicleCatalogue;

public class Car {
    private String model;
    private String color;
    private int horsepower;
    private String type = "Car";

    public Car(String model, String color, int horsepower) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" + "Model: %s%n" + "Color: %s%n" + "Horsepower: %d"
                , this.type, this.model, this.color, this.horsepower);
    }
}