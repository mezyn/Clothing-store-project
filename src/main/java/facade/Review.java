package facade;

public class Review {

    private String comment;
    private int grade;


    //public Review(){}

    public Review(String comment, int grade){

        this.comment= comment; //Should it be set as null? -M
        this.grade = grade;

    }


    @Override
    public String toString() {return  "Grade: " + this.grade +". " + this.comment ;}



    public String getID() {return ID;}

    public String getItemComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    } // Don't need this?

    public void setGrade(int grade) {
        this.grade = grade;
    } // Don't need this?

    public double getItemGrade() { return grade; }

    public String addComment(){
        return comment;}



}


