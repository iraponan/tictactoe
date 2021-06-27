package br.eti.inovareti.tictactoe.score;

import br.eti.inovareti.tictactoe.core.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileScoreManager implements ScoreManager {

    private static final Path SCORE_FILE = Path.of("score.txt");
    private Map<String, Integer> scoreMap = new HashMap<>();

    public FileScoreManager() throws IOException {
        setup();
    }

    @Override
    public Integer getScore(Player player) {
        return null;
    }

    @Override
    public void saveScore(Player player) {

    }

    private void setup() throws IOException {
        if (!Files.exists(SCORE_FILE)) {
            Files.createFile(SCORE_FILE);
        }
        try (BufferedReader reader = Files.newBufferedReader(SCORE_FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                scoreMap.put(tokens[0], Integer.parseInt(tokens[1]));
            }
        }
        //reader.close();
    }
}
