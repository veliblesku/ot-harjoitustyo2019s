package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(40);
        kortti.lataaRahaa(70);
        assertEquals("saldo: 1.20", kortti.toString());
    }

    @Test
    public void saldoVaheneeOikeinJosRahaaTarpeeksi() {
        kortti.otaRahaa(3);
        assertEquals("saldo: 0.7", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void trueJosRahaaTarpeeksi() {
        assertEquals(true, kortti.otaRahaa(5));
    }

    @Test
    public void falseJosRahaaEiTarpeeksi() {
        assertEquals(false, kortti.otaRahaa(15));
    }

}
