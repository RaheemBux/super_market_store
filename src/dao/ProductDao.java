/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Product;


/**
 *
 * @author Ahmed
 */
public interface ProductDao {
 

//    final String SHOW_ALL_PRODUCTS = "SELECT * FROM product";
    final String SHOW_ALL_PRODUCTS = "SELECT p.id,p.product_name,p.brand,p.product_description,p.created_date,p.modified_date,p.created_by,p.updated_by,p.bool_active,c.id,c.category_name,c.category_code FROM product p INNER JOIN category c on p.category_id = c.id AND p.bool_active = true";
    final String INSERT_PRODUCT = "INSERT INTO `super_market_store_system`.`product` (`product_name`, `category_id`,`brand`,`product_description`,`created_date`,`created_by`,`bool_active`) VALUES (?,?,?,?,?,?,?);";
    final String UPDATE_PRODUCT = "UPDATE `super_market_store_system`.`product` SET `product_name`=?, `category_id`=?, `brand`=?, `product_description`=?, `modified_date`=?, `updated_by`=?, `bool_active`=?  WHERE (`id` = ?)";
    final String DELETE_PRODUCT = "UPDATE `super_market_store_system`.`product` SET `bool_active`= false WHERE `id` = ?";
    final String PRODUCT_BY_ID = "SELECT * FROM product WHERE `id` = ?";
    final String PRODUCT_BY_NAME = "SELECT * FROM product WHERE `product_name` = ?";  
    
    
    List<Product> getAllProduct();
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct (int id);
    Product getProductById(int id);
    Product getProductByName(String name);

    /**
     *
     * @return
     */
}
