/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebar;

/**
 *
 * @author arlin
 */
public class CameriereConsumatore extends Thread{
    
    BufferCaffe buffer;
    int numClienti;

    public CameriereConsumatore(BufferCaffe buffer, int numClienti) {
        this.buffer = buffer;
        this.numClienti = numClienti;
    }
    
    public void run(){
    
        for(int i = numClienti; i > 0; i--){
            
            buffer.preleva();
            
            try {
                sleep((int)(Math.random() * 500));
            } catch (Exception e) {
            }
        
        }
    }
    
}
