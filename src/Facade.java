import java.util.List;

public class Facade {
Controller controller = new Controller();


//----------------------------- For items --------------------------------------------

    public String createItem(String itemID, String itemName, double unitPrice){
        return controller.createItem(itemID, itemName, unitPrice);
    }

    public String updateItemName(String itemID, String newName) {
        controller.updateItemName(itemID,newName);
        return "";
    }

    public String updateItemPrice(String itemID, double newPrice) {
        controller.updateItemPrice(itemID, newPrice);
        return "";
    }

    public String removeItem(String itemID) {
        controller.removeItem(itemID);
        return "";
    }

    public boolean containsItem(String itemID) {
        controller.findReview(itemID);
        return controller.containsItem(itemID);
    }

    public boolean containsReview(String reviewID) { // added by Carl,
        controller.findReview(reviewID);
        return controller.containsItem(reviewID);
    }


    public double buyItem(String itemID, int amount) {
        controller.buyItem(itemID, amount);
        return 0.0;
    }

    public String printItem(String itemID) {

        controller.printItem(itemID);
        return "";
    }

    public String printAllItems() {

        controller.printAllItems();

        return "";
    }


    // ------------------------------- For reviews ------------------------------------

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) { // 3.1 user story

        return controller.createReview(itemID, reviewComment, reviewGrade);
    }

    public String reviewItem(String itemID, int reviewGrade) { // 3.1 user story
        reviewItem(itemID, "", reviewGrade);
        return "";
    }

    public String getItemCommentsPrinted(String itemID) {
        return "";
    }

    public List<String> getItemComments(String itemID) {
        return null;
    }

    public double getItemMeanGrade(String itemID) {
        return -1.0;
    }

    public int getNumberOfReviews(String itemID) {
        return -1;
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {// 3.2 user Story?


        return controller.getPrintedItemReview(itemID, reviewNumber);
    }

    public String getPrintedReviews(String itemID) { // 3.3 user story

        return "";
    }

    public String printMostReviewedItems() {
        return "";
    }

    public List<String> getMostReviewedItems() {
        return null;
    }

    public List<String> getLeastReviewedItems() {
        return null;
    }

    public String printLeastReviewedItems() {
        return "";
    }

    public String printWorseReviewedItems() {
        return "";
    }

    public String printBestReviewedItems() {
        return "";
    }

    public List<String> getWorseReviewedItems() {
        return null;
    }

    public List<String> getBestReviewedItems() {
        return null;
    }

    public String printAllReviews() {
        controller.printAllReviews();

        return "";
    }



    // ------------------------------- for transaction history ---------------------------------

    public double getTotalProfit() {
        return -1.0;
    }

    public String printItemTransactions(String itemID) {
        return "";
    }

    public int getTotalUnitsSold() {
        return -1;
    }

    public int getTotalTransactions() {
        return -1;
    }

    public double getProfit(String itemID) {
        return -1.0;
    }

    public int getUnitsSolds(String itemID) {
        return -1;
    }

    public String printAllTransactions() {
        return "";
    }


    public String printMostProfitableItems() {
        return "";
    }



}
