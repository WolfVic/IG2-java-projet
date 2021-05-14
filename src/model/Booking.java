package model;

import exception.model.booking.InvalidBookingException;
import util.Utils;

import java.time.LocalDate;

public class Booking {
  private Integer id;
  private String lastname;
  private String firstname;
  private Double amount;
  private Boolean isPaid;
  private String phone;
  private LocalDate birthdate;
  private String email;
  private LocalDate date;
  private Charity charity;
  private String charityCode;
  private Session session;
  private Integer sessionId;

  public Booking(Integer id, String lastname, String firstname, Double amount, Boolean isPaid, String phone, LocalDate birthdate, String email, LocalDate date, Charity charity, Session session) throws InvalidBookingException {
    setId(id);
    setLastname(lastname);
    setFirstname(firstname);
    setAmount(amount);
    setPaid(isPaid);
    setPhone(phone);
    setBirthdate(birthdate);
    setEmail(email);
    setDate(date);
    setCharity(charity);
    setSession(session);
    
    if (getCharityCode() == null) throw new InvalidBookingException("association");
  }
  
  public Booking(Integer id, String lastname, String firstname, Double amount, Boolean isPaid, String phone, LocalDate birthdate, String email, LocalDate date, String charityCode, Integer sessionId) throws InvalidBookingException {
    this(id, lastname, firstname, amount, isPaid, phone, birthdate, email, date, (Charity) null,  (Session) null);
    this.setCharityCode(charityCode);
    this.setSessionId(sessionId);
  }

  public Booking(String lastname, String firstname, Double amount, Boolean isPaid, String phone, LocalDate birthdate, String email, LocalDate date, Charity charity, Session session) throws InvalidBookingException {
    this(null, lastname, firstname, amount, isPaid, phone, birthdate, email, date, charity, session);
  }
  
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public void setLastname(String lastname) throws InvalidBookingException {
    if (lastname == null) throw new InvalidBookingException("nom");
    this.lastname = lastname;
  }
  
  public void setFirstname(String firstname) throws InvalidBookingException {
    if (firstname == null) throw new InvalidBookingException("prénom");
    this.firstname = firstname;
  }
  
  public void setAmount(Double amount) throws InvalidBookingException {
    if (amount == null || amount < 0) throw new InvalidBookingException("montant");
    this.amount = amount;
  }
  
  public void setPaid(Boolean paid) throws InvalidBookingException {
    if (paid == null) throw new InvalidBookingException("est payé");
    isPaid = paid;
  }
  
  public void setPhone(String phone) throws InvalidBookingException {
    if (phone == null || Utils.isPhoneValid(phone)) throw new InvalidBookingException("téléphone");
    this.phone = phone;
  }
  
  public void setBirthdate(LocalDate birthdate) throws InvalidBookingException {
    if (birthdate != null && birthdate.isAfter(LocalDate.now())) throw new InvalidBookingException("date de naissance");
    this.birthdate = birthdate;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setDate(LocalDate date) throws InvalidBookingException {
    if (date == null) throw new InvalidBookingException("date");
    this.date = date;
  }
  
  public void setCharity(Charity charity) throws InvalidBookingException {
    if (charity == null) throw new InvalidBookingException("association");
    this.charity = charity;
  }
  
  public void setCharityCode(String charityCode) {
    this.charityCode = charityCode;
  }
  
  public void setSession(Session session) {
    this.session = session;
  }
  
  public void setSessionId(Integer sessionId) {
    this.sessionId = sessionId;
  }
  
  public Integer getId() {
    return id;
  }
  
  public String getLastname() {
    return lastname;
  }
  
  public String getFirstname() {
    return firstname;
  }
  
  public Double getAmount() {
    return amount;
  }
  
  public Boolean isPaid() {
    return isPaid;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public LocalDate getBirthdate() {
    return birthdate;
  }
  
  public String getEmail() {
    return email;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public Charity getCharity() {
    return charity;
  }
  
  public String getCharityCode() {
    if (charity == null) {
      return charityCode;
    } else {
      return charity.getCode();
    }
  }
  
  public Session getSession() {
    return session;
  }
  
  public Integer getSessionId() {
    if (session == null) {
      return sessionId;
    } else {
      return session.getId();
    }
  }
  
  @Override
  public String toString() {
    return "Booking{" +
            "id=" + id +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", amount=" + amount +
            ", isPaid=" + isPaid +
            ", phone='" + phone + '\'' +
            ", birthdate=" + birthdate +
            ", email='" + email + '\'' +
            ", date=" + date +
            ", charity=" + charity +
            ", session=" + session +
            '}';
  }
  
  
}
