package by.radyuk.myautobase.model.entity;

/**
 * The User Entity
 */
public class User{
    private Long userId = -1L;
    private String login;
    private String password;
    private String email;
    private Role role;
    private String name;
    private String surname;



    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return userId.equals(user.userId)
                &&
                login.equals(user.login)
                &&
                email.equals(user.email)
                &&
                role.equals(user.role)
                &&
                name.equals(user.name)
                &&
                surname.equals(user.surname)
                &&
                password.equals(user.password);
    }

    @Override
    public int hashCode(){
        int result = userId.hashCode();
        result = result * 31 + login.hashCode();
        result = result * 31 + email.hashCode();
        result = result * 31 + role.hashCode();
        result = result * 31 + name.hashCode();
        result = result * 31 + surname.hashCode();
        result = result * 31 + password.hashCode();
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("User{").append("userId = ").append(userId).append(", login = ").append(login).append("," +
                " email = ").append(", role = ").append(role.toString()).append(", name = ").append(name.toString()).append(", surname = ").append(surname.toString());
        return sb.toString();
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        public final User user;

        public Builder(){
            user = new User();
        }

        public Builder setUserId(Long userId){
            user.setUserId(userId);
            return this;
        }

        public Builder setLogin(String login){
            user.setLogin(login);
            return this;
        }

        public Builder setEmail(String email){
            user.setEmail(email);
            return this;
        }

        public Builder setRole(Role role){
            user.setRole(role);
            return this;
        }

        public Builder setName(String name){
            user.setName(name);
            return this;
        }

        public Builder setSurname(String surname){
            user.setSurname(surname);
            return this;
        }

        public Builder setPassword(String password){
            user.setPassword(password);
            return this;
        }

        public User build(){
            return user;
        }


    }
}
