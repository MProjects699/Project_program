 Connection myconnection=null;
        
        String path="jdbc:mysql://localhost/";
        String place="libman";
        try
        {
            myconnection=DriverManager.getConnection(path+place, "root", "");
            String query="insert into member_master(username_id,name,address,email,mobile,active_user) values(?,?,?,?,?,?)";
            PreparedStatement mystatement=myconnection.prepareStatement(query);
            mystatement.setString(1, jTextField3.getText());
            mystatement.setString(2, jTextField2.getText());
            mystatement.setString(3, jTextArea1.getText());
            mystatement.setString(4, jTextField1.getText());
            mystatement.setString(5, jFormattedTextField2.getText());
            if(jCheckBox1.isSelected());
                {
                    mystatement.setString(6,"Y");
                }
                
                //{
                  //  mystatement.setString(6,"N");
                //}
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