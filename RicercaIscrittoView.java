
package palestra2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class RicercaIscrittoView extends JPanel {
    public RicercaIscrittoView(MainFrame frame) {
        setLayout(new BorderLayout());
        
        JTextField codiceField = new JTextField(10);
        JTextArea risultato = new JTextArea();
        JButton cercaBtn = new JButton("Cerca");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Codice iscritto: "));
        inputPanel.add(codiceField);
        inputPanel.add(cercaBtn);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(risultato), BorderLayout.CENTER);

        cercaBtn.addActionListener(e -> {
            Iscritto i = new RicercaIscrittoPresenter().cercaIscritto(codiceField.getText());
            risultato.setText(i != null ? i.toString() : "Iscritto non trovato");
            
            codiceField.setText("");
        });
        
        JButton backBtn = new JButton("INDIETRO");
        backBtn.addActionListener(e -> frame.mostraCard("MENU"));
        add(backBtn, BorderLayout.SOUTH);
    }
}
