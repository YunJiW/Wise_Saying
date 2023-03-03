package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Container.init();
        new App().Run();

        Container.close();
    }
}