package com.api.printer.data;

/**
 * 
 * @author login
 */
public class PrecioPasajes {
    private double adulto_precio_m;
    private double nigno_precio_m;
    private double estudiante_precio_m;
    private double mayor_precio_m;
    private double maestro_precio_m;
    private double cap_dif_precio_m;
    
    /**
     * CONSTRUCTOR VACÍO
     */
    public PrecioPasajes() {
    }
    
    /**
     * 
     * CONSTRUCTOR CON PARAMETROS DE LOS PASAJES
     * 
     * @param adulto_precio_m
     * @param nigno_precio_m
     * @param estudiante_precio_m
     * @param mayor_precio_m
     * @param maestro_precio_m
     * @param cap_dif_precio_m 
     */
    public PrecioPasajes(double adulto_precio_m, double nigno_precio_m, double estudiante_precio_m, double mayor_precio_m, double maestro_precio_m, double cap_dif_precio_m) {
        this.adulto_precio_m = adulto_precio_m;
        this.nigno_precio_m = nigno_precio_m;
        this.estudiante_precio_m = estudiante_precio_m;
        this.mayor_precio_m = mayor_precio_m;
        this.maestro_precio_m = maestro_precio_m;
        this.cap_dif_precio_m = cap_dif_precio_m;
    }
    
    /**
     * 
     * @return TYPE DOUBLE adulto_precio_m
     */
    public double getAdulto_precio_m() {
        return adulto_precio_m;
    }
    
    /**
     * 
     * @param adulto_precio_m 
     */
    public void setAdulto_precio_m(double adulto_precio_m) {
        this.adulto_precio_m = adulto_precio_m;
    }
    
    /**
     * 
     * @return TYPE DOUBLE precio de niño
     */
    public double getNigno_precio_m() {
        return nigno_precio_m;
    }

    /**
     * 
     * @param nigno_precio_m 
     */
    public void setNigno_precio_m(double nigno_precio_m) {
        this.nigno_precio_m = nigno_precio_m;
    }
    
    /**
     * 
     * @return TYPE DOUBLE estudiante_precio_m
     */
    public double getEstudiante_precio_m() {
        return estudiante_precio_m;
    }
    
    /**
     * 
     * @param estudiante_precio_m 
     */
    public void setEstudiante_precio_m(double estudiante_precio_m) {
        this.estudiante_precio_m = estudiante_precio_m;
    }

    /**
     * 
     * @return TYPE DOUBLE mayor_precio_m
     */
    public double getMayor_precio_m() {
        return mayor_precio_m;
    }
    
    /**
     * 
     * @param mayor_precio_m 
     */
    public void setMayor_precio_m(double mayor_precio_m) {
        this.mayor_precio_m = mayor_precio_m;
    }
    
    /**
     * 
     * @return TYPE DOUBLE maestro_precio_m
     */
    public double getMaestro_precio_m() {
        return maestro_precio_m;
    }

    /**
     * 
     * @param maestro_precio_m 
     */
    public void setMaestro_precio_m(double maestro_precio_m) {
        this.maestro_precio_m = maestro_precio_m;
    }
    
    /**
     * 
     * @return TYPE DOUBLE cap_dif_precio_m
     */
    public double getCap_dif_precio_m() {
        return cap_dif_precio_m;
    }

    /**
     * 
     * @param cap_dif_precio_m 
     */
    public void setCap_dif_precio_m(double cap_dif_precio_m) {
        this.cap_dif_precio_m = cap_dif_precio_m;
    }
    
}
