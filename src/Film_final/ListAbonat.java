/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import java.util.*;


public class ListAbonat {
    private ArrayList <Abonat> list;
    ListAbonat()
    {
        this.list=new ArrayList <Abonat>();
    }
    void addAbonat(Abonat tr)
    {
        this.list.add(tr);
    }
    ArrayList<Abonat> getAbonatList()
    {
        return list;
    }
    void deleteAbonat(Abonat tr,int i)
    {
        tr=null;
        
        list.remove(i);
    }
}
