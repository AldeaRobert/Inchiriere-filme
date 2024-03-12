package Film_final;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


class Addition2 extends JFrame
{   final String[] genuri={"Comedie","Actiune","Mister","Groaza","Romantic","Istoric","Politist","Thriller","SF","Dramatic"};
    JTextField t1,t2,t3,t4,t5;
    JButton ok;
    JToggleButton exit=new JToggleButton("Exit");
    JLabel T1,T2,T3,T4,T5,T6;
    int x;
    JRadioButton r1,r2;
    public Addition2(FilmList list)
    {   
        final DefaultListModel<String> l1 = new DefaultListModel<>();
        for(int i=0;i<genuri.length;i++){
              l1.addElement(genuri[i]);}
        final JList<String> list3 = new JList<>(l1);  
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list3);
        list3.setLayoutOrientation(JList.VERTICAL);
        setLayout(null);
        JPanel panel = new JPanel(null);
        panel.add(exit);
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        T1 = new JLabel("Nume");
        T2 = new JLabel("Anul aparitiei");
        T3 = new JLabel("Pret total");
        T4 = new JLabel("Numar Casete");
        T5 = new JLabel("Numar DVD");
        T6 = new JLabel("Gen");
        ok = new JButton("Ok");
        t1.setBounds(10,10,110,20);
        t2.setBounds(10,35,110,20);
        t3.setBounds(10,60,110,20);
        t4.setBounds(10,85,110,20);
        t5.setBounds(10,110,110,20);
        T1.setBounds(135,10,100,20);
        T2.setBounds(135,35,100,20);
        T3.setBounds(135,60,100,20);
        T4.setBounds(135,85,100,20);
        T5.setBounds(135,110,100,20);
        T6.setBounds(290,10,30,20);
        ok.setBounds(75,150,75,25);
        scrollPane.setBounds(260,35,100,90);
        exit.setBounds(0,0,75,25);
        panel.setBounds(237,150,75,25);
        add(t1);add(T1);add(t2);add(T2);add(t3);add(T3);add(t4);add(T4);add(t5);add(T5);add(scrollPane);add(T6);add(ok);add(panel);
        setVisible(true);
        setResizable(false);
        setSize(400,240);
        setTitle("E-Inchiriere filme/Admin/Adaugare film");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        ok.addActionListener((ActionEvent e) -> {
         if(!t1.getText().isEmpty()&&!t2.getText().isEmpty()&&!t3.getText().isEmpty()&&!t4.getText().isEmpty()&&!t5.getText().isEmpty()) 
            if(list3.getSelectedIndex() != -1)
            { int aleg=list3.getSelectedIndex();
                Film film;
                film = new Film(t1.getText(),Integer.parseInt(t2.getText()),l1.elementAt(aleg),Integer.parseInt(t4.getText()),Integer.parseInt(t5.getText()),Float.parseFloat(t3.getText()));
            list.addFilm(film);exit.setSelected(true);
            }
            
            
            
        });
     while(true)
            {
                if(exit.isSelected())
                    break;
                System.out.print("");
            }  
     this.dispose();
}
}