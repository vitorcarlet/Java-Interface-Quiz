/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizz;

import java.util.Random;

/**
 *
 * @author vitor
 */
public class TestFor {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int index = aleatorio.nextInt(4);
        int [] b = new int[5];
     
        for(int i = 0; i < b.length;i++){
            b[i] = aleatorio.nextInt(4);
            
            for(int j = 0; j < i; j++){
                if(b[i]==b[j]){
                    i--;
                    break;
                }
            }
        }
        
        for(int i=0; i< b.length;i++){
            System.out.println(b[i]);
        }
        
    }
    
}
