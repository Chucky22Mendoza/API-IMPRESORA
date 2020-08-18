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
public class Ticket_Inicio_Operaciones {
    
    Impresora impresora = new Impresora();
    Abrir_Puerto abrirPuerto = new Abrir_Puerto();
    Cerrar_Puerto cerrarPuerto = new Cerrar_Puerto();
    
    private static SerialPort serialPort;
    byte[] NEGRITAS = impresora.getNEGRITAS(); //LETRAS EN NEGRITAS
    byte[] IMP_ESP = impresora.getIMP_ESP(); //ESPACIO ANTES DE CORTAR
    byte[] CUT = impresora.getCUT(); //CORTE PARCIAL
    byte[] ESP_SMALL = impresora.getESP_SMALL(); //ESPACIO PEQUEÑO
    byte[] ESP_MIDDLE = impresora.getESP_MIDDLE(); //ESPACIO MEDIANO
    Calendar CALENDAR = impresora.getCALENDAR();
    
    //CREACIÓN DE TICKET PARA INICIO DE OPERACIONES
    public void ticket_inicio_operaciones(
            String modo_operacion,
            String unidad, 
            String ruta, 
            String ramal, 
            String operador,
            String tipo_tarifa,
            String fecha_lista_negra,
            String hora_lista_negra,
            String fecha_tarifas,
            String hora_tarifas,
            String fecha_operadores,
            String hora_operadores,
            String fecha_unidades,
            String hora_unidades
    ) throws InterruptedException, SerialPortException{
        
        String hora = CALENDAR.get(Calendar.HOUR_OF_DAY) + ":" + CALENDAR.get(Calendar.MINUTE) + ":" + CALENDAR.get(Calendar.SECOND);
        String fecha = CALENDAR.get(Calendar.YEAR) + "-" + CALENDAR.get(Calendar.MONTH) + "-" + CALENDAR.get(Calendar.DAY_OF_MONTH);
        //ACTIVO NEGRITAS
        serialPort = abrirPuerto.abrir_puerto();

        serialPort.writeBytes(NEGRITAS);

        serialPort.writeString("    *INICIO DE OPERACIONES*");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("--------------------------------");
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeString("FECHA Y HORA DE INICIO");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("             " + fecha + " " + hora);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("MODO DE OPERACIÓN");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                   " + modo_operacion);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("OPERADOR");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                   " + operador);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("UNIDAD");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                             " + unidad);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RUTA");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                             " + ruta);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RAMAL");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                    " + ramal);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("TARIFA CON QUE SE OPERA");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString(tipo_tarifa);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("DATOS            FECHA Y HORA DE");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                ACTUALIZACIONES:");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("LISTA NEGRA        " + fecha_lista_negra);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                  " + hora_lista_negra);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("TARIFAS            " + fecha_tarifas);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                  " + hora_tarifas);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("OPERADORES         " + fecha_operadores);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                  " + hora_operadores);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("ADMINISTRADORES DE");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("UNIDADES           " + fecha_unidades);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                  " + hora_unidades);
        serialPort.writeBytes(ESP_SMALL);


        serialPort.writeBytes(IMP_ESP);
        serialPort.writeBytes(CUT);

        cerrarPuerto.cerrar_puerto(serialPort);             
    }
}
