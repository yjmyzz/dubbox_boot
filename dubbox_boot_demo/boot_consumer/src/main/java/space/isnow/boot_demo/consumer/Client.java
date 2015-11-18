package space.isnow.boot_demo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.isnow.boot_demo.api.TestInterface;

/**
 * Created by lxq on 15-11-17.
 */
@RestController
public class Client {

    @Reference
    private TestInterface xmlService;


    @RequestMapping("/test")
    public void  mainInterfaceTest2(){
        xmlService.test();
        System.out.println("客户端调用返回结果");
    }

}
