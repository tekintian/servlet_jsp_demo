package cn.tekin.myshopping.service;

import cn.tekin.myshopping.domain.Users;
import cn.tekin.myshopping.utils.SqlHelper;

import java.util.ArrayList;

//这是专门处理业务逻辑的
//处理和users表相关的业务逻辑
public class UsersService {

    //验证用户是否合法，合法则返回该用户的其他信息
    public boolean checkUser(Users user) {

        //到数据库去验证
        String sql = "select * from users where name=? and pwd=?";
        String paras[] = {user.getName() + "", user.getPwd()};
        ArrayList al = new SqlHelper().executeQuery(sql, paras);
        if (al.size() == 0) {
            return false;
        }
        else {
            Object[] objects = (Object[]) al.get(0);
            //把对象数据封装到User对象

            user.setName((String) objects[1]);//在用户登陆后同时还需要取出该用户的其他信息,故封装到一个对象
            user.setEmail((String) objects[3]);
            user.setGrade(Integer.parseInt(objects[5].toString()));

            return true;
        }


    }
}
