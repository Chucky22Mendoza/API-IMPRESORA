package com.api.printer.data;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * 
 * @author login
 */
public class AbrirPuerto {
    private final SerialPort serialPort; 

    public AbrirPuerto() {
        this.serialPort = new SerialPort("COM4");
    }
    
    /**
     * 
     * OBTENER LA LECTURA DE BYTES DEL PUERTO SERIAL
     * 
     * @param serialPort
     * @throws SerialPortException 
     *
    protected byte[] portReadBytes(SerialPort serialPort) throws SerialPortException {
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
            return first;
        }
    }
    */
    
    /**
     * ABRIR PUERTO CON SUS PARAMETROS RESPECTIVOS
     * 
     * @return TYPE SERIALPORT
     * @throws SerialPortException 
     */
    protected SerialPort getSerialPort() throws SerialPortException{
        serialPort.openPort(); //ABRIR PUERTO
        serialPort.setParams(SerialPort.BAUDRATE_115200, 
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE); //PARAMETROS NECESARIOS
        return serialPort;
    }

}
