package com.contactservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * 
 * unit tests for the Contact class.
 */
public class ContactTest {
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "Emma", "Sue", "1234567890", "179 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Emma", contact.getFirstName());
        assertEquals("Sue", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("179 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdValidation() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Emma", "Sue", "1234567890", "179 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Emma", "Sue", "1234567890", "179 Main St"));
    }

    @Test
    public void testFirstNameValidation() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", null, "Sue", "1234567890", "179 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "EmmaSueInvalid", "Sue", "1234567890", "179 Main St"));
    }

    @Test
    public void testLastNameValidation() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", null, "1234567890", "179 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", "SueInvalidLonger", "1234567890", "179 Main St"));
    }

    @Test
    public void testPhoneValidation() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", "Sue", null, "179 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", "Sue", "123456789", "179 Main St"));
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", "Sue", "123456789a", "179 Main St"));
    }

    @Test
    public void testAddressValidation() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", "Sue", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1", "Emma", "Sue", "1234567890",
                "123 Main Street Address Too Long"));
    }
}
