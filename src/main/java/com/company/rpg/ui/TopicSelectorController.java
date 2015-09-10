package com.company.rpg.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TopicSelectorController extends TextUIController {

    public void execute() {
        Path path = Paths.get("assets/topics-list.txt");
        try {
            Stream<String> lines = Files.lines(path);
            lines.forEach(s -> System.out.println(s));
        } catch (IOException ex) {

        }
    }
}
