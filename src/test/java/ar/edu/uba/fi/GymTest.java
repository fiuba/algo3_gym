package ar.edu.uba.fi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class GymTest
{
    /**
     * Un socio con plan NoTanBasico quiere reservar la sala de musculación.
     */
    @Test
    public void caso01()
    {

        Socio joaquin = new Socio( "Nro. 1", new NoTanBasico(), new AgendaGimnasio() );

        joaquin.usa( new Musculacion(), "semana 2");
        joaquin.usa( new Musculacion(), "semana 3");

        Assertions.assertDoesNotThrow(() -> {
            joaquin.reservar( new Musculacion(), "semana 3");
        });
    }

    @Test
    public void caso01MusculacionNoAgotadaEnLaSemana()
    {

        Socio joaquin = new Socio( "Nro. 1", new NoTanBasico(), new AgendaGimnasio() );

        joaquin.usa( new Musculacion(), "semana 2");
        joaquin.usa( new Musculacion(), "semana 3");
        joaquin.usa( new Musculacion(), "semana 3");
        joaquin.usa( new Musculacion(), "semana 3");
        joaquin.usa( new Musculacion(), "semana 3");

        Assertions.assertDoesNotThrow(() -> {
            joaquin.reservar( new Musculacion(), "semana 10");
        });
    }

    @Test
    public void caso01AgotoMusculacion()
    {

        Socio joaquin = new Socio( "Nro. 1", new NoTanBasico(), new AgendaGimnasio() );

        joaquin.usa( new Musculacion(), "semana 2");
        joaquin.usa( new Musculacion(), "semana 3");
        joaquin.usa( new Musculacion(), "semana 3");
        joaquin.usa( new Musculacion(), "semana 3");
        joaquin.usa( new Musculacion(), "semana 3");

        Assertions.assertThrows(MusculacionAgotada.class, () -> {
            joaquin.reservar( new Musculacion(), "semana 3");
        });
    }

    @Test
    public void caso01AgotoCardio()
    {

        AgendaGimnasio agenda = new AgendaGimnasio();

        Socio joaquin = new Socio( "Nro. 1", new NoTanBasico(), agenda);

        agenda.reservaYaRegistrada( new Uso(joaquin, new Cardio(), "semana 4"));
        agenda.reservaYaRegistrada( new Uso(joaquin, new Cardio(), "semana 4"));

        joaquin.usa( new Cardio(), "semana 4");
        joaquin.usa( new Cardio(), "semana 4");
        joaquin.usa( new Cardio(), "semana 4");

        Assertions.assertThrows(CardioAgotada.class, () -> {
            joaquin.reservar( new Cardio(), "semana 4");
        });
    }
}
