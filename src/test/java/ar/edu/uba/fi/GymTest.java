package ar.edu.uba.fi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class GymTest
{

    public static final String ID_SOCIO_JOAQUIN = "Nro. 1";

    /**
     * Un socio con plan NoTanBasico quiere reservar la sala de musculación.
     */
    @Test
    public void caso01NoTanBasicoPuedeReservarMusculacion()
    {

        AgendaGimnasio agenda = new AgendaGimnasio();

        Socio joaquin = new Socio(ID_SOCIO_JOAQUIN, new NoTanBasico());

        Assertions.assertDoesNotThrow(() -> {
            joaquin.reservar( new Musculacion(), agenda);
        });
    }

    @Test
    public void caso01NoTanBasicoNoPuedeReservarMusculacion()
    {

        AgendaGimnasio agenda = new AgendaGimnasio();

        Socio joaquin = new Socio(ID_SOCIO_JOAQUIN, new NoTanBasico());

        joaquin.reservar( new Musculacion(), agenda);
        joaquin.reservar( new Musculacion(), agenda);
        joaquin.reservar( new Musculacion(), agenda);
        joaquin.reservar( new Musculacion(), agenda);

        Assertions.assertThrows(MusculacionAgotada.class, () -> {
            joaquin.reservar( new Musculacion(), agenda);
        });
    }

    @Test
    public void caso02FanDeLasClasesNoPuedeReservarMusculacion()
    {

        AgendaGimnasio agenda = new AgendaGimnasio();

        Socio santi = new Socio( "Nro. 15", new FanDeLasClases());

        santi.reservar( new Musculacion(), agenda);
        santi.reservar( new Musculacion(), agenda);

        Assertions.assertThrows(MusculacionAgotada.class, () -> {
            santi.reservar( new Musculacion(), agenda);
        });
    }

    @Test
    public void caso02FanDeLasClasesNoPuedeReservarCardio()
    {

        AgendaGimnasio agenda = new AgendaGimnasio();

        Socio santi = new Socio( "Nro. 15", new FanDeLasClases());

        santi.reservar( new Cardio(), agenda);
        santi.reservar( new Cardio(), agenda);

        Assertions.assertThrows(CardioAgotada.class, () -> {
            santi.reservar( new Cardio(), agenda);
        });
    }

    @Test
    public void caso02FanDeLasClasesPuedeTomarClasesIlimitadas()
    {

        AgendaGimnasio agenda = new AgendaGimnasio();

        Socio santi = new Socio( "Nro. 15", new FanDeLasClases());

        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);
        santi.reservar( new ClaseGrupal(), agenda);

        Assertions.assertDoesNotThrow(() -> santi.reservar( new ClaseGrupal(), agenda));
    }


}
