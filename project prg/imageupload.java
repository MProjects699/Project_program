Folder Name=> images in project folder

import java.sql.*;
import javax.swing.JOptionPane;
//import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

;

public class MemberMaster extends javax.swing.JFrame {
    
    JFileChooser fc;
    File myfile;
    String pic = "";



String filename="";
                
        if(myfile!=null){
         filename = "Images\\"+new Date().getTime() + "_" + myfile.getName();//Date.getTime() added for unique file name.
        int i;
        FileInputStream rd = null;
        FileOutputStream outs = null;
        try {

            rd = new FileInputStream(myfile);
            outs = new FileOutputStream(filename);//writing the new file in 'Images' folder, in the project

            byte[] b = new byte[2048];
            while ((i = rd.read(b)) > 0) {
                outs.write(b, 0, i);

            }
            JOptionPane.showMessageDialog(rootPane, "File saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error" + e.getMessage());
        } finally {
            try {
                rd.close();
                outs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "error in closing file" + e.getMessage());
            }
        }
        }else
        {
            filename="Default\\mypic";
        
        }
 
        
        Connection myconnection=null;
        
        String path="jdbc:mysql://localhost/";
        String place="libman";
        try
        {
            myconnection=DriverManager.getConnection(path+place, "root", "");
            String query="insert into member_master(username_id,name,gender,course,year,address,email,mobile,active_user,photo) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement mystatement=myconnection.prepareStatement(query);
            mystatement.setString(1, jTextField3.getText());
            mystatement.setString(2, jTextField2.getText());
            if(jRadioButton1.isSelected())
            {
                mystatement.setString(3, "Male");
                
            }
            else if(jRadioButton2.isSelected())
            {
                mystatement.setString(3, "Female");
            }
            mystatement.setString(4, jComboBox2.getSelectedItem().toString());
            mystatement.setString(5, jComboBox1.getSelectedItem().toString());
            mystatement.setString(6, jTextArea1.getText());
            mystatement.setString(7, jTextField1.getText());
            mystatement.setString(8, jFormattedTextField2.getText());
            if(jCheckBox1.isSelected());
                {
                    mystatement.setString(9,"Y");
                }
                
                //{
                  //  mystatement.setString(6,"N");
                //}
            mystatement.setString(10, filename);
            
            mystatement.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Saved Successfully ");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error in Connection "+ e.getMessage());
        }
        finally
        {
            try
            {
                myconnection.close();    
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane,"Could not close connection "+ e.getMessage());
            }
            
        }

fc = new JFileChooser();

        fc.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                int pos = f.getName().lastIndexOf('.');
                if (pos == -1) {
                    return false;
                } else {
                    String extention = f.getName().substring(pos + 1);//saving the extension
                    String str[] = {"gif", "png", "jpg", "jpeg"};//allowed extentions
                    for (String allwd : str) {

                        if (extention.equalsIgnoreCase(allwd)) {
                            return true;
                        }
                    }
                    return false;
                }

            }

            @Override
            public String getDescription() {

                return "";
            }
        });
        int result = fc.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            myfile = fc.getSelectedFile();

            try {
                jLabel10.setIcon(new ImageIcon(ImageIO.read(myfile)));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(rootPane, "Error");
                e.printStackTrace();
            }
        }