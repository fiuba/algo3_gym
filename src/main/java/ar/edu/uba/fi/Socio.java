package ar.edu.uba.fi;

import java.util.ArrayList;

public class Socio {
    private String idSocio;
    private Plan plan;

    public Socio(String idSocio, Plan plan) {

        this.idSocio = idSocio;
        this.plan = plan;
    }

    public void reservar(Servicio servicio, AgendaGimnasio agenda) {
        this.plan.verificarUsos(this.idSocio, servicio, agenda);
        agenda.registrar(idSocio, servicio);
    }
}
