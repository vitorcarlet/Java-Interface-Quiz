/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BEAN;



/**
 *
 * @author vitor
 */
public class Questoes {
    
    private int id;
    private String nivel;
    private String assunto;
    private String pergunta;
    private String opcao1;
    private String opcao2;
    private String opcao3;
    private String opcao4;
    private String opcaocorreta;

    public int getId() {
        return id;
    }
    
    public String toStringId(){
        String id1 = Integer.toString(id);
        return id1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getOpcao1() {
        return opcao1;
    }

    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    public String getOpcao2() {
        return opcao2;
    }

    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    public String getOpcao3() {
        return opcao3;
    }

    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }

    public String getOpcao4() {
        return opcao4;
    }

    public void setOpcao4(String opcao4) {
        this.opcao4 = opcao4;
    }

    public String getOpcaocorreta() {
        return opcaocorreta;
    }

    public void setOpcaocorreta(String opcaocorreta) {
        this.opcaocorreta = opcaocorreta;
    }

    
    
    
    
}
