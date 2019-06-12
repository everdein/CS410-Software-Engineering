// Import libraries.
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.Position;
import javax.swing.text.StyledDocument;
import javax.swing.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

// Creates simple notepad class, extends JFrame class and implements ActionListener and MenuListener interfaces.
public class SimpleNotePadRefactored extends JFrame implements ActionListener, MenuListener
{
    // Creates menu objects.
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu editMenu = new JMenu("Edit");
    private JMenu subMenu = new JMenu("Open Recent Files");
    private JTextPane textPane = new JTextPane();
    private JMenuItem newFileButton = new JMenuItem("New File");
    private JMenuItem openFileButton = new JMenuItem("Open File");
    private JMenuItem saveFileButton = new JMenuItem("Save File");
    private JMenuItem printFileButton = new JMenuItem("Print File");
    private JMenuItem undoButton = new JMenuItem("Undo");
    private JMenuItem copyButton = new JMenuItem("Copy");
    private JMenuItem pasteButton = new JMenuItem("Paste");
    private JMenuItem replaceButton = new JMenuItem("Replace");

    private Stack<String> recentFiles = new Stack<>(); //Stack created to use for storing the most recent files

    // Adds menu buttons and menu.
    public SimpleNotePadRefactored()
    {
        setTitle("A Simple Notepad Tool");
        fileMenu.add(newFileButton);
        fileMenu.addSeparator();
        fileMenu.add(openFileButton);
        fileMenu.addSeparator();
        fileMenu.add(subMenu);
        fileMenu.addSeparator();
        fileMenu.add(saveFileButton);
        fileMenu.addSeparator();
        fileMenu.add(printFileButton);
        editMenu.add(copyButton);
        editMenu.add(pasteButton);
        editMenu.add(undoButton);
        editMenu.add(replaceButton);
        newFileButton.addActionListener(this);
        newFileButton.setActionCommand("new");
        openFileButton.addActionListener(this);
        openFileButton.setActionCommand("open");
        subMenu.addMenuListener(this);
        subMenu.setActionCommand("recent");
        saveFileButton.addActionListener(this);
        saveFileButton.setActionCommand("save");
        printFileButton.addActionListener(this);
        printFileButton.setActionCommand("print");
        undoButton.addActionListener(this);
        undoButton.setActionCommand("undo");
        copyButton.addActionListener(this);
        copyButton.setActionCommand("copyButton");
        pasteButton.addActionListener(this);
        pasteButton.setActionCommand("paste");
        replaceButton.addActionListener(this);
        replaceButton.setActionCommand("replace");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);
        add(new JScrollPane(textPane));
        setPreferredSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    // Creates action listener if else block to call functionality methods.
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("new"))
        {
            newFile();
        }
        else if (actionCommand.equals("open"))
        {
            openFile();
        }
        else if (actionCommand.equals("save"))
        {
            saveFile();
        }
        else if (actionCommand.equals("print"))
        {
            print();
        }
        else if (actionCommand.equals("undo"))
        {
            undo();
        }
        else if (actionCommand.equals("copyButton"))
        {
            copy();
        }
        else if (actionCommand.equals("paste"))
        {
            paste();
        }
        else if (actionCommand.equals("replace"))
        {
            replace();
        }
        else if (recentFiles.contains(actionCommand))
        {
            String filePath = actionCommand;
            openFile(filePath);
        }
    }

    // Creates new file.
    public  void newFile()
    {
        textPane.setText("");
    }

    // Creates open file.
    public void openFile()
    {
        JFileChooser openFileFC = new JFileChooser();
        int returnValOpen = openFileFC.showOpenDialog(null);
        if (returnValOpen == JFileChooser.APPROVE_OPTION)
        {
            String filePath = openFileFC.getSelectedFile().getAbsolutePath();
            openFile(filePath);
        }
    }

    // Overloads openFile method and accepts a filePath String, reads the file,
    // prints the text to the String as well as calls a method to push the filePath
    // to a stack (to use for opening recent files).
    public void openFile(String filePath)
    {
        String line = "";
        try
        {
            Scanner textReader = new Scanner(new FileReader(filePath));
            pushRecentFiles(filePath);
            while (textReader.hasNext())
            {
                line += textReader.nextLine() + '\n';
            }

            textPane.setText(line);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open");
        }
    }

    // Pushes the most recently opened file to the top of the stack for
    // priority listing in the "Open Recent Files" menu.
    public void pushRecentFiles(String filePath)
    {
        if (recentFiles.contains(filePath))
        {
            recentFiles.remove(filePath);
        }
        recentFiles.push(filePath);
    }

    // When the user mouses over "Open Recent Files" a menu is generated
    // via the generateRecentFileMenu() method.
    @Override
    public void menuSelected(MenuEvent e)
    {
        generateRecentFileMenu();
    }

    // Mousing away from the menu removes or refreshes the menu.
    @Override
    public void menuDeselected(MenuEvent e)
    {
        subMenu.removeAll();
    }

    // Creates a new menu item for every item within the stack.
    public void generateRecentFileMenu()
    {
       Stack<String> duplicatedStack = generateDuplicateStack();
       while (!duplicatedStack.isEmpty())
       {
           String filePath = duplicatedStack.pop();
           JMenuItem menuItem = new JMenuItem(filePath);
           subMenu.add(menuItem);
           menuItem.addActionListener(this);
           menuItem.setActionCommand(filePath);
           menuItem.setVisible(true);
       }
    }

    // Creates a duplicate stack via a temp stack and the original stack which is used in the
    // generateRecentFileMenu method. Duplicate Stack items (file path strings) are popped and
    // then stored as new menuItems
    public Stack<String> generateDuplicateStack()
    {
        Stack<String> tempStack = new Stack<>();
        Stack<String> duplicateStack = new Stack<>();
        int count = 0;
        while (!recentFiles.isEmpty() && count < 5) //restricts the open recent list to 5 files
        {
            String poppedValue = recentFiles.pop(); //pop original stack and push values to temp stack
            tempStack.push(poppedValue);
            count++;
        }

        while (!tempStack.isEmpty())
        {
            String poppedValue = tempStack.pop(); //empty temp stack and push values to duplicate and original
            duplicateStack.push(poppedValue);
            recentFiles.push(poppedValue);
        }

        return duplicateStack;
    }

    //User selects "Save File" from the menu list
    public void saveFile()
    {
        File fileToWrite = null;
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            fileToWrite = fc.getSelectedFile();
        }
        try
        {
            PrintWriter out = new PrintWriter(new FileWriter(fileToWrite));
            out.println(textPane.getText());
            JOptionPane.showMessageDialog(null, "File is saved successfully...");
            out.close();
        }
        catch (IOException ex) {}
    }

    // Opens print functionality.
    public void print()
    {
        try
        {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("Sample Command Pattern");
            pjob.setCopies(1);
            pjob.setPrintable(new Printable()
            {
                public int print(Graphics pg, PageFormat pf, int pageNum)
                {
                    if (pageNum>0)
                    {
                        return Printable.NO_SUCH_PAGE;
                    }
                    pg.drawString(textPane.getText(), 500, 500);
                    paint(pg);
                    return Printable.PAGE_EXISTS;
                }
            });
            if (pjob.printDialog() == false)
            {
                return;
            }
             pjob.print();
        }
        catch (PrinterException pe)
        {
            JOptionPane.showMessageDialog(null,
                    "Printer error" + pe, "Printing error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Implement undo feature.
    public void undo()
    {
        // TODO: implement undo operation
    }

    // Copies text.
    public void copy()
    {
        textPane.copy();
    }

    // Pastes text.
    public void paste()
    {
        StyledDocument doc = textPane.getStyledDocument();
        Position position = doc.getEndPosition();
        System.out.println("offset"+position.getOffset());
        textPane.paste();
    }

    // Replaces current text with copied text.
    public void replace()
    {
        paste();
    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
