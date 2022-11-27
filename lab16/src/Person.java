
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String name=null;
    private String surname=null;
    private String pib=null;
    private String nickname=null;
    private String email=null;


    private String sex=null;
    private Date bday=null;
    private String phone=null;
    private String city=null;
    private String address=null;
    private String memo=null;

    public Person(){}
    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setName(String _name){
        name=_name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String _surname){
        surname=_surname;
    }
    public String getPib() {
        return pib;
    }
    public void setPib(String pib) {
        this.pib = pib;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString(){
        if (memo==null) memo="-";
        return ("ПІБ: "+surname+" "+name+" "+pib+"\n"+
                "Псевдонім:"+nickname+"\n"+
                "Email:"+email+"\n"+
                "Стать:"+sex+"\n"+
                "Дата народження:"+bday+"\n"+
                "Місто:"+city+"\n"+
                "Адреса:"+address+"\n"+
                "Додаткова інформація:"+memo+"\n\n");
    }
}
