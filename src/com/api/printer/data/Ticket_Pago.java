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
public class Ticket_Pago {
    Impresora impresora = new Impresora();
    Abrir_Puerto abrirPuerto = new Abrir_Puerto();
    Cerrar_Puerto cerrarPuerto = new Cerrar_Puerto();
    
    private static SerialPort serialPort;
    private byte[] NEGRITAS; //LETRAS EN NEGRITAS
    byte[] IMP_ESP = impresora.getIMP_ESP(); //ESPACIO ANTES DE CORTAR
    byte[] CUT = impresora.getCUT(); //CORTE PARCIAL
    byte[] ESP_SMALL = impresora.getESP_SMALL(); //ESPACIO PEQUEÑO
    byte[] ESP_MIDDLE = impresora.getESP_MIDDLE(); //ESPACIO MEDIANO
    Calendar CALENDAR = impresora.getCALENDAR();
    
    public void Ticket_Pago(byte[] NEGRITAS) {
        this.NEGRITAS = impresora.getNEGRITAS();
    }
    
    //CREACIÓN DE TICKET DE PAGO
    public void ticket_pago(
            int tipo_pago,
            String operador,
            String unidad,
            String ruta,
            String ramal,
            String num_tarjeta,
            int cant_serv,
            int niños, 
            int adultos, 
            int estudiantes,
            int mayores,
            int maestro,
            int cap_dif,
            double total
    ) throws InterruptedException, SerialPortException{
        serialPort = abrirPuerto.abrir_puerto();
         
        String hora=CALENDAR.get(Calendar.HOUR_OF_DAY) + ":" + CALENDAR.get(Calendar.MINUTE) + ":" + CALENDAR.get(Calendar.SECOND);
        String fecha=CALENDAR.get(Calendar.YEAR) + "-" + CALENDAR.get(Calendar.MONTH) + "-" + CALENDAR.get(Calendar.DAY_OF_MONTH);
        
            //ACTIVO NEGRITAS
            serialPort.writeBytes(NEGRITAS);

            serialPort.writeString("Pago de servicios de transporte");
            serialPort.writeBytes(ESP_SMALL);
            serialPort.writeString("Fecha de pago: " + fecha);
            serialPort.writeBytes(ESP_SMALL);
            serialPort.writeString("Hora: " + hora);
            serialPort.writeBytes(ESP_MIDDLE);
            serialPort.writeString("Operador: " + operador);
            serialPort.writeBytes(ESP_SMALL);
            serialPort.writeString("UNIDAD: "+ unidad + " RUTA: " + ruta);
            serialPort.writeBytes(ESP_SMALL);
            serialPort.writeString("RAMAL: "+ ramal);
            serialPort.writeBytes(ESP_MIDDLE);
            
            serialPort.writeString("********************************");
            serialPort.writeBytes(ESP_MIDDLE);

            if (tipo_pago == 2) {
                serialPort.writeString("Tarjeta: " + num_tarjeta);
                serialPort.writeBytes(ESP_SMALL);
                serialPort.writeString("Servicios cobrados: " + cant_serv + "    Tarjeta");
                serialPort.writeBytes(ESP_SMALL);   
            } else {
                serialPort.writeString("Servicios cobrados: " + cant_serv + "   Efectivo");
                serialPort.writeBytes(ESP_SMALL);
            }

            if (niños > 0) {
                serialPort.writeString("Infantes: " + niños);
                serialPort.writeBytes(ESP_SMALL);
            }

            if (adultos > 0) {
                serialPort.writeString("Adultos: " + adultos);
                serialPort.writeBytes(ESP_SMALL);
            }

            if (estudiantes > 0) {
                serialPort.writeString("Estudiantes: " + estudiantes);
                serialPort.writeBytes(ESP_SMALL);
            }

            if (mayores > 0) {
                serialPort.writeString("Mayores: " + mayores);
                serialPort.writeBytes(ESP_SMALL);
            }

            if (maestro > 0) {
                serialPort.writeString("Mestros: " + maestro);
                serialPort.writeBytes(ESP_SMALL);
            }

            if (cap_dif > 0) {
                serialPort.writeString("Cap_dif: " + cap_dif);
                serialPort.writeBytes(ESP_SMALL);
            }
            serialPort.writeBytes(ESP_MIDDLE);
            serialPort.writeString("********************************");
            serialPort.writeBytes(ESP_MIDDLE);

            serialPort.writeString("                  Total: $" + total);
            serialPort.writeBytes(ESP_MIDDLE);
            
            serialPort.writeBytes(IMP_ESP);
            serialPort.writeBytes(CUT);
    }
}
