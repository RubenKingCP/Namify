package org.example.model;

public class CuratorAccount extends Account{
    public CuratorAccount() {
        // Get from database
    }

    public void issueStrike(String userId) {
        // Issue a strike to the user with the given userId
    }

    public void checkStrikes(String userId) {
        // Check the number of strikes for the user with the given userId
    }

    public void removeStrike(String userId) {
        // Remove a strike from the user with the given userId
    }

    public void banUser(String userId) {
        // Ban the user with the given userId
    }

    public void unbanUser(String userId) {
        // Unban the user with the given userId
    }

    public void approveUserToArtist(String userId) {
        // Approve the user with the given userId to become an artist
    }
}
