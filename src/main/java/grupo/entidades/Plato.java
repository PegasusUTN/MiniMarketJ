package grupo.entidades;

public class Plato {

    private int id;
    private String nombre;
    private float precio;
    private int vecesPedido;

    public Plato(int id, String nombre, float precio, int vecesPedido) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.vecesPedido = vecesPedido;
    }
    public Plato() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getVecesPedido() {
        return vecesPedido;
    }
    public void setVecesPedido(int vecesPedido) {
        this.vecesPedido = vecesPedido;
    }

}
