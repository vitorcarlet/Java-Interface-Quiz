/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quizz;

import BEAN.Questoes;
import DAO.QuestoesDAO;
import quizz.Engine.*;
import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import CONNECTION.ConnectionFactory;
import quizz.TelaFinal;

/**
 *
 * @author Aluno
 */
public class Quizz_Form4 extends javax.swing.JFrame {

    

    
    
     
    
    
    public void answerCheck(){
        String studentAnswer="";
        String acertofinal = "";
        if(jRadioButton1_.isSelected())
        {
            studentAnswer = jRadioButton1_.getText();
        }else if(jRadioButton2_.isSelected())
        {
            studentAnswer = jRadioButton2_.getText();
        }else if(jRadioButton3_.isSelected())
        {
            studentAnswer = jRadioButton3_.getText();
        }else
        {
            studentAnswer = jRadioButton4_.getText();
        }
        if(studentAnswer.equals(answer) && contNextQuestionActionPerformed > 0)
        {
            marks=marks+1;
            String marks1=String.valueOf(marks);
            txtAcertos.setText(marks1);
            JOptionPane.showMessageDialog(null, "Parabéns, Você acertou!");
        }else if(!studentAnswer.equals(answer) && contNextQuestionActionPerformed > 0) {
            JOptionPane.showMessageDialog(null, "Resposta Errada!");
        }
        
        contNextQuestionActionPerformed++;
        System.out.println(contNextQuestionActionPerformed);
        
        //System.out.println(contNextQuestionActionPerformed);
if(contNextQuestionActionPerformed == getTotalUser+1){
    int totmark = marks;
    String assunto = getAssuntoUser;
    String dificuldade = getDificuldadeUser;
    int totalPerguntas = getTotalUser;
    txtNumQuestao.setText(" ");
                Lbl_Question.setText("Parabéns, você respondeu todas as questões!");
                jRadioButton1_.setText(" ");
                jRadioButton2_.setText(" ");
                jRadioButton3_.setText(" ");
                jRadioButton4_.setText(" ");
                Button_Next_Question.setText("finalizar");
                
                new TelaFinal(totmark, assunto, dificuldade, totalPerguntas).setVisible(true);
                
                
    
    acertofinal = txtAcertos.getText();
    //System.out.println(acertofinal);
    
}




        //question number change     
//        int questionId1;                     
//        questionId1 = b[c];
//        if(c<5){
//         c++;
//        }
//         if(c==5){
////             txtNumQuestao.setText(" ");
////                Lbl_Question.setText("Parabéns, você respondeu todas as questões!");
////                jRadioButton1_.setText(" ");
////                jRadioButton2_.setText(" ");
////                jRadioButton3_.setText(" ");
////                jRadioButton4_.setText(" ");
////                Button_Next_Question.setText("finalizar");
//             c=0;
//         }
//        questionId=String.valueOf(questionId1);               
        bg.clearSelection();              
    }
    
   
    public void contID(){
        try{
            
            Connection con = CONNECTION.ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement("select count(id) from questoes;");
            ResultSet rs1 = stmt.executeQuery();
            
            while(rs1.next()){
            txtTotalQuestao.setText(rs1.getString(1));
        }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e+" cont id");
        }
    }
   
    
    public void question(){
        
        try{ 
            Connection con = CONNECTION.ConnectionFactory.getConnection();
            //PreparedStatement stmt = con.prepareStatement("SELECT * FROM questoes WHERE id = '"+questionId+"' AND nivel LIKE ? AND assunto LIKE ?");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM questoes WHERE nivel LIKE ? AND assunto LIKE ? ORDER BY RAND()");
            stmt.setString(1, "%"+getDificuldadeUser+"%");
            stmt.setString(2, "%"+getAssuntoUser+"%");
            ResultSet rs1 = stmt.executeQuery();
            while(rs1.next()){
                txtNumQuestao.setText(rs1.getString(1));
                Lbl_Question.setText(rs1.getString(4));
                jRadioButton1_.setText(rs1.getString(5));
                jRadioButton2_.setText(rs1.getString(6));
                jRadioButton3_.setText(rs1.getString(7));
                jRadioButton4_.setText(rs1.getString(8));
                answer = rs1.getString(9);
            }   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e+"teste1");
        }
        
    }
     
    
    public void submit(){      
    }
    
    public String questionId="0";
    public String answer="";
    public int c=0;
    public int [] b = forcontador();
    public int getTotalUser;
    public String getDificuldadeUser;
    public String getAssuntoUser;
    
    
//    String dificuldade = getDificuldadeUser;
//    String assunto = getAssuntoUser;
//    int totalPerguntas = getTotalUser;
           
    int marks;
    int contquestoes = -1;
    int contvetor = 0;
    int contNextQuestionActionPerformed = 0;
    int contNextQuestionActionPerformed2 = 0;
    
 
    
    public int[] forcontador(){
        
        Random aleatorio3 = new Random();
        
        int [] b = new int[5];
        for(int i = 0; i < b.length;i++){
            b[i] = aleatorio3.nextInt(5)+1;
            
            for(int j = 0; j < i; j++){
                if(b[i]==b[j]){
                    i--;
                    break;
                }
            }
        }
        return b;
        
    }
    
    Random aleatorio = new Random();
    Random aleatorio2 = new Random();
     int index = aleatorio.nextInt(5);
     
    
//    int [] b = new int[5];
    
    
   ButtonGroup bg = new ButtonGroup();
   
   
   
    
    
    /**
     * Creates new form Quizz_Form
     */
    public Quizz_Form4() {
        initComponents();
        
        
        
        
     bg.add(jRadioButton1_);
      bg.add(jRadioButton2_);
       bg.add(jRadioButton3_);
       bg.add(jRadioButton4_);
       
      
       
       
        Button_Next_QuestionActionPerformed(null);    
       Connection con = CONNECTION.ConnectionFactory.getConnection();  
       try{ 
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM questoes WHERE nivel LIKE ? AND assunto LIKE ? ORDER BY RAND()");
            stmt.setString(1, "%"+getDificuldadeUser+"%");
            stmt.setString(2, "%"+getAssuntoUser+"%");
            ResultSet rs1 = stmt.executeQuery();
            while(rs1.next()){
                txtNumQuestao.setText(rs1.getString(1));
                Lbl_Question.setText(rs1.getString(4));
                jRadioButton1_.setText(rs1.getString(5));
                jRadioButton2_.setText(rs1.getString(6));
                jRadioButton3_.setText(rs1.getString(7));
                jRadioButton4_.setText(rs1.getString(8));
                answer = rs1.getString(9);
            }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"teste1");
        }
       
    }
    
    Quizz_Form4(String qtdQ, String Dificuldade, String Tema) {
     
        initComponents();
        
        txtTotalQuestao.setText(qtdQ);
        getTotalUser = Integer.parseInt(qtdQ);
        getDificuldadeUser = Dificuldade;
        getAssuntoUser = Tema;
        
        
        
        
     bg.add(jRadioButton1_);
      bg.add(jRadioButton2_);
       bg.add(jRadioButton3_);
       bg.add(jRadioButton4_);
       
      
       
       
        Button_Next_QuestionActionPerformed(null);    
       Connection con = CONNECTION.ConnectionFactory.getConnection();  
       try{ 
  
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM questoes WHERE nivel LIKE ? AND assunto LIKE ? ORDER BY RAND()");
            stmt.setString(1, "%"+getDificuldadeUser+"%");
            stmt.setString(2, "%"+getAssuntoUser+"%");
            ResultSet rs1 = stmt.executeQuery();
            while(rs1.next()){
                txtNumQuestao.setText(rs1.getString(1));
                Lbl_Question.setText(rs1.getString(4));
                jRadioButton1_.setText(rs1.getString(5));
                jRadioButton2_.setText(rs1.getString(6));
                jRadioButton3_.setText(rs1.getString(7));
                jRadioButton4_.setText(rs1.getString(8));
                answer = rs1.getString(9);
            }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"teste1");
        }
        
    }
    
    Quizz_Form4(String qtdQ) {
       
        initComponents();
        
        txtTotalQuestao.setText(qtdQ);
        getTotalUser = Integer.parseInt(qtdQ);
        
        
        
     bg.add(jRadioButton1_);
      bg.add(jRadioButton2_);
       bg.add(jRadioButton3_);
       bg.add(jRadioButton4_);
       
      
       
       
        Button_Next_QuestionActionPerformed(null);    
       Connection con = CONNECTION.ConnectionFactory.getConnection();  
       try{ 
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM questoes WHERE nivel LIKE ? AND assunto LIKE ? ORDER BY RAND()");
            stmt.setString(1, "%"+getDificuldadeUser+"%");
            stmt.setString(2, "%"+getAssuntoUser+"%");
            ResultSet rs1 = stmt.executeQuery();
            while(rs1.next()){
                txtNumQuestao.setText(rs1.getString(1));
                Lbl_Question.setText(rs1.getString(4));
                jRadioButton1_.setText(rs1.getString(5));
                jRadioButton2_.setText(rs1.getString(6));
                jRadioButton3_.setText(rs1.getString(7));
                jRadioButton4_.setText(rs1.getString(8));
                answer = rs1.getString(9);
            }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"teste1");
        }
        
    }
    
    
    
    public void enableRbuttons(boolean yes_or_no)
    {
        jRadioButton1_.setEnabled(yes_or_no);
        jRadioButton2_.setEnabled(yes_or_no);
        jRadioButton3_.setEnabled(yes_or_no);
        jRadioButton4_.setEnabled(yes_or_no);
        
        
       
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        _Q_Container = new javax.swing.JPanel();
        Lbl_Question = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumQuestao = new javax.swing.JLabel();
        txtTotalQuestao = new javax.swing.JLabel();
        txtAcertos = new javax.swing.JLabel();
        jRadioButton1_ = new javax.swing.JRadioButton();
        jRadioButton4_ = new javax.swing.JRadioButton();
        jRadioButton2_ = new javax.swing.JRadioButton();
        jRadioButton3_ = new javax.swing.JRadioButton();
        Button_Next_Question = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        _Q_Container.setBackground(new java.awt.Color(204, 204, 204));

        Lbl_Question.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Lbl_Question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Question.setText("Question Here???");

        jLabel1.setText("Total de Questões:");

        jLabel2.setText("Numero da Questão:");

        jLabel3.setText("Acertos:");

        txtNumQuestao.setText("0");

        txtTotalQuestao.setText("0");

        txtAcertos.setText("0");

        javax.swing.GroupLayout _Q_ContainerLayout = new javax.swing.GroupLayout(_Q_Container);
        _Q_Container.setLayout(_Q_ContainerLayout);
        _Q_ContainerLayout.setHorizontalGroup(
            _Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, _Q_ContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumQuestao)
                    .addComponent(txtTotalQuestao)
                    .addComponent(txtAcertos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbl_Question, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );
        _Q_ContainerLayout.setVerticalGroup(
            _Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_Q_ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(_Q_ContainerLayout.createSequentialGroup()
                        .addGroup(_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTotalQuestao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNumQuestao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(_Q_ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtAcertos)))
                    .addComponent(Lbl_Question, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButton1_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1_.setText("jRadioButton1");
        jRadioButton1_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_ActionPerformed(evt);
            }
        });

        jRadioButton4_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4_.setText("jRadioButton4");
        jRadioButton4_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4_ActionPerformed(evt);
            }
        });

        jRadioButton2_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2_.setText("jRadioButton2");
        jRadioButton2_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_ActionPerformed(evt);
            }
        });

        jRadioButton3_.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3_.setText("jRadioButton3");
        jRadioButton3_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3_ActionPerformed(evt);
            }
        });

        Button_Next_Question.setBackground(new java.awt.Color(244, 126, 2));
        Button_Next_Question.setForeground(new java.awt.Color(255, 255, 255));
        Button_Next_Question.setText("Next");
        Button_Next_Question.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_Next_QuestionMouseClicked(evt);
            }
        });
        Button_Next_Question.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Next_QuestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_Q_Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton3_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_Next_Question, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_Q_Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jRadioButton1_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4_)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(Button_Next_Question)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_ActionPerformed
        //getSelectedOption(jRadioButton2_);
    }//GEN-LAST:event_jRadioButton2_ActionPerformed

    private void jRadioButton3_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3_ActionPerformed
        //getSelectedOption(jRadioButton3_);
    }//GEN-LAST:event_jRadioButton3_ActionPerformed

    private void Button_Next_QuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Next_QuestionActionPerformed
//        
//         
        
        contNextQuestionActionPerformed2++;
        System.out.println(contNextQuestionActionPerformed2);
        answerCheck();
        //contID();
        if(contNextQuestionActionPerformed < getTotalUser+1)
        question();
        
        
        
        if(contNextQuestionActionPerformed2 == (getTotalUser+2)){
            //new TelaFinal().setVisible(true);
            this.dispose();
        }     

    }//GEN-LAST:event_Button_Next_QuestionActionPerformed
  
    
    

    
    private void jRadioButton4_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4_ActionPerformed
        //getSelectedOption(jRadioButton4_);
    }//GEN-LAST:event_jRadioButton4_ActionPerformed

    private void jRadioButton1_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_ActionPerformed
        //getSelectedOption(jRadioButton1_);
    }//GEN-LAST:event_jRadioButton1_ActionPerformed

    private void Button_Next_QuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Next_QuestionMouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_Button_Next_QuestionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quizz_Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quizz_Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quizz_Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quizz_Form4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quizz_Form4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Next_Question;
    private javax.swing.JLabel Lbl_Question;
    private javax.swing.JPanel _Q_Container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1_;
    private javax.swing.JRadioButton jRadioButton2_;
    private javax.swing.JRadioButton jRadioButton3_;
    private javax.swing.JRadioButton jRadioButton4_;
    private javax.swing.JLabel txtAcertos;
    private javax.swing.JLabel txtNumQuestao;
    private javax.swing.JLabel txtTotalQuestao;
    // End of variables declaration//GEN-END:variables
}

