
package transitiongraphautomata;

import java.util.Scanner;


public class TransitionGraphAutomata {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Number of states :");
        int nummberOfStates = sc.nextInt();
        
        //---------------------------------------------------------------------------------------
        
        System.out.print("Enter the number of final states elements you want to store: ");  
        //reading the number of elements from the that we want to enter  
        int n=sc.nextInt();  
        //creates an array in the memory of length 10  
        Integer[] finalStatesArray = new Integer[n];  
        System.out.println("Enter the fianl states elements array one by one ");  
        for(int i=0; i<n; i++)  
        {  
        //reading array elements from the user   
        finalStatesArray[i]=sc.nextInt();  
        }        
        //-----------------------------------------------------------------------------------------
        
        TranstionObject arr[][] = new TranstionObject[nummberOfStates][];
        for(int i=0; i<nummberOfStates; i++)
        {
            System.out.print("How many objects/columns you have at row" + i + " : ");
            int nummberOfColumnsAtEachState = sc.nextInt();
            arr[i] = new TranstionObject[nummberOfColumnsAtEachState];
        }
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print("Enter object you have at [row][column] = [" + i + "]" + "[" + j + "]" + " example 0,b : ");
                String obj = sc.next();
                String[] arrOfStr = obj.split(",", 2);
//                arr[i][j].state = Integer.parseInt(arrOfStr[0]);
//                arr[i][j].word = arrOfStr[1];
                    
                arr[i][j] = new TranstionObject(arrOfStr[1], Integer.parseInt(arrOfStr[0]));
            }
        }
        System.out.println("Contents of 2D Jagged Array");
        for (int i = 0; i < arr.length; i++) {
            
            System.out.print(i + " row" + " | ");
            for (int j = 0; j < arr[i].length; j++)
                System.out.print("{" + arr[i][j].state + "," + arr[i][j].word + "} ");
            System.out.println();
        }
            
                
        
        
        
        
    }
    
}

class TranstionObject
{

    public TranstionObject(String word, Integer state) {
        this.word = word;
        this.state = state;
    }
    public String word;
    public Integer state;
    
}
