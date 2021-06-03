import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class fourthPageQ3 extends JFrame {
	JPanel p1, p2,  bt_p5, bottom, contentPane;
	JLabel title, subtitle,q3;
	String username;
	RoundButton before, main;
	static String[] text= {"혼자서","가족과","연인과", "친구와"};
	static RoundButton[] btn= new RoundButton[4]; 

	public fourthPageQ3() {
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
		bt_p5 = new JPanel();
		bt_p5.setLayout(new GridLayout(1, 4, 10, 40));

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

		q3 = new JLabel("Q3 오늘 당신은?");
		q3.setFont(font1);
		for (int i=0; i < 4; i++) {
			btn[i]=new RoundButton(text[i]);//버튼 초기화
			btn[i].setVisible(true);//보이게
			btn[i].setFont(font1);//폰트설정
			btn[i].addMouseListener(me);
			bt_p5.add(btn[i]);
		}

		p2.add(q3);		p2.add(bt_p5);
		contentPane.add("Center", p2);

		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		before = new RoundButton("다음으로");	before.setBackground(new Color(102, 102, 102));
		main = new RoundButton("이전으로");	main.setBackground(new Color(102, 102, 102));

		before.addActionListener(new MyActionListener());
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
			if (b.getText().equals("다음으로"))
			{
				//new fourthPageQ3();
				fourthPageQ3.this.setVisible(false);

			}else{
				//이전페이지로 이동
				new fourthPageQ2();
				fourthPageQ3.this.setVisible(false);
			}
		}
	}
}
