import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class ViewEmployee extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

ViewEmployee(){
c=getContentPane();
Color m=new Color(255,255,255);
FlowLayout fl=new FlowLayout(FlowLayout.CENTER,30,30);
c.setLayout(fl);
c.setBackground(Color.YELLOW);
Font f=new Font("Century",Font.BOLD + Font.ITALIC,30);

taData=new TextArea(17,50);
btnBack=new JButton("Back To Home");
btnBack.setBackground(m);

taData.setFont(f);
btnBack.setFont(f);

c.add(taData);
c.add(btnBack);

ActionListener a1=(ae) -> {
Home h=new Home();
dispose();
};
btnBack.addActionListener(a1);


Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");


SessionFactory sf=cfg.buildSessionFactory();
Session s=null;

try{
s=sf.openSession();
System.out.println("Connected");

java.util.List<Employee> emp=new java.util.ArrayList<>();
emp=s.createQuery("from Employee").list();

StringBuffer sb=new StringBuffer();
for(Employee ss:emp)
{
sb.append("id= "+ss.getId()+","+" name= "+ss.getName()+","+" email= "+ss.getEmail()+","+" phone= "+ss.getPhone()+","+" salary= "+ss.getSalary()+"\n");
}
taData.setText(sb.toString());

}
catch(Exception e){
JOptionPane.showMessageDialog(c,"issue"+e);
}finally{
s.close();
System.out.println("closed");

}

taData.setEditable(false);


setTitle("E.M.S");
setSize(1200,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}