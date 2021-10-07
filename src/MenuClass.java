import java.sql.SQLOutput;

public class MenuClass {

    Facade facade = new Facade();

    //method for creating items
    public void createItem(){

        String ID = UserInput.readLine("Type ID for item: ");
        while(facade.containsItem(ID)) {
            ID = UserInput.readLine("The ID is already taken." + System.lineSeparator() + "Type another ID for item: ");
        }
        while (ID.isBlank()) {
            System.out.println("Invalid data for item.");
            ID = UserInput.readLine("Type ID for item: ");
        }
        String name = UserInput.readLine("Type name for item: ");
        while (name.isBlank()) {
            System.out.println("Invalid data for item.");
            name = UserInput.readLine("Type name for item: ");
        }
        double pricePerUnit = UserInput.readDouble("Type unit price of item: ");
        while (pricePerUnit == 0 || pricePerUnit < 0) {
            System.out.println("Invalid data for item.");
            pricePerUnit = UserInput.readDouble("Type unit price of item: ");
        }
        String item = facade.createItem(ID, name, pricePerUnit);

    }


    //2.3 - Update item name and price
    public String updateItemName() { //(String itemID, String newName)

        String IDInput = UserInput.readLine("Type current ID of the item: ");
        while (IDInput.isBlank() || IDInput.equals(IDInput)) {
            System.out.println("Invalid data for item.");
            IDInput = UserInput.readLine("Type new name for the item: ");
        }
        String newNameInput = UserInput.readLine("Type new name for the item: ");

        facade.updateItemName(IDInput,newNameInput);
        
       
        return "";
        }


    public String updateItemPrice(){ //(String itemID, double newPrice)

        String IDInput = UserInput.readLine("Type current ID of the item: ");
        Item foundItem = facade.findItem(IDInput);
        double newPriceInput = UserInput.readDouble("Type new price for the item: ");

        while (newPriceInput < 0 || newPriceInput == 0) {
            System.out.println("Invalid data for item.");
            newPriceInput = UserInput.readDouble("Type new price for the item: ");
        }
        foundItem.setItemPrice(newPriceInput);

        return "";
    }

    //2.4-Buy items // I'll move this to obj for now to fix TransactionHistory
/*    public double buyItem() { //(String itemID, int amount)

        double totalPrice;
        String itemID = UserInput.readLine("Type ID of item you want to purchase: ");

        if (!obj.containsItem(itemID)) {
            return -1;

        } else {
            int amount = UserInput.readInt("Type the amount of items you want to purchase: ");
            double itemPrice = obj.findItem(itemID).getItemPrice();

            if (amount < 4 || amount == 4) {
                totalPrice = itemPrice * amount;
            } else {
                totalPrice = 4 * itemPrice + ((amount - 4) * (itemPrice * (1.0 - 0.3)));
            }

            Transaction newTransaction = new Transaction(itemID, amount, itemPrice);


            return totalPrice;

        }
    }
*/
    //2.5 - Remove items
    public String removeItem() {

        String itemID = UserInput.readLine("Type ID of item you would like to remove: ");
        facade.removeItem(itemID);

        return "";
    }

    //2.6 - print an specific item
    public String printItem() {

        String itemID = UserInput.readLine("Type ID of item to be printed: ");
        if (facade.containsItem(itemID)) {
            Item foundItem = facade.findItem(itemID);
            System.out.println(foundItem);
        } else {
            System.out.println("Item <" + itemID + " > was not registered yet.");
        }
        return "";
    }

    public String  getPrintedItemReview(){ // User story 3.2

    }


    public String getPrintedReviews () { //User story 3.3
        String reviewID = UserInput.readLine("Enter the ID of Item");
        if (facade.containsReview(reviewID)){
            System.out.println("Review(s) for <" + reviewID + ">: <" + Item.getItemName(reviewID) + ">. <" + Item.getItemPrice(reviewID) + "> SEK.");
            Review foundReview = Controller.findReview(reviewID);
            System.out.println(foundReview);
        }else {
            System.out.println("Item <" + reviewID + " > was not registered yet.");

        }
        return "";

    }
    

     /*public String meanReview(){
        String reviewID = UserInput.readLine("Enter the ID of Item");
        if (obj.containsReview(reviewID) && obj.containsItem(itemID) ){ // Checks if there are a review with that ID.
            Review foundReview = obj.findReview(reviewID);
            Item foundItem = obj.findItem(itemID);
            System.out.println(foundReview);

        }

    }*/

    public void createReview() { //User Story 3.1

        System.out.println("To create a review for a item please enter ID of the item:");

        String reviewID = UserInput.readLine("Enter the ID number: ");
        while(reviewID.isEmpty()) {
            System.out.println("ID needed to review item: ");
            reviewID = UserInput.readLine("Enter ID number: ");
        } while (!facade.containsItem(reviewID)){
            System.out.println("Item <ID> was not registered yet.");
            reviewID = UserInput.readLine("Enter a valid ID number: ");

        }
        String reviewComment = UserInput.readLine("What did you like or dislike about this item?: ");
       
        double reviewGrade = UserInput.readDouble("Enter a grade between 1 to 5: ");
         while (reviewGrade < 1.0 || reviewGrade > 5.0){

             reviewGrade = UserInput.readDouble("Grade values must be between 1 and 5.");
        }

        String review = facade.createItem(reviewID, reviewComment, reviewGrade);

        System.out.println("Your item review was registered successfully.");
        System.out.println("Returning to Review Menu....");

    }

    public String  getPrintedItemReview(){ // User story 3.2
        String reviewID = UserInput.readLine("Enter ID of Item: ");


    }


    public String getPrintedReviews () { //User story 3.3
        String reviewID = UserInput.readLine("Enter the ID of Item: ");
        if (facade.containsReview(reviewID)){
            System.out.println("Review(s) for <" + reviewID + ">: <" + facade.getItemName(reviewID) + ">. " +
                    "<" + facade.getItemPrice(reviewID) + "> SEK.");
            Review foundReview = Controller.findReview(reviewID);
            System.out.println(foundReview);
        }else {
            System.out.println("Item <" + reviewID + " > was not registered yet.");

        }
        return "";

    }

    // 4.3 print transaction for specific item
    /*public String printTransactionSpecificItem() {
            String itemID = UserInput.readLine("Type the ID of the desired item for transaction to be printed");
       if (obj.containsTransaction(itemID)) {
            Item foundItem = obj.findItem(itemID);
            System.out.println(foundItem);
    } else {
        System.out.println("Item <" + itemID + " > was not registered yet.");
       }
       return "";
    }
     */



    public void itemOption() {

        int option = UserInput.readInt("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an Item.\n" +
                "2. Remove an Item.\n" +
                "3. Print all registered Items.\n" +
                "4. Buy an Item.\n" +
                "5. Update an item’s name.\n" +
                "6. Update an item’s price.\n" +
                "7. Print an specific Item.\n\n" + //It's for User Story 2.6, but not in the menu option? I put it here temporarily anyway.
                "Type an option number: ");

        while (option < 0 || option > 7) { // 7 instead of 6 (temporarily)

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            // all println below are temporary.
            case 1 : //create an item
                createItem();
                itemOption(); //can be moved at the end of createItem()
                break;
            case 2 :
                removeItem();
                itemOption();
                break;
            case 3 :
                facade.printAllItems();
                itemOption();
                break;
            case 4 :
                facade.buyItem(); //as for now buyItem is in obj
                itemOption();
                break;
            //5. Update an item’s name.
            case 5 : //Update an item’s name.
                updateItemName();
                itemOption();
                break;
            //6. Update an item’s price.
            case 6 :
                updateItemPrice();
                itemOption();
                break;
            case 7 :
                printItem();
                itemOption();
        }

        UserInput.scanner.close();
    }
    public void ReviewMenu() {

        int option = UserInput.readInt("Reviews options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create a review for an Item.\n" +
                "2. Print a specific review of an Item.\n" +
                "3. Print all reviews of an Item.\n" +
                "4. Print mean grade of an Item\n" +
                "5. Print all comments of an Item.\n" +
                "6. Print all registered reviews.\n" +
                "7. Print item(s) with most reviews.\n" +
                "8. Print item(s) with least reviews.\n" +
                "9. Print item(s) with best mean review grade.\n" +
                "10. Print item(s) with worst mean review grade.\n\n" +
                "Type an option number: ");


        while (option < 0 || option > 10) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            case 1 : createReview();
                ReviewMenu();
                break;
            case 2 : System.out.println("Option 3");
                break;
            case 3 : getPrintedReviews (); // User Story 3.3
                ReviewMenu();
                break;
            case 4 : //meanReview();
                ReviewMenu();
                break;
            case 5 : System.out.println("Option 6");
                break;
            case 6 : facade.printAllReview();
                ReviewMenu();
                break;
            case 7 : System.out.println("Option 8");
                break;
            case 8 : System.out.println("Option 9");
                break;
            case 9 : System.out.println("Option 10");
                break;
            default : System.out.println("Please enter a valid option");
                break;
        }
        UserInput.scanner.close();
    }
    public void transactionHistoryMenu() {

        int option = UserInput.readInt("Transaction History options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Print total profit from all item purchases\n" +
                "2. Print total units sold from all item purchases\n" +
                "3. Print the total number of item transactions made.\n" +
                "4. Print all transactions made.\n" +
                "5. Print the total profit of a specific item.\n" +
                "6. Print the number of units sold of a specific item.\n" +
                "7. Print all transactions of a specific item.\n" +
                "8. Print item with highest profit.\n\n" +
                "Type an option number:\n");

        while (option < 0 || option > 8) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0 : MainMenu();
                break;
            case 1 : System.out.println("Option 2");
                break;
            case 2 : System.out.println("Option 3");
                break;
            case 3 : System.out.println("Option 4");
                break;
            case 4 : facade.printAllTransactions();
                transactionHistoryMenu();
                break;
            case 5 : System.out.println("Option 6");
                break;
            case 6 : System.out.println("Option 7");
                break;
            case 7 : //printTransactionSpecificItem();
                transactionHistoryMenu();
                break;
            case 8 : System.out.println("Option 9");
                break;
        }

        UserInput.scanner.close();
    }

    public void MainMenu(){

        int option = UserInput.readInt(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n\n" +
                        "Type any Option Number:");

        while (option < 0 || option > 3) {

            option = UserInput.readInt("Invalid menu option. Please type another option");
        }

        switch (option) {
            case 0:
                System.out.println("Closed");
                break;// create method, need help from TA with this / Carl
            case 1:
                itemOption();
                break;
            case 2:
                ReviewMenu();
                break;
            case 3:
                transactionHistoryMenu();
                break; // Added method, so when "3" is pressed we have the transactionMenu printed /Carl

        }

        UserInput.scanner.close();

    }

    public static void main(String[] args) {

        MenuClass mainmenu = new MenuClass();
        mainmenu.MainMenu();

        }
    }

