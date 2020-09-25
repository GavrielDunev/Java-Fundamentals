package OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("End")) {
            String[] info = input.split(" ");
            String name = info[0];
            String id = info[1];
            int age = Integer.parseInt(info[2]);
            Person person = new Person(name, id, age);
            people.add(person);
            input = scanner.nextLine();
        }
        people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(p -> System.out.println(p.toString()));
    }
}
