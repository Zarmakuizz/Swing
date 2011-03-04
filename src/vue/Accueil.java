/**
 * Fenêtre principale
 */
package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author namor
 * @author Zarmakuizz
 */

public class Accueil extends JFrame implements ActionListener{
    /** Boutons */
    private JButton add, mod, desc, supp;
    /** Le panel central */
    private JPanel pCentral;
    /** Le panel des boutons */
    private JPanel pBoutons;
    
    public Accueil(){
        setSize(500, 400);
        //Boutons
        add = new JButton("Ajouter");
        mod = new JButton("Modifier");
        supp = new JButton("Supprimer");
        desc = new JButton("Description");
        pBoutons = new JPanel();
        add(pBoutons, BorderLayout.NORTH);
        pBoutons.add(add); pBoutons.add(mod); pBoutons.add(desc); pBoutons.add(supp);
        //Listeners
        add.addActionListener(this);
        mod.addActionListener(this);
        desc.addActionListener(this);
        supp.addActionListener(this);
        // Panel central
        pCentral = new JPanel();
        add(pCentral, BorderLayout.SOUTH);
    }

    /**
     * Ecoute les évènements.
     * @param e L'évènement qui survient
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            add.setText("lol");
        }
        else if (e.getSource() == mod) {
            mod.setText("lol");
        }
        else if (e.getSource() == desc) {
            desc.setText("lol");
        }
        else if (e.getSource() == supp) {
            supp.setText("lol");
        }
    }
    
}
