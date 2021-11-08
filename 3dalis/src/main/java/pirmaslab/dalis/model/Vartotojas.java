package pirmaslab.dalis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vartotojai")
public class Vartotojas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String vardas;
    private String pavarde;
    private String telNr;
    private String email;
    private String adresas;
    private String slaptazodis;

    public Vartotojas() {}

    public Vartotojas(String vardas, String pavarde, String telNr, String email, String adresas, String slaptazodis){
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.telNr = telNr;
        this.email = email;
        this.adresas = adresas;
        this.slaptazodis = slaptazodis;
    }
    @Override
    public String toString() {
        return "Vartotojas [userId=" + id + ", vardas=" + vardas + " pavarde=" + pavarde + " telNr=" + telNr + " email=" + email + " adresas=" + adresas + " slaptazodis=" + slaptazodis + "]";
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }


    public int getId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }
}
