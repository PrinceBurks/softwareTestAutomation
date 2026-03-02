package com.contactservice;

import java.util.HashMap;
import java.util.Map;

/**
 * THe ContactService manages a collection of Contact objects.
 * It provides functionality to add, delete, and update thr contacts.
 */
public class ContactService {
    private Map<String, Contact> contacts;

    /**
     * Constructor for ContactService, this will initializes empty contact storage
     */
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    /**
     * Add a new contact to the service
     * 
     * @param contact 
     * @throws IllegalArgumentException if the contact with same ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cant be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by ID
     * 
     * @param contactId 
     * @throws IllegalArgumentException if contact ID does not exist
     */
    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact
     * 
     * @param contactId 
     * @param firstName 
     * @throws IllegalArgumentException if contact ID does not exist
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact
     * 
     * @param contactId 
     * @param lastName 
     * @throws IllegalArgumentException if contact ID deos not exist
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact
     * 
     * @param contactId 
     * @param phone 
     * @throws IllegalArgumentException if contact ID does not exist
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact
     * 
     * @param contactId 
     * @param address 
     * @throws IllegalArgumentException if contact ID does not exist
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by ID
     * 
     * @param contactId 
     * @return 
     * @throws IllegalArgumentException if contact ID does not exist
     */
    public Contact getContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID was not found");
        }
        return contacts.get(contactId);
    }
}
