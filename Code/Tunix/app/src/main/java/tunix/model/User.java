package tunix.model;

import tunix.enums.AccountStatus;

public class User extends Account {

    private String displayName;
    private String profilePictureUrl;
    
    public User(int id, String username, String email, AccountStatus accountStatus) {
        super(id, username, email, accountStatus);
    }
    

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
