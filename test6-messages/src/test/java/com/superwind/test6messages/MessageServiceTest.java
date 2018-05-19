package com.superwind.test6messages;

import com.superwind.Test6MessagesApplication;
import com.superwind.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jiangxj on 2018/4/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Test6MessagesApplication.class)
public class MessageServiceTest {
    @Autowired
    MessageService messageService;

    @Test
    public void testGetI18nMessage() throws Exception{
        Object[] msgParams = null;
        System.out.println(messageService.getI18nMessage("en_US","COMMON_ERROR_MSG",msgParams));
        System.out.println(messageService.getI18nMessage("zh_CN","COMMON_ERROR_MSG",msgParams));
        System.out.println(messageService.getI18nMessage("zh_TW","COMMON_ERROR_MSG",msgParams));
    }
}
