import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContactSuccess() {
        Contact contact = new Contact("12345", "First", "Last", "0123456789", "123 Main St");
        service.addContact(contact);
        assertNotNull(service.getContact("12345"));
    }

    @Test
    void testAddDuplicateContactFails() {
        Contact contact1 = new Contact("12345", "First", "Last", "0123456789", "123 Main St");
        Contact contact2 = new Contact("12345", "New", "Name", "9876543210", "456 St");
        service.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void testDeleteContactSuccess() {
        Contact contact = new Contact("12345", "First", "Last", "0123456789", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("12345"));
    }

    @Test
    void testDeleteNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    void testUpdateContactSuccess() {
        Contact contact = new Contact("12345", "First", "Last", "0123456789", "123 Main St");
        service.addContact(contact);
        
        service.updateContact("12345", "NewFirst", "NewLast", "9876543210", "456 New St");
        
        assertEquals("NewFirst", service.getContact("12345").getFirstName());
        assertEquals("NewLast", service.getContact("12345").getLastName());
        assertEquals("9876543210", service.getContact("12345").getPhone());
        assertEquals("456 New St", service.getContact("12345").getAddress());
    }
    
    @Test
    void testUpdateNonExistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("99999", "NewFirst", null, null, null));
    }
}