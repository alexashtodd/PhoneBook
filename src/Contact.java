import java.util.ArrayList;

public class Contact {
    private String[] name;
    private int number;
    private ArrayList<String> notes = new ArrayList<>();
    private String email = "";
    private String address = "";

    public Contact(String[] name, int num){
        if (verifyName(name)) {
            this.name = name;
        } else {
            this.name = new String[]{"",""};
        }
        number = num;
    }

    public Contact(String[] name, int num, ArrayList<String> notes, String email, String address){
        if (verifyName(name)) {
            this.name = name;
        } else {
            this.name = new String[]{"",""};
        }
        number = num;
        this.notes = notes;
        this.email = email;
        this.address = address;
    }

    public Contact(String[] name, int num, ArrayList<String> notes){
        if (verifyName(name)) {
            this.name = name;
        } else {
            this.name = new String[]{"",""};
        }
        number = num;
        this.notes = notes;
    }

    private boolean verifyName(String[] name){
        if (name.length != 2){
            return false;
        }
        if (name.equals(new String[]{"",""})) {
            return false;
        }
        else {return true;}
    }

    public String[] getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public ArrayList<String> getNotes(){
        return notes;
    }
    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return address;
    }
    public void setName(String[] name){
        if (verifyName(name)) {
            this.name = name;
        }
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setNotes(ArrayList<String> notes){
        this.notes = notes;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void addNote(String newNote){
        notes.add(newNote);
    }
    public void addNote(int index, String newNote){
        notes.add(index, newNote);
    }
    public String removeNote(int index){
        return notes.remove(index);
    }
    public void clearNotes(){
        setNotes(new ArrayList<>());
    }
    public int compareTo(Contact other) {
        if (!name[0].equals(other.getName()[0])) {
            return name[1].compareTo(other.getName()[1]);
        } else {
            return name[0].compareTo(other.getName()[0]);
        }
    }

    @Override public String toString() {
        return "Contact(Name=[" + name[0] + "," + name[1] + "],Number=" + number + ",Notes=" + notes + ",E-Mail=" + email + ",Address=" + address + ")";
    }
}