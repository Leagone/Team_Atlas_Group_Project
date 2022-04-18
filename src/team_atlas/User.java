package team_atlas;

public class User {
    private String password, emailAddress, firstName, lastName, userID;
    private boolean isTeacher;

    User(String userID, String password, String emailAddress, String firstName, String lastName, Boolean isTeacher) {
        this.userID = userID;
        this.password = password;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isTeacher = isTeacher;
    }

    public void getInfo() {
        System.out.println(userID);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(emailAddress);
        System.out.println("Teacher: " + isTeacher);
    }
}
