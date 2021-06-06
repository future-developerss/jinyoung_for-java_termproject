import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClothesB_2Q2 extends JFrame{
    JPanel p1, p2, bt_p4, bottom, contentPane;
    JLabel title, subtitle, q2;
    RoundButton main; 
    static String[] text= {"����/ȸ�� ���", "ģ�� ���/����", "��ó ����"};
    static RoundButton[] btn= new RoundButton[3];
	public String name;
    public ClothesB_2Q2(String msg) {
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

        bt_p4 = new JPanel();
        bt_p4.setLayout(new GridLayout(1, 4, 10, 40));

        Font font = new Font("a�ó׸�L", Font.PLAIN, 45);
        Font font1 = new Font("a�ó׸�L", Font.PLAIN, 30);

        title = new JLabel(name+"���� ������ �ڵ��� �帳�ϴ�.");
        title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
        subtitle = new JLabel("����� ���� �ְ��� �м� ��õ�� ����, ������ ������ �����ּ���!");
        title.setHorizontalAlignment(JLabel.CENTER);
        subtitle.setHorizontalAlignment(JLabel.CENTER);
        p1.add(title);
        p1.add(subtitle);
        title.setFont(font);
        subtitle.setFont(font1);
        contentPane.add("North", p1);

        q2 = new JLabel("Q3 ����� ���� � ������ �غ����ΰ���?");
        q2.setFont(font1);

        for (int i=0; i < 3; i++) {
            btn[i]=new RoundButton(text[i]);//��ư �ʱ�ȭ
            btn[i].setVisible(true);//���̰�
            btn[i].setFont(font1);//��Ʈ����
            btn[i].addMouseListener(me);
            bt_p4.add(btn[i]);
        }

		//�������� ��ư �̺�Ʈ ���
		for (int i=0;i<3 ;i++ ){
			btn[i].addActionListener(new AnswerListener());
		}

        p2.add(q2);		p2.add(bt_p4);


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

//�Ʒ� �̵���ư Ŭ���� �̺�Ʈ
private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("��������"))
			{
				//������������ �̵�
				new fourthPageB_Q1(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);

			}
		}
	}

//������ ���� ��� �̺�Ʈ
private class AnswerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("����/ȸ�� ���")){
				new ClothesResultB157(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);
			}else if (b.getText().equals("ģ�� ���/����"))
			{
				new ClothesResultB157(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);
			}else{
				//��ó ����
				new ClothesResultB258(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);
			}
		}
	}
}
