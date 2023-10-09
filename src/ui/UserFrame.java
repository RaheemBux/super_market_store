/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import dao.UserDAO;
import daoimp.UserDAOImpl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.User;

/**
 *
 * @author DELL
 */
public class UserFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserFrame
     */
    UserDAO userDAO = new UserDAOImpl();
    DefaultTableModel userTableModel = null;
    String[] column = {"ID","FName","LName","Ph#","Email","Password","Created Date",
                        "Modified Date","Created By","Updated By","Status"};
     Integer userId = 0;
     DateFormat dform = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
    public UserFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        fillUserTable();
       
    }

    private void fillUserTable() {
        userTableModel = new DefaultTableModel(column, 0);
        List<User> user = userDAO.getAllUser();

        for (User u : user) {
            
            Object[] row = {u.getId(),u.getfName(),u.getlName(),u.getPhoneNum(),u.getUEmail(),u.getPassword(),u.getCreatedDate(),u.getModifiedDate(),"","",u.isStatus()};
            userTableModel.addRow(row);
            userTable.setModel(userTableModel);

        }
        userTable.getColumnModel().getColumn(0).setWidth(0);
        userTable.getColumnModel().getColumn(0).setMinWidth(0);
        userTable.getColumnModel().getColumn(0).setMaxWidth(0);
    }

   private void clearFields() {
        fname.setText("");
        lname.setText("");
        phoneNum.setText("");
        user_email.setText("");
        password.setText("");
    }
    private User getUserFields(){
        String fName = fname.getText();
        String lName = lname.getText();
        String phNum = phoneNum.getText();
        String userEmail = user_email.getText();
        String userPwd = password.getText();
        
        User user = new User();
        user.setfName(fName);
        user.setlName(lName);
        user.setUEmail(userEmail);
        user.setPhoneNum(phNum);
        user.setPassword(userPwd);
        
        //Date obj = new Date();
        user.setCreatedDate( new Date(System.currentTimeMillis()));
        user.setModifiedDate(new Date(System.currentTimeMillis()));
        return user;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phoneNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        user_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        password = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 44, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("User");

        backBtn.setText("Back");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("FName : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("LName : ");

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ph# : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Email");

        user_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_emailActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Password :");

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        ClearBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FName", "LName", "Ph#", "Email", "Password", "Created Date", "Modified Date", "Created By", "Updated By", "Status"
            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fname)
                                    .addComponent(lname, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(password))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(user_email, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(phoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(107, 107, 107))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(addBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(UpdateBtn)
                                        .addGap(38, 38, 38)
                                        .addComponent(DeleteBtn)
                                        .addGap(32, 32, 32)
                                        .addComponent(ClearBtn)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 56, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(phoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(user_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(addBtn)
                    .addComponent(UpdateBtn)
                    .addComponent(ClearBtn)
                    .addComponent(DeleteBtn)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void user_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_emailActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
         boolean success = userDAO.addUser(getUserFields());
        if (success) {
            JOptionPane.showMessageDialog(this, "Added Successfully");
            fillUserTable();
            clearFields();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
        User user = new User();
         user = this.getUserFields();
        user.setId(userId);
        System.out.println(user.getPassword());
        boolean success = userDAO.updateUser(user);
        
        if (success) {
            JOptionPane.showMessageDialog(this, "Added Successfully");
            fillUserTable();
            clearFields();
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        // TODO add your handling code here:
        userId = Integer.parseInt(userTable.getValueAt(userTable.getSelectedRow(), 0).toString());
        User user = userDAO.getUserById(userId);
        fname.setText(user.getfName());
        lname.setText(user.getlName());
        user_email.setText(user.getUEmail());
        phoneNum.setText(user.getPhoneNum());
       
        password.setText(user.getPassword());
        
    }//GEN-LAST:event_userTableMouseClicked

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
         User user = this.getUserFields();
        user.setId(userId);
        boolean success = userDAO.deleteUser(user);
        if (success) {
            JOptionPane.showMessageDialog(this, "Deleted Successfully");
            fillUserTable();
            clearFields();
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        clearFields();
    }//GEN-LAST:event_ClearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField password;
    private javax.swing.JTextField phoneNum;
    private javax.swing.JTable userTable;
    private javax.swing.JTextField user_email;
    // End of variables declaration//GEN-END:variables
}