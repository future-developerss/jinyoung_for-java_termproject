import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClothesB_2Q2 extends JFrame{
    JPanel p1, p2, bt_p4, bottom, contentPane;
    JLabel title, subtitle, q2;
    RoundButton main; 
    static String[] text= {"면접/회사 출근", "친구 약속/여행", "근처 마실"};
    static RoundButton[] btn= new RoundButton[3];
	public String name;
    public ClothesB_2Q2(String msg) {
		name=msg;
        setTitle(name+"의 선택은?");
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

        Font font = new Font("a시네마L", Font.PLAIN, 45);
        Font font1 = new Font("a시네마L", Font.PLAIN, 30);

        title = new JLabel(name+"이의 오늘을 코디해 드립니다.");
        title.setBorder(BorderFactory.createEmptyBorder(30 , 0 , 0 , 0));
        subtitle = new JLabel("당신을 위한 최고의 패션 추천을 위해, 다음의 질문에 답해주세요!");
        title.setHorizontalAlignment(JLabel.CENTER);
        subtitle.setHorizontalAlignment(JLabel.CENTER);
        p1.add(title);
        p1.add(subtitle);
        title.setFont(font);
        subtitle.setFont(font1);
        contentPane.add("North", p1);

        q2 = new JLabel("Q3 당신은 현재 어떤 일정을 준비중인가요?");
        q2.setFont(font1);

        for (int i=0; i < 3; i++) {
            btn[i]=new RoundButton(text[i]);//버튼 초기화
            btn[i].setVisible(true);//보이게
            btn[i].setFont(font1);//폰트설정
            btn[i].addMouseListener(me);
            bt_p4.add(btn[i]);
        }

		//설문조사 버튼 이벤트 등록
		for (int i=0;i<3 ;i++ ){
			btn[i].addActionListener(new AnswerListener());
		}

        p2.add(q2);		p2.add(bt_p4);


        contentPane.add("Center", p2);



        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        main = new RoundButton("이전으로");	main.setBackground(new Color(102, 102, 102));
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

//아래 이동버튼 클릭시 이벤트
private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("이전으로"))
			{
				//이전페이지로 이동
				new fourthPageB_Q1(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);

			}
		}
	}

//설문지 응답 대답 이벤트
private class AnswerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton b=(JButton)e.getSource();
			if (b.getText().equals("면접/회사 출근")){
				new ClothesResultB157(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);
			}else if (b.getText().equals("친구 약속/여행"))
			{
				new ClothesResultB157(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);
			}else{
				//근처 마실
				new ClothesResultB258(ClothesB_2Q2.this.name);
				ClothesB_2Q2.this.setVisible(false);
			}
		}
	}
}
