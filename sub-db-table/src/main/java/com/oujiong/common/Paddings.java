package com.oujiong.common;

public class Paddings {


    /**
     * 填充
     * <pre>
     *    padding(4,12) -> "0012"
     * <pre/>
     * @param paddedSize 填充后长度(不包括前缀)
     * @param value 待填充数值
     * @return 填充后的后缀
     */
    public static String padding(int paddedSize, int value) {
        return padding(null, false, paddedSize, value);
    }

    /**
     * 填充
     * <pre>
     *    padding(4,12) -> "0012"
     * <pre/>
     * @param paddedSize 填充后长度(不包括前缀)
     * @param value 待填充数值
     * @return 填充后的后缀
     */
    public static String padding(int paddedSize, String value) {
        return padding(null, false, paddedSize, value);
    }

    /**
     * 填充
     * <pre>
     *    padding("_",4,12) -> "_0012"
     * <pre/>
     * @param prefix 前缀
     * @param paddedSize 填充后长度(不包括前缀)
     * @param value 待填充数值
     * @return 填充后的后缀
     */
    public static String padding(String prefix, int paddedSize, int value) {
        return padding(prefix, false, paddedSize, value);
    }

    /**
     * 后缀填充
     * <pre>
     *    padding("_",4,12) -> "_0012"
     * <pre/>
     * @param prefix 前缀
     * @param paddedSize 填充后长度(不包括前缀)
     * @param value 待填充数值
     * @return 填充后的后缀
     */
    public static String padding(String prefix, int paddedSize, String value) {
        return padding(prefix, false, paddedSize, value);
    }

    /**
     * 填充
     * <pre>
     *    padding("_",true,4,12) -> "_012"
     *    padding("_",false,4,12) -> "_0012"
     * <pre/>
     * @param prefix 前缀
     * @param includePrefixSize 填充后长度是否包含前缀长度
     * @param paddedSize 填充后长度
     * @param value 待填充数值
     * @return
     */
    public static String padding(String prefix, boolean includePrefixSize, int paddedSize, int value) {
       return padding(prefix, includePrefixSize, paddedSize, String.valueOf(value));
    }
    /**
     * 填充
     * <pre>
     *    padding("_",true,4,12) -> "_012"
     *    padding("_",false,4,12) -> "_0012"
     * <pre/>
     * @param prefix 前缀
     * @param includePrefixSize 填充后长度是否包含前缀长度
     * @param paddedSize 填充后长度
     * @param value 待填充数值
     * @return
     */
    public static String padding(String prefix, boolean includePrefixSize, int paddedSize, Long value) {
        return padding(prefix, includePrefixSize, paddedSize, String.valueOf(value));
    }

    /**
     * 填充
     * <pre>
     *    padding("_",true,4,12) -> "_012"
     *    padding("_",false,4,12) -> "_0012"
     * <pre/>
     * @param prefix 前缀
     * @param includePrefixSize 填充后长度是否包含前缀长度
     * @param paddedSize 填充后长度
     * @param value 待填充数值
     * @return
     */
    public static String padding(String prefix, boolean includePrefixSize, int paddedSize, String value) {
        if (paddedSize == 0) {
            return value;
        }
        int valueLen = String.valueOf(value).length();
        final StringBuilder builder = new StringBuilder();

        if (prefix != null) {
            builder.append(prefix);
            if (includePrefixSize) {
                valueLen += prefix.length();
            }
        }
        if (valueLen > paddedSize) {
            throw new IllegalArgumentException("value length [" + valueLen + "] >  paddedSize [" + paddedSize + "]");
        }
        for (int idx = paddedSize - valueLen; idx-- > 0; ) {
            builder.append("0");
        }
        return builder.toString() + value;
    }

}
