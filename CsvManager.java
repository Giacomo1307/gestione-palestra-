
package palestra2;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class CsvManager {
    private static CsvManager instance;
    private final String file = "iscritti.csv";

    private CsvManager() {}

    public static CsvManager getInstance() {
        if (instance == null) instance = new CsvManager();
        return instance;
    }

    public void salvaIscritti(List<Iscritto> iscritti) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Iscritto i : iscritti) {
                pw.println(i.getCodice() + ";" + i.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Iscritto> caricaIscritti() {
        List<Iscritto> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] parti = riga.split(";");
                if (parti.length >= 2) {
                    lista.add(new Iscritto(parti[1].split(" ")[0], parti[1].split(" ")[1], parti[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
