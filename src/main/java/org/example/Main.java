package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //|||  Author - Eugene  ||| 

        String filePath = parseFile("data/code.html");
        Jsoup.parse(filePath);
        Document document = Jsoup.parse(filePath);
        Elements elements = document.select(".link");
        elements.forEach(element -> {
            if (String.valueOf(element).contains("https://www.hse.ru/ma") || String.valueOf(element).contains("https://www.hse.ru/ba")) {
                System.out.println(element.text());
            }
        });


        /*System.out.println(filePath);*/
    }

    public static String parseFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            allLines.forEach(line -> stringBuilder.append(line + "\n"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return stringBuilder.toString();
    }
}