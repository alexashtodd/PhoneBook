import java.util.ArrayList;

public class ContactList {
    ArrayList<Contact> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }
    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }
    public void setAllContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    public void addContact(int index, Contact contact){
        contacts.add(index, contact);
    }
    public Contact removeContact(int index){
        return contacts.remove(index);
    }
    public boolean removeContact(Contact contact){
        return contacts.remove(contact);
    }
    public Contact getContact(int index){
        return contacts.get(index);
    }

    public void setContactName(int index, String[] name) {
        Contact temp = contacts.get(index);
        temp.setName(name);
        contacts.set(index, temp);
    }
    public void setContactNumber(int index, int number) {
        Contact temp = contacts.get(index);
        temp.setNumber(number);
        contacts.set(index, temp);
    }
    public void setContactNotes(int index, ArrayList<String> notes) {
        Contact temp = contacts.get(index);
        temp.setNotes(notes);
        contacts.set(index, temp);
    }
    public void setContactEmail(int index, String email) {
        Contact temp = contacts.get(index);
        temp.setEmail(email);
        contacts.set(index, temp);
    }
    public void setContactAddress(int index, String address) {
        Contact temp = contacts.get(index);
        temp.setAddress(address);
        contacts.set(index, temp);
    }

    public void addContactNote(int index, String note) {
        Contact temp = contacts.get(index);
        temp.addNote(note);
        contacts.set(index, temp);
    }
    public void addContactNote(int index, String note, int notesIndex) {
        Contact temp = contacts.get(index);
        temp.addNote(notesIndex, note);
        contacts.set(index, temp);
    }
    public String removeContactNote(int index, int notesIndex) {
        Contact temp = contacts.get(index);
        String i = temp.removeNote(notesIndex);
        contacts.set(index, temp);
        return i;
    }
    public void clearContactNotes(int index) {
        Contact temp = contacts.get(index);
        temp.clearNotes();
        contacts.set(index, temp);
    }

    public ArrayList<Contact> searchByName(String name) {
        ArrayList<Contact> filteredList = new ArrayList<>();
        for (Contact i : contacts) {
            if (i.getName()[0].equals(name) || i.getName()[1].equals(name)) {
                filteredList.add(i);
            }
        }
        return filteredList;
    }
    public void sortContacts() {
        Contact temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < contacts.size()-1; i++) {
                if (contacts.get(i).compareTo(contacts.get(i + 1)) > 0) {
                    temp = contacts.get(i);
                    contacts.set(i, contacts.get(i + 1));
                    contacts.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }
}