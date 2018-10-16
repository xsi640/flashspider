package com.suyang.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suyang.domain.User;
import com.suyang.exceptions.APIException;
import com.suyang.exceptions.APIExceptionType;
import com.suyang.repository.UserRepository;
import com.suyang.utils.CryptoUtils;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") final int id) {
        return userRepository.findById(id).orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<User> findAll(@RequestParam(name = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
        return userRepository.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(String loginName,
                       String loginPwd,
                       String realName,
                       int sex, Date birthday,
                       String address) {
        User user = new User();
        user.setLoginName(loginName);
        user.setRealName(realName);
        user.setLastLoginIP("");
        user.setLastLoginTime(new Date());
        user.setLoginCount(0);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setAddress(address);
        String salt = CryptoUtils.getSalt();
        user.setLoginSalt(salt);
        user.setLoginPwd(CryptoUtils.getHash(loginPwd, salt));
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User modify(int id,
                       String loginPwd,
                       String realName,
                       int sex, Date birthday, String address) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            return null;

        user.setRealName(realName);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setAddress(address);
        if (!StringUtils.isEmpty(loginPwd)) {
            String salt = CryptoUtils.getSalt();
            user.setLoginSalt(salt);
            user.setLoginPwd(CryptoUtils.getHash(loginPwd, salt));
        }
        return userRepository.save(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable("id") int id) throws Exception {
        int result = 0;
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.getLoginName().equals("admin")) {
                throw new APIException(APIExceptionType.NoLimit);
            }
            userRepository.delete(user);
            result = 1;
        }
        return result;
    }

    @RequestMapping(value = "checkname")
    public boolean existsName(String loginName) {
        return userRepository.countByLoginName(loginName) > 0;
    }
}
