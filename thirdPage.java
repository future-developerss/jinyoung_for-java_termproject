import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class thirdPage extends JFrame{
    private Image screenImage;
    private Graphics screenGraphic;
	
    private JLabel title, sub1;
    private JTextField nameInput;
    private JButton clothesButton, foodButton,placeButton, cultureButton;
    private ImageIcon background_img=new ImageIcon("images/start_img.png");
    JLabel imageLabel1=new JLabel();
	public String name;
    public thirdPage(String msg) {
		name=msg;
		setTitle(name+"�� ������?");
        //setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        //f.setBackground(new Color(255, 255, 255));
        setLayout(null);

        JPanel labelP=new JPanel();
        labelP.setBounds(550, 70, 400, 120);

        title=new JLabel("������ �����?");
        title.setFont(new Font("SansSerif", Font.BOLD, 35));
        labelP.add(title);
        sub1=new JLabel("����� �Ϸ縦 �����غ�����");
        sub1.setFont(new Font("SansSerif", Font.BOLD, 25));
        labelP.add(sub1);
        labelP.setBackground(new Color(255, 255, 255));
        add(labelP);

        page1.setBounds(580, 220, 349, 153);   //�г��� ��ġ�� ũ��.
        add(page1);//�����ӿ� �г��� �߰�.


		//�̹��� ��ư
		ImageIcon bclothes = new ImageIcon("images/clothes.png");
		ImageIcon bfood = new ImageIcon("images/food.png");
		ImageIcon bplace = new ImageIcon("images/place.png");
		ImageIcon bculture = new ImageIcon("images/culture.png");

        clothesButton=new JButton("�ڵ�", bclothes);
		clothesButton.setBackground(Color.LIGHT_GRAY);
		clothesButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		//clothes ��ư �̺�Ʈ ���
		clothesButton.addActionListener(new MyActionListener());
        clothesButton.setBounds(510, 480, 100, 50);
        add(clothesButton);

		foodButton=new JButton("����",bfood);
		foodButton.setBackground(Color.LIGHT_GRAY);
		foodButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		//food ��ư �̺�Ʈ ���
		foodButton.addActionListener(new MyActionListener());
        foodButton.setBounds(650, 480, 100, 50);
        add(foodButton);

		placeButton=new JButton("���",bplace);
		placeButton.setBackground(Color.LIGHT_GRAY);
		placeButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		//place ��ư �̺�Ʈ ���
		placeButton.addActionListener(new MyActionListener());
        placeButton.setBounds(790, 480, 100, 50);
        add(placeButton);

		cultureButton=new JButton("��ȭ",bculture);
		cultureButton.setBackground(Color.LIGHT_GRAY);
		cultureButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		//culture ��ư �̺�Ʈ ���
		cultureButton.addActionListener(new MyActionListener());
        cultureButton.setBounds(930, 480, 100, 50);
        add(cultureButton);

        setSize(1500,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("�ڵ�"))
			{
				new ClothesQ1(thirdPage.this.name);
				thirdPage.this.setVisible(false);
			}else if (b.getText().equals("����"))
			{
				//���� ����â
				new FoodQuestion1();
				thirdPage.this.setVisible(false);
			}else if (b.getText().equals("���"))
			{
				//��� ����â
				new PlaceQ_1();
				thirdPage.this.setVisible(false);
			}
			else{
				//��ȭ ����â
				//new fourthPageQ1();
				//thirdPage.this.setVisible(false);
			}
		}
	}

    static JPanel page1=new JPanel() {
        Image background=new ImageIcon("images/start_img.png").getImage();
        public void paint(Graphics g) {//�׸��� �Լ�
            g.drawImage(background, 0, 0, null);
        }
    };

}
