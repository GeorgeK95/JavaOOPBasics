package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.InvalidSongException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Song> album = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String pattern = "(.*);(.*);(.*):(.*)";
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            Matcher m = Pattern.compile(pattern).matcher(line);
            while (m.find()) {
                String artist = m.group(1);
                String songName = m.group(2);
                String min = m.group(3);
                String sec = m.group(4);
                try {
                    Song song = new Song(artist, songName, min, sec);
                    album.add(song);
                    System.out.println("Song added.");
                } catch (InvalidSongException ise) {
                    System.out.println(ise.getMessage());
                }
            }
        }

        print(album);
    }

    private static void print(List<Song> album) {
        System.out.println("Songs added: " + album.size());
        System.out.println(Song.getAlbumLength(album));
    }
}
