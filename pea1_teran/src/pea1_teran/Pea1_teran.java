/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pea1_teran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author l11m05
 */
public class Pea1_teran {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/aplleinc?user=root&password=mysqladmin";
            Connection connect = DriverManager.getConnection(url);
            Statement statement =connect.createStatement();
            String query = "SELECT * FROM dispositivos";
            ResultSet resultSet = statement.executeQuery(query);
            String format = "|%1$-3d|%2$-17s|%3$-5d\n";
            while(resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int precio = resultSet.getInt("precio");
                String tipo = resultSet.getString("tipo");
                System.out.format(format, nombre, precio, tipo);
                
            Scanner scan = new Scanner(System.in);
            System.out.println("¿Qué deseas hacer: INSERTAR / BORRAR / CONSULTAR / ACTUALIZAR ?");
            String accion = scan.nextLine();
            
            if(accion.equals("REGISTRAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String _nombre = scan.nextLine();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                String _precio = scan.nextLine();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el tipo");
                String _tipo = scan.nextLine();
          
                query = "INSERT INTO dispositivos VALUES (?, ?, ?)";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setString(1, _nombre);
                ps.setInt(2,Integer.parseInt(_precio));
                ps.setString(3, _tipo);
                
                ps.executeUpdate();
                
                } else if (accion.equals("BORRAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String _nombre = scan.nextLine();
                
                query = "DELETE FROM producto WHERE id_producto = ?";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(_nombre));
                ps.executeUpdate();
            } else if (accion.equals("ACTUALIZAR")) {
                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String _nombre = scan.nextLine();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                String _precio = scan.nextLine();
                
                scan = new Scanner(System.in);
                System.out.println("Ingresa el tipo");
                String _tipo = scan.nextLine();
                
                query = "UPDATE dispositivos SET precio = ?, tipo = ? WHERE nombre = ?";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setString(1, _nombre);
                ps.setInt(2, Integer.parseInt(_precio));
                ps.setString(3, _tipo);
                ps.executeUpdate();
            }
            
            
            }
            
            resultSet.close();
            statement.close();
            connect.close();
        } catch (Exception e) {
            System.err.println(e);
            
        }
    }
    
}
