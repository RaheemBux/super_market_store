/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimp;

import constant.CustomerDealerEnum;
import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.CustomerDealer;
import dao.CustomerDealerDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Haseeb
 */
public class CustomerDealerDaoImp implements CustomerDealerDao {

    private static final String ADD_CUSTOMERDEALER = "INSERT INTO customer_dealer(customer_dealer_name,type,email,phone_number,address,created_date,modified_date,created_by,updated_by,bool_active) \n"
            + "VALUES(?,?,?,?,?,?,?,?,?,?); ";
    private static final String UPDATE_CUSTOMERDEALER = "UPDATE customer_dealer SET customer_dealer_name=?,type=?,email=?,phone_number=?,address=?,modified_date=?,created_by=?,updated_by=?,bool_active=? WHERE id=?;";
    private static final String GET_ALL_CUSTOMERDEALER = "SELECT * FROM customer_dealer WHERE bool_active=1;";
    private static final String GET_CUSTOMERDEALER_BY_ID = "SELECT * FROM customer_dealer where id=?;";
    private static final String DELETE_CUSTOMERDEALER = "UPDATE customer_dealer SET bool_active=0 WHERE id=?;";

    Connection connection = DbConnection.getConnection();

    @Override
    public boolean addCustomerDealer(CustomerDealer customerDealer) {

        boolean success = true;
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_CUSTOMERDEALER);
            ps.setString(1, customerDealer.getCustomerDealerName());
            ps.setObject(2, CustomerDealerEnum.valueOf(customerDealer.getCustomerDealerEnum().toString()).ordinal());
            ps.setString(3, customerDealer.getEmail());
            ps.setString(4, customerDealer.getPhoneNumber());
            ps.setString(5, customerDealer.getAddress());
            ps.setDate(6, customerDealer.getCreateDate());
            ps.setDate(7, customerDealer.getModifiedDate());
            ps.setString(8, customerDealer.getCreatedBy());
            ps.setString(9, customerDealer.getUpdatedBy());
            ps.setInt(10, customerDealer.isActive());
            ps.execute();
        } catch (Exception e) {
             Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
            success = false;
        }
        return success;
    }

    @Override
    public boolean updateCustomerDealer(CustomerDealer customerDealer) {

        boolean success = true;
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMERDEALER);
            ps.setString(1, customerDealer.getCustomerDealerName());
            ps.setObject(2, CustomerDealerEnum.valueOf(customerDealer.getCustomerDealerEnum().toString()).ordinal());
            ps.setString(3, customerDealer.getEmail());
            ps.setString(4, customerDealer.getPhoneNumber());
            ps.setString(5, customerDealer.getAddress());
            ps.setDate(6, customerDealer.getModifiedDate());
            ps.setString(7, customerDealer.getCreatedBy());
            ps.setString(8, customerDealer.getUpdatedBy());
            ps.setInt(9, customerDealer.isActive());
            ps.setInt(10, customerDealer.getCustomerDealerId());
            ps.execute();
        } catch (Exception e) {
             Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
            success = false;
        }
        return success;
    }

    public boolean deleteCustomerDealer(Integer id) {
        boolean success = true;
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMERDEALER);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
              Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
            success = false;
        }
        return success;
    }

    @Override
    public List<CustomerDealer> getAllCustomerDealer() {
        List<CustomerDealer> getAllCustomerDealers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_CUSTOMERDEALER);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                CustomerDealer customerDealer = new CustomerDealer();
                customerDealer.setCustomerDealerId(resultSet.getInt("id"));
                customerDealer.setCustomerDealerName(resultSet.getString("customer_dealer_name"));
                customerDealer.setCustomerDealerEnum(CustomerDealerEnum.valueOf(resultSet.getString("type")));
                customerDealer.setEmail(resultSet.getString("email"));
                customerDealer.setPhoneNumber(resultSet.getString("phone_number"));
                customerDealer.setAddress(resultSet.getString("address"));
                customerDealer.setCreateDate(resultSet.getDate("created_date"));
                customerDealer.setModifiedDate(resultSet.getDate("modified_date"));
                customerDealer.setCreatedBy(resultSet.getString("created_by"));
                customerDealer.setUpdatedBy(resultSet.getString("updated_by"));
                customerDealer.setActive(resultSet.getInt("bool_active"));

                getAllCustomerDealers.add(customerDealer);

            }
        } catch (Exception e) {
            Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
        }
        return getAllCustomerDealers;
    }

    @Override
    public CustomerDealer getCustomerDealerById(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement(GET_CUSTOMERDEALER_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                CustomerDealer customerDealer = new CustomerDealer();

                customerDealer.setCustomerDealerId(resultSet.getInt("id"));
                customerDealer.setCustomerDealerName(resultSet.getString("customer_dealer_name"));
                customerDealer.setCustomerDealerEnum(CustomerDealerEnum.valueOf(resultSet.getString("type")));
                customerDealer.setEmail(resultSet.getString("email"));
                customerDealer.setPhoneNumber(resultSet.getString("phone_number"));
                customerDealer.setAddress(resultSet.getString("address"));
                customerDealer.setCreateDate(resultSet.getDate("created_date"));
                customerDealer.setModifiedDate(resultSet.getDate("modified_date"));
                customerDealer.setCreatedBy(resultSet.getString("created_by"));
                customerDealer.setUpdatedBy(resultSet.getString("updated_by"));
                customerDealer.setActive(resultSet.getInt("bool_active"));
                return customerDealer;

            }
        } catch (Exception e) {
            Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

}
