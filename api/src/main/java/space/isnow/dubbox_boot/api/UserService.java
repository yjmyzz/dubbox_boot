package space.isnow.dubbox_boot.api;

import space.isnow.dubbox_boot.api.model.User;

import java.util.List;

/**
 * Created by lxq on 15-11-16.
 */
public interface UserService {

    public List<User> findAll();

}
