/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONNECTION.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import BEAN.Usuarios;

/**
 *
 * @author vitor
 */
public class UsuarioDAO {
    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
       

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");          
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();

            if (rs.next()) {

               check = true;
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
}
