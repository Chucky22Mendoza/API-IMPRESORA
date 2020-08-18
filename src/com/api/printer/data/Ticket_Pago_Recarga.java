/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.printer.data;

import com.api.printer.model.Impresora;
import java.util.Calendar;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author mendoza
 */
public class Ticket_Pago_Recarga {
    
    Impresora impresora = new Impresora();
    Abrir_Puerto abrirPuerto = new Abrir_Puerto();
    Cerrar_Puerto cerrarPuerto = new Cerrar_Puerto();
    
    private static SerialPort serialPort;
    byte[] NEGRITAS = impresora.getNEGRITAS(); //LETRAS EN NEGRITAS
    byte[] IMP_ESP = impresora.getIMP_ESP(); //ESPACIO ANTES DE CORTAR
    byte[] CUT = impresora.getCUT(); //CORTE PARCIAL
    byte[] ESP_SMALL = impresora.getESP_SMALL(); //ESPACIO PEQUEÑO
    byte[] ESP_MIDDLE = impresora.getESP_MIDDLE(); //ESPACIO MEDIANO
    Calendar CALENDAR = impresora.getCALENDAR(); //HORA Y FECHA
    
    //CREACIÓN DE TICKET PARA PAGO DE RECARGA
    public void ticket_pago_recarga(
            String unidad, 
            String ruta, 
            String ramal, 
            String operador, 
            String num_tarjeta, 
            double saldo_anterior,
            double monto_solicitado,
            double saldo_actual
    ) throws InterruptedException, SerialPortException{
        serialPort = abrirPuerto.abrir_puerto();

        System.out.println("LLEGA A IMPRIMIR RECARGA \n");
        
        String hora=CALENDAR.get(Calendar.HOUR_OF_DAY) + ":" + CALENDAR.get(Calendar.MINUTE) + ":" + CALENDAR.get(Calendar.SECOND);
        String fecha=CALENDAR.get(Calendar.YEAR) + "-" + CALENDAR.get(Calendar.MONTH) + "-" + CALENDAR.get(Calendar.DAY_OF_MONTH);
        
        //ACTIVO NEGRITAS
        serialPort.writeBytes(NEGRITAS);
        
        serialPort.writeString("        RECARGA DE SALDO");
        serialPort.writeBytes(ESP_SMALL);
        
        serialPort.writeString("    FECHA Y HORA DE RECARGA:");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("       " + fecha + " " + hora);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("  OPERADOR: " + operador);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("    UNIDAD: "+ unidad + " RUTA: " + ruta);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("    RAMAL: "+ ramal);
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

        cerrarPuerto.cerrar_puerto(serialPort);
    } 
}
