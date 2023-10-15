/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import dao.ProductCategoryDAO;
import daoimp.ProductCategoryDAOImp;
import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author SAQIB
 */
public class ProductCategoryFrame extends javax.swing.JFrame {
    ProductCategoryDAO pcDAO=new ProductCategoryDAOImp();
    Object columns[]={"ID","Name","Code","Date","Created_by","Updated_by","Status"};
    DefaultTableModel defaultTableModel;
    
    /**
     * Creates new form ProductCategory
     */
    public ProductCategoryFrame() {
        initComponents();
        setLocationRelativeTo(null);
        fillbTable();
       
    }
    
    
    
     private void clearFields(){
        nameField.setText(""); 
        codeField.setText("");
        datePickerField.setCalendar(null);
        
    }
     
     
     
     
        private void fillbTable() {
        defaultTableModel = new DefaultTableModel(columns, 0);
        List<model.ProductCategory> prod = pcDAO.getAllProduct(); 

        for (model.ProductCategory c : prod) {
            Object[] row = {c.getId(), c.getCategoryName(), c.getCategoryCode(),c.getCreateDate(),c.getCreatedBy(),c.getUpdatedBy(),c.isActive()};
            defaultTableModel.addRow(row);
            productTable.setModel(defaultTableModel);
        }
       productTable.getColumnModel().getColumn(0).setWidth(50);
       productTable.getColumnModel().getColumn(0).setMinWidth(100);
        productTable.getColumnModel().getColumn(0).setMaxWidth(100);
    }
        
        
        
        private model.ProductCategory getProdCtg() {
        String name = nameField.getText();
        String code = codeField.getText();
        String createdBy="sms";
        String updatedBy="sms";
        model.ProductCategory c = new model.ProductCategory();
        c.setCategoryName(name);
        c.setCategoryCode(code);
        c.setCreatedBy(createdBy);
        c.setUpdatedBy(updatedBy);
        return c;
    }
           

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        codeLabel = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        datePickerField = new com.toedter.calendar.JDateChooser();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/pxfuel.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Product Category");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameLabel.setText("Name");

        nameField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        codeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        codeLabel.setText("Code");

        codeField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dateLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dateLabel.setText("Date");

        datePickerField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        insertButton.setBackground(new java.awt.Color(0, 51, 153));
        insertButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insertButton.setForeground(new java.awt.Color(255, 0, 0));
        insertButton.setText("INSERT");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 51, 153));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 0, 0));
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(0, 51, 153));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(0, 51, 153));
        clearButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 0, 0));
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Created_Date", "Modified", "Created_by", "Updated_by", "Status"
            }
        ));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datePickerField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertButton)
                                .addGap(61, 61, 61)
                                .addComponent(updateButton)
                                .addGap(75, 75, 75)
                                .addComponent(deleteButton)
                                .addGap(62, 62, 62)
                                .addComponent(clearButton)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codeLabel)
                            .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLabel)
                            .addComponent(datePickerField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
//                String name=bName.getText();
//                ProductCategoryModel pc = new ProductCategoryModel();
//                ProductCategoryDAO pcd=new ProductCategoryDAOImp();
//                pc.setCategory_name(bName.getText());
//                boolean success = pcd.updateCategory(pc.getCategory_name());
//                  
//        
//        if(success){
//            JOptionPane.showMessageDialog(this,"Delete successfully");
//             fillbTable();
//            
//        }
//        
                model.ProductCategory pc = new model.ProductCategory();
                ProductCategoryDAO pcd=new ProductCategoryDAOImp();
                
                int[] selectedRows = productTable.getSelectedRows();
                TableModel model=productTable.getModel();
                for(int i : selectedRows)
                {
                    String name=nameField.getText();
                    String code=codeField.getText();
                    pc.setCategoryName(name);
                    pc.setCategoryCode(code);
                    int id = (int) model.getValueAt(i, 0);
                    pc.setId(id);
                    
                    model.setValueAt(name, i, 1);
                    model.setValueAt(code, i, 2);
                    
                }
                boolean success = pcd.updateCategory(pc);
        
        if(success){
            JOptionPane.showMessageDialog(this,"Updated successfully");
             fillbTable();
            
        }
                
    }//GEN-LAST:event_updateButtonActionPerformed
   
    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // TODO add your handling code here:
        ProductCategoryDAO pcd=new ProductCategoryDAOImp();
        model.ProductCategory pc = new model.ProductCategory();
        String name=nameField.getText();
        String code=codeField.getText();
      //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
       // String date = sdf.format(datePickerField.getDate());
        pc.setCategoryName(name);
        pc.setCategoryCode(code);
        pc.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
        pc.setCreatedBy("sms");
        pc.setUpdatedBy("sms");
        pc.setActive(true);
        boolean success = pcd.addProduct(pc);
        
        if(success){
            JOptionPane.showMessageDialog(this,"added successfully");
             fillbTable();
            
        }
        
         
    }//GEN-LAST:event_insertButtonActionPerformed
    
//    private void select(java.awt.event.MouseEvent evt){
//        int index= bTable.getSelectedRow();
//        TableModel model=bTable.getModel();
//        
//        String name=model.getValueAt(index, 1).toString();
//        String code=model.getValueAt(index, 2).toString();
//        
//        bName.setText(name);
//        bCode.setText(code);
//    }
    
    
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
                String name=nameField.getText();
                model.ProductCategory pc = new model.ProductCategory();
                ProductCategoryDAO pcd=new ProductCategoryDAOImp();
                pc.setCategoryName(name);
                pc.setActive(false);
                int[] selectedRows = productTable.getSelectedRows();
                TableModel model=productTable.getModel();
                for(int i : selectedRows)
                {
                    int id = (int) model.getValueAt(i, 0);
                    model.setValueAt(false, i, 4);
                }
                  boolean success = pcd.deleteCategory(pc);
        
        if(success){
           pcd.updateStatus(name, false);
            JOptionPane.showMessageDialog(this,"Delete successfully");
             fillbTable();
            
        }
                


        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
             int index= productTable.getSelectedRow();
        TableModel model=productTable.getModel();
        
        String name=model.getValueAt(index, 1).toString();
        String code=model.getValueAt(index, 2).toString();
        Date date;
        date = (Date) model.getValueAt(index, 3);
        nameField.setText(name);
        codeField.setText(code);
        datePickerField.setDate(date);  
        
        
    }//GEN-LAST:event_productTableMouseClicked

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
            java.util.logging.Logger.getLogger(ProductCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductCategoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductCategoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JLabel dateLabel;
    private com.toedter.calendar.JDateChooser datePickerField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable productTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
