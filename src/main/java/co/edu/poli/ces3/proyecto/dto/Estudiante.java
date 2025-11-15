package co.edu.poli.ces3.proyecto.dto;

public class Estudiante {
    private InformacionPersonal informacionPersonal;

    private Academico academico;

    private Preferencias preferencias;

    public Estudiante() {}

    public Estudiante(InformacionPersonal informacionPersonal, Academico academico, Preferencias preferencias) {
        this.informacionPersonal = informacionPersonal;
        this.academico = academico;
        this.preferencias = preferencias;
    }

    public InformacionPersonal getInformacionPersonal() {
        return this.informacionPersonal;
    }

    public void setInformacionPersonal(InformacionPersonal informacionPersonal) {
        this.informacionPersonal = informacionPersonal;
    }

    public Academico getAcademico() {
        return this.academico;
    }

    public void setAcademico(Academico academico) {
        this.academico = academico;
    }

    public Preferencias getPreferencias() {
        return this.preferencias;
    }

    public void setPreferencias(Preferencias preferencias) {
        this.preferencias = preferencias;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"informacionPersonal\":").append(this.informacionPersonal.toJson()).append(",");
        json.append("\"academico\":").append(this.academico.toJson()).append(",");
        json.append("\"preferencias\":").append(this.preferencias.toJson());
        json.append("}");
        return json.toString();
    }

    public String toString() {
        return "Estudiante{informacionPersonal=" + this.informacionPersonal + ", academico=" + this.academico + ", preferencias=" + this.preferencias + '}';
    }
}
