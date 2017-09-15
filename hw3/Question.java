import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * A question class to help the user ask a question
 * 
 * @author monil
 */

public class Question
{
   private String question;
   private User userQuestion;
   private boolean good;
   private Answer instructorAnswer;
   private Answer studentAnswer;
   Set<User> viewers = new HashSet<>();
   List<FollowupDiscussion> followups1 = new ArrayList<FollowupDiscussion>();

   /**
    * helps the user update the question
    * 
    * @param currentUser
    *           the user
    * @param string
    *           the text string
    */
   public void update(User currentUser, String string)
   {
      question = string;
      userQuestion = currentUser;
   }

   /**
    * Sets the question as good
    */
   public void setGood()
   {
      good = true;

   }

   /**
    * Gets the answer answered by the instructor
    * 
    * @return the instructors answer
    */
   public Answer getInstructorAnswer()
   {
      if (instructorAnswer == null)
      {
         this.instructorAnswer = new Answer();
      }
      return this.instructorAnswer;
   }

   /**
    * Gets the answer answered by the student
    * 
    * @return the students answer
    */
   public Answer getStudentAnswer()
   {
      if (studentAnswer == null)
      {
         this.studentAnswer = new Answer();
         // return this.studentAnswer;
      }
      return this.studentAnswer;
   }

   /**
    * Gets the question text
    * 
    * @return the text
    */

   public Object getText()
   {
      return this.question;
   }

   /**
    * Gets the discussion count
    * 
    * @return the count
    */

   public int getFollowupCount()
   {
      return followups1.size();
   }

   /**
    * Gets the followupdiscussion
    * 
    * @param followupid
    *           the followupid
    * @return the discussion
    */

   public FollowupDiscussion getFollowup(int followupid)
   {
      return followups1.get(followupid);
   }

   /**
    * Adds the discussion
    * 
    * @param followup
    *           the discussion
    * @return the id
    */

   public int add(FollowupDiscussion followup)
   {
      followups1.add(followup);
      return followups1.size() - 1;
   }

   /**
    * Gets the last author
    * 
    * @return the author
    */

   public Object getLastAuthor()
   {
      return userQuestion.getUser();
   }

   /**
    * The total views
    * 
    * @param currentUser
    *           the user
    * @return the count
    */

   public Object view(User currentUser)
   {
      viewers.add(currentUser);
      return viewers.size();
   }

   /**
    * Returns the boolean value of the object
    * 
    * @return the boolean value
    */

   public Object isGood()
   {
      return good;
   }

}
