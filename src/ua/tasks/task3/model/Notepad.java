package ua.tasks.task3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for keeping records
 *
 * @author Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Notepad {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
