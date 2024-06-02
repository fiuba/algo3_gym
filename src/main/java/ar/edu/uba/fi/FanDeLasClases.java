package ar.edu.uba.fi;

public class FanDeLasClases extends Plan {

    public FanDeLasClases() {
        super();

        inicializarLimites();
    }

    @Override
    protected void inicializarLimites() {
        this.limites.add(new Limite(new Musculacion(), 2));
        this.limites.add(new Limite(new Cardio(), 2));
    }

}
