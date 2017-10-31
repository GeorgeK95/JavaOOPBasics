package onlineRadioDatabase;

import onlineRadioDatabase.exceptions.*;

import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class Song {
    private String songName;
    private String artistName;
    private int minutes;
    private int seconds;

    Song(String artistName, String songName, String minutes, String seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(minutes, seconds);
    }

    private void setLength(String minutes, String seconds) {
        int minutesInt;
        int secondsInt;
        try {
            minutesInt = Integer.valueOf(minutes);
            secondsInt = Integer.valueOf(seconds);
        } catch (NumberFormatException nfe) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        this.setMinutes(minutesInt);
        this.setSeconds(secondsInt);
    }

    static String getAlbumLength(List<Song> album) {
        int secondsStream = album.stream().mapToInt(Song::getSeconds).sum();
        int seconds = secondsStream % 60;
        int bonusMinutes = secondsStream / 60;

        int minutesStreamAndBonus = album.stream().mapToInt(Song::getMinutes).sum() + bonusMinutes;
        int minutes = minutesStreamAndBonus % 60;
        int hours = minutesStreamAndBonus / 60;

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }

    private String getSongName() {
        return songName;
    }

    private void setSongName(String songName) {
        int length = songName.length();
        if (length < 3 || length > 20) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) {
        int length = artistName.length();
        if (length < 3 || length > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private int getMinutes() {
        return minutes;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    private int getSeconds() {
        return seconds;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }
}
