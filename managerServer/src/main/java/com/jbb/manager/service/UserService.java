package com.jbb.manager.service;

import com.jbb.manager.entity.QMUser;
import com.jbb.manager.entity.dto.UserDTO;
import com.jbb.manager.repository.qrepository.QUserRepository;
import com.jbb.manager.util.DateUtil;
import com.jbb.manager.util.StringUtil;
import com.jbb.manager.util.TableResult;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName UserService
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-23 16:12
 **/
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private QUserRepository qUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = getUserRole(username);
        if (StringUtil.isEmpty(userDTO)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        String psw = userDTO.getPassword();
        String password = bCryptPasswordEncoder.encode(psw);
        userDTO.setPassword(password);//加密数据库中密码字段，会与加密后的用户输入密码做比较
        return userDTO;
    }

    public TableResult userList(TableResult result) {
        //查询条件
        HashMap<String, Object> queryMap = result.getQueryMap();

        JPAQuery<UserDTO> query = qUserRepository.userList();
        //用户表
        QMUser user = QMUser.mUser;
        //根据用户真实姓名模糊查询
        if (StringUtil.isNotEmpty(queryMap.get("queryName"))) {
            query.where(user.realName.like("%" + queryMap.get("queryName") + "%"));
        }
        if (StringUtil.isNotEmpty(queryMap.get("queryDate"))) {
            Date queryDate = DateUtil.getLocalTime(queryMap.get("queryDate").toString());
            //当前时间加一天 2018-07-10 00:00变为2018-07-11 00:00
            Timestamp timestamp = new Timestamp(queryDate.getTime() + 60 * 60 * 24 * 1000);
            query.where(user.loginTime.before(timestamp));
        }
        //分页  前台传来第一页为1
        query.offset((result.getCurrPage() - 1) * result.getCurrTotal()).limit(result.getCurrTotal());
        //查询结果集
        QueryResults<UserDTO> queryResults = query.fetchResults();
        //用户数据集合
        List<UserDTO> results = queryResults.getResults();
        //总记录数
        long total = queryResults.getTotal();
        //总页数
        Long totalPage = result.getTotalPage(total);
        result.setLists(results);
        result.setTotal(total);
        result.setCountPage(totalPage);
        return result;
    }

    private UserDTO getUserRole(String username) {
        QueryResults<UserDTO> userRole = qUserRepository.getUserRole(username);
        List<UserDTO> results = userRole.getResults();
        if (results.size() == 0) {
            return null;
        }
        List<String> roles = new LinkedList<>();
        for (UserDTO result : results) {
            roles.add(result.getRoleName());
        }
        UserDTO userDTO = results.get(0);
        userDTO.setRoles(roles);
        return userDTO;
    }
}
