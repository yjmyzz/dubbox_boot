package space.isnow.boot_demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import space.isnow.boot_demo.api.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 使用rest协议通信
 * Created by lxq on 15-11-17.
 */
@Service
@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserServiceImpl implements UserService {

    @GET
    @Path("register")
    @Override
    public void registerUser() {
        System.out.println("使用rest方式实现provider");
    }
}
