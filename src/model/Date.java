package model;

import java.time.LocalDate;

public class Date {
  private Integer id;
  private String type;
  private LocalDate date;
  private Session session;
  
  public Date(Integer id, String type, LocalDate date, model.Session session) {
    this.id = id;
    this.type = type;
    this.date = date;
    this.session = session;
  }
  
  @Override
  public String toString() {
    return "Date{" +
            "id=" + id +
            ", type='" + type + '\'' +
            ", date=" + date +
            ", session=" + session +
            '}';
  }
}