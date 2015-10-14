package oop.lab03.encapsulation;

public class AccountHolder {

    private String name;
    private String surname;
    private Integer userID;

    public AccountHolder(String name, String surname, Integer accountID) {
        this.name = name;
        this.surname = surname;
        this.userID = accountID;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Integer getUserID() {
        return this.userID;
    }

    public String toString() {
        // TODO: completare
        return "";
    }
}