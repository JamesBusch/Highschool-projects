/*
 * James Busch
 * ICS4U
 * 05/06/18
 * Album object
 * holds all data about a album 
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u6;

import java.util.Objects;

/**
 *
 * @author jamers444
 */
public class Album {
    private String albumName;
    private String artistName;
    private int albumSales = 0;
    private int amountOfTracks = 0;
    private double raiting = 0;
    private char longPlay = 'N';
    private boolean clean = false; 

    /**
     * amount of characters in the albums name
     */
    public static final int ALBUM_NAME_SIZE = 17;

    /**
     * amount of characters the artists name
     */
    public static final int ARTIST_NAME_SIZE = 15;

    /**
     * total byte size of the album
     */
    public static final int ALBUM_SIZE = 83;
    
    
    StringBuilder sb;
    
    /**
     * sets all vales to default values if empty
     */
    public Album(){
        setAlbumName(null);
        setArtistName(null);
        setAlbumSales(0);
        setAmountOfTracks(0);
        setRaiting(0);
        setLongPlay('n');
        setClean(true);
    }
    
    /**
     *
     * @param albumName Name of the album 17 chars long
     * @param artistName Name of artist 15 chars long
     * @param albumSales Sales of the album
     * @param amountOfTracks Amount of tracks
     * @param raiting the albums raiting
     * @param longPlay if it is a EP or LP
     * @param clean if the album is clean or explicit 
     */
    public Album(String albumName, String artistName, int albumSales, int amountOfTracks, double raiting, char longPlay, boolean clean){
        setAlbumName(albumName);
        setArtistName(artistName);
        setAlbumSales(albumSales);
        setAmountOfTracks(amountOfTracks);
        setRaiting(raiting);
        setLongPlay(longPlay);
        setClean(clean);
    }

    /**
     *
     * @return the albums name
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * sets the albums title and makes it the correct length
     * @param albumName the albums title
     */
    public void setAlbumName(String albumName) {
        sb = new StringBuilder();
        if ( albumName != null ) {
            sb.append( albumName.trim() );
        } else {
            sb.append( "TBD".trim() );
        }

        // trucates or pads the string
        sb.setLength( ALBUM_NAME_SIZE );
        this.albumName = sb.toString();
    }

    /**
     * gets the artists name
     * @return the artists name
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * gets the artists name and sets it to the correct length
     * @param artistName takes the artist name
     */
    public void setArtistName(String artistName) {
        sb = new StringBuilder();
        if ( artistName != null ) {
            sb.append( artistName.trim() );
        } else {
            sb.append( "TBD".trim() );
        }

        // trucates or pads the string
        sb.setLength( ARTIST_NAME_SIZE );
        this.artistName = sb.toString();
    }

    /**
     * gets the amount of records sold
     * @return the amount of record sales
     */
    public int getAlbumSales() {
        return albumSales;
    }

    /**
     * setting current record sales
     * @param albumSales how many copies the record has sold
     */
    public void setAlbumSales(int albumSales) {
        this.albumSales = albumSales;
    }

    /**
     * getting the amount of tracks on a record
     * @return the amount of tracks on the record
     */
    public int getAmountOfTracks() {
        return amountOfTracks;
    }

    /**
     * sets the amount of songs on a album
     * @param amountOfTracks amount of tracks of the record
     */
    public void setAmountOfTracks(int amountOfTracks) {
        this.amountOfTracks = amountOfTracks;
    }

    /**
     *
     * @return the raiting of the album
     */
    public double getRaiting() {
        return raiting;
    }

    /**
     * Sets the albums raiting
     * @param raiting the raiting of the album
     */
    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    /**
     * gets the char representing ep or lp
     * @return E for ep and L for lp
     */
    public char getLongPlay() {
        return longPlay;
    }

    /**
     * sets the char for LP or EP
     * @param longPlay if it is a LP or EP
     */
    public void setLongPlay(char longPlay) {
        this.longPlay = longPlay;
    }

    /**
     * checks if the album is clean
     * @return if the album is clean
     */
    public boolean isClean() {
        return clean;
    }

    /**
     * sets if the album is clean or explicit
     * @param clean if the album is clean or explicit
     */
    public void setClean(boolean clean) {
        this.clean = clean;
    }   
    
    public boolean isValid(){
        boolean valid = true;
        if(this.albumName.trim().equals("TBD") || this.artistName.trim().equals("TBD"))valid = false;
        return valid;
    }

    @Override
    public String toString() {
        return "Album{" + "albumName=" + albumName + ", artistName=" + artistName + ", albumSales=" + albumSales + ", amountOfTracks=" + amountOfTracks + ", raiting=" + raiting + ", longPlay=" + longPlay + ", clean=" + clean + '}';
    }
    
    
    
    public boolean equals(Album album) {
        if(this.isValid() && album.isValid()){
            if(this.albumName.equals(album.getAlbumName())){
                if(this.artistName.equals(album.getArtistName())){
                    if(this.amountOfTracks == album.getAmountOfTracks()){
                        if(this.albumSales == album.getAlbumSales()){
                            if(this.raiting == album.getRaiting()){
                                if(this.longPlay == album.getLongPlay()){
                                    if(this.clean == album.isClean()) return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    
}
