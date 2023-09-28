/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoimp;

import dao.UserDAO;
import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author DELL
 */
public class UserDAOImpl implements UserDAO {

    private final String INSERT_QUERY = "INSERT INTO user (first_Name,last_Name,phone_number,email,user_password,created_date,modified_date,created_by,updated_by,bool_active) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private final String SELECT_QUERY = "SELECT * FROM user where bool_active=true";
    private final String SELECT_QUERY_SINGLE = "SELECT * FROM user where id=?";
    private final String UPDATE_QUERY = "UPDATE user SET first_Name = ?,last_Name = ?,phone_number = ?,email = ?,user_password=?,modified_date=? where id = ?";
    private final String UPDATE_STATUS = "update user set bool_active = false where id = ?";

    @Override
    public boolean addUser(User user) {
        boolean success = false;

        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, user.getfirstName());
            preparedStatement.setString(2, user.getlastName());
            preparedStatement.setString(3, user.getPhoneNum());
            preparedStatement.setString(4, user.getUEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, user.getCreatedDate());
            preparedStatement.setDate(7, user.getModifiedDate());
            preparedStatement.setString(8, "sms");
            preparedStatement.setString(9, "sms");
            preparedStatement.setBoolean(10, true);
            
            preparedStatement.execute();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public User getUserById(Integer id) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_SINGLE);
            preparedStatement.setInt(1, id);
            ResultSet rst = preparedStatement.executeQuery();

            User user = new User();
            while (rst.next()) {
                user.setId(id);
                user.setfirstName(rst.getString("first_Name"));
                user.setlastName(rst.getString("last_Name"));
                user.setUEmail(rst.getString("email"));
                user.setPhoneNum(rst.getString("phone_number"));
                user.setPassword(rst.getString("user_password"));
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteUser(User user) {

        boolean success = false;
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            success = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            ResultSet rst = preparedStatement.executeQuery();

            while (rst.next()) {
                User user = new User();
                user.setId(rst.getInt("id"));
                user.setfirstName(rst.getString("first_Name"));
                user.setlastName(rst.getString("last_Name"));
                user.setPhoneNum(rst.getString("phone_number"));
                user.setUEmail(rst.getString("email"));
                user.setPassword(rst.getString("user_password"));
                user.setCreatedDate(rst.getDate("created_date"));
                user.setModifiedDate(rst.getDate("modified_date"));
                user.setStatus(rst.getBoolean("bool_active"));
                users.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User getUserIDByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean updateUser(User user) {
        boolean success = false;

        try {

            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, user.getfirstName());
            preparedStatement.setString(2, user.getlastName());
            preparedStatement.setString(3, user.getPhoneNum());
            preparedStatement.setString(4, user.getUEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setDate(6, user.getModifiedDate());
            preparedStatement.setInt(7, user.getId());

            preparedStatement.execute();
            return success = true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

}
