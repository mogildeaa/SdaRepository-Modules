package com.sda.fisiere;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class ModernFileManipulator implements IFileManipulator {

    @Override
    public List<String> readFromFile(PathType pathType) {

        List<String> result = new LinkedList<>();
        String path = "";

        switch (pathType) {
            case ABSOLUT:
                path = ABSOLUTE_PATH;
                break;
            case RELATIVE:
                path = RELATIVE_PATH;
                break;
            default:
                System.out.println("Path received not recognized");
        }

        try {
            //Path e interfata si Paths e classa
            //din string path creez un obiect de tip Path
            //pe care il dau parametru in readAllLines();
            result.addAll(Files.readAllLines(Paths.get(path)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void writeToFile(List<String> linesToWrite, boolean append) {

        StandardOpenOption openOption;
        if(append){
            openOption = StandardOpenOption.APPEND;
        } else {
            openOption = StandardOpenOption.WRITE;
        }

        try {
            Files.write(Paths.get(RELATIVE_PATH), linesToWrite, openOption);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
