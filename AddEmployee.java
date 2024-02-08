import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class AddEmployee extends JFrame{
Container c;
JLabel labId,labName,labEmail,labPhone,labSalary;
JTextField txtId,txtName,txtEmail,txtPhone,txtSalary;
JButton btnSave, btnBack;

AddEmployee(){
c=getContentPane();
Color m=new Color(255,255,255);
FlowLayout fl=new FlowLayout(FlowLayout.CENTER,30,30);
c.setLayout(fl);
c.setBackground(Color.YELLOW);

Font f=new Font("Century",Font.BOLD + Font.ITALIC,30);

labId=new JLabel("Enter Employee Id");
txtId=new JTextField(25);
labName=new JLabel("Enter Employee Name");
txtName=new JTextField(25);
labEmail=new JLabel("Enter Employee Email");
txtEmail=new JTextField(25);
labPhone=new JLabel("Enter Employee Phone No.");
txtPhone=new JTextField(25);
labSalary=new JLabel("Enter Employee Salary");
txtSalary=new JTextField(25);
btnSave=new JButton("Save");
btnBack=new JButton("Back To Home");

labId.setFont(f);
txtId.setFont(f);
labName.setFont(f);
txtName.setFont(f);
labEmail.setFont(f);
txtEmail.setFont(f);
labPhone.setFont(f);
txtPhone.setFont(f);
labSalary.setFont(f);
txtSalary.setFont(f);
btnSave.setFont(f);
btnBack.setFont(f);

btnSave.setBackground(m);
btnBack.setBackground(m);

c.add(labId);
c.add(txtId);
c.add(labName);
c.add(txtName);
c.add(labEmail);
c.add(txtEmail);
c.add(labPhone);
c.add(txtPhone);
c.add(labSalary);
c.add(txtSalary);
c.add(btnSave);
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
String name=txtName.getText();
String email=txtEmail.getText();
long phone=Long.parseLong(txtPhone.getText());
int salary=Integer.parseInt(txtSalary.getText());
Employee emp=new Employee(id,name,email,phone,salary);


t=s.beginTransaction();
s.save(emp);
t.commit();
JOptionPane.showMessageDialog(c,"Record Created");
txtId.setText("");
txtName.setText("");
txtEmail.setText("");
txtPhone.setText("");
txtSalary.setText("");
}
catch(Exception e){
t.rollback();
JOptionPane.showMessageDialog(c,"issue"+e);
}finally{
s.close();

}
};
btnSave.addActionListener(a2);


setTitle("E.M.S");
setSize(1200,700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setVisible(true);
}
}