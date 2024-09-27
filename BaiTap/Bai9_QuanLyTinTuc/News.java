import java.util.ArrayList;
import java.util.Scanner;

interface INews {
    void display();    
}
class News implements INews{
    int ID;
    String Title;
    String PulishDate;
    String Author;
    String Content;
    float AverageRate;

    
    public News(int iD, String title, String pulishDate, String author, String content, float averageRate) {
        ID = iD;
        Title = title;
        PulishDate = pulishDate;
        Author = author;
        Content = content;
        AverageRate = averageRate;
    }


    public int getID() {
        return ID;
    }



    public void setID(int iD) {
        ID = iD;
    }



    public String getTitle() {
        return Title;
    }



    public void setTitle(String title) {
        Title = title;
    }



    public String getPulishDate() {
        return PulishDate;
    }



    public void setPulishDate(String pulishDate) {
        PulishDate = pulishDate;
    }



    public String getAuthor() {
        return Author;
    }



    public void setAuthor(String author) {
        Author = author;
    }



    public String getContent() {
        return Content;
    }



    public void setContent(String content) {
        Content = content;
    }



    public float getAverageRate() {
        return AverageRate;
    }

    public void Calculate(){
        
    }

    @Override
    public String toString() {
        return "News [ID=" + ID + ", Title=" + Title + ", PulishDate=" + PulishDate + ", Author=" + Author
                + ", Content=" + Content + ", AverageRate=" + AverageRate + "]";
    }


    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }
}
