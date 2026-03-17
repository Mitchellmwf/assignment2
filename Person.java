import java.util.ArrayList;
public abstract class Person {
    
    //Private field of Strings name, id, email
    private String name;
    private String id;
    private String email;
    private static ArrayList<String> usedIDs = new ArrayList<>();

    //constructor assigning strings name, id, email 
    public Person(String name, String id, String email){
        id = id.toUpperCase();
        //validate name, id, and email inputs and throw exceptions if invalid
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name.");
        } else {
            this.name = name;
        }
        if (id == null || !id.matches("\\D-\\d{4}")) {
            throw new IllegalArgumentException("Invalid ID - Needs to match S-1234.");
        } 
        else if (usedIDs.contains(id)) {
            throw new IllegalArgumentException("ID already in use.");
        } 
        else {
            this.id = id;
            usedIDs.add(id);
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$") || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid email.");
        } else {
            this.email = email;
        }
    }

    //setter for name that validate if empty and spaces and will send invalid
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else {
            System.out.println("Invalid name.");
        }
    }

    //setter for ID that validate if empty and 6 nums and will send invalid
    public void setId(String id) {
        id = id.toUpperCase();
        if(id != null && id.matches("\\D-\\d{4}")){
            usedIDs.remove(this.id);
            this.id = id;
            usedIDs.add(id);
        }
        else {
            System.out.println("Invalid ID - Needs to be (S-1234).");
        }
    }

    //setter for email that validate if empty and spaces and needs to contain @ if not will send invalid
    public void setEmail(String email) {
        email = email.trim().toLowerCase();
        if(email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$") && !email.trim().isEmpty()){
            this.email = email;
        }
        else {
            System.out.println("Invalid email.");
        }
    }

    //getters return Name value
    public String getName() {
    return name;
}
    //getters return ID value
    public String getId() {
        return id;
    }

    //getters return Email value
    public String getEmail() {
        return email;
    }

    //return detail info about strings 
    public abstract String getDetails();
}
