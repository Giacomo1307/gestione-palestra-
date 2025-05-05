
package palestra2;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class VisualizzaIscrittiView extends JPanel {
    public VisualizzaIscrittiView(MainFrame frame) {
        setLayout(new BorderLayout());
        
        JTextArea area = new JTextArea();
        area.setEditable(false); // opzionale: impedisce la modifica del testo
        
        JButton aggiorna = new JButton("Aggiorna");
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(aggiorna, BorderLayout.SOUTH);

        aggiorna.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Iscritto i : IscrittiMgr.getInstance().getIscritti()) {
                sb.append(i.toString()).append("\n");
                
            for (Abbonamento ab : i.getAbbonamentiAttivi()) {
            sb.append("   → Abbonamento: ").append(ab.toString());
}
            
            sb.append("\n"); 
          }  
            
            area.setText(sb.toString());
        });

        aggiorna.doClick();

        JButton backBtn = new JButton("INDIETRO");
        backBtn.addActionListener(e -> frame.mostraCard("MENU"));
        add(backBtn, BorderLayout.NORTH); // Cambiato per non sovrascrivere il bottone "Aggiorna"
    }
}
