package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Comenzile vor fi citite și parsate în cadrul clasei Main. Funcția public static void
 * main(String[] args) va primi ca parametru numele aferent testului ce urmează să fie
 * executat. Astfel, folderul aferent testului va avea denumirea parametrului, iar fișierul care
 * conține comenzile se va afla în folderul aferent și va avea denumirea input.in. De exemplu,
 * pentru parametrul 00-test, folderul aferent va avea calea
 * “src/main/resources/00-test”, iar fișierul cu comenzi va avea calea
 * “src/main/resources/00-test/input.in”. Va trebui să creați și să scrieți rezultatul
 * comenzilor ce necesită afișare în fișierele
 * “src/main/resources/00-test/runway_info_<ID_pista>_<timestamp>.out”,
 * “src/main/resources/00-test/flight_info.out” sau
 * “src/main/resources/00-test/board_exceptions.out”, iar fișierele de referință, pe
 * care nu aveți voie să le modificați, vor fi de tipul
 * “src/main/resources/00-test/***.ref”.
 */
public class Main {
    String antetResources = "src/main/resources/";
    public static void main(String[] args) {
        String antetResources = "src/main/resources/";
        String test_name = args[0];
        File[] files = new File(antetResources + test_name).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".in")) {

            }
        }
    }

    public void readCommands(String test_name) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(antetResources + test_name + "/input.in"));
        for (String line : lines) {
            String[] parts = line.split(" - ");
            String timestamp = parts[0];
            String command = parts[1];
            String runwayId = parts[2];
            String utility = parts[3];
            String airplaneType = parts[4];
        }
    }


}