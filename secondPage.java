import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class secondPage extends JFrame{
    private Image screenImage;
    private Graphics screenGraphic;
	
    private JLabel title, sub1;
    private JTextField nameInput;
    private JButton landomButton, surveyButton;
    private ImageIcon background_img=new ImageIcon("images/start_img.png");
    JLabel imageLabel1=new JLabel();
	public String name;
    public secondPage(String msg) {
		name=msg;
		setTitle(name+"의 오늘은?");
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        //f.setBackground(new Color(255, 255, 255));
        setLayout(null);

        JPanel labelP=new JPanel();
        labelP.setBounds(550, 70, 400, 120);

        title=new JLabel("오늘의 당신은?");
        title.setFont(new Font("SansSerif", Font.BOLD, 35));
        labelP.add(title);
        sub1=new JLabel("당신의 하루를 선택해보세요");
        sub1.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelP.add(sub1);
        labelP.setBackground(new Color(255, 255, 255));
        add(labelP);

        page1.setBounds(580, 220, 349, 153);   //패널의 위치와 크기.
        add(page1);//프레임에 패널을 추가.

        landomButton=new JButton("랜덤으로 추천 받기");
		landomButton.setBackground(Color.LIGHT_GRAY);
		landomButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		//landomButton.addActionListener(new MyActionListener());
        landomButton.setBounds(480, 480, 250, 45);
        add(landomButton);

		surveyButton=new JButton("응답으로 추천 받기");
		surveyButton.setBackground(Color.LIGHT_GRAY);
		surveyButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        surveyButton.setBounds(800, 480, 250, 45);
		surveyButton.addActionListener(new MyActionListener());
        add(surveyButton);

        setSize(1500,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("응답으로 추천 받기"))
			{
				new thirdPage(secondPage.this.name);
				secondPage.this.setVisible(false);
			}
			else{
				new RouletteFrame(secondPage.this.name);
				secondPage.this.setVisible(false);
			}
		}
	}

    static JPanel page1=new JPanel() {
        Image background=new ImageIcon("images/start_img.png").getImage();
        public void paint(Graphics g) {//그리는 함수
            g.drawImage(background, 0, 0, null);
        }
    };

}
