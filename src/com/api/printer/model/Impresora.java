/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.printer.model;

import java.util.Calendar;

/**
 *
 * @author login
 */
public class Impresora {
    private byte[] NEGRITAS;
    private byte[] IMP_ESP;
    private byte[] CUT;
    private byte[] ESP_SMALL;
    private byte[] ESP_MIDDLE;
    private Calendar CALENDAR;
    
    public Impresora() {
        
    }

    public byte[] getNEGRITAS() {
        return new byte[] { 0x1B,0x45,1};
    }

    public byte[] getIMP_ESP() {
        return new byte[] { 0x1B,0x4A,99};
    }

    public byte[] getCUT() {
        return new byte[] { 0x1B,0x6D};
    }

    public byte[] getESP_SMALL() {
        return new byte[] { 0x1B,0x4A,15};
    }

    public byte[] getESP_MIDDLE() {
        return new byte[] { 0x1B,0x4A,35};
    }

    public Calendar getCALENDAR() {
        return Calendar.getInstance();
    }
    
}
