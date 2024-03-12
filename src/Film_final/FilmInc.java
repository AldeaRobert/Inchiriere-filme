/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import javax.swing.JOptionPane;


public class FilmInc {
    Abonat a;int codUnic;int inchiriere=0;static int counter;
    Film b;String nume;boolean tip;
    String tip2;String data;
    FilmInc(Abonat a,Film b,boolean tip,String ldt2)
    {
    this.a=a;codUnic=this.a.getNrUnic();
    this.inchiriere=this.counter;this.counter=this.counter+1;
        this.b=b;nume=b.getNume();
        this.a=a;codUnic=a.getNrUnic();
        this.tip=tip;
        if(tip)
            tip2="true";
        else tip2="false";
        data=ldt2;
    }
    FilmInc(int cod,String nume,String tip,ListAbonat a,FilmList b,String data,int inchirieri)
    {
        codUnic=cod;this.nume=nume;this.tip2=tip;this.inchiriere=inchirieri;this.counter=inchirieri+1;
        if(tip2.equals("true"))
            this.tip=true;
        else this.tip=false;
        for(Abonat abonat:a.getAbonatList())
        {
            if(abonat.getNrUnic()==cod)
                this.a=abonat;
        }
        for(Film film:b.getFilmList())
        {
            if(film.getNume().equals(nume))
                this.b=film;
        }
        this.data=data;
    }
}
