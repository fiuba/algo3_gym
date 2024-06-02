package ar.edu.uba.fi;

import java.util.ArrayList;

public abstract class Plan {
    protected final ArrayList<Limite> limites;

    public Plan() {

        this.limites = new ArrayList<Limite>();

        inicializarLimites();
    }

    public void verificarUsos(String idSocio, Servicio servicio, AgendaGimnasio agenda) {
        Limite limite = encontrarLimite(servicio);

        limite.verificarUsosMaximos(idSocio, agenda);
    }

    private Limite encontrarLimite(Servicio servicio) {
        return this.limites.stream()
                .filter((l) -> l.mismoServicio(servicio))
                .findFirst()
                .orElse(new Limite(new Ninguno()));
    }

    protected abstract void inicializarLimites();

}
