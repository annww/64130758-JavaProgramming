package Bai6_Citizen;

public class OOPCitizen {
    //Field first
    private String id;
    private String name;
    private String year;
    private String gender;
    private String nation;

    //Constructor
    
    public String getId() {
        return id;
    }
    public OOPCitizen(String id, String name, String year, String gender, String nation) {
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
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
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

    @Override
    public String toString() {
        return "OOPCitizen [id=" + id + ", name=" + name + ", year=" + year + ", gender=" + gender + ", nation="
                + nation + "]";
    }
    
}
