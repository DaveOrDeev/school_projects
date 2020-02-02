
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.sound.sampled.*;

public class AudioRecorder extends Application
{
	private AudioFormat audioFormat;
  	private TargetDataLine targetDataLine;
  	
	@Override
    public void start(Stage primaryStage)
    {
    	Button startButton = new Button("Start");
    	Button stopButton = new Button("Stop");
    	startButton.setLayoutX(40);
    	startButton.setLayoutY(40);
    	startButton.setDisable(false);
    	stopButton.setLayoutX(100);
    	stopButton.setLayoutY(40);
    	stopButton.setDisable(true);
    	
    	 startButton.setOnAction((ActionEvent e) -> {
    		//write code here
         startButton.setDisable(true);
         stopButton.setDisable(false);
         recordAudio();//0======================

    	}); 
    	
    	 stopButton.setOnAction((ActionEvent e) -> {
    		//write code here
         startButton.setDisable(false);
         stopButton.setDisable(true);
         targetDataLine.stop();//=================
        targetDataLine.close();//==================
         
         
    	}); 
    	
    	Pane pane = new Pane();
    	Text text = new Text(20, 20, "Microphone recorder");
    	pane.getChildren().addAll(text, startButton, stopButton);
    	
    	Scene scene = new Scene(pane, 300, 100);
    	primaryStage.setTitle("Audio Recorder");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	
    	primaryStage.setOnCloseRequest((WindowEvent e) -> {
        	Platform.exit();
		});	
    }
    
    private void recordAudio()
    {
      this.audioFormat = new AudioFormat(8000.0F, 16, 1, true, false);
    	DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
      try
      {
         this.targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
      }catch(LineUnavailableException e){
         e.printStackTrace();
         System.exit(0);
      }
      RecordingThread recThread = new RecordingThread();//===============
      recThread.start();//===============
      
      
      
    }
  	
  	protected class RecordingThread extends Thread 
  	{
  		@Override
  		public void run()
  		{
    		AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
         File audioFile = new File("MyRecording.wav");
         try
         {
            targetDataLine.open(audioFormat);
            targetDataLine.start();
            AudioInputStream stream = new AudioInputStream(targetDataLine);
            AudioSystem.write(stream, fileType, audioFile);
         }catch(LineUnavailableException e){
             e.printStackTrace();
             System.exit(0);
         }catch(IOException e1){
             e1.printStackTrace();
             System.exit(0);
         }
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
