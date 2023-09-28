/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.util.Scanner;
import model.ProductCategoryModel;

/**
 *
 * @author Govind Kumar
 */
public interface ProductCategoryDAO {
    
    /**
     *
     */
   public List<ProductCategoryModel> getAllProduct();
    public boolean addProduct(ProductCategoryModel product);
    public boolean deleteCategory(ProductCategoryModel category);
    public boolean updateCategory(ProductCategoryModel category);
    public void updateStatus(String name,boolean status);
   
    
    
    
    
    
    
    
    
    
    
    
    
}
