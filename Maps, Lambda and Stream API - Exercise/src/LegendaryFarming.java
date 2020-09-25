import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean isObtained = false;
        while (!isObtained) {
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < input.length; i+= 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                if (keyMaterials.containsKey(material)) {
                    int currentCount = keyMaterials.get(material);
                    keyMaterials.put(material, currentCount + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        switch (material) {
                            case "shards":
                                keyMaterials.put("shards", currentCount + quantity - 250);
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                keyMaterials.put("fragments", currentCount + quantity - 250);
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                keyMaterials.put("motes", currentCount + quantity - 250);
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        isObtained = true;
                    }
                } else {
                    junkMaterials.putIfAbsent(material, 0);
                    int currentCount = junkMaterials.get(material);
                    junkMaterials.put(material, currentCount + quantity);
                }
                if (isObtained) {
                    break;
                }
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((m1, m2) -> {
                    int result = m2.getValue().compareTo(m1.getValue());
                    if (result == 0) {
                        result = m1.getKey().compareTo(m2.getKey());
                    }
                    return result;
                })
                .forEach(m -> System.out.println(String.format("%s: %d", m.getKey(), m.getValue())));

        junkMaterials.forEach((k,v) -> System.out.println(String.format("%s: %d", k, v)));
    }
}