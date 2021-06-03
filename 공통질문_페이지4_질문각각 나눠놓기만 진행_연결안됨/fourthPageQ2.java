import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class fourthPageQ2 extends JFrame {
	JPanel p1, p2, bt_p4, bottom, contentPane;
	JLabel title, subtitle, q2;
	String username;
	RoundButton before, main;
	static String[] text= {"기쁨/신남","우울/지침","심심", "화남"};
	static RoundButton[] btn= new RoundButton[4]; 

	public fourthPageQ2() {
		super("당신의 오늘은?");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1, 30, 30));
		p2 = new JPanel();
		//p2.setBounds(150, 250, 500, 700);
		p2.setBorder(BorderFactory.createEmptyBorder(0 , 200 , 100 , 200));
		MouseEv me = new MouseEv();

		p2.setLayout(new GridLayout(6, 1, 10, 10));
		bt_p4 = new JPanel();
		bt_p4.setLayout(new GridLayout(1, 4, 10, 40));


		Font font = new Font("a시네마L", Font.PLAIN, 50);
		Font font1 = new Font("a시네마L", Font.PLAIN, 30);

		title = new JLabel("이의 오늘은?");
		title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
		subtitle = new JLabel("당신을 위한 최고의 오늘 하루를 위해, 다음의 질문에 답해주세요!");
		title.setHorizontalAlignment(JLabel.CENTER);
		subtitle.setHorizontalAlignment(JLabel.CENTER);

		p1.add(title);
		p1.add(subtitle);
		title.setFont(font);
		subtitle.setFont(font1);
		contentPane.add("North", p1);

		q2 = new JLabel("Q2 오늘의 기분은 어떤가요?");
		q2.setFont(font1);

		for (int i=0; i < 4; i++) {
			btn[i]=new RoundButton(text[i]);//버튼 초기화
			btn[i].setVisible(true);//보이게
			btn[i].setFont(font1);//폰트설정
			btn[i].addMouseListener(me);
			bt_p4.add(btn[i]);
		}

		p2.add(q2);		p2.add(bt_p4);

		contentPane.add("Center", p2);

		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());

		main = new RoundButton("이전으로");	main.setBackground(new Color(102, 102, 102));


		main.addActionListener(new MyActionListener());

		bottom.add("West",main);
		bottom.setBorder(BorderFactory.createEmptyBorder(0 , 80 , 50 , 80));
		contentPane.add("South", bottom);


		setSize(1500,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("이전으로"))
			{
				//이전페이지로 이동
				new fourthPageQ1();
				fourthPageQ2.this.setVisible(false);

			}
		}
	}
}
