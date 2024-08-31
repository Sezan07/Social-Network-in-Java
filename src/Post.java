import java.util.ArrayList;
import java.util.List;

abstract class Post {
    protected User author;
    protected String content;
    public int likes;
    protected List<String> comments;
    List<Message> userMessages = new ArrayList<>();


    public Post(User author, String content) {
        this.author = author;
        this.content = content;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void like(User user)
    {
        user.countLike();
        user.noti(user.getUsername() + " liked the post.");
    }

    public void comment(User user, String text) {
        user.noti(user.getUsername() + " commented on your post : "+ text);
    }

    public abstract void display();
}

class TextPost extends Post {
    public TextPost(User author, String content) {
        super(author, content);
    }

    @Override
    public void display() {
        System.out.println("Text Post by " + author.getUsername() + ": " + getContent());
    }
}

class ImagePost extends Post {
    public ImagePost(User author, String content) {
        super(author, content);
    }

    @Override
    public void display() {
        System.out.println("Image Post by " + author.getUsername() + ": " + getContent());
    }
}

class VideoPost extends Post {
    public VideoPost(User author, String content) {
        super(author, content);
    }

    @Override
    public void display() {
        System.out.println("Video Post by " + author.getUsername() + ": " + getContent());
    }
}
