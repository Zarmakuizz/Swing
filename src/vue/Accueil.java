/**
 * Fenêtre principale
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

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
import javax.swing.tree.*;

import fr.polytech.pooihm.phonebook.Person;


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
        //tree.setShowsRootHandles(true);
        tree.expandPath(tree.getPathForRow(2)); // ???
        
        pCentral = new JScrollPane(tree);
        add(pCentral, BorderLayout.CENTER);
        
    }

    
    
    /**
     * Permet de remplir le JTree avec la liste de groupes et personnes visibles
     * @param donnees
     *          Les données des groupes et personnes
     */
    public void fillTheTree(ArrayList<ArrayList<ArrayList<String>>> donnees, ArrayList<String> groupe){
        //Pour chaque groupe
        for(int i=0; i<donnees.size(); i++){
            groupes = new DefaultMutableTreeNode(groupe.get(i));
            racine.add(groupes);
            //Pour chaque personne
            for(ArrayList<String> personne : donnees.get(i)){
                personnes = new DefaultMutableTreeNode(personne.get(0)+" "+personne.get(1));
                groupes.add(personnes);
            }
        }
    }
    
    /**
     * Permet de remplir le groupe par défaut qui contient toutes les personnes.
     * @param donnees
     *          Les données de toutes les personnes
     */
    public void fillAllPersons(ArrayList<ArrayList<String>> donnees){
        groupes = new DefaultMutableTreeNode("Tous les contacts");
        racine.add(groupes);
        //On remplit le Groupe par défaut des personnes données
        for(ArrayList<String> personne : donnees){
            personnes = new DefaultMutableTreeNode(personne.get(0)+" "+personne.get(1));
            groupes.add(personnes);
        }
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
