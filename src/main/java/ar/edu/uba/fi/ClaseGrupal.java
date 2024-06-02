package ar.edu.uba.fi;

public class ClaseGrupal implements Servicio {

    @Override
    public boolean equals(Object obj) {

        return obj.getClass().equals(this.getClass());
    }

    @Override
    public void verificarUsosMaximos(int maximoDeUsos, String idSocio, AgendaGimnasio agenda) {
        Long usos = agenda.cuantasClasesEstaSemana(idSocio);

        if ( usos > maximoDeUsos ) {
            throw new ClasesGrupalesAgotadas();
        }
    }
}
