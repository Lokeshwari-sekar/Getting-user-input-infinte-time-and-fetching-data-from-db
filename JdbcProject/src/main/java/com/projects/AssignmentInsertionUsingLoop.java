package com.projects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AssignmentInsertionUsingLoop {

	public static void main(String[] args)
	{
		int seatno, psmobno;
		String psname,seattype;
		Scanner sc= new Scanner(System.in);

		int input=0;//looping logic
		int count=1;//which primary key next we insert...
		while(input==0)
		{
			System.out.println("start seat number from "+count);
			//user input
			System.out.println("Enter the seat no");
			seatno=sc.nextInt();
			System.out.println("Enter the passanger name");
			psname=sc.next();
			System.out.println("Enter the passanger mobile no");
			psmobno=sc.nextInt();
			System.out.println("Enter the seat type");
			seattype=sc.next();

			//jdbc connection
			String driverlink="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/transport";
			String username="root";
			String password="root";

			try
			{
				Class.forName(driverlink);
				Connection con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();
				String insert="insert into passangers_detail values ("+seatno+","+psname+","+psmobno+","+seattype+")";
				int i=st.executeUpdate(insert);
				if(i>0)
				{
					System.out.println("inserted successfully");
					System.out.println("again you want to insert type '0' or if you want to exit type '1'");
					input=sc.nextInt();
					if(input==0)
					{
						input=0;
						count=count+1;
					}
					else
					{
						System.out.println("thank you");
						break;
					}
				}
				else
				{
					System.out.println("not inserted");
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();

			}
		}
	}
}
