import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] array = Files.readAllBytes(new File("C:\\Users\\79372\\source\\NetCracker\\AutumnJava21\\29.11.2021\\Ксения Демидова")
                .toPath());

        byte[] decoded = Base64.getDecoder().decode(array);

        Path fileB = Paths.get("image.png");
        Files.write(fileB, decoded);

    }
}