
package palestra2;

import java.util.List;

public class AbbonamentiAttiviPresenter {
    
    public String mostraAbbonamenti() {
        
        List<Iscritto> iscritti = IscrittiMgr.getInstance().getIscritti();

        StringBuilder sb = new StringBuilder("Abbonamenti attivi:\n");

        for (Iscritto i : iscritti) {

            if (!i.getAbbonamentiAttivi().isEmpty()) {
                sb.append(i.toString()).append("\n"); 
                for (Abbonamento abbonamento : i.getAbbonamentiAttivi()) {

                    String tipoAbbonamento = abbonamento instanceof AbbonamentoMensile ? "Mensile" : 
                                              abbonamento instanceof AbbonamentoAnnuale ? "Annuale" : "Sconosciuto";

                    sb.append("   → Tipo: ").append(tipoAbbonamento)
                      .append(" | Data Inizio: ").append(abbonamento.getDataInizio())
                      .append(" | Data Fine: ").append(abbonamento.getDataFine())
                      .append("\n");
                }
            }
        }

        if (sb.length() == "Abbonamenti attivi:\n".length()) {
            sb.append("Nessun abbonamento attivo trovato.");
        }
        return sb.toString();
    }
}
