package com.linera.Reservationmanagement.Model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Reservation")
public class Reservation {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPointCharge() {
        return idPointCharge;
    }

    public void setIdPointCharge(int idPointCharge) {
        this.idPointCharge = idPointCharge;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
    private int idUser;
    private int idPointCharge;
    private Date dateStart;
    private Date dateEnd;
    private Boolean accepted;

    public Reservation(int idUser,int idPointCharge,Date dateStart,Date dateEnd,Boolean accepted)
    {
        this.idUser = idUser;
        this.idPointCharge = idPointCharge;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.accepted = accepted;
    }
}