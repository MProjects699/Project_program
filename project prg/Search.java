Connection myconnection=null;
    
    String path="jdbc:mysql://localhost/";
    String place="libman";
    
    try
    {
     myconnection=DriverManager.getConnection(path+place,"root","");
     String q="select * from member_master where username_id=?";
     PreparedStatement mystatement=myconnection.prepareStatement(q);
     mystatement.setString(1, jTextField3.getText());
     
     ResultSet myresult=mystatement.executeQuery();
     if(myresult.next())
     {
         jTextField2.setText(myresult.getString("name"));
         jTextArea1.setText(myresult.getString("address"));
         jTextField1.setText(myresult.getString("email"));
         jFormattedTextField2.setText(myresult.getString("mobile"));
         jCheckBox1.setSelected(true);
     }
     else
     {
         JOptionPane.showMessageDialog(rootPane,"Wrong Id");
     }
     
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
            JOptionPane.showMessageDialog(rootPane,"Could not close"+ e.getMessage());
        }
    }