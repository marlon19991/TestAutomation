package Tests;

public class Personas {
    private String nombre;
    private String apellido;
    public Personas(String nombre, String apellido) {
        nombre = this.nombre;
        apellido = this.apellido;
    }

    public void saludar() {
        System.out.println("Hola "+this.nombre+" "+this.apellido);
    }
}
