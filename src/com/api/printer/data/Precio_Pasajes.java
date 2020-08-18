/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.printer.data;

/**
 *
 * @author mendoza
 */
public class Precio_Pasajes {
    private double adulto_precio_m;
    private double niño_precio_m;
    private double estudiante_precio_m;
    private double mayor_precio_m;
    private double maestro_precio_m;
    private double cap_dif_precio_m;

    public Precio_Pasajes() {
    }

    public Precio_Pasajes(double adulto_precio_m, double niño_precio_m, double estudiante_precio_m, double mayor_precio_m, double maestro_precio_m, double cap_dif_precio_m) {
        this.adulto_precio_m = adulto_precio_m;
        this.niño_precio_m = niño_precio_m;
        this.estudiante_precio_m = estudiante_precio_m;
        this.mayor_precio_m = mayor_precio_m;
        this.maestro_precio_m = maestro_precio_m;
        this.cap_dif_precio_m = cap_dif_precio_m;
    }

    public double getAdulto_precio_m() {
        return adulto_precio_m;
    }

    public void setAdulto_precio_m(double adulto_precio_m) {
        this.adulto_precio_m = adulto_precio_m;
    }

    public double getNiño_precio_m() {
        return niño_precio_m;
    }

    public void setNiño_precio_m(double niño_precio_m) {
        this.niño_precio_m = niño_precio_m;
    }

    public double getEstudiante_precio_m() {
        return estudiante_precio_m;
    }

    public void setEstudiante_precio_m(double estudiante_precio_m) {
        this.estudiante_precio_m = estudiante_precio_m;
    }

    public double getMayor_precio_m() {
        return mayor_precio_m;
    }

    public void setMayor_precio_m(double mayor_precio_m) {
        this.mayor_precio_m = mayor_precio_m;
    }

    public double getMaestro_precio_m() {
        return maestro_precio_m;
    }

    public void setMaestro_precio_m(double maestro_precio_m) {
        this.maestro_precio_m = maestro_precio_m;
    }

    public double getCap_dif_precio_m() {
        return cap_dif_precio_m;
    }

    public void setCap_dif_precio_m(double cap_dif_precio_m) {
        this.cap_dif_precio_m = cap_dif_precio_m;
    }
    
}
