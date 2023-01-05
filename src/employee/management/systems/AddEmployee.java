
package employee.management.systems;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    //global declaration
    JTextField tfname, tffname,tfaddres, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JDateChooser dcdob;
    JLabel lblempid;
    JButton add, back;
     JComboBox cbeducation;
    
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        ///Name
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        //fathers name
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("serif", Font.PLAIN, 20));
        add(fname);
        
        tffname=new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        //Date of Birth
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
        //salary
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
       tfsalary=new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        
        //address
        JLabel labeladdres=new JLabel("Address");
        labeladdres.setBounds(50, 250, 150, 30);
        labeladdres.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdres);
        
        tfaddres=new JTextField();
        tfaddres.setBounds(200, 250, 150, 30);
        add(tfaddres);
        
        //phone 
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        //email
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        //Heighest education
        JLabel labeleducation=new JLabel("Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        String courses[]={"BBA", "BCA","BCOM", "BSC", "BE", "BTECH", "OTHRES" };
        
        cbeducation=new JComboBox(courses);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);
        
       //Designation
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        //Aadhar 
        JLabel labelaadhar=new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);
        
        //Employee ID
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
        
        ////Random number
        lblempid=new JLabel(""+number);
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        
        //buttons
        add=new JButton("Add Details");
        add.setBounds(250, 480, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(450, 480, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        setSize(900, 600);
        setLocation(300, 50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name =tfname.getText();
            String fname=tfname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address=tfaddres.getText();
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String education= (String) cbeducation.getSelectedItem();
            String designation=tfdesignation.getText();
            String aadhar=tfaadhar.getText();
            String empid=lblempid.getText();
            
            try{
                Conn conn=new Conn();
                String query="insert into employee values('"+name+"', '"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
            
        }else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String args[]){
        new AddEmployee();
    }
}
