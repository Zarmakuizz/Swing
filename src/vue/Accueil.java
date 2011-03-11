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
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import controle.AccueilControler;
import controle.AjouterControler;
import controle.DescriptionControler;
import controle.ModifierControler;

/**
 * @author namor
 */

public class Accueil extends JFrame implements ActionListener {
    /** Boutons */
    private JButton add, mod, desc, supp;
    /** Le panel central */
    private JScrollPane pCentral;
    /** Le panel des boutons */
    private JPanel pBoutons;
    /** l'arbre contenant le répertoire */
    private JTree tree;
    /** Noeuds */
    DefaultMutableTreeNode racine, groupes, personnes;
    
    public Accueil() {
        setSize(500, 350);
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
        String[] lool = {"lol", "lool"};
        
        racine = new DefaultMutableTreeNode("Répertoire");
        tree = new JTree(racine);
       
        groupes = new DefaultMutableTreeNode("Tous les contacts");
        racine.add(groupes);
        personnes = new DefaultMutableTreeNode("Personne1");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne2");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne3");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne4");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne5");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne6");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne7");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne8");
        groupes.add(personnes);
        
        groupes = new DefaultMutableTreeNode("groupe2");
        racine.add(groupes);
        groupes = new DefaultMutableTreeNode("groupe3");
        racine.add(groupes);
        personnes = new DefaultMutableTreeNode("Personne1");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne2");
        groupes.add(personnes);
        groupes = new DefaultMutableTreeNode("groupe4");
        racine.add(groupes);
        groupes = new DefaultMutableTreeNode("groupe5");
        racine.add(groupes);
        personnes = new DefaultMutableTreeNode("Personne1");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne2");
        groupes.add(personnes);
        groupes = new DefaultMutableTreeNode("groupe6");
        racine.add(groupes);
        groupes = new DefaultMutableTreeNode("groupe7");
        racine.add(groupes);
        personnes = new DefaultMutableTreeNode("Personne1");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne2");
        groupes.add(personnes);
        groupes = new DefaultMutableTreeNode("groupe8");
        racine.add(groupes);
        groupes = new DefaultMutableTreeNode("groupe9");
        racine.add(groupes);
        personnes = new DefaultMutableTreeNode("Personne1");
        groupes.add(personnes);
        personnes = new DefaultMutableTreeNode("Personne2");
        groupes.add(personnes);

        
        pCentral = new JScrollPane(tree);
        add(pCentral, BorderLayout.CENTER);
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
            AjouterControler.vueAjout();
        } else if (e.getSource() == mod) {
            ModifierControler.vueModifier();
        } else if (e.getSource() == desc) {
            DescriptionControler.vueDescription();
        } else if (e.getSource() == supp) {
            AccueilControler.vueSuppression();
        }
    }

}
