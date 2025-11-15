package co.edu.poli.ces3.proyecto.dto;

public class Notificaciones {
    private boolean email;

    private boolean sms;

    private boolean app;

    public Notificaciones() {}

    public Notificaciones(boolean email, boolean sms, boolean app) {
        this.email = email;
        this.sms = sms;
        this.app = app;
    }

    public boolean isEmail() {
        return this.email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isSms() {
        return this.sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    public boolean isApp() {
        return this.app;
    }

    public void setApp(boolean app) {
        this.app = app;
    }

    public String toJson() {
        return "{\"email\":" + this.email + ",\"sms\":" + this.sms + ",\"app\":" + this.app + "}";
    }

    public String toString() {
        return "Notificaciones{email=" + this.email + ", sms=" + this.sms + ", app=" + this.app + "}";
    }
}
