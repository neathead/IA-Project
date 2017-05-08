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
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected,
            boolean hasFocus, int row,
            int column) {
        table.setShowGrid(false);

        ImageLoader loader = ImageLoader.getLoader();
        setText("");

        switch ((Integer) value) {
            case 0:
                setIcon(loader.getIcon(Properties.EMPTY_IMAGE));
                break;
            case 1:
                setIcon(loader.getIcon(Properties.CAR));
                break;
            case 2:
                setIcon(loader.getIcon(Properties.WALLH));
                break;
            case 3:
                setIcon(loader.getIcon(Properties.WALLV));
                break;
            case 4:
                setIcon(loader.getIcon(Properties.WALLH2));
                break;
            case 5:
                setIcon(loader.getIcon(Properties.WALLV2));
                break;
            case 6:
                setIcon(loader.getIcon(Properties.WALLH3));
                break;
            case 7:
                setIcon(loader.getIcon(Properties.WALLV3));
                break;
            case 8:
                setIcon(loader.getIcon(Properties.WALLH4));
                break;
            case 9:
                setIcon(loader.getIcon(Properties.WALLV4));
                break;
            case 10:
                setIcon(loader.getIcon(Properties.DOOR));
                break;
        }
        return this;
    }
}
