
public class MainMenu {

    public static void mainMenu() {

        int option = UserInput.readInt(
                "Main Menu: Please chose among the options below \n" +
                        "0. Close System.\n" +
                        "1. Open Item Options.\n" +
                        "2. Open Review options.\n" +
                        "3. Open Transaction History Options.\n\n" +
                        "Type any Option Number:");

        while (option != 0 && option != 1 && option != 2 && option != 3) {

            option = UserInput.readInt("Invalid menu option. Please type another option"); // Changed the text to match assignment / Carl
        }

        switch (option) {
            case 0:
                System.out.println("Closed");
                break;// create method, need help from TA with this / Carl
            case 1:
                Item.itemOption();
                break;
            case 2:
                Review.ReviewMenu();
                break;
            case 3:
                TransactionHistory.transactionHistoryMenu();
                break; // Added method, so when "3" is pressed we have the transactionMenu printed /Carl


        }

        UserInput.scanner.close();
    }
    public static void main(String[] args) {

mainMenu();

        }

}

