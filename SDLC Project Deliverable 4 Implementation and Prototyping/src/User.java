// Lucas Phillips, CIS 340 T/TH 1:30-2:45, SDLC Project - Deliverable 4: Implementation/Prototyping

public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    
    public String getRole() {
    	return role;
    }
    
    public boolean checkPassword(String pw) {
        return password.equals(pw);
    }
    
    public boolean canCreateEvents() {
    	return role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("officer");
    }
}