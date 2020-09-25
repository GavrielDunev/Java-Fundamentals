import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mileage = new LinkedHashMap<>();
        Map<String, Integer> fuel = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String carName = input[0];
            int carMileage = Integer.parseInt(input[1]);
            int carFuel = Integer.parseInt(input[2]);
            mileage.put(carName, carMileage);
            fuel.put(carName, carFuel);
        }
        String[] input = scanner.nextLine().split(" : ");
        while (!"Stop".equals(input[0])) {
            String command = input[0];
            String car = input[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(input[2]);
                    int gasoline = Integer.parseInt(input[3]);
                    if (gasoline > fuel.get(car)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        mileage.put(car, mileage.get(car) + distance);
                        fuel.put(car, fuel.get(car) - gasoline);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, gasoline);
                        if (mileage.get(car) >= 100000) {
                            mileage.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                    break;
                case "Refuel":
                    gasoline = Integer.parseInt(input[2]);
                    if (fuel.get(car) + gasoline > 75) {
                        gasoline = 75 - fuel.get(car);
                        fuel.put(car, 75);
                    } else {
                        fuel.put(car, fuel.get(car) + gasoline);
                    }
                    System.out.printf("%s refueled with %d liters%n", car, gasoline);
                    break;
                case "Revert":
                    distance = Integer.parseInt(input[2]);
                    if (mileage.get(car) - distance < 10000) {
                        mileage.put(car, 10000);
                    } else {
                        mileage.put(car, mileage.get(car) - distance);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, distance);
                    }
                    break;
            }
            input = scanner.nextLine().split(" : ");
        }
        mileage.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    int result = c2.getValue().compareTo(c1.getValue());
                    if (result == 0) {
                        result = c1.getKey().compareTo(c2.getKey());
                    }
                    return result;
                })
                .forEach(car -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car.getKey(), car.getValue(), fuel.get(car.getKey())));
    }
}