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
public class Abrir_Puerto {
    
    //SerialPort serialPort = new SerialPort("/dev/ttyUSB0"); //ACCESO AL PUERTO PARA IMPRIMIR \ LINUX
    //SerialPort serialPort = new SerialPort("/dev/printer");
    SerialPort serialPort = new SerialPort("COM4"); //ACCESO AL PUERTO PARA IMPRIMIR \ WINDOWS
    
    protected byte[] portReadBytes() throws SerialPortException {
        // readBytes will block until the amount of data is read
        final byte[] first = serialPort.readBytes(1);
        
        // check for remaining bytes
        if (serialPort.getInputBufferBytesCount() > 0) {
            // read as much as possible
            final byte[] remaining = serialPort.readBytes();
            // combine the stuff we read
            final byte[] combined = new byte[first.length + remaining.length];
            System.arraycopy(first,0,combined,0,first.length);
            System.arraycopy(remaining,0,combined,first.length,remaining.length);
            // return the combined data
            return combined;
        } else {
            // return the data we read first
            return first;
        }
    }
    
    public SerialPort abrir_puerto() throws SerialPortException{
        serialPort.openPort(); //ABRIR PUERTO
        serialPort.setParams(SerialPort.BAUDRATE_115200, 
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE); //PARAMETROS NECESARIOS
        return serialPort;
    }

}
