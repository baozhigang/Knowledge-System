import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jukebox5 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {

    }

    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);

        System.out.println(songList);
    }

    void getSongs() {
        //
    }

    void addSong(String lineToParse) {
        //
    }
}
