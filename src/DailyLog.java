

/*--------------------------------------------
Program 3: MPLS care attendant Daily Log
The MPLS care attendant Daily Dog Log is a program that allows the care attendant manager to  enter daily logs for each Dog in MPLS Dog boarding School.  
Listed below is a chart with the name of each care attendant and the name of each dog in their care.  The program allows the care attendant to continuously 
enter their id# and enter the total amount of time spent with the dog and a general note about the dog's day. Once the care attendant id # is entered, the care attendant
will be prompted to select the dogs who fall under their care.  For each dog entered, The program provides a summary of all entered information for a dog. The program should enforce that only care attendants with the id numbers listed in the chart below can be entered.    

Once the manager is done entering all logs, the program will display a count of total dogs entered, a count of the total number of dogs entered from each 
color group, along with the total time the care attendant spent with the various dogs. The program also provides you with a summary of the dog with the most care minutes.

**ARRAYS CANNOT BE USED FOR THIS PROGRAM**

| ID # | Care Attendant Name | Assigned Color Group|
|------|---------------------|---------------------|
| 11   | Noah Charles        |  BLUE, RED          |
| 22   | Silas Alexander     |  GREEN, YELLOW      |
| 33   | Chris Isaac         |  BLUE, YELLOW       |                               
| 44   | Mya Lynn            |  RED, GREEN         |


**** List of dogs currently in care
| ID # | Dog Name | Dogs in Care                                         |
|-------|------------|----------|
| 348   | Badger    | RED      |
| 301   | Hoosier   | RED      |
| 325   | Spartan   | GREEN    |
| 388   | Hawk      | YELLOW   |
| 333   | Gopher    | YELLOW   |
| 388   | Husker    | RED      |
| 391   | Bucky     | RED      |
| 362   | Nittany   | BLUE     |
| 311   | Wolvey    | BLUE     |
	
    Course: COMP 170, Fall 2026
    System: Visual Studio Code, Windows 11
    Author: G. Bolles
*/
import java.util.Scanner;
public class DailyLog {
    public static void main(String[] args) throws Exception {
        
        //DECLARATIONS *Make sure to also consider all variables that will keep tally and initialize to zero
        int inputAttendantID=0;
        String currentAttendantName="";
        int longestSingleSession=0;
        String dogWithLongestSession="";
        String currentDogGroup="";
        int blueTime=0;
        int blueCount=0;
        int greenTime=0;
        int greenCount=0;
        int redTime=0;
        int redCount=0;
        int yellowTime=0;
        int yellowCount=0;
        int timeWithCurrentDog=0;
        String noteForCurrentDog="";
        int currentDogID=0;
        String currentDogName="";
        String colorGroup1="";
        String colorGroup2="";
        boolean exitBool=false;
        boolean secondaryExitBool=false;
        Scanner scan=new Scanner(System.in);
        //WELCOME MESSAGE
        System.out.println("Welcome to the MPLS care attendant daily log program.  This program will allow you to enter a care attendant id and produce a log for the dogs under the attendant's care.");

        //Create Space
        System.out.println("");

        //OUTPUT OF CARE ATTENDANT INFO.
        System.out.println("Enter 11 for Noah Charles");
        System.out.println("Enter 22 for Silas Alexander");
        System.out.println("Enter 33 for Chris Isaac");
        System.out.println("Enter 44 for Mya Lynn");
        System.out.println("Enter -1 to quit");

        //PRIMER

        //Enfore that only 11, 22, 33, 44 and sentinel value can be entered
        while(exitBool==false){
            try{
            inputAttendantID=Integer.parseInt(scan.nextLine());
            }
            catch(Exception e){
                exitBool=false;
            }
            if(inputAttendantID==11||inputAttendantID==22||inputAttendantID==33||inputAttendantID==44||inputAttendantID==-1){
            exitBool=true;
            }
            else{
                System.out.println("Invalid input. Please input one of the four attendant IDs specified above or -1 to quit.");
            }
        }
        if(inputAttendantID==-1){
            scan.close(); return; //If user decided to quit, return from main
        }
        exitBool=false;
        //Looping structure that allow for continous iteration and checks against sentinel value
        while(exitBool==false){

                //Determine which dogs to display based on attendant id number 
                if(inputAttendantID==11){
                    currentAttendantName="Noah";
                    colorGroup1="BLUE";
                    colorGroup2="RED";
                }
                else if(inputAttendantID==22){
                    currentAttendantName="Silas";
                    colorGroup1="GREEN";
                    colorGroup2="YELLOW";
                }
                else if(inputAttendantID==33){
                    currentAttendantName="Chris";
                    colorGroup1="BLUE";
                    colorGroup2="YELLOW";
                }
                else if(inputAttendantID==44){
                    currentAttendantName="Mya";
                    colorGroup1="RED";
                    colorGroup2="GREEN";
                }
                else{
                    System.out.println("An invalid attendant id was entered."); //This line should never be hit;
                    scan.close();
                    exitBool=true;
                    return;
                }

                //Enforce that dog ID is an applicable number according to the chart
                if(colorGroup1=="BLUE"||colorGroup2=="BLUE"){
                    System.out.println("Enter 362 for Nittany");
                    System.out.println("Enter 311 for Wolvey");
                }
                if(colorGroup1=="GREEN"||colorGroup2=="GREEN"){
                    System.out.println("Enter 325 for Spartan");
                }
                if(colorGroup1=="RED"||colorGroup2=="RED"){
                    System.out.println("Enter 348 for Badger");
                    System.out.println("Enter 301 for Hoosier");
                    System.out.println("Enter 388 for Husker");
                    System.out.println("Enter 391 for Bucky");
                }
                if(colorGroup1=="YELLOW"||colorGroup2=="YELLOW"){
                    System.out.println("Enter 388 for Hawk");
                    System.out.println("Enter 333 for Gopher");
                }
                currentDogGroup="";
                currentDogID=0;
                while(secondaryExitBool==false){

                    try{currentDogID=Integer.parseInt(scan.nextLine());}
                    catch(Exception e){currentDogID=0;}
                    //Exit early if -1 input;
                    if(currentDogID==-1){secondaryExitBool=true; }

                    //Valdiate dog IDs only if they belong to the groups assigned to the attendant
                    if((colorGroup1=="BLUE"||colorGroup2=="BLUE")){
                        if(currentDogID==362||currentDogID==311){
                            secondaryExitBool=true;
                            currentDogGroup="BLUE";
                        }
                    }
                    if(secondaryExitBool==false && (colorGroup1=="GREEN"||colorGroup2=="GREEN")){
                        if(currentDogID==325){
                            secondaryExitBool=true;
                            currentDogGroup="GREEN";
                        }
                    }
                    if(secondaryExitBool==false && (colorGroup1=="RED"||colorGroup2=="RED")){
                        if(currentDogID==348||currentDogID==301||currentDogID==388||currentDogID==391){
                            secondaryExitBool=true;
                            currentDogGroup="RED";
                        }
                    }
                    if(secondaryExitBool==false && (colorGroup1=="YELLOW"||colorGroup2=="YELLOW")){
                        if(currentDogID==388||currentDogID==333){
                            secondaryExitBool=true;
                            currentDogGroup="YELLOW";
                        }
                    }
                    if(secondaryExitBool==false){
                        currentDogGroup="";
                        System.out.println("Invalid input. Please input one of the specified dog IDs above or -1 to stop.");
                    }    
                }
                if(currentDogID==-1){exitBool=true;}
                else{
                if(currentDogID==362){
                    currentDogName="Nittany";
                }
                else if(currentDogID==311){
                    currentDogName="Wolvey";
                }
                else if(currentDogID==325){
                    currentDogName="Spartan";
                }
                else if(currentDogID==348){
                    currentDogName="Badger";
                }
                else if(currentDogID==301){
                    currentDogName="Hoosier";
                }
                else if(currentDogID==391){
                    currentDogName="Bucky";
                }
                else if(currentDogID==333){
                    currentDogName="Gopher";
                }
                else if(currentDogID==388){
                    if(colorGroup1=="RED"||colorGroup2=="RED"){
                        currentDogName="Husker";
                    }
                    else{
                        //388 valid only for red and yellow, validation done above. Yellow must be the only alternative, and no single attendant has both red and yellow groups assigned to them.
                        currentDogName="Hawk";
                    }
                }
                secondaryExitBool=false; //reset secondary exit condition, as we've left the corresponding loop and are not exiting the outer loop.
                timeWithCurrentDog=0;
                //Gather rest of information such as total numbers of min. spent with dog and dog note
                while(secondaryExitBool==false){
                    System.out.println(currentAttendantName+", please enter the number of minutes spent with dog:");
                    try{timeWithCurrentDog=Integer.parseInt(scan.nextLine());}
                    catch(Exception e){timeWithCurrentDog=-2;}
                    if(timeWithCurrentDog>=-1){secondaryExitBool=true;}
                    else{System.out.println("Invalid input. Please enter a positive integer (or -1 to quit the program).");}
                }
                secondaryExitBool=false;
                if(timeWithCurrentDog==-1){exitBool=true;}
                else{
                System.out.println("...and enter a note for the session:");
                noteForCurrentDog=scan.nextLine(); //collect note, if any. No real need to validate here

                //Output current dog's entered information.
                System.out.println("");
                System.out.println("=======================");
                System.out.println("Attendant ID: "+inputAttendantID);
                System.out.println("Dog ID:       "+currentDogID);
                System.out.println("Dog Name:     "+currentDogName);
                System.out.println("Minutes with: "+timeWithCurrentDog);
                System.out.println("***********************");
                System.out.println("Note: "+noteForCurrentDog);
                System.out.println("=======================");

                //Determine color count and total time spent by color &
                //Increment count for total entries
                if(currentDogGroup=="BLUE"){
                    blueCount++;
                    blueTime+= timeWithCurrentDog;
                }
                else if(currentDogGroup=="GREEN"){
                    greenCount++;
                    greenTime+= timeWithCurrentDog;
                }
                else if(currentDogGroup=="RED"){
                    redCount++;
                    redTime+= timeWithCurrentDog;
                }
                else{
                    //currentDogGroup cannot be null due to the validation restrictions on dog IDs. For all valid dog IDs, currentColorGroup is assigned
                    //Consequently, final else is for group yellow
                    yellowCount++;
                    yellowTime+=timeWithCurrentDog;
                }
                //Check if this input was the longest single session yet.
                if(timeWithCurrentDog > longestSingleSession){
                    longestSingleSession=timeWithCurrentDog;
                    dogWithLongestSession=currentDogName + " ["+currentDogGroup+", "+currentDogID+"]";
                }

                //Reprompt user to enter another user and enforce that only care attendant ID #'s are entered' 
                //Enfore that only 11, 22, 33 and 44 can be entered, including sentinel value
                
                //OUTPUT OF CARE ATTENDANT INFO.
                System.out.println("");
                System.out.println("Please enter the attendant ID for the next dog:");
                System.out.println("Enter 11 for Noah Charles");
                System.out.println("Enter 22 for Silas Alexander");
                System.out.println("Enter 33 for Chris Isaac");
                System.out.println("Enter 44 for Mya Lynn");
                System.out.println("Enter -1 to quit");
                while(secondaryExitBool==false){
                    try{
                    inputAttendantID=Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e){
                        secondaryExitBool=false; 
                        System.out.println("Invalid input. Please input one of the four attendant IDs specified above or -1 to quit.");
                    }
                    if(inputAttendantID==11||inputAttendantID==22||inputAttendantID==33||inputAttendantID==44||inputAttendantID==-1){
                        secondaryExitBool=true;
                    }
                    else{
                        inputAttendantID=-2;
                        System.out.println("Invalid input. Please input one of the four attendant IDs specified above or -1 to quit.");
                    }
                }
                if(inputAttendantID==-1){
                    exitBool=true; //user has opted to not input for another attendant. Close loop and output totals. 
                }
                secondaryExitBool=false;
            }}
        }
        //Output total time and count by color 
        System.out.println("#################################################");
        System.out.println("Blue Group Totals");
        System.out.println("           Time:  "+blueTime);
        System.out.println("           Count: "+blueCount);
        System.out.println("Green Group Totals");
        System.out.println("           Time:  "+greenTime);
        System.out.println("           Count: "+greenCount);
        System.out.println("Red Group Totals");
        System.out.println("           Time:  "+redTime);
        System.out.println("           Count: "+redCount);
        System.out.println("Yellow Group Totals");
        System.out.println("           Time:  "+yellowTime);
        System.out.println("           Count: "+yellowCount);
        System.out.println("#################################################");
        scan.close();
    }
}
