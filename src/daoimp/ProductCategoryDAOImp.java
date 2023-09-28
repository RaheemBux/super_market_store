/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimp;
import java.sql.*;
//import com.sun.jdi.connect.spi.Connection;
import dao.ProductCategoryDAO;
import dbconnection.DbConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ProductCategoryModel;

/**
 *
 * @author SAQIB
 */
public class ProductCategoryDAOImp implements ProductCategoryDAO {
    
    private final String SELECT_QUERY = "SELECT * FROM category where bool_active=true";
	private final String INSERT_QUERY = "INSERT INTO category( category_name,category_code,created_date,created_by,updated_by,bool_active) VALUES (?,?, ?,?,?,?)";
	private final String DELETE_QUERY = "DELETE FROM category WHERE category_name=?";
        private final String CHANGE_QUERY = "UPDATE category SET bool_active=? WHERE category_name=?";
	private final String UPDATE_QUERY = "UPDATE category SET category_name=?, category_code= ? WHERE id=?";
	private final String SELECT_BY_ID_QUERY = "SELECT id,category_name,category_code FROM category WHERE id= ?";
    private Object created_date;
        
        
       @Override
	public List<ProductCategoryModel> getAllProduct() {
		Connection connection;
        try {
            connection = DbConnection.getConnection();
            try {
            connection = DbConnection.getConnection();
       

			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ResultSet rst = ps.executeQuery();

			List<ProductCategoryModel> catgList = new ArrayList<>();
                       
                       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                      			while (rst.next()) {
				ProductCategoryModel catg = new ProductCategoryModel();
				catg.setId(rst.getInt("id"));
				catg.setCategory_name(rst.getString("category_name"));
                                catg.setCategory_code(rst.getString("category_code"));
                               catg.setCreated_date(rst.getString("created_date"));
                               catg.setCreated_by(rst.getString("created_by"));
                               catg.setUpdated_by(rst.getString("updated_by"));
                               catg.setActive(rst.getBoolean("bool_active"));
                               
				catgList.add(catg);
			}
			return catgList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                return null;
	}
   
    
    
    	@Override
	public boolean addProduct(ProductCategoryModel product) {
		
               
                boolean success=false;
		try {
                   Connection connection =  (Connection) DbConnection.getConnection();
                   
                   
			PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
//			ps.setInt(1, department.getId());
			ps.setString(1, product.getCategory_name());
                        ps.setString(2,product.getCategory_code());
                        ps.setString(3,  product.getCreated_date());
                        ps.setString(4, product.getCreated_by() );
                        ps.setString(5,  product.getUpdated_by());
                        ps.setBoolean(6,product.isActive());
                         
			ps.execute();
			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                       success=false;
			e.printStackTrace();
                        
		}
                return success;

	}
        
        
        
        
        
        
        
        
        @Override
	public boolean deleteCategory(ProductCategoryModel category) {
		Connection con = null;
        try {
            con = DbConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                boolean success;
		try {
			PreparedStatement ps = con.prepareStatement(CHANGE_QUERY);
			ps.setString(2, category.getCategory_name());
                        ps.setBoolean(1, category.isActive());
			ps.execute();
			success=true;
		} catch (SQLException e) {
			success=false;
			e.printStackTrace();
		}
            return success;
	}
        
        
        
        
        
        
        
        
        @Override
	public boolean updateCategory(ProductCategoryModel category) {
		Connection con = null;
        try {
            con = DbConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
                boolean success;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
                        ps.setInt(3, category.getId());
			ps.setString(1, category.getCategory_name());
                        ps.setString(2, category.getCategory_code());
			
			int n = ps.executeUpdate();
                        System.out.print(n + " rows updated");
			success=true;
		} catch (SQLException e) {
			success=false;
			e.printStackTrace();
		}
                return success;
	}
        
        
        
    @Override
           public void updateStatus(String name,boolean status){
        try {
                   Connection connection =  (Connection) DbConnection.getConnection();
                   
                   
			PreparedStatement ps = connection.prepareStatement(CHANGE_QUERY);
//			ps.setInt(1, department.getId());
			ps.setBoolean(1, status);
                        ps.setString(2,name);
                     
                         
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
                       
			e.printStackTrace();
     }

    
}
}

