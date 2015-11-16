package space.isnow.dubbox_boot.provider_dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import space.isnow.dubbox_boot.api.UserService;
import space.isnow.dubbox_boot.api.model.User;
import space.isnow.dubbox_boot.provider_dubbo.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxq on 15-11-16.
 */
@Service(protocol = { "rest", "dubbo" })
@Path("user")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.APPLICATION_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.APPLICATION_XML_UTF_8})
public class UserServiceImpl implements UserService{

    //"application/json; charset=UTF-8"
    //"text/xml; charset=UTF-8"
    @GET
    @Path("findAll")
    @Override
    public List<User> findAll() {

        User user1 = new User();
        user1.setId(001);
        user1.setName("用户１");

        User user2 = new User();
        user2.setId(002);
        user2.setName("用户2");

        User user3 = new User();
        user3.setId(003);
        user3.setName("用户3");

        User user4 = new User();
        user4.setId(004);
        user4.setName("用户4");

        User user5 = new User();
        user5.setId(005);
        user5.setName("用户5");

        User user6 = new User();
        user6.setId(006);
        user6.setName("用户6");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        return list;
    }
}
