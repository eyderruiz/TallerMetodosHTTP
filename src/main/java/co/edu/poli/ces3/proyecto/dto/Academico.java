package co.edu.poli.ces3.proyecto.dto;

import java.util.ArrayList;
import java.util.List;

public class Academico {
    private String programa;

    private int semestreActual;

    private double promedioAcumulado;

    private List<String> materiasInscritas = new ArrayList<>();

    private List<DetalleMateria> detalleMaterias = new ArrayList<>();

    public String getPrograma() {
        return this.programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getSemestreActual() {
        return this.semestreActual;
    }

    public void setSemestreActual(int semestreActual) {
        this.semestreActual = semestreActual;
    }

    public double getPromedioAcumulado() {
        return this.promedioAcumulado;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public List<String> getMateriasInscritas() {
        return this.materiasInscritas;
    }

    public void setMateriasInscritas(List<String> materiasInscritas) {
        this.materiasInscritas = materiasInscritas;
    }

    public List<DetalleMateria> getDetalleMaterias() {
        return this.detalleMaterias;
    }

    public void setDetalleMaterias(List<DetalleMateria> detalleMaterias) {
        this.detalleMaterias = detalleMaterias;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"programa\":\"").append(this.programa).append("\",");
        json.append("\"semestreActual\":").append(this.semestreActual).append(",");
        json.append("\"promedioAcumulado\":").append(this.promedioAcumulado).append(",");
        json.append("\"materiasInscritas\":[");
        int i;
        for (i = 0; i < this.materiasInscritas.size(); i++) {
            json.append("\"").append(this.materiasInscritas.get(i)).append("\"");
            if (i < this.materiasInscritas.size() - 1)
                json.append(",");
        }
        json.append("],");
        json.append("\"detalleMaterias\":[");
        for (i = 0; i < this.detalleMaterias.size(); i++) {
            json.append(((DetalleMateria)this.detalleMaterias.get(i)).toJson());
            if (i < this.detalleMaterias.size() - 1)
                json.append(",");
        }
        json.append("]");
        json.append("}");
        return json.toString();
    }

    public String toString() {
        return "Academico{programa='" + this.programa + "', semestre=" + this.semestreActual + ", promedioAcumulado=" + this.promedioAcumulado + ", materiasInscritas=" + this.materiasInscritas + ", detalleMaterias=" + this.detalleMaterias + "}";
    }
}
