/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blesku
 */
public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuPaateOlemassa() {
        assertTrue(paate != null);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kassapaatteenSaldoAlussaOikein() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void edullisetAlussaOikein() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaatAlussaOikein() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiJosRahaaRiittavastiEdullinen() {
        assertEquals(260, paate.syoEdullisesti(500));
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiJosRahaaEiOleRiittavastiEdullinen() {
        assertEquals(150, paate.syoEdullisesti(150));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiJosRahaaRiittavastiMaukkaasti() {
        assertEquals(100, paate.syoMaukkaasti(500));
        assertEquals(100400, paate.kassassaRahaa());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiJosRahaaEiOleRiittavastiMaukkaasti() {
        assertEquals(300, paate.syoMaukkaasti(300));
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    /// Kortti+pääte -testit
    @Test
    public void korttiostoToimiiJosRahaaRiittavastiEdullinen() {
        assertEquals(true, paate.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiJosRahaaEiOleRiittavastiEdullinen() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(false, paate.syoEdullisesti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiJosRahaaRiittavastiMaukkaasti() {
        assertEquals(true, paate.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiostoToimiiJosRahaaEiOleRiittavastiMaukkaasti() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertEquals(false, paate.syoMaukkaasti(kortti));
        assertEquals(200, kortti.saldo());
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kassassaOlevanRahanMaaraEiMuutuKortillaOstaessa() {
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void lataaRahaaKortilleToimii() {
        paate.lataaRahaaKortille(kortti, 260);
        assertEquals(100260, paate.kassassaRahaa());
        assertEquals(1260, kortti.saldo());

    }

    @Test
    public void lataaRahaaKortilleToimiiJosSummaOnNolla() {
        paate.lataaRahaaKortille(kortti, -1);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(1000, kortti.saldo());

    }

}
