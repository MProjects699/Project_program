Connection myconnection=null;
        
        String path="jdbc:mysql://localhost/";
        String place="libman";
        try
        {
            myconnection=DriverManager.getConnection(path+place, "root", "");
            String query="insert into book_detail(book_id,category,title,author,publisher,year_publish) values(?,?,?,?,?,?)";
            PreparedStatement mystatement=myconnection.prepareStatement(query);
            mystatement.setString(1, jTextField1.getText());
            mystatement.setString(2, jComboBox1.getSelectedItem().toString());
            mystatement.setString(3, jTextField2.getText());
            mystatement.setString(4, jTextField3.getText());
            mystatement.setString(5, jTextField4.getText());
            SimpleDateFormat myformat=new SimpleDateFormat("YYY-MM-dd");
            String d=myformat.format(jDateChooser1.getDate());
            mystatement.setString(6, d);
            
            
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
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    
    jTextField1.setText("");
    jComboBox1.setSelectedItem("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jDateChooser1.setDate(null);
        
    }                                        
