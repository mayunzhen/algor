package com.example.algorithm;

import com.sun.deploy.util.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AlgorithmApplication {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Mxy");
        list.add("StringUtils");
        list.add("join");
        String join = StringUtils.join(list, "-");//传入String类型的List集合，使用"-"号拼接
        System.out.println(join);

        SpringApplication.run(AlgorithmApplication.class, args);
    }

}

