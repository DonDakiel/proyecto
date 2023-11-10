/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import model.ItemDAO;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import javax.swing.JOptionPane;
import model.User;

public class ItemController {

    public void saveItem(String usu, User u) {

        ItemDAO itemDao = new ItemDAO();

        Map<String, Object> items = new HashMap<String, Object>() {
            {
                put(usu, u);

            }
        };

        itemDao.saveItem("users", items);
        System.out.println("Item saved successfully!");
    }

    public Map<String, User> getItems() {
        ItemDAO itemDao = new ItemDAO();
        System.out.println("LIST Item".toUpperCase());
        
        return itemDao.listItems();
    }

}
