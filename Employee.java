class Employee{
private int id;
private String name;
private String email;
private long phone;
private int salary;



public Employee(){}

public Employee(int id,String name,String email,long phone,int salary){
this.id=id;
this.name=name;
this.email=email;
this.phone=phone;
this.salary=salary;
}


public int getId() {return id;}
public String getName() {return name;}
public String getEmail() {return email;}
public long getPhone() {return phone;}
public int getSalary() {return salary;}


public void setId(int id) {this.id=id;}
public void setName(String name) {this.name=name;}
public void setEmail(String email) {this.email=email;}
public void setPhone(long phone) {this.phone=phone;}
public void setSalary(int salary) {this.salary=salary;}

}