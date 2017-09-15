import java.util.ArrayList;
import java.util.List;

/**
 * A class which helps with the followUpDiscussion
 * 
 * @author monil
 */
public class FollowupDiscussion
{
   private User current;
   private String followup;
   private boolean follow;
   List<Post> reply = new ArrayList<Post>();

   /**
    * Gets the reply count
    * 
    * @return the count
    */
   public int getReplyCount()
   {
      return reply.size();
   }

   /**
    * Gets the reply
    * 
    * @param followupreplyid
    *           the id
    * @return the post object
    */
   public Post getReply(int followupreplyid)
   {

      return reply.get(followupreplyid);
   }

   /**
    * Add the reply
    * 
    * @param p
    *           the post object
    * @return the count
    */

   public int addReply(Post p)
   {
      reply.add(p);
      return reply.size() - 1;

   }

   /**
    * Whether the question is resolved
    * 
    * @return the boolean value
    */

   public Object isResolved()
   {
      return follow;
   }

   /**
    * Gets the user
    * 
    * @return the user
    */

   public Object getAuthor()
   {
      return current.getUser();
   }

   /**
    * gets the text
    * 
    * @return the text
    */
   public Object getText()
   {
      return followup;
   }

   /**
    * Sets the question as resolved
    */
   public void resolve()
   {
      follow = true;
   }

   /**
    * Update the discussion
    * 
    * @param currentUser
    *           the user
    * @param string
    *           the string value
    */
   public void update(User currentUser, String string)
   {
      current = currentUser;
      followup = string;
   }

}
