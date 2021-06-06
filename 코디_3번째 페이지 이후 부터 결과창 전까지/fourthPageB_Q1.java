import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;

public class fourthPageB_Q1 extends JFrame {
	JPanel p1, p2, bt_p3, bottom, contentPane;
	JLabel title, subtitle, q1;
	String username;
	RoundButton main;
	static String[] text= {"����","����/������","�� ��", "�ҽ���/�߿�"};
	static RoundButton[] btn= new RoundButton[4]; 
	public String name;
	public fourthPageB_Q1(String msg) {
		name=msg;
		setTitle(name+"�� ������?");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1, 10, 7));
		p2 = new JPanel();
		//p2.setBounds(150, 250, 500, 700);
		p2.setBorder(BorderFactory.createEmptyBorder(0 , 200 , 100 , 200));
		MouseEv me = new MouseEv();

		p2.setLayout(new GridLayout(6, 1, 10, 10));
		bt_p3 = new JPanel();
		bt_p3.setLayout(new GridLayout(1, 4, 10, 40));

		Font font = new Font("a�ó׸�L", Font.PLAIN, 45);
		Font font1 = new Font("a�ó׸�L", Font.PLAIN, 30);

		title = new JLabel(name+"���� ������?");
		title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
		subtitle = new JLabel("����� ���� �ְ��� ���� �Ϸ縦 ����, ������ ������ �����ּ���!");
		title.setHorizontalAlignment(JLabel.CENTER);
		subtitle.setHorizontalAlignment(JLabel.CENTER);

		p1.add(title);
		p1.add(subtitle);
		title.setFont(font);
		subtitle.setFont(font1);
		contentPane.add("North", p1);

		q1 = new JLabel("Q2 ������ ������ �����?");
		q1.setFont(font1);
		for (int i=0; i < 4; i++) {
			btn[i]=new RoundButton(text[i]);//��ư �ʱ�ȭ
			btn[i].setVisible(true);//���̰�
			btn[i].setFont(font1);//��Ʈ����
			btn[i].addMouseListener(me);
			bt_p3.add(btn[i]);
		}

		//�������� ��ư �̺�Ʈ ���
		for (int i=0;i<4 ;i++ ){
			btn[i].addActionListener(new AnswerListener());
		}

		p2.add(q1);		p2.add(bt_p3);
		contentPane.add("Center", p2);

		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());

		main = new RoundButton("��������");	main.setBackground(new Color(102, 102, 102));
		main.addActionListener(new MyActionListener());

		bottom.add("West",main);
		bottom.setBorder(BorderFactory.createEmptyBorder(0 , 80 , 50 , 80));
		contentPane.add("South", bottom);


		setSize(1500,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	  public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(150, 200, 1350, 200);
    }

	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("��������")){
				//������������ �̵�
				new ClothesQ1(fourthPageB_Q1.this.name);
				fourthPageB_Q1.this.setVisible(false);
			}
		}
	}

// ������ ���� ��� �̺�Ʈ
private class AnswerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("����")){
					new ClothesB_1Q2(fourthPageB_Q1.this.name);
					fourthPageB_Q1.this.setVisible(false);
			}else if (b.getText().equals("����/������")){
					new ClothesB_2Q2(fourthPageB_Q1.this.name);
					fourthPageB_Q1.this.setVisible(false);
			}else if (b.getText().equals("�� ��")){
					new ClothesB_3Q2(fourthPageB_Q1.this.name);
					fourthPageB_Q1.this.setVisible(false);
			}else{
				new ClothesB_2Q2(fourthPageB_Q1.this.name);
				fourthPageB_Q1.this.setVisible(false);
			}
		}
	}
}
