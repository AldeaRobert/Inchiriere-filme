/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;


public class Film implements Comparable<Film>{
    private int an=0;
    private String nume=null;
    private String gen=null;
    private int casete=0;
    private int dvd=0;
    private float pretTotal=0;
    Film(String nume2,int an,String gen,int casete,int dvd,float pret){
    this.an = an;
    nume=nume2;
    this.gen=gen;
    this.casete=casete;
    this.dvd=dvd;
    pretTotal=pret;
    }
    int getAn()
    {
        return an;
    }
    String getNume()
    {
        return nume;
    }
    String getGen()
    {
        return gen;
    }
    int getCasete()
    {
        return casete;
    }
    int getDvd()
    {
        return dvd;
    }
    void setAn(int an)
    {
        this.an=an;
    }
    void setNume(String nume)
    {
        this.nume=nume;
    }
    void setGen(String gen)
    {
        this.gen=gen;
    }
    void setDVD(int dvd)
    {
        this.dvd=dvd;
    }
    void setCasete(int casete)
    {
        this.casete=casete;
    }
    void cumparCaseta()
    {if(casete>=1)
        casete=casete-1;
    
    }
    void cumparDVD()
    {if(dvd>=1)
        dvd=dvd-1;
    
    }
    float getPret()
    {
        return pretTotal;
    }
    void returnCaseta()
    {
        casete++;
    }
    void returnDVD()
    {
        dvd++;
    }
    public int compareTo(Film compareFilm) {
	
		int compareAn = ((Film) compareFilm).getAn(); 
		
		//ascending order
		return this.getAn() - compareAn;
		
		//descending order
		//return compareQuantity - this.quantity;
		
	}
    public int compare(Film o1, Film o2) {
        return o1.getNume().compareTo(o2.getNume());
    }
}

