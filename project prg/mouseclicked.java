String book_id=jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
    Connection myconnection=null;
    
    String path="jdbc:mysql://localhost/";
    String place="libman";
    
    try
    {
     myconnection=DriverManager.getConnection(path+place,"root","");
     String q="select * from book_detail where book_id=?";
     PreparedStatement mystatement=myconnection.prepareStatement(q);
     mystatement.setString(1, book_id);
     
     ResultSet myresult=mystatement.executeQuery();
     if(myresult.next())
     {
         jTextField3.setText(myresult.getString("book_id"));
         jTextField4.setText(myresult.getString("category"));
         
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