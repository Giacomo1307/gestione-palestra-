
package palestra2;

import java.time.LocalDate;

public class AggiungiIscrittoPresenter {
    public void aggiungiIscritto(String nome, String cognome, String codice, String tipoAbbonamento) {
        Iscritto nuovo = new Iscritto(nome, cognome, codice);

        Abbonamento abbonamento;
        if ("Mensile".equalsIgnoreCase(tipoAbbonamento)) {
            abbonamento = new AbbonamentoMensile(codice, LocalDate.now());
        } else {
            abbonamento = new AbbonamentoAnnuale(codice, LocalDate.now());
        }

        nuovo.aggiungiAbbonamento(abbonamento);

        IscrittiMgr.getInstance().aggiungiIscritto(nuovo);
    }
}