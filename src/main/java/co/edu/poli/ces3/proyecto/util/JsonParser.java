package co.edu.poli.ces3.proyecto.util;

import co.edu.poli.ces3.proyecto.dto.Academico;
import co.edu.poli.ces3.proyecto.dto.DetalleMateria;
import co.edu.poli.ces3.proyecto.dto.Estudiante;
import co.edu.poli.ces3.proyecto.dto.InformacionPersonal;
import co.edu.poli.ces3.proyecto.dto.Notificaciones;
import co.edu.poli.ces3.proyecto.dto.Preferencias;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static Estudiante parseEstudiante(String json) {
        json = json.trim();
        Estudiante InfStudent = new Estudiante();
        String infoPersonalJson = extraerObjeto(json, "informacionPersonal");
        if (infoPersonalJson != null)
            InfStudent.setInformacionPersonal(parseInformacionPersonal(infoPersonalJson));
        String academicoJson = extraerObjeto(json, "academico");
        if (academicoJson != null)
            InfStudent.setAcademico(parseAcademico(academicoJson));
        String preferenciasJson = extraerObjeto(json, "preferencias");
        if (preferenciasJson != null)
            InfStudent.setPreferencias(parsePreferencias(preferenciasJson));
        return InfStudent;
    }

    private static InformacionPersonal parseInformacionPersonal(String json) {
        InformacionPersonal info = new InformacionPersonal();
        info.setNombreCompleto(extraerString(json, "nombreCompleto"));
        info.setCorreo(extraerString(json, "correo"));
        info.setTelefono(extraerString(json, "telefono"));
        info.setCiudadResidencia(extraerString(json, "ciudadResidencia"));
        info.setEdad(extraerInt(json, "edad"));
        return info;
    }

    private static Academico parseAcademico(String json) {
        Academico academico = new Academico();
        academico.setPrograma(extraerString(json, "programa"));
        academico.setSemestreActual(extraerInt(json, "semestreActual"));
        academico.setPromedioAcumulado(extraerDouble(json, "promedioAcumulado"));
        String materiasJson = extraerArray(json, "materiasInscritas");
        if (materiasJson != null)
            academico.setMateriasInscritas(parseStringArray(materiasJson));
        String detalleJson = extraerArray(json, "detalleMaterias");
        if (detalleJson != null)
            academico.setDetalleMaterias(parseDetalleMaterias(detalleJson));
        return academico;
    }

    private static List<DetalleMateria> parseDetalleMaterias(String arrayJson) {
        List<DetalleMateria> lista = new ArrayList<>();
        List<String> objetos = dividirArrayObjetos(arrayJson);
        for (String obj : objetos) {
            DetalleMateria detalle = new DetalleMateria();
            detalle.setNombre(extraerString(obj, "nombre"));
            detalle.setCreditos(extraerInt(obj, "creditos"));
            detalle.setDocente(extraerString(obj, "docente"));
            detalle.setEstado(extraerString(obj, "estado"));
            lista.add(detalle);
        }
        return lista;
    }

    private static Preferencias parsePreferencias(String json) {
        Preferencias pref = new Preferencias();
        pref.setModalidadEstudio(extraerString(json, "modalidadEstudio"));
        String actividadesJson = extraerArray(json, "actividadesExtracurriculares");
        if (actividadesJson != null)
            pref.setActividadesExtracurriculares(parseStringArray(actividadesJson));
        String notifJson = extraerObjeto(json, "notificaciones");
        if (notifJson != null) {
            Notificaciones notif = new Notificaciones();
            notif.setEmail(extraerBoolean(notifJson, "email"));
            notif.setSms(extraerBoolean(notifJson, "sms"));
            notif.setApp(extraerBoolean(notifJson, "app"));
            pref.setNotificaciones(notif);
        }
        return pref;
    }

    private static String extraerString(String json, String campo) {
        String patron = "\"" + campo + "\"";
        int inicio = json.indexOf(patron);
        if (inicio == -1)
            return null;
        inicio = json.indexOf(":", inicio) + 1;
        inicio = json.indexOf("\"", inicio) + 1;
        int fin = json.indexOf("\"", inicio);
        return json.substring(inicio, fin);
    }

    private static int extraerInt(String json, String campo) {
        String valor = extraerValorPrimitivo(json, campo);
        try {
            return (valor != null) ? Integer.parseInt(valor.trim()) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static double extraerDouble(String json, String campo) {
        String valor = extraerValorPrimitivo(json, campo);
        try {
            return (valor != null) ? Double.parseDouble(valor.trim()) : 0.0D;
        } catch (NumberFormatException e) {
            return 0.0D;
        }
    }

    private static boolean extraerBoolean(String json, String campo) {
        String valor = extraerValorPrimitivo(json, campo);
        return (valor != null && valor.trim().equals("true"));
    }

    private static String extraerValorPrimitivo(String json, String campo) {
        String patron = "\"" + campo + "\"";
        int inicio = json.indexOf(patron);
        if (inicio == -1)
            return null;
        inicio = json.indexOf(":", inicio) + 1;
        int fin = json.indexOf(",", inicio);
        if (fin == -1)
            fin = json.indexOf("}", inicio);
        return json.substring(inicio, fin).trim();
    }

    private static String extraerObjeto(String json, String campo) {
        String patron = "\"" + campo + "\"";
        int inicio = json.indexOf(patron);
        if (inicio == -1)
            return null;
        inicio = json.indexOf("{", inicio);
        int contador = 1;
        int i = inicio + 1;
        while (i < json.length() && contador > 0) {
            if (json.charAt(i) == '{')
                contador++;
            if (json.charAt(i) == '}')
                contador--;
            i++;
        }
        return json.substring(inicio, i);
    }

    private static String extraerArray(String json, String campo) {
        String patron = "\"" + campo + "\"";
        int inicio = json.indexOf(patron);
        if (inicio == -1)
            return null;
        inicio = json.indexOf("[", inicio);
        int fin = json.indexOf("]", inicio) + 1;
        return json.substring(inicio, fin);
    }

    private static List<String> parseStringArray(String arrayJson) {
        List<String> lista = new ArrayList<>();
        arrayJson = arrayJson.substring(1, arrayJson.length() - 1);
        String[] elementos = arrayJson.split(",");
        for (String elem : elementos) {
            String limpio = elem.trim().replace("\"", "");
            if (!limpio.isEmpty())
                lista.add(limpio);
        }
        return lista;
    }

    private static List<String> dividirArrayObjetos(String arrayJson) {
        List<String> objetos = new ArrayList<>();
        arrayJson = arrayJson.substring(1, arrayJson.length() - 1).trim();
        int inicio = 0;
        int contador = 0;
        for (int i = 0; i < arrayJson.length(); i++) {
            char c = arrayJson.charAt(i);
            if (c == '{') {
                if (contador == 0)
                    inicio = i;
                contador++;
            } else {
                contador--;
                if (c == '}' && contador == 0)
                    objetos.add(arrayJson.substring(inicio, i + 1));
            }
        }
        return objetos;
    }
}
