public class Employee {
    private int id;
    private String name;
    private String specialty;

    public Employee() {}

    public Employee(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public Employee(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
