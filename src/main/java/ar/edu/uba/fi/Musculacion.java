package ar.edu.uba.fi;

public class Musculacion implements Servicio {
    @Override
    public boolean equals(Object obj) {

        return obj.getClass().equals(this.getClass());
    }

    @Override
    public void verificarUsosMaximos(int maximoDeUsos, String idSocio, AgendaGimnasio agenda) {
        Long usos = agenda.cuantasVecesASalaMusculacion(idSocio);

        if ( usos >= maximoDeUsos ) {
            throw new MusculacionAgotada();
        }
    }


}
