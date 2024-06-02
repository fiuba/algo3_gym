package ar.edu.uba.fi;

public class Cardio implements Servicio {
    @Override
    public boolean equals(Object obj) {

        return obj.getClass().equals(this.getClass());
    }

    @Override
    public void verificarUsosMaximos(int maximoDeUsos, String idSocio, AgendaGimnasio agenda) {
        Long usos = agenda.cuantasCardioEstaSemana(idSocio);

        if ( usos >= maximoDeUsos ) {
            throw new CardioAgotada();
        }
    }

}
