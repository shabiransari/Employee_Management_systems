
package employee.management.systems;

import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice cemployeeid;
    JButton search, print, update, back;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.WHITE);        
        setLayout(null);
        
        JLabel searchlbl=new JLabel("Search By Employee id");
        searchlbl.setBounds(20, 20, 150, 20);
        
        add(searchlbl);
        cemployeeid=new Choice();
        cemployeeid.setBounds(180, 20, 150, 20);
        add(cemployeeid);
        
        
         try{
            Conn c=new Conn();
            //rs contains each row of table
            ResultSet rs=c.s.executeQuery("select * from employee");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                cemployeeid.add(rs.getString("empid"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        table=new JTable();
        try{
            Conn c=new Conn();
            //rs contains each row of table
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                        
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 500);
        add(jsp);
        
        
        //buttons
        search=new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 600);
        setLocation(300, 100);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employee where empid= '"+cemployeeid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try{
               table.print();
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
            
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        
        
        new ViewEmployee();
    }
}
