
package palestra2;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class StoricoAbbonamentiView extends JPanel {
    public StoricoAbbonamentiView(MainFrame frame) {
        setLayout(new BorderLayout());
        JTextArea risultato = new JTextArea();
        JButton mostraBtn = new JButton("Mostra Storico Abbonamenti");

        JPanel inputPanel = new JPanel();
        inputPanel.add(mostraBtn);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(risultato), BorderLayout.CENTER);

        mostraBtn.addActionListener(e -> {
            AbbonamentiStoricoPresenter presenter = new AbbonamentiStoricoPresenter();
            String output = presenter.mostraStorico();  // Mostra tutti gli abbonamenti storici
            risultato.setText(output);  // Mostra il risultato nella JTextArea
        });

        JButton backBtn = new JButton("INDIETRO");
        backBtn.addActionListener(e -> frame.mostraCard("MENU"));
        add(backBtn, BorderLayout.SOUTH);
    }
}
