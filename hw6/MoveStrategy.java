import java.util.List;
/**
 * An interface to process shapes
 * @author monil
 *
 */
public interface MoveStrategy
{
   /**
    * a method to process shapes
    * @param shapes the shapes
    */
   void process(List<MoveableShape> shapes);
}
