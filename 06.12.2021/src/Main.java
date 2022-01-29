import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("src", "russian_nouns.txt"), UTF_8);
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();


    }
}
