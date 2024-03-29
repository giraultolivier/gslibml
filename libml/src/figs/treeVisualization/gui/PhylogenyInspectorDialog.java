/*
 * TreeInspectorPanel.java
 *
 * Created on April 13, 2007, 10:46 AM
 */

package figs.treeVisualization.gui;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mitre.bio.phylo.dom.Phylogeny;

/**
 * Class for displaying information about a tree (Phylogeny). 
 *
 * @author Marc Colosimo
 * @copyright 2007 The MITRE Corporation
 * 
 * @version $Id: PhylogenyInspectorDialog.java 2 2007-08-15 16:57:33Z mcolosimo $
 *
 */
public class PhylogenyInspectorDialog extends JFrame implements WindowListener {
    
    /** Default Title of window. */
    public static final String DEFAULT_TITLE = "Phylogeny Inspector";
    
    /** Map of open Phylogeny Inspector Windows. */
    private static Map<Phylogeny,JFrame> dialogs;
    
    /** Our Phylogeny to inspect. */
    private Phylogeny phylogeny;
    
    /**
     * Show a Dialog box for the given Phylogeny.
     * <P>
     * Only <B>ONE</B> window for each Phylogeny will be displayed.
     * 
     * @param phylogeny the <code>Phylogeny</code> to get the information from.
     */
    public static void showDialog(Phylogeny phylogeny) {
        if ( dialogs == null )
            dialogs = new HashMap<Phylogeny, JFrame>();

        if ( phylogeny == null )
            throw new IllegalArgumentException("Null 'phylogeny' argument.");

        if ( dialogs.containsKey(phylogeny) ) {
            JFrame dialog = dialogs.get(phylogeny);
            dialog.setVisible(true);
        } else {
            String title = DEFAULT_TITLE + ": " + phylogeny.toString();
            PhylogenyInspectorDialog dialog = new PhylogenyInspectorDialog(phylogeny, title); 
            dialogs.put(phylogeny, dialog);
        }
    }
        
    /** 
     * Private Constructor
     *
     * Creates new TreeInspectorDialog 
     */
    private PhylogenyInspectorDialog(Phylogeny phylogeny, String title) {
        super(title);
        
        this.phylogeny = phylogeny;

        initComponents();
        updateFields();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(this);
        getRootPane().setDefaultButton(this.applyButton);
        pack();
	setLocationRelativeTo(null);
        setVisible(true);
    }
 
    /**
     * Update the fields.
     */
    private void updateFields() {
       this.nameTextField.setText(this.phylogeny.toString());
       
       // this.idTextField.setText(this.phylogeny.getID);
       this.idTextField.setEnabled(false);
       this.idLabel.setEnabled(false);
       
       this.descriptionTextArea.setText(this.phylogeny.getDescription());
       
       //this.commentTextArea.setText(this.phylogeny.getComment());
       this.commentScrollPane.setEnabled(false);
       this.commentLabel.setEnabled(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                nameLabel = new javax.swing.JLabel();
                nameTextField = new javax.swing.JTextField();
                idLabel = new javax.swing.JLabel();
                idTextField = new javax.swing.JTextField();
                descriptionLabel = new javax.swing.JLabel();
                descriptionScrollPane = new javax.swing.JScrollPane();
                descriptionTextArea = new javax.swing.JTextArea();
                commentLabel = new javax.swing.JLabel();
                commentScrollPane = new javax.swing.JScrollPane();
                commentTextArea = new javax.swing.JTextArea();
                jPanel1 = new javax.swing.JPanel();
                cancelButton = new javax.swing.JButton();
                applyButton = new javax.swing.JButton();

                getContentPane().setLayout(new java.awt.GridBagLayout());

                nameLabel.setText("Name:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                getContentPane().add(nameLabel, gridBagConstraints);

                nameTextField.setToolTipText("The name of the Phylogeny");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
                getContentPane().add(nameTextField, gridBagConstraints);

                idLabel.setText("Id:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                getContentPane().add(idLabel, gridBagConstraints);

                idTextField.setEditable(false);
                idTextField.setToolTipText("An unique identifier for the Phylogeny");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.ipady = 5;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
                getContentPane().add(idTextField, gridBagConstraints);

                descriptionLabel.setText("Description:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
                getContentPane().add(descriptionLabel, gridBagConstraints);

                descriptionTextArea.setColumns(20);
                descriptionTextArea.setRows(5);
                descriptionTextArea.setToolTipText("Description of the Phylogeny");
                descriptionScrollPane.setViewportView(descriptionTextArea);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.ipady = 5;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
                getContentPane().add(descriptionScrollPane, gridBagConstraints);

                commentLabel.setText("Comments:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
                getContentPane().add(commentLabel, gridBagConstraints);

                commentTextArea.setColumns(20);
                commentTextArea.setRows(5);
                commentTextArea.setToolTipText("Comments about the Phylogeny");
                commentScrollPane.setViewportView(commentTextArea);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
                getContentPane().add(commentScrollPane, gridBagConstraints);

                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelButtonActionPerformed(evt);
                        }
                });
                jPanel1.add(cancelButton);

                applyButton.setText("Apply");
                applyButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                applyButtonAction(evt);
                        }
                });
                jPanel1.add(applyButton);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
                getContentPane().add(jPanel1, gridBagConstraints);
        }// </editor-fold>//GEN-END:initComponents

    private void applyButtonAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonAction
        /** Check to see if ID is unqiue */
        
        if (! this.phylogeny.toString().equals(this.nameTextField.getText()) ) {
            this.phylogeny.setPhylogenyName(this.nameTextField.getText());
        }
        
        if (! this.phylogeny.getDescription().equals(this.descriptionTextArea.getText()) ) {
            this.phylogeny.setDescription(this.descriptionTextArea.getText());
        }
            
        /** Close the window, we are done! */
        dispose();
    }//GEN-LAST:event_applyButtonAction

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        /** Just close and dispose of this window. */
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    //
    // WindowListener Events
    //
    
    public void windowOpened(WindowEvent windowEvent) {
    }

    public void windowClosing(WindowEvent windowEvent) {
    }

    /**
     * Handle the window being closed
     */
    public void windowClosed(WindowEvent windowEvent) {
        PhylogenyInspectorDialog.dialogs.remove(this.phylogeny);
    }

    public void windowIconified(WindowEvent windowEvent) {
    }

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }
    
    
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton applyButton;
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel commentLabel;
        private javax.swing.JScrollPane commentScrollPane;
        private javax.swing.JTextArea commentTextArea;
        private javax.swing.JLabel descriptionLabel;
        private javax.swing.JScrollPane descriptionScrollPane;
        private javax.swing.JTextArea descriptionTextArea;
        private javax.swing.JLabel idLabel;
        private javax.swing.JTextField idTextField;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel nameLabel;
        private javax.swing.JTextField nameTextField;
        // End of variables declaration//GEN-END:variables
    
}
