package model;

public class Borrow {
    int id;
    int user_id;
    int book_id;
    String borrow_date;
    String return_date;
    String status;
    String description;
    String created_at;
    String updated_at;

    public Borrow(int id, int user_id, int book_id, String borrow_date, String return_date, String status, String description, String created_at, String updated_at){
        this.id=id;
        this.user_id=user_id;
        this.book_id=book_id;
        this.borrow_date=borrow_date;
        this.return_date=return_date;
        this.status=status;
        this.description=description;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    public int getId() {
        return id;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public int getBook_id(){
        return this.book_id;
    }
    public String getBorrow_date(){
        return this.borrow_date;
    }
    public String getReturn_date(){
        return this.return_date;
    }
    public String getStatus(){
        return this.status;
    }
    public String getDescription(){
        return this.description;
    }
    public String getCreated_at(){
        return this.created_at;
    }
    public String getUpdated_at(){
        return this.updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUser_id(int user_id){
        this.user_id=user_id;
    }
    public void setBook_id(int book_id){
        this.book_id=book_id;
    }
    public void setBorrow_date(String borrow_date){
        this.borrow_date=borrow_date;
    }
    public void setReturn_date(String return_date){
        this.return_date=return_date;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setCreated_at(String created_at){
        this.created_at=created_at;
    }
    public void setUpdated_at(String updated_at){
        this.updated_at=updated_at;
    }


}
