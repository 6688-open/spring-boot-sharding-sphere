package com.oujiong.common;


/**
 * 规则片段提取工具类
 */
public class Segments {

    public static final int CYD_PADDED_SIZE = 17;
    public static final int SEGMENT_OFFSET = 0;
    public static final int SPLIT_OFFSET = 2;
    public static final int SEGMENT_END = 4;
    public static final int SEGMENT_SIZE = 2;

    /**
     * 从分片值中提取数据库ID
     * @param shardingValue 分片值(运单ID)
     * @return 数据库ID
     */
    public static int extractDbSegment(String shardingValue) {
        final String dbSegment = shardingValue.substring(SPLIT_OFFSET, SEGMENT_END);
        return Integer.parseInt(dbSegment);
    }

    /**
     * 从分片值中提取节点ID
     * @param shardingValue 分片值(运单ID)
     * @return 节点ID
     */
    public static int extractNodeSegment(String shardingValue) {
        final String nodeSegment = shardingValue.substring(SEGMENT_OFFSET, SPLIT_OFFSET);
        return Integer.parseInt(nodeSegment);
    }

    /**
     * 从分片值中提取规则片段(包含节点及数据库ID片段)
     * @param shardingValue
     * @return 规则片段(包含节点及数据库ID片段)
     */
    public static String extractSegment(String shardingValue) {
        return shardingValue.substring(SEGMENT_OFFSET, SEGMENT_END);
    }
}
