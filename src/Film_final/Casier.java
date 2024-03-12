
package Film_final;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;  
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class Casier {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Scanner sc;int z=0;
    String scan1=null,scan2=null,scan3=null;
    ListAbonat list;
    InchiriereList lista;FilmInc tmp;
    public Casier(ListAbonat list,InchiriereList lista) throws FileNotFoundException {this.list=list;this.lista=lista;}
    public void casier() throws FileNotFoundException{
        int x=0;boolean y=true;
        while(x==0)
            {String[] op3 = new String[] {"1","2","3","4","5","6"};
            int rasp3 = JOptionPane.showOptionDialog(null, "Ce doriti sa faceti?\n1 - Afisare lista abonati\n2 - Adaugare abonat\n3 - Modificare abonat\n4 - Returnare Filme\n5 - Eliminare abonat\n6 - Deconectare", "E-Inchiriere filme/Meniu Casier",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op3, op3[0]);
            if(rasp3>=0){
                switch(rasp3+1){
                    case 1:{
                       
                        JFrame frame= new JFrame();  
                        final JLabel label1 = new JLabel();
                        final JLabel label2 = new JLabel();
                        final JLabel label3 = new JLabel();
                        final JLabel label4 = new JLabel();
                        final JLabel label5 = new JLabel();
                        JButton b=new JButton("Detalii");    
                        JToggleButton b3=new JToggleButton("Inchidere");  
                        b.setBounds(200,150,80,30); 
                        b3.setBounds(300,200,120,50);
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        final DefaultListModel<String> l2 = new DefaultListModel<>();
                        
  
                        for(Abonat abonat:list.getAbonatList()){
                            l1.addElement(abonat.getAllNume());
                        String d;
                            d=String.valueOf(abonat.getNrUnic());
                            l2.addElement(d);}
                        final JList<String> list1 = new JList<>(l1);  
                        JPanel panel = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        b.setBounds(100,180,100,25);
                        b3.setBounds(300,180,100,25);
                        panel.setBounds(30,10,150,145);
                        label1.setBounds(220,10,300,20);
                        label1.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        frame.add(b);frame.add(b3);
                        frame.setTitle("E-Inchiriere filme/Meniu Casier/Lista abonati");
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.setSize(500,270);  
                        frame.setLayout(null);
                        frame.setVisible(true); 
                        frame.setResizable(false);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
                        b.addActionListener((ActionEvent e) -> {
                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Abonat tmp=null;
                                for(Abonat abonat:list.getAbonatList())
                                {
                                    if(abonat.getAllNume().equals(list1.getSelectedValue())&&l2.elementAt(list1.getSelectedIndex()).equals(String.valueOf(abonat.getNrUnic())))
                                    {tmp=abonat;break;}
                                    
                                }
                                if(tmp!=null)  
                                    data1 = "Detalii Abonat:";
                                    data2 = "Nume = " + list1.getSelectedValue();
                                    data3 = "ID = "+ tmp.getNrUnic();
                                    data4 = "Numar Telefon = "+tmp.getTelefon();
                                    data5 = "Data expirarii abonamentului = "+tmp.getExpired();
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                            }
                            label1.setText(data1);
                            label2.setText(data2);
                            label3.setText(data3);
                            label4.setText(data4);
                            label5.setText(data5);
                        });
                        while(y)
          {if(b3.isSelected())
              {b3.remove(b3);
              
              break;}
          System.out.print("");
          }
          frame.dispose();
                        
                        break;
                        }
                    case 2:{
                        new Addition(list);
                        break;
                        }
                    case 3:{
                        
                        JFrame frame= new JFrame();  
                        final JLabel label1 = new JLabel();
                        final JLabel label2 = new JLabel();
                        final JLabel label3 = new JLabel();
                        final JLabel label4 = new JLabel();
                        final JLabel label5 = new JLabel();
                        JButton b=new JButton("Detalii"); 
                        JButton b2=new JButton("Modificare");
                        JToggleButton b3=new JToggleButton("Inchidere"); 
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        final DefaultListModel<String> l2 = new DefaultListModel<>();
                        for(Abonat abonat:list.getAbonatList()){
                            l1.addElement(abonat.getAllNume());
                        String d;
                            d=String.valueOf(abonat.getNrUnic());
                            l2.addElement(d);}
                        final JList<String> list1 = new JList<>(l1);  
                        JPanel panel = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        frame.setTitle("E-Inchiriere filme/Meniu Casier/Modificare abonati");
                        scrollPane.setBounds(30,10,150,145);
                        panel.setBounds(30,10,150,145);
                        b.setBounds(80,180,100,25);
                        b2.setBounds(200,180,100,25);
                        b3.setBounds(320,180,100,25);
                        label1.setBounds(220,10,300,20);
                        label1.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.setSize(500,270);  
                        frame.setLayout(null);
                        frame.setVisible(true); 
                        frame.setResizable(false);
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        frame.add(b);frame.add(b2);frame.add(b3);
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
                        b.addActionListener((ActionEvent e) -> {
                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Abonat tmp=null;
                                for(Abonat abonat:list.getAbonatList())
                                {
                                    if(abonat.getAllNume().equals(list1.getSelectedValue())&&l2.elementAt(list1.getSelectedIndex()).equals(String.valueOf(abonat.getNrUnic())))
                                    {tmp=abonat;break;}
                                    
                                }
                                if(tmp!=null)  
                                    data1 = "Detalii Abonat:";
                                    data2 = "Nume = " + list1.getSelectedValue();
                                    data3 = "ID = "+ tmp.getNrUnic();
                                    data4 = "Numar Telefon = "+tmp.getTelefon();
                                    data5 = "Data expirarii abonamentului = "+tmp.getExpired();
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                            }
                            label1.setText(data1);
                            label2.setText(data2);
                            label3.setText(data3);
                            label4.setText(data4);
                            label5.setText(data5);
                        });
                        b2.addActionListener((ActionEvent e) -> {
                            String data = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Abonat tmp=null;int i=0;
                                for(Abonat abonat:list.getAbonatList())
                                {
                                    if(abonat.getAllNume().equals(list1.getSelectedValue()))
                                    {tmp=abonat;break;}
                                    else i++;
                                }
                                JTextField nume = new JTextField();                                 
                                JTextField prenume = new JTextField();
                                JTextField serie = new JTextField();
                                JTextField numar = new JTextField();
                                JTextField telefon = new JTextField();
                                JOptionPane.showOptionDialog(null, new Object[] {"Introduceti noile date ale abonatului","Nume",nume,"Prenume",prenume,"Serie Buletin",serie,"Numar Buletin",numar,"Numar telefon",telefon},
                                        "E-inchiriere filme/Casier/Modificare Abonat", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                                if(!nume.getText().isEmpty())
                                    tmp.setNume(nume.getText());
                                if(!prenume.getText().isEmpty())
                                    tmp.setPrenume(prenume.getText());
                                if(!serie.getText().isEmpty())
                                    tmp.setSerie(serie.getText());
                                if(!numar.getText().isEmpty())
                                    tmp.setNumar(numar.getText());
                                if(!telefon.getText().isEmpty())
                                    tmp.setTelefon(telefon.getText());
                                
                                l1.set(i,tmp.getAllNume());
                                
                            }
                        });
                        while(y)
          {if(b3.isSelected())
              {b3.remove(b3);
              
              break;}
          System.out.print("");
          }
          frame.dispose();
          
                        break;
                    }
                    case 4:
                    {
                        JFrame frame= new JFrame();
                        final JLabel label1 = new JLabel();
                        final JLabel label2 = new JLabel();
                        final JLabel label3 = new JLabel();
                        final JLabel label4 = new JLabel();
                        final JLabel label5 = new JLabel();
                        final JLabel label6 = new JLabel();
                        JButton b=new JButton("Detalii");    
                        b.setBounds(200,150,80,30); 
                        JToggleButton b3=new JToggleButton("Inchidere"); 
                        JButton b4=new JButton("Film pierdut");
                        JButton b2=new JButton("Returnare");
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        final DefaultListModel<String> l2 = new DefaultListModel<>();
                        
                        for(FilmInc film:lista.getFilmeInchiriateList()){
                            l1.addElement(film.nume);
                            String d;
                            d=String.valueOf(film.inchiriere);
                            l2.addElement(d);
                            }
                        final JList<String> list1 = new JList<>(l1); 
                        final JList<String> list2 = new JList<>(l2);
                        JPanel panel = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        frame.add(b);frame.add(b2);frame.add(b4);frame.add(b3); frame.add(label1);frame.add(label4); frame.add(label5); frame.add(label2);frame.add(label3); frame.add(label6); 
                        b.setBounds(100,180,100,25);
                        b3.setBounds(100,210,100,25);
                        b2.setBounds(300,180,100,25);
                        b4.setBounds(300,210,100,25);
                        panel.setBounds(30,10,150,145);
                        label1.setBounds(220,10,300,20);
                        label6.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        frame.add(b);frame.add(b3);
                        frame.setTitle("E-Inchiriere filme/Meniu Casier/Returnare filme");
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.add(label6);
                        frame.setSize(500,300);  
                        frame.setLayout(null);
                        frame.setVisible(true); 
                        frame.setResizable(false);
                        frame.add(b);
                        frame.add(b2);
                        frame.add(b4);
                        frame.add(b3);
                        frame.add(label1);
                        frame.add(label4);
                        frame.add(label5);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label6);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
                        b.addActionListener((ActionEvent e) -> {
                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            String data6 = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                tmp=null;
                                for(FilmInc film:lista.getFilmeInchiriateList())
                                {
                                    if(film.nume.equals(list1.getSelectedValue())&&l2.elementAt(list1.getSelectedIndex()).equals(String.valueOf(film.inchiriere)))
                                    {tmp=film;break;}
                                    else z++;
                                    
                                    
                                }
                                if(tmp!=null)
                                {data1 = "Detalii Film:";
                                data6="Nume = " + tmp.nume;
                                if(tmp.tip)
                                data4 = "Inchiriat: Caseta ";
                                else
                                data4 = "Inchiriat: DVD "; 
                                data5= "Cod unic abonat: "+tmp.codUnic;
                                data2= "Nume Abonat: "+tmp.a.getAllNume();
                                data3= "Data returnare: "+tmp.data;
                                }
                                label1.setText(data1);
                                label4.setText(data4);
                                label5.setText(data5);
                                label2.setText(data2);
                                label3.setText(data3);
                                label6.setText(data6);
                                
                            }
                            label1.setText(data1);
                            label4.setText(data4);
                            label5.setText(data5);
                            label2.setText(data2);
                            label3.setText(data3);
                            label6.setText(data6);
                            
                        });
                        b2.addActionListener((ActionEvent e) -> {
                            if (list1.getSelectedIndex() != -1) {
                                
                               z=0;
                                    late late = null;
                                for(FilmInc film:lista.getFilmeInchiriateList())
                                {
                                    if(film.nume.equals(list1.getSelectedValue())&&l2.elementAt(list1.getSelectedIndex()).equals(String.valueOf(film.inchiriere)))
                                    {tmp=film;break;}
                                    else z++;
                                }    
                                try {
                                    late = new late(tmp.data);
                                } catch (ParseException ex) {
                                    Logger.getLogger(Casier.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                                
                                    if(late.d2>0)
                                        if(tmp.tip)
                                            JOptionPane.showOptionDialog(null, new Object[] {"Aveti de platit "+ 3*late.d2+ "ron deoarece ati intarziat la returnarea filmului cu "+late.d2+" zile.\nFilmul cumparat: "+tmp.nume},
                                                    "E-inchiriere filme/Platire", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                                        else
                                            JOptionPane.showOptionDialog(null, new Object[] {"Aveti de platit "+ 1.5*late.d2+ " ron deoarece ati intarziat la returnarea filmului cu "+late.d2+" zile.\nFilmul cumparat: "+tmp.nume},
                                                    "E-inchiriere filme/Platire", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                                    tmp.a.returnat();
                                    lista.returnareFilm(z,tmp.tip);
                                    if(tmp!=null)
                                    {if(tmp.tip)
                                    tmp.b.returnDVD();
                                    else tmp.b.returnDVD();
                                    l1.remove(z);l2.remove(z);
                                   
                                
                                    }
                                    z=0;
                            }
                        });
                        b4.addActionListener((ActionEvent e) -> {
                            if (list1.getSelectedIndex() != -1) 
                                {z=0;
                                    for(FilmInc film:lista.getFilmeInchiriateList())
                                {
                                    if(film.nume.equals(list1.getSelectedValue())&&l2.elementAt(list1.getSelectedIndex()).equals(String.valueOf(film.inchiriere)))
                                    {tmp=film;break;}
                                    else z++;
                                }   
                                JOptionPane.showOptionDialog(null, new Object[] {"Aveti de platit 200% din pretul total al filmului: "+2*tmp.b.getPret()+" RON"},
                            "E-inchiriere filme/Platire", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                                tmp.a.returnat();
                                    lista.returnareFilm(z,tmp.tip);
                                    l1.remove(z);l2.remove(z);
                                    }
                                    
                                    
                        });
                        while(y)
          {if(b3.isSelected())
              {
              
              break;}
          System.out.print("");
          }
          frame.dispose();
                    
                    break;}
                        
                        
                        
                        
                    
                    case 5:{
                        JFrame frame= new JFrame();  
                        final JLabel label1 = new JLabel();
                        final JLabel label2 = new JLabel(); 
                        final JLabel label3 = new JLabel(); 
                        final JLabel label4 = new JLabel(); 
                        final JLabel label5 = new JLabel(); 
                        JButton b=new JButton("Detalii");
                        JButton b2=new JButton("Stergere");
                        JToggleButton b3=new JToggleButton("Inchidere");
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        final DefaultListModel<String> l2 = new DefaultListModel<>();
                        for(Abonat abonat:list.getAbonatList()){
                            l1.addElement(abonat.getAllNume());
                        String d;
                            d=String.valueOf(abonat.getNrUnic());
                            l2.addElement(d);}
                        final JList<String> list1 = new JList<>(l1);  
                        JPanel panel = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        frame.add(b);frame.add(b2);frame.add(b3);frame.add(label5);frame.add(label4);frame.add(label3);frame.add(label2);frame.add(label1);
                        frame.setTitle("E-Inchiriere filme/Meniu Casier/Stergere abonati");
                        scrollPane.setBounds(30,10,150,145);
                        panel.setBounds(30,10,150,145);
                        b.setBounds(80,180,100,25);
                        b2.setBounds(200,180,100,25);
                        b3.setBounds(320,180,100,25);
                        label1.setBounds(220,10,300,20);
                        label1.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.setSize(500,270);  
                        frame.setLayout(null);
                        frame.setVisible(true); 
                        frame.setResizable(false);
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        frame.add(b);frame.add(b2);frame.add(b3);
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
                        b.addActionListener((ActionEvent e) -> {
                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            if (list1.getSelectedIndex() != -1) {
                                Abonat tmp1 = null;
                                for (Abonat abonat : list.getAbonatList()) {
                                    if (abonat.getAllNume().equals(list1.getSelectedValue())&&l2.elementAt(list1.getSelectedIndex()).equals(String.valueOf(abonat.getNrUnic()))) {
                                        tmp1 = abonat;
                                        break;
                                    }
                                }
                                if (tmp1 != null) {  
                                    data1 ="Detalii Abonat:";
                                    data2 ="Nume = " + list1.getSelectedValue();
                                    data3="ID = " + tmp1.getNrUnic();
                                    data4="Numar Telefon = " + tmp1.getTelefon();
                                    data5="Data expirarii abonamentului= " + tmp1.getExpired();
                                }
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                            }
                            label1.setText(data1);
                            label2.setText(data2);
                            label3.setText(data3);
                            label4.setText(data4);
                            label5.setText(data5);
                        });
                        b2.addActionListener((ActionEvent e) -> {
                            String data1 = "";
                            String data2 = "";
                            String data3 = "";
                            String data4 = "";
                            String data5 = "";
                            if (list1.getSelectedIndex() != -1) {
                                Abonat tmp1 = null;
                                int i=0;
                                for (Abonat abonat : list.getAbonatList()) {
                                    if (abonat.getAllNume().equals(list1.getSelectedValue())) {
                                        tmp1 = abonat;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (tmp1 != null) {                                 
                                    list.deleteAbonat(tmp1,i);
                                }
                                l1.remove(i);i--;
                            }
                        });
                        while(y)
          {if(b3.isSelected())
              {b3.remove(b3);
              
              break;}
          System.out.print("");
          }
          frame.dispose();
                        
                        break;
                    }
                    case 6:{
                        x=1;break;
                        }
                }
            }else {x=1;}
        }    
    }
}
