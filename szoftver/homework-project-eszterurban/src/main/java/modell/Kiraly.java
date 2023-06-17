package modell;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

/**
 * Egy osztály a Király objectumnak.
 */
public class Kiraly {
    /**
     * Egy Wrapper Pozíció típussal a Királynak.
     */
    private ReadOnlyObjectWrapper<Pozicio> pozicio;

    /**
     * Konstrukrol a Király osztálynak.
     * @param pozicio A Király pozícióját állítja be.
     */
    public Kiraly(Pozicio pozicio) {
        this.pozicio = new ReadOnlyObjectWrapper<>(pozicio);
    }

    /**
     * Visszaadja a csak olvasható tulajdonságát a pozíciónak az objectumról.
     * @return csak olvasható tulajdonság a pozícióról.
     */
    public ReadOnlyObjectProperty<Pozicio> pozicioProperty() {
        return pozicio.getReadOnlyProperty();
    }

    /**
     * Getter a Király pozíciójára.
     * @return Király pozíciójára
     */
    public Pozicio getPozicio() {
        return pozicio.get();
    }

    /**
     * Setter a Király pozíciójára.
     * @param p Pozíció beállítása {@code p}
     */
    public void setPozicio(Pozicio p) {
        pozicio.set(p);
    }
}
