package modell;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import org.tinylog.Logger;
import com.google.gson.*;

import java.io.*;
import java.util.*;

/**
 * Egy osztály a játék fő működéséhez.
 */
public class KetKiralyModell {
    /**
     * {@code SOR} a tábla sorainak száma.
     */
    public static final int SOR = 6;
    /**
     * {@code OSZLOP} a tábla oszlopainak száma.
     */
    public static final int OSZLOP = 8;
    /**
     * A tabla a jatékmező, a Wrapper csak olvashatóvá teszi ezt.
     */
    private final ReadOnlyObjectWrapper<Negyzet>[][] tabla = new ReadOnlyObjectWrapper[SOR][OSZLOP];

    /**
     * Két Király pozíciója.
     */
    Kiraly feketeKiraly  = new Kiraly(new Pozicio(3,7));
    Kiraly feherKiraly  = new Kiraly(new Pozicio(2,0));

    /**
     * Pozíció típusú List Property így tudjuk követni ha változik.
     */
    public ListProperty<Pozicio> uresNegyzetPozicio;
    /**
     * haFeherKiraly adja meg éppen ki kkövetkezi a lépésben.
     */
    public boolean haFeherKiraly = true;
    /**
     * A nyertes nevének eltárolása.
     */
    public String neveaNyertesnek;

    /**
     * Konstruktol a KétKirályModellnek.
     * A pálya megtöltése ÜRES mezőkkel és a uresNegyzetPozicio feltöltése.
     */
    public KetKiralyModell(){
        uresNegyzetPozicio = new SimpleListProperty<>(FXCollections.observableArrayList());

        for (int i = 0; i < SOR; i++) {
            for (int j = 0; j < OSZLOP; j++) {
                Pozicio pozicio = new Pozicio(i, j);
                tabla[i][j] = new ReadOnlyObjectWrapper<>(Negyzet.URES);

                if (getNegyzet(pozicio) == Negyzet.URES) {
                    uresNegyzetPozicio.add(pozicio);
                }
            }
        }
    }

    /**
     * Visszaadja a típusát az adott Négyzetnek.
     * @param i az adott sor a tablan.
     * @param j az adott oszlop a tablan.
     * @return típusa a kért Négyzetnek.
     */
    public ReadOnlyObjectProperty<Negyzet> squareProperty(int i, int j){
        return tabla[i][j].getReadOnlyProperty();
    }

    /**
     * Visszaadja a négyzetet a megadott pozíció alapján.
     * @param p a pozíció, amely alapján a négyzetet vissza kell adni
     * @return a megadott pozícióban lévő négyzet
     */
    public Negyzet getNegyzet(Pozicio p){
        return tabla[p.sor()][p.oszl()].get();
    }

    /**
     * Setter a kért négyzetrea kért típus.
     * @param p <code>A pozíció a négyzetnek</code>
     * @param square <code>A kért típus</code>
     */
    public void setNegyzet(Pozicio p, Negyzet square){
        tabla[p.sor()][p.oszl()].set(square);
    }

    /**
     * @return Visszaadja a Fehér Király objectumot
     */
    public Kiraly getFeherKiraly(){
        return feherKiraly;
    }
    /**
     * @return Visszaadja a Fekete Király objectumot
     */
    public Kiraly getFeketeKiraly(){
        return feketeKiraly;
    }

    /**
     *
     * Meghatározza, hogy két pozíció között van-e legalább egy távolság egységnyi eltérés
     * @param pozicio1 az első pozíció
     * @param pozicio2 a második pozíció
     * @return true, ha a két pozíció között van legalább egy távolság egységnyi eltérés, egyébként false
     */
    public boolean aTavolsag(Pozicio pozicio1, Pozicio pozicio2) {
        int sortav = Math.abs(pozicio1.sor() - pozicio2.sor());
        int oszloptav = Math.abs(pozicio1.oszl() - pozicio2.oszl());
        return sortav > 1 || oszloptav > 1;
    }

    /**
     * Létrehoz egy BooleanBinding objektumot, amely meghatározza, hogy a lehetséges lépések üresek-e.
     * @return a létrehozott BooleanBinding objektum
     */
    public BooleanBinding isPossibleMovesEmptyBinding() {
        return Bindings.createBooleanBinding(
                () -> getLehetsegesLepes(getFeherKiraly().getPozicio(), getFeketeKiraly().getPozicio()).isEmpty(),
                uresNegyzetPozicio
        );
    }

    /**
     * A nyertest határozza meg
     */
    public void Nyertes() {
        if (haFeherKiraly) {
            neveaNyertesnek = "Fekete";
        } else {
            neveaNyertesnek = "Fehér";
        }
    }
    /**
     * Hozzárendeli a megadott pozíciót a megfelelő királyhoz és végrehajtja a lépést.
     * Ellenőrzi, hogy a lépés érvényes-e a lehetséges lépések alapján.
     * @param to a cél pozíció, ahova a lépést szeretnénk végrehajtani
     */
    public void lepes(Pozicio to) {
        if (haFeherKiraly) {
            if (getLehetsegesLepes(feherKiraly.getPozicio(), feketeKiraly.getPozicio()).contains(to)) {
                feherKiraly.setPozicio(to);
                Pozicio position = randomUresNegyzet();
                setNegyzet(position, Negyzet.NINCS);
                haFeherKiraly = false;
                Nyertes();
                uresNegyzetPozicio.remove(position);
            } else {
                Logger.error("Rossz lépés");
                feherKiraly.setPozicio(feherKiraly.getPozicio());
            }
        } else {
            if (getLehetsegesLepes(feherKiraly.getPozicio(), feketeKiraly.getPozicio()).contains(to)) {
                feketeKiraly.setPozicio(to);
                Pozicio position = randomUresNegyzet();
                setNegyzet(position, Negyzet.NINCS);
                haFeherKiraly = true;
                Nyertes();
                uresNegyzetPozicio.remove(position);
            } else {
                Logger.error("Rossz lépés");
                feketeKiraly.setPozicio(feketeKiraly.getPozicio());
            }
        }

    }
    /**
     * Visszaadja a lehetséges lépések listáját a megadott király pozíciója alapján.
     * @param adottKiralyPozicio az adott király pozíciója
     * @param masikKiralyPozicio a másik király pozíciója
     * @return a lehetséges lépések listája
     */
    public ArrayList<Pozicio> getLehetsegesLepes(Pozicio adottKiralyPozicio, Pozicio masikKiralyPozicio) {
        ArrayList<Pozicio> lehetsegesLepes = new ArrayList<>();

        if (haFeherKiraly) {
            for (Pozicio move : uresNegyzetPozicio) {
                if (haKiralyMozog(adottKiralyPozicio, move) && !move.equals(adottKiralyPozicio) && aTavolsag(move, masikKiralyPozicio)) {
                    lehetsegesLepes.add(move);
                }
            }
        } else {
            for (Pozicio move : uresNegyzetPozicio) {
                if (haKiralyMozog(masikKiralyPozicio, move) && !move.equals(masikKiralyPozicio) && aTavolsag(move, adottKiralyPozicio)) {
                    lehetsegesLepes.add(move);
                }
            }
        }

        return lehetsegesLepes;
    }

    /**
     * Véletlenszerűen kiválaszt egy üres négyzetet a játéktábláról.
     * @return a véletlenszerűen kiválasztott üres négyzet pozíciója
     */
    public Pozicio randomUresNegyzet() {
        List<Pozicio> elerhetoPozicio = new ArrayList<>(uresNegyzetPozicio);
        elerhetoPozicio.removeAll(Arrays.asList(getFeherKiraly().getPozicio(),getFeketeKiraly().getPozicio()));

        if (elerhetoPozicio.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(elerhetoPozicio.size());
        return elerhetoPozicio.get(index);
    }

    /**
     * Ellenőrzi, hogy a király lépése érvényes-e az adott pozíciókból.
     * @param from a kiinduló pozíció
     * @param to   a célpozíció
     * @return true, ha a király lépése érvényes, különben false
     */
    public boolean haKiralyMozog(Pozicio from, Pozicio to) {
        int dx = Math.abs(from.sor() - to.sor());
        int dy = Math.abs(from.oszl() - to.oszl());
        return dx <= 1 && dy <= 1;
    }

    /**
     * Frissíti a játékos adatokat a megadott játékosnév alapján.
     * @param playerName a játékos neve, akinek az adatait frissíteni kell
     */
    public void jatekosFrissites(String playerName) {
        File file = new File("Eredmeny.json");
        JsonArray playerArray;

        if (file.exists()) {
            try (FileReader fileReader = new FileReader(file)) {
                playerArray = JsonParser.parseReader(fileReader).getAsJsonArray();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            playerArray = new JsonArray();
        }

        boolean playerExists = false;
        for (var element : playerArray) {
            JsonObject player = element.getAsJsonObject();
            if (player.has("nev") && player.get("nev").getAsString().equals(playerName)) {
                playerExists = true;
                player.addProperty("nyeresek", player.get("nyeresek").getAsInt() + 1);
                break;
            }
        }


        if (!playerExists) {
            JsonObject newPlayer = new JsonObject();
            newPlayer.addProperty("nev", playerName);
            newPlayer.addProperty("nyeresek", 1);
            playerArray.add(newPlayer);
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(playerArray, fileWriter);
            Logger.info("JSON sikeres fájlba írása.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Konvertál egy JSON fájlt egy Map<String, Integer> adatszerkezetté.
     * @param jatekos a JSON fájl elérési útvonala
     * @return egy Map<String, Integer> tartalmazó adatokat a JSON fájlból, ahol a játékosnevek a kulcsok,
     */
    public Map<String,Integer> jsonToMap(String jatekos) {
        Map<String,Integer> returnMap = new HashMap<>();
        File file = new File(jatekos);
        if(file.exists()){
            try(FileReader fileReader = new FileReader(file)){
                JsonArray playerArray = JsonParser.parseReader(fileReader).getAsJsonArray();
                for(var element : playerArray){
                    JsonObject player = element.getAsJsonObject();
                    if(player.has("nev") && player.has("nyeresek")){
                        String name = player.get("nev").getAsString();
                        Integer wins = player.get("nyeresek").getAsInt();
                        returnMap.put(name,wins);
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return returnMap;
    }
}
