/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sfitap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author capie
 */
public class SFITAP {

    public static void main(String[] args) {

        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {

            conn
                    = DriverManager.getConnection("jdbc:mysql://localhost/db_sfi_tap?"
                            + "user=capiedrahita1&password=C@ps*7414");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Integer userid = rs.getInt("usuario_id");
                String name = rs.getString("nombre");
                String lastName = rs.getString("apellido");
                //Date dob = rs.getDate(4);
                System.out.println("userid:" + userid);
                System.out.println("name:" + name);
                System.out.println("lastName:" + lastName);
                System.out.println("");
            }
            // The newInstance() call is a work around for some
            // broken Java implementations

        } catch (Exception ex) {
            ex.printStackTrace();
            // handle the error
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }

        System.out.println("Hello world!");
    }
}
