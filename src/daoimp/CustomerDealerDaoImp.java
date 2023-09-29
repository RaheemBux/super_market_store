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
    private static final String DELETE_CUSTOMERDEALER = "UPDATE customer_dealer SET bool_active=False WHERE id=?;";

    Connection connection = DbConnection.getConnection();

    @Override
    public boolean addCustomerDealer(CustomerDealer customerDealer) {

        boolean success = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMERDEALER);
            preparedStatement.setString(1, customerDealer.getCustomerDealerName());
            preparedStatement.setObject(2, CustomerDealerEnum.valueOf(customerDealer.getCustomerDealerEnum().toString()).ordinal());
            preparedStatement.setString(3, customerDealer.getEmail());
            preparedStatement.setString(4, customerDealer.getPhoneNumber());
            preparedStatement.setString(5, customerDealer.getAddress());
            preparedStatement.setDate(6, customerDealer.getCreateDate());
            preparedStatement.setDate(7, customerDealer.getModifiedDate());
            preparedStatement.setString(8, customerDealer.getCreatedBy());
            preparedStatement.setString(9, customerDealer.getUpdatedBy());
            preparedStatement.setBoolean(10, customerDealer.isActive());
            preparedStatement.execute();
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
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMERDEALER);
            preparedStatement.setString(1, customerDealer.getCustomerDealerName());
            preparedStatement.setObject(2, CustomerDealerEnum.valueOf(customerDealer.getCustomerDealerEnum().toString()).ordinal());
            preparedStatement.setString(3, customerDealer.getEmail());
            preparedStatement.setString(4, customerDealer.getPhoneNumber());
            preparedStatement.setString(5, customerDealer.getAddress());
            preparedStatement.setDate(6, customerDealer.getModifiedDate());
            preparedStatement.setString(7, customerDealer.getCreatedBy());
            preparedStatement.setString(8, customerDealer.getUpdatedBy());
            preparedStatement.setBoolean(9, customerDealer.isActive());
            preparedStatement.setInt(10, customerDealer.getCustomerDealerId());
            preparedStatement.execute();
        } catch (Exception e) {
             Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
            success = false;
        }
        return success;
    }

    @Override
    public boolean deleteCustomerDealer(Integer id) {
        boolean success = true;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMERDEALER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
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
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMERDEALER);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                customerDealer.setActive(resultSet.getBoolean("bool_active"));

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
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMERDEALER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                customerDealer.setActive(resultSet.getBoolean("bool_active"));
                return customerDealer;

            }
        } catch (Exception e) {
            Logger.getLogger(CustomerDealerDaoImp.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

}
