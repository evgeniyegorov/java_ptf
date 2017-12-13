package ru.staq.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("addnew")
@Entity
@Table(name = "addressbook")
public class AddNewData {

  @XStreamOmitField
  @Id
  @Column (name = "id")
  private int  id = Integer.MAX_VALUE;

  @Expose
  @Column (name = "firstname")
  private String firstname;

  @Expose
  @Column (name = "middlename")
  private String middlename;

  @Expose
  @Column (name = "lastname")
  private String lastname;

  @Expose
  @Column (name = "nickname")
  private String nickname;

  @Expose
  @Column (name = "company")
  private String company;

  @Expose
  @Column (name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column (name = "mobile")
  @Type(type = "text")
  private String mobile;

  @Expose
  @Column (name = "email")
  @Type(type = "text")
  private String email;

  @Expose
  @Column (name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column (name = "email3")
  @Type(type = "text")
  private String email3;

  @Expose
  @Column (name = "byear")
  private String byear;

  @Expose
  @Transient
  private String group;

  @Expose
  @Column (name = "home")
  @Type(type = "text")
  private String home;

  @Expose
  @Column (name = "work")
  @Type(type = "text")
  private String work;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String allMails;

  @Expose
  @Transient
  private String photo;

 /* @Expose
  @Column (name = "photo")
  @Type(type = "text")
  private String photo; */


  public AddNewData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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

  public AddNewData  withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public AddNewData  withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public AddNewData withAllMails(String allMails) {
    this.allMails = allMails;
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


  public int getId() { return id; }

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

  public String getMobilePhone() { return mobile; }

  public String getHomePhone() {
    return home;
  }

  public String getWorkPhone() { return work; }

  public String getAllPhones() { return allPhones; }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllMails() { return allMails; }

  public String getByear() {
    return byear;
  }

  public String getGroup() {
    return group;
  }

//  public File getPhoto() { return new File(photo); }

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
