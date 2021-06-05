import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClothesTopa extends JPanel{
	JPanel a,b,c;
	JLabel title, deco, explain;
	JButton link;
	private JRadioButton[] radio=new JRadioButton[4];
	private String[] text={"Blue","White","Beige","Black"};
	private ImageIcon[] image={new ImageIcon("images/g_longshirt1.jpg"),new ImageIcon("images/g_longshirt2.jpg"),new ImageIcon("images/g_longshirt3.jpg"),new ImageIcon("images/g_longshirt4.jpg")};
	private JLabel imagelabel=new JLabel();

	public ClothesTopa(){

	setLayout(new BorderLayout(5,5));
    Font font1 = new Font("a시네마L", Font.BOLD, 25);

	//TITLE
	ImageIcon icon=new ImageIcon("images/icon.jpg");
	deco=new JLabel(icon);
	title = new JLabel("긴 셔츠    ");
	title.setFont(font1);

	link = new JButton("상품 보러가기");
	link.addActionListener(new LinkListener());
	a=new JPanel();
	a.add(deco);
	a.add(title);
	a.add(link);

	//IMAGE+색변화
	b=new JPanel();
	b.setLayout(new BorderLayout(5,5));

	JPanel radioPanel=new JPanel();
	imagelabel.setHorizontalAlignment(SwingConstants.CENTER);//이미지 중앙 정렬
	ButtonGroup g=new ButtonGroup();

	for (int i=0; i<radio.length;i++){
		radio[i]=new JRadioButton(text[i]);
		g.add(radio[i]);
		radioPanel.add(radio[i]);
		radio[i].addItemListener(new MyItemListener());
	}
	radio[0].setSelected(true);

	b.add(imagelabel,BorderLayout.NORTH);
	b.add(radioPanel,BorderLayout.CENTER);

	//상품정보
	explain=new JLabel("<html><br/>상품명: 헤지스 단색 면혼방 긴팔 셔츠<br/><br/>가격: 83350<br/><br/>구매처: CJ Onstyle<br/><br/></html>");
	explain.setFont(new Font("a시네마L", Font.BOLD, 20));
	c=new JPanel();
	c.add(explain);


	//최종추가
	add(a,BorderLayout.NORTH);
	add(b,BorderLayout.WEST);
	add(c,BorderLayout.EAST);
	}


	public class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e){
			if (radio[1].isSelected()){
				imagelabel.setIcon(image[1]);
			}else if (radio[2].isSelected()){
				imagelabel.setIcon(image[2]);
			}else if (radio[3].isSelected()){
				imagelabel.setIcon(image[3]);
			}else imagelabel.setIcon(image[0]);
		}
	}
	class LinkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == link) {
				new ClothesTopLinka();
			}
		}
	}
}
