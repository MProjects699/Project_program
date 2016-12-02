Connection myconnection=null;
    
    String path="jdbc:mysql://localhost/";
    String place="libman";
    
    try
    {
     myconnection=DriverManager.getConnection(path+place,"root","");
     String q="select max(username_id)from member_master";
     PreparedStatement mystatement=myconnection.prepareStatement(q);
     ResultSet myresult=mystatement.executeQuery();
     if(myresult.next())
     {
      do
      {
          int username_id=myresult.getInt(1);
          jTextField3.setText(String.valueOf(username_id+1));
      }
      while(myresult.next());
     }
    
     else
     {
         JOptionPane.showMessageDialog(rootPane,"Wrong Entry");
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