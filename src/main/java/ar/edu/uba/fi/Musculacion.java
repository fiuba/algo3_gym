package ar.edu.uba.fi;

public class Musculacion extends Servicio {
    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(this.getClass());
    }
}
