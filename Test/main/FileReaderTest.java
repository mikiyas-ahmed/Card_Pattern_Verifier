package main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void fileReaderWithWrongPath() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("something is wrong with reading the file");
        String path="src"+ File.separator+"resources"+ File.separator+"wrongConf.csv";
        List<String> list =FileReader.fileReader(path);

    }
}