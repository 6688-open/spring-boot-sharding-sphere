package com.oujiong.config;

import com.oujiong.common.HashSharding;
import com.oujiong.common.Paddings;
import com.oujiong.common.Segments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description: 分表算法
 *
 * @author wj
 * @date 2019/10/10 下午4:18
 */
public final class WaybillTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    /*@Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<Long> shardingValue) {
        for (String each : tableNames) {
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }*/
    private static final Logger LOG = LogManager.getLogger(WaybillTableShardingAlgorithm.class);
    private int startWith = 1;
    private int paddedSize = 3;
    private String split = "_";

    @Override
    public String doSharding(Collection<String> targetNames, PreciseShardingValue<Long> shardingValue) {//shardingValue 表名 字段名 值
        //补全是17位运单ID
        final String paddedValue = Paddings.padding(Segments.CYD_PADDED_SIZE,String.valueOf(shardingValue.getValue()));
        LOG.error("shardingValue:{},targetNames:{}", paddedValue, Arrays.toString(targetNames.toArray()));
        return HashSharding.sharding(targetNames,paddedValue ,startWith,paddedSize,split);
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