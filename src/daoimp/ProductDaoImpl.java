package daoimp;

import dao.ProductDao;
import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.ProductCategory;

public class ProductDaoImpl implements ProductDao {

    private boolean SUCCESS;
    private boolean status;

    @Override
    public boolean addProduct(Product product) {
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_PRODUCT);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getCategory().getId());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getDescription());
            ps.setDate(5, new java.sql.Date(product.getCreatedDate().getTime())); // Convert java.util.Date to java.sql.Date
            ps.setString(6, product.getCreatedBy());
            ps.setBoolean(7, true);

            ps.execute();
            SUCCESS = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            SUCCESS = false;
        }
        return SUCCESS;
    }

    @Override
    public boolean updateProduct(Product product) {
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getCategory().getId());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getDescription());
//            ps.setDate(5, (Date) product.getCreated_date());
            ps.setDate(5, new java.sql.Date(product.getModifiedDate().getTime()));
//            ps.setDate(6, (Date) product.getModified_date());
//            ps.setString(7, product.getCreated_by());
            ps.setString(6, product.getUpdatedBy());
            ps.setBoolean(7, product.getStatus());
            ps.setInt(8, product.getId());

            ps.execute();
            SUCCESS = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            SUCCESS = false;
        }
        return SUCCESS;
    }

    @Override
    public boolean deleteProduct(int id) {
        try {
            java.sql.Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);

            ps.execute();
            SUCCESS = true;

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            SUCCESS = false;
        }
        return SUCCESS;
    }

    @Override
    public Product getProductById(int id) {
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(PRODUCT_BY_ID);
            ps.setInt(1, id);

            ResultSet rstproduct = ps.executeQuery();

            while (rstproduct.next()) {
                Product product = new Product();
                product.setId(rstproduct.getInt("id"));
                product.setName(rstproduct.getString("product_name"));
                
                ProductCategory pc = new ProductCategory();
                pc.setId(rstproduct.getInt("id"));
                
                product.setCategory(pc);
 
                product.setBrand(rstproduct.getString("brand"));
                product.setDescription(rstproduct.getString("product_description"));
                product.setCreatedDate(rstproduct.getDate("created_date"));
                product.setModifiedDate(rstproduct.getDate("modified_date"));
                product.setCreatedBy(rstproduct.getString("created_by"));
                product.setUpdatedBy(rstproduct.getString("updated_by"));
                product.setStatus(rstproduct.getBoolean("bool_active"));

                if (product.getId() == id) {
                    return product;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(PRODUCT_BY_NAME);
            ps.setString(1, name);

            ResultSet rstproduct = ps.executeQuery();

            while (rstproduct.next()) {
                Product p = new Product();
                p.setId(rstproduct.getInt("id"));
                p.setName(rstproduct.getString("product_name"));
                
                ProductCategory pc = new ProductCategory();
                pc.setId(rstproduct.getInt("id"));
                
                p.setCategory(pc);
                
                p.setBrand(rstproduct.getString("brand"));
                p.setDescription(rstproduct.getString("product_description"));
                p.setCreatedDate(rstproduct.getDate("created_date"));
                p.setModifiedDate(rstproduct.getDate("modified_date"));
                p.setCreatedBy(rstproduct.getString("created_by"));
                p.setUpdatedBy(rstproduct.getString("updated_by"));
                p.setStatus(rstproduct.getBoolean("bool_active"));

                if (p.getName().equals(name)) {
                    return p;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> product = new ArrayList<>();
        try {
            Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(SHOW_ALL_PRODUCTS);
            ResultSet rstproduct = ps.executeQuery();
            while (rstproduct.next()) {
              
                Product p = new Product();
                
                p.setId(rstproduct.getInt("id"));
                p.setName(rstproduct.getString("product_name"));
                
                ProductCategory pc = new ProductCategory();
                pc.setId(rstproduct.getInt("id"));
                pc.setCategoryName(rstproduct.getString("category_name"));
                pc.setCategoryCode(rstproduct.getString("category_code"));
                p.setCategory(pc);
                
                p.setBrand(rstproduct.getString("brand"));
                p.setDescription(rstproduct.getString("product_description"));
                p.setCreatedDate(rstproduct.getDate("created_date"));
                p.setModifiedDate(rstproduct.getDate("modified_date"));
                p.setCreatedBy(rstproduct.getString("created_by"));
                p.setUpdatedBy(rstproduct.getString("updated_by"));
                p.setStatus(rstproduct.getBoolean("bool_active"));

                product.add(p);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

}
