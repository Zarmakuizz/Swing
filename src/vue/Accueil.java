/**
 * Fenêtre principale
 */
package vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author namor
 * @author Zarmakuizz
 */

public class Accueil extends JFrame implements ActionListener {
    /** Boutons */
    private JButton add, mod, desc, supp;
    /** Le panel central */
    private JScrollPane pCentral;
    /** Le panel des boutons */
    private JPanel pBoutons;
    /** la liste des noms de groupe */
    private JList lGroupe;
    /** la liste des noms de personnes du groupe sélectionné */
    private JList lPersonnes;

    public Accueil() {
        setSize(500, 200);
        // Boutons
        add = new JButton("Ajouter");
        mod = new JButton("Modifier");
        supp = new JButton("Supprimer");
        desc = new JButton("Description");
        pBoutons = new JPanel();
        add(pBoutons, BorderLayout.NORTH);
        pBoutons.add(add);
        pBoutons.add(mod);
        pBoutons.add(desc);
        pBoutons.add(supp);
        // Listeners
        add.addActionListener(this);
        mod.addActionListener(this);
        desc.addActionListener(this);
        supp.addActionListener(this);

        // Panel central
        String[] groupes = { "G1 blablabla", "G2blablabla", "G3",
                "G4 blablabla", "G5", "G6", "G7", "G8", "G9 blablabla",
                "G10blablabla", "G11", "G12 blablabla", "G13", "G14", "G15", "G16" }, personnes = {
                "P1", "P2" };
        lGroupe = new JList(groupes);
        lPersonnes = new JList(personnes);
        pCentral = new JScrollPane(lGroupe);
        add(pCentral, BorderLayout.CENTER);
        //pCentral.add(lGroupe); // pCentral.add(lPersonnes);
    }

    /**
     * Ecoute les évènements.
     * 
     * @param e
     *            L'évènement qui survient
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            add.setText("lol");
        } else if (e.getSource() == mod) {
            mod.setText("lol");
        } else if (e.getSource() == desc) {
            desc.setText("lol");
        } else if (e.getSource() == supp) {
            supp.setText("lol");
        }
    }

}
