/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionebar;

import java.util.concurrent.Semaphore;

/**
 *
 * @author arlin
 */
public class BufferCaffe {
    
    Semaphore semVuoto = new Semaphore(1);
    Semaphore semPieno = new Semaphore(0);
    int numOrd;
    int ordTot = 0;
    
    public void deposita(int numOrd){
    
        try {
            semVuoto.acquire();
        } catch (InterruptedException e) {
        }
        
        this.numOrd = numOrd;
        this.ordTot += this.numOrd;
        System.out.println(this.numOrd +" Caffè ordinati");
        semPieno.release();
    }
    
    public int preleva(){
    
        try {
            semPieno.acquire();
        } catch (InterruptedException e) {
        }
        
        System.out.println("Vengono serviti: " +this.numOrd +" Caffè");
        semVuoto.release();
        return this.numOrd;
    }
    
    public int incassoTotale(){
    
        return this.ordTot;
    }
    
}
