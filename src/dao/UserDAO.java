/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author DELL
 */
public interface UserDAO {

    public boolean addUser(User user);

    public User getUserById(Integer id);

    public boolean deleteUser(User user);

    public List<User> getAllUser();

    public User getUserIDByName(String name);
    
    public boolean updateUser(User user);
}
