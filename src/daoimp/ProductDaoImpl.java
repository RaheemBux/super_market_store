package daoimp;

import com.sun.jdi.connect.spi.Connection;
import dao.ProductDao;
import dbconnection.DbConnection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

public class ProductDaoImpl implements ProductDao {

    private boolean SUCCESS;
    private boolean status;

    @Override
    public boolean addProduct(Product product) {
        try {
            java.sql.Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(INSERT_PRODUCT);
            ps.setString(1, product.getProduct_name());
            ps.setInt(2, product.getCategory_id());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getProduct_description());
            ps.setDate(5, new java.sql.Date(product.getCreated_date().getTime())); // Convert java.util.Date to java.sql.Date
            ps.setString(6, product.getCreated_by());
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
            java.sql.Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, product.getProduct_name());
            ps.setInt(2, product.getCategory_id());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getProduct_description());
//            ps.setDate(5, (Date) product.getCreated_date());
            ps.setDate(5, new java.sql.Date(product.getModified_date().getTime()));
//            ps.setDate(6, (Date) product.getModified_date());
//            ps.setString(7, product.getCreated_by());
            ps.setString(6, product.getUpdated_by());
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
            java.sql.Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(PRODUCT_BY_ID);
            ps.setInt(1, id);

            ResultSet rstproduct = ps.executeQuery();

            while (rstproduct.next()) {
                Product product = new Product();
                product.setId(rstproduct.getInt("id"));
                product.setProduct_name(rstproduct.getString("product_name"));
                product.setCategory_id(rstproduct.getInt("category_id"));
                product.setBrand(rstproduct.getString("brand"));
                product.setProduct_description(rstproduct.getString("product_description"));
                product.setCreated_date(rstproduct.getDate("created_date"));
                product.setModified_date(rstproduct.getDate("modified_date"));
                product.setCreated_by(rstproduct.getString("created_by"));
                product.setUpdated_by(rstproduct.getString("updated_by"));
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
            java.sql.Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(PRODUCT_BY_NAME);
            ps.setString(1, name);

            ResultSet rstproduct = ps.executeQuery();

            while (rstproduct.next()) {
                Product p = new Product();
                p.setId(rstproduct.getInt("id"));
                p.setProduct_name(rstproduct.getString("product_name"));
                p.setCategory_id(rstproduct.getInt("category_id"));
                p.setBrand(rstproduct.getString("brand"));
                p.setProduct_description(rstproduct.getString("product_description"));
                p.setCreated_date(rstproduct.getDate("created_date"));
                p.setModified_date(rstproduct.getDate("modified_date"));
                p.setCreated_by(rstproduct.getString("created_by"));
                p.setUpdated_by(rstproduct.getString("updated_by"));
                p.setStatus(rstproduct.getBoolean("bool_active"));

                if (p.getProduct_name().equals(name)) {
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
            java.sql.Connection connect = DbConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(SHOW_ALL_PRODUCTS);
            ResultSet rstproduct = ps.executeQuery();
            while (rstproduct.next()) {
                Product p = new Product();
                p.setId(rstproduct.getInt("id"));
                p.setProduct_name(rstproduct.getString("product_name"));
                p.setCategory_id(rstproduct.getInt("category_id"));
                p.setBrand(rstproduct.getString("brand"));
                p.setProduct_description(rstproduct.getString("product_description"));
                p.setCreated_date(rstproduct.getDate("created_date"));
                p.setModified_date(rstproduct.getDate("modified_date"));
                p.setCreated_by(rstproduct.getString("created_by"));
                p.setUpdated_by(rstproduct.getString("updated_by"));
                p.setStatus(rstproduct.getBoolean("bool_active"));

                if (p.getStatus() == true) {
                    product.add(p);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }

}
