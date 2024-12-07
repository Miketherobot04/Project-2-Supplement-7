import java.io.*;

public class FileHandler {

    /**
     * Writes content to a specified file. If the file does not exist, it will be created.
     *
     * @param filename the name of the file
     * @param content  the content to write to the file
     * @throws IOException if an I/O error occurs
     */
    public void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    /**
     * Reads content from a specified file and returns it as a String.
     *
     * @param filename the name of the file
     * @return the content of the file
     * @throws IOException if an I/O error occurs
     */
    public String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim();
    }

    /**
     * Appends content to a specified file. If the file does not exist, it will be created.
     *
     * @param filename the name of the file
     * @param content  the content to append to the file
     * @throws IOException if an I/O error occurs
     */
    public void appendToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(content);
        }
    }
}