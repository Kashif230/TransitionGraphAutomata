
package transitiongraphautomata;

import java.util.Scanner;
import java.util.Stack;


public class TransitionGraphAutomata {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total Number of states :");
        int nummberOfStates = sc.nextInt();
        
        //---------------------------------------------------------------------------------------
        
        System.out.print("Enter the number of final states elements you want to store: ");  
        //reading the number of elements from the that we want to enter  
        int dd=sc.nextInt();  
        //creates an array in the memory of length 10  
        Integer[] finalStatesArray = new Integer[dd];  
        System.out.println("Enter the fianl states elements array one by one ");  
        for(int i=0; i<dd; i++)  
        {  
        //reading array elements from the user   
        finalStatesArray[i]=sc.nextInt();  
        }        
        //-----------------------------------------------------------------------------------------
        
        TranstionObject arr[][]= new TranstionObject[nummberOfStates][];
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
            
        //-------------------------------------------------------------------------------------------- Algorithm
        
        
        
        
       boolean tt = true; 
       Stack<Integer> stack1= new Stack<Integer>();
       Stack<String> stack2= new Stack<String>();
       System.out.println("Enter Number of Initial States");
       int numberOfInitialStates = sc.nextInt();
       Integer[] ia = new Integer[numberOfInitialStates];
       System.out.println("Now enter initial states one by one : ");
       for(int i =0; i<numberOfInitialStates;i++)
       {
           ia[i]= sc.nextInt();
       }
       System.out.println("Enter Number of Final States");
       int numberOfFinalStates = sc.nextInt();
       Integer[] fa = new Integer[numberOfFinalStates];
       System.out.println("Now enter final states one by one : ");
       for(int i =0; i<numberOfInitialStates;i++)
       {
           fa[i]= sc.nextInt();
       }
       Integer m,n =0,var1,var2;
       String t="";
       System.out.println("Enter input for checking with above Transition automato which you given.");
       String input = sc.next();
       
       
       for(int iaa=0;iaa<ia.length;iaa=iaa+1)
       {
           n=0;
           int a = ia[iaa];
           int kk=0;
           do{
           do
           {
               for(int i=a;i<a+1;i++)
               {
                   
                   for(int j=n; j<arr[i].length;j++)
                   {
                       third:{  
                     
                     if(kk+arr[i][j].word.length()<=input.length())  // 3<=4&&       4<=4     5<=4    6<=4
                     {
                         if(tt) break third;
                     }
                       
                     
                     String s= input.substring(kk,kk+arr[i][j].word.length());
                     if(s==arr[i][j].word)
                     {
                         stack1.push(arr[i][j].state);
                         kk=kk+arr[i][j].word.length();
                         a=arr[i][j].state;
                         stack2.push(arr[i][j].word);
                         n=0;
                         break;
                         
                     }
                     
                       }//third
                     
                       
                   } break;
                   
               }
           }while(kk<input.length());
           
           for(int y=0; y<dd; y++)
           {
               if(finalStatesArray[y]==a)
               {
                   System.out.println("Correct Input");
               }
           }
           
           five:{
           do{
           var1=stack1.peek();
           stack1.pop();
           if(stack1.isEmpty()==false)
           {
               var2=stack1.peek();
               stack1.push(var1);
           }
           else
           {
               var2 = ia[iaa];
               stack1.push(var1);
           }
           
           for(m=var2;m<var2+1;m++)
           {
               for(n=0;n<arr[m].length;n++)
               {
                   if(stack1.peek()==arr[var2][n].state && stack2.peek()==arr[var2][n].word)
                   {
                       kk = kk - arr[var2][n].word.length();
                       t = input.substring(kk,input.length());
                       n++;
                       break;
                   }
               }  break;
           }
           
           
           for(m=var2;m<var2+1;m++)
           {
               for(n=n;n<arr[m].length;n++)
               {
                   String x = arr[var2][n].word;
                   if(t.length()>=x.length() && t.substring(0,x.length()).equals(x))
                   {
                       a=var2;
                       stack1.pop();
                       stack2.pop();
                       if (tt) break five;
                   }
               } break;
           }
           
           
           
           stack1.pop();
           stack2.pop();
           
           four:{   if(tt) break four;   }
            }while(1==1);
           
           }   // five
           }while(1==1);
       }//main for
       
       

       
        
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
