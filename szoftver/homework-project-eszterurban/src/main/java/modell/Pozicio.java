package modell;

/**
 * Egy rekord a pozíció tárolására.
 * @param sor Sor index
 * @param oszl Oszlop index
 */
public record Pozicio(int sor, int oszl) {
    /**
     * @return A pozíciót adja vissza megformázva.
     */
    public String toString(){
        return String.format("(%d,%d)",sor,oszl);
    }
}
