Connection myconnection=null;
    
    String path="jdbc:mysql://localhost/";
    String place="libman";
    
    try
    {
     myconnection=DriverManager.getConnection(path+place,"root","");
     String q="delete from issue_book where member_id=?";
     PreparedStatement mystatement=myconnection.prepareStatement(q);
     mystatement.setString(1, jTextField5.getText());
     
     int b=JOptionPane.showConfirmDialog(rootPane, "Do you really want to delete?", "Are you Sure?", JOptionPane.YES_OPTION);
     
     if(b==JOptionPane.YES_OPTION)
     {
         int a=mystatement.executeUpdate();
         if(a>0)
         {
             JOptionPane.showMessageDialog(rootPane, "Deleted Successfully");
         }
         else
         {
             JOptionPane.showMessageDialog(rootPane,"Could not delete Successfully" );
         }
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