      Connection myconnection=null;
        
        String path="jdbc:mysql://localhost/";
        String place="collegedb";
        try
        {
            myconnection=DriverManager.getConnection(path+place, "root", "");
            String query="insert into student_table(name,fname,address,phone) values(?,?,?,?)";
            PreparedStatement mystatement=myconnection.prepareStatement(query);
            mystatement.setString(1, jTextField1.getText());
            mystatement.setString(2, jTextField2.getText());
            mystatement.setString(3, jTextArea1.getText());
            mystatement.setString(4, jFormattedTextField1.getText());
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
        
        