package ru.staq.pft.addressbook.model;

public class AddNewData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String mobile;
  private final String email;
  private final String byear;
  private String group;

  public AddNewData(String firstname, String middlename, String lastname, String nickname, String company, String address, String mobile, String email, String byear, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
    this.byear = byear;
    this.group = group;
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
            "firstname='" + firstname + '\'' +
            ", middlename='" + middlename + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddNewData that = (AddNewData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return middlename != null ? middlename.equals(that.middlename) : that.middlename == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
    return result;
  }
}
