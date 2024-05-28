package ar.edu.uba.fi;

import java.util.ArrayList;

public class AgendaGimnasio {

    private final ArrayList<Uso> reservasRegistradas;

    public AgendaGimnasio() {
        this.reservasRegistradas = new ArrayList<Uso>();
    }
    public void reservaYaRegistrada(Uso uso) {
        this.reservasRegistradas.add(uso);
    }

    public long cuantasReservasPara(Socio socio, Servicio servicio, String semana) {
        Uso intermedio = new Uso(socio, servicio, semana);

        return intermedio.contarMisEquivalentes(this.reservasRegistradas);
    }
}
