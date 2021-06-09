package com.oujiong.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

public class HashSharding {

    private static final Logger LOG = LogManager.getLogger(HashSharding.class);
    /**
     * 通用Hash分片算法(sharding-sphere)
     * @param targetNames
     * @param shardingValue
     * @param startWith
     * @param paddedSize
     * @param split
     * @return
     */
    public static String sharding(Collection<String> targetNames, String shardingValue, int startWith, int paddedSize, String split){
        final long hash = Math.abs(MurmurHash.hash(shardingValue));
        final int targetSize = targetNames.size();
        final long suffixIndex = startWith + (hash % targetSize);
        LOG.error("startWith:{},paddedSize:{},split:{},shardingValue:{},hashValue:{},targetSize:{}",
                startWith,paddedSize,split,shardingValue,hash,targetSize);
        String suffix = Paddings.padding(split, paddedSize, (int)suffixIndex);
        LOG.error("分表-----------》运单号：{}, 数据库:{}, 表suffix:{}", shardingValue, shardingValue.substring(2,4), suffix);
        for (String each : targetNames) {
            if (each.endsWith(suffix)) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }
}
