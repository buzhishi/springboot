package cn.jihui.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class Tiger {
    private Animals cat;

    public Tiger() {
    }

    @Autowired
    public Tiger(Animals cat) {
        this.cat = cat;
    }


    public Animals getCat() {
        return cat;
    }

    public void setCat(Animals cat) {
        this.cat = cat;
    }
}
