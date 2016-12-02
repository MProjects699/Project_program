public void actionPerformed(ActionEvent e) 
{
    try {
              MessageFormat headerFormat = new MessageFormat("Page {0}");
              MessageFormat footerFormat = new MessageFormat("- {0} -");
              table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            } 
	catch (PrinterException pe) 
	{
              System.err.println("Error printing: " + pe.getMessage());
        }
}