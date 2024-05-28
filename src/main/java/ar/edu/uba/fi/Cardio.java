package ar.edu.uba.fi;

public class Cardio extends Servicio {
    @Override
    public boolean equals(Object obj) {

        return obj.getClass().equals(this.getClass());
    }
}
