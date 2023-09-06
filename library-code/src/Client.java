import java.util.Date;

public class Client extends User{
    private int client_number;
    public Client(int id, String name, String email, String password, String phone, Date created_at, Date updated_at, int client_number){
        super(id, name,  email,  password,  phone,  created_at,  updated_at);
        this.client_number=client_number;

    }

    public void setAdmin_number(int client_number) {

        this.client_number = client_number;
    }

    public int getAdmin_number() {

        return client_number;
    }
}
