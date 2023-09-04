import java.util.Date;

public class Author {
    private int id;
    private String name;
    private String biography;

    private Date created_at;
    private Date updated_at;

    public Author(int id, String name, String biography, Date created_at, Date updated_at){
        this.id=id;
        this.name=name;
        this.biography=biography;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return this.name;
    }
    public String getBiography(){
        return this.biography;
    }
   

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setBiography(String biography){
        this.biography=biography;
    }
   

}
