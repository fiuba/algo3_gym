package ar.edu.uba.fi;

import java.util.ArrayList;

public class NoTanBasico {
    public void verificarReservaPara(Uso usoParaValidar, long reservas, ArrayList<Uso> usos) {
        verificarMusculacionSemanalesDe(usoParaValidar, reservas, 4, usos);
        verificarCardioSemanalesDe(usoParaValidar, reservas, 4, usos);
        verificarClasesSemanalesDe(usoParaValidar.socio, reservas, 3, usos);

    }

    private void verificarMusculacionSemanalesDe(Uso usoParaValidar, long reservas, int maximo, ArrayList<Uso> usos) {
        Uso musculacion = usoParaValidar.conServicio( new Musculacion());
        long cantidad = musculacion.contarMisEquivalentes(usos);

        if (cantidad + reservas + 1 /* reserva en curso */ > maximo) {
            throw new MusculacionAgotada();
        }

    }

    private void verificarCardioSemanalesDe(Uso usoParaValidar, long reservas, int maximo, ArrayList<Uso> usos) {
        Uso cardio = usoParaValidar.conServicio( new Cardio());
        long cantidad = cardio.contarMisEquivalentes(usos);

        if (cantidad + reservas + 1 /* reserva en curso */ > maximo) {
            throw new CardioAgotada();
        }


    }

    private void verificarClasesSemanalesDe(Socio socio, long reservas, int maximo, ArrayList<Uso> usos) {

    }
}
