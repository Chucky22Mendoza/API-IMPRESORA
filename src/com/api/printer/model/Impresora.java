package com.api.printer.model;

import java.util.Calendar;

/**
 *
 * @author login
 */
public class Impresora {
    /**
     * CONSTRUCTOR VACÍO
     */
    public Impresora() {
        
    }
    
    /**
     * 
     * @return TYPE ARRAY DE BYTES
     */
    public byte[] getNEGRITAS() {
        return new byte[] {0x1B,0x45,1};
    }
    
    /**
     * 
     * @return TYPE ARRAY DE BYTES
     */
    public byte[] getIMP_ESP() {
        return new byte[] {0x1B,0x4A,99};
    }

    /**
     * 
     * @return TYPE ARRAY DE BYTES
     */
    public byte[] getCUT() {
        return new byte[] {0x1B,0x6D};
    }

    /**
     * 
     * @return TYPE ARRAY DE BYTES
     */
    public byte[] getESP_SMALL() {
        return new byte[] {0x1B, 0x4A, 15};
    }
    
    /**
     * 
     * @return TYPE ARRAY DE BYTES
     */
    public byte[] getESP_MIDDLE() {
        return new byte[] {0x1B, 0x4A, 35};
    }

    /**
     * 
     * @return TYPE STRING
     */
    public String getHORA() {
        Calendar CALENDAR = Calendar.getInstance();
        return CALENDAR.get(Calendar.HOUR_OF_DAY) + ":" + CALENDAR.get(Calendar.MINUTE) + ":" + CALENDAR.get(Calendar.SECOND);
    }
    
    /**
     * 
     * @return TYPE STRING
     */
    public String getFECHA() {
        Calendar CALENDAR = Calendar.getInstance();
        return CALENDAR.get(Calendar.YEAR) + "-" + CALENDAR.get(Calendar.MONTH) + "-" + CALENDAR.get(Calendar.DAY_OF_MONTH);
    }
    
}
