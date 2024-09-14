package paper.ReadAndWriteUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class WriteFileTest {

    @Test
    void output() throws IOException {
        WriteFile.Write("C:/Users/1027/Desktop/测试文本/answertest.txt",74.22);
    }
}
