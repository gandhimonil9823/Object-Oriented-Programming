/**
 * Pots a response to a question or an answer
 * 
 * @author monil
 */
public class Post
{
   private User theuser;
   private String thestring;

   /**
    * constructs an post object
    * 
    * @param currentUser
    *           the current user loged in
    * @param string
    *           the text reply
    */
   public Post(User currentUser, String string)
   {
      theuser = currentUser;
      thestring = string;
   }

   /**
    * gets the text of the reply
    * 
    * @return the text
    */

   public Object getText()
   {
      return thestring;
   }

   /**
    * Gets the current authors name
    * 
    * @return the authors name
    */
   public Object getAuthor()
   {
      return theuser.getUser();
   }

}
