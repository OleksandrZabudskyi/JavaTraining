package ua.tasks.task3.controller;

import ua.tasks.task3.model.Address;
import ua.tasks.task3.model.Contact;
import ua.tasks.task3.model.Group;
import ua.tasks.task3.model.Notepad;
import ua.tasks.task3.view.Constants;
import ua.tasks.task3.view.View;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Realizes the controller of the MVC pattern
 * Class handles input data and sending result to view
 *
 * @autor Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Controller {
    private Notepad notepad;
    private View view;


    public Controller(Notepad notepad, View view) {
        this.notepad = notepad;
        this.view = view;
    }

    /**
     * Executing user process
     */
    public void processUser() {
        UtilityController utilityController = new UtilityController(view);
        view.printCreateContact();
        addContact(utilityController.fetchInputData());
    }

    /**
     * Process of saving data in model and displaying result
     *
     * @param map maps of input data
     */
    public void addContact(Map<String, String> map) {
        notepad.addContact(createContact(map));
        getContact(notepad.getContacts().size() - 1);

    }

    /**
     * Get contact from notepad by contactID
     *
     * @param contactId index in list
     */
    public void getContact(int contactId) {
        view.printRecordsFromNotepad(notepad.getContacts().get(contactId).toString());
    }

    /**
     * Creating contact
     *
     * @param map
     * @return
     */
    private Contact createContact(Map<String, String> map) {
        Contact contact = new Contact();
        Address address = new Address();
        contact.setAddress(address);
        contact.setFirstName(map.get(Constants.FIRST_NAME));
        contact.setLastName(map.get(Constants.LAST_NAME));
        contact.setAdditionalName(map.get(Constants.ADDITION_NAME));
        contact.setNickName(map.get(Constants.NICKNAME));
        contact.setComment(map.get(Constants.COMMENT));

        switch (Group.valueOf(map.get(Constants.GROUP))) {
            case FAMILY:
                contact.setGroup(Group.FAMILY);
                break;
            case WORK:
                contact.setGroup(Group.WORK);
                break;
            case FRIENDS:
                contact.setGroup(Group.FRIENDS);
                break;
            case RELATIVES:
                contact.setGroup(Group.RELATIVES);
                break;
            default:
                contact.setGroup(Group.FRIENDS);
        }
        contact.setHomePhone(map.get(Constants.HOME_PHONE));
        contact.setMobilePhone(map.get(Constants.MOBILE_PHONE));
        contact.setAdditionalMobilePhone(map.get(Constants.ADDITIONAL_MOBILE_PHONE));
        contact.setEmail(map.get(Constants.EMAIL));
        contact.setSkype(map.get(Constants.SKYPE));
        contact.setCreateDate(LocalDateTime.now().toLocalDate());
        contact.setModificationDate(LocalDateTime.now().toLocalDate());
        address.setIndex(Integer.valueOf(map.get(Constants.INDEX)));
        address.setCity(map.get(Constants.CITY));
        address.setStreet(map.get(Constants.STREET));
        address.setHouseNumber(map.get(Constants.HOUSE_NUMBER));
        address.setApartmentNumber(Integer.valueOf(map.get(Constants.APARTMENT_NUMBER)));
        return contact;
    }
}
