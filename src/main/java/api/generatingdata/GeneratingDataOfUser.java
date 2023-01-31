package api.generatingdata;

import com.github.javafaker.Faker;
import api.models.User;

public class GeneratingDataOfUser {
    public static User createNewUser() {
        return User.builder()
                .email(Faker.instance().internet().emailAddress())
                .password(Faker.instance().internet().password())
                .name(Faker.instance().name().nameWithMiddle())
                .build();
    }
}