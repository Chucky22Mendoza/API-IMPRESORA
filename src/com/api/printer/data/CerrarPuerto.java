package com.api.printer.data;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * 
 * @author login
 */
public class CerrarPuerto {
    /**
     * 
     * CERRAR PUERTO YA ABIERTO ANTERIORMENTE POR MEDIO DE AbrirPuerto
     * 
     * @param serialPort
     * @throws SerialPortException 
     */
    protected void closeSerialPort(SerialPort serialPort) throws SerialPortException{
        serialPort.closePort(); //CERRAR PUERTO
    }
}
