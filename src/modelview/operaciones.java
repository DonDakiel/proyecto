/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.User;
import view.iniciosesion;

public class operaciones {
    
    public User item(String a, String b, String c, String d) {
        User item = new User();
        item.setContra(c);
        item.setEdad(d);
        item.setNombre(b);
        item.setUser(a);
        return item;
    }

    public String confirm(String username, String password,Map<String, User> mapa) {
        
        if (mapa.containsKey(username)) {
            // Obtener los datos del usuario para el nombre de usuario dado
            User userData = mapa.get(username);
            if (userData.getContra().equals(password)) {
                // Verificar si la contraseña coincide
                return "bienvenido";
            }else{
                return "contraseña incorrecta";
            }
        }else{
            return "usuario no registrado";
        }
    
    }
  
    public List<String> variables(){
      
      List<String> L=new ArrayList<>();
      User i=new User();
        System.out.println(i.getUser());
//      User userData = ic.getItems().get(appState.getUser());
//      L.add(userData.getUser());
//      L.add(userData.getEdad());
//      L.add(userData.getNombre());      
      return L;}

      
    }























//int sensorPin = A0;     // Pin analógico para el sensor de humedad
//int ledPin = 13;        // Pin digital para el LED
//int sensorValue = 0;    // Variable para almacenar el valor del sensor
//
//void setup() {
//Serial.begin(9600);
//pinMode(ledPin, OUTPUT);  // Configura el pin del LED como salida
//}
//
//void loop() {
// // read the value from the sensor:
//   sensorValue = analogRead(sensorPin);
//   Serial.print("Moisture Sensor Value: ");
//   Serial.println(sensorValue);
//   
//  if (sensorValue > 650) {
//    digitalWrite(ledPin, HIGH);  // Enciende el LED si el valor supera 650
//  } else {
//    digitalWrite(ledPin, LOW);   // Apaga el LED si el valor es igual o menor a 650
//  }
//   delay(1000);
//}


