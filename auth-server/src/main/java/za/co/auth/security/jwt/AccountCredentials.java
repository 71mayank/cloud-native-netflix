package za.co.auth.security.jwt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCredentials {

    private String username;
    private String password;
}
