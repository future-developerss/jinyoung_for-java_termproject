import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class firstPage extends JFrame{
	//사용자 이름
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
        super("당신의 오늘은?");

        getContentPane().setBackground(Color.WHITE);
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

        nameInput=new JTextField("");
        nameInput.setFont(new Font("SansSerif", Font.BOLD, 20));
        nameInput.setBounds(590, 450, 300, 50);
        add(nameInput);
		nameInput.setText("");

        startButton=new JButton("시작하기");
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
        public void paint(Graphics g) {//그리는 함수
            g.drawImage(background, 0, 0, null);
        }
    };

	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("시작하기")){
				//다음페이지로
				String name=firstPage.this.nameInput.getText();
				new secondPage(name);
				firstPage.this.setVisible(false); //private class로의 이벤트 클래스 만들어, 이전페이지 부르고-> 현재 페이지는 안보이게 (frame 전환)
			}
		}
	}

	public static void main(String[] args) 
	{
		new firstPage();
	}
}

