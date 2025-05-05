
package palestra2;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    private MainFrame() {
        setTitle("Gestione Palestra");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new MenùPanel(), "MENU");
        mainPanel.add(new AggiungiIscrittoView(this), "AGGIUNGI_ISCRITTO");
        mainPanel.add(new RicercaIscrittoView(this), "RICERCA_ISCRITTO");
        mainPanel.add(new VisualizzaIscrittiView(this), "VISUALIZZA_ISCRITTI");
        mainPanel.add(new AbbonamentiAttiviView(this), "VISUALIZZA_ABBONAMENTI");
        mainPanel.add(new StoricoAbbonamentiView(this), "STORICO_ABBONAMENTI");

        setContentPane(mainPanel);
        mostraCard("MENU");
        setVisible(true);
    }

    public void mostraCard(String nomeCard) {
        cardLayout.show(mainPanel, nomeCard);
    }
}

