package ar.edu.uba.fi;

import java.util.ArrayList;

public class Socio {
    private final ArrayList<Uso> usos;

    private String semana;
    private String idSocio;
    private NoTanBasico plan;
    private AgendaGimnasio agenda;

    public Socio(String idSocio, NoTanBasico plan, AgendaGimnasio agenda) {

        this.idSocio = idSocio;
        this.plan = plan;
        this.agenda = agenda;

        this.usos = new ArrayList<>();
    }

    public void usa(Servicio servicio, String semana) {

        this.usos.add(new Uso(this, servicio, semana));
    }

    public void reservar(Servicio servicio, String semana) {
        Uso usoParaValidar = new Uso(this, servicio, semana);

        long reservas = this.agenda.cuantasReservasPara(this, servicio, semana);
        long usosYaConsumidos = usoParaValidar.contarMisEquivalentes(this.usos);
        this.plan.verificarReservaPara(usoParaValidar, reservas, this.usos);
    }
}
