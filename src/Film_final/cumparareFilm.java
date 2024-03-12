/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.*;


public class cumparareFilm extends JFrame {
    JToggleButton ok;int tmp;
    JToggleButton exit=new JToggleButton("Exit");
    JLabel T1,T2,T3,T4,T5,T6;
    int x;    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    FilmInc a;
    JRadioButton r1=new JRadioButton("Caseta");JRadioButton r2=new JRadioButton("DVD");
     cumparareFilm(Film film,int id,ListAbonat list,InchiriereList lista)
    {
        setLayout(null);
        JPanel panel = new JPanel(null);
        ButtonGroup bg = new ButtonGroup();
        setTitle("Cumparare film");
        T1 = new JLabel("Nume: "+film.getNume());
        T2 = new JLabel("Gen: "+film.getGen());
        T3 = new JLabel("An: "+film.getAn());
        ok = new JToggleButton("Ok");
        add(T1);add(T2);add(T3);
        if(film.getCasete()>0)
        {bg.add(r1);
        T5 = new JLabel("Numar casete: "+film.getCasete());add(T5);
        T5.setBounds(10,60,150,20);
        r1.setBounds(20,90,80,25);
        add(r1);}
        if(film.getDvd()>0)
        {bg.add(r2);
        T6 = new JLabel("Numar DVD: "+film.getDvd());add(T6);
        T6.setBounds(120,60,150,20);
        r2.setBounds(120,90,80,25);
        add(r2);}
        T1.setBounds(10,10,150,20);
        T2.setBounds(10,35,150,20);
        T3.setBounds(130,35,150,20);
        ok.setBounds(40,120,80,25);
        exit.setBounds(0,0,80,25);
        panel.setBounds(160,120,80,25);
        panel.add(exit);add(panel);
        setVisible(true);
        setResizable(false);
        setSize(285,200);
        for(Abonat abonat:list.getAbonatList())
             if(abonat.getNrUnic()==id)
                 {Abonat tmpabon=abonat;tmp=tmpabon.getInchiriat();break;}
        add(ok);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        if(film.getCasete()<1 && film.getDvd()<1)
        {T4=new JLabel("Nu exista stock pentru acest film");
            T4.setBounds(10,85,150,20);}
            
            
        exit.addActionListener((ActionEvent e2) -> {     
       if(exit.isSelected())
           dispose();
            });
        ok.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if(ok.isSelected())
                if(tmp<5)
                {if(r1.isSelected())
                {
                    film.cumparCaseta();
                    LocalDateTime ldt = LocalDateTime.now().plusDays(7);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
          String ldt2= formmat1.format(ldt);
                    for(Abonat abonat:list.getAbonatList())
                    {if(abonat.getNrUnic()==id)
                    {a= new FilmInc(abonat,film,true,ldt2);
                    lista.addFilmInc(a);
                    abonat.inchiriat();
                    
                    break;}}
                    dispose();
                    JOptionPane.showOptionDialog(null, new Object[] {"Aveti de platit 7 ron.\nFilmul cumparat: "+film.getNume()+"\nFilmul trebuie returnat pana pe data de: "+ldt2},
                            "E-inchiriere filme/Platire", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    
                }
                if(r2.isSelected())
                {
                    LocalDateTime ldt = LocalDateTime.now().plusDays(7);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
          String ldt2= formmat1.format(ldt);
                    film.cumparDVD();
                    for(Abonat abonat:list.getAbonatList())
                        if(abonat.getNrUnic()==id)
                        {a= new FilmInc(abonat,film,false,ldt2);
                        lista.addFilmInc(a);
                        abonat.inchiriat();
                        
                        break;}
                    dispose();
                    
                    JOptionPane.showOptionDialog(null, new Object[] {"Aveti de platit 14 ron.\nFilmul cumparat: "+film.getNume()+"\nFilmul trebuie returnat pana pe data de: "+ldt2},
                            "E-inchiriere filme/Platire", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    exit.setEnabled(true);
                }
                }
                else {JOptionPane.showOptionDialog(null, new Object[] {"Ati inchiriat prea multe filme. Pentru a inchiria alte filme, returnari unul dintre filmele inchiriate anterior."},
                            "E-inchiriere filme/Eroare", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        }
        }
    });
        ok.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e2) {
            if(ok.isSelected())
            {
                dispose();
            }
        }

        });
        
        
}
}
