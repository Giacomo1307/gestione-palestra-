
package palestra2;

import java.time.LocalDate;

public class AbbonamentoAnnuale extends Abbonamento {
    public AbbonamentoAnnuale(String codiceIscritto, LocalDate dataInizio) {
        super(codiceIscritto, dataInizio, dataInizio.plusYears(1));
    }

    @Override
    public String toString() {
        return "Tipo: Annuale | " + super.toString();
    }
}
