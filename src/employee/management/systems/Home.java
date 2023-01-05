
package employee.management.systems;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton view, add, update, remove;
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading =new JLabel("Employee Management System");
        heading.setBounds(660, 20, 400, 40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        image.add(heading);
        
        //1. add button
        add=new JButton("Add Employee");
        add.setBounds(670, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        //2.  view button
        view=new JButton("View Employees");
        view.setBounds(840, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        //3. update button
        
        update=new JButton("Update Employee");
        update.setBounds(670, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        //4.remove button
        
        remove=new JButton("Remove Employee");
        remove.setBounds(840, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120, 630);
        setLocation(100, 50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
            
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
            
        }
    }
    
    public static void main(String args[]){
        new Home();
    }
}
