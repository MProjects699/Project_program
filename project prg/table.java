Connection myconnection=null;
        
        String path="jdbc:mysql://localhost/";
        String place="libman";
        try
        {
            myconnection=DriverManager.getConnection(path+place, "root", "");
            String q="Select * from member_master";
            PreparedStatement mystatement=myconnection.prepareStatement(q);
            String name,address,email,mobile,active_user,username_id;
            
            DefaultTableModel mymodel=(DefaultTableModel)jTable1.getModel();
            ResultSet myresult=mystatement.executeQuery();
            if(myresult.next())
            {
                do
                {
                    username_id=myresult.getString("username_id");
                    name=myresult.getString("name");
                    address=myresult.getString("address");
                    email=myresult.getString("email");
                    mobile=myresult.getString("mobile");
                    active_user=myresult.getString("active_user");
                    
                    mymodel.addRow(new Object[]{username_id,name,address,email,mobile,active_user});
                }
                while(myresult.next());
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
                JOptionPane.showMessageDialog(rootPane,"Could not close connection "+ e.getMessage());
            }     
        }