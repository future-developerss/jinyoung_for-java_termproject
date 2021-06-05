import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClothesTop4 extends JPanel{
	JPanel a,b,c;
	JLabel title, deco, explain;
	JButton link;
	private JRadioButton[] radio=new JRadioButton[5];
	private String[] text={"Mustard","Blue","Violet","Black","White"};
	private ImageIcon[] image={new ImageIcon("images/b_shorttshirt1.jpg"),new ImageIcon("images/b_shorttshirt2.jpg"),new ImageIcon("images/b_shorttshirt3.jpg"),new ImageIcon("images/b_shorttshirt4.jpg"),new ImageIcon("images/b_shorttshirt5.jpg")};
	private JLabel imagelabel=new JLabel();

	public ClothesTop4(){

	setLayout(new BorderLayout(5,5));
    Font font1 = new Font("a�ó׸�L", Font.BOLD, 25);

	//TITLE
	ImageIcon icon=new ImageIcon("images/icon.jpg");
	deco=new JLabel(icon);
	title = new JLabel("���� Ƽ    ");
	title.setFont(font1);

	link = new JButton("��ǰ ��������");
	link.addActionListener(new LinkListener());
	a=new JPanel();
	a.add(deco);
	a.add(title);
	a.add(link);

	//IMAGE+����ȭ
	b=new JPanel();
	b.setLayout(new BorderLayout(5,5));

	JPanel radioPanel=new JPanel();
	imagelabel.setHorizontalAlignment(SwingConstants.CENTER);//�̹��� �߾� ����
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

	//��ǰ����
	explain=new JLabel("<html><br/>��ǰ��: �ް��ΰ� ������ ���� Ƽ���� ���� ��Ű��<br/><br/>����: 59000<br/><br/>����ó: MLB<br/><br/></html>");
	explain.setFont(new Font("a�ó׸�L", Font.BOLD, 20));
	c=new JPanel();
	c.add(explain);


	//�����߰�
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
			}else if (radio[4].isSelected()){
				imagelabel.setIcon(image[4]);
			}else imagelabel.setIcon(image[0]);
		}
	}

	class LinkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == link) {
				new ClothesTopLink4();
			}
		}
	}
}
