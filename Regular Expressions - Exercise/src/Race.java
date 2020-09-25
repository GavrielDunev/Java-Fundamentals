import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        String regexName = "(?<name>[A-Za-z])";
        String regexKm = "(?<km>[0-9])";
        Pattern patternName = Pattern.compile(regexName);
        Pattern patternKm = Pattern.compile(regexKm);
        Map<String, Integer> contestants = new LinkedHashMap<>();
        while (!"end of race".equals(input)) {
            StringBuilder sb = new StringBuilder();
            Matcher matcherName = patternName.matcher(input);
            while (matcherName.find()) {
                sb.append(matcherName.group());
            }
            if (participants.contains(sb.toString())) {
                Matcher matcherKm = patternKm.matcher(input);
                int countKm = 0;
                while (matcherKm.find()) {
                    countKm += Integer.parseInt(matcherKm.group());
                }
                contestants.putIfAbsent(sb.toString(), 0);
                int totalKm = contestants.get(sb.toString()) + countKm;
                contestants.put(sb.toString(), totalKm);
            }
            input = scanner.nextLine();
        }
        List<String> places = new ArrayList<>();
        places.add("1st place: ");
        places.add("2nd place: ");
        places.add("3rd place: ");
        contestants.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .limit(3)
                .forEach(c -> System.out.println(places.remove(0) + c.getKey()));
    }
}