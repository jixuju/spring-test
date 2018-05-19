package com.superwind.conf;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by jiangxj on 2018/4/2.
 */
@Configuration
public class BeanConfig {
    @Autowired
    private ApplicationContext ctx;

    @Bean
    public TBScheduleManagerFactory initTBScheduleManagerFactory() {
        // 初始化调度工厂
        TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();

        Properties p = new Properties();
        p.put("zkConnectString", "192.168.31.98:2181");
        p.put("rootPath", "/jiangxj/test");
        p.put("zkSessionTimeout", "60000");
        p.put("userName", "admin");
        p.put("password", "password");
        p.put("isCheckParentPath", "true");
        scheduleManagerFactory.setApplicationContext(ctx);

        Map<String, String> map = new HashMap<String, String>((Map) p);
        try {
            scheduleManagerFactory.init(p);
            scheduleManagerFactory.setZkConfig(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleManagerFactory;
    }
}
