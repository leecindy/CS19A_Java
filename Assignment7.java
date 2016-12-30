//CSCI 19A - Assignment 7 by Cindy Lee -- due 8/3/2016

import java.util.*;
import java.text.*;

public class Assignment7
{
  
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#,###.00");
    
    //create class objects
    SwimmingPools rectangular = new SwimmingPools();
    SwimmingPools circular = new SwimmingPools();
    double length;
    double width;
    double depth;
    double diameter;
    double flowRate;
    double rectangularConstant = 7.48;
    double circularConstant = 5.9;
    
    boolean again = true;
        
    while (again)
    {
      System.out.println("Please select the following: \n"+
                         "1. I have a rectangular pool\n"+
                         "2. I have a circular pool\n"+
                         "3. Quit the application");
      
      try
      {
        int choice = input.nextInt();
      
        switch(choice)
        {
          case 1: //rectangular pool
            System.out.print("Please enter the length of the rectangular pool: ");
            length = input.nextDouble();
            System.out.print("Please enter the width of the rectangular pool: ");
            width = input.nextDouble();
            System.out.print("Please enter the depth of the rectangular pool: ");
            depth = input.nextDouble();
            System.out.print("Please enter the flow rate per minute: ");
            flowRate = input.nextDouble();
            
            //set values of the object
            rectangular.setValues(length, width, depth, rectangularConstant, flowRate);
            
            //display
            System.out.println("Your Rectangular Pool is:\n"+
                               df.format(length) + " feet in length\n"+
                               df.format(width) + " feet across in width\n"+
                               df.format(depth) + " feet deep\n");                     
            System.out.println("The pool has a volume of " + df.format(rectangular.getVolume()) + " cubic feet.");
            System.out.println("The pool has a capacity of " + df.format(rectangular.getCapacity()) + " gallons of water.");
            System.out.println("The pool has a fill time of " + df.format(rectangular.getFlowRate()) + " hours.\n");
            break;
            
          case 2://circular pool
            System.out.println("Please enter the diameter of the circular pool: ");
            diameter = input.nextDouble();
            System.out.println("Please enter the depth of the circular pool: ");
            depth = input.nextDouble();
            System.out.println("Please enter the flow rate per minute: ");
            flowRate = input.nextDouble();
            
            //set values of the object
            circular.setValues(diameter, diameter, depth, circularConstant, flowRate);
            
            //display
            System.out.println("Your Circular Pool has a:\n"+
                               "Diameter of " + df.format(diameter) + " feet diameter\n"+
                               df.format(depth) + " feet deep\n");            
            System.out.println("The pool has a volume of " + df.format(circular.getVolume()) + " cubic feet.");
            System.out.println("The pool has a capacity of " + df.format(circular.getCapacity()) + " gallons of water.");
            System.out.println("The pool has a fill time of " + df.format(circular.getFlowRate()) + " hours.\n"); 
            break;
            
          case 3:
            System.exit(0);
            break;
            
          default:
            System.out.println("Invalid input.. Ending of the application");
            System.exit(0);
            break;
        }
      }
      catch(InputMismatchException e)
      {
          System.out.println("Invalid input.. Ending of the application");
          System.exit(0);
      }
      
    }
  }
}

class SwimmingPools
{
  private double poolLength;
  private double poolWidth; 
  private double poolDepth;
  private double poolFlowRate;
  private double constant;
   
  //constructor
  public SwimmingPools ()
  {
    poolLength = 0;
    poolWidth = 0;
    poolDepth = 0;
    constant = 0;
    poolFlowRate = 0;
  }
  
  //set values
  public void setValues(double poolLength, double poolWidth, double poolDepth, double constant, double poolFlowRate)
  {
    this.poolLength = poolLength;
    this.poolWidth = poolWidth;
    this.poolDepth = poolDepth;
    this.constant = constant;
    this.poolFlowRate = poolFlowRate;
  }
  
  //calculate volume
  public double getVolume()
  {
    return poolLength * poolWidth * poolDepth;
  }
  
  //calculate capacity
  public double getCapacity()
  {
    return getVolume() * constant;
  }
    
  //calculate flowrate
  public double getFlowRate()
  {
    return getCapacity()/(poolFlowRate*60);
  }
  
  //test
  public void print()
  {
    System.out.println(this);
  }
}
    
      
      