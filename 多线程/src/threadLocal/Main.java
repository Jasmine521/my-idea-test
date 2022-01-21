package threadLocal;

public class Main {
     public static void main(String[] args){
         try(UserContext ctx = new UserContext("Bob")){
             String currentUser = UserContext.currentUser();
         }
     }
}
class UserContext implements AutoCloseable{
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user){
        ctx.set(user);
    }

    public static String currentUser(){
        return ctx.get();
    }

    @Override
    public void close(){
        ctx.remove();
    }
}