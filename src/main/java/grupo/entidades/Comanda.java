package grupo.entidades;

import java.util.Date;

public class Comanda {

    private int id;
    private Date fecha;
    private float montoTotal;
    public Comanda(int id, Date fecha, float montoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }
    public Comanda() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public float getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

}
