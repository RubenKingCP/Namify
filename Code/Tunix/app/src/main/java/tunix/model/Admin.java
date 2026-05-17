package tunix.model;
import tunix.enums.AccountStatus;

public class Admin extends Account {
    public Admin(int id, String username, String email, AccountStatus accountStatus) {
        super(id, username, email, accountStatus);
    }
}
