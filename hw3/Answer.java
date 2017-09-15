/**
 * Answers the respective question and also lets the user know whether the
 * question is good
 * 
 * @author monil
 */
public class Answer
{
   private String text;
   private User theuser;
   private boolean isgood;

   /**
    * gets the last author that edited the answer
    * 
    * @return the last author
    */
   public Object getLastAuthor()
   {
      return theuser.getUser();
   }

   /**
    * Sets the answer as good
    */
   public void setGood()
   {
      isgood = true;
   }

   /**
    * lets the user know whether the answer is good
    * 
    * @return the boolean value
    */
   public Object isGood()
   {
      return isgood;
   }

   /**
    * Gets the text
    * 
    * @return the text
    */
   public Object getText()
   {
      return text;
   }

   /**
    * Updates the user with the respective text
    * 
    * @param currentUser
    *           the user
    * @param string
    *           the text string
    */
   public void update(User currentUser, String string)
   {
      theuser = currentUser;
      text = string;
   }

}
