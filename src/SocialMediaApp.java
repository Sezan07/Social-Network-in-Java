
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocialMediaApp implements postable{
    private List<User> users;
    private List<Post> posts;
    private List<Message> messages;

    public SocialMediaApp() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void registerUser(String username, String password, String email) {
        User newUser = new User(username, password, email);
        users.add(newUser);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void createPost(User currentUser, String postContent) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select post type:");
        System.out.println("1. Text Post");
        System.out.println("2. Image Post");
        System.out.println("3. Video Post");

        int postTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            switch (postTypeChoice) {
                case 1:
                    System.out.println("Enter text for the post:");
                    String textContent = scanner.nextLine();
                    TextPost textPost = new TextPost(currentUser, textContent);
                    posts.add(textPost);
                    System.out.println("Text post created successfully.");
                    break;
                case 2:
                    System.out.println("Enter image URL for the post:");
                    String imageUrl = scanner.nextLine();
                    ImagePost imagePost = new ImagePost(currentUser, imageUrl);
                    posts.add(imagePost);
                    System.out.println("Image post created successfully.");
                    break;
                case 3:
                    System.out.println("Enter video URL for the post:");
                    String videoUrl = scanner.nextLine();
                    VideoPost videoPost = new VideoPost(currentUser, videoUrl);
                    posts.add(videoPost);
                    System.out.println("Video post created successfully.");
                    break;
                default:
                    System.out.println("Invalid post type choice.");
                    break;
            }
        } catch(Exception e)//generic exception
        {
            System.out.println("Exception : post not created");
        }
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Message> getMessages(User user) {
        List<Message> userMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getReceiver().equals(user)) {
                userMessages.add(message);
            }
        }
        return userMessages;
    }
}