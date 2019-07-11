package com.wallychen.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description
 * @author ChenYZ
 * @version  1.0.0
 * @create 2019/7/5
 */
public class PasswordUtils {



    public static String encode(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    public static void main(String[] args) {
        String password = "123456";
        String encode = encode(password);
        System.out.println(encode);
    }

}
