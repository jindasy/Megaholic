/*Java Program to switch between frames using buttons*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SwitchFrame implements ActionListener
{
    static JFrame frame1;
    static JFrame frame2;
    static JFrame frame3;
    static JButton one;
    static JButton two;
    static JButton close;
    static JButton playAgain2;
    //Driver function
    public static void main(String args[])
    {

        //Create frame 1
        frame1 = new JFrame("Frame 1");
        frame1.setSize(250,250);
        frame1.setLayout(null);
        JLabel title = new JLabel("Megaholic");

        //Create next and close buttons
        one = new JButton("One");
        two = new JButton("Two");
        close = new JButton("Close");
        title.setBounds(10,2,700,100);
        one.setBounds(75,90,100,50);
        two.setBounds(75,150,100,50);

        title.setFont(new Font("Verdana", Font.BOLD, 40));
        one.setFont(new Font("Verdana", Font.PLAIN, 20));
        two.setFont(new Font("Verdana", Font.PLAIN, 20));
        //Add the buttons to frame 1
        frame1.add(title);
        frame1.add(one);
        frame1.add(two);
        frame1.add(close);
        //Create an object
        SwitchFrame obj=new SwitchFrame();
        //Associate ActionListener with the buttons
        one.addActionListener(obj);
        two.addActionListener(obj);
        close.addActionListener(obj);
        //Display frame 1
        frame1.setVisible(true);
    }
    //Function to perform actions related to button clicked
    public void actionPerformed(ActionEvent e)
    {
        String button=e.getActionCommand();
        if(button.equals("One"))
        {
            frame1.dispose();
            create_frame2();
        }
        if(button.equals("Two"))
        {
            frame1.dispose();
            create_frame3();
        }
        if(button.equals("Close"))
        {
            frame1.dispose();
        }
        if(button.equals("Play again"))
        {
            frame3.dispose();
        }
    }
    //function to create Frame 2
    public static void create_frame2()
    {
        //Create frame 2
        frame2 = new Window();
        frame2.setVisible(true);
    }
    //function to create Frame 2
    public static void create_frame3()
    {
        //Create frame 2
        frame3 = new Window2();
        frame3.setVisible(true);


    }
}