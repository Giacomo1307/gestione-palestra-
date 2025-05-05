
package palestra2;

public class RicercaIscrittoPresenter {
    public Iscritto cercaIscritto(String codice) {
        return IscrittiMgr.getInstance().cercaIscritto(codice);
    }
}
