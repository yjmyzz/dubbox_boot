package space.isnow.dubbox_boot.consumer_dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import space.isnow.dubbox_boot.api.UserService;

/**
 * Created by lxq on 15-11-16.
 */
@Component
public class Client {

    @Reference
    private UserService userService;

    public String hello() {
        System.out.println("==========" +  (userService == null) + userService.findAll().size());
        return ""+userService.findAll().size()+"";
    }
}
