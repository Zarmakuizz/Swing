/**
 * Fenêtre de modification
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * @author namor
 */

public class Modifier extends Detail implements ActionListener {
    /** Les champs de textes */
    protected JTextField nomField, prenomField, telMField, telBField, telPField;
    
    public Modifier() {
        // Boutons
        act.setText("Modifier");
        pBoutons.add(act);
        pBoutons.add(ann);
        // Panel central
        nomField = new JTextField("Jean");
        prenomField = new JTextField("Dupont");
        telMField = new JTextField("04 92 93 92 93");
        telBField = new JTextField("04 95 94 93 92");
        telPField = new JTextField("06 01 02 03 04");
        pCentral.add(nom); pCentral.add(nomField);
        pCentral.add(prenom); pCentral.add(prenomField);
        pCentral.add(telM); pCentral.add(telMField);
        pCentral.add(telB); pCentral.add(telBField);
        pCentral.add(telP); pCentral.add(telPField);
        
    }

    /**
     * Ecoute les évènements.
     * 
     * @param e
     *            L'évènement qui survient
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == act) {
            act.setText("lol");
        } else if (e.getSource() == ann) {
            ann.setText("lol");
        }
    }

}
