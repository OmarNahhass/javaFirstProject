import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
    public void writeToFile(String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/data.txt"));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
