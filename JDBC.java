/* =======================================================================
   A generic GUI for the JDBC project

   Author: Shun Yan Cheung

   To compile the project: 

	javac JDBC.java

   To run the project: 

	java -cp ".:/home/cs377001/lib/mysql-connector-java.jar" JDBC
   ======================================================================= */
/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Naomi Keusch Baker */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;
 import java.util.Scanner;

public class JDBC  
{
   public static JFrame mainFrame;

   /* ***************************************************************
      The class variables (defined using static) defined in this area
      can be accessed by other "call back" classes

      You can define your SHARED program variables below this line

      SHARED variables are variables that you need to use in
      MULTIPLE methods

      (If you ONLY use a variable inside ONE method, define that
       variable as a LOCAL variable inside THAT method)
      *************************************************************** */

   /* *********************************************************
      TODO 1: Define you SHARED program variables here

	      SHARED variables are variables that will can 
	      be used by methods in *different* classes
      ********************************************************* */




   /* ********************************************************************
      End area where you define your SHARED program variables
      ******************************************************************* */

   /* vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
      This area contain SHARED object variables for the GUI application

      Do NOT make any changes to the variable sections below
      You can use these GUI variables to code your GUI application:

	Input:  a JTextArea object
		Input.getText() will return the SQL query that you
		need to execute
	Output:  a JTextArea object
		(1) Use Output.setText("") to clear the text area
		(2) Then use Output.append( ... ) to print text
		    Use Output.append("\n") to advance to next line

	DBName: a JTextField object. 
		DBName.getText() will return the database name
	Select: a JButton object.
		Activate this object to process "Select database" function
	Execute: a JButton object.
		Activate this object to process "Execute query" function

	Column: a JTextField object.
		Column.getText() will return the column number
	Max: a JButton object.
		Activate this object to process "Max" function
	Min: a JButton object.
		Activate this object to process "Min" function
	Avg: a JButton object.
		Activate this object to process "Avg" function
	Median: a JButton object.
		Activate this object to process "Median" function
      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */

   /* ==========================================================
      The query input area
      ========================================================== */
   public static JTextArea Input = new JTextArea();   // Query input !!!
                                                      // Get the query text here

   /* ==========================================================
      The query output area
      ========================================================== */
   public static JTextArea Output = new JTextArea();  // Query output !!
                                                      // Print tuples here

   /* ==========================================================
      The TOP-RIGHT panel things
      ========================================================== */
   // Database label and name
   public static JLabel DBLabel = new JLabel("Database: ");
   public static JTextField DBName = new JTextField();     // Database name !!

   // The database selection button
   public static JButton Select = new JButton("Select");   // Select button !!

   // The query execution button
   public static JButton Execute = new JButton("Execute"); // Execute button !!


   /* ==========================================================
      The BOTTON-RIGHT panel things
      ========================================================== */
   // The column selection field
   public static JLabel ColumnLabel = new JLabel("Column: ");
   public static JTextField Column = new JTextField();       // Column number !!

   // The MAX output field  and button
   public static JTextField MaxText = new JTextField();
   public static JButton Max = new JButton("Maximum");       // Max button !!

   // The MIN output field  and button
   public static JTextField MinText = new JTextField();
   public static JButton Min = new JButton("Minimum");       // Min button !!

   // The Average output field  and button
   public static JTextField AvgText = new JTextField();
   public static JButton Avg = new JButton("Average");       // Avg button !!

   // The Median output field  and button
   public static JTextField MedianText = new JTextField();
   public static JButton Median = new JButton("Median");     // Median button !!



   /* ********************************************************************
      The main program
      ******************************************************************** */
   public static void main( String[] args )
   {
      /* ===============================================
	 Make the window
         =============================================== */
      MakeGUIWindow();


      /* =====================================================
	 Make the Select button active:
         ===================================================== */
      Select.addActionListener(new SelectListener() );
		// Make Select button execute the actionPerform() method
		// inside the class SelectListener (see below)

      /* **********************************************************
	 TODO 2: make the OTHER buttons active 
                 (Execute, Max, Min, Avg, Median)

		 Make the buttons perform the functions given in HW
         ********************************************************** */

       // I did this in class....
       Execute.addActionListener(new myExecuteClass() );






   }


   // I did this in class....
   static class myExecuteClass implements ActionListener            
   {
      public void actionPerformed(ActionEvent e)
      {
	 String s;

	 s = Input.getText( );

	 Output.setText("");

	 for (int i = 0; i < 4; i++ )
	 {
	    Output.append(s);
	    Output.append("\n");
	 }

      }
   }


   /* ===============================================================
      ***** Sample "call back" class

      Listener class for the Select button
      =============================================================== */
   static class SelectListener implements ActionListener            
   {  
      /* =============================================================
         The "actionPerformed( )" method will be called
	 when a button is pressed

	 You must ASSOCIATE a button to this class using this call:

	    ButtonObject.addActionListener( new SelectListener( ) )
         ============================================================= */
      public void actionPerformed(ActionEvent e)
      {  
	 /* ===========================================================
	    You must replace these statements with statements that
	    perform the "SELECT button" function:

		1. make a connection to the database server
		2. allocate statement object to prepare for 
                   query execution
	    =========================================================== */

         // =============================================================
         // Dummy statements to show that the activation was successful
         // =============================================================
	 Connection SQLconnection;  

 	 try {SQLconnection = DriverManager.getConnection (
                    "jdbc:mysql://holland.mathcs.emory.edu:3306/",    
		    "cs377",
		    "abc123");
	  }
	catch(SQLException t) {
		System.out.println("Error: Cannot load mySQL JDBC driver.");
	}

	Connection conn = null;	
	String url = "jdbc:mysql://holland.mathcs.emory.edu:3306/";	
        try {   
   	   conn = DriverManager.getConnection(url,"cs377","abc123"); 
        }
        catch ( SQLException t ) {
           System.out.println("Error: Cannot connect to database.");
	   System.exit(1);
        }			   

			      
   	/* ==============================================
           Create a Statement object to process queries
	   ============================================== */
        Statement stmt = null;
        try {   
   	   stmt = conn.createStatement (); 
        }
        catch ( SQLException t ) {
           System.out.println("Error: Cannot create SQL statement object.");
	   System.exit(1);
        }

	/* ==============================================================
            Start the infinite loop to:
              1. Read an SQL query
              2. Execute the Query
              3. Print the attribute names (meta data)
              4. Print the rows
            =============================================================== */
   	 Boolean done = false;
Scanner in = new Scanner(System.in);
    
   	 while ( ! done )
   	 {
   	    String s;
    
   	    System.out.print("\nmyCli>> ");
   	    s = in.nextLine();                    // Read SQL command  
    
            /* ============================================
               Check if user wants to exit....
               ============================================ */
   	    if ( s.equalsIgnoreCase("exit") )
   	    {
   	       done = true;
   	       continue;
   	    }
    
   	    try
   	    {
   	       ResultSet rset = stmt.executeQuery( s );      // Exec query
    
   	       ResultSetMetaData meta = rset.getMetaData();  // Get meta data
    
   	       int NCols = meta.getColumnCount();
   
   	       /* ===================================================
   		  **** Print the column names before any data ****
   		  =================================================== */
   	       for ( int i = 1; i <= NCols; i++ )
   	       {
   		  String name;
    
   		  name = meta.getColumnName(i);
   		  System.out.print( name + "\t" );  // Print field name
   	       }
   	       System.out.println();
    
               /* ---------------------------------
                 Print a dividing line....
		 --------------------------------- */
   	       System.out.println(
                    "====================================================");
   
   	       /* ===========================================
   		  Fetch and print one row at a time....
   		  =========================================== */
   	       while ( rset.next () )    // Advance to next row
   	       {
   		  /* ===========================================
   		     Fetch the columns (attributes) from a row
   		     =========================================== */
   		  for(int i = 1; i <= NCols; i++)
   		  {
   		     String nextItem;
    
   		     nextItem = rset.getString(i);
   		     System.out.print(nextItem + "\t");
   		  }
   		  System.out.println();
    
   		}
    
   		rset.close();           // Free result set buffers 
   	    }
 

	catch ( SQLException t ) {
		System.out.println("Error: " + t.getMessage() );  // Print error message
        }
}

	 try
   	 {
   	    stmt.close();        // Free Statement object resources
   	    conn.close();        // Close SQL server connection    
   	 }
   	 catch (Exception t)
   	 {
   	    System.out.println(t.getMessage()); // Print the error message
   	 }	


         System.out.println("The method actionPerformed"); 
         System.out.println("in the class SelectListener was called\n");
      }
   }

   /* ===============================================================
      TODO 3:
      ***** Write OTHER "call back" classes here for other buttons
            (Execute, Max, Min, Avg, Median)
      =============================================================== */




   static class myExecuteClass implements ActionListener            
   {
      public void actionPerformed(ActionEvent e)
      {
	 String s;

	 s = Input.getText( );

	 Output.setText("");

	 for (int i = 0; i < 4; i++ )
	 {
	    Output.append(s);
	    Output.append("\n");
	 }

      }
   }




	





  /* **********************************************************
     This section of the program makes the GUI

     DO NOT make any changes to the code below !!!
     ********************************************************** */

   /* ===============================================================
      Make GUI window
      =============================================================== */
   public static void MakeGUIWindow()
   {
      Font ss_font = new Font("SansSarif",Font.BOLD,16) ;
      Font ms_font = new Font("Monospaced",Font.BOLD,16) ;

      JPanel P1 = new JPanel();   // Top panel
      JPanel P2 = new JPanel();

      P1.setLayout( new BorderLayout() );
      P2.setLayout( new BorderLayout() );

      /* =============================================
         Make top panel
         ============================================= */
      JScrollPane d1 = new JScrollPane(Input, 
                                       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      Input.setFont( ss_font );

      JPanel s1 = new JPanel(); // Side panel
      s1.setLayout( new GridLayout( 8,1 ) );
      s1.add( DBLabel );
      s1.add( DBName );
      DBName.setEditable(true);
      DBName.setFont( ss_font );
      s1.add( Select );
      s1.add( Execute );
      Execute.setPreferredSize(new Dimension(140, 30)) ;

      P1.add(d1, "Center");
      P1.add(s1, "East");

      /* =============================================
         Make bottom panel
         ============================================= */
      JScrollPane d2 = new JScrollPane(Output, 
                                       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,
                                       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

      Output.setFont( ms_font );
      Output.setEditable(false);

      JPanel s3 = new JPanel(); // Put ColumnLabel and Column on 1 row
      s3.add(ColumnLabel);
      s3.add(Column);
      Column.setFont( ss_font );

      Column.setPreferredSize(new Dimension(40, 30)) ;

      JPanel s2 = new JPanel(); // Side panel
      s2.setLayout( new GridLayout( 10,1 ) );
      s2.add( s3 );

      MaxText.setPreferredSize(new Dimension(140, 30)) ;
      s2.add( MaxText );
      MaxText.setFont( ss_font );
      MaxText.setEditable(false);
      s2.add( Max );

      s2.add( MinText );
      MinText.setFont( ss_font );
      MinText.setEditable(false);
      s2.add( Min );

      s2.add( AvgText );
      AvgText.setFont( ss_font );
      AvgText.setEditable(false);
      s2.add( Avg );

      s2.add( MedianText );
      MedianText.setFont( ss_font );
      MedianText.setEditable(false);
      s2.add( Median );


      P2.add(d2, "Center");
      P2.add(s2, "East");

      mainFrame = new JFrame("CS377 JDBC project");
      mainFrame.getContentPane().setLayout( new GridLayout(2,1) );
      mainFrame.getContentPane().add( P1 );
      mainFrame.getContentPane().add( P2 );
      mainFrame.setSize(900, 700);

      /* =================================================
         Exit application if user press close on window

         This will clean up the network connection....
         ================================================= */
      // mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      mainFrame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent we) {
             System.out.println("\nGood-bye.Thanks for using CS377-sql...\n");
             System.exit(0);
          }
      });


      mainFrame.setVisible(true);
   }
}
