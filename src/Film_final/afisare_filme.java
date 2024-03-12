/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

/**
 *
 * @author alexandru
 */
public class afisare_filme extends JFrame {
    afisare_filme(FilmList tl,int id,int id2,ListAbonat list,InchiriereList inc)
    {
        JToggleButton close = new JToggleButton("Inchidere");
        String[] genuri={"Comedie","Actiune","Mister","Groaza","Romantic","Istoric","Politist","Thriller","SF","Dramatic"};
        JButton b=new JButton("Detalii");
        JButton b4=new JButton("Sortare in functie de nume");
        JButton b5=new JButton("Sortare in functie de an");
        JButton b6=new JButton("Sortare in functie de gen");
        JButton b2=new JButton("Cumpara");
        final JLabel label12 = new JLabel();
        final JLabel label1 = new JLabel();
        final JLabel label2 = new JLabel();
        final JLabel label3 = new JLabel();
        final JLabel label4 = new JLabel();
        final JLabel label5 = new JLabel();
        final DefaultListModel<String> l1 = new DefaultListModel<>();
        final DefaultListModel<String> l2 = new DefaultListModel<>();
        Collections.sort(tl.getFilmList(), new Comparator<Film>(){

  public int compare(Film o1, Film o2)
  {
     return o1.getNume().compareTo(o2.getNume());
  }
                            });
                        for(Film film:tl.getFilmList()){
                            l1.addElement(film.getNume());
                            }
                        for(int i=0;i<genuri.length;i++)
                            l2.addElement(genuri[i]);
                        final JList<String> list1 = new JList<>(l1);  
                        final JList<String> list2 = new JList<>(l2);  
                        JPanel panel2 = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel2.add(scrollPane);
                        JPanel panel = new JPanel(null);
                        panel.add(close);
                        setSize(500,420);
                        setTitle("E-Inchiriere filme/Abonat/Cumparare film");
                        panel2.setBounds(30,10,145,145);
                        b.setBounds(180,60,95,25);
                        b2.setBounds(180,95,95,25);
                        label12.setBounds(300,10,120,20);
                        label1.setBounds(300,30,200,20);
                        label2.setBounds(300,50,120,20);
                        label3.setBounds(300,70,120,20);
                        label4.setBounds(300,90,120,20);
                        label5.setBounds(300,110,120,20);
                        b4.setBounds(30,180,200,25);
                        b5.setBounds(30,210,200,25);
                        b6.setBounds(30,240,200,25);
                        list2.setBounds(320,160,60,180);
                        close.setBounds(45,300,100,25);
                        add(panel2);
                        panel.setBounds(1,1,500,420);
                        panel.add(b);
                        panel.add(b2);
                        panel.add(label12);
                        panel.add(label1);
                        panel.add(label2);
                        panel.add(label3);
                        panel.add(label4);
                        panel.add(label5);
                        panel.add(b4);
                        panel.add(b5);
                        panel.add(b6);
                        panel.add(list2);
                        panel.add(close);
                        add(panel);
                        setVisible(true);
                        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
                        b.addActionListener((ActionEvent e2) -> {
                            String data1 = "";
                            String data12 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Film tmp=null;
                                for(Film film:tl.getFilmList())
                                {
                                    if(film.getNume()==list1.getSelectedValue())
                                    {tmp=film;break;}
                                }
                                data12 = " Detalii Film:";
                                data1 = " Nume = "+ list1.getSelectedValue();
                                data2 = " An = "+ tmp.getAn();
                                data3 = " Gen = "+ tmp.getGen();
                                data4 = " Nr Casete = " + tmp.getCasete();
                                data5 = " Nr DVD = "+ tmp.getDvd();  
                                label12.setText(data12);
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                            }
                            label12.setText(data12);
                            label1.setText(data1);
                            label2.setText(data2);
                            label3.setText(data3);
                            label4.setText(data4);
                            label5.setText(data5);
                        });
                        b2.addActionListener((ActionEvent e2) -> {
                            if (list1.getSelectedIndex() != -1) 
                                {
                                    Film tmp=null;
                                    for(Film film:tl.getFilmList())
                                    {
                                        if(film.getNume()==list1.getSelectedValue())
                                            if(id<5)
                                            {new cumparareFilm(film,id2,list,inc);
                                            
                                            break;
                                            }
                                            else JOptionPane.showOptionDialog(null, new Object[] {"Ati inchiriat prea multe filme! Pentru a putea inchiria alte filme, returnati unul dintre filmele inchiriate anterior.",},
                                    "E-inchiriere filme/Inchiriere filme", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                                    }
                                    
                                    }
                        
                        });
                        b4.addActionListener((ActionEvent e2) -> {
                            l1.clear();
                            Collections.sort(tl.getFilmList(), new Comparator<Film>(){

  public int compare(Film o1, Film o2)
  {
     return o1.getNume().compareTo(o2.getNume());
  }
                            });
                            for(Film film:tl.getFilmList())
                            {
                                l1.addElement(film.getNume());
                            }
                            });
                        b5.addActionListener((ActionEvent e3) -> {
                            l1.clear();
                            Collections.sort(tl.getFilmList(), new Comparator<Film>(){

  public int compare(Film o1, Film o2)
  {
     return o1.getAn() - (o2.getAn());
  }
                            });
                            
                            for(Film film:tl.getFilmList())
                            {
                                l1.addElement(film.getNume());
                            }
                            
                            
                        });
                        b6.addActionListener((ActionEvent e3) -> {
                            l1.clear();
                            if (list2.getSelectedIndex() != -1)
                                for(Film film:tl.getFilmList())
                                {if(film.getGen().equals(list2.getSelectedValue()))
                                {
                                    l1.addElement(film.getNume());
                                }
                                }
                            
                        });
             while(true)
          {if(close.isSelected())
              {
              break;}
          System.out.print("");
          }
         dispose();           
    }
    
}
class afisare_filme2 extends JFrame {
    afisare_filme2(FilmList tl,int id,int id2,ListAbonat list,InchiriereList inc)
    {String[] genuri={"Comedie","Actiune","Mister","Groaza","Romantic","Istoric","Politist","Thriller","SF","Dramatic"};
        JToggleButton close=new JToggleButton("Inchidere");
        JButton b=new JButton("Detalii");  
        JButton b2=new JButton("Cumpara");
                        JButton b4=new JButton("Sortare in functie de nume");
                            JButton b5=new JButton("Sortare in functie de an");
                            JButton b6=new JButton("Sortare in functie de gen");
        setLayout(null);
                        final JLabel label12 = new JLabel();
                            final JLabel label1 = new JLabel();
                        final JLabel label2 = new JLabel();
                        final JLabel label3 = new JLabel();
                        final JLabel label4 = new JLabel();
                        final JLabel label5 = new JLabel();
                            final DefaultListModel<String> l1 = new DefaultListModel<>();
                            final DefaultListModel<String> l2 = new DefaultListModel<>();
                            Collections.sort(tl.getFilmList(), new Comparator<Film>(){

  public int compare(Film o1, Film o2)
  {
     return o1.getNume().compareTo(o2.getNume());
  }
                            });
                        for(Film film:tl.getFilmList()){
                            if(film.getCasete()+film.getDvd()>0)
                            l1.addElement(film.getNume());
                            }
                        for(int i=0;i<genuri.length;i++)
                            l2.addElement(genuri[i]);
                        final JList<String> list1 = new JList<>(l1);  
                        final JList<String> list2 = new JList<>(l2);
                        JPanel panel2 = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel2.add(scrollPane);
                        JPanel panel = new JPanel(null);
                        panel.add(close);
                        setSize(500,420);
                        setTitle("E-Inchiriere filme/Abonat/Cumparare film");
                        panel2.setBounds(30,10,145,145);
                        b.setBounds(180,60,95,25);
                        b2.setBounds(180,95,95,25);
                        label12.setBounds(300,10,120,20);
                        label1.setBounds(300,30,200,20);
                        label2.setBounds(300,50,120,20);
                        label3.setBounds(300,70,120,20);
                        label4.setBounds(300,90,120,20);
                        label5.setBounds(300,110,120,20);
                        b4.setBounds(30,180,200,25);
                        b5.setBounds(30,210,200,25);
                        b6.setBounds(30,240,200,25);
                        list2.setBounds(320,160,60,180);
                        close.setBounds(45,300,100,25);
                        add(panel2);
                        panel.setBounds(1,1,500,420);
                        panel.add(b);
                        panel.add(b2);
                        panel.add(label12);
                        panel.add(label1);
                        panel.add(label2);
                        panel.add(label3);
                        panel.add(label4);
                        panel.add(label5);
                        panel.add(b4);
                        panel.add(b5);
                        panel.add(b6);
                        panel.add(list2);
                        panel.add(close);
                        add(panel);
                        setVisible(true);
                        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
                        b.addActionListener((ActionEvent e2) -> {
                            String data12 = "";
                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Film tmp=null;
                                for(Film film:tl.getFilmList())
                                {
                                    if(film.getNume()==list1.getSelectedValue())
                                    {tmp=film;break;}
                                }
                                data12 = "Detalii Film:";
                                data1="Nume = " + list1.getSelectedValue();
                                data2 = " An = "+ tmp.getAn();
                                data3 = " Gen = "+ tmp.getGen();
                                data4 = " Nr Casete = " + tmp.getCasete();
                                data5 = " Nr DVD = "+ tmp.getDvd();  
                                label12.setText(data12);
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                            }
                            label12.setText(data12);
                            label1.setText(data1);
                            label2.setText(data2);
                            label3.setText(data3);
                            label4.setText(data4);
                            label5.setText(data5);
                        });
                        
                        b2.addActionListener((ActionEvent e2) -> {
                            if (list1.getSelectedIndex() != -1) 
                                {
                                    Film tmp=null;
                                    for(Film film:tl.getFilmList())
                                    {
                                        if(film.getNume()==list1.getSelectedValue())
                                            if(id<5)
                                            {new cumparareFilm(film,id2,list,inc);
                                            
                                            break;
                                            }
                                            else JOptionPane.showOptionDialog(null, new Object[] {"Ati inchiriat prea multe filme! Pentru a putea inchiria alte filme, returnati unul dintre filmele inchiriate anterior.",},
                                    "E-inchiriere filme/Inchiriere filme", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                                    }
                                    
                                    }
                        
                        });
                        b4.addActionListener((ActionEvent e2) -> {
                            l1.clear();
                            Collections.sort(tl.getFilmList(), new Comparator<Film>(){

  public int compare(Film o1, Film o2)
  {
     return o1.getNume().compareTo(o2.getNume());
  }
                            });
                            for(Film film:tl.getFilmList())
                            {if(film.getCasete()+film.getDvd()>0)
                                l1.addElement(film.getNume());
                            }
                            });
                        b5.addActionListener((ActionEvent e3) -> {
                            l1.clear();
                            Collections.sort(tl.getFilmList(), new Comparator<Film>(){

  public int compare(Film o1, Film o2)
  {
     return o1.getAn() - (o2.getAn());
  }
                            });
                            
                            for(Film film:tl.getFilmList())
                            {if(film.getCasete()+film.getDvd()>0)
                                l1.addElement(film.getNume());
                            }
                            
                            
                        });
                        b6.addActionListener((ActionEvent e3) -> {
                            l1.clear();
                            if (list2.getSelectedIndex() != -1)
                                for(Film film:tl.getFilmList())
                                {if(film.getGen().equals(list2.getSelectedValue()))
                                {if(film.getCasete()+film.getDvd()>0)
                                    l1.addElement(film.getNume());
                                }
                                }
                            
                        });
             while(true)
          {if(close.isSelected())
              {close.remove(close);
              
              break;}
          System.out.print("");
          }
         dispose();           
    }
}