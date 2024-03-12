package Film_final;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;


class Addition extends JFrame
{   Abonat temp;
    JTextField t1,t2,t3,t4,t5;int y=0;
    JToggleButton ok = new JToggleButton("Ok");;
    JToggleButton exit=new JToggleButton("Exit");
    JLabel T1,T2,T3,T4,T5,Tx;
    int x;int k=-1;
    JRadioButton r1,r2;
    public Addition(ListAbonat list)
    {
        setLayout(new FlowLayout());
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        Tx = new JLabel("                            ");
        r1 = new JRadioButton("8 luni");
        r2 = new JRadioButton("12 luni");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        T1 = new JLabel("Nume              ");
        T2 = new JLabel("Prenume        ");
        T3 = new JLabel("Serie buletin  ");
        T4 = new JLabel("Numar buletin");
        T5 = new JLabel("Nr telefon        ");
        
        add(t1);add(T1);add(t2);add(T2);add(t3);add(T3);add(t4);add(T4);add(t5);add(T5);add(r1);add(r2);add(Tx);add(ok);add(exit);
        setVisible(true);
        setResizable(false);
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        ok.addActionListener((ActionEvent e) -> {
            if(!t1.getText().isEmpty()&&!t2.getText().isEmpty()&&!t3.getText().isEmpty()&&!t4.getText().isEmpty()&&!t5.getText().isEmpty())
            {if(r1.isSelected())
            {
                x = 8;y=5;System.out.println(y);
                
            }
            if(r2.isSelected())
            {
                x= 12;y=8;
                
            }
            
            Abonat abonat=new Abonat(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),x);
            list.addAbonat(abonat);temp=abonat;}
            
         if(y!=0)
        k=JOptionPane.showOptionDialog(null, new Object[] {"Abonatul are de platit "+y+" RON\nNume Abonat: "+t1.getText()+"\nNumar Telefon: "+t5.getText()+"\nDate Buletin: "+t3.getText()+" "+t4.getText()+"\n"+"Data expirare: "+temp.getExpired()},
                            "E-inchiriere filme/Platire", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);   
        });
        
        
        
     while(true)
            {
                if(exit.isSelected()||ok.isSelected()&&k==JOptionPane.OK_OPTION)
                    break;
                System.out.print("");
            }  
     this.dispose();
}
}