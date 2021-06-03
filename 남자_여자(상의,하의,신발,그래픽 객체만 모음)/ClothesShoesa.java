import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClothesShoesa extends JPanel{
	JPanel a,b,c;
	JLabel title, deco, explain;
	private JRadioButton[] radio=new JRadioButton[2];
	private String[] text={"Beige","Black"};
	private ImageIcon[] image={new ImageIcon("images/g_shoes1.jpg"),new ImageIcon("images/g_shoes2.jpg")};
	private JLabel imagelabel=new JLabel();

	public ClothesShoesa(){

	setLayout(new BorderLayout(5,5));
    Font font1 = new Font("a�ó׸�L", Font.BOLD, 25);

	//TITLE
	ImageIcon icon=new ImageIcon("images/icon.jpg");
	deco=new JLabel(icon);
	title = new JLabel("����");
	title.setFont(font1);

	a=new JPanel();
	a.add(deco);
	a.add(title);

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
	explain=new JLabel("<html>��ǰ��: ��ƿ���� U���� �̵��� ����<br/><br/>����: 36000<br/><br/>����ó: Ishoes<br/><br/>��ũ �ּ�: https://ishoesmall.co.kr/</html>");
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
			}else imagelabel.setIcon(image[0]);
		}
	}

}
