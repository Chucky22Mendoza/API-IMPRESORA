package com.api.main;

import com.api.printer.data.Ticket_Pago_Recarga;
import jssc.SerialPortException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author login
 */
public class main {
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws jssc.SerialPortException
     */
    public static void main(String[] args) throws InterruptedException, SerialPortException {
        Ticket_Pago_Recarga tpr = new Ticket_Pago_Recarga();
        tpr.ticket_pago_recarga("22", "124a", "ramal prueba", "Jesus Mendoza", "1234123412341234", 20.0, 20.0, 40.0);
    }
    
}
