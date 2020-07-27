package cn.jihui.ssm.service.impl;

import cn.jihui.ssm.service.IRankService;
import cn.jihui.ssm.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RankServiceImpl implements IRankService {
    @Autowired
    private RedisService redisService;

    @Override
    public void addScore(String uid, Integer score) {
//        redisService.addScore(uid, score);
    }

    @Override
    public void incrScore(String uid, Integer score) {
//        redisService.incrScore(uid, score);
    }

    @Override
    public Map sortScore() {
        return null;
    }
}
