import java.util.Date;

public class Admin extends User{
    private int admin_number;
    public Admin(int id, String name, String email, String password, String phone, Date created_at, Date updated_at, int admin_number){
        super(id, name,  email,  password,  phone,  created_at,  updated_at);
        this.admin_number=admin_number;

    }

    public void setAdmin_number(int admin_number) {

        this.admin_number = admin_number;
    }

    public int getAdmin_number() {

        return admin_number;
    }
}
