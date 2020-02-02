//David Arroyo, Sharon Velez, Jorge A. Garcia
//CS-200-01, Fall 2018
import java.util.Scanner ;

public class Yahtzee_PartIII {
   public static void main( String[] args ) {
      
     int countTurn = 0;
     int[][] scores = initializeScores();
     String[] description = createScoreDescriptions();
     int[]diceStatus= initializeDiceStatus();
     int player, score1, score2;
     
     while(countTurn < 2){
      int score, cat;
     
     if(countTurn % 2 == 0)
        player = 1;
      else
         player = 2; 
      printAllScores(player, description, scores); 
      System.out.println(); 
      oneTurn(player, diceStatus);
      System.out.println();
      cat = getCategory(player, scores);
      score = getScore();
      scores[player-1][cat-1] = score;
      System.out.println();
      countTurn++;
      }
      score1 = calculateSum(1, scores);
      score2 = calculateSum(1, scores);
      printGameResult(score1, score2);
      
      
   }
   //part 2
     public static void oneTurn ( int player , int [] diceStatus ) {
        diceStatus = initializeDiceStatus();
         int[] array = new int[5] ;
         int count = 0, check = 0;
         do {    
            System.out.print( "Player " + player + " - Dice roll: " ) ;
            roll( array , diceStatus ) ;
            printArray( array ) ;
            System.out.println() ;
            check = handleRollAgain( count , diceStatus ) ;
            count++ ;
         } while( count < 2 && check != 0 ) ; 
         if (check != 0){
            System.out.print( "Player " + player + " - Dice roll: " ) ;
            roll( array, diceStatus);
            printArray( array );
            System.out.println();
         } 
   }
   
   public static int  handleRollAgain ( int rolls , int [] diceStatus ) {
      Scanner kb = new Scanner( System.in ) ; 
      int num = 0 ;
      if( rolls <= 3 ) {
         System.out.println( "Do you want to roll again?" ) ;
         System.out.print("(0 - no, 1 - yes): " );
         num = kb.nextInt() ;
         if( num == 1 ) {
            System.out.print( "How many dice? " ) ;
            int numDice = kb.nextInt();
            setDiceStatusForRollAgain(numDice, diceStatus);
         }
      }
      return num ;    
   } 
   
   public static void setDiceStatusForRollAgain( int numDice , int[] diceStatus ) {
      Scanner kb = new Scanner( System.in ) ; 
      for( int i = 0 ; i < numDice ; i++ ) {
         System.out.print( "Which dice? Enter 1 - 5: " ) ;
         diceStatus[kb.nextInt() - 1] = 1;
      }
   } 
    
   public static void roll( int[] dice , int[] diceStatus ) {
      for( int i = 0 ; i < dice.length ; i++ ) {
         if( diceStatus[i] == 1 ) {
            dice[i] = (int) ( Math.random() * 6 ) + 1 ;     
            diceStatus[i] = 0 ; 
         }
      }
   }
   
   public static void printArray( int[] array ) {
      for( int i = 0 ; i < array.length ; i++ ) 
         System.out.print( array[i] + " "  ) ;
   }
   
   public static void printStringArray( String[] array ) {
      for( int i = 0 ; i < array.length ; i++ ) 
         System.out.println( array[i] + "  (" + (i+1) + ")"  ) ;
   }
   
   public static int [] initializeDiceStatus() {
      int[] array = { 1 , 1, 1 ,1 , 1} ;
      return array ;  
   }
  //part 1 
   public static String [] createScoreDescriptions() {
      String[] desc= { "Ones (sum 1s)" ,
      "Twos (sum 2s)" ,
      "Threes (sum 3s)" ,
      "Fours (sum 4s)" ,
      "Fives (sum 5s)" ,
      "Sixes (sum 6s)" ,
      "Three of a kind (sum all dice)" ,
      "Four of kind (sum all dice)" ,
      "Full House (25 points)" ,
      "Small Straight (30 points)" ,
      "Large Straight (40 points)" ,
      "Chance (sum all dice)" ,
      "Yahtzee (50 points)" ,
      }; 
      return desc ;
   }
   
   public static int getScore() {
      Scanner kb = new Scanner( System.in ) ;  
      System.out.print( "Enter score: " ) ;
      return kb.nextInt() ;
   }
   
   public static void printScoreValue( int score ) {
      if( score == -1 )
         System.out.println( "Score: N/A" ) ;
      else
         System.out.println( "Score: " + score ) ;      
   } 
   
   public static void printGameResult( int sum1 , int sum2 ) {
      System.out.println( "Player 1: " + sum1 ) ;
      System.out.println( "Player 2: " + sum2 ) ;
      if( sum1 > sum2 ) 
         System.out.println( "Player 1 wins!" ) ;
      else if( sum1 < sum2 )
         System.out.println( "Player 2 wins!" ) ;
      else
         System.out.println( "It's a tie!" ) ;         
   }
//part 3   
   public static int[][] initializeScores(){
      int[][] arr = new int[2][13];
      
      for(int i = 0; i < arr.length; i++){
         for(int j = 0; j < arr[0].length; j++){
            arr[i][j] = -1;
         
         }
      }
     return arr;
   }
   
   public static int getCategory(int player, int[][] scores){
     Scanner kbd = new Scanner(System.in);
     
      boolean check = false;
      int input = 0;
      
      while(check == false){
         System.out.print("Enter a category for scoring (1 - 13): ");
         input = kbd.nextInt();
         
         if(scores[player - 1][input - 1] == -1){
            check = true;
         }else{
           System.out.println("Category already has a score.");
         }
      }   
     return input; 
   
   }
   
   public static void printAllScores(int player, String[] descriptions, int[][] scores){
      System.out.println("Player " + player + " Categories/Current Scores:");
      for( int i = 0; i < descriptions.length; i++){
         System.out.print(descriptions[i] + "   (" + (i + 1) +")    "); 
         printScoreValue(scores[player-1][i]);
         }
      }
      
  public static int calculateSum(int player, int[][] finalScores){
   int sum = 0;
   for(int i = player - 1; i < player; i++){
      for(int j = 0; j < finalScores[0].length-1; j++){
         sum += finalScores[i][j];
      }
   } 
   return sum;
  }
}