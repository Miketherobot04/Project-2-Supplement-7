import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    private static final String TEST_FILE = "testFile.txt";
    private FileHandler fileHandler;

    @BeforeEach
    public void setUp() {
        fileHandler = new FileHandler();
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    public void testWriteToFile() throws IOException {
        String content = "Hello, world!";
        fileHandler.writeToFile(TEST_FILE, content);
        String fileContent = Files.readString(Paths.get(TEST_FILE));
        assertEquals(content, fileContent, "Content should match the written text.");
    }

    @Test
    public void testReadFromFile() throws IOException {
        String content = "Read me!";
        Files.writeString(Paths.get(TEST_FILE), content);
        String fileContent = fileHandler.readFromFile(TEST_FILE);
        assertEquals(content, fileContent, "Content should match the file content.");
    }

    @Test
    public void testAppendToFile() throws IOException {
        String initialContent = "Initial content.";
        String appendedContent = " Appended content.";
        fileHandler.writeToFile(TEST_FILE, initialContent);
        fileHandler.appendToFile(TEST_FILE, appendedContent);
        String expectedContent = initialContent + appendedContent;
        String fileContent = Files.readString(Paths.get(TEST_FILE));
        assertEquals(expectedContent, fileContent, "Content should include both initial and appended text.");
    }
}