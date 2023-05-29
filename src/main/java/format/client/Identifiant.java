package main.java.format.client;

import main.java.utils.InvalidIdentifiantException;

public interface Identifiant {
    public boolean checkFormat() throws InvalidIdentifiantException;
}
