import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClothesResultG157 extends JFrame{
    JPanel p1,bottom, one, two, three, four;
    JLabel title, subtitle;
	JTabbedPane tp, tp1;
    RoundButton before, main,cal;

    static RoundButton[] btn= new RoundButton[3];
public String name;
    public ClothesResultG157(String msg) {
		name=msg;
        setTitle(name+"�� ���� ��õ");
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1, 10, 7));

		//��� ����
        Font font = new Font("a�ó׸�L", Font.PLAIN, 45);
        Font font1 = new Font("a�ó׸�L", Font.PLAIN, 25);
        title = new JLabel(name+"���� ������ �ڵ��� �帳�ϴ�.");
        title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
        subtitle = new JLabel("��Ÿ��� ����, ������ ������ �м� ��õ�� ������ �����ϴ�.");
        title.setHorizontalAlignment(JLabel.CENTER);
        subtitle.setHorizontalAlignment(JLabel.CENTER);
        p1.add(title);
        p1.add(subtitle);
        title.setFont(font);
        subtitle.setFont(font1);
		p1.setBounds(0,0,1500,200); 
        add( p1);

		//���â
		one=new JPanel();  
		one.add(new ClothesTopa());
		two=new JPanel(); 
		two.add(new ClothesPantsa());
		three=new JPanel(); 
		three.add(new ClothesShoesa());
		four=new JPanel();
		four=new Clothesgraphic2();
		tp=new JTabbedPane();  
		tp.setBounds(250,230,1100,400);  
		tp.add("<html><body><table width='150'><tr><td>����</td></tr></table></body></html>", one);
		tp.add("<html><body><table width='150'><tr><td>����</td></tr></table></body></html>", two);
		tp.add("<html><body><table width='150'><tr><td>�Ź�</td></tr></table></body></html>",three);
		tp.add("<html><body><table width='150'><tr><td>�ڵ� �� ����</td></tr></table></body></html>",four);
		add(tp);



		//�Ʒ� ����, ���� ��ư
        bottom = new JPanel();
        bottom.setLayout(new BorderLayout(500,500));
        before = new RoundButton("��������");	before.setBackground(new Color(102, 102, 102));
		cal = new RoundButton("��õ��ǰ ����غ���");	cal.setBackground(new Color(102, 102, 102));
        main = new RoundButton("��������");	main.setBackground(new Color(102, 102, 102));

		before.addActionListener(new MyActionListener());
		cal.addActionListener(new MyActionListener());
		main.addActionListener(new MyActionListener());

        bottom.add("East",before); 	bottom.add("Center",cal); bottom.add("West",main);

        bottom.setBorder(BorderFactory.createEmptyBorder(0 , 80 , 50 , 80));
		bottom.setBounds(0,700,1500,100); 
		add(bottom);


		setLayout(null);  
        setSize(1500,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	//�Ʒ� ��
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
				new ClothesG_2Q2(ClothesResultG157.this.name);
				ClothesResultG157.this.setVisible(false);
			}else if (b.getText().equals("��õ��ǰ ����غ���"))
			{
					//���� ��ü �θ���
				new Calculater("�� ����غ���");
			}else
			{
				//��������â �����ϱ�
				new survey(ClothesResultG157.this.name);
				ClothesResultG157.this.setVisible(false);
			}
	}
}
}
