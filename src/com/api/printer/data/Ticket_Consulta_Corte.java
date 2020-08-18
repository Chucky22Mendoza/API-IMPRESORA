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
public class Ticket_Consulta_Corte {
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
    
    //CREACIÓN DE TICKET DE CONSULTA DE CORTE
    public void ticket_consulta_corte(
                String fecha_inicio,
                String hora_inicio,
                String fecha_fin,
                String hora_fin,
                String unidad,
                String ruta,
                String ramal,
                String operador,
                String tipo_tarifa,
                double tarifa,
                int tarjetaPreferencialCantidad_cobrosNormales,
                int tarjetaPreferencialCantidad_viajesGratis,
                int tarjetaPreferencialCantidad_transbordos1,
                int tarjetaPreferencialCantidad_transbordos2,
                int tarjetaPreferencialCantidad_numTarjetas,
                double tarjetaPreferencialMonto_cobrosNormales,
                double tarjetaPreferencialMonto_viajesGratis,
                double tarjetaPreferencialMonto_transbordos1,
                double tarjetaPreferencialMonto_transbordos2,
                double tarjetaPreferencialMonto_numTarjetas,
                double tarjetaPreferencialMonto_total,
                int tarjetaOrdinariosCantidad_cobrosNormales,
                int tarjetaOrdinariosCantidad_viajesGratis,
                int tarjetaOrdinariosCantidad_transbordos1,
                int tarjetaOrdinariosCantidad_transbordos2,
                int tarjetaOrdinariosCantidad_numTarjetas,
                double tarjetaOrdinariosMonto_cobrosNormales,
                double tarjetaOrdinariosMonto_viajesGratis,
                double tarjetaOrdinariosMonto_transbordos1,
                double tarjetaOrdinariosMonto_transbordos2,
                double tarjetaOrdinariosMonto_numTarjetas,
                double tarjetaOrdinariosMonto_total,
                int pagosEfectivo_cantidadPasajes,
                double pagosEfectivo_total,
                int recargas,
                double totalRecargas,
                double totalCobradoEfectivo,
                double totalCobradoTarjeta,
                double totalCobrado
    ) throws InterruptedException, SerialPortException{
        serialPort = abrirPuerto.abrir_puerto();
        //ACTIVO NEGRITAS
        serialPort.writeBytes(NEGRITAS);

        serialPort.writeString(" CONSULTA DE COBROS DEL PERIODO");
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("       " + fecha_inicio + " " + hora_inicio );
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("               -");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("       " + fecha_fin + " " + hora_fin);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("OPERADOR: " + operador);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("UNIDAD: " + unidad + "    RUTA: " + ruta);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RAMAL: " + ramal);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString(tipo_tarifa);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                         TARIFA");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                         $" + tarifa);
        serialPort.writeBytes(ESP_MIDDLE);


        serialPort.writeString("--------PAGOS CON TARJETA-------");
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeString("Tarjetas Preferenciales");
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("             CANTIDAD   MONTO");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Cobros normales " + tarjetaPreferencialCantidad_cobrosNormales + "     $" + tarjetaPreferencialMonto_cobrosNormales);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Viajes Gratis   " + tarjetaPreferencialCantidad_viajesGratis + "     $" + tarjetaPreferencialMonto_viajesGratis);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Transbordos 1   " + tarjetaPreferencialCantidad_transbordos1 + "     $" + tarjetaPreferencialMonto_transbordos1);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Transbordos 2   " + tarjetaPreferencialCantidad_transbordos2 + "     $" + tarjetaPreferencialMonto_transbordos2);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("No. Tarjetas    " + tarjetaPreferencialCantidad_numTarjetas + "     $" + tarjetaPreferencialMonto_numTarjetas);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("        Monto Total: $" + tarjetaPreferencialMonto_total);
        serialPort.writeBytes(ESP_SMALL);

        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("Tarjetas Ordinarias");
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("             CANTIDAD   MONTO");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Cobros normales " + tarjetaOrdinariosCantidad_cobrosNormales + "     $" + tarjetaOrdinariosMonto_cobrosNormales);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Viajes Gratis   " + tarjetaOrdinariosCantidad_viajesGratis + "     $" + tarjetaOrdinariosMonto_viajesGratis);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Transbordos 1   " + tarjetaOrdinariosCantidad_transbordos1 + "     $" + tarjetaOrdinariosMonto_transbordos1);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("Transbordos 2   " + tarjetaOrdinariosCantidad_transbordos2 + "     $" + tarjetaOrdinariosMonto_transbordos2);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("No. Tarjetas    " + tarjetaOrdinariosCantidad_numTarjetas + "     $" + tarjetaOrdinariosMonto_numTarjetas);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("        Monto Total: $" + tarjetaOrdinariosMonto_total);
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeString("-------PAGOS CON EFECTIVO-------");
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("Cantidad de pasajes      " + pagosEfectivo_cantidadPasajes);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("      TOTAL EFECTIVO: $" + pagosEfectivo_total);
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeString("------------RECARGAS------------");
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("Recargas: " + recargas);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("       TOTAL RECARGAS: $" + totalRecargas);
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeString("--------------------------------");
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("TOTAL EN EFECTIVO: $" + totalCobradoEfectivo);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("TOTAL CON TARJETA: $" + totalCobradoTarjeta);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("       TOTAL COBRADO: $" + totalCobrado);
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeBytes(IMP_ESP);
        serialPort.writeBytes(CUT);

        cerrarPuerto.cerrar_puerto(serialPort);            
    }
}
