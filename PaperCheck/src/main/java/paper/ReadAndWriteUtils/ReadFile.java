package paper.ReadAndWriteUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {

    public static String Read(String url) throws FileNotFoundException {
        // 接收文件路径获取文件
        File file = new File(url);

        try {
            // 使用Scanner类读取文件内容
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            // 逐行读取文件内容并追加到StringBuilder对象中
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
                // 添加系统行分隔符来保持文件的原始格式
                content.append(System.lineSeparator());
            }
            scanner.close();
            System.out.println(content.toString());
            return content.toString();

        } catch (FileNotFoundException e) {
            // 文件未找到
            throw e;
        }

    }
}