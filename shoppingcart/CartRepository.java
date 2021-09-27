package shoppingcart;

import java.util.LinkedList;
import java.util.Random;

public class CartRepository {
    private LinkedList<Cart> database;
    private Random rn;

    public  CartRepository() {
        database=new  LinkedList<>();
        rn= new Random();
    }
    public void addToCart(String name, Double price, Double quantity) {
        Cart ct=new Cart();
        ct.setId(rn.nextInt());
        ct.setName(name);
        ct.setPrice(price);
        ct.setQuantity(quantity);
        ct.setTotal(price*quantity);
        database.add(ct);
        
    }

    public int findItemPositionById(int id) {
        for(int i=0;i<database.size();i++) {
            Cart ct= database.get(i);
            if((ct.getId())==id)
            return i;
        }
        return -1;
    }
    public void removeFromCart(int id) {
        int pos= findItemPositionById(id);
        if(pos==-1) {
            System.out.println("Invalid ID");
            System.exit(0);
        }
        else {
            database.remove(pos);
        }

    }

    public void updateQuantity(int id, Double quantity) {
        int pos= findItemPositionById(id);
        Cart ct=database.get(pos);
        ct.setQuantity(quantity);
        ct.setTotal(ct.getPrice()*quantity);
        database.set(pos, ct);
        
    }

    public Double displaBill(){
        Double total=0.0;
        for(int i=0;i<database.size();i++) {
            Cart ct=database.get(i);
            System.out.println("\nItem Id: "+ct.getId()+
            "\tName of the Item: "+ct.getName()+
            "\tQunatity : "+ct.getQuantity()+
            "\nPrice of one Item: "+ct.getPrice()+
            "\nTotal price of this item: "+ct.getTotal()+"\n \n");
            total=total+ct.getTotal();
        }
        return total;
    }
}
