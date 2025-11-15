package co.edu.poli.ces3.proyecto.dto;

public class InformacionPersonal {
    private String nombreCompleto;

    private int edad;

    private String correo;

    private String telefono;

    private String ciudadResidencia;

    public InformacionPersonal() {}

    public InformacionPersonal(String nombreCompleto, int edad, String correo, String telefono, String ciudadResidencia) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudadResidencia() {
        return this.ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String toJson() {
        return "{\"nombreCompleto\":\"" +
                escapeJson(this.nombreCompleto) + "\",\"edad\":" + this.edad + ",\"correo\":\"" +

                escapeJson(this.correo) + "\",\"telefono\":\"" +
                escapeJson(this.telefono) + "\",\"ciudadResidencia\":\"" +
                escapeJson(this.ciudadResidencia) + "\"}";
    }

    private String escapeJson(String str) {
        if (str == null)
            return "";
        return str.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    public String toString() {
        return "InformacionPersonal{nombreCompleto='" + this.nombreCompleto + "', edad=" + this.edad + ", correo='" + this.correo + "', telefono='" + this.telefono + "'}";
    }
}
