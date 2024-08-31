import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMediaApp socialMediaApp = new SocialMediaApp();
        User currentUser = null;

        while (true) {
            if (currentUser == null) {
                System.out.println("Enter number from below options:");
                System.out.println("1. Login");
                System.out.println("2. Register");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter username:");
                        String username = scanner.nextLine();
                        System.out.println("Enter password:");
                        String password = scanner.nextLine();
                        currentUser = socialMediaApp.authenticateUser(username, password);
                        if (currentUser != null) {
                            System.out.println("Login successful.");
                        } else {
                            System.out.println("Authentication failed. Invalid username or password.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter username:");
                        String newUsername = scanner.nextLine();
                        System.out.println("Enter password:");
                        String newPassword = scanner.nextLine();
                        System.out.println("Enter email:");
                        String email = scanner.nextLine();
                        socialMediaApp.registerUser(newUsername, newPassword, email);
                        System.out.println("Registration successful. Please log in.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("Options:");
                System.out.println("1. Feed");
                System.out.println("2. Notifications");
                System.out.println("3. Messages");
                System.out.println("4. Post");
                System.out.println("5. Logout");

                int userChoice = scanner.nextInt();
                scanner.nextLine();

                switch (userChoice) {
                    case 1:
                        // Feed
                        List<Post> posts = socialMediaApp.getPosts();
                        System.out.println("Feed:");
                        for (int i = 0; i < posts.size(); i++) {
                            System.out.println((i + 1) + ". " + posts.get(i).getContent());
                        }
                        System.out.println("Press 9 to go back to the main menu.");
                        int postChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (postChoice == 9) {
                            continue; // Go back to the main menu
                        } else if (postChoice >= 1 && postChoice <= posts.size()) {
                            Post selectedPost = posts.get(postChoice - 1);
                            System.out.println("1. Like");
                            System.out.println("2. Comment");
                            int actionChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            if (actionChoice == 1) {
                                selectedPost.like(currentUser);
                            } else if (actionChoice == 2) {
                                System.out.println("Enter your comment:");
                                String comment = scanner.nextLine();
                                selectedPost.comment(currentUser, comment);
                            }
                        } else {
                            System.out.println("Invalid choice.");
                        }
                        break;
                    case 2:
                        // Notifications
                        List<String> notifications = currentUser.getNotification();
                        System.out.println("Notifications:");
                        for (String notification : notifications) {
                            System.out.println(notification);
                        }
                        int l = currentUser.getLike();
                        System.out.println("Likes:"+l);
                        System.out.println("Press 9 to go back to the main menu.");
                        int Choice = scanner.nextInt();
                        scanner.nextLine();
                        if (Choice == 9) {
                            continue;
                        }
                        break;
                    case 3:
                        // Messages
                        List<Message> messages = socialMediaApp.getMessages(currentUser);
                        System.out.println("Messages:");
                        for (Message message : messages) {
                            System.out.println(message.getSender().getUsername() + ": " + message.getContent());
                        }
                        break;
                    case 4:
                        // Post
                        System.out.println("Enter your post content:");
                        String postContent = scanner.nextLine();
                        socialMediaApp.createPost(currentUser, postContent);
                        System.out.println("Post created successfully.");
                        break;
                    case 5:
                        // Logout
                        currentUser = null;
                        System.out.println("Logged out.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }
}