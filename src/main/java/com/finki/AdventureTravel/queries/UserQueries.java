package com.finki.AdventureTravel.queries;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("classpath:user-queries.properties")
public class UserQueries {

    @Value("${add-user}")
    private String addUser;

    @Value("${select-all}")
    private String selectAll;

    @Value("${select-by-username}")
    private String selectByUsername;
}
