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
public class AlbumDBTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        Album a1 = new Album("Afraid of Heights", "Billy Talent", 750000, 12, 4.3, 'L', false);
        Album a2 = new Album("Best Buds", "Mom Jeans.", 50000, 10, 4.5, 'E', false);
        Album a3 = new Album("This Album Name is Really Long", "This Artist Name is Really Long", 12, 3, 2.5, 'E', true);
        Album a4 = new Album();
        Album albumHolder;
        
        
        AlbumDatabase albumDB = new AlbumDatabase();
        albumDB.saveAlbum(a1);
        albumDB.saveAlbum(a2);
        albumDB.saveAlbum(a3);
        
        albumHolder = albumDB.getAlbum(0);
        assert a1.equals(albumHolder);
        System.out.println(albumHolder.toString());
        
        albumDB.albumUpdate(0, a2);
        albumHolder = albumDB.getAlbum(0);
        assert a2.equals(albumHolder);
        System.out.println(albumHolder.toString());
        
        albumDB.albumUpdate(0, a1);
        System.out.println(a4.isValid());
        albumDB.saveAlbum(a4);
        
        albumDB.closeDatabase();
    }
    
}
