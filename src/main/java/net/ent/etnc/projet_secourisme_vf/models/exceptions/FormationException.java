package net.ent.etnc.projet_secourisme_vf.models.exceptions;

public class FormationException extends Exception {
    public FormationException(String message) {
        super(message);
    }

    public FormationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormationException(Throwable cause) {
        super(cause);
    }
}
