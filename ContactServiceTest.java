package com.contactservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * unit tests for the ContactService.
 */
public class ContactServiceTest {
    @Test
    public void testAddContactsAndGet() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Emma", "Sue", "1234567890", "179 Pond St");
        Contact contact2 = new Contact("2", "JOna", "Burks", "9876543210", "102 Oak Ave");

        service.addContact(contact1);
        service.addContact(contact2);

        assertSame(contact1, service.getContact("1"));
        assertSame(contact2, service.getContact("2"));
    }

    @Test
    public void testAddContactDuplicateId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Emma", "Sue", "1234567890", "179 Pond St");
        Contact duplicate = new Contact("1", "Jona", "Burks", "9876543210", "102 Oak Ave");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Emma", "Sue", "1234567890", "102 Main St");

        service.addContact(contact1);
        service.deleteContact("1");

        assertThrows(IllegalArgumentException.class, () -> service.getContact("1"));
    }

    @Test
    public void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Emma", "Sue", "1234567890", "102 Main St");

        service.addContact(contact1);
        service.updateFirstName("1", "Jona");
        service.updateLastName("1", "Burks");
        service.updatePhone("1", "5555555555");
        service.updateAddress("1", "789 Pine St");

        Contact updated = service.getContact("1");
        assertEquals("1", updated.getContactId());
        assertEquals("Jona", updated.getFirstName());
        assertEquals("Burks", updated.getLastName());
        assertEquals("5554445555", updated.getPhone());
        assertEquals("179 Pond St", updated.getAddress());
    }
}
