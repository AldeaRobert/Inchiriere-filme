/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Film_final;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;  
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

public class Admin {
    FilmList list;
    Scanner sc;
    String scan1=null,scan2=null,scan3=null;
    
    public Admin(FilmList list) throws FileNotFoundException {
    this.list=list;
    }
    public void admin() throws FileNotFoundException{
        int x=0;boolean y=true;
        while(x==0)
            {String[] op2 = new String[] {"1","2","3","4","5"};
            int rasp2 = JOptionPane.showOptionDialog(null, "Ce doriti sa faceti?\n1 - Vizionare lista filme\n2 - Adaugare film\n3 - Stergere film\n4 - Modificare film\n5 - Deconectare", "E-Inchiriere filme/Meniu admin",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, op2, op2[0]);
            if(rasp2>=0){
                switch(rasp2+1){
                    case 1:
                    {
                         
                        final JLabel label1 = new JLabel();
                        final JLabel label2 = new JLabel();
                        final JLabel label3 = new JLabel();
                        final JLabel label4 = new JLabel();
                        final JLabel label5 = new JLabel();
                        final JLabel label6 = new JLabel();
                        JPanel panel = new JPanel(new BorderLayout());
                        JButton b=new JButton("Detalii"); 
                        JToggleButton b3=new JToggleButton("Inchidere");  
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        
                        for(Film film:list.getFilmList()){
                            l1.addElement(film.getNume());}
                        final JList<String> list1 = new JList<>(l1);  
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);
                        JFrame frame= new JFrame(); 
                        frame.add(panel);frame.add(b);frame.add(b3);frame.add(label5);frame.add(label4);frame.add(label3);frame.add(label2);frame.add(label1);frame.add(label6);
                        b.setBounds(80,180,100,25);
                        b3.setBounds(280,180,100,25);
                        panel.setBounds(30,10,150,145);
                        label1.setBounds(220,10,300,20);
                        label1.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        label6.setBounds(220,130,300,20);
                        frame.add(b);frame.add(b3);
                        frame.setTitle("E-Inchiriere filme/Meniu Admin/Lista filme");
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.add(label6);
                        frame.setSize(460,270);  
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
                            String data6 = "";
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Film tmp=null;
                                for(Film film:list.getFilmList())
                                {
                                    if(film.getNume().equals(list1.getSelectedValue()))
                                    {tmp=film;break;}
                                }
                                data1 = "Detalii Film:";
                                data2="Nume = " + list1.getSelectedValue();
                                data3="An = "+ tmp.getAn();
                                data4="Gen = "+ tmp.getGen();
                                data5="Nr Casete = " + tmp.getCasete();
                                data6="Nr DVD = "+ tmp.getDvd();  
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                                label6.setText(data6);
                            }
                            label1.setText(data1);
                            label2.setText(data2);
                            label3.setText(data3);
                            label4.setText(data4);
                            label5.setText(data5);
                            label6.setText(data6);
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
                        new Addition2(list);
                        break;
                    }

                    case 3:{
                        JFrame frame= new JFrame();  
                        final JLabel label6 = new JLabel();
                        final JLabel label5 = new JLabel(); 
                        final JLabel label4 = new JLabel(); 
                        final JLabel label3 = new JLabel(); 
                        final JLabel label2 = new JLabel(); 
                        final JLabel label1 = new JLabel();
                        JButton b=new JButton("Detalii");  
                        JButton b2=new JButton("Stergere"); 
                        JToggleButton b3=new JToggleButton("Inchidere");
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        list.getFilmList().forEach(film -> {
                            l1.addElement(film.getNume());
                    });
                        final JList<String> list1 = new JList<>(l1);
                        JPanel panel = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        frame.add(b);frame.add(b2);frame.add(b3);frame.add(label6);frame.add(label5);frame.add(label4);frame.add(label3);frame.add(label2);frame.add(label1);
                        b.setBounds(55,180,100,25);
                        b2.setBounds(180,180,100,25);
                        b3.setBounds(305,180,100,25);
                        panel.setBounds(30,10,150,145);
                        label1.setBounds(220,10,300,20);
                        label1.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        label6.setBounds(220,130,300,20);
                        frame.add(b);frame.add(b3);
                        frame.setTitle("E-Inchiriere filme/Meniu Admin/Lista filme");
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.add(label6);
                        frame.setSize(460,270);  
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
                            String data6 = "";
                            if (list1.getSelectedIndex() != -1)
                            {
                                Film tmp=null;
                                for(Film film:list.getFilmList())
                                {
                                    if(film.getNume().equals(list1.getSelectedValue()))
                                    {tmp=film;break;}
                                }
                                data1 = "Detalii Film:";
                                data2="Nume = "+ list1.getSelectedValue();
                                data3="An = "+ tmp.getAn();
                                data4="Gen = "+ tmp.getGen();
                                data5="Nr Casete = " + tmp.getCasete();
                                data6="Nr DVD = "+ tmp.getDvd();
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                                label6.setText(data6);
                            }
                            label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                                label6.setText(data6);
                        });
                        b2.addActionListener((ActionEvent e) -> {
                            if (list1.getSelectedIndex() != -1)
                            { 
                                Film tmp=null;int i=0;
                                for(Film film:list.getFilmList())
                                {
                                    if(film.getNume().equals(list1.getSelectedValue()))
                                    {tmp=film;break;}
                                    else i++;
                                }
                                list.stergeFilm(i);
                                l1.remove(i);
                            }
                        });
                        while(y)
          {if(b3.isSelected())
              {
              
              break;}
          System.out.print("");
          }
          frame.dispose();
                        break;
                    }
                    case 4:{
                        JFrame frame= new JFrame();  
                        final JLabel label6 = new JLabel();
                        final JLabel label5 = new JLabel(); 
                        final JLabel label4 = new JLabel(); 
                        final JLabel label3 = new JLabel(); 
                        final JLabel label2 = new JLabel(); 
                        final JLabel label1 = new JLabel();
                        JButton b=new JButton("Detalii");  
                        JButton b2=new JButton("Modificare");  
                        JToggleButton b3=new JToggleButton("Inchidere"); 
                        final DefaultListModel<String> l1 = new DefaultListModel<>();
                        list.getFilmList().forEach(film -> {
                            l1.addElement(film.getNume());
                    });
                        final JList<String> list1 = new JList<>(l1);
                        JPanel panel = new JPanel(new BorderLayout());
                        JScrollPane scrollPane = new JScrollPane();
                        scrollPane.setViewportView(list1);
                        list1.setLayoutOrientation(JList.VERTICAL);
                        panel.add(scrollPane);frame.add(panel);
                        frame.add(b);frame.add(b2);frame.add(b3);frame.add(label6);frame.add(label5);frame.add(label4);frame.add(label3);frame.add(label2);frame.add(label1);
                        b.setBounds(55,180,100,25);
                        b2.setBounds(180,180,100,25);
                        b3.setBounds(305,180,100,25);
                        panel.setBounds(30,10,150,145);
                        label1.setBounds(220,10,300,20);
                        label1.setBounds(220,30,300,20);
                        label2.setBounds(220,50,300,20);
                        label3.setBounds(220,70,300,20);
                        label4.setBounds(220,90,300,20);
                        label5.setBounds(220,110,300,20);
                        label6.setBounds(220,130,300,20);
                        frame.add(b);frame.add(b3);
                        frame.setTitle("E-Inchiriere filme/Meniu Admin/Lista filme");
                        frame.add(label1);
                        frame.add(label2);
                        frame.add(label3);
                        frame.add(label4);
                        frame.add(label5);
                        frame.add(label6);
                        frame.setSize(460,270);  
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
                            String data6 = "";
                                if (list1.getSelectedIndex() != -1)
                                { 
                                    Film tmp=null;
                                    for(Film film:list.getFilmList())
                                    {
                                        if(film.getNume() == null ? list1.getSelectedValue() == null : film.getNume().equals(list1.getSelectedValue()))
                                        {tmp=film;break;}
                                    }
                                    data1 = "Detalii Film:";
                                data2="Nume = "+ list1.getSelectedValue();
                                data3="An = "+ tmp.getAn();
                                data4="Gen = "+ tmp.getGen();
                                data5="Nr Casete = " + tmp.getCasete();
                                data6="Nr DVD = "+ tmp.getDvd();
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                                label6.setText(data6);
                                }
                                label1.setText(data1);
                                label2.setText(data2);
                                label3.setText(data3);
                                label4.setText(data4);
                                label5.setText(data5);
                                label6.setText(data6);
                            });
                            b2.addActionListener((ActionEvent e) -> {
                                if (list1.getSelectedIndex() != -1)
                                { 
                                    Film tmp=null;int i=0;
                                    for(Film film:list.getFilmList())
                                    {
                                        if(film.getNume() == null ? list1.getSelectedValue() == null : film.getNume().equals(list1.getSelectedValue()))
                                        {tmp=film;break;}
                                        else i++;
                                    }
                                    JTextField nume = new JTextField();
                                    JTextField an = new JTextField();
                                    JTextField gen = new JTextField();
                                    JTextField nrCasete = new JTextField();
                                    JTextField nrDVD = new JTextField();
                                    JOptionPane.showOptionDialog(null, new Object[] {"Introduceti datele filmului","Nume film",nume,"An aparitie",an,"Gen",gen,"Nr casete",nrCasete,"Nr DVD-uri",nrDVD},
                                            "E-inchiriere filme/Admin/Modificare Film", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                                    if(!nume.getText().isEmpty())
                                        tmp.setNume(nume.getText());
                                    if(!an.getText().isEmpty())
                                        tmp.setAn(Integer.parseInt(an.getText()));
                                    if(!gen.getText().isEmpty())
                                        tmp.setGen(gen.getText());
                                    if(!nrCasete.getText().isEmpty())
                                        tmp.setCasete(Integer.parseInt(nrCasete.getText()));
                                    if(!nrDVD.getText().isEmpty())
                                        tmp.setDVD(Integer.parseInt(nrDVD.getText()));
                                    
                                    l1.set(i,tmp.getNume());
                                }
                            });
                        
                        while(y)
          {if(b3.isSelected())
              {
              
              break;}
          System.out.print("");
          }
          frame.dispose();
                        break;
                    }
                    case 5:{
                        x=1;break;
                    }
                }
            }else {x=1;}
        }
    }
}
