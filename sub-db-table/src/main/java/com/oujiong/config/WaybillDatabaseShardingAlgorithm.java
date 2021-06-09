package com.oujiong.config;

import com.oujiong.common.Paddings;
import com.oujiong.common.Segments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * 分库算法
 * @ProjectName: spring-boot-sharding-sphere
 * @Author: wangJia
 * @Date: 2021-06-09-11-25
 */
public class WaybillDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    private static final Logger LOG = LogManager.getLogger(WaybillDatabaseShardingAlgorithm.class);
    private int startWith = 0;
    private int paddedSize = 4;
    private String split = "_";

    public String doSharding(Collection<String> targetNames, PreciseShardingValue<Long> shardingValue) {
        //补全是17位运单ID
        final String paddedValue = Paddings.padding(Segments.CYD_PADDED_SIZE, String.valueOf(shardingValue.getValue()));
        LOG.error("shardingValue:{},targetNames:{}", paddedValue, Arrays.toString(targetNames.toArray()));
        //提取数据库ID 截取运单（2,4）位  维护的dbId
        final int dbIndex = Segments.extractDbSegment(paddedValue);
        final int suffixIndex = startWith + dbIndex;
        String suffix = Paddings.padding(split, paddedSize, suffixIndex);
        LOG.error("分库----------->运单号:{}, 数据库suffix:{}", shardingValue.getValue(), suffix);
        for (String each : targetNames) {
            if (each.endsWith(suffix)) {
                return each;
            }
        }
        throw new UnsupportedOperationException(String.format("根据运单ID路由数据库出错-[%s]", shardingValue.getValue()));
    }


    public int getStartWith() {
        return startWith;
    }

    public void setStartWith(int startWith) {
        this.startWith = startWith;
    }

    public int getPaddedSize() {
        return paddedSize;
    }

    public void setPaddedSize(int paddedSize) {
        this.paddedSize = paddedSize;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }
}
