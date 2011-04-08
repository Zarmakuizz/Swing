/**
 * Classe abstraite commune à ajouter/détail
 */
package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.AjouterControler;

/**
 * @author namor
 */

public abstract class Detail extends JFrame implements ActionListener {
    /** Boutons */
    protected JButton ann, act;
    /** Le panel central */
    protected JPanel pCentral;
    /** Le panel des boutons */
    protected JPanel pBoutons;
    /** Les textes */
    protected JLabel nom, prenom, telM, telB, telP;

    public Detail() {
        setSize(300, 200);
        // Boutons
        ann = new JButton("Annuler");
        act = new JButton("Action");
        pBoutons = new JPanel();
        add(pBoutons, BorderLayout.SOUTH);
        // Listeners
        ann.addActionListener(this);
        act.addActionListener(this);

        // Panel central
        pCentral = new JPanel(new GridLayout(5, 2));
        add(pCentral, BorderLayout.CENTER);
        nom = new JLabel("Nom : ");
        prenom = new JLabel("Prénom : ");
        telM = new JLabel("Tel. Maison : ");
        telB = new JLabel("Tel. Bureau : ");
        telP = new JLabel("Tel. Portable : ");
        
    }

    /**
     * Ecoute les évènements.
     * 
     */
    @Override
    public abstract void actionPerformed(ActionEvent e);

}
