package LT_Buoi4;

public class Person {
    private String idenCode;
    private String name;
    private byte age;
    private String addr;
    private String phoneNumber;

    public Person() {
    }

    public Person(String idenCode, String name, byte age, String phoneNumber, String addr) {
        this.idenCode = idenCode;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.addr = addr;
    }

    public String getIdenCode() {
        return idenCode;
    }

    public void setIdenCode(String idenCode) {
        this.idenCode = idenCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idenCode='" + idenCode + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void Display(){
        System.out.printf("%-10s %-5s %-5s %-5s %n", "idenCode", "name", "age", "addr", "phoneNumber");
        System.out.printf("%-10s %-5s %-5s %-5s %n", this.idenCode, this.name, this.age, this.addr, this.phoneNumber);
    }
}
