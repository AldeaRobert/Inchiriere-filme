
package Film_final;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class film_main {
    
    public static void main(String[] args) throws Exception{
        FilmList tl= new FilmList();Abonat tmpabon = null;
        ListAbonat list= new ListAbonat();
        InchiriereList inc=new InchiriereList();
        String userDirectory = new File("").getAbsolutePath();
        BufferedReader buf=new BufferedReader(new FileReader(userDirectory+"//filme"));
        while(true){
            String tmp=buf.readLine();
            if(tmp==null)
            {
                    break;
            }
            else
            {
                    String[] tbl =tmp.split(",");
                    Film tr=new Film(tbl[0],Integer.parseInt(tbl[1]),tbl[2],Integer.parseInt(tbl[3]),Integer.parseInt(tbl[4]),Float.parseFloat(tbl[5]));
                    tl.addFilm(tr);
            }
        }
        buf=new BufferedReader(new FileReader(userDirectory+"//abonati"));
        while(true){
         
            String tmp=buf.readLine();
            if(tmp==null)
            {
                break;
            }
            else
            {
                String[] tbl =tmp.split(",");
                Abonat tr=new Abonat(tbl[0],tbl[1],tbl[2],tbl[3],tbl[4],tbl[5],Integer.parseInt(tbl[6]),Integer.parseInt(tbl[7]));
                list.addAbonat(tr);
            }
        }
        buf=new BufferedReader(new FileReader(userDirectory+"//filmeinchiriate"));
        while(true){
            String tmp=buf.readLine();
            if(tmp==null)
            {
                    break;
            }
            else
            {
                    String[] tbl =tmp.split(",");
                    FilmInc tr=new FilmInc(Integer.parseInt(tbl[0]),tbl[1],tbl[2],list,tl,tbl[3],Integer.parseInt(tbl[4]));
                    inc.addFilmInc(tr);
            }
        }
        Admin admin;
        File userList = new File(userDirectory+"//files//listaUtilizatori.txt");
        Casier casier = new Casier(list,inc);
        Scanner sc = new Scanner(userList);
        String scan1=null,scan2=null,scan3=null;
        int vex=0,x=0;
        while(x==0){
            String[] op1 = new String[] {"1","2","3"};
            int rasp1 = JOptionPane.showOptionDialog(null, "Ce doriti sa faceti?\n1 - Conectare\n2 - Vizionare lista filme\n3 - Inchidere program", "E-Inchiriere filme/Meniu principal",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op1, op1[0]);
            if(rasp1>=0){
                switch(rasp1+1){
                    case 1:{
                        while(vex==0)
                            {JTextField username = new JTextField();
                            JPasswordField password = new JPasswordField();
                            int result = JOptionPane.showOptionDialog(null, new Object[] {"Introduceti contul","Username",username,"Password",password},
                            "E-inchiriere filme/Conectare", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                            if(result == JOptionPane.OK_OPTION){
                                sc = new Scanner(userList);
                                while (sc.hasNext()){
                                    scan1=sc.next();
                                    scan2=sc.next();
                                    scan3=sc.next();
                                    if(username.getText().matches(scan1) && password.getText().matches(scan2)){
                                        vex=1;
                                        break;}
                                }sc.close();
                                if(vex==0){
                                    JOptionPane.showOptionDialog(null, new Object[] {"Datele introduse sunt invalide",},
                                    "E-inchiriere filme/Conectare nereusita", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                                }
                            }
                            else
                                {JOptionPane.showOptionDialog(null, new Object[] {"Operatie anulata."},
                                "E-inchiriere filme/Conectare anulata", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                                vex=2;break;
                            }
                        }if(vex==1){
                            switch(Integer.parseInt(scan3)){
                                case 1:{
                                    JOptionPane.showOptionDialog(null, new Object[] {"Bine ati revenit",},
                                    "E-inchiriere filme/Conectare casier reusita", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                                    
                                    casier.casier();
                                    break;
                                    }
                                case 2:{
                                    JOptionPane.showOptionDialog(null, new Object[] {"Bine ati revenit",},
                                    "E-inchiriere filme/Conectare admin reusita", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                                    
                                    admin=new Admin(tl);
                                    admin.admin();
                                    break;
                                    }
                            }
                        }
                        vex=0;break;
                    }
                    case 2:{
                        JTextField id=new JTextField();
                        
                        int k=2;
                        int j=JOptionPane.showOptionDialog(null, new Object[] {"Introduceti ID personal","ID",id},
                            "E-inchiriere filme/Abonat", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                        
                        if(j==JOptionPane.OK_OPTION)
                            if(!id.getText().isEmpty())
                            {k=0;
                                for(Abonat abonat:list.getAbonatList())
                                    {
                                        if(abonat.getNrUnic()==(Integer.parseInt(id.getText())))
                                            {tmpabon=abonat;k=1;
                                            
                                            break;
                                            }
                                    }}
                        
                        int id3=0;
                        if(tmpabon!=null)
                        {id3=tmpabon.getInchiriat();}
                        
                        if(k==1)
                        {int z=1;
                            while(z==1)
                        {
                            String[] op2 = new String[] {"Vizionare lista cu toate filmele","Vizionare lista filme disponibile","Inchidere"};
            int rasp2 = JOptionPane.showOptionDialog(null, "Ce doriti sa faceti?\n", "E-Inchiriere filme/Abonat/Afisare filme",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op2, op2[0]);
                            
                            if(rasp2==0)
                            {new afisare_filme(tl,id3,Integer.parseInt(id.getText()),list,inc);}
                            else if(rasp2==1)
                            {
                                new afisare_filme2(tl,id3,Integer.parseInt(id.getText()),list,inc);
                            }
                            else if(rasp2==2)
                              z=0;  
                            else
                                break;
                            
                             
                        }
                        }
                        else if(k==0)
                            JOptionPane.showOptionDialog(null, new Object[] {"ID-ul introdus nu reprezinta un abonat.",},
                                    "E-inchiriere filme/Conectare nereusita", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);

                        break;
                    }
                    case 3:{
                    x=1;
                    break;
                    }
                }
            }else{x=1;}
        
        }
        String fisier = null;
        
        try{
            File fold=new File(userDirectory+"//filme");
            fold.delete();
            FileWriter myWriter =new FileWriter(userDirectory+"//filme");
        for(Film film:tl.getFilmList())
        { 
            myWriter.write(film.getNume()+","+film.getAn()+","+film.getGen()+","+film.getCasete()+","+film.getDvd()+","+film.getPret()+"\n");
        }
        buf.close();
        myWriter.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        try{
            File fold=new File(userDirectory+"//abonati");
            fold.delete();
            FileWriter myWriter =new FileWriter(userDirectory+"//abonati");
        for(Abonat abonat:list.getAbonatList())
        { 
            
            myWriter.write(abonat.getNume()+","+abonat.getPrenume()+","+abonat.getSerie()+","+abonat.getNumar()+","+abonat.getTelefon()+","+abonat.getExpired()+","+abonat.getNrUnic()+","+abonat.getInchiriat()+"\n");
        }
        buf.close();
        myWriter.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        try{
            File fold=new File(userDirectory+"//filmeinchiriate");
            fold.delete();
            FileWriter myWriter =new FileWriter(userDirectory+"//filmeinchiriate");
        for(FilmInc film:inc.getFilmeInchiriateList())
        { 
            
            myWriter.write(film.codUnic+","+film.nume+","+film.tip2+","+film.data+","+film.inchiriere+"\n");
        }
        buf.close();
        myWriter.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

