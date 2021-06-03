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
	static String[] text= {"ȥ�ڼ�","������","���ΰ�", "ģ����"};
	static RoundButton[] btn= new RoundButton[4]; 

	public fourthPageQ3() {
		super("����� ������?");
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

		Font font = new Font("a�ó׸�L", Font.PLAIN, 50);
		Font font1 = new Font("a�ó׸�L", Font.PLAIN, 30);

		title = new JLabel("���� ������?");
		title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
		subtitle = new JLabel("����� ���� �ְ��� ���� �Ϸ縦 ����, ������ ������ �����ּ���!");
		title.setHorizontalAlignment(JLabel.CENTER);
		subtitle.setHorizontalAlignment(JLabel.CENTER);

		p1.add(title);
		p1.add(subtitle);
		title.setFont(font);
		subtitle.setFont(font1);
		contentPane.add("North", p1);

		q3 = new JLabel("Q3 ���� �����?");
		q3.setFont(font1);
		for (int i=0; i < 4; i++) {
			btn[i]=new RoundButton(text[i]);//��ư �ʱ�ȭ
			btn[i].setVisible(true);//���̰�
			btn[i].setFont(font1);//��Ʈ����
			btn[i].addMouseListener(me);
			bt_p5.add(btn[i]);
		}

		p2.add(q3);		p2.add(bt_p5);
		contentPane.add("Center", p2);

		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		before = new RoundButton("��������");	before.setBackground(new Color(102, 102, 102));
		main = new RoundButton("��������");	main.setBackground(new Color(102, 102, 102));

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
			if (b.getText().equals("��������"))
			{
				//new fourthPageQ3();
				fourthPageQ3.this.setVisible(false);

			}else{
				//������������ �̵�
				new fourthPageQ2();
				fourthPageQ3.this.setVisible(false);
			}
		}
	}
}
