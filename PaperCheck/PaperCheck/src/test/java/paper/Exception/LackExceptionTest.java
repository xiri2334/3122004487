package paper.Exception;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LackExceptionTest {

    @Test
    void test() {
        String[] args = {"C:/Users/1027/Desktop/测试文本/orig.txt", "C:/Users/1027/Desktop/测试文本/orig_0.8_add.txt"};

        // 判断命令行参数是否有三个
        if (args.length < 3) throw new LackException("绝对路径不足三个");
    }

}
