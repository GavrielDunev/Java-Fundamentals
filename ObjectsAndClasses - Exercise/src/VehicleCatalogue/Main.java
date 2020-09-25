package VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Car> cars = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();
        int sumCarHorsepower = 0;
        int sumTruckHorsepower = 0;
        while (!input.equals("End")) {
            String[] vehicleInfo = input.split(" ");
            String type = vehicleInfo[0];
            String model = vehicleInfo[1];
            String color = vehicleInfo[2];
            int horsepower = Integer.parseInt(vehicleInfo[3]);
            if (type.equals("car")) {
                Car car = new Car(model, color, horsepower);
                cars.add(car);
                sumCarHorsepower += horsepower;
            } else {
                Truck truck = new Truck(model, color, horsepower);
                trucks.add(truck);
                sumTruckHorsepower += horsepower;
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue")) {
            for (Truck truck : trucks) {
                if (input.equals(truck.getModel())) {
                    System.out.println(truck);
                    break;
                }
            }
            for (Car car : cars) {
                if (input.equals(car.getModel())) {
                    System.out.println(car);
                    break;
                }
            }
            input = scanner.nextLine();
        }
        double averageCarHorsepower = sumCarHorsepower * 1.0 / cars.size();
        double averageTruckHorsepower = sumTruckHorsepower * 1.0 / trucks.size();
        if (cars.size() <= 0) {
            averageCarHorsepower = 0;
        }
        if (trucks.size() <= 0) {
            averageTruckHorsepower = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTruckHorsepower);
    }
}
