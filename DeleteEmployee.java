import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class DeleteEmployee extends JFrame{
Container c;
JLabel labId;
JTextField txtId;
JButton btnDelete, btnBack;

DeleteEmployee(){
c=getContentPane();
Color m=new Color(255,255,255);
FlowLayout fl=new FlowLayout(FlowLayout.CENTER,30,30);
c.setLayout(fl);
c.setBackground(Color.YELLOW);

Font f=new Font("Century",Font.BOLD + Font.ITALIC,30);

labId=new JLabel("Enter Employee Id");
txtId=new JTextField(20);
btnDelete=new JButton("Delete");
btnBack=new JButton("Back To Home");

labId.setFont(f);
txtId.setFont(f);
btnDelete.setFont(f);
btnBack.setFont(f);

btnDelete.setBackground(m);
btnBack.setBackground(m);

c.add(labId);
c.add(txtId);
c.add(btnDelete);
c.add(btnBack);

ActionListener a1=(ae) -> {
Home h=new Home();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2=(ae) -> {
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf=cfg.buildSessionFactory();
Session s=null;
Transaction t=null;
try{
s=sf.openSession();
System.out.println("Connected");
int id=Integer.parseInt(txtId.getText());
Employee emp=(Employee)s.get(Employee.class,id);
if(emp==null){
System.out.println(id+" does not exists");
}
else{
t=s.beginTransaction();
s.delete(emp);
t.commit();
JOptionPane.showMessageDialog(c,"Record Deleted");
txtId.setText("");
}
}
catch(Exception e){
t.rollback();
System.out.println("issue "+e);
}finally{
s.close();
System.out.println("Closed");
}
};
btnDelete.addActionListener(a2);


setTitle("E.M.S");
setSize(1200,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}