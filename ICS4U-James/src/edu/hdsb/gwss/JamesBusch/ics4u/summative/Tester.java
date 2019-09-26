package edu.hdsb.gwss.JamesBusch.ics4u.summative;

/**
 * Open Hash Table Tester
 *
 * @version v2016.S2
 */
public class Tester {

    /**
     */
    public static void main( String[] args ) {

        CSStudent studentAA1 = new CSStudent( "Arielle", "A", 7111, 11 );
        CSStudent studentAA2 = new CSStudent( "Ali", "A", 2221, 12 );
        CSStudent studentJB = new CSStudent( "James", "B", 2332, 12 );
        CSStudent studentRD = new CSStudent( "Raidi", "D", 1443, 12 );
        CSStudent studentAE = new CSStudent( "Ahmad", "E", 2554, 12 );
        CSStudent studentJG = new CSStudent( "Gillian", "J", 6665, 12 );
        CSStudent studentYK = new CSStudent( "Yulia", "K", 7976, 12 );
        CSStudent studentRL = new CSStudent( "Ryan", "L", 8387, 12 );
        CSStudent studentRM = new CSStudent( "Ruiling", "M", 9098, 11 );
        CSStudent studentYM = new CSStudent( "Youssef", "M", 1120, 12 );
        CSStudent studentFS = new CSStudent( "Faisal", "S", 2231, 12 );
        CSStudent studentKSE = new CSStudent( "Karim", "SE", 8695, 12 );
        CSStudent studentMS = new CSStudent( "Matthew", "S", 3695, 12 );
        CSStudent studentCW = new CSStudent( "Christiana", "W", 2691, 12 );
        CSStudent studentEX = new CSStudent( "Ellie", "X", 1234, 11 );
        CSStudent studentIY = new CSStudent( "Irmak", "Y", 1234, 12 );
        
        OpenHashTable ht = new OpenHashTable();
        
        assert ht.containsKey(5) == false;
        assert ht.size() == 0;
        
        ht.put(studentAA1);
        assert ht.containsKey(7111);
        ht.put(studentAA2);
        assert ht.containsKey(2221);
        ht.put(studentJB);
        assert ht.containsKey(2332);
        ht.put(studentRD);
        assert ht.containsKey(1443);
        ht.put(studentAE);
        assert ht.containsKey(2554);
        ht.put(studentJG);
        assert ht.containsKey(6665);
        ht.put(studentYK);
        assert ht.containsKey(7976);
        ht.put(studentRL);
        assert ht.containsKey(8387);
        ht.put(studentRM);
        assert ht.containsKey(9098);
        ht.put(studentYM);
        assert ht.containsKey(1120);
        ht.put(studentFS);
        assert ht.containsKey(2231);
        ht.put(studentKSE);
        assert ht.containsKey(8695);
        ht.put(studentMS);
        assert ht.containsKey(3695);
        
        System.out.println( ht.toString() );

    }

}
