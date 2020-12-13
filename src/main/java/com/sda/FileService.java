package com.sda;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileService {
    public static char[][] loadMap() {
        char map[][] = new char[10][];
        try {
            final List<String> lines = Files.readAllLines(Paths.get(
                    FileService.class
                            .getClassLoader()
                            .getResource("map.txt")
                            .toURI()
            ));
            for (int i = 0; i < lines.size(); i++) {
                map[i] = lines.get(i).toCharArray();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return map;
    }
}
