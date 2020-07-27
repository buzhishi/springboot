package cn.jihui.ssm.web.controller;

import cn.jihui.ssm.domain.Employee;
import cn.jihui.ssm.service.IRankService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class RankController {
    @Autowired
    private IRankService rankService;
    // http://localhost:8090/addScore
    @PutMapping(value = "/addScore")
    @ResponseBody
    public String addSorce(String uid,Integer score){
        rankService.addScore(uid,score);
        return "SUCCESS";
    }

    // http://localhost:8090/incrScore
    @PostMapping(value = "/incrScore")
    @ResponseBody
    public String increScore(String uid,Integer score){
        rankService.incrScore(uid,score);
        return "SUCCESS";
    }





    @PostMapping(value = "/sortScore")
    @ResponseBody
    public String sortScore(){
        Map map = rankService.sortScore();
        return JSON.toJSONString(map);
    }

}
