package com;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

    @Bean
    CommandLineRunner runner(ChatClient.Builder builder) {
        return args -> {
            String reply = builder.build()
                    .prompt("讲个关于 Java 的笑话")
                    .call()
                    .content();
            System.out.println(reply);
        };
    }
}
