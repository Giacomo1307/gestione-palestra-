
package palestra2;

import java.time.LocalDate;

import java.time.LocalDate;

public class Abbonamento {
    protected String codiceIscritto;
    protected LocalDate dataInizio;
    protected LocalDate dataFine;

    public Abbonamento(String codiceIscritto, LocalDate dataInizio, LocalDate dataFine) {
        this.codiceIscritto = codiceIscritto;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getCodiceIscritto() {
        return codiceIscritto;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }
    
    public void setDataFine(LocalDate dataFine) {
    this.dataFine = dataFine;
}

    @Override
    public String toString() {
        return "Inizio: " + dataInizio + " | Fine: " + dataFine;
    }
}
