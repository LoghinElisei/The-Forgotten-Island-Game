package PaooGame.Graphics;

import javax.swing.*;
import java.awt.*;

public class Button {
    private Rectangle bounds;
    private String label;
    private boolean hovered = false;

    public Button(String label, Rectangle rect) {
        this.label = label;
        this.bounds = rect;
    }

    public void draw(Graphics g, Color background, Color text, Color hoverColor) {
        g.setColor(hovered ? hoverColor : background);
        if (hovered)
        {
            g.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 20, 20);
        }
        g.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 20, 20);

        g.setColor(text);
        g.setFont(new Font("Merriweather", Font.BOLD, 22));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(label);
        int textHeight = fm.getHeight();

        g.drawString(label, bounds.x + (bounds.width - textWidth) / 2,
                            bounds.y + (bounds.height + textHeight / 2) / 2);
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
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
