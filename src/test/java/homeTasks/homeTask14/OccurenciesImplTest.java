package homeTasks.homeTask14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OccurenciesImplTest {
    private static final String[] WORDS = {"спор", "слуга"};
    private static final String EXPECTED_OUTPUT =
            "Происхождение названия \"Казань\" до сих пор вызывает споры историков." + System.lineSeparator() +
                    "По древней легенде, нерадивый слуга хана Алтынбека уронил в реку золотой котел, символ власти и могущества господина." +
                    System.lineSeparator();

    private static StringBuilder input;
    private ReaderAndWriter readerAndWriter;

    @BeforeAll
    static void mockInput() {
        input = new StringBuilder();
        input.append("Происхождение названия \"Казань\" до сих пор вызывает споры историков.");
        input.append("Слово \"казан\" имеет давнюю историю. Одно из его значений - \"котел\".");
        input.append("По древней легенде, нерадивый слуга хана Алтынбека уронил в реку золотой котел, символ власти и могущества господина.");
    }

    @BeforeEach
    void initReaderAndWriter() {
        readerAndWriter = new ReaderAndWriter();
    }

    @Test
    @DisplayName("Исключение, если ReaderAndWriter null")
    void testNullReaderAndWriter() {
        Occurencies nullParser = new OccurenciesImpl(null);
        assertThrows(NullPointerException.class, () -> nullParser.getOccurencies(new String[]{""}, new String[]{}, new ByteArrayOutputStream()));
    }

    @Test
    @DisplayName("Исключение, если filePath null")
    void testNullFilePath() {
        assertThrows(NullPointerException.class, () -> readerAndWriter.sourceReader(null));
    }

    @Test
    @DisplayName("Исключение, если saveSentence null")
    void testNullSaveSentence() {
        assertThrows(NullPointerException.class, () -> readerAndWriter.fileWriter(null, new ByteArrayOutputStream()));
    }

    @Test
    @DisplayName("Исключение, если res null")
    void testNullRes() {
        assertThrows(NullPointerException.class, () -> readerAndWriter.fileWriter(new StringBuilder(), null));
    }

    @Test
    @DisplayName("Результат поиска совпадает с ожидаемым выводом")
    void getOccurencies() throws IOException {
        ReaderAndWriter mockedReaderAndWriter = Mockito.spy(new ReaderAndWriter());
        Mockito.doReturn(input.toString()).when(mockedReaderAndWriter).sourceReader(Mockito.anyString());

        Occurencies parser = new OccurenciesImpl(mockedReaderAndWriter);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        parser.getOccurencies(new String[]{""}, WORDS, outputStream);
        assertEquals(EXPECTED_OUTPUT, outputStream.toString());
    }
}