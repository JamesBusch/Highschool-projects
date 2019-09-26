/*
 * James Busch
 * ICS4U
 * 05/06/18
 * Album Database
 * takes a albums data from the object and 
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u6;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author jamers444
 */
public class AlbumDatabase{
    
    File file = new File(".//data//albumDatabase//albumdata.dat");
    RandomAccessFile recordFile = new RandomAccessFile(file, "rw");
    
    private long pointer;
   
    /**
     * Empty constructor sets default file and opens RAF
     * 
     * @throws Exception io exception
     */
    public AlbumDatabase() throws Exception{
        pointer = recordFile.length();
        openDB(file);
    }
    
    /**
     * Constructor that takes in file that the user wants to use as the data base
     * 
     * @param file takes in file object that user wants to store data in
     * @throws Exception io exception
     */
    public AlbumDatabase(File file)throws Exception{
        openDB(file);
    }
    
    /**
     * takes in a id and album object and writes over the current album sitting there
     * 
     * @param id where the wanted album is stored in the RAF
     * @param album the new data to overwrite the existing data
     * @throws Exception io exception
     */
    public void albumUpdate(int id, Album album)throws Exception{
        pointer = id * Album.ALBUM_SIZE;
        if(album != null && album.isValid() && pointer <= recordFile.length()){
            recordFile.seek(this.pointer);
            writeData(album);
        }else{
            System.out.println("Album is invalid");
        }
    }
    
    /**
     * saves album all the way to the end of the file
     * 
     * @param album takes in album object
     * @throws Exception io exception
     */
    public void saveAlbum(Album album)throws Exception{
        if(album != null && album.isValid()){
            pointer = recordFile.length();
            recordFile.seek(pointer);
            System.out.println(pointer);
            writeData(album); 
        }else{
            System.out.println("Album is not valid");
        }
    }
    
    /**
     * opens database using given file
     * 
     * @param file takes in file to open data base
     * @throws Exception io exception
     */
    public void openDB(File file)throws Exception{
        if(file != null){
            RandomAccessFile recordFile = new RandomAccessFile(file, "rw");
        }else{
            RandomAccessFile recordFile = new RandomAccessFile(this.file, "rw");
        }
    }
    
    /**
     * gets a album object at the given id and returns the album
     * 
     * @param id where the album is stored
     * @return the album with the data at the given id
     * @throws Exception io exception
     */
    public Album getAlbum(int id)throws Exception{
        pointer = id * Album.ALBUM_SIZE;
        recordFile.seek(this.pointer);
        
        Album albumHolder = new Album();
        
        char albumName[] = new char[Album.ALBUM_NAME_SIZE];
        for( int i=0; i < Album.ALBUM_NAME_SIZE; i++ ) {
            albumName[i] = recordFile.readChar();
        }
        
        char artistName[] = new char[Album.ARTIST_NAME_SIZE];
        for( int i=0; i < Album.ARTIST_NAME_SIZE; i++ ) {
            artistName[i] = recordFile.readChar();
        }
        albumHolder.setAlbumName(new String( albumName ) );
        albumHolder.setArtistName(new String( artistName ) );
        albumHolder.setAlbumSales(recordFile.readInt());
        albumHolder.setAmountOfTracks(recordFile.readInt());
        albumHolder.setRaiting(recordFile.readDouble());
        albumHolder.setLongPlay(recordFile.readChar());
        albumHolder.setClean(recordFile.readBoolean());
        return albumHolder;
    }
    
    /**
     * closes database
     * 
     * @throws Exception io exception
     */
    public void closeDatabase()throws Exception{
        recordFile.close();
    }

    /**
     * Takes in a album and writes it to the RAF
     * 
     * @param album to write to the RAF
     * @throws Exception io exception
     */
    private void writeData(Album album)throws Exception{
        if(album.isValid()){
        recordFile.writeChars(album.getAlbumName());
        recordFile.writeChars(album.getArtistName());
        recordFile.writeInt(album.getAlbumSales());
        recordFile.writeInt(album.getAmountOfTracks());
        recordFile.writeDouble(album.getRaiting());
        recordFile.writeChar(album.getLongPlay());
        recordFile.writeBoolean(album.isClean());
        }else{
            System.out.println("Album not vaild");
        }
    }
    
    
}
