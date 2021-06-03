import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

//Ƽ, �ݹ���, �ȭ
class Clothesgraphic1 extends JPanel implements ActionListener{
	JLabel option;
	JButton button,button1,button2;
	Color color=new Color(255,255,255);
	Color color1=new Color(0,0,255);
	Color color2=new Color(0,128,0);
	Color color3=new Color(0,0,255);
	Color color4=new Color(255,255,255);
	String a,b,c;
	public Clothesgraphic1() {
		setLayout(null);

		option=new JLabel("�Ʒ� ��ư�� ���� ���� ��ȭ���Ѻ�����~");
		Font font1 = new Font("a�ó׸�L", Font.BOLD, 20);
		option.setFont(font1);
		option.setHorizontalAlignment(JLabel.CENTER);
		option.setSize(400,20);
		option.setLocation(650,35);
		add(option);

		//���� �ٲٴ� ��ư
		button=new JButton("���� ����ȭ");
		button.setLocation(730,100);
		button.setSize(200,30);
		add(button);
		button.addActionListener(this);

		button1=new JButton("���� ����ȭ");
		button1.setLocation(730,150);
		button1.setSize(200,30);
		add(button1);
		button1.addActionListener(this);

		button2=new JButton("�Ź� ����ȭ");
		button2.setLocation(730,200);
		button2.setSize(200,30);
		add(button2);
		button2.addActionListener(this);
	}

	public void paintComponent(Graphics g) 
	{

		//����
		g.setColor(color1);
		g.fillRoundRect(350,140,60,50,15,10);
		g.fillRoundRect(420,140,60,50,15,10);

		//����
		g.setColor(color);
		g.fillRoundRect(340,50,150,100,50,50);
		g.fillArc(300,50,150,100,90,100);
		g.fillArc(380,50,150,100,90,-110);

		//�Ź�
		g.setColor(color2);
		g.fillOval(320,230,90,25);
		g.fillOval(420,230,90,25);


	}

	@Override
	public void actionPerformed(ActionEvent e){
		JButton k=(JButton)e.getSource();
		if (k.getText().equals("���� ����ȭ")){
			color=new Color ((int) (Math.random()*255.0),(int) (Math.random()*255.0),(int) (Math.random()*255.0));
			getParent().repaint();
		}
		if (k.getText().equals("���� ����ȭ")){
			color1=new Color ((int) (Math.random()*255.0),(int) (Math.random()*255.0),(int) (Math.random()*255.0));
			getParent().repaint();
		}
		if (k.getText().equals("�Ź� ����ȭ")){
			color2=new Color ((int) (Math.random()*255.0),(int) (Math.random()*255.0),(int) (Math.random()*255.0));
			getParent().repaint();
		}

	}
}