import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;

public class PersonNode extends CircleNode
{
    public PersonNode()
    {
        super(Color.WHITE);
        super.setSize(50);
        setImageURL("http://horstmann.com/sjsu/spring2017/cs151/lecture17/default.png");
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
       this.imageURL = imageURL;
       try
       {
//          icon = new ImageIcon(new URL(imageURL));
          image = new ImageIcon(new URL(imageURL)).getImage();
       } 
       catch (IOException ex)
       {         
       }
    }
    
    @Override
    public void draw(Graphics2D g2)
    {
        if (image == null)
            return;
        
        Shape oldClip = g2.getClip();
        Rectangle2D bounds = getBounds();
        g2.setClip(new Ellipse2D.Double((int) bounds.getX(), (int) bounds.getY(), 50, 50));
//        icon.paintIcon(null, g2, (int) bounds.getX(), (int) bounds.getY());
        
        double width = image.getWidth(null);
        double height = image.getHeight(null);
        double scale = Math.min(bounds.getWidth() / width, bounds.getHeight() / height);
        width = scale * width;
        height = scale * height;
        g2.drawImage(image, (int) (bounds.getX() + bounds.getWidth() - width), 
                    (int) (bounds.getY() + bounds.getHeight() - height), 
                    (int) width, (int) height, null);
        
        g2.setClip(oldClip);
//        super.draw(g2);
    }

    private String imageURL;
    private Image image;
}
