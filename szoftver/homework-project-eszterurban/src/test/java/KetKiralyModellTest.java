import modell.KetKiralyModell;
import modell.Negyzet;
import modell.Pozicio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KetKiralyModellTest {
    KetKiralyModell model = new KetKiralyModell();

    @Test
    public void a_nyeres_helyes(){
        model.haFeherKiraly = true;
        model.Nyertes();
        assertEquals("Fekete", model.neveaNyertesnek);

        model.haFeherKiraly = false;
        model.Nyertes();
        assertEquals("Fehér", model.neveaNyertesnek);
    }
    @Test
    public void random_negyzet_helyes(){
        int initialEmptySquareCount = model.uresNegyzetPozicio.size();
        model.lepes(new Pozicio(1, 1));
        int updatedEmptySquareCount = model.uresNegyzetPozicio.size();
        assertEquals(initialEmptySquareCount - 1, updatedEmptySquareCount);

        model.uresNegyzetPozicio.clear();
        var rand_freeSquare = model.randomUresNegyzet();
        assertNull(rand_freeSquare);
    }
    @Test
    public void test_lepes_metodus(){
        assertTrue(model.haFeherKiraly);
        model.lepes(new Pozicio(3,1));
        assertFalse(model.haFeherKiraly);
        model.lepes(new Pozicio(4,6));
        assertTrue(model.haFeherKiraly);

        model.lepes(new Pozicio(0,0));
        assertEquals(model.getFeherKiraly().getPozicio(),model.getFeherKiraly().getPozicio());
        model.lepes(new Pozicio(3,2));

        model.lepes(new Pozicio(0,0));
        assertEquals(model.getFeketeKiraly().getPozicio(),model.getFeketeKiraly().getPozicio());
        model.lepes(new Pozicio(4,5));
    }
    @Test
    public void negyzet_allapot_test(){
        assertEquals(Negyzet.URES, model.squareProperty(0, 0).get());
        model.setNegyzet(new Pozicio(0, 0), Negyzet.NINCS);
        assertEquals(Negyzet.NINCS, model.squareProperty(0, 0).get());
    }

    @Test
    public void get_lehetseges_lepes_test(){
        KetKiralyModell model = new KetKiralyModell();

        model.getFeherKiraly().setPozicio(new Pozicio(3, 3));
        model.getFeketeKiraly().setPozicio(new Pozicio(5, 5));

        ArrayList<Pozicio> lehetsegesLepes = model.getLehetsegesLepes(model.getFeherKiraly().getPozicio(), model.getFeketeKiraly().getPozicio());

        assertEquals(7, lehetsegesLepes.size());

        assertTrue(lehetsegesLepes.contains(new Pozicio(2, 2)));
        assertTrue(lehetsegesLepes.contains(new Pozicio(2, 3)));
        assertTrue(lehetsegesLepes.contains(new Pozicio(2, 4)));
        assertTrue(lehetsegesLepes.contains(new Pozicio(3, 2)));
        assertTrue(lehetsegesLepes.contains(new Pozicio(3, 4)));
        assertTrue(lehetsegesLepes.contains(new Pozicio(4, 2)));
        assertTrue(lehetsegesLepes.contains(new Pozicio(4, 3)));
    }

    @Test
    public void ha_kiraly_mozog_test() {
        KetKiralyModell model = new KetKiralyModell();

        Pozicio from1 = new Pozicio(3, 3);
        Pozicio to1 = new Pozicio(4, 4);
        boolean result1 = model.haKiralyMozog(from1, to1);
        assertTrue(result1);

        Pozicio from2 = new Pozicio(3, 3);
        Pozicio to2 = new Pozicio(5, 5);
        boolean result2 = model.haKiralyMozog(from2, to2);
        assertFalse(result2);
    }
}
