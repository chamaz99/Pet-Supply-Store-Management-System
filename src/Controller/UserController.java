/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserDAO;
import Model.User;


public class UserController {
    private UserDAO dao;

    public UserController() { dao = new UserDAO(); }

    public boolean createUser(User u) { return dao.createUser(u); }
}
