private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    
        Connection myconnection=null;
        String path="jdbc:mysql://localhost/";
        String place="libman";
        try
        {
            myconnection=DriverManager.getConnection(path+place,"root","");
            String q="select username from login where username=? and password=?";
            PreparedStatement mystatement=myconnection.prepareStatement(q);
            mystatement.setString(1, jTextField1.getText());
            mystatement.setString(2, jPasswordField1.getText());
            ResultSet myresult=mystatement.executeQuery();
            
            if(myresult.next())
            {
                
            MainForm1 b=new MainForm1();
            b.setVisible(true);
            b.setExtendedState(MAXIMIZED_BOTH);
            this.dispose();
            
            }
           else
            {
                    
            JOptionPane.showMessageDialog(rootPane," Invalid User");
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
                JOptionPane.showMessageDialog(rootPane,"Could not Close"+e.getMessage());
            }