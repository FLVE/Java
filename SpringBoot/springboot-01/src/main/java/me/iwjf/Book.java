package me.iwjf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class Book {
    //@Value("${Book.id}")
    private Long id;
    //@Value("${Book.name}")
    private String name;
    //@Value("${Book.author}")
    private String author;
}
