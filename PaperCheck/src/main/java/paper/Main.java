package paper;


import paper.ComputeUtils.Hamming;
import paper.ComputeUtils.SimHash;
import paper.Exception.LackException;
import paper.ReadAndWriteUtils.WriteFile;
import paper.ReadAndWriteUtils.ReadFile;

public class Main {
    public static void main(String[] args) throws Exception {
        // 判断命令行参数是否有三个
        if(args.length < 3) throw new LackException("绝对路径不足三个");


        // 读取两个文件的文本
        String string1 = ReadFile.Read(args[0]);
        String string2 = ReadFile.Read(args[1]);

        // 将文本转换simhash值,并计算海明距离并输出相似度
        String simhash1 = SimHash.getSimHash(string1);
        String simhash2 = SimHash.getSimHash(string2);
        double ratio = Hamming.getSimilarity(simhash1,simhash2);

        // 将相似度写入文件
        WriteFile.Write(args[2],ratio);
    }
}
