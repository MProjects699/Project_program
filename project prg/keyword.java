Connection myconnection=null;
        
        String path="jdbc:mysql://localhost/";
        String place="libman";
        try
        {
            myconnection=DriverManager.getConnection(path+place, "root", "");
            String q="Select * from book_detail where title like '%"+jTextField1.getText()+"%'";
            PreparedStatement mystatement=myconnection.prepareStatement(q);
            String category,title,author,mobile,publisher,book_id;
            
            DefaultTableModel mymodel=(DefaultTableModel)jTable1.getModel();
            ResultSet myresult=mystatement.executeQuery();
            if(myresult.next())
            {
                mymodel.setRowCount(0);
                do
                {
                    book_id=myresult.getString("book_id");
                    category=myresult.getString("category");
                    title=myresult.getString("title");
                    author=myresult.getString("author");
                    publisher=myresult.getString("publisher");
                    //year_publish=myresult.getString("year_publish");
                    
                    mymodel.addRow(new Object[]{book_id,category,title,author,publisher});
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