package ar.edu.uba.fi;

public class Limite {
    private Servicio servicio;
    private int maximo;

    public Limite(Servicio servicio) {

        this.servicio = servicio;
        this.maximo = 0;
    }

    public Limite(Servicio servicio, int maximo) {

        this.servicio = servicio;
        this.maximo = maximo;
    }

    public boolean mismoServicio(Servicio servicio) {
        return servicio.equals(this.servicio);
    }

    public void verificarUsosMaximos(String idSocio, AgendaGimnasio agenda) {
        servicio.verificarUsosMaximos( maximo, idSocio, agenda );

    }
}
