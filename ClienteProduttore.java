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
public class ClienteProduttore extends Thread{
    
    BufferCaffe buffer;

    public ClienteProduttore(BufferCaffe buffer) {
        this.buffer = buffer;
    }
    
    public void run(){
    
        try {
            sleep((int)(Math.random() * 300));
        } catch (InterruptedException e) {
        }
        
        buffer.deposita((int)((Math.random() * 4) + 1));
    
    }
    
    
}
