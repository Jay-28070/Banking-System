package src;

public class User {
    private String name;
    private String surname;
    private int age;
    private String id;
    private String accountNumber;
    private String pin;

    public User(String name, String surname, int age, String id, String accountNumber, String pin) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getAccountNr() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountNr(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    } 

    @Override
    public String toString() {
        return "Account holder: " + getName() + getSurname();
    }
}
