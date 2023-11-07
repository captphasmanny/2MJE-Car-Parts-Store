    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 *
 */
import java.io.BufferedReader;
import java.util.Base64;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.CryptoPrimitive;
import java.util.Scanner;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class AppLoginModule implements LoginModule {
         
//        private static String client_name/*="name"*/;
//        private static String psswd/*="psswd"*/;
        private static String client_id/*= "123"*/;
	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map sharedState;
	private Map options;
        
         
	private boolean succeeded = false;
        private static File psswdFile = new File("psswd.txt");
        public static String getClientName(String id){
            
            Scanner sc=null;
            try {
                sc = new Scanner(psswdFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppLoginModule.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(sc.hasNext())
                if(sc.next().equals(id))
                    return sc.next();
                else 
                    return null;
            return null;
        }
        public static boolean verifyPassword(String client_name, String psswd)
        {
            String s= getPassword(client_name);
            if(s != null)
                return(encrypt(psswd).equals(s));
            else
            return false;
        }
        private static synchronized String getPassword(String userName)
        {
            Scanner sc = null;
            try {
                 sc = new Scanner(psswdFile);
            } catch (FileNotFoundException ex) {
                
                Logger.getLogger(AppLoginModule.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            while(sc.hasNext())
             if(sc.next().equals(userName))
                 return sc.next();
             
             return null;
                     
        }
        public static synchronized String encrypt(String plaintext)
        {
            MessageDigest md=null;
            try {
                md = MessageDigest.getInstance("SHA");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AppLoginModule.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                md.update(plaintext.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AppLoginModule.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte raw[] = md.digest();
            String hash = Base64.getEncoder().encodeToString(raw);
            return hash;
            
        }
        
        public static void setNewPassword(String client_name, String client_id)
        {
            
                         
             try{
                 String line; String input = "";
                BufferedReader file = new BufferedReader(new FileReader(psswdFile));
                while((line = file.readLine())!=null){
                     Scanner sc = new Scanner(line);
                     String s = null; 
                     while(sc.hasNext()){
                          s=sc.next();
                          
                          if(s.equals(client_name))
                             line=line.replace(sc.next(), "");
                     }
                     line = line.replace(client_name, client_name+ " " + encrypt(client_id)+ " ");
                     
                    input +=line + '\n';
                }
                file.close();
                BufferedWriter br = new BufferedWriter(new FileWriter(psswdFile));
                br.write(input);
                br.close();
                
            }catch(IOException e){}
            
        }
        public static void saveNewClient(String client_name, String psswd)
        {
            try{
                BufferedWriter br = new BufferedWriter(new FileWriter(psswdFile, true));
                br.write(client_name +" "+encrypt(psswd)+ " "  );
                br.close();
            }catch(IOException e){}
            
        }
        public static void setPsswdFile()
        {
            try{
                BufferedWriter br = new BufferedWriter(new FileWriter(psswdFile));
                br.write("123"+" "+"name" +" "+encrypt("psswd")+ " "  );
                br.close();
            }catch(IOException e){}
            
        }
        public static boolean psswdFileExists()
        {
            if(psswdFile.isFile())
            {
                return true;
            }
            else
                return false;
        }
	public AppLoginModule() {
		//System.out.println("Login Module - constructor called");
                
	}

	public boolean abort() throws LoginException {
		//System.out.println("Login Module - abort called");
		return false;
	}
        public static boolean verifyId(String id)
        {
            Scanner sc=null;
            try {
                sc = new Scanner(psswdFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AppLoginModule.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(sc.hasNext())
                if(sc.next().equals(id))
                    return true;
                else 
                    return false;
            
            return false;
        }
//        public static void setPassword(String password)
//        {
//            
//            psswd=password;
//        }
	public boolean commit() throws LoginException {
		//System.out.println("Login Module - commit called");
		return succeeded;
	}

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {

		//System.out.println("Login Module - initialize called");
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;

		//System.out.println("testOption value: " + (String) options.get("testOption"));

		succeeded = false;
	}

	public boolean login() throws LoginException {
		//System.out.println("Login Module - login called");
		if (callbackHandler == null) {
			throw new LoginException("Oops, callbackHandler is null");
		}

		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("name:");
		callbacks[1] = new PasswordCallback("password:", false);

		try {
			callbackHandler.handle(callbacks);
		} catch (IOException e) {
			throw new LoginException("Oops, IOException calling handle on callbackHandler");
		} catch (UnsupportedCallbackException e) {
			throw new LoginException("Oops, UnsupportedCallbackException calling handle on callbackHandler");
		}

		NameCallback nameCallback = (NameCallback) callbacks[0];
		PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];

		String name = nameCallback.getName();
		String password = new String(passwordCallback.getPassword());

                
                
		if (verifyPassword(name, password))/*client_name.equals(name) && psswd.equals(password))*/ {
			  
                        System.out.println("Success! You get to log in!");
			succeeded = true;
                        commit();
                        if(!POS.isEmployee())
                       //run program here
                         POS.toggleEmployee();
                         POS.getLogout_Button().setText("Log Out");
                         POS.getMain().remove(POS.getLogout_Button());
                      
                        
                        
                         POS.getMain().add(POS.getLogout_Button(), new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 50, 100, 30));
                         POS.getMain().add(POS.getSaleButton(), new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 420, 150, 98));
                         POS.getMain().revalidate();
                         POS.getMain().repaint();
                      
                         return succeeded;
		} else {
			System.out.println("Failure! You don't get to log in");
			succeeded = false;
                      
			throw new FailedLoginException("Sorry! No login for you.");
		}
	}

	public  boolean logout() {
		//System.out.println("Login Module - logout called");
                
                        if(POS.isEmployee())
                        POS.toggleEmployee();
                        POS.resetOptions("Add to Cart");
                        POS.getLogout_Button().setText("Log in");
                       
                        POS.getMain().remove(POS.getBglabel());                  
                        POS.getButton().revalidate();
                        POS.getButton().repaint();
                        POS.getItem().setViewportView(POS.getButton());
                        POS.getMain().add(POS.getItem(), new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 155, 685, 480));
                        
                        
                        POS.getMenubar().revalidate();
                        POS.getMain().remove(POS.getAdd());
                        POS.getMain().remove(POS.getPrint());
                        POS.getMain().add(POS.getBglabel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0, 1400,768));
                        POS.getMain().remove(POS.getSaleButton());
                        POS.getMain().remove(POS.getPanel());
                        POS.getMain().revalidate();
                        POS.getMain().repaint();
                
		return false;
	}

}