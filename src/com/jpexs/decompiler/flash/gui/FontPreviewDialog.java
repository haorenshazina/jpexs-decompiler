/*
 *  Copyright (C) 2010-2015 JPEXS
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jpexs.decompiler.flash.gui;

import com.jpexs.decompiler.flash.configuration.Configuration;
import com.jpexs.helpers.utf8.Utf8Helper;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author JPEXS
 */
public class FontPreviewDialog extends AppDialog {

    /**
     * Creates new form FontPreviewDialog
     *
     * @param parent
     * @param font
     * @param modal
     */
    public FontPreviewDialog(java.awt.Frame parent, boolean modal, Font font) {
        super();
        setModal(true);
        initComponents();
        View.setWindowIcon(this);

        labelSample12.setFont(font.deriveFont(12f));
        labelSample18.setFont(font.deriveFont(18f));
        labelSample24.setFont(font.deriveFont(24f));
        labelSample36.setFont(font.deriveFont(36f));
        labelSample48.setFont(font.deriveFont(48f));
        labelSample60.setFont(font.deriveFont(60f));
        labelSample72.setFont(font.deriveFont(72f));
        comboBoxSampleTexts.setSelectedIndex(Configuration.guiFontPreviewSampleText.get(0));
        if (Configuration.guiFontPreviewWidth.hasValue()) {
            int width = Configuration.guiFontPreviewWidth.get();
            int height = Configuration.guiFontPreviewHeight.get();
            setSize(width, height);
        }
        if (Configuration.guiFontPreviewPosX.hasValue()) {
            int posX = Configuration.guiFontPreviewPosX.get();
            int posY = Configuration.guiFontPreviewPosY.get();
            setLocation(posX, posY);
        }
        setText((String) comboBoxSampleTexts.getSelectedItem());
        labelFontName.setText(font.getFontName());
    }

    private void setText(String text) {
        labelSample12.setText(text);
        labelSample18.setText(text);
        labelSample24.setText(text);
        labelSample36.setText(text);
        labelSample48.setText(text);
        labelSample60.setText(text);
        labelSample72.setText(text);
    }

    private ComboBoxModel<String> getModel() {
        List<String> sampleTexts = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(FontPreviewDialog.class.getResourceAsStream("/com/jpexs/decompiler/flash/tags/font/font_preview_samples.txt"), Utf8Helper.charset));
        String s;
        try {
            while ((s = br.readLine()) != null) {
                sampleTexts.add(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(FontPreviewDialog.class.getName()).log(Level.SEVERE, "Cannot read font preview dialog sample texts", ex);
        }
        return new DefaultComboBoxModel<>(sampleTexts.toArray(new String[sampleTexts.size()]));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        labelSample72 = new javax.swing.JLabel();
        labelSample60 = new javax.swing.JLabel();
        labelSample12 = new javax.swing.JLabel();
        labelSample24 = new javax.swing.JLabel();
        labelSample48 = new javax.swing.JLabel();
        labelSample36 = new javax.swing.JLabel();
        labelSample18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxSampleTexts = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        labelFontName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/jpexs/decompiler/flash/gui/locales/FontPreviewDialog"); // NOI18N
        setTitle(bundle.getString("fontPreview.dialog.title")); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 512));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        labelSample72.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        labelSample72.setText("---");

        labelSample60.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        labelSample60.setText("---");

        labelSample12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelSample12.setText("---");

        labelSample24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSample24.setText("---");

        labelSample48.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelSample48.setText("---");

        labelSample36.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelSample36.setText("---");

        labelSample18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSample18.setText("---");

        jLabel2.setText("12");

        jLabel3.setText("18");

        jLabel4.setText("24");

        jLabel5.setText("36");

        jLabel6.setText("48");

        jLabel7.setText("60");

        jLabel8.setText("72");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSample72)
                    .addComponent(labelSample18)
                    .addComponent(labelSample12)
                    .addComponent(labelSample24)
                    .addComponent(labelSample36)
                    .addComponent(labelSample48)
                    .addComponent(labelSample60))
                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample12)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample18)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample24)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample36)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample48)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample60)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSample72)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        comboBoxSampleTexts.setModel(getModel());
        comboBoxSampleTexts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSampleTextsItemStateChanged(evt);
            }
        });

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("com/jpexs/decompiler/flash/gui/locales/MainFrame"); // NOI18N
        jLabel1.setText(bundle1.getString("font.name")); // NOI18N

        labelFontName.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxSampleTexts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFontName)
                        .addGap(519, 519, 519)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxSampleTexts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelFontName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSampleTextsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSampleTextsItemStateChanged
        Configuration.guiFontPreviewSampleText.set(comboBoxSampleTexts.getSelectedIndex());
        setText((String) comboBoxSampleTexts.getSelectedItem());
    }//GEN-LAST:event_comboBoxSampleTextsItemStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Configuration.guiFontPreviewWidth.set(getWidth());
        Configuration.guiFontPreviewHeight.set(getHeight());
    }//GEN-LAST:event_formComponentResized

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        Configuration.guiFontPreviewPosX.set(getX());
        Configuration.guiFontPreviewPosY.set(getY());
    }//GEN-LAST:event_formComponentMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxSampleTexts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFontName;
    private javax.swing.JLabel labelSample12;
    private javax.swing.JLabel labelSample18;
    private javax.swing.JLabel labelSample24;
    private javax.swing.JLabel labelSample36;
    private javax.swing.JLabel labelSample48;
    private javax.swing.JLabel labelSample60;
    private javax.swing.JLabel labelSample72;
    // End of variables declaration//GEN-END:variables
}
