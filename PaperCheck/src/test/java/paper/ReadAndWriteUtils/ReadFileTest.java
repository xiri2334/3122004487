package paper.ReadAndWriteUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class ReadFileTest {

    @Test
    void read() throws FileNotFoundException {
        String sum = ReadFile.Read("C:/Users/1027/Desktop/测试文本/2411Yagi.txt");
        assertEquals("超强台风摩羯（英语：Super Typhoon Yagi，国际编号：2411，联合台风警报中心：12W）是2024年太平洋台风季第11个被命名的风暴。“摩羯”一名由日本提供，含义即摩羯座,本次为“摩羯”一名第五次使用。台风“摩羯”于2024年9月1日晚在菲律宾以东洋面上生成，9月2日下午在菲律宾东北部奥罗拉省卡西古兰市登陆。此后其逐渐发展增强，于9月6日达到中央气象台认定的68米/秒强度，并于当日16时20分以62米/秒登陆中国海南省文昌市翁田镇沿海，后又于9月7日15时30分前后以58米/秒登陆越南广宁省南部沿海。最终于9月8日17时被中央气象台停止编号\r\n", sum);
    }
}