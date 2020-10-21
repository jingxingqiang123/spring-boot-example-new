package client.client;


import common.IUserService;
import common.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value="/v1")
@Slf4j
public class TestController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/getUser")
    public User getUser(String name) {
        return userService.getUserByName(name);
    }

}
