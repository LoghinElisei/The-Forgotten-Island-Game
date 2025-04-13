package PaooGame.Graphics;

import javax.swing.*;
import java.awt.*;

public class Button {
    private Rectangle bounds;
    private String label;


    public Button(String label, Rectangle rect) {
        this.label = label;
        this.bounds = rect;
    }

    public void draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.setColor(Color.BLACK);
        g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(label);
        int textHeight = fm.getHeight();

        g.drawString(label, bounds.x + (bounds.width - textWidth) / 2,
                            bounds.y + (bounds.height + textHeight / 2) / 2);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getLabel()
    {
        return label;
    }

    public boolean contains(Point p) {
        return bounds.contains(p);
    }
}
