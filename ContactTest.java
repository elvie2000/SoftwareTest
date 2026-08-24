import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "First", "Last", "0123456789", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("First", contact.getFirstName());
        assertEquals("Last", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactCreationFailsWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "First", "Last", "0123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "First", "Last", "0123456789", "123 Main St"));
    }

    @Test
    void testContactCreationFailsWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "FirstNameTooLong", "Last", "0123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Last", "0123456789", "123 Main St"));
    }
    
    @Test
    void testContactCreationFailsWithInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "LastNameTooLong", "0123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", null, "0123456789", "123 Main St"));
    }

    @Test
    void testContactCreationFailsWithInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "Last", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "Last", "012345678901", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "Last", "abcde56789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "Last", null, "123 Main St"));
    }

    @Test
    void testContactCreationFailsWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "Last", "0123456789", "This address is definitely way too long to be accepted"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "First", "Last", "0123456789", null));
    }
    
    @Test
    void testSettersSuccess() {
        Contact contact = new Contact("12345", "First", "Last", "0123456789", "123 Main St");
        contact.setFirstName("NewFirst");
        contact.setLastName("NewLast");
        contact.setPhone("9876543210");
        contact.setAddress("456 New St");
        
        assertEquals("NewFirst", contact.getFirstName());
        assertEquals("NewLast", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 New St", contact.getAddress());
    }
}