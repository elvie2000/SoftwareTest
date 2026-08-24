import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists or is null");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        
        Contact contact = contacts.get(contactId);
        
        if (firstName != null) { contact.setFirstName(firstName); }
        if (lastName != null) { contact.setLastName(lastName); }
        if (phone != null) { contact.setPhone(phone); }
        if (address != null) { contact.setAddress(address); }
    }
    
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}