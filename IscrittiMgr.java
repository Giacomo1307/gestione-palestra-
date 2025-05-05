
package palestra2;

import java.util.List;

public class IscrittiMgr {
    private static IscrittiMgr instance;
    private List<Iscritto> iscritti;

    private IscrittiMgr() {
        iscritti = CsvManager.getInstance().caricaIscritti();
    }

    public static IscrittiMgr getInstance() {
        if (instance == null) instance = new IscrittiMgr();
        return instance;
    }

    public void aggiungiIscritto(Iscritto i) {
        iscritti.add(i);
        CsvManager.getInstance().salvaIscritti(iscritti);
    }

    public Iscritto cercaIscritto(String codice) {
        for (Iscritto i : iscritti) {
            if (i.getCodice().equalsIgnoreCase(codice)) return i;
        }
        return null;
    }

    public List<Iscritto> getIscritti() {
        return iscritti;
    }
}
