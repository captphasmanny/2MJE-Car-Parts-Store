/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 *
 * 
 */
public class AppLogin {

    private static LoginContext lc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String roots = new File("").getAbsolutePath();
        
       System.setProperty("java.security.auth.login.config", roots+"/src/jaas.config");
         String name=args[0];
    String pwd =args[1];
        try{
       lc = new LoginContext("Test", new AppCallbackHandler(name, pwd));
        lc.login();
        
    }catch(LoginException e){}
   
}
    public static void logout(){
        try{
        lc.logout();
        }catch(LoginException e){}
    }
}
    