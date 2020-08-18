/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.printer.data;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author mendoza
 */
public class Cerrar_Puerto {
    
    public void cerrar_puerto(SerialPort serialPort) throws SerialPortException{
        serialPort.closePort(); //CERRAR PUERTO 
        System.out.println("CIERRA IMPRESORA");
    }
}
