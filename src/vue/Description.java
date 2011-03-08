/**
 * Fenêtre d'ajout
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * @author namor
 */

public class Description extends Detail implements ActionListener {
    /** Les textes correspondants */
    protected JLabel nom2, prenom2, telM2, telB2, telP2;
    
    public Description() {
        // Boutons
        ann.setText("Quitter");
        pBoutons.add(ann);
        // Panel central
        nom2 = new JLabel("Jean");
        prenom2 = new JLabel("Dupont");
        telM2 = new JLabel("04 92 93 92 93");
        telB2 = new JLabel("04 95 94 93 92");
        telP2 = new JLabel("06 01 02 03 04");
        pCentral.add(nom); pCentral.add(nom2);
        pCentral.add(prenom); pCentral.add(prenom2);
        pCentral.add(telM); pCentral.add(telM2);
        pCentral.add(telB); pCentral.add(telB2);
        pCentral.add(telP); pCentral.add(telP2);
        
    }

    /**
     * Ecoute les évènements.
     * 
     * @param e
     *            L'évènement qui survient
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ann) {
            ann.setText("lol");
        }
    }

}
