package co.edu.poli.ces3.proyecto.dto;

public class DetalleMateria {
    private String nombre;

    private int creditos;

    private String docente;

    private String estado;

    public DetalleMateria() {}

    public DetalleMateria(String nombre, int creditos, String docente, String estado) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
        this.estado = estado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return this.creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getDocente() {
        return this.docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String toJson() {
        return "{\"nombre\":\"" + this.nombre + "\",\"creditos\":" + this.creditos + ",\"docente\":\"" + this.docente + "\",\"estado\":\"" + this.estado + "\"}";
    }

    public String toString() {
        return "DetalleMateria{nombre='" + this.nombre + "', creditos=" + this.creditos + ", docente='" + this.docente + "', estado='" + this.estado + "'}";
    }
}
