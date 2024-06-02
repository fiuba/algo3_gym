package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.Objects;

public class Uso {
    private String idSocio;
    private Servicio servicio;

    public Uso(String idSocio, Servicio servicio) {
        this.idSocio = idSocio;
        this.servicio = servicio;
    }

    public Long contarMisEquivalentes(ArrayList<Uso> usos) {
        return usos.stream()
                .filter((e) -> e.equals(this))
                .count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uso uso = (Uso) o;
        return Objects.equals(idSocio, uso.idSocio) && Objects.equals(servicio, uso.servicio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSocio, servicio);
    }
}
