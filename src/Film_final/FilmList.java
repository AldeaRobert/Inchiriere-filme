/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import java.util.*;


public class FilmList {
    private ArrayList <Film> list;
    FilmList()
    {
        this.list=new ArrayList <Film>();
    }
    void addFilm(Film tr)
    {
        this.list.add(tr);
    }
    void stergeFilm(int index)
    {
        list.remove(index);
    }
    public ArrayList<Film> getFilmList()
    {
        return list;
    }
    public Film getFilm(int index)
    {
        return list.get(index);
    }
}
