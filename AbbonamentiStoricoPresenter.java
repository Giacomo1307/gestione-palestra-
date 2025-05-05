
package palestra2;

import java.util.List;

public class AbbonamentiStoricoPresenter {
    public String mostraStorico() {

        List<Iscritto> iscritti = IscrittiMgr.getInstance().getIscritti();

        StringBuilder sb = new StringBuilder("Storico degli abbonamenti:\n");

        for (Iscritto i : iscritti) {

            if (!i.getStoricoAbbonamenti().isEmpty()) {
                sb.append(i.toString()).append("\n"); 
                for (Abbonamento abbonamento : i.getStoricoAbbonamenti()) {

                    String tipoAbbonamento = abbonamento instanceof AbbonamentoMensile ? "Mensile" : 
                                              abbonamento instanceof AbbonamentoAnnuale ? "Annuale" : "Sconosciuto";

                    sb.append("   → Tipo: ").append(tipoAbbonamento)
                      .append(" | Data Inizio: ").append(abbonamento.getDataInizio())
                      .append(" | Data Fine: ").append(abbonamento.getDataFine())
                      .append("\n");
                }
            }
        }

        if (sb.length() == "Storico degli abbonamenti:\n".length()) {
            sb.append("Nessun abbonamento storico trovato.");
        }

        return sb.toString();
    }
}
