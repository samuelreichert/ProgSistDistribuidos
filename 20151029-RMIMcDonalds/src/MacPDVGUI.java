import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MacPDVGUI extends javax.swing.JFrame {
    MacPDVService pdv;

    public MacPDVGUI() {
        initComponents();
        startRegistry();
    }

    public void startRegistry(){
        try {
            pdv = new MacPDVService();
            Registry r = LocateRegistry.createRegistry(8088);
            String uri = "rmi://localhost:8088/pdv";
            Naming.rebind(uri, pdv);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btComprarFritas = new javax.swing.JButton();
        btComprarBigMac = new javax.swing.JButton();
        btEntregar = new javax.swing.JButton();
        btComprarRefri = new javax.swing.JButton();
        btComprarSuco = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btComprarFritas.setText("Fritas");
        btComprarFritas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarFritasActionPerformed(evt);
            }
        });

        btComprarBigMac.setText("Big Mac");
        btComprarBigMac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarBigMacActionPerformed(evt);
            }
        });

        btEntregar.setText("Entrega");
        btEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntregarActionPerformed(evt);
            }
        });

        btComprarRefri.setText("Refri");
        btComprarRefri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarRefriActionPerformed(evt);
            }
        });

        btComprarSuco.setText("Suco");
        btComprarSuco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarSucoActionPerformed(evt);
            }
        });

        labelStatus.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
        labelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatus.setText("Nenhum Pedido");
        labelStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btComprarFritas, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(btComprarRefri, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btComprarBigMac, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(btComprarSuco, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addComponent(btEntregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btComprarBigMac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btComprarFritas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btComprarRefri, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btComprarSuco, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(btEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btComprarFritasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarFritasActionPerformed
        pdv.makeOrder(new Order("Fritas"));
        labelStatus.setText("Pedido em Processamento");
        labelStatus.setForeground(Color.red);
        btEntregar.setEnabled(false);
    }//GEN-LAST:event_btComprarFritasActionPerformed

    private void btComprarBigMacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarBigMacActionPerformed
        pdv.makeOrder(new Order("Big Mac"));
        labelStatus.setText("Pedido em Processamento");
        labelStatus.setForeground(Color.red);
        btEntregar.setEnabled(false);
    }//GEN-LAST:event_btComprarBigMacActionPerformed

    private void btEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntregarActionPerformed
        pdv.delivery();
    }//GEN-LAST:event_btEntregarActionPerformed

    private void btComprarRefriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarRefriActionPerformed
        pdv.makeOrder(new Order("Refri"));
        labelStatus.setText("Pedido em Processamento");
        labelStatus.setForeground(Color.red);
        btEntregar.setEnabled(false);
    }//GEN-LAST:event_btComprarRefriActionPerformed

    private void btComprarSucoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarSucoActionPerformed
        pdv.makeOrder(new Order("Suco"));
        labelStatus.setText("Pedido em Processamento");
        labelStatus.setForeground(Color.red);
        btEntregar.setEnabled(false);
    }//GEN-LAST:event_btComprarSucoActionPerformed

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
            java.util.logging.Logger.getLogger(MacPDVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MacPDVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MacPDVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MacPDVGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MacPDVGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComprarBigMac;
    private javax.swing.JButton btComprarFritas;
    private javax.swing.JButton btComprarRefri;
    private javax.swing.JButton btComprarSuco;
    public static javax.swing.JButton btEntregar;
    public static javax.swing.JLabel labelStatus;
    // End of variables declaration//GEN-END:variables
}
