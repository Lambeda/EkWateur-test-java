package main.java.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseurDB {

    private ParseurDB() {
    }

    public static String[] parseLine(String line) {
        return line.split(";");
    }
}
