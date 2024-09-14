package paper.ReadAndWriteUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteFile {

    public static void Write(String url,Number ratio) throws IOException {
        try {
            // 创建FileOutputStream对象，用于将数据写入指定路径的文件
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            // 将指定的字符串写入文件
            System.out.println("论文查重率为 " + String.format("%.2f",ratio) + "%");
            outputStreamWriter.write("论文查重率为 " + String.format("%.2f",ratio) + "%");
            outputStreamWriter.close();
        } catch (IOException e) {
            // 如果发生I/O错误，抛出运行时异常并附带详细错误信息
            throw new IOException("文件写入失败" + e);
        }

    }
}