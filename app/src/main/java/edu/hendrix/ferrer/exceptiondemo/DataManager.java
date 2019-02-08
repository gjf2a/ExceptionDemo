package edu.hendrix.ferrer.exceptiondemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by gabriel on 2/8/19.
 */

public class DataManager {
    private File saveDir;

    public DataManager(File saveDir) {
        this.saveDir = saveDir;
    }

    public void saveRecord(Record r) throws IOException {
        File output = new File(saveDir, r.getName());
        PrintWriter pw = new PrintWriter(new FileWriter(output));
        pw.println(r);
        pw.close();
    }

    public Record openRecord(String name) throws FileNotFoundException {
        File input = new File(saveDir, name);
        Scanner s = new Scanner(input);
        String text = s.nextLine();
        s.close();
        return Record.parse(text);
    }
}
