package com.api.printer.data;

import com.api.printer.model.Impresora;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * 
 * @author login
 */
public class TicketInicioOperaciones {
    
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
     * CREACIÓN DE TICKET PARA INICIO DE OPERACIONES
     * 
     * @param modo_operacion
     * @param unidad
     * @param ruta
     * @param ramal
     * @param operador
     * @param tipo_tarifa
     * @param fecha_lista_negra
     * @param hora_lista_negra
     * @param fecha_tarifas
     * @param hora_tarifas
     * @param fecha_operadores
     * @param hora_operadores
     * @param fecha_unidades
     * @param hora_unidades
     * @throws InterruptedException
     * @throws SerialPortException 
     */
    public void print(
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
        //ABRIR PUERTO DE IMPRESORA
        serialPort = abrirPuerto.getSerialPort();
        //ACTIVO NEGRITAS
        serialPort.writeBytes(NEGRITAS);

        serialPort.writeString("    *INICIO DE OPERACIONES*");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("--------------------------------");
        serialPort.writeBytes(ESP_MIDDLE);

        serialPort.writeString("    FECHA Y HORA DE INICIO:");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("      " + FECHA + " " + HORA);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("MODO DE OPERACIÓN: " + modo_operacion);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("OPERADOR: " + operador);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("UNIDAD: " + unidad);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RUTA: " + ruta);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("RAMAL: " + ramal);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("TARIFA CON QUE SE OPERA:");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString(tipo_tarifa);
        serialPort.writeBytes(ESP_MIDDLE);
        serialPort.writeString("DATOS           FECHA Y HORA DE");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                ACTUALIZACIONES:");
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("LISTA NEGRA        " + fecha_lista_negra);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                   " + hora_lista_negra);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("TARIFAS            " + fecha_tarifas);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                   " + hora_tarifas);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("OPERADORES         " + fecha_operadores);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("                   " + hora_operadores);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("ADMINISTRADORES DE " + fecha_unidades);
        serialPort.writeBytes(ESP_SMALL);
        serialPort.writeString("UNIDADES           " + hora_unidades);
        serialPort.writeBytes(ESP_SMALL);


        serialPort.writeBytes(IMP_ESP);
        serialPort.writeBytes(CUT);
        //CERRAR PUERTO ENVIANDO EL YA ABIERTO
        cerrarPuerto.closeSerialPort(serialPort);             
    }
}
