package model;

import java.util.Objects;

public class Charity {
  private final String code;
  private String name;
  private String contact;
  private String address;
  private String city;
  private String zipCode;
  private String country;
  
  public Charity(String code, String name, String contact, String address, String city, String zipCode, String country) {
    this.code = code;
    this.name = name;
    this.contact = contact;
    this.address = address;
    this.city = city;
    this.zipCode = zipCode;
    this.country = country;
  }

  public  Charity(String code) {
    this.code = code;
  }
  
  public Charity(String code, String name) {
    this(code, name, null, null, null, null, null);
  }
  
  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getContact() {
    return contact;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCountry() {
    return country;
  }

  @Override
  public String toString() {
    return "Charity{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", contact='" + contact + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", country='" + country + '\'' +
            '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Charity charity = (Charity) o;
    return Objects.equals(code, charity.code);
  }
  
}
