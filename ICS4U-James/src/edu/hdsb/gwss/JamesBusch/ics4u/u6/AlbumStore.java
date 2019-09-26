/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u6;

/**
 *
 * @author jamers444
 */
import java.io.*;

public class AlbumStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        File file = new File(".//data//Album//album.dat");
        
        RandomAccessFile recordFile = new RandomAccessFile(file, "rw");
        
        recordFile.seek(recordFile.length());
        
        Album a1 = new Album("Best Buds", "Mom Jeans", 100000, 11, 4.5, 'E', false);
        Album a2 = new Album("Afraid of Heights", "Billy Talent", 800000, 12, 4.0, 'L', true);
        Album a3 = new Album("Foo Fighters", "Foo Fighters", 10000000, 12, 5.0, 'L', false);
        AlbumDatabase j = new AlbumDatabase();
        
        j.saveAlbum(a1);
        j.saveAlbum(a2);
        j.saveAlbum(a3);
        
        j.closeDatabase();
//        System.out.println(recordFile.length());
//        
//        recordFile.writeChars(a1.getAlbumName());
//        recordFile.writeChars(a1.getArtistName());
//        recordFile.writeInt(a1.getAlbumSales());
//        recordFile.writeInt(a1.getAmountOfTracks());
//        recordFile.writeDouble(a1.getRaiting());
//        recordFile.writeChar(a1.getLongPlay());
//        recordFile.writeBoolean(a1.isClean());
//        
//        System.out.println(recordFile.length());
//        
//        recordFile.writeChars(a2.getAlbumName());
//        recordFile.writeChars(a2.getArtistName());
//        recordFile.writeInt(a2.getAlbumSales());
//        recordFile.writeInt(a2.getAmountOfTracks());
//        recordFile.writeDouble(a2.getRaiting());
//        recordFile.writeChar(a2.getLongPlay());
//        recordFile.writeBoolean(a2.isClean());
//        
//        System.out.println(recordFile.length());
//        
//        recordFile.writeChars(a3.getAlbumName());
//        recordFile.writeChars(a3.getArtistName());
//        recordFile.writeInt(a3.getAlbumSales());
//        recordFile.writeInt(a3.getAmountOfTracks());
//        recordFile.writeDouble(a3.getRaiting());
//        recordFile.writeChar(a3.getLongPlay());
//        recordFile.writeBoolean(a3.isClean());
////        
//        System.out.println(recordFile.length());
        
        //recordFile.close();
    }
    
}
