/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julzz.groups.ui;

import java.awt.BorderLayout;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import com.julzz.groups.io.ProblemReader;
import com.julzz.groups.io.ProblemWriter;
import com.julzz.groups.model.Problem;
import com.julzz.groups.model.ProblemDescription;
import com.julzz.groups.ui.panels.ConstraintPanel;
import com.julzz.groups.ui.panels.GroupPanel;
import com.julzz.groups.ui.panels.NamePanel;
import com.julzz.groups.ui.panels.RelationPanel;
import com.julzz.groups.ui.panels.ResultPanel;

public class Main extends javax.swing.JFrame {

    final private List<Class<?>> cPanels = Arrays.asList(NamePanel.class, 
            GroupPanel.class, ConstraintPanel.class, RelationPanel.class,ResultPanel.class);

    private final int startPanel = 0;

    
    private int currentIdx = 0;
    private AbstractPanel currentPanel = null;
    

    public Main() {
        initComponents();

        //Storage.bProblem = new ProblemReader().read("/home/julesy/december2015.json");
        //Storage.desc = new ProblemReader().read("/home/julesy/december2015.json").build().getDescription();
        
        setLayout(new BorderLayout());
        pnlContainer.setLayout(new BorderLayout());

        loadPanel(startPanel);

        updateButtons();
    }

    private AbstractPanel buildPanel(int idx) {
        try {
            return (AbstractPanel) cPanels.get(idx).getConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException |
                IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    private void loadPanel(int idx) {
        
        pnlContainer.removeAll();
        currentPanel = buildPanel(idx);
        pnlContainer.add(currentPanel);

        invalidate();
        validate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNext = new javax.swing.JToggleButton();
        btnBack = new javax.swing.JToggleButton();
        pnlContainer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        mImport = new javax.swing.JMenuItem();
        mReset = new javax.swing.JMenuItem();
        mSave = new javax.swing.JMenuItem();
        mQuit = new javax.swing.JMenuItem();
        mAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Groups");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        pnlContainer.setMaximumSize(new java.awt.Dimension(654, 408));
        pnlContainer.setMinimumSize(new java.awt.Dimension(654, 408));

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        mFile.setText("File");
        mFile.setText(Storage.bundle.getString("file"));

        mImport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mImport.setText("Import");
        mImport.setText(Storage.bundle.getString("import"));
        mImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mImportActionPerformed(evt);
            }
        });
        mFile.add(mImport);

        mReset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mReset.setText("Reset");
        mReset.setToolTipText("");
        mReset.setText(Storage.bundle.getString("reset"));
        mReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mResetActionPerformed(evt);
            }
        });
        mFile.add(mReset);

        mSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mSave.setText("Save");
        mSave.setText(Storage.bundle.getString("save"));
        mSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSaveActionPerformed(evt);
            }
        });
        mFile.add(mSave);

        mQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mQuit.setText("Quit");
        mQuit.setText(Storage.bundle.getString("quit"));
        mQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mQuitActionPerformed(evt);
            }
        });
        mFile.add(mQuit);

        jMenuBar1.add(mFile);

        mAbout.setText("About");
        mAbout.setToolTipText("");
        mAbout.setText(Storage.bundle.getString("about"));
        jMenuBar1.add(mAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtons() {

        if (currentIdx == 0) {
            btnBack.setEnabled(false);
            btnNext.setEnabled(true);
        } else if (currentIdx == cPanels.size() - 1) {
            btnNext.setEnabled(false);
            btnBack.setEnabled(true);
        } else {
            btnBack.setEnabled(true);
            btnNext.setEnabled(true);
        }
    }


    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        currentPanel.save();
        currentIdx++;
        loadPanel(currentIdx);
        updateButtons();
    }//GEN-LAST:event_btnNextActionPerformed


    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        currentPanel.save();
        currentIdx--;
        loadPanel(currentIdx);
        updateButtons();
    }//GEN-LAST:event_btnBackActionPerformed

    private void mImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mImportActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            Storage.desc = new ProblemReader().read(file.getAbsolutePath()).build().getDescription();
            loadPanel(currentIdx);
        }
    }//GEN-LAST:event_mImportActionPerformed

    private void mSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSaveActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            new ProblemWriter().write(new Problem(Storage.desc), file.getAbsolutePath());
        }
    }//GEN-LAST:event_mSaveActionPerformed

    private void mQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mQuitActionPerformed

    private void mResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mResetActionPerformed
        Storage.desc = new ProblemDescription();
        loadPanel(startPanel);
    }//GEN-LAST:event_mResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JToggleButton btnNext;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAbout;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuItem mImport;
    private javax.swing.JMenuItem mQuit;
    private javax.swing.JMenuItem mReset;
    private javax.swing.JMenuItem mSave;
    private javax.swing.JPanel pnlContainer;
    // End of variables declaration//GEN-END:variables
}
