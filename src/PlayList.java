import java.util.*;

public class PlayList {
    private String title;
    private List<Song> songs;

    private boolean wasNext = false;

    private ListIterator<Song> itr;

    public PlayList(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
        itr = songs.listIterator();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    // add song to playlist from album
    public String addSongFromAlbum(Album album, String songName) {
//        Boolean songExists = album.findSong(songName); // O(N)
//        Song song;
//        if(songExists) {
//            album.searchSong(songName); // O(N)
//        }

        // both information together - True/False and Song using Optional
        Optional<Song> songOpt = album.searchSong(songName);
        if(songOpt.isEmpty()) { // !songOpt.isPresent()
            return "Song not found in album";
        }

        // Optional.of()
        // Optional.empty()
        // opt.isEmpty()
        // opt.get()

        Song songInAlbum = songOpt.get(); // list.get(0)
        this.songs.add(songInAlbum);
        itr = songs.listIterator();
        return "Song added Successfully";
    }

    public String playNext() {
        if(wasNext) { // true
        }
        if(!wasNext) { // was previous is true
            wasNext = true;
            itr.next();
        }
        if(itr.hasNext()) {
            wasNext = true;
            Song song = itr.next();
            return "Next Song is:" + song;
        }

        return "You have reached end of playlist";
    }

    public String playPrevious() {
        if(!wasNext) { // true
        }
        if(wasNext) {
            wasNext = false;
            itr.previous();
        }
        if(itr.hasPrevious()) {
            wasNext = false;
            Song song = itr.previous();
            return "Previous Song is:" + song;
        }
        return "You have reached start of playlist. No song before this";
    }

    public String currentSong() {
        if(wasNext) {
            wasNext = false;
            return "current song is " + itr.previous();
        }
        wasNext = true;
        return "current song is " + itr.next();
    }

    // addSongByTrackNumber
    // deleteSongFromPlayList
    // add check if song in playlist already, don't add it and return relevant information
}
