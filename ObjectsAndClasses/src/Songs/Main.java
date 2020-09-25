package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scanner.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];
            Song song = new Song();
            song.setTypeList(typeList);
            song.setName(name);
            song.setTime(time);
            songs.add(song);
        }
        String type = scanner.nextLine();
        for (Song song : songs) {
            if (type.equals("all")) {
                System.out.println(song.getName());
            } else if (type.equals(song.getTypeList())) {
                System.out.println(song.getName());
            }
        }
    }
}
