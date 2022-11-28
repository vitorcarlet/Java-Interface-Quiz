/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BEAN.Questoes;
import CONNECTION.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class QuestoesDAO {
    
    public List<Questoes> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt;
        ResultSet rs;

        List<Questoes> questoes = new ArrayList<>();

       
        
        try {
            stmt = con.prepareStatement("SELECT * FROM questoes");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Questoes questao = new Questoes();

                questao.setId(rs.getInt("id"));
                questao.setNivel(rs.getString("nivel"));
                questao.setAssunto(rs.getString("assunto"));
                questao.setPergunta(rs.getString("pergunta"));
                questao.setOpcao1(rs.getString("opcao1"));
                questao.setOpcao2(rs.getString("opcao2"));
                questao.setOpcao3(rs.getString("opcao3"));
                questao.setOpcao4(rs.getString("opcao4"));
                questao.setOpcaocorreta(rs.getString("opcaocorreta"));
               
                questoes.add(questao);
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }

        return questoes;

    }
    
//    public void ListWithoutRepeat() {
//    Random rand = new Random();
//    int numberOfElements = 2;
//
//    for (int i = 0; i < numberOfElements; i++) {
//        int randomIndex = rand.nextInt(Questoes.size());
//        String randomElement = Questoes.get(randomIndex);
//        questoes.remove(randomIndex);
//    }
//}
    
    
    
}
