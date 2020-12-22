/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dev.ui;

import com.dev.model.SingleResponseQuestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author jdh6w
 */
public class CategorySelector extends javax.swing.JPanel {
    
    
    /**
     * Creates new form CategorySelector
     */
    public CategorySelector(MainMenuNB mmnb) {
        initComponents();
        this.mmnb = mmnb;
        allQs.add(new SingleResponseQuestion(2,"What does SQL stand for?", "Structured Query Language", "SQL"));
        allQs.add(new SingleResponseQuestion(3,"What does POM stand for?", "Project Object Model", "POM"));
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        gbc.gridwidth = 0;
        gbc.gridheight= 0;
        internalPanel.setLayout(gbl);
//        internalPanel.setLayout(new BorderLayout());

        for(SingleResponseQuestion q : allQs){
            if(!allCategories.contains(q.getCategory())){
                allCategories.add(q.getCategory());
                
                JCheckBox jcb = new JCheckBox();
                jcb.setText(q.getCategory());
                jcb.addActionListener(new AbstractAction("box selected") {
                    String category = jcb.getText();
                    public void actionPerformed(ActionEvent e){
                        if(!selectedCategories.contains(category)){
                            System.out.println("Does not contain category");
                            selectedCategories.add(category);
                        } else {
                            System.out.println("Does contain category");
                            selectedCategories.remove(category);
                        }
                        System.out.println(selectedCategories);
                        System.out.println(category);
                    }
                });
                internalPanel.add(jcb, gbc);
            }
        }
        internalPanel.revalidate();
        internalPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        SettingsButton = new javax.swing.JButton();
        internalPanel = new javax.swing.JPanel();

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Categories");

        SettingsButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SettingsButton.setText("Return to Settings");
        SettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsButtonActionPerformed(evt);
            }
        });

        internalPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        internalPanel.setMinimumSize(new java.awt.Dimension(285, 372));

        javax.swing.GroupLayout internalPanelLayout = new javax.swing.GroupLayout(internalPanel);
        internalPanel.setLayout(internalPanelLayout);
        internalPanelLayout.setHorizontalGroup(
            internalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        internalPanelLayout.setVerticalGroup(
            internalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 309, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(internalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(internalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsButtonActionPerformed
        // TODO add your handling code here:
        
        mmnb.backToLobbySettings(this);
    }//GEN-LAST:event_SettingsButtonActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SettingsButton;
    private javax.swing.JPanel internalPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private MainMenuNB mmnb;
    private List<SingleResponseQuestion> allQs = new ArrayList<>();
    private Set<String> allCategories = new HashSet<>();
    private Set<String> selectedCategories = new HashSet<>();
    
    public Set<String> getSelectedCategories(){
        return selectedCategories;
    }

}
