package cn.jihui.ssm.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClusterLockTimeJob {
    private final static String lockKey = "setNx";
    private final static String lockVal = "success";
    private final static long expire = 20000;



    @Autowired
    private RedisTemplate redisTemplate;

//    @Scheduled(cron = "0/5 * * * * *")  //  秒分时天月年
//    public void lock(){
//        System.out.println("定时器成功实现："+System.currentTimeMillis());
//    }



//    @Scheduled(cron = "0/10 * * * * *")  //  秒分时天月年
//    public void lock(){
//        try {
//            Boolean flag = redisTemplate.opsForValue().setIfAbsent(lockKey, lockVal);
//            if(!flag){
//                System.out.println("----------获取锁失败啦");
//            }else{
//                redisTemplate.opsForValue().set(lockKey,lockVal,expire);
//                System.out.println("----------创建锁过期时间");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("创建失败"+e.getMessage());
//        }finally {
//            redisTemplate.delete(lockKey);
//        }
//    }


    /**
     * 实现分布式锁
     *
     *
     */
    public void setLock(){
        try {
            redisTemplate.execute(new   RedisCallback() {
              @Override
              public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                  return redisConnection.set(lockKey.getBytes(),lockVal.getBytes(), Expiration.seconds(expire), RedisStringCommands.SetOption.ifAbsent());
              }
          });
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("创建失败"+e.getMessage());
        }
    }
}
