package registration;

import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;

public class MenuHelper {
    
    private Scanner sc=new Scanner(System.in);
    private Random rn=new Random();
    private LinkedList<User> database=new LinkedList<>();
    private int choice;
    private int count1;
    private int count2;
    private int count3;
    private int count4;
    

    private void askChoice() {

        System.out.println("Enter your choice: ");
        choice=sc.nextInt();
            
        if(choice==1){
            registration();
        }
        else if(choice==2){
            login();
            
        }
        else if(choice ==3){
            showRegisteredUsers();
        }
        else if(choice==4){
            findUsersWithAgeGreterThanFifty();
        }
        else if(choice==5) {
            findTheUserWhoseNameStartWithA();
        }
        else if(choice==6) {
            findTheUsersWhoseAgeBetween35To60();
        }

        else {
            System.out.println("Bad Choice...");
             System.exit(0);
        }
         
    }

    private void registration() {
        System.out.println("\n--- For Registering Enter Following Deatils --- \n");
        System.out.println("Enter user name: ");
        String name=sc.next();

        System.out.println("Enter your password: ");
        String pass=sc.next();

        System.out.println("Enter your age: ");
        int age=sc.nextInt();

        User ui=new User();
        ui.setName(name);
        ui.setPass(pass);
        ui.setAge(age);
        ui.setId(rn.nextLong());

        database.add(ui);

    }

    private void login() {
        
        System.out.println("\n*** Login *** \nEnter your name: " );
        String name=sc.next();
        for(User us : database) {
            if(name.equals(us.getName()))
            {
                count4=1;
                System.out.println("Enter your password: ");
                String pass=sc.next();
                if(pass.equals(us.getPass())){
                    System.out.println("\n ***  Found The User  *** \n ");
                    System.out.println("Id: "+us.getId()+"\nname: "+us.getName()+"\nage: "+us.getAge()+"\n"); 
                }
                else{
                    System.out.println("\nThe password you entered is incorrect..");
                }
            }
             
        }
        if(count4==0)
        {
            System.out.println("\n ***User Not Found *** \n");
        }
    }

    private void showRegisteredUsers() {
        System.out.println("\n --- Registered Users Are --- \n");
        for(int i=0;i<database.size();i++) {
            User us=database.get(i);
            System.out.println("Id: "+us.getId()+"\nname: "+us.getName()+"\nage: "+us.getAge()+"\n");
        }
    }

    private void findUsersWithAgeGreterThanFifty() {  
        for(int i=0;i<database.size();i++) {
            User us=database.get(i);
            int age=us.getAge();
            if(age>50){
                System.out.println("\nThe Users whose age is above 50 are: \n");
                System.out.println("Id: "+us.getId()+"\nname: "+us.getName()+"\nage: "+us.getAge()+"\n");
                count1=1;
            }
        }
        if(count1==0){
            System.out.println("\nThere is No user Whose age is Greater Than 50...");
        }
    
    }

    private void findTheUserWhoseNameStartWithA() { 
        for(int i=0;i<database.size();i++) {
            User us=database.get(i);
            if((us.getName().charAt(0)=='A')||(us.getName().charAt(0)=='a')) {
                System.out.println("\nThe Users whose name Starts with A letter are: \n");
                System.out.println("Id: "+us.getId()+"\nname: "+us.getName()+"\nage: "+us.getAge()+"\n");
                count3=1;
            }

        }
        if(count3==0) {
            System.out.println("\nThere is No user whose name starts with A");
        }
        

    }

    private void findTheUsersWhoseAgeBetween35To60() {
           
        for(int i=0;i<database.size();i++) {
            User us=database.get(i);
            int age=us.getAge();
            if(age>35&&age<60){
                System.out.println("\nThe Users whose age is between 35 and 60 are: \n");
                System.out.println("Id: "+us.getId()+"\nname: "+us.getName()+"\nage: "+us.getAge()+"\n");
                count2=1;
            }
 
        }
        if(count2==0){
            System.out.println("\nThere is No user Whose age is Between 35 and 60");
        }

     }

    public void performOperation(){
        do{
            System.out.println("1. Register \n"+
            "2. login \n"+
            "3. Show users \n"+
            "4. Find Users with Age Greater than 50 \n"+
            "5. Find Users whose Name Starts with A \n"+
            "6. Find Users Whose Age is Between 35 to 60");
		    askChoice();
		    System.out.println("Press 'y' to continue....");
		    System.out.println("Press 'n' to stop....");
	    }while(sc.next().charAt(0) == 'y');
    }

}
