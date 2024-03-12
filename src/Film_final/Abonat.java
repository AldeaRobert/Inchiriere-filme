/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;
import static java.lang.Math.pow;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Abonat {
    private String nume;
    private String prenume;
    private String expiredSTRING;
    private String serie;
    private String numar;
    private String telefon;
    private static int c=0;
    private int nrUnic;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private int nrInchirieri=0;
    Abonat(String nume,String prenume,String serie,String numar,String telefon,long abonament)
    {   
        this.nume=nume;
        this.prenume=prenume;
        this.serie=serie;
        this.numar=numar;
        this.telefon=telefon;
        nrUnic=c;
        c++;
        LocalDateTime ldt = LocalDateTime.now().plusMonths(abonament);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
          expiredSTRING= formmat1.format(ldt);
        
    }
    Abonat(String nume,String prenume,String serie,String numar,String telefon,String expired,int c,int nrInc)
    {   nrInchirieri=nrInc;
        this.nume=nume;
        this.prenume=prenume;
        this.serie=serie;
        this.numar=numar;
        this.telefon=telefon;
        nrUnic=c;
        expiredSTRING=expired;
        this.c=c+1;
    }
    String getNume()
    {
        return nume;
    }
    String getPrenume()
    {
        return prenume;
    }
    String getAllNume()
    {
        return nume+" "+prenume;
    }
    String getSerie()
    {
        return serie;
    }
    String getNumar()
    {
        return numar;
    }
    String getTelefon()
    {
        return telefon;
    }
    int getNrUnic()
    {
        return nrUnic;
    }
    String getExpired()
    {
        return expiredSTRING;
    }
    void setNume(String nume)
    {
        this.nume=nume;
    }
    void setPrenume(String n)
    {
        prenume=n;
    }
    void setSerie(String n)
    {
        serie=n;
    }
    void setNumar(String n)
    {
        numar=n;
    }
    void setTelefon(String n)
    {
        telefon=n;
    }
    void inchiriat()
    {
        nrInchirieri++;
    }
    int getInchiriat()
    {
        return nrInchirieri;
    }
    void returnat()
    {
        nrInchirieri--;
    }
    
}
