/**
 * The user class helps the users login into their accounts or signup as new
 * members.
 * 
 * @author monil
 */

public class User
{
   private String username;
   private String password;
   private boolean yesInstructor;

   /**
    * Creates two different enums as INSTRUCTOR and STUDENT
    */
   public enum Type
   {
      STUDENT, INSTRUCTOR;
   }

   /**
    * Constructors an User object
    * 
    * @param string
    *           the username
    * @param string2
    *           the password
    * @param instructor
    *           enum type
    */
   public User(String string, String string2, Type instructor)
   {
      username = string;
      password = string2;
      if (Type.INSTRUCTOR == instructor)
      {
         yesInstructor = true;
      } else
      {
         yesInstructor = false;
      }
   }

   /**
    * Checks whether the user is an instructor
    * 
    * @return the boolean value
    */

   public boolean isInstructor()
   {
      return this.yesInstructor;
   }

   /**
    * Gives the user the authentication to login
    * 
    * @param username2
    *           the username
    * @param password2
    *           the password
    * @return the boolean value
    */

   public boolean authenticate(String username2, String password2)
   {

      if (username2.equals(username) && password2.equals(password))
      {
         return true;
      } else
      {
         return false;
      }
   }

   /**
    * Gives the username of the required user
    * 
    * @return the string
    */
   public String getUser()
   {
      return username;
   }

}
