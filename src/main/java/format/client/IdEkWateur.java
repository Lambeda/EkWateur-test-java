package main.java.format.client;

import main.java.utils.InvalidIdentifiantException;

import java.util.Objects;
import java.util.regex.Pattern;

public class IdEkWateur implements Identifiant {
    private String numericId;
    private String prefixe = "EKW";

    public IdEkWateur(String numericId) throws InvalidIdentifiantException {

        if (numericId.contains(prefixe))
            this.numericId = numericId.substring(prefixe.length());
        else
            this.numericId = numericId;
        checkFormat();
    }

    public String getIdEkWateur() {
        return prefixe + numericId;
    }

    public String getNumericId() {
        return numericId;
    }

    public void setNumericId(String numericId) {
        this.numericId = numericId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdEkWateur that)) return false;
        return Objects.equals(numericId, that.numericId);
    }

    @Override
    public boolean checkFormat() throws InvalidIdentifiantException {
        String regexIdEkWateur= "[0-9]{8}";
        if (numericId == null || numericId.isEmpty() || !Pattern.matches(regexIdEkWateur, numericId)) {
            throw new InvalidIdentifiantException("Format identifiant EKWateur invalide");
        }
        return true;
    }
}
