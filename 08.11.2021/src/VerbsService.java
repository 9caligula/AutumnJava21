import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VerbsService {
    public static final VerbsService getInstance = new VerbsService();
    private final List<Verb> verbs;
    private final String PATH = "src/verbs.csv";

    private VerbsService(){
        verbs = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(PATH))){
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tmp = line.split(";");
                Verb verb = new Verb(tmp[0], tmp[1], tmp[2], tmp[3]);
                verbs.add(verb);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Verb> getList(){
        if(verbs == null)
            return Collections.EMPTY_LIST;
        return Collections.unmodifiableList(verbs);
    }

    public void shuffle(){
        Collections.shuffle(verbs);
    }
}
