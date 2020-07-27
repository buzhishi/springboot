package cn.jihui.ssm.service.impl;

import cn.jihui.ssm.util.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SecKillService {
    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  SECKILLSTARTFLAG  0_1595250000   0_开始日期时间
     *  SECACCESS   允许进入第一层的人数
     *  SECCOUNT 一共多少件商品
     *  FILTER_NAME 判断人是否已经购买了商品  存入的人员UID
     *  BOOK_NAME 已经被抢购的商品数量
     */
    public final static String SECKILLSTARTFLAG = "skuId_start_";
    public final static String SECACCESS = "skuId_access_";
    public final static String SECCOUNT = "skuId_count_";
    public final static String FILTER_NAME = "skuId_bloomFilter_";
    public final static String BOOK_NAME = "book_name_";

    /**
     * 流量拦截层
     * 秒杀是否开始
     *
     * @param uid
     * @param skuId
     * @return
     */
    public String secKill(int uid, int skuId) {
        String flag = (String) redisService.get(SECKILLSTARTFLAG + skuId);
        if (StringUtils.isBlank(flag)) {
            return "还未开始";
        }
        if (flag.contains("_")) {
            Integer isStart = Integer.parseInt(flag.split("_")[0]);
            Integer startTime = Integer.parseInt(flag.split("_")[1]);
            if (isStart == 0) {
                if (startTime > System.currentTimeMillis() / 1000) {
                    return "还未开始";
                } else {
                    redisService.set(SECKILLSTARTFLAG + skuId, "1"+startTime);
                }
            }
        }
        // 流量拦截
        String skuIdAccessName = SECACCESS + skuId;
        String accessNumStr  = (String)redisService.get(skuIdAccessName);
        Integer accessNum = 0;
        if(accessNumStr!=null){
            accessNum = Integer.valueOf((String)redisService.get(skuIdAccessName));
        }
        String skuIdCountName = SECCOUNT + skuId;
        Integer countNum = Integer.valueOf((String) redisService.get(skuIdCountName));
        if(countNum*1.2 < accessNum){
            return "抢购已经结束，欢迎下次参与";
        }else{
            // 增加允许通过的人数
            redisService.incr(skuIdAccessName);
        }
        /**
         * 信息校验
         */
        if(redisService.bloomFilterExists(FILTER_NAME,uid)){
            return "请勿重复购买商品";
        }else {
            redisService.bloomFilterAdd(FILTER_NAME,uid);
        }
        Boolean isSuccess = redisService.getAndIncrLua(BOOK_NAME + skuId);
        if(isSuccess){
            return "恭喜你抢购成功！！";
        }
        return "抢购已经结束，欢迎下次参与";
    }


}
