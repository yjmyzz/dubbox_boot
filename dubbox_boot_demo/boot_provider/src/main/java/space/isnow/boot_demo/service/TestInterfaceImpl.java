package space.isnow.boot_demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import space.isnow.boot_demo.api.TestInterface;

/**
 *
 * 使用dubbo协议方式通信
 * Created by lxq on 15-11-17.
 */
@Service(protocol = "dubbo")
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void test() {
        System.out.println("boot---服务实现");
    }
}
