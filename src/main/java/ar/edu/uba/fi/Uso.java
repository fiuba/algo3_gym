package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.Objects;

public class Uso {
    public Socio socio;
    private Servicio servicio;
    public String semana;

    public Uso(Socio socio, Servicio servicio, String semana) {
        this.socio = socio;
        this.servicio = servicio;
        this.semana = semana;
    }

    public Uso(Servicio servicio, String semana) {
        this.socio = null /* anonimo */ ;
        this.servicio = servicio;
        this.semana = semana;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uso uso = (Uso) o;
        return Objects.equals(servicio, uso.servicio) &&
                Objects.equals(semana, uso.semana) &&
                Objects.equals(socio, uso.socio) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicio, semana);
    }

    public long contarMisEquivalentes(ArrayList<Uso> usos) {
        return usos.stream()
                .filter( (e) -> e.equals(this))
                .count();
    }

    public Uso conServicio(Servicio servicio) {
        return new Uso(this.socio, servicio, this.semana);
    }
}
