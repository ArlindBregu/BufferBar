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
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        BufferCaffe b = new BufferCaffe();
        
        System.out.println("Apertura Bar");
        
        CameriereConsumatore cam = new CameriereConsumatore(b, 10);
        cam.start();
        
        for(int i = 0; i<cam.numClienti; i++){
        
            ClienteProduttore c = new ClienteProduttore(b);
            c.start();
        }
        for(int i=0; i<cam.numClienti; i++){
        
            ClienteProduttore c = new ClienteProduttore(b);
            c.join();
        }
        
        cam.join();
        
        System.out.println("Incasso totale: " +b.incassoTotale());
        System.out.println("Chiusura bar");
    }
    
}
