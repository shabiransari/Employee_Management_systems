
package employee.management.systems;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpid;
    JButton delete, back;
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50, 50, 100, 30);
        add(labelempid);
        
        //choice
        cEmpid=new Choice();
        cEmpid.setBounds(200, 50, 150, 30);
        add(cEmpid);
        //use dbs
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cEmpid.add(rs.getString("empid"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        //
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        //
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        //
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        
        
        ///
         try{
            Conn c=new Conn();
            String query="select * from employee where empid='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
                
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        cEmpid.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
             try{
            Conn c=new Conn();
            String query="select * from employee where empid='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
                
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        }
        });
        
    ///buttons
    delete=new JButton("Delete");
    delete.setBounds(80, 280, 100, 30);
    delete.setBackground(Color.BLACK);
    delete.setForeground(Color.WHITE);
    delete.addActionListener(this);
    add(delete);
    
    back=new JButton("Back");
    back.setBounds(230, 280, 100, 30);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    //image to right side
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(200, 200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            
            try{
                Conn c=new Conn();
                String query="delete from employee where empid= '"+cEmpid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
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
    public static void main(String[] args){
        new RemoveEmployee();
        
    }
}
