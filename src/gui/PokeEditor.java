/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author User
 */
public class PokeEditor extends javax.swing.JDialog
{

    /**
     * Creates new form PokeEditor
     */
    public PokeEditor(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        
        for(data.PokemonList pkm: data.PokemonList.values())
        {
            cbPokemom.addItem(pkm);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        cbPokemom = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbType1 = new javax.swing.JLabel();
        lbType2 = new javax.swing.JLabel();
        lbLvl = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        slLvl = new javax.swing.JSlider();
        tfLvl = new javax.swing.JTextField();
        lbNickname = new javax.swing.JLabel();
        tfNickname = new javax.swing.JTextField();
        lbShiny = new javax.swing.JLabel();
        rbShiny = new javax.swing.JRadioButton();
        lbAbility = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbAbility = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbNature = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbMove1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbMove2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbMove3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbMove4 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbIVHP = new javax.swing.JLabel();
        slIvHP = new javax.swing.JSlider();
        tfIvHp = new javax.swing.JTextField();
        lbIVAtk = new javax.swing.JLabel();
        slIvAtk = new javax.swing.JSlider();
        tfIvAtk = new javax.swing.JTextField();
        lbIVDef = new javax.swing.JLabel();
        slIvDef = new javax.swing.JSlider();
        tfIvDef = new javax.swing.JTextField();
        lbIVSpAtk = new javax.swing.JLabel();
        slIvSpAtk = new javax.swing.JSlider();
        tfIvSpAtk = new javax.swing.JTextField();
        lbIVSpDef = new javax.swing.JLabel();
        slIvSpDef = new javax.swing.JSlider();
        tfIvSpDef = new javax.swing.JTextField();
        lbIVInit = new javax.swing.JLabel();
        slIvInit = new javax.swing.JSlider();
        tfIvInit = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbEVHP = new javax.swing.JLabel();
        slEvHP = new javax.swing.JSlider();
        tfEvHp = new javax.swing.JTextField();
        lbEVAtk = new javax.swing.JLabel();
        slEvAtk = new javax.swing.JSlider();
        tfEvAtk = new javax.swing.JTextField();
        lbEVDef = new javax.swing.JLabel();
        slEvDef = new javax.swing.JSlider();
        tfEvDef = new javax.swing.JTextField();
        lbEVSpAtk = new javax.swing.JLabel();
        slEvSpAtk = new javax.swing.JSlider();
        tfEvSpAtk = new javax.swing.JTextField();
        lbEVSpDef = new javax.swing.JLabel();
        slEvSpDef = new javax.swing.JSlider();
        tfEvSpDef = new javax.swing.JTextField();
        lbEVInit = new javax.swing.JLabel();
        slEvInit = new javax.swing.JSlider();
        tfEvInit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        getContentPane().add(cbPokemom, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel3.setLayout(new java.awt.GridLayout(11, 2));

        lbType1.setText("Type1");
        jPanel3.add(lbType1);

        lbType2.setText("Type2");
        jPanel3.add(lbType2);

        lbLvl.setText("Level: ");
        jPanel3.add(lbLvl);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        slLvl.setMajorTickSpacing(1);
        slLvl.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                updateLvlField(evt);
            }
        });
        jPanel6.add(slLvl);
        jPanel6.add(tfLvl);

        jPanel3.add(jPanel6);

        lbNickname.setText("Nickname: ");
        jPanel3.add(lbNickname);
        jPanel3.add(tfNickname);

        lbShiny.setText("Shiny: ");
        jPanel3.add(lbShiny);
        jPanel3.add(rbShiny);

        lbAbility.setText("Gender: ");
        jPanel3.add(lbAbility);

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbGender);

        jLabel5.setText("Ability: ");
        jPanel3.add(jLabel5);

        cbAbility.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbAbility);

        jLabel6.setText("Nature: ");
        jLabel6.setToolTipText("");
        jPanel3.add(jLabel6);

        cbNature.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbNature);

        jLabel7.setText("Move 1: ");
        jPanel3.add(jLabel7);

        cbMove1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbMove1);

        jLabel8.setText("Move 2: ");
        jPanel3.add(jLabel8);

        cbMove2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbMove2);

        jLabel9.setText("Move 3: ");
        jPanel3.add(jLabel9);

        cbMove3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbMove3);

        jLabel10.setText("Move 4: ");
        jPanel3.add(jLabel10);

        cbMove4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbMove4);

        jPanel1.add(jPanel3);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("IV"));
        jPanel5.setLayout(new java.awt.GridLayout(6, 3));

        lbIVHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIVHP.setText("Hp");
        jPanel5.add(lbIVHP);

        slIvHP.setMaximum(31);
        slIvHP.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateIvHPField(evt);
            }
        });
        jPanel5.add(slIvHP);

        tfIvHp.setEditable(false);
        jPanel5.add(tfIvHp);

        lbIVAtk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIVAtk.setText("Atk");
        jPanel5.add(lbIVAtk);

        slIvAtk.setMaximum(31);
        slIvAtk.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateIvAtkField(evt);
            }
        });
        jPanel5.add(slIvAtk);

        tfIvAtk.setEditable(false);
        tfIvAtk.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                onTypedInIvAtk(evt);
            }
        });
        jPanel5.add(tfIvAtk);

        lbIVDef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIVDef.setText("Def");
        jPanel5.add(lbIVDef);

        slIvDef.setMaximum(31);
        slIvDef.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateIvDefField(evt);
            }
        });
        jPanel5.add(slIvDef);

        tfIvDef.setEditable(false);
        tfIvDef.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                onTypedInIvDef(evt);
            }
        });
        jPanel5.add(tfIvDef);

        lbIVSpAtk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIVSpAtk.setText("SpAtk");
        jPanel5.add(lbIVSpAtk);

        slIvSpAtk.setMaximum(31);
        slIvSpAtk.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateIvSpAtkField(evt);
            }
        });
        jPanel5.add(slIvSpAtk);

        tfIvSpAtk.setEditable(false);
        tfIvSpAtk.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                onTypedInIvSpAtk(evt);
            }
        });
        jPanel5.add(tfIvSpAtk);

        lbIVSpDef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIVSpDef.setText("SpDef");
        jPanel5.add(lbIVSpDef);

        slIvSpDef.setMaximum(31);
        slIvSpDef.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateIvSpDefField(evt);
            }
        });
        jPanel5.add(slIvSpDef);

        tfIvSpDef.setEditable(false);
        tfIvSpDef.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                onTypedInIvSpDef(evt);
            }
        });
        jPanel5.add(tfIvSpDef);

        lbIVInit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIVInit.setText("Init");
        jPanel5.add(lbIVInit);

        slIvInit.setMaximum(31);
        slIvInit.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateIvIniField(evt);
            }
        });
        jPanel5.add(slIvInit);

        tfIvInit.setEditable(false);
        jPanel5.add(tfIvInit);

        jPanel2.add(jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("EV"));
        jPanel4.setLayout(new java.awt.GridLayout(6, 3));

        lbEVHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEVHP.setText("Hp");
        jPanel4.add(lbEVHP);

        slEvHP.setMaximum(252);
        slEvHP.setValue(0);
        slEvHP.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateEvHPField(evt);
            }
        });
        jPanel4.add(slEvHP);

        tfEvHp.setEditable(false);
        jPanel4.add(tfEvHp);

        lbEVAtk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEVAtk.setText("Atk");
        jPanel4.add(lbEVAtk);

        slEvAtk.setMaximum(252);
        slEvAtk.setValue(0);
        slEvAtk.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateEvAtkField(evt);
            }
        });
        jPanel4.add(slEvAtk);

        tfEvAtk.setEditable(false);
        jPanel4.add(tfEvAtk);

        lbEVDef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEVDef.setText("Def");
        jPanel4.add(lbEVDef);

        slEvDef.setMaximum(252);
        slEvDef.setValue(0);
        slEvDef.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateEvDefField(evt);
            }
        });
        jPanel4.add(slEvDef);

        tfEvDef.setEditable(false);
        jPanel4.add(tfEvDef);

        lbEVSpAtk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEVSpAtk.setText("SpAtk");
        jPanel4.add(lbEVSpAtk);

        slEvSpAtk.setMaximum(252);
        slEvSpAtk.setValue(0);
        slEvSpAtk.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateEvSpAtkField(evt);
            }
        });
        jPanel4.add(slEvSpAtk);

        tfEvSpAtk.setEditable(false);
        jPanel4.add(tfEvSpAtk);

        lbEVSpDef.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEVSpDef.setText("SpDef");
        jPanel4.add(lbEVSpDef);

        slEvSpDef.setMaximum(252);
        slEvSpDef.setValue(0);
        slEvSpDef.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateEvSpDefField(evt);
            }
        });
        jPanel4.add(slEvSpDef);

        tfEvSpDef.setEditable(false);
        jPanel4.add(tfEvSpDef);

        lbEVInit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEVInit.setText("Init");
        jPanel4.add(lbEVInit);

        slEvInit.setMaximum(252);
        slEvInit.setValue(0);
        slEvInit.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                onUpdateEvInitField(evt);
            }
        });
        jPanel4.add(slEvInit);

        tfEvInit.setEditable(false);
        jPanel4.add(tfEvInit);

        jPanel2.add(jPanel4);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateLvlField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_updateLvlField
    {//GEN-HEADEREND:event_updateLvlField
        tfLvl.setText(""+slLvl.getValue());
    }//GEN-LAST:event_updateLvlField

    private void onUpdateIvHPField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateIvHPField
    {//GEN-HEADEREND:event_onUpdateIvHPField
        tfIvHp.setText(""+slIvHP.getValue());
    }//GEN-LAST:event_onUpdateIvHPField

    private void onUpdateIvAtkField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateIvAtkField
    {//GEN-HEADEREND:event_onUpdateIvAtkField
        tfIvAtk.setText(""+slIvAtk.getValue());
    }//GEN-LAST:event_onUpdateIvAtkField

    private void onUpdateIvDefField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateIvDefField
    {//GEN-HEADEREND:event_onUpdateIvDefField
        tfIvDef.setText(""+slIvDef.getValue());
    }//GEN-LAST:event_onUpdateIvDefField

    private void onUpdateIvSpAtkField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateIvSpAtkField
    {//GEN-HEADEREND:event_onUpdateIvSpAtkField
        tfIvSpAtk.setText(""+slIvSpAtk.getValue());
    }//GEN-LAST:event_onUpdateIvSpAtkField

    private void onUpdateIvSpDefField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateIvSpDefField
    {//GEN-HEADEREND:event_onUpdateIvSpDefField
        tfIvSpDef.setText(""+slIvDef.getValue());
    }//GEN-LAST:event_onUpdateIvSpDefField

    private void onUpdateIvIniField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateIvIniField
    {//GEN-HEADEREND:event_onUpdateIvIniField
        tfIvInit.setText(""+slIvInit.getValue());
    }//GEN-LAST:event_onUpdateIvIniField

    private void onUpdateEvHPField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateEvHPField
    {//GEN-HEADEREND:event_onUpdateEvHPField
        if(calcEvSum() <= 510)
            tfEvHp.setText(""+slEvHP.getValue());
        else
        {
            tfEvHp.setText(""+(510-calcEvSum()-slEvHP.getValue()));
            slEvHP.setValue(510-(calcEvSum()-slEvHP.getValue()));
        }
    }//GEN-LAST:event_onUpdateEvHPField

    private void onUpdateEvAtkField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateEvAtkField
    {//GEN-HEADEREND:event_onUpdateEvAtkField
        if(calcEvSum() <= 510)
            tfEvAtk.setText(""+slEvAtk.getValue());
        else
        {
            tfEvAtk.setText(""+(510-calcEvSum()-slEvAtk.getValue()));
            slEvAtk.setValue(510-(calcEvSum()-slEvAtk.getValue()));
        }
    }//GEN-LAST:event_onUpdateEvAtkField

    private void onUpdateEvDefField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateEvDefField
    {//GEN-HEADEREND:event_onUpdateEvDefField
        if(calcEvSum() <= 510)
            tfEvDef.setText(""+slEvDef.getValue());
        else
        {
            tfEvDef.setText(""+(510-calcEvSum()-slEvDef.getValue()));
            slEvDef.setValue(510-(calcEvSum()-slEvDef.getValue()));
        }
    }//GEN-LAST:event_onUpdateEvDefField

    private void onUpdateEvSpAtkField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateEvSpAtkField
    {//GEN-HEADEREND:event_onUpdateEvSpAtkField
        if(calcEvSum() <= 510)
            tfEvSpAtk.setText(""+slEvSpAtk.getValue());
        else
        {
            tfEvSpAtk.setText(""+(510-(calcEvSum()-slEvSpAtk.getValue())));
            slEvSpAtk.setValue(510-(calcEvSum()-slEvSpAtk.getValue()));
        }
    }//GEN-LAST:event_onUpdateEvSpAtkField

    private void onUpdateEvSpDefField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateEvSpDefField
    {//GEN-HEADEREND:event_onUpdateEvSpDefField
        if(calcEvSum() <= 510)
            tfEvSpDef.setText(""+slEvSpDef.getValue());
        else
        {
            tfEvSpDef.setText(""+(510-(calcEvSum()-slEvSpDef.getValue())));
            slEvSpDef.setValue(510-(calcEvSum()-slEvSpDef.getValue()));
        }
    }//GEN-LAST:event_onUpdateEvSpDefField

    private void onUpdateEvInitField(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_onUpdateEvInitField
    {//GEN-HEADEREND:event_onUpdateEvInitField
        if(calcEvSum() <= 510)
            tfEvInit.setText(""+slEvInit.getValue());
        else
        {
            tfEvInit.setText(""+(510-(calcEvSum()-slEvInit.getValue())));
            slEvInit.setValue(510-(calcEvSum()-slEvInit.getValue()));
        }
    }//GEN-LAST:event_onUpdateEvInitField

    private void onTypedInIvAtk(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_onTypedInIvAtk
    {//GEN-HEADEREND:event_onTypedInIvAtk
        // TODO add your handling code here:
    }//GEN-LAST:event_onTypedInIvAtk

    private void onTypedInIvDef(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_onTypedInIvDef
    {//GEN-HEADEREND:event_onTypedInIvDef
        // TODO add your handling code here:
    }//GEN-LAST:event_onTypedInIvDef

    private void onTypedInIvSpAtk(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_onTypedInIvSpAtk
    {//GEN-HEADEREND:event_onTypedInIvSpAtk
        // TODO add your handling code here:
    }//GEN-LAST:event_onTypedInIvSpAtk

    private void onTypedInIvSpDef(java.beans.PropertyChangeEvent evt)//GEN-FIRST:event_onTypedInIvSpDef
    {//GEN-HEADEREND:event_onTypedInIvSpDef
        // TODO add your handling code here:
    }//GEN-LAST:event_onTypedInIvSpDef

    private int calcEvSum()
    {
        int sum = 0;
        
//        if(!tfEvHp.getText().isEmpty())
//            sum+=Integer.parseInt(tfEvHp.getText());
        sum = slEvHP.getValue()+slEvAtk.getValue()+slEvDef.getValue()+slEvSpAtk.getValue()+slEvSpDef.getValue()+slEvInit.getValue();
        System.out.println(sum);
        return sum;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(PokeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(PokeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(PokeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(PokeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                PokeEditor dialog = new PokeEditor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbAbility;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbMove1;
    private javax.swing.JComboBox<String> cbMove2;
    private javax.swing.JComboBox<String> cbMove3;
    private javax.swing.JComboBox<String> cbMove4;
    private javax.swing.JComboBox<String> cbNature;
    private javax.swing.JComboBox<data.PokemonList> cbPokemom;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbAbility;
    private javax.swing.JLabel lbEVAtk;
    private javax.swing.JLabel lbEVDef;
    private javax.swing.JLabel lbEVHP;
    private javax.swing.JLabel lbEVInit;
    private javax.swing.JLabel lbEVSpAtk;
    private javax.swing.JLabel lbEVSpDef;
    private javax.swing.JLabel lbIVAtk;
    private javax.swing.JLabel lbIVDef;
    private javax.swing.JLabel lbIVHP;
    private javax.swing.JLabel lbIVInit;
    private javax.swing.JLabel lbIVSpAtk;
    private javax.swing.JLabel lbIVSpDef;
    private javax.swing.JLabel lbLvl;
    private javax.swing.JLabel lbNickname;
    private javax.swing.JLabel lbShiny;
    private javax.swing.JLabel lbType1;
    private javax.swing.JLabel lbType2;
    private javax.swing.JRadioButton rbShiny;
    private javax.swing.JSlider slEvAtk;
    private javax.swing.JSlider slEvDef;
    private javax.swing.JSlider slEvHP;
    private javax.swing.JSlider slEvInit;
    private javax.swing.JSlider slEvSpAtk;
    private javax.swing.JSlider slEvSpDef;
    private javax.swing.JSlider slIvAtk;
    private javax.swing.JSlider slIvDef;
    private javax.swing.JSlider slIvHP;
    private javax.swing.JSlider slIvInit;
    private javax.swing.JSlider slIvSpAtk;
    private javax.swing.JSlider slIvSpDef;
    private javax.swing.JSlider slLvl;
    private javax.swing.JTextField tfEvAtk;
    private javax.swing.JTextField tfEvDef;
    private javax.swing.JTextField tfEvHp;
    private javax.swing.JTextField tfEvInit;
    private javax.swing.JTextField tfEvSpAtk;
    private javax.swing.JTextField tfEvSpDef;
    private javax.swing.JTextField tfIvAtk;
    private javax.swing.JTextField tfIvDef;
    private javax.swing.JTextField tfIvHp;
    private javax.swing.JTextField tfIvInit;
    private javax.swing.JTextField tfIvSpAtk;
    private javax.swing.JTextField tfIvSpDef;
    private javax.swing.JTextField tfLvl;
    private javax.swing.JTextField tfNickname;
    // End of variables declaration//GEN-END:variables
}
