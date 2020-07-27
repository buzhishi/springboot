package cn.jihui.ssm.web.controller;

import cn.jihui.ssm.service.impl.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecKillController {
    @Autowired
    private SecKillService secKillService;


    // http://localhost:8090/redis/secKill?uid=1&skuId=1
    @RequestMapping("redis/secKill")
    public String secKill(int uid,int skuId){
        return secKillService.secKill(uid,skuId);
    }
}
