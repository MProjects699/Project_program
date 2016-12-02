Calendar cal1=new GregorianCalendar();
     Calendar cal2=new GregorianCalendar();
        SimpleDateFormat myformat=new SimpleDateFormat("yyyy-MM-dd");
        String d1=myformat.format(jDateChooser1.getDate());
        String d2=myformat.format(jDateChooser2.getDate());
        try
        {
            java.util.Date dt1=myformat.parse(d1);
            java.util.Date dt2=myformat.parse(d2);
            cal1.setTime(dt1);
            cal2.setTime(dt2);
            
        }
        catch(Exception e)
        {
                    JOptionPane.showMessageDialog(rootPane,e.getMessage());      
        }
        JOptionPane.showMessageDialog(rootPane, "Days=" + daysBetween(cal1.getTime(),cal2.getTime()));
    }                                        

    public  int daysBetween(java.util.Date d1,java.util.Date d2)
    {
        {
        return (int)((d2.getTime()-d1.getTime())/(1000*60*60*24));
        //return 0;
        
    }