package paper.ComputeUtils;

public class Hamming {

    // 计算相似度
    public static double getSimilarity(String simHash1, String simHash2) {
        // 通过 simHash1 和 simHash2 获得它们的海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        return (100 - (double) (distance * 100) / 128);
    }

    // 计算海明距离
    public static int getHammingDistance(String simHash1, String simHash2) {
        int d = 0; // 初始海明距离置为0
        if (simHash1.length() != simHash2.length()) {
            // 两个simHash的长度不一致
            throw new IllegalArgumentException("两个simHash的长度不一致");
    } else {
            // 比较两者的字符是否相同
            for (int i = 0; i < simHash1.length(); i++) {
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    d++; // 不同则距离加1
                }
            }
        }
        System.out.println("海明距离：" + d); // 输出海明距离
        return d; // 返回计算出的海明距离
    }


}