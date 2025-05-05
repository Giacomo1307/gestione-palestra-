
package palestra2;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

public class AggiungiIscrittoView extends JPanel {
    public AggiungiIscrittoView(MainFrame frame) {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Aggiungi Iscritto");

        JTextField nomeField = new JTextField(10);
        JTextField cognomeField = new JTextField(10);
        JTextField codiceField = new JTextField(10);
        JComboBox<String> tipoAbbonamentoBox = new JComboBox<>(new String[] {"Seleziona", "Mensile", "Annuale"});
        JButton salvaBtn = new JButton("Salva");

        JPanel form = new JPanel();
        form.add(new JLabel("Nome"));
        form.add(nomeField);
        form.add(new JLabel("Cognome"));
        form.add(cognomeField);
        form.add(new JLabel("Codice"));
        form.add(codiceField);
        form.add(new JLabel("Tipo Abbonamento"));
        form.add(tipoAbbonamentoBox);
        form.add(salvaBtn);
       

        add(label, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);

    salvaBtn.addActionListener(e -> {
    String nome = nomeField.getText();
    String cognome = cognomeField.getText();
    String codice = codiceField.getText();
    String tipo = (String) tipoAbbonamentoBox.getSelectedItem();
    
    if (nome.isEmpty() || cognome.isEmpty() || codice.isEmpty() || "Seleziona".equals(tipo)) {
    JOptionPane.showMessageDialog(this, "Compila tutti i campi e seleziona un tipo di abbonamento valido.", "Errore", JOptionPane.ERROR_MESSAGE);
    return;
    }
    
        boolean esiste = IscrittiMgr.getInstance().getIscritti().stream().anyMatch(i ->
        i.getNome().equalsIgnoreCase(nome) &&
        i.getCognome().equalsIgnoreCase(cognome) &&
        i.getCodice().equalsIgnoreCase(codice)
    );

    if (esiste) {
        JOptionPane.showMessageDialog(this, "Esiste già un iscritto con lo stesso nome, cognome e codice.");
        return;
    }

    AggiungiIscrittoPresenter presenter = new AggiungiIscrittoPresenter();
    presenter.aggiungiIscritto(nome, cognome, codice, tipo);

    JOptionPane.showMessageDialog(this, "Iscritto salvato con abbonamento " + tipo.toLowerCase());
    
    nomeField.setText("");
    cognomeField.setText("");
    codiceField.setText("");
    tipoAbbonamentoBox.setSelectedIndex(0);
    
    });
    
        JButton backBtn = new JButton("INDIETRO");
        backBtn.addActionListener(e -> frame.mostraCard("MENU"));
        add(backBtn, BorderLayout.SOUTH);
    }
}
