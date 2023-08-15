package songApplication;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private String artistName;
    private List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();

    }

    public boolean findSongByTitle(String title){

        // Iterating over the Song List
        for(Song song : songList){
            if(song.getTitle().equals(title)){
                return true;
            }
        }

        // Unable to find the song
        return false;
    }

    public String addNewSongToAlbum(String title, Double duration){

        if(findSongByTitle(title)){
            return "Song is already added.";
        }

        Song song = new Song(title,duration);
        this.songList.add(song);
        return "Song has been added Successfully";
    }

    public String addSongToPlayList(int songNo, ArrayList<Song> playList){

        //Add this songNo (album songList -> songNo)
        //songNo 1 2 3 4 5
        // index 0 1 2 3 4

        int index = songNo-1;

        if(index>=0 && index<songList.size()){

            Song song = songList.get(index);
            playList.add(song);
            return "Song added to playList Successfully";
        }
        else {
            return "Song No entered is out of range";
        }
    }

    public String addSongToPlayList(String title, ArrayList<Song> playList){

        // Assuming song is present in the songList
        for(Song song: songList){

            if(song.getTitle().equals(title)){
                playList.add(song);
                return "Song added to playList";
            }
        }

        return "No song found with given title";
    }
}
