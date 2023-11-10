/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author afprietoa
 */
public class ItemDAO {

    /**
     *
     * @param items, list to save
     */
    public void saveItem(String id, Map<String, Object> items) {
        FirebaseDatabase connexion = null;
        try {
            connexion = Facade.getConnection();
            DatabaseReference ref = connexion.getReference("/");
            DatabaseReference childReference = ref.child(id);

            childReference.setValue(items);
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    ;
    public Map<String, User> listItems() {
        FirebaseDatabase connexion = null;
        Map<String, User> items = new HashMap<>();

        try {
            connexion = Facade.getConnection();
            DatabaseReference ref = connexion.getReference("/").child("users");

            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    GenericTypeIndicator<Map<String, User>> typeIndicator = new GenericTypeIndicator<Map<String, User>>() {
                    };
                    Map<String, User> data = dataSnapshot.getValue(typeIndicator);

                    if (data != null) {
                        items.putAll(data);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });

            // Añadir una pausa para esperar la operación de lectura (esto no es lo ideal)
            Thread.sleep(2000);

        } catch (InterruptedException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return items;
    }

}
