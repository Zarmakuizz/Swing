/**
 * Diverses alertes avec un choix ou sans
 */
package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author namor
 */

public class Alerte extends JFrame implements ActionListener{
    /** Bouton ok d'acceptation de la fatalité */
    private JButton ok;
    /** Bouton oui de confirmation */
    private JButton oui;
    /** Bouton non d'annulation */
    private JButton non;
    /** Indique le type de fenêtre courant */
    private int type;
    /** Le panel central */
    private JPanel panel;
    
    /**
     * Crée une fenêtre d'alerte à un ou 2 boutons
     * @param type Le type de la fenêtre
     */
    public Alerte(int type){
        this.type = type;
        setLayout(new BorderLayout());
        panel = new JPanel(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        if(type == 1){
            ok = new JButton("Ok");
            ok.addActionListener(this);
            panel.add(ok, BorderLayout.CENTER);
        }
        if(type == 2){
            non = new JButton("Non");
            oui = new JButton("Oui");
            non.addActionListener(this);
            oui.addActionListener(this);
            panel.add(non, BorderLayout.EAST);
            panel.add(oui, BorderLayout.WEST);
        }
        //setSize(150, 80);
        pack();
    }
    
    /**
     * Ecoute les évènements.
     * @param e L'évènement qui survient
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            ok.setText("lol");
        }
        else if (e.getSource() == non) {
            non.setText("lol");
        }
        else if (e.getSource() == oui) {
            oui.setText("lol");
        }
    }
      
}