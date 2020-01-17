package me.iwjf.demo1;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        //SpringApplication.run(Demo1Application.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Demo1Application.class);
        SpringApplication build = builder.build();
        build.setBannerMode(Banner.Mode.OFF);
        build.run(args);

    }

}
