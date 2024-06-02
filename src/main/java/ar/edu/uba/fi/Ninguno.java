package ar.edu.uba.fi;

public class Ninguno implements Servicio {

    public Ninguno() {

    }
    @Override
    public void verificarUsosMaximos(int maximoDeUsos, String idSocio, AgendaGimnasio agenda) {

        // Si no hay límite para el plan, esta verificación no arroja exception
    }
}
