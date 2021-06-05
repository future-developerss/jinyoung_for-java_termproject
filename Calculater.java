import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculater extends JDialog{
    TextField text;   // shows click button and calculated result
    GridBagLayout gridbag;
    String[] names= {"+", "-", "*", "/", "7", "8", "9","%",
            "4", "5", "6", "C", "1", "2", "3", "DEL", ".", "0", "="};
    JButton[] btn=new JButton[names.length];

    static int flag = 0;

    // check if the input is calculatable
    // cannot calculate number over 100000
    static int isError = 0;

    public Calculater(String msg){
        getContentPane().setLayout(new BorderLayout());

        text=new TextField("");
        text.setFont(new Font("SansSerif", Font.BOLD, 30));

        ButtonPanel button=new ButtonPanel();
        add("North", text);
        add("Center", button);

        setTitle(msg);
        setSize(400, 500);
        setVisible(true);

    }

    class ButtonPanel extends JPanel {
        public ButtonPanel() {
            gridbag=new GridBagLayout();
            GridBagConstraints constraint=new GridBagConstraints();
            setLayout(gridbag);
            MouseHandler handler=new MouseHandler();

            for (int i=0; i<btn.length; i++) {
                btn[i]=new JButton(names[i]);
                btn[i].setFont(new Font("SansSerif", Font.BOLD, 30));
                btn[i].addMouseListener(handler);
            }
            //button color
            for (int i=4; i<btn.length-1; i++) {   // numbers
                btn[i].setBackground(new Color(175, 238, 238));
                if (i%4!=3) {        // action when number buttons are clicked
                    btn[i].addActionListener(new ActionListener () {
                        public void actionPerformed(ActionEvent e) {
                            if (flag == 0) {
                                JButton button = (JButton)e.getSource();
                                String oldtext = text.getText();
                                String newtext = button.getText();
                                String finaltext = oldtext + newtext;

                                int n = finaltext.length();
                                if (n <= 20)  text.setText(finaltext);
                                else if (n > 20) text.setText("Please write under 20 letters.");
                            }
                        }
                    });
                }
            }
            for (int i=0; i<4; i++) {           // +, -, *, /
                btn[i].setBackground(new Color(127, 255, 212));
                btn[i].addActionListener(new OperationListener());
            }
            for (int i=7; i<16; i+=4) {
                btn[i].setBackground(new Color(127, 255, 212));
            }
            btn[7].addActionListener(new OperationListener()); // % calculate
            btn[11].addActionListener(new DelListener());      // clear all
            btn[15].addActionListener(new DelListener());      // delete one input

            btn[18].setBackground(new Color(255, 255, 255));  // "=" button
            btn[18].addActionListener(new CalcListener());

            constraint.fill=GridBagConstraints.BOTH;
            constraint.weightx=0.2;
            constraint.weighty=0.1;
            constraint.gridwidth=1;
            constraint.gridheight=1;

            for (int i=0; i<4; i++) {   // 1~4 row button
                constraint.gridy=i;
                for (int j=0; j<4; j++) {
                    constraint.gridx=j;
                    gridbag.setConstraints(btn[i*4+j], constraint);
                    add(btn[i*4+j]);
                }
            }
            // bottom row button
            constraint.gridy=4;
            constraint.gridx=0;
            gridbag.setConstraints(btn[16], constraint);
            add(btn[16]);

            constraint.gridx=1;
            gridbag.setConstraints(btn[17], constraint);
            add(btn[17]);

            constraint.gridwidth=2;
            constraint.gridx=2;
            gridbag.setConstraints(btn[18], constraint);
            add(btn[18]);
        }
    }

    public class CalcListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String s = text.getText();
            double result = Calculator(s);
            text.setText(Double.toString(result));
        }
    }

    // action when DEL button is clicked
    public class DelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            int n= text.getText().length();

            if (b==btn[15]) n -= 1;
            else if (b==btn[11])  n = 0;

            if (n == 0) {
                text.setText("");
                flag = 0;
            } else {
                text.setFont(new Font("SansSerif", Font.BOLD, 30));
                text.setText(text.getText().substring(0, n));
            }
        }
    }

    // action when operation button is clicked
    private class OperationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            int n = text.getText().length();
            Character c = text.getText().charAt(n-1);
            if (flag == 0 && c != '+' && c != '-' && c != '¡¿' && c != '/' && c != '¡À') {
                String oldtext = text.getText();
                String newtext = b.getText();
                String finaltext = oldtext + newtext;
                n = finaltext.length();
                if (n <= 20)  text.setText(finaltext);
                else if (n > 20) text.setText("Please write under 20 letters.");
            }
        }
    }

    public class MouseHandler extends MouseAdapter {
        Color color=new Color(175, 238, 238);
        JButton b=new JButton();

        public void mouseEntered(MouseEvent e) {  //color change
            b=(JButton)e.getSource();
            color=b.getBackground();
            b.setBackground(new Color(072, 209, 204));
        }
        public void mouseExited(MouseEvent e) {  //back to original color
            b=(JButton)e.getSource();
            b.setBackground(color);
        }
    }

    public double Calculator(String input) {
        ArrayList<Double> num = new ArrayList<Double>();
        ArrayList<String> oper = new ArrayList<String>();
        oper.add(null);  // operation part null

        String str = new String("");

        // getting input
        for (int i = 0; i < input.length(); i++) {
            Character chrInput = input.charAt(i);
            String dot = Character.toString(chrInput);  // dot(.) button input

            if(Character.isDigit(chrInput)) {   // number part
                str += Character.toString(chrInput);
                if(i == input.length()-1)
                    num.add(Double.parseDouble(str));
            }
            else if (dot.equals(".")) str += dot;
            else {
                num.add(Double.parseDouble(str));
                oper.add(Character.toString(chrInput));
                str = "";
            }
        }

        for(int i = 1; i < num.size(); i++) {
            String op = oper.get(i);
            double result=0;

            //calculate and input new result in array
            if (op.equals("*") || op.equals("/") || op.equals("%")) {
                switch (op) {
                    case "*": result = num.get(i-1) * num.get(i); break;
                    case "/": result = num.get(i-1) / num.get(i); break;
                    case "%": result = num.get(i-1) % num.get(i); break;
                }
                oper.remove(i);
                num.remove(i);
                num.remove(i-1);
                num.add(i-1, result);
                i--;
            }
        }
        double ans = num.get(0);
        for(int i = 1; i < num.size(); i++) {
            String s = oper.get(i);
            double n = num.get(i);

            if(s.equals("+")) ans += n;
            else if(s.equals("-")) ans -= n;
        }
        return ans;
    }
		public static void main(String[] args) 
	{
		new HWcal1("hi");
	}
}