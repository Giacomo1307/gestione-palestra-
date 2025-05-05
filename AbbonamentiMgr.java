
package palestra2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

public class AbbonamentiMgr {
    private static AbbonamentiMgr instance;
    private List<Abbonamento> abbonamenti;
    private final String FILE_NAME = "abbonamenti.csv";

    private AbbonamentiMgr() {
        abbonamenti = new ArrayList<>();
        caricaAbbonamenti();
    }

    public static AbbonamentiMgr getInstance() {
        if (instance == null) {
            instance = new AbbonamentiMgr();
        }
        return instance;
    }

    public void aggiungiAbbonamento(Abbonamento abbonamento) {
        abbonamenti.add(abbonamento);
        salvaAbbonamenti();
    }

    public List<Abbonamento> getAbbonamentiByCodice(String codice) {
        List<Abbonamento> lista = new ArrayList<>();
        for (Abbonamento a : abbonamenti) {
            if (a.getCodiceIscritto().equals(codice)) {
                lista.add(a);
            }
        }
        return lista;
    }

    public List<Abbonamento> getAbbonamentiAttivi(String codice) {
        LocalDate oggi = LocalDate.now();
        List<Abbonamento> attivi = new ArrayList<>();
        for (Abbonamento a : getAbbonamentiByCodice(codice)) {
            if (!oggi.isAfter(a.getDataFine())) {
                attivi.add(a);
            }
        }
        return attivi;
    }

    public List<Abbonamento> getAbbonamentiStorici(String codice) {
        LocalDate oggi = LocalDate.now();
        List<Abbonamento> storici = new ArrayList<>();
        for (Abbonamento a : getAbbonamentiByCodice(codice)) {
            if (oggi.isAfter(a.getDataFine())) {
                storici.add(a);
            }
        }
        return storici;
    }

    private void caricaAbbonamenti() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campi = linea.split(",");
                String tipo = campi[0];
                String codice = campi[1];
                LocalDate inizio = LocalDate.parse(campi[2]);
                Abbonamento abbonamento;
                if (tipo.equals("M")) {
                    abbonamento = new AbbonamentoMensile(codice, inizio);
                } else {
                    abbonamento = new AbbonamentoAnnuale(codice, inizio);
                }
                abbonamenti.add(abbonamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void salvaAbbonamenti() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Abbonamento a : abbonamenti) {
                String tipo = (a instanceof AbbonamentoMensile) ? "M" : "A";
                pw.println(tipo + "," + a.getCodiceIscritto() + "," + a.getDataInizio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
