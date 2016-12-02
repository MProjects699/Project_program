Connection myconnection=null;
    String path="jdbc:mysql://localhost/";
    String place="libman";
    try
    {
        myconnection=DriverManager.getConnection(path+place,"root","");
        String query="update member_master set name=?,address=?,email=?,mobile=? where username_id=?";
        PreparedStatement mystatement=myconnection.prepareStatement(query);
            
            mystatement.setString(1, jTextField2.getText());
            mystatement.setString(2, jTextArea1.getText());
            mystatement.setString(3, jTextField1.getText());
            mystatement.setString(4, jFormattedTextField2.getText());
            mystatement.setString(5, jTextField3.getText());
            
            
            mystatement.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"update Successfully ");
            
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