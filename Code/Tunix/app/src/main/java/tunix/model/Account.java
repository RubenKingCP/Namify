package tunix.model;

import tunix.enums.AccountStatus;

public abstract class Account {
    private int id;
    private String username;
    private String email;
    private AccountStatus accountStatus;

    public Account(int id, String username, String email, AccountStatus accountStatus) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accountStatus = accountStatus;
    }
}