import java.util.Date;

public class Reservation {
    public String id;
    private int idUser;
    private int idPointCharge;
    private Date dateStart;
    private Date dateEnd;
    private Boolean accepted;

    public Reservation(){}

    public Reservation(int idUser,int idPointCharge,Date dateStart,Date dateEnd){

        this.idUser = idUser;
        this.idPointCharge = idPointCharge;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

}
