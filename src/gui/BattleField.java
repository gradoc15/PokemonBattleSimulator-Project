/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import battle.battleBl;
import data.Pokemon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class BattleField extends javax.swing.JFrame
{

    /**
     * Creates new form BattleField
     */
    
    private data.Pokemon ownTeam[];
    private battle.battleBl battleBl;
    
    private JLabel teamSlots[] = new JLabel[6];
    private JLabel moveSlots[] = new JLabel[4];
    
    public BattleField()
    {
        initComponents();
    }

    public BattleField(Pokemon[] ownTeam, int amount)
    {
        initComponents();
        
        this.ownTeam = new data.Pokemon[amount];
        for(int i = 0; i < amount; i++)
        {
            this.ownTeam[i] = ownTeam[i];
        }
        
        //Enemy Team
        data.Pokemon p1 = ownTeam[0];
        data.Pokemon enemyTeam[] = new data.Pokemon[1];
        enemyTeam[0] = p1;

        
        battleBl = new battle.battleBl(this.ownTeam, enemyTeam);
        
        
        init();
    }
    
    private void init()
    {
        teamSlots[0] = lbSlot1;
        teamSlots[1] = lbSlot2;
        teamSlots[2] = lbSlot3;
        teamSlots[3] = lbSlot4;
        teamSlots[4] = lbSlot5;
        teamSlots[5] = lbSlot6;
        
        moveSlots[0] = lbMove1;
        moveSlots[1] = lbMove2;
        moveSlots[2] = lbMove3;
        moveSlots[3] = lbMove4;
        
        
        lbESlot1.setOpaque(true);
        lbESlot2.setOpaque(true);
        lbESlot3.setOpaque(true);
        lbESlot4.setOpaque(true);
        lbESlot5.setOpaque(true);
        lbESlot6.setOpaque(true);
        
        
        for(int i = 0; i < teamSlots.length; i++)
        {
            if(ownTeam.length > i)
            {
                if(ownTeam[i] != null)
                    teamSlots[i].setText(ownTeam[i].getName());
                teamSlots[i].setOpaque(true);
                teamSlots[i].setBackground(java.awt.Color.green);
                
                
                
            }
            else
            {
                teamSlots[i].setOpaque(true);
                teamSlots[i].setBackground(java.awt.Color.gray);

            }
        }
        
        //Setting acutal Pokemon slot
        battleBl.changeActPokemon(true, 0);
        battleBl.changeActPokemon(false, 0);
        
        updateUI();
    }
    
    
    public void updateUI()
    {

        boolean actTurn = battleBl.isMyTurn();

        battleBl.setTurn(true);
        System.out.println(battleBl.getActPokemon());
        lbMyPokemon.setText(battleBl.getActPokemon().getName());
        pbMyHP.setValue(battleBl.getHPPercent());
        lbHPPercentOwn.setText("" + battleBl.getHPPercent() + "%");

        for (int i = 0; i < moveSlots.length; i++) {
            moveSlots[i].setText("<html><body>" + battleBl.getActPokemon().getMove()[i].getBez() + "<br>" + battleBl.getActPokemon().getMovePP()[i] + "/10</body></html>");
        }

        battleBl.setTurn(false);
        lbEnemyPokemon.setText(battleBl.getActPokemon().getName());
        pbEnemyHP.setValue(battleBl.getHPPercent());
        lbHPPercentEnemy.setText("" + battleBl.getHPPercent() + "%");

        
            
            for(int i = 0; i < battleBl.getEnemyTeam().length; i++)
            { 
                switch(i)
                {
                    case 0: 
                    {
                        lbESlot1.setBackground(battleBl.getEnemyTeam()[i].isBattleRdy() ? java.awt.Color.GREEN : java.awt.Color.RED); 
                        lbESlot1.setText((battleBl.getEnemyTeam()[i].isBattleRdy() ? "O" : "X"));
                    }break;
                    case 1: 
                    {
                        lbESlot2.setBackground(battleBl.getEnemyTeam()[i].isBattleRdy() ? java.awt.Color.GREEN : java.awt.Color.RED);
                        lbESlot2.setText((battleBl.getEnemyTeam()[i].isBattleRdy() ? "O" : "X"));
                    }break;
                    case 2: 
                    {
                        lbESlot3.setBackground(battleBl.getEnemyTeam()[i].isBattleRdy() ? java.awt.Color.GREEN : java.awt.Color.RED); 
                        lbESlot3.setText((battleBl.getEnemyTeam()[i].isBattleRdy() ? "O" : "X"));
                    }break;
                    case 3: 
                    {
                        lbESlot4.setBackground(battleBl.getEnemyTeam()[i].isBattleRdy() ? java.awt.Color.GREEN : java.awt.Color.RED);
                        lbESlot4.setText((battleBl.getEnemyTeam()[i].isBattleRdy() ? "O" : "X"));
                    } break;
                    case 4: 
                    {
                        lbESlot5.setBackground(battleBl.getEnemyTeam()[i].isBattleRdy() ? java.awt.Color.GREEN : java.awt.Color.RED);
                        lbESlot5.setText((battleBl.getEnemyTeam()[i].isBattleRdy() ? "O" : "X"));
                    }break;
                    case 5:
                    {
                        lbESlot6.setBackground(battleBl.getEnemyTeam()[i].isBattleRdy() ? java.awt.Color.GREEN : java.awt.Color.RED);
                        lbESlot6.setText((battleBl.getEnemyTeam()[i].isBattleRdy() ? "O" : "X"));
                    }break;
                }
            battleBl.setTurn(actTurn);     
        }
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plTeamPriview = new javax.swing.JPanel();
        lbSlot1 = new javax.swing.JLabel();
        lbSlot2 = new javax.swing.JLabel();
        lbSlot3 = new javax.swing.JLabel();
        lbSlot4 = new javax.swing.JLabel();
        lbSlot5 = new javax.swing.JLabel();
        lbSlot6 = new javax.swing.JLabel();
        lbMyPokemon = new javax.swing.JLabel();
        lbEnemyPokemon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbMove1 = new javax.swing.JLabel();
        lbMove2 = new javax.swing.JLabel();
        lbMove3 = new javax.swing.JLabel();
        lbMove4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbESlot1 = new javax.swing.JLabel();
        lbESlot2 = new javax.swing.JLabel();
        lbESlot3 = new javax.swing.JLabel();
        lbESlot4 = new javax.swing.JLabel();
        lbESlot5 = new javax.swing.JLabel();
        lbESlot6 = new javax.swing.JLabel();
        pbMyHP = new javax.swing.JProgressBar();
        pbEnemyHP = new javax.swing.JProgressBar();
        lbHPPercentEnemy = new java.awt.Label();
        lbHPPercentOwn = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        plTeamPriview.setMinimumSize(new java.awt.Dimension(215, 600));
        plTeamPriview.setLayout(new java.awt.GridLayout(6, 0));

        lbSlot1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlot1.setText("empty");
        lbSlot1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickedSlot1(evt);
            }
        });
        plTeamPriview.add(lbSlot1);

        lbSlot2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlot2.setText("empty");
        plTeamPriview.add(lbSlot2);

        lbSlot3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlot3.setText("empty");
        plTeamPriview.add(lbSlot3);

        lbSlot4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlot4.setText("empty");
        plTeamPriview.add(lbSlot4);

        lbSlot5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlot5.setText("empty");
        plTeamPriview.add(lbSlot5);

        lbSlot6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlot6.setText("empty");
        plTeamPriview.add(lbSlot6);

        lbMyPokemon.setBackground(new java.awt.Color(153, 255, 204));
        lbMyPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMyPokemon.setText("empty");
        lbMyPokemon.setOpaque(true);

        lbEnemyPokemon.setBackground(new java.awt.Color(153, 255, 204));
        lbEnemyPokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEnemyPokemon.setText("empty");
        lbEnemyPokemon.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(485, 115));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        lbMove1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMove1.setText("/");
        lbMove1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbMove1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClickedMove1(evt);
            }
        });
        jPanel1.add(lbMove1);

        lbMove2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMove2.setText("/");
        lbMove2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbMove2);

        lbMove3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMove3.setText("/");
        lbMove3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbMove3);

        lbMove4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMove4.setText("/");
        lbMove4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbMove4);

        jPanel2.setLayout(new java.awt.GridLayout(1, 6));

        lbESlot1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbESlot1.setText("/");
        jPanel2.add(lbESlot1);

        lbESlot2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbESlot2.setText("/");
        jPanel2.add(lbESlot2);

        lbESlot3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbESlot3.setText("/");
        jPanel2.add(lbESlot3);

        lbESlot4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbESlot4.setText("/");
        jPanel2.add(lbESlot4);

        lbESlot5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbESlot5.setText("/");
        jPanel2.add(lbESlot5);

        lbESlot6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbESlot6.setText("/");
        jPanel2.add(lbESlot6);

        pbMyHP.setToolTipText("");
        pbMyHP.setValue(50);
        pbMyHP.setAutoscrolls(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(plTeamPriview, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMyPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbMyHP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHPPercentOwn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 232, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pbEnemyHP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lbHPPercentEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbEnemyPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plTeamPriview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbEnemyPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pbEnemyHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHPPercentEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pbMyHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbHPPercentOwn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbMyPokemon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onClickedSlot1(java.awt.event.MouseEvent evt)//GEN-FIRST:event_onClickedSlot1
    {//GEN-HEADEREND:event_onClickedSlot1
        // TODO add your handling code here:
    }//GEN-LAST:event_onClickedSlot1

    private void onClickedMove1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClickedMove1
        try {
            battleBl.makeMove(0);
            updateUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_onClickedMove1

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
            java.util.logging.Logger.getLogger(BattleField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BattleField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BattleField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BattleField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new BattleField().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbESlot1;
    private javax.swing.JLabel lbESlot2;
    private javax.swing.JLabel lbESlot3;
    private javax.swing.JLabel lbESlot4;
    private javax.swing.JLabel lbESlot5;
    private javax.swing.JLabel lbESlot6;
    private javax.swing.JLabel lbEnemyPokemon;
    private java.awt.Label lbHPPercentEnemy;
    private java.awt.Label lbHPPercentOwn;
    private javax.swing.JLabel lbMove1;
    private javax.swing.JLabel lbMove2;
    private javax.swing.JLabel lbMove3;
    private javax.swing.JLabel lbMove4;
    private javax.swing.JLabel lbMyPokemon;
    private javax.swing.JLabel lbSlot1;
    private javax.swing.JLabel lbSlot2;
    private javax.swing.JLabel lbSlot3;
    private javax.swing.JLabel lbSlot4;
    private javax.swing.JLabel lbSlot5;
    private javax.swing.JLabel lbSlot6;
    private javax.swing.JProgressBar pbEnemyHP;
    private javax.swing.JProgressBar pbMyHP;
    private javax.swing.JPanel plTeamPriview;
    // End of variables declaration//GEN-END:variables
}
