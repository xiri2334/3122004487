package paper.ComputeUtils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class SimHash {

    public static String getHash(String str) {
        try {
            // 使用MD5算法来计算字符串的哈希值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // 将输入字符串转换为字节数组，计算其哈希值并转换为二进制字符串
            return new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
        } catch (Exception e) {
            // 抛出运行时异常，提示转换哈希失败
            throw new RuntimeException("转换超时", e);
        }
    }


    public static String getSimHash(String str) {


        // 初始化特征向量数组，长度为128位，表示SimHash的每一位
        int[] v = new int[128];

        // 提取关键词，使用HanLP库
        List<String> keywordList = HanLP.extractKeyword(str, str.length()); // 提取所有关键词
        int size = keywordList.size();
        int i = 0; // 循环计数器

        // 遍历每个关键词，计算其哈希值，并根据权重调整特征向量
        for (String keyword : keywordList) {
            // 获取关键词的哈希值
            StringBuilder keywordHash = new StringBuilder(getHash(keyword));

                // 如果哈希值长度小于128位，在低位补0
            int k = 128 - keywordHash.length();
            if (keywordHash.length() < 128) {
                for (int j = 0; j < k; j++) {
                    keywordHash.append("0");
                }
            }

            // 加权并更新特征向量
            for (int j = 0; j < v.length; j++) {
                // 判断当前位是否为1，并根据权重更新特征向量
                if (keywordHash.charAt(j) == '1') {
                    // 权重从高到低分为10级
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }

        // 降维操作，将特征向量转换为SimHash值
        StringBuilder simHash = new StringBuilder();
        for (int k : v) {
            simHash.append(k <= 0 ? "0" : "1");
        }
        return simHash.toString();
    }
}
