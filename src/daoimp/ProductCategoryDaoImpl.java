/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimp;

import java.sql.*;
//import com.sun.jdi.connect.spi.Connection;
import dao.ProductCategoryDao;
import dbconnection.DbConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProductCategory;

/**
 *
 * @author SAQIB
 */
public class ProductCategoryDaoImpl implements ProductCategoryDao {

//    private final String SELECT_QUERY = "SELECT * FROM category where bool_active=true";
    private final String SELECT_QUERY = "SELECT * FROM category";

    private final String INSERT_QUERY = "INSERT INTO category( category_name,category_code,created_date,created_by,bool_active) VALUES (?,?,?,?,?,?)";
    private final String DELETE_QUERY = "DELETE FROM category WHERE category_name=?";
    private final String CHANGE_QUERY = "UPDATE category SET bool_active=? WHERE category_name=?";
    private final String UPDATE_QUERY = "UPDATE category SET category_name=?, category_code= ?, modified_date = ?, updated_by = ?, WHERE id=?";
    private final String SELECT_BY_ID_QUERY = "SELECT id,category_name,category_code FROM category WHERE id= ?";
    private final String GET_CATEGORY_BYID = "SELECT * FROM category where category_name = ?";
    private Object created_date;

    @Override
    public List<ProductCategory> getAllProductCategory() {
        Connection connection;
//            connection = DbConnection.getConnection();
            try {
                connection = DbConnection.getConnection();

                PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
                ResultSet rst = ps.executeQuery();

                List<ProductCategory> catgList = new ArrayList<>();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                while (rst.next()) {
                    ProductCategory catg = new ProductCategory();
                    catg.setId(rst.getInt("id"));
                    catg.setCategoryName(rst.getString("category_name"));
                    catg.setCategoryCode(rst.getString("category_code"));
                    catg.setCreatedDate(rst.getDate("created_date"));
                    catg.setCreatedBy(rst.getString("created_by"));
                    catg.setStatus(rst.getBoolean("bool_active"));

                    catgList.add(catg);
                }
                return catgList;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public boolean addProduct(ProductCategory product) {

        boolean success = false;
        try {
            Connection connection = (Connection) DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
//			ps.setInt(1, department.getId());
            ps.setString(1, product.getCategoryName());
            ps.setString(2, product.getCategoryCode());
            ps.setDate(3, new Date(product.getCreatedDate().getTime()));
            ps.setString(4, product.getCreatedBy());
            ps.setString(5, product.getUpdatedBy());
            ps.setBoolean(6, product.getStatus());

            ps.execute();
            success = true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            success = false;
            e.printStackTrace();

        }
        return success;

    }

    @Override
    public boolean deleteCategory(ProductCategory category) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean success;
        try {
            PreparedStatement ps = con.prepareStatement(CHANGE_QUERY);
            ps.setString(2, category.getCategoryName());
            ps.setBoolean(1, category.getStatus());
            ps.execute();
            success = true;
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean updateCategory(ProductCategory category) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean success;
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getCategoryCode());
            ps.setDate(3, new Date(category.getModifiedDate().getTime()));
            ps.setString(4, category.getUpdatedBy());
            ps.setInt(5, category.getId());
            

            int n = ps.executeUpdate();
            System.out.print(n + " rows updated");
            success = true;
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public void updateStatus(String name, boolean status) {
        try {
            Connection connection = (Connection) DbConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement(CHANGE_QUERY);
//			ps.setInt(1, department.getId());
            ps.setBoolean(1, status);
            ps.setString(2, name);

            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
    }

    @Override
    public ProductCategory getCategoryByName(String categoryname) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_CATEGORY_BYID);
            ps.setString(1, categoryname);
            ResultSet rstcategory = ps.executeQuery();
            
            while(rstcategory.next()){
                ProductCategory pc = new ProductCategory();
                pc.setId(rstcategory.getInt("id"));
                pc.setCategoryName(rstcategory.getString("category_name"));
                pc.setCategoryCode(rstcategory.getString("category_code"));
                
                
                return pc;
            }
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
