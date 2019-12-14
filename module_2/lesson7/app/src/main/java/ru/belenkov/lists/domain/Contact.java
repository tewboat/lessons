package ru.belenkov.lists.domain;

public class Contact {
    public int avatarUrl;
    public String contactName;
    public String contactPhoneNumber;

    public Contact(String contactName, String contactPhoneNumber, int avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.contactName = contactName;
        this.contactPhoneNumber = contactPhoneNumber;
    }
}
