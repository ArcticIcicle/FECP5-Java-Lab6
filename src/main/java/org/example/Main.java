package org.example;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> pizzas = new ArrayList<String>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();

        Scanner getInput = new Scanner (System.in);
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Choose option: ");
            String optionString = getInput.nextLine();
            int option = Integer.parseInt(optionString);

            if ( option == 5 ) { // Check if the input matches the desired input (case-insensitive)
                System.out.println("---Thank you!---");
                break; // Exit the loop
            }

            switch(option){
                case 1: //ADD
                    System.out.print("Pizza type: ");
                    String pizzaType = getInput.nextLine();
                    int quantity = 0;
                    System.out.print("Quantity: ");
                    String quantityString = getInput.nextLine();
                    quantity = Integer.parseInt(quantityString);
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    System.out.print("\n");
                    break;
                case 2: //Update
                    // get index
                    System.out.print("Order number to update: ");
                    String indexUpdateString = getInput.nextLine();
                    int indexUpdate = Integer.parseInt(indexUpdateString);
                    indexUpdate--;
                    // new quantity
                    System.out.print("New quantity: ");
                    String newQuantityString = getInput.nextLine();
                    int newQuantity = Integer.parseInt(newQuantityString);
                    updateOrder(quantities, indexUpdate, newQuantity);
                    System.out.print("\n");
                    break;
                case 3: //Remove
                    System.out.print("Remove: ");
                    String indexRemoveString = getInput.nextLine();
                    int indexRemove = Integer.parseInt(indexRemoveString);
                    indexRemove--;
                    removeOrder(pizzas, quantities, indexRemove);
                    System.out.print("\n");
                    break;
                case 4: //View
                    printOrders(pizzas,quantities);
                    System.out.print("\n");
                    break;
            }
        }
        //System.out.println(pizzas.isEmpty());
        //System.out.println(quantities.isEmpty());

    }
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity)
    {
        if (quantity <= 0){
            System.out.println("Quantity must be positive");
        }
        else{
            pizzas.add(pizzaType);
            quantities.add(quantity);
        }

    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index)
    {
        if (index < 0 || index>= pizzas.size()) {
            System.out.println("Order number does not exist");
        }
        else {
            pizzas.remove(index);
            quantities.remove(index);
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity)
    {
        if (index < 0 || index>= quantities.size()) {
            System.out.println("Not Valid");
        }
        else if (newQuantity <= 0){
            System.out.println("Not Valid");
        }
        else {
            quantities.set(index, newQuantity);
        }
    }
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities)
    {
        System.out.println("--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i+1)+". "+ pizzas.get(i)+ " x " + quantities.get(i));
        }
    }
}
