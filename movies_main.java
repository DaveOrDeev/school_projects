
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
public class movies_main {

	public static void main(String[] args) {
		
		try {
		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","root");
			Statement stmt=con.createStatement();
			//inserting the data
			/*File f = new File("MovieDatabase.csv");
			Scanner in = new Scanner(f);
			//int count = 0;
			int id = 0;
			while(in.hasNextLine())
			{
				
				String q1 = "Insert Into Movie Values (" + id + ", ";
				String q2 = "Insert Into Director Values (" + id + ", ";
				String q3 = "Insert Into LeadActor Values (" + id + ", ";
				String q4 = "Insert Into SupActor Values (" + id + ", ";
				
				String s = in.nextLine();
				String[] line = s.split(",");
				
				for(int i = 0; i < line.length; i++)
				{
					
					if((i == 0|| i == 1|| i == 3 || i == 4 ))
					{
						q1 = q1 + "'" + line[i] + "'" + ", ";
					}
					else if(i < 9)
					{
						q1 = q1 + line[i] + ", ";
					}
					else if(i == 9)
					{
						q1 = q1 + "'" + line[i] + "'" + ", ";
						q2 = q2 + "'" + line[i] + "'" + ", ";
					}
					else if(i == 10)
					{
						q2 = q2 + line[i];
					}				
					else if(i == 11)
					{
						q1 = q1 + "'" + line[i] + "'" + ", ";
						q3 = q3 + "'" + line[i] + "'" + ", ";
					}
					else if(i == 12)
					{
						q3 = q3 + line[i];
					}		
					else if(i == 13)
					{
						q1 = q1 + "'" + line[i] + "'";
						q4 = q4 + "'" + line[i] + "'" + ", ";
					}
					else
					{
						q4 = q4 + line[i];
					}
					
				}
				q1 = q1 + ");";
				q2 = q2 + ");";
				q3 = q3 + ");";
				q4 = q4 + ");";
				
				
				Boolean ret1 = stmt.execute(q1);
				Boolean ret2 = stmt.execute(q2);
				Boolean ret3 = stmt.execute(q3);
				Boolean ret4 = stmt.execute(q4);
				id++;
			}
		*/
						
			System.out.println("Hi, welcome to our movie database.");
			
			Scanner kb = new Scanner(System.in);
			boolean cont = true;
			
			while(cont) {
				System.out.println("Please select one of the following queries by inputing the number that before the description");
				System.out.println("Enter 0 to exit the program");
				System.out.println("1) Which movies are only in black & white and what year were they created?");
				System.out.println("2) What is the IMDB Score on the movie with the lowest budget?");
				System.out.println("3) What is the IMDB Score on the movie with the highest budget?");
				System.out.println("4) Find the movie titles with the Director having the least amount of Facebook Likes.");
				System.out.println("5)  Display lead actor (insert actor name here) movies and list them by IMDB Rating in ascending order.");
				System.out.println("6) Display the movies where the supporting actor starred in the least amount of movies and list them by title in descending order.");
				System.out.println("7) Find the average movie duration grouped by rating in ascending order.");
				System.out.println("8) Find the average movie gross income grouped by country in ascending order (by average gross)");
				System.out.println("9) List all the movies that are longer than the average movie duration");
				System.out.println("10) Display all movies directed by (insert director name here) in ascending order.");
				int q = kb.nextInt();
				
				String query = "";
				
				if(q == 0)
					cont = false;
				else if(q == 1)
				{
					query = "SELECT MovieTitle, TitleYear FROM Movie WHERE Color != 'Color';";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {
						String mt = rs.getString("MovieTitle");
						int my = rs.getInt("TitleYear");
						System.out.println(mt + " " + my);
						
					}
					
				}
				else if(q == 2)
				{
					String prequery = "SELECT MIN(Budget) From Movie; ";
					ResultSet rs = stmt.executeQuery(prequery);
					while(rs.next())
					{
						int min = rs.getInt("Min(Budget)"); 	
						String s = "" + min;
						query = "SELECT MovieTitle, IMDBScore FROM Movie Where Budget = " + s +"; ";
						 rs = stmt.executeQuery(query);
						while(rs.next())
						{
							s = rs.getString("MovieTitle");
							double d = rs.getDouble("IMDBScore");
							System.out.println(s + " " + d);
							
						}
						
					}
					
					

				}
				else if(q == 3)
				{
					String prequery = "SELECT Max(Budget) From Movie; ";
					ResultSet rs = stmt.executeQuery(prequery);
					while(rs.next())
					{
						int max = rs.getInt("Max(Budget)"); 	
						String s = "" + max;
						query = "SELECT MovieTitle, IMDBScore FROM Movie Where Budget = " + s +"; ";
						rs = stmt.executeQuery(query);
						while(rs.next())
						{
							s = rs.getString("MovieTitle");
							double d = rs.getDouble("IMDBScore");
							System.out.println(s + " " + d);	
						}
					}

				}
				else if(q == 4)
				{
					query = "SELECT distinct M.MovieTitle FROM Movie as M, Director as D WHERE M.DirName = D.DName AND D.DFBLikes  = (Select Min(DFBLikes) From Director);";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						String s = rs.getString("MovieTitle");
						System.out.println(s);	
					}
				}
				else if(q == 5)
				{
					System.out.println("Please insert the actor's first and last name");
					String s = kb.next() + " " + kb.next();
					query = "SELECT Distinct M.MovieTitle FROM Movie AS M, LeadActor AS LA WHERE M.LeadName = LA.LAName AND LA.LAName = \""  +  s + "\" ORDER BY IMDBScore ASC;";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						s = rs.getString("M.MovieTitle");
						System.out.println(s);	
					}
				}
				else if(q == 6)
				{
					query = "SELECT distinct M.MovieTitle FROM Movie AS M, SupActor AS SA GROUP BY SA.SupName ORDER BY M.MovieTitle DESC;";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						String s = rs.getString("M.MovieTitle");
						System.out.println(s);	
					}
				}
				else if(q == 7)
				{
					query = "SELECT ContentRating, AVG(Duration) FROM Movie GROUP BY ContentRating Order by ContentRating ASC;";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						String s = rs.getString("ContentRating");
						double d = rs.getDouble("AVG(Duration)");
						System.out.println(s + " " + d);	
					}
				}
				else if(q == 8)
				{
					query = "SELECT Country, AVG(Gross) FROM Movie GROUP BY Country ORDER BY AVG(Gross) ASC;";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						String s = rs.getString("Country");
						double d = rs.getDouble("AVG(Gross)");
						System.out.println(s + " " + d);	
					}
				}
				else if(q == 9)
				{
					query = "SELECT MovieTitle FROM Movie WHERE Duration > (SELECT AVG(Duration) FROM Movie);";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						String s = rs.getString("MovieTitle");
						System.out.println(s);	
					}
				}
				else if(q == 10)
				{
					System.out.println("Please insert the Director's name");
					String s = "'" + kb.next() + " " + kb.next() + "'";
					query = "Select distinct M.MovieTitle From Movie AS M, Director AS D Where D.DName = M.DirName AND D.DName = " + s +  " Order by MovieTitle ASC;";
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next())
					{
						s = rs.getString("M.MovieTitle");
						System.out.println(s);	
					}
				}
				
				System.out.println();
				System.out.println();
				System.out.println();
				

			}
			
			
			
		
		con.close();
		}
		/*(FileNotFoundException q) {
			System.out.println(q);
		}*/catch(Exception e) {
			System.out.println(e);
		}
	
	
	
		
	}
}
