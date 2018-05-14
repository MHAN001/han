/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.commonadm.ManageAccount;

import biz.EcoSystem;
import biz.account.Account;
import biz.enterprises.Enterprise;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

/**
 *
 * @author royn
 */
public class ManageAccounts extends javax.swing.JPanel implements TablePopulatable<Account>, HasTitle {

    private ParentUI parent;
    private Account account;
    private EcoSystem ecoSystem;
    private Enterprise enterprise;

    /**
     * Creates new form ManageAccounts
     */
    public ManageAccounts(ParentUI parent, Account account) {
        initComponents();
        this.account = account;
        this.parent = parent;
        ecoSystem = EcoSystem.getInstance();
        enterprise = account.getOrg().getEnterprise();
        populateTable();
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
        tblUser = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Owner", "Role", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUser);

        btnAdd.setText("Add Account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit Selected");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Selected");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(0, 539, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        parent.pushComponent(new AddOrEditAccounts(enterprise));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        Account a = getSelected();
        if (a == null) {
            return;
        }
        parent.pushComponent(new AddOrEditAccounts(enterprise, a));
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        Account a = getSelected();
        
        if (a == null) {
            return;
        }
        
        if (a == account){
            JOptionPane.showMessageDialog(this, "You cannot delete the Account of yourself!");
            return;
        }
        
        populateTable();
        a.getOrg().getAccountCatalog().removeAccount(a);
        JOptionPane.showMessageDialog(this, "Success!");
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return tblUser;
    }

    @Override
    public Object[] populateRow(Account a) {
        return new Object[]{a,
            a.getPerson(),
            a.getRole(),
            a.isActive()};
    }

    @Override
    public void populateTable() {
        populateTable(ecoSystem.getAllAccountArrayList()
                .stream().filter(v -> (v.getOrg() != null) && v.getOrg().getEnterprise()
                .equals(account.getOrg().getEnterprise())));
    }

    @Override
    public String getTitle() {
        return String.format("Manage Accounts in %s", account.getOrg().getEnterprise());
    }
}
