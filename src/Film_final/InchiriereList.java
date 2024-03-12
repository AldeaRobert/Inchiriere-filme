/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import java.util.ArrayList;


public class InchiriereList {
    private ArrayList <FilmInc> list;
    InchiriereList()
    {
        this.list=new ArrayList <FilmInc>();
    }
    void addFilmInc(FilmInc tr)
    {
        this.list.add(tr);
    }
    ArrayList<FilmInc> getFilmeInchiriateList()
    {
        return list;
    }
    void returnareFilm(int z,boolean tip)
    {
     if(tip)
     {
     list.remove(z);}
     else
     {
        list.remove(z);}
    }
}
