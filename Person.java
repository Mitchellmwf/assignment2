public abstract class Person {
    
    private String name;
    private String id;
    private String email;

    public Person(String name, String id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else {
            System.out.println("Invalid name.");
        }
    }

    public void setID(String id) {
        if(id != null && id.matches("\\d{1,6}")){
            this.id = id;
        }
        else {
            System.out.println("Invalid ID.");
        }
    }

    public void setEmail(String email) {
        if(email != null && email.contains("@") && !email.trim().isEmpty()){
            this.email = email;
        }
        else {
            System.out.println("Invalid email.");
        }
    }

    public String getName() {
    return name;
}

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public abstract String getDetails();
}
