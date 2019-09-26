/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u6;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author jamers444
 */
public class ReadTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        File file = new File(".//data//Album//album.dat");
        RandomAccessFile recordFile = new RandomAccessFile(file, "rw");
        
        Album a2 = new Album();
        
        int id = 2;
        long filePointer = (id - 1) * Album.ALBUM_SIZE;
        
        recordFile.seek(filePointer);
        
        char albumName[] = new char[Album.ALBUM_NAME_SIZE];
        for( int i=0; i < Album.ALBUM_NAME_SIZE; i++ ) {
            albumName[i] = recordFile.readChar();
        }
        a2.setAlbumName(new String( albumName ) );
        
        
        char artistName[] = new char[Album.ARTIST_NAME_SIZE];
        for( int i=0; i < Album.ARTIST_NAME_SIZE; i++ ) {
            artistName[i] = recordFile.readChar();
        }
        a2.setArtistName(new String( artistName ) );
        
        a2.setAlbumSales(recordFile.readInt());
        a2.setAmountOfTracks(recordFile.readInt());
        a2.setRaiting(recordFile.readDouble());
        a2.setLongPlay(recordFile.readChar());
        a2.setClean(recordFile.readBoolean());
        
        System.out.println(a2.getAlbumName());
        System.out.println(a2.getArtistName());
        System.out.println(a2.getAlbumSales());
        System.out.println(a2.getAmountOfTracks());
        System.out.println(a2.getRaiting());
        System.out.println(a2.getLongPlay());
        System.out.println(a2.isClean());
        
        recordFile.close();
        
    }
    
}