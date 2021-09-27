package shoppingcart;

import java.util.Scanner;

public class MenuHelper {
    
    private Scanner sc;
    private int choice;
    private CartRepository repository;

    public MenuHelper() {
        sc=new Scanner(System.in);
        repository=new CartRepository();
    }

    public void showMenu() {
        String menu="\n1. Add an Item to cart"+"\n2. Remove an Item from cart"+"\n3. Update Quantity in Cart"+"\n4. Display Bill"+"\n5. Exit";
        while(true) {
            System.out.println(menu);
            System.out.println("Enter your choice: ");
            choice =sc.nextInt();
            performOperation(choice);
        }
    }

    private void performOperation(int choice) {
        if(choice==1)
        {
            addToCart();
        }
        else if(choice ==2) {
            removeFromCart();
        }
        else if(choice ==3) {
            updateQuantity();
        }
        else if(choice ==4) {
            displayBill();
        }
        else {
            System.exit(0);
        }
    }

    private void addToCart() {
        System.out.println("\n***ADDING AN ITEM TO CART***\n");
        System.out.println("Enter the Item Name: ");
        String name=sc.next();
        System.out.println("Enter the price: ");
        Double price=sc.nextDouble();
        System.out.println("Enter the Quantity: ");
        Double quantity=sc.nextDouble();

        repository.addToCart(name,price,quantity);

        System.out.println("\n***Item Added Successfully***\n");
    }

    private void removeFromCart() {
        System.out.println("\n***REMOVING AN ITEM TO CART***\n");
        System.out.println("Enter Item Id: ");
        int id=sc.nextInt();
        repository.removeFromCart(id);
        System.out.println("\n***Item Removed successfully***\n");
    }

    private void updateQuantity() {
        System.out.println("\n***UPDATE QUANTITY OF AN ITEM***\n");
        System.out.println("Enter Item Id: ");
        int id=sc.nextInt();
        System.out.println("Enter Qunatity requried: ");
        Double quantity=sc.nextDouble();
        repository.updateQuantity(id,quantity);
        System.out.println("\n***Quantity updated successfully***\n");
    }

    private void displayBill() {
        System.out.println("\n***DISPLAY OF ADDED CART AND TOTAL BILL***\n");
        double totalBill=repository.displaBill();
        System.out.println("\n***TOTAL AMOUNT TO BE PAID: "+totalBill+"***");
    }


}
