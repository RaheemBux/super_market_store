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
import models.User;

/**
 *
 * @author DELL
 */
public class UserDAOImpl implements UserDAO {

    private final String INSERT_QUERY = "INSERT INTO user (first_Name,last_Name,phone_number,email,user_password,created_date,modified_date,bool_active) VALUES (?,?,?,?,?,?,?,?)";
    private final String SELECT_QUERY = "SELECT * FROM user where bool_active=true";
    private final String SELECT_QUERY_SINGLE = "SELECT * FROM user where id=?";
    private final String UPDATE_QUERY = "UPDATE user SET first_Name = ?,last_Name = ?,phone_number = ?,email = ?,user_password=?,modified_date=? where id = ?";
    private final String UPDATE_STATUS = "update user set bool_active = false where id = ?";

    @Override
    public boolean addUser(User user) {
        boolean success = false;

        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
            ps.setString(1, user.getfName());
            ps.setString(2, user.getlName());
            ps.setString(3, user.getPhoneNum());
            ps.setString(4, user.getUEmail());
            ps.setString(5, user.getPassword());
            ps.setDate(6, user.getCreatedDate());
            ps.setDate(7, user.getModifiedDate());
            ps.setBoolean(8, true);
            
            ps.execute();
            success = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    @Override
    public User getUserById(Integer id) {
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_QUERY_SINGLE);
            ps.setInt(1, id);
            ResultSet rst = ps.executeQuery();

            User u = new User();
            while (rst.next()) {
                u.setId(id);
                u.setfName(rst.getString("first_Name"));
                u.setlName(rst.getString("last_Name"));
                u.setUEmail(rst.getString("email"));
                u.setPhoneNum(rst.getString("phone_number"));
                u.setPassword(rst.getString("user_password"));
            }
            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteUser(User user) {

        boolean success = false;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE_STATUS);
            ps.setInt(1, user.getId());
            ps.execute();
            success = true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public List<User> getAllUser() {

        List<User> list = new ArrayList<>();
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
            ResultSet rst = ps.executeQuery();

            while (rst.next()) {
                User user = new User();
//                System.out.println(rst.getString("email"));
                user.setId(rst.getInt("id"));
                user.setfName(rst.getString("first_Name"));
                user.setlName(rst.getString("last_Name"));
                user.setPhoneNum(rst.getString("phone_number"));
                user.setUEmail(rst.getString("email"));
                user.setPassword(rst.getString("user_password"));
                user.setCreatedDate(rst.getDate("created_date"));
                user.setModifiedDate(rst.getDate("modified_date"));
                user.setStatus(rst.getBoolean("bool_active"));
                list.add(user);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User getUserIDByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateUser(User user) {
        boolean success = false;

        try {

            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);

            ps.setString(1, user.getfName());
            ps.setString(2, user.getlName());
            ps.setString(3, user.getPhoneNum());
            ps.setString(4, user.getUEmail());
            ps.setString(5, user.getPassword());
            ps.setDate(6, user.getModifiedDate());
            ps.setInt(7, user.getId());

            ps.execute();
            return success = true;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

}
