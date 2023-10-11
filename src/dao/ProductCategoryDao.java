/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.util.Scanner;
import model.ProductCategory;

/**
 *
 * @author Govind Kumar
 */
public interface ProductCategoryDAO {
    
    /**
     *
     */
    List<ProductCategory> getAllProduct();
     boolean addProduct(ProductCategory product);
     boolean deleteCategory(ProductCategory category);
     boolean updateCategory(ProductCategory category);
     void updateStatus(String name,boolean status);
  
}
