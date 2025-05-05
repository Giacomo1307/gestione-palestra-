
package palestra2;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class AbbonamentiAttiviView extends JPanel {
    public AbbonamentiAttiviView(MainFrame frame) {
        setLayout(new BorderLayout());
        JTextArea risultato = new JTextArea();
        JButton mostraBtn = new JButton("Mostra Abbonamenti Attivi");


        JPanel inputPanel = new JPanel();
        inputPanel.add(mostraBtn);


        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(risultato), BorderLayout.CENTER);


        mostraBtn.addActionListener(e -> {
            AbbonamentiAttiviPresenter presenter = new AbbonamentiAttiviPresenter();
            String output = presenter.mostraAbbonamenti();  // Mostra tutti gli abbonamenti attivi
            risultato.setText(output); 
        });
        

        JButton backBtn = new JButton("INDIETRO");
        backBtn.addActionListener(e -> frame.mostraCard("MENU"));
        add(backBtn, BorderLayout.SOUTH);
    }
}
