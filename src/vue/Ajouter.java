/**
 * Fenêtre d'ajout
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * @author namor
 */

public class Ajouter extends Detail implements ActionListener {
    /** Les champs de textes */
    protected JTextField nomField, prenomField, telMField, telBField, telPField;
    
    public Ajouter() {
        // Boutons
        act.setText("Ajouter");
        pBoutons.add(act);
        pBoutons.add(ann);
        // Panel central
        nomField = new JTextField();
        prenomField = new JTextField();
        telMField = new JTextField();
        telBField = new JTextField();
        telPField = new JTextField();
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
            
        } else if (e.getSource() == ann) {
            setVisible(false);
        }
    }

}
