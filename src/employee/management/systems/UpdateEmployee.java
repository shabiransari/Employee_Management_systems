
package employee.management.systems;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    //global declaration
    JTextField tfeducation, tffname,tfaddres, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    //JDateChooser dcdob;
    JLabel lblempid;
    JButton add, back;
    //JComboBox cbeducation;
    String empid;
    
    UpdateEmployee(String empid){
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        ///Name
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
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
        
//        dcdob=new JDateChooser();
//        dcdob.setBounds(200, 200, 150, 30);
//        add(dcdob);
         JLabel lbldob=new JLabel();
         lbldob.setBounds(200, 200, 150, 30);
         add(lbldob);


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
        
        //String courses[]={"BBA", "BCA","BCOM", "BSC", "BE", "BTECH", "OTHRES" };
        
        tfeducation=new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        //tfeducation.setBackground(Color.WHITE);
        add(tfeducation);
        
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
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);
        
        //Employee ID
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);
        
        //Random number
        lblempid=new JLabel(""+number);
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
          
          
          try{
              Conn c=new Conn();
              String query="select * from employee where empid = '"+empid+"'";
              ResultSet rs=c.s.executeQuery(query);
              
              while(rs.next()){
                  lblname.setText(rs.getString("name"));
                  tffname.setText(rs.getString("fname"));
                  lbldob.setText(rs.getString("dob"));
                  tfaddres.setText(rs.getString("address"));
                  tfsalary.setText(rs.getString("salary"));
                  tfphone.setText(rs.getString("phone"));
                  tfemail.setText(rs.getString("email"));
                  tfeducation.setText(rs.getString("education"));
                  lblaadhar.setText(rs.getString("aadhar"));
                  lblempid.setText(rs.getString("empid"));
                  tfdesignation.setText(rs.getString("designation"));
                  
              }
              
              
          }catch (Exception e){
              e.printStackTrace();
          }



        //buttons
        add=new JButton("Update Details");
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
            //String name =tfeducation.getText();
            String fname=tffname.getText();
            //String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address=tfaddres.getText();
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String education= tfeducation.getText();
            String designation=tfdesignation.getText();
            //String aadhar=tfaadhar.getText();
            //String empid=lblempid.getText();
            
            try{
                Conn conn=new Conn();
                String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"', phone='"+phone+"', email='"+email+"', education='"+education+"',designation='"+designation+"' where empid='"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateEmployee("");
    }
}
