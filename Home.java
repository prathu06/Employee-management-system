import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home extends JFrame{
Container c;
JButton btnAdd, btnView,btnUpdate,btnDelete;


Home(){
c=getContentPane();
Color m=new Color(255,255,255);
FlowLayout fl=new FlowLayout(FlowLayout.CENTER,30,30);
c.setLayout(fl);
c.setBackground(Color.YELLOW);
Font f=new Font("Century",Font.BOLD,30);

btnAdd=new JButton("Add Employee");
btnView=new JButton("View Employee");
btnUpdate=new JButton("Update Employee");
btnDelete=new JButton("Delete Employee");


btnAdd.setPreferredSize(new Dimension(600,120));
btnView.setPreferredSize(new Dimension(600,120));
btnUpdate.setPreferredSize(new Dimension(600,120));
btnDelete.setPreferredSize(new Dimension(600,120));

btnAdd.setFont(f);
btnView.setFont(f);
btnUpdate.setFont(f);
btnDelete.setFont(f);

btnAdd.setBackground(m);
btnView.setBackground(m);
btnUpdate.setBackground(m);
btnDelete.setBackground(m);

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);



ActionListener a1=(ae) -> {
AddEmployee a=new AddEmployee();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2=(ae) -> {
ViewEmployee v=new ViewEmployee();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3=(ae) -> {
UpdateEmployee u=new UpdateEmployee();
dispose();
};
btnUpdate.addActionListener(a3);

ActionListener a4=(ae) -> {
DeleteEmployee d=new DeleteEmployee();
dispose();
};
btnDelete.addActionListener(a4);

setTitle("E.M.S");
setSize(1200,700);
setLocationRelativeTo(null);
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
