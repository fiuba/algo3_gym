package ar.edu.uba.fi;

public class NoTanBasico extends Plan {


    @Override
    protected void inicializarLimites() {
        this.limites.add(new Limite(new Musculacion(), 4));
        this.limites.add(new Limite(new Cardio(), 4));
        this.limites.add(new Limite(new ClaseGrupal(), 3));
    }

}
