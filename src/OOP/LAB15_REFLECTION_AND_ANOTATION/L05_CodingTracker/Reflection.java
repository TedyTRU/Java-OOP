package OOP.LAB15_REFLECTION_AND_ANOTATION.L05_CodingTracker;

import java.io.Serializable;

public class Reflection implements Serializable {

    private static final String nickName = "Pinguin";
    public String name;
    protected String webAddress;
    String email;
    private int zip;

    public Reflection() {
        this.setName("Java");
        this.setWebAddress("oracle.com");
        this.setEmail("mail@oracle.com");
        this.setZip(1407);
    }

    private Reflection(String name, String webAddress, String email) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    protected Reflection(String name, String webAddress, String email, int zip) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    //private final String date = new Date().toString();

    @Author(name = "George", date = "23-01-2201")
    public final String getName() {
        return name;
    }

    @Author(name = "Peter", date = "03-07-2001")
    private void setName(String name) {
        this.name = name;
    }

    @Author(name = "Gosho", date = "23-01-2201")
    protected String getWebAddress() {
        return webAddress;
    }

    @Author(name = "Ivan", date = "23-01-2201")
    private void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Author(name = "Milka", date = "23-01-2201")
    public String getEmail() {
        return email;
    }

    @Author(name = "Ivanka", date = "23-01-2201")
    public void setEmail(String email) {
        this.email = email;
    }

    @Author(name = "Pepa", date = "23-01-2201")
    protected final int getZip() {
        return zip;
    }

    @Author(name = "Gergana", date = "23-01-2201")
    private void setZip(int zip) {
        this.zip = zip;
    }

    public String toString() {
        String result = "Name: " + getName() + "\n";
        result += "WebAddress: " + getWebAddress() + "\n";
        result += "email: " + getEmail() + "\n";
        result += "zip: " + getZip() + "\n";
        return result;
    }
}
