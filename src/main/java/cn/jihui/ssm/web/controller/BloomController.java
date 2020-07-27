package cn.jihui.ssm.web.controller;

import cn.jihui.ssm.bloom.BloomFilterService;
import cn.jihui.ssm.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BloomController {
    @Autowired
    private BloomFilterService bloomFilterService;
    @Autowired
    private RedisService redisService;




    // http://localhost:8090/bloom/exist/1
    @GetMapping(value = "/bloom/exist/{id}")
    @ResponseBody
    public boolean sortScore(@PathVariable("id") Integer id){
        return bloomFilterService.numIsExist(id);
    }

    // http://localhost:8090/bloom/bloomFilterAdd?id=
    @RequestMapping(value = "/bloom/bloomFilterAdd")
    @ResponseBody
    public boolean bloomFilterAdd(int id){
        return redisService.bloomFilterAdd(id);
    }


    // http://localhost:8090/bloom/bloomFilterExists?id=
    @GetMapping(value = "/bloom/bloomFilterExists")
    @ResponseBody
    public boolean bloomFilterExists(int id){
        return redisService.bloomFilterExists(id);
    }

}
