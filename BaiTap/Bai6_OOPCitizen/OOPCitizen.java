package Bai6_OOPCitizen;

public class OOPCitizen {
    //Field first
    private String id;
    private String name;
    private Short year;
    private String gender;
    private String nation;
    //Constructor
    
    public String getId() {
        return id;
    }
    public OOPCitizen(String id, String name, Short year, String gender, String nation) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nation = nation;
    }

    // Getter setter
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Short getYear() {
        return year;
    }
    public void setYear(Short year) {
        this.year = year;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
}
