/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.advertisementEnterprise.accountingOrganization;

import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import biz.fnc.AdViewsOrder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

/**
 *
 * @author royn
 */
public class ManageOrders extends javax.swing.JPanel implements TablePopulatable<AdViewsOrder>,HasTitle{
    private ParentUI parentUI;
    private Account account;
    /**
     * Creates new form NewJPanel
     */

    public ManageOrders(ParentUI parent, Account account) {
        this.parentUI = parent;
        this.account = account;
        initComponents();
        populateTable();
        AdCompanyEnterprise companyEnterprise = (AdCompanyEnterprise) account.getOrg().getEnterprise();
        lblRemain.setText(String.valueOf(companyEnterprise.getRemainingAdViews()));
        txtTotal.setEnabled(false);
        txtTotal.setText("N/A");
        txtQuantity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTxtTotalPrice();
            }
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTxtTotalPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTxtTotalPrice();
            }
        });
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
        tblAdOrder = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtInformation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblRemain = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        tblAdOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Create Time", "Information", "Quantity Bought", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblAdOrder);

        jButton3.setText("Send Request");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtQuantity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtQuantityInputMethodTextChanged(evt);
            }
        });
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantity:");

        jLabel2.setText("Information:");

        jLabel3.setText("Remain Quantity:");

        jLabel4.setText("Order History:");

        jLabel5.setText("TotalAmount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(39, 39, 39)
                                .addComponent(txtInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRemain, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRemain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(310, 310, 310)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int quantity;
        try{
            quantity = Integer.parseInt(txtQuantity.getText());
            if(quantity <= 0){
                throw new Exception();
            }else if(quantity > 2000){
                throw new Exception();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please input valid number!Number should between 0-2000!");
            return;
        }
        String information = txtInformation.getText();
        if(information.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please input valid information");
            return;
        }
        AdCompanyEnterprise company = (AdCompanyEnterprise) account.getOrg().getEnterprise();
        company.getAdViewsOrderCatalog().newAdViewsOrder(quantity, information);
        txtInformation.setText("");
        txtQuantity.setText("");
        populateTable();
        JOptionPane.showMessageDialog(this, "Congratulations!Request has been send,you may wait for few seconds");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtQuantityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtQuantityInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityInputMethodTextChanged

    private Integer parseAmount() throws Exception {
        Integer amount;
        try {
            amount = Integer.parseInt(txtQuantity.getText());
            if (amount <= 0) {
                throw new Exception("Invalid, amount must be greater than 0.");
            }
            if (amount > 2000) {
                throw new Exception("Invalid, amount must be no greater than 2000");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Invalid, amount must be an integer from 0 - 2000");
        }
        return amount;
    }
    
    private void updateTxtTotalPrice() {
        Integer amount;
        try {
            amount = parseAmount();
        } catch (Exception e){
            txtTotal.setText("N/A");
            return;
        }
        AdCompanyEnterprise companyEnterprise = (AdCompanyEnterprise) account.getOrg().getEnterprise();
        double totalPrice = companyEnterprise.getAdViewPrice(amount);
        txtTotal.setText(String.format("%.2f", totalPrice));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRemain;
    private javax.swing.JTable tblAdOrder;
    private javax.swing.JTextField txtInformation;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return tblAdOrder;
    }

    @Override
    public Object[] populateRow(AdViewsOrder element) {
        return new Object[]{
            element,
            element.getInformation(),
            element.getQuantity(),
            element.getStatus()
        };
    }

    @Override
    public void populateTable() {
        AdCompanyEnterprise company = (AdCompanyEnterprise) account.getOrg().getEnterprise();
        populateTable(company.getAdViewsOrderCatalog().getAdViewsOrders());
    }

    @Override
    public String getTitle() {
        return "Manage AdvertisementOrders";
    }
}
