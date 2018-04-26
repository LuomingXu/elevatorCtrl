import javax.swing.*;
import java.awt.*;

public class elevatorDynamic extends JFrame implements Runnable
{
    //private MyPanel myPanel=new MyPanel();
    private JButton btn = new JButton("电梯");
    private JButton btnUp=new JButton("1层--上");
    private JButton btnDown=new JButton("2层--下");

    private int floor=1;
    private enum myEnum{up,down,stop}
    private myEnum status=myEnum.stop;

    elevatorDynamic()
    {
        this.setLayout(null);
        Font font=new Font("Console",Font.BOLD,36);
        Font font1=new Font("Console",Font.BOLD,18);
        btn.setVisible(true);
        btn.setBackground(Color.yellow);
        btn.setBounds(200,200,200,200);

        btnUp.setBounds(0,200,120,80);
        btnUp.setBackground(Color.white);
        btnDown.setBounds(0,0,120,80);
        btnDown.setBackground(Color.white);

        btn.setFont(font);
        btnUp.setFont(font1);
        btnDown.setFont(font1);
//        myPanel.setBounds(0,0,400,400);
//        //this.addKeyListener(new MyKeyListener());
//        //this.add(myPanel);
//        myPanel.add(btn);myPanel.add(btnUp);myPanel.add(btnDown);
//        //this.add(myPanel);
        //特别迷...这边如果添加了myPanel的话, 按钮只有在鼠标悬浮到它上面的时候才会显现...迷
        this.add(btn);
        this.add(btnUp);
        this.add(btnDown);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Thread t=new Thread(this);
        t.setName("my thread");

        btn.addActionListener(e ->
                {
                   t.start();
                }
        );
        btnUp.addActionListener(e->
        {
            status=myEnum.up;
        });
        btnDown.addActionListener(e->
        {
            status=myEnum.down;
        });
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (status == myEnum.up && floor == 1)
            {
                System.out.println(1);
                try
                {
                    btn.setLocation(200,100);
                    Thread.sleep(1000);
                    btn.setLocation(200,0);
                    floor = 2;
                    status=myEnum.stop;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if (status == myEnum.up && floor == 2)
            {
                System.out.println(2);
                try
                {
                    btn.setLocation(200,100);
                    Thread.sleep(1000);
                    btn.setLocation(200,200);
                    Thread.sleep(1000);
                    btn.setLocation(200,100);
                    Thread.sleep(1000);
                    btn.setLocation(200,0);
                    floor = 2;
                    status=myEnum.stop;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if (status == myEnum.down && floor == 2)
            {
                System.out.println(3);
                try
                {
                    btn.setLocation(200,100);
                    Thread.sleep(1000);
                    btn.setLocation(200,200);
                    floor = 1;
                    status=myEnum.stop;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
            else if (status == myEnum.down && floor == 1)
            {
                System.out.println(4);
                try
                {
                    btn.setLocation(200,100);
                    Thread.sleep(1000);
                    btn.setLocation(200,0);
                    Thread.sleep(1000);
                    btn.setLocation(200,100);
                    Thread.sleep(1000);
                    btn.setLocation(200,200);
                    floor = 1;
                    status=myEnum.stop;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if (status == myEnum.stop)
            {
                try
                {
                    System.out.println("stop sleep 1000ms");
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

