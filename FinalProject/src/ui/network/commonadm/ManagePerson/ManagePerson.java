/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.commonadm.ManagePerson;

import biz.account.Account;
import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.person.Person;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

public class ManagePerson extends javax.swing.JPanel implements HasTitle, TablePopulatable<Person>{
    private ParentUI parent;
    private Account account;
    private Organization organization;
    private Enterprise enterprise;
    
    /**
     * Creates new form ManageCollege
     */
    public ManagePerson(ParentUI parent, Account account){
        this(parent, account, null);
    }
    
    public ManagePerson(ParentUI parent, Account account, Organization organization) {
        this.parent = parent;
        this.account = account;
        this.organization = organization;
        this.enterprise = account.getOrg().getEnterprise();
        
        
        
        initComponents();
        btnAdd.setText("Add Persons");
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

        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();

        btnAdd.setText("Add Person");
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

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "E-mail", "Organization"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUser);

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
        if(organization != null){
            parent.pushComponent(new AddOrEditPerson(enterprise, organization));
        }else{
            parent.pushComponent(new AddOrEditPerson(enterprise));
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       Person person = getSelected();
       Organization organizationofSelected = person.getOrg();
       if (person == null) {
           return;
       }
       parent.pushComponent(new AddOrEditPerson(enterprise, organizationofSelected, person));
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
       Person person = getSelected();
       if (person == null) {
           return;
       }
       
       if (person == account.getPerson()){
           JOptionPane.showMessageDialog(this, "You cannot delete your own information!");
       }
       
       person.getOrg().getPersonCatalog().getPersonList().remove(person);
       populateTable();
       JOptionPane.showMessageDialog(null, "Success");
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return String.format("Manage persons in %s", enterprise.getName());
    }

    @Override
    public JTable getTable() {
        return tblUser;
    }

    @Override
    public Object[] populateRow(Person person) {
        return new Object[] {
            person,
            person.getEmail(),
            person.getOrg(),
        };
    }

    @Override
    public void populateTable() {
        if(organization != null){
            populateTable(organization.getPersonCatalog().getPersonList());
        }
        else{
            ArrayList<Person> persons = new ArrayList<>();
            enterprise.getOrganizationArrayList().forEach((o) -> {
                persons.addAll(o.getPersonCatalog().getPersonList());
            });
            populateTable(persons);
        }
    }
}