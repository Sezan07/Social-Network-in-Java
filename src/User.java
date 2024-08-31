import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private int like;
    List<String> comment;
// it cannot be accessed directly but it can access threw getter setter methof.
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.comment = new ArrayList<>();
        this.like = 0;
    }

    public void noti(String n)
    {
        comment.add(n);
    }
    public void countLike()
    {
        like++;
    }
    public int getLike()
    {
        int like1;
        like1 = like;
        return like1;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getNotification()
    {
        return comment;
    }
}