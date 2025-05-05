
package palestra2;

import java.time.LocalDate;

public class AbbonamentoMensile extends Abbonamento {
    public AbbonamentoMensile(String codiceIscritto, LocalDate dataInizio) {
        super(codiceIscritto, dataInizio, dataInizio.plusMonths(1));
    }

    @Override
    public String toString() {
        return "Tipo: Mensile | " + super.toString();
    }
}