package ru.staq.pft.addressbook.model;

public class AddNewData {
  private int  id = Integer.MAX_VALUE;;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String mobile;
  private String email;
  private String byear;
  private String group;
  private String home;
  private String work;
  private String allPhones;




  public int getId() { return id; }

  public AddNewData  withId(int id) {
    this.id = id;
    return this;
  }

  public AddNewData  withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public AddNewData  withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public AddNewData  withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public AddNewData  withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public AddNewData withCompany(String company) {
    this.company = company;
    return this;
  }

  public AddNewData  withAddress(String address) {
    this.address = address;
    return this;
  }

  public AddNewData  withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public AddNewData  withHomePhone(String home) {
    this.home = home;
    return this;
  }

  public AddNewData  withWorkPhone(String work) {
    this.work = work;
    return this;
  }

  public AddNewData  withEmail(String email) {
    this.email = email;
    return this;
  }

  public AddNewData  withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public AddNewData  withGroup(String group) {
    this.group = group;
    return this;
  }

  public AddNewData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobile;
  }

  public String getHomePhone() {
    return home;
  }

  public String getWorkPhone() { return work; }

  public String getAllPhones() { return allPhones; }

  public String getEmail() {
    return email;
  }

  public String getByear() {
    return byear;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "AddNewData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddNewData that = (AddNewData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
