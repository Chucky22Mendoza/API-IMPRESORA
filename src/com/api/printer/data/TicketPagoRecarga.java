package com.api.printer.data;

import com.api.printer.model.Impresora;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * 
 * @author login
 */
public class TicketPagoRecarga {
    
    Impresora impresora = new Impresora();
    AbrirPuerto abrirPuerto = new AbrirPuerto();
    CerrarPuerto cerrarPuerto = new CerrarPuerto();
    
    private static SerialPort serialPort;
    byte[] NEGRITAS = impresora.getNEGRITAS(); //LETRAS EN NEGRITAS
    byte[] IMP_ESP = impresora.getIMP_ESP(); //ESPACIO ANTES DE CORTAR
    byte[] CUT = impresora.getCUT(); //CORTE PARCIAL
    byte[] ESP_SMALL = impresora.getESP_SMALL(); //ESPACIO PEQUEÑO
    byte[] ESP_MIDDLE = impresora.getESP_MIDDLE(); //ESPACIO MEDIANO
    String FECHA = impresora.getFECHA(); //FECHA ACTUAL
    String HORA = impresora.getHORA(); //HORA ACTUAL
    
    /**
     * 
     * CREACIÓN DE TICKET PARA PAGO DE RECARGA
     * 
     * @param unidad
     * @param ruta
     * @param ramal
     * @param operador
     * @param num_tarjeta
     * @param saldo_anterior
     * @param monto_solicitado
     * @param saldo_actual
     * @throws InterruptedException
     * @throws SerialPortException 
     */
    public void print(
        String unidad, 
        String ruta, 
        String ramal, 
        String operador, 
        String num_tarjeta, 
        double saldo_anterior,
        double monto_solicitado,
        double saldo_actual
    ) throws InterruptedException, SerialPortException{
        //ABRIR PUERTO DE IMPRESORA
        serialPort = abrirPuerto.getSerialPort();
        //ACTIVO NEGRITAS
        serialPort.writeBytes(NEGRITAS);
        
        serialPort.writeString("       RECARGA DE SALDO");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("   FECHA Y HORA DE RECARGA:");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("      " + FECHA + " " + HORA);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("OPERADOR: " + operador);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("UNIDAD: "+ unidad);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RUTA: " + ruta);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RAMAL: "+ ramal);
        serialPort.writeBytes(ESP_MIDDLE);
        
        serialPort.writeString("********************************");
        serialPort.writeBytes(ESP_MIDDLE);
        
        serialPort.writeString("N° TARJETA:" + num_tarjeta);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("SALDO ANTERIOR: $" + saldo_anterior);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("MONTO SOLICITADO: $" + monto_solicitado);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("SALDO ACTUAL: $" + saldo_actual);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("********************************");
        serialPort.writeBytes(ESP_MIDDLE);
        
        serialPort.writeBytes(IMP_ESP);
        serialPort.writeBytes(CUT);
        //CERRAR PUERTO ENVIANDO EL YA ABIERTO
        cerrarPuerto.closeSerialPort(serialPort);
    } 
}
