import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClothesResultB468 extends JFrame{
    JPanel p1,bottom, one, two, three, four;
    JLabel title, subtitle;
	JTabbedPane tp, tp1;
    RoundButton before, main;

    static RoundButton[] btn= new RoundButton[5];

    public ClothesResultB468() {
        super("Clothes Result Page");
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,1, 10, 7));

		//상단 문구
        Font font = new Font("a시네마L", Font.PLAIN, 45);
        Font font1 = new Font("a시네마L", Font.PLAIN, 25);
        title = new JLabel("이의 오늘을 코디해 드립니다.");
        title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
        subtitle = new JLabel("당신만을 위한, 오늘의 최적의 패션 추천은 다음과 같습니다.");
        title.setHorizontalAlignment(JLabel.CENTER);
        subtitle.setHorizontalAlignment(JLabel.CENTER);
        p1.add(title);
        p1.add(subtitle);
        title.setFont(font);
        subtitle.setFont(font1);
		p1.setBounds(0,0,1500,200); 
        add( p1);

		//결과창
		one=new JPanel();  
		one.add(new ClothesTop4());
		two=new JPanel(); 
		two.add(new ClothesPants2());
		three=new JPanel(); 
		three.add(new ClothesShoes2());
		four=new JPanel();
		four=new Clothesgraphic1();
		tp=new JTabbedPane();  
		tp.setBounds(250,230,1100,400);  
		tp.add("<html><body><table width='150'><tr><td>상의</td></tr></table></body></html>", one);
		tp.add("<html><body><table width='150'><tr><td>하의</td></tr></table></body></html>", two);
		tp.add("<html><body><table width='150'><tr><td>신발</td></tr></table></body></html>",three);
		tp.add("<html><body><table width='150'><tr><td>코디 색 조합</td></tr></table></body></html>",four);
		add(tp);



		//아래 메인, 이전 버튼
        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        before = new RoundButton("메인으로");	before.setBackground(new Color(102, 102, 102));
        main = new RoundButton("이전으로");	main.setBackground(new Color(102, 102, 102));

		before.addActionListener(new MyActionListener());
		main.addActionListener(new MyActionListener());

        bottom.add("East",before); 	bottom.add("West",main);
        bottom.setBorder(BorderFactory.createEmptyBorder(0 , 80 , 50 , 80));
		bottom.setBounds(0,700,1500,100); 
		add(bottom);


		setLayout(null);  
        setSize(1500,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	//아래 선
    public void paint(Graphics g) {
        super.paint(g);
       g.drawLine(150, 200, 1350, 200);
    }
//아래 이동버튼 클릭시 이벤트
private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("이전으로"))
			{
				//이전페이지로 이동
				new ClothesB_1Q2();
				ClothesResultB468.this.setVisible(false);
			}//else
			//{
				//설문조사창 연결하기
			//}
		}
	}
}
