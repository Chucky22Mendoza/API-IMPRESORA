package com.api.printer.data;

import com.api.printer.model.Impresora;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * 
 * @author login
 */
public class TicketPago {
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
     * CREACIÓN DE TICKET DE PAGO
     * 
     * @param tipo_pago
     * @param operador
     * @param unidad
     * @param ruta
     * @param ramal
     * @param num_tarjeta
     * @param cant_serv
     * @param niños
     * @param adultos
     * @param estudiantes
     * @param mayores
     * @param maestro
     * @param cap_dif
     * @param total
     * @throws InterruptedException
     * @throws SerialPortException 
     */
    public void print(
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
        //ABRIR PUERTO DE IMPRESORA
        serialPort = abrirPuerto.getSerialPort();
        //ACTIVO NEGRITAS
        serialPort.writeBytes(NEGRITAS);

        serialPort.writeString(" PAGO DE SERVICIOS DE TRANSPORTE");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("     FECHA Y HORA DE PAGO:");
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
        //CERRAR PUERTO ENVIANDO EL YA ABIERTO
        cerrarPuerto.closeSerialPort(serialPort);
    }
}
