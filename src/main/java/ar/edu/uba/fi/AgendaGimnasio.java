package ar.edu.uba.fi;

import java.util.ArrayList;

public class AgendaGimnasio {

    private final ArrayList<Uso> reservas;

    public AgendaGimnasio() {

        this.reservas = new ArrayList<Uso>();
    }

    public Long cuantasClasesEstaSemana(String idSocio) {
        Uso u = new Uso(idSocio, new ClaseGrupal());
        return u.contarMisEquivalentes(this.reservas);    }

    public Long cuantasVecesASalaMusculacion(String idSocio) {
        Uso u = new Uso(idSocio, new Musculacion());
        return u.contarMisEquivalentes(this.reservas);
    }

    public void registrar(String idSocio, Servicio servicio) {

        this.reservas.add(new Uso(idSocio, servicio));
    }

    public Long cuantasCardioEstaSemana(String idSocio) {
        Uso u = new Uso(idSocio, new Cardio());
        return u.contarMisEquivalentes(this.reservas);
    }
}
