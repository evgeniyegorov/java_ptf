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

  public AddNewData  withMobile(String mobile) {
    this.mobile = mobile;
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

  public String getMobile() {
    return mobile;
  }

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

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
