package space.isnow.dubbox_boot.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import space.isnow.dubbox_boot.consumer_dubbo.Application;
import space.isnow.dubbox_boot.consumer_dubbo.controller.Client;

/**
 * Created by lxq on 15-11-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class Test {

    @Autowired
    private Client client;

    @org.junit.Test
    public void test() {
        System.out.println("==========" + client.hello() );
    }
}
