package hbase;

import com.google.common.base.Preconditions;

public class TestHbase {
    public static void main(String[] args) {
        int aa = 1 / 0;
        long flowRun = 1586596627206L;
        long invert = invertLong(flowRun);
        System.out.println("invertLong(flowRun) = " + invert);
        byte[] byteArr = toBytes(invert);
        System.out.println("start ..........");
        System.out.println(byteToHex(byteArr));
        System.out.println("end ..........");
        for (Byte b : byteArr) {
            System.out.println(b);
        }
    }

    /**
     * byte数组转hex
     * @param bytes
     * @return
     */
    public static String byteToHex(byte[] bytes){
        String strHex = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < bytes.length; n++) {
            strHex = Integer.toHexString(bytes[n] & 0xFF);
            sb.append((strHex.length() == 1) ? "0" + strHex : strHex); // 每个字节由两个字符表示，位数不够，高位补0
        }
        return sb.toString().trim();
    }

    public static long invertLong(long key) {
        return Long.MAX_VALUE - key;
    }

    public static byte[] toBytes(long val) {
        byte[] b = new byte[8];

        for (int i = 7; i > 0; --i) {
            b[i] = (byte) ((int) val);
            val >>>= 8;
        }

        b[0] = (byte) ((int) val);
        return b;
    }

    private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHex(byte[] b) {
        return toHex(b, 0, b.length);
    }
    public static String toHex(byte[] b, int offset, int length) {
        int numChars = length * 2;
        char[] ch = new char[numChars];

        for(int i = 0; i < numChars; i += 2) {
            byte d = b[offset + i / 2];
            ch[i] = HEX_CHARS[d >> 4 & 15];
            ch[i + 1] = HEX_CHARS[d & 15];
        }

        return new String(ch);
    }
}
