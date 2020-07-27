package cn.jihui.ssm.service;

import java.util.Map;

public interface IRankService {
    void addScore(String uid, Integer score);

    void incrScore(String uid, Integer score);

    Map sortScore();
}
