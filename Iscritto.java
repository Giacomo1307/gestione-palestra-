
package palestra2;

import java.util.ArrayList;
import java.util.List;

public class Iscritto {
    private String nome;
    private String cognome;
    private String codice;
    private List<Abbonamento> abbonamentiAttivi;
    private List<Abbonamento> storicoAbbonamenti;

    public Iscritto(String nome, String cognome, String codiceIdentificativo) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codiceIdentificativo;
        this.abbonamentiAttivi = new ArrayList<>();
        this.storicoAbbonamenti = new ArrayList<>();
    }

    public String getNome() {
        return nome; 
    }
    public String getCognome() {
        return cognome; 
    }
    public String getCodice() {
        return codice; 
    }
    public List<Abbonamento> getAbbonamentiAttivi() {
        return abbonamentiAttivi;
    }
    public List<Abbonamento> getStoricoAbbonamenti() {
        return storicoAbbonamenti; 
    }
    
    
    public void aggiungiAbbonamento(Abbonamento abbonamento) {
        abbonamentiAttivi.add(abbonamento);
    }
    public void terminaAbbonamento(Abbonamento abbonamento) {
        abbonamentiAttivi.remove(abbonamento);
        storicoAbbonamenti.add(abbonamento);
    }
    
     @Override
    public String toString() {
        return nome + " " + cognome + " (" + codice + ")";
    }
}
