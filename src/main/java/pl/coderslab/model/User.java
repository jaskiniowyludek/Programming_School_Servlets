package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private int id = 0;
    private String username;
    private String password;
    private String email;
    private int user_group;

    public int getUser_group() {
        return user_group;
    }

    public void setUser_group(int user_group) {
        this.user_group = user_group;
    }

    public	User(String	username, String	email, String	password, int user_group)	{
        this.username	=	username;
        this.email	=	email;
        this.setPassword(password);
        this.user_group = user_group;

    }
    public User(){}
    public int getId(){
        return id;
    }

    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public	void	setPassword(String	password)	{
        this.password	=	BCrypt.hashpw(password,	BCrypt.gensalt());
    }
    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

}
