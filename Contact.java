package com.contactservice;

/**
 * Contact class represents a contact with ID, name, phone, and address.
 * All fields are required and have specific validation constraints.
 */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructor for Contact
     * 
     * @param contactId 
     * @param firstName 
     * @param lastName 
     * @param phone 
     * @param address 
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cant be null or empty");
        }
        if (contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cant be longer than 10 characters");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cant be null or empty");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cant be longer than 10 characters");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cant be null or empty");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cant be longer than 10 characters");
        }
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone number cant be null or empty");
        }
        if (phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cant be null or empty");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cant be longer than 30 characters");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * 
     * Get the contact ID
     * 
     * @return 
     * 
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Get the first name
     * 
     * @return firts name
     * 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("The First name cant be null or empty");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("the First name cant be longer than 10 characters");
        }
        this.firstName = firstName;
    }

    /**
     * Get the last name
     * 
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("The last name cant be null or empty");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("The last name cant be longer than 10 characters");
        }
        this.lastName = lastName;
    }

    /**
     * Get the phone number
     * 
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone numbr
     * 
     * @param phone 
     */
    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone number cant be null or empty");
        }
        if (phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.phone = phone;
    }

    /**
     * Get the addres
     * 
     * @return 
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address
     * 
     * @param address 
     */
    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cant be null or empty");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cant be longer than 30 characters");
        }
        this.address = address;
    }
}
