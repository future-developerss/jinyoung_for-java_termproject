import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class firstPage extends JFrame{
	//����� �̸�
	public String name;
	public String realname;
    private Image screenImage;
    private Graphics screenGraphic;

    private JLabel title, sub1;
    private JTextField nameInput;
    private JButton startButton, nameButton;
    private ImageIcon background_img=new ImageIcon("images/start_img.png");
    JLabel imageLabel1=new JLabel();

    public firstPage() {
        super("����� ������?");

        getContentPane().setBackground(Color.WHITE);
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

        nameInput=new JTextField("");
        nameInput.setFont(new Font("SansSerif", Font.BOLD, 20));
        nameInput.setBounds(590, 450, 300, 50);
        add(nameInput);
		nameInput.setText("");

        startButton=new JButton("�����ϱ�");
        startButton.setBounds(590, 510, 300, 45);
		startButton.addActionListener(new MyActionListener());
        add(startButton);

        setSize(1500,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    static JPanel page1=new JPanel() {
        Image background=new ImageIcon("images/start_img.png").getImage();
        public void paint(Graphics g) {//�׸��� �Լ�
            g.drawImage(background, 0, 0, null);
        }
    };

	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("�����ϱ�")){
				//firstPage.this.nameInput.setText(nameInput.getText());
				//new Realname(nameInput.getText());

				//������������
				new secondPage();
				firstPage.this.setVisible(false); //private class���� �̺�Ʈ Ŭ���� �����, ���������� �θ���-> ���� �������� �Ⱥ��̰� (frame ��ȯ)
			}
		}
	}

	public static void main(String[] args) 
	{
		new firstPage();
	}
}

