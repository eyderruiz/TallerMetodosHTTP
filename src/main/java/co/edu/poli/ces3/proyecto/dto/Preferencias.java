package co.edu.poli.ces3.proyecto.dto;

import java.util.ArrayList;
import java.util.List;

public class Preferencias {
    private String modalidadEstudio;

    private List<String> actividadesExtracurriculares = new ArrayList<>();

    private Notificaciones notificaciones;

    public String getModalidadEstudio() {
        return this.modalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        this.modalidadEstudio = modalidadEstudio;
    }

    public List<String> getActividadesExtracurriculares() {
        return this.actividadesExtracurriculares;
    }

    public void setActividadesExtracurriculares(List<String> actividadesExtracurriculares) {
        this.actividadesExtracurriculares = actividadesExtracurriculares;
    }

    public Notificaciones getNotificaciones() {
        return this.notificaciones;
    }

    public void setNotificaciones(Notificaciones notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"modalidadEstudio\":\"").append(this.modalidadEstudio).append("\",");
        json.append("\"actividadesExtracurriculares\":[");
        for (int i = 0; i < this.actividadesExtracurriculares.size(); i++) {
            json.append("\"").append(this.actividadesExtracurriculares.get(i)).append("\"");
            if (i < this.actividadesExtracurriculares.size() - 1)
                json.append(",");
        }
        json.append("],");
        json.append("\"notificaciones\":").append(this.notificaciones.toJson());
        json.append("}");
        return json.toString();
    }

    public String toString() {
        return "Preferencias{modalidadEstudio='" + this.modalidadEstudio + "'}";
    }
}
