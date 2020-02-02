import javafx.application.Application;
import javafx.geometry.*; 
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;  
import javafx.stage.Stage;
import javafx.event.*; 
import javafx.scene.text.*;


public class SweepstakesJavaFX extends Application 
{
	private TextField first = new TextField();
	private TextField last = new TextField();
	private TextField phone = new TextField();
	private TextField email = new TextField();
	private TextField luckyNum = new TextField();
	private TextField dob = new TextField();
	public Label error = new Label();
	public Label title = new Label("Sweepstakes Entry Form\nPlease complete the fields below");
	
	public static void main(String[] args)
   	{
      	Application.launch(args);
   	}
   
	@Override
	public void start(Stage primaryStage) 
	{
		VBox labels = new VBox(); 
    	GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
    	labels.setAlignment(Pos.CENTER);
    	pane.setPadding(new Insets(10, 5, 5, 5)); 
    	labels.setPadding(new Insets(5, 5, 5, 5)); 
    	pane.setHgap(45.5);
    	pane.setVgap(20.5); 
      
      	title.setStyle("-fx-font-weight: bold; -fx-font-size:20;"); 
      	error.setStyle("-fx-text-fill: red;"); 
      
      	labels.getChildren().add(title);
      	labels.getChildren().add(error);  
      
      	pane.add(new Label("First Name: "), 0, 0);
      	pane.add(first, 1, 0); 
      	pane.add(new Label("Last Name: "), 0, 1); 
      	pane.add(last, 1, 1); 
      	pane.add(new Label("Phone Number: "), 0, 2); 
      	pane.add(phone, 1, 2);  
      	pane.add(new Label("Email Address: "), 0, 3); 
      	pane.add(email, 1, 3); 
      	pane.add(new Label("Lucky Number: "), 0, 4); 
      	pane.add(luckyNum, 1, 4); 
      	pane.add(new Label("Date of Birth: "), 0, 5); 
      	pane.add(dob, 1, 5); 
      
      	Button btnSubmit = new Button("Submit"); 
      	pane.add(btnSubmit,1,6); 
      	GridPane.setHalignment(btnSubmit, HPos.RIGHT); 
            
      	Scene scene = new Scene(new VBox(labels,pane), 450, 525);  
      	primaryStage.setTitle("Sign up form"); // Set the stage title
      	primaryStage.setScene(scene); // Place the scene in the stage
      	primaryStage.show(); // Display the stage
      
      	btnSubmit.setOnAction(new EventHandler<ActionEvent>()
      	{
        	@Override
         	public void handle(ActionEvent e)
         	{
            	String fName = first.getText(); 
            	String lName = last.getText(); 
            	String inPhone = phone.getText(); 
            	String inEmail = email.getText(); 
            	String inLuckyNum = luckyNum.getText(); 
            	String inDob = dob.getText(); 
            
            	error.setText("");
            	
            	// Call the validation methods here.   
               checkFirst(fName); 
               checkLast(lName); 
               checkPhone(inPhone);
               checkEmail(inEmail);  
               checkLuckyNum(inLuckyNum);
               checkDob(inDob);

            if (error.getText() == "")
            	{
               	primaryStage.hide();
               	resultsPage();
            	}
         	}    
});

     	

}
	
	public void checkFirst(String first)
  	{
      boolean f = first.matches("[A-Za-z]{2,}");  
     if(first.matches(""))
      {
         error.setText(error.getText() + "\n" + "First name required");
      }   
    else if(!f)
      {
         error.setText(error.getText() + "\n" + "First name invalid");
      }
          	
	}
	
	public void checkLast(String last)
   {
         
      	boolean l = last.matches("[A-Za-z]{2,}");
         if(last.matches(""))
         {
            error.setText(error.getText() + "\n" + "Last name required");
         }
         else if(!l)
         {
            error.setText(error.getText() + "\n" + "Last name invalid");
         }
	}
	
	public void checkPhone(String phone)
	{
      boolean p = phone.matches("[0-9]{3}[-][0-9]{3}[-][0-9]{4}");
      if(phone.matches(""))
      {
         error.setText(error.getText() + "\n" + "Phone number is required");
      }
      else if(!p)
      {
         error.setText(error.getText() + "\n" + "Phone number is invalid");
      }
		
	}
	
	public void checkEmail(String email)
   {
      boolean e = email.matches("[A-Za-z0-9._-].+[@][A-Za-z0-9._-].+[.][A-Za-z0-9].+");
      if(email.matches(""))
      {
         error.setText(error.getText() + "\n" + "Email is required");
      }
      else if(!e)
      {
         error.setText(error.getText() + "\n" + "Email is invalid");
      }
      
	}
	
	public void checkLuckyNum(String luckyNum)
   {
      boolean l = luckyNum.matches("[1-9]{1}([0-9]|[0][0]){0,1}");
      if(luckyNum.matches(""))
      {
         error.setText(error.getText() + "\n" + "Lucky number is required");
      }
      else if(!l)
      {
         error.setText(error.getText() + "\n" + "Lucky is invalid");
      }
      
	}
	
	public void checkDob(String dob)
   {
      boolean d = dob.matches("([0-9]{2}[/][0-9]{2}|[1-9]{1}[/][1-9]{1})[/]([1][9]|[2][0])[0-9]{2}");
      if (dob.matches(""))
      {
         error.setText(error.getText() + "\n" + "Date of birth is required");
      }
      else  if(!d)
      {
         error.setText(error.getText() + "\n" + "Date of birth  is invalid");
      }
      	
	}
   
  
	public void resultsPage() 
   	{
      	Stage resultsStage = new Stage(); 
      	VBox results = new VBox(); 
      	results.setAlignment(Pos.CENTER);
      	results.setPadding(new Insets(10, 5, 5, 5));
      
      	Label congrats = new Label("Congrats!");
      	Label display = new Label("The fields have been validated!");
      	congrats.setStyle("-fx-font-weight: bold; -fx-font-size:20; -fx-text-fill:blue;");
      	display.setStyle("-fx-font-weight: bold; -fx-font-size:20; -fx-text-fill:blue;");
      	results.getChildren().add(congrats); 
      	results.getChildren().add(display);
      
      	Scene scene = new Scene(results, 400, 400);  
      	resultsStage.setTitle("Results Page"); 
      	resultsStage.setScene(scene);
      	resultsStage.show(); 
   	}
}

