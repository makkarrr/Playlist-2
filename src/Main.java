import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Gloria","Sam Smith");
        album1.addSong(new Song("Unholy","Sam Smith", 2));
        album1.addSong(new Song("Perfect","Sam Smith", 3));
        album1.addSong(new Song("Gloria", "Sam Smith",2));

        Album album2 = new Album("Honestly, Nevermind", "Drake");
        album2.addSong(new Song("Her Loss","Drake", 1));
        album2.addSong(new Song("Views","Drake", 1));
        album2.addSong(new Song("Take Care", "Drake",2));

        PlayList myPlaylist = new PlayList("myPlaylist");
        myPlaylist.addSongFromAlbum(album1, "Unholy"); //unholy
        myPlaylist.addSongFromAlbum(album1,"Gloria"); //gloria
        myPlaylist.addSongFromAlbum(album2, "Her Loss"); //her loss
        myPlaylist.addSongFromAlbum(album2, "Take Care"); //take care

        System.out.println(myPlaylist.currentSong()); //unholy

        System.out.println(myPlaylist.playPrevious()); // nothing

        System.out.println(myPlaylist.playNext()); //gloria

        System.out.println(myPlaylist.playNext()); //her loss

        System.out.println(myPlaylist.playPrevious()); //gloria

        System.out.println(myPlaylist.playNext());

        System.out.println(myPlaylist.currentSong()); //unholy
        // her loss
    }
}