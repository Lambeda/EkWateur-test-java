package main.java.format.client;

import main.java.utils.InvalidIdentifiantException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Siret implements Identifiant {
    private String siret;

    public Siret(String siret) throws InvalidIdentifiantException {
        this.siret = siret;
        checkFormat();
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Siret siret1)) return false;
        return Objects.equals(siret, siret1.siret);
    }
    @Override
    public boolean checkFormat() throws InvalidIdentifiantException {
        String regexSiret = "[0-9]{14}";
        if (siret == null || siret.isEmpty() || !Pattern.matches(regexSiret, siret)) {
            throw new InvalidIdentifiantException("Format siret invalide");
        }
        return true;
    }
}
