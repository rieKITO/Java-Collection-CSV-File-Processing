import org.example.CSVPersonDataReader;
import org.example.Person;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CSVPersonDataReaderTest {

    @Test
    public void testReadCSVFile() throws IOException {
        String csvFilePath = "foreign_names.csv";
        char separator = ';';
        CSVPersonDataReader csvPersonDataReader = new CSVPersonDataReader(csvFilePath, separator);
        csvPersonDataReader.readCSVFile();
        assertEquals(25898, csvPersonDataReader.getPersonList().size());
    }

    @Test
    public void testInvalidCSVFile() {
        // Arrange
        String csvFilePath = "nonexistent_file.csv"; // Файл не существует
        char separator = ';';
        CSVPersonDataReader csvReader = new CSVPersonDataReader(csvFilePath, separator);

        // Act & Assert
        assertThrows(IOException.class, () -> csvReader.readCSVFile());
    }

    private void createTestCSVFile() {

    }
}
