package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import utils.ImageLoader;

public class PuzzleTileCellRenderer extends JLabel implements TableCellRenderer {

    public PuzzleTileCellRenderer() {
        setBackground(Color.WHITE);
        setOpaque(true);
        //setFont(new Font("Monospaced", Font.BOLD, 50));
        //this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus, int row,
            int column) {
        
        //table.setShowGrid(false);
        
        //String text = (((Integer) value).intValue() == 0) ? "" : ((Integer) value).toString();
        //setText(text);

        ImageLoader loader = ImageLoader.getLoader();
        setText("");
        if (((Integer) value).intValue() == 0) {
            setIcon(loader.getIcon(Properties.EMPTY_IMAGE));
        } else {
            setIcon(loader.getIcon(Properties.IMAGE_PREFIX + ((Integer) value).intValue() + Properties.IMAGE_SUFFIX));
        }
        return this;
    }
}
