import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame implements ActionListener{
    float price = 0, orderQuantity = 0, total=0, yourChange=0;
    String customerType;

    JLabel menu, chooseOrder, quantity, typeOfCustomer, totalOrder, enterPayment, change, orderAnswer, changeAnswer;
    JRadioButton mealA, mealB, regular, seniorCitizen;
    JTextArea enterQuantity, payment;
    ButtonGroup meal, customer;
    JPanel panel, panel2;
    JButton calculate, pay;
     
    public App(){
        //JLabel settings
        menu = new JLabel("Menu:");
        chooseOrder = new JLabel("Choose Order:");
        quantity = new JLabel("Enter Quantity:");
        typeOfCustomer = new JLabel("Type of Customer:");
        totalOrder = new JLabel("Your Total Order is: ");
        change = new JLabel("Your change is: ");
        orderAnswer = new JLabel();
        changeAnswer = new JLabel();
        enterPayment = new JLabel("Enter Payment: ");

        menu.setBounds(250, 5, 150, 50);
        chooseOrder.setBounds(50, 100, 150, 20);
        quantity.setBounds(50, 150, 150, 20);
        typeOfCustomer.setBounds(50, 200, 200, 20);
        enterPayment.setBounds(300, 150, 150,20);
        totalOrder.setBounds(330, 270, 200, 50);
        change.setBounds(330, 370, 200, 50);
        orderAnswer.setBounds(330, 310, 200, 50);
        changeAnswer.setBounds(330, 410, 200, 50);

        menu.setFont(new Font("Verdana",Font.BOLD,30));     
        chooseOrder.setFont(new Font("Verdana",Font.BOLD,15));
        quantity.setFont(new Font("Verdana",Font.BOLD,15));
        typeOfCustomer.setFont(new Font("Verdana",Font.BOLD,15));
        totalOrder.setFont(new Font("Verdana",Font.BOLD,15));
        change.setFont(new Font("Verdana",Font.BOLD,15));
        orderAnswer.setFont(new Font("Verdana",Font.BOLD,15));
        changeAnswer.setFont(new Font("Verdana",Font.BOLD,15));
        enterPayment.setFont(new Font("Verdana",Font.BOLD,15));

        menu.setForeground(Color.GREEN);
        chooseOrder.setForeground(Color.GREEN);
        quantity.setForeground(Color.GREEN);
        typeOfCustomer.setForeground(Color.GREEN);
        enterPayment.setForeground(Color.GREEN);
        totalOrder.setForeground(Color.darkGray);
        change.setForeground(Color.darkGray);
        changeAnswer.setForeground(Color.darkGray);
        orderAnswer.setForeground(Color.darkGray);

        //Radiobutton settings
        mealA = new JRadioButton("Meal A(P100.00)");
        mealB = new JRadioButton("Meal B(P150.00)");
        regular = new JRadioButton("Regular");
        seniorCitizen = new JRadioButton("Senior Citizen(20% Discount)");

        mealA.setBounds(190, 100, 150, 20);
        mealB.setBounds(350, 100, 150, 20);
        regular.setBounds(210, 200, 100, 20);
        seniorCitizen.setBounds(320, 200, 250, 20);

        mealA.setFocusable(false);
        mealB.setFocusable(false);
        regular.setFocusable(false);
        seniorCitizen.setFocusable(false);

        mealA.addActionListener(this);
        mealB.addActionListener(this);
        regular.addActionListener(this);
        seniorCitizen.addActionListener(this);

        mealA.setFont(new Font("Verdana",Font.BOLD,13));
        mealB.setFont(new Font("Verdana",Font.BOLD,13));
        regular.setFont(new Font("Verdana",Font.BOLD,13));
        seniorCitizen.setFont(new Font("Verdana",Font.BOLD,13));

        mealA.setBackground(Color.BLACK);
        mealA.setForeground(Color.WHITE);
        mealB.setBackground(Color.BLACK);
        mealB.setForeground(Color.WHITE);

        regular.setBackground(Color.BLACK);
        regular.setForeground(Color.WHITE);
        seniorCitizen.setBackground(Color.BLACK);
        seniorCitizen.setForeground(Color.WHITE);

        //Buttongroup settings
        meal = new ButtonGroup();
        customer = new ButtonGroup();

        meal.add(mealA);
        meal.add(mealB);

        customer.add(regular);
        customer.add(seniorCitizen);

        //Textarea settings
        enterQuantity = new JTextArea();
        payment = new JTextArea();

        enterQuantity.setBounds(200, 154, 80, 20);
        payment.setBounds(450, 154, 80, 20);

        enterQuantity.setMargin(new Insets(2,10,0,0));
        payment.setMargin(new Insets(2,10,0,0));

        //Jbutton settings
        calculate = new JButton("Calculate");
        pay = new JButton("Pay");

        calculate.setBounds(120, 300, 100, 50);
        pay.setBounds(120, 410, 100, 50);

        calculate.setFocusable(false);
        pay.setFocusable(false);

        calculate.addActionListener(this);
        pay.addActionListener(this);

        calculate.setBackground(Color.DARK_GRAY);
        calculate.setForeground(Color.WHITE);

        pay.setBackground(Color.DARK_GRAY);
        pay.setForeground(Color.WHITE);

        //Jpanel settings
        panel = new JPanel();
        panel2 = new JPanel();
        panel.add(calculate);

        panel.setBounds(40, 250, 250, 270);
        panel2.setBounds(300, 250, 250, 270);

        panel.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        
        //JFrame settings
        add(menu);
        add(chooseOrder);
        add(mealA);
        add(mealB);
        add(quantity);
        add(enterQuantity);
        add(typeOfCustomer);
        add(regular);
        add(seniorCitizen);
        add(calculate);
        add(pay);
        add(payment);
        add(enterPayment);
        add(totalOrder);
        add(change);
        add(orderAnswer);
        add(changeAnswer);
        add(panel);
        add(panel2);
       
        setTitle("Menu");
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public static void main(String[] args) {
    new App();
}
public void actionPerformed(ActionEvent e) {
   if(e.getSource()==mealA) price = 100;
   else if(e.getSource()==mealB) price = 150;

   if(e.getSource()==regular)customerType="regular";
   else if(e.getSource()==seniorCitizen)customerType="senior";
   
   //calculate total
   if(e.getSource()==calculate){
        orderQuantity = Float.parseFloat(enterQuantity.getText());
        
        if(customerType=="regular")total = price * orderQuantity;
        else total = (float) ((price * orderQuantity) * 0.80);
        
        orderAnswer.setText("P" + total);
   }
   if(e.getSource()==pay){
        orderQuantity = Float.parseFloat(enterQuantity.getText());
            
        if(customerType=="regular")total = price * orderQuantity;
        else total = (float) ((price * orderQuantity) * 0.80);
        
        orderAnswer.setText("P" + total);

        yourChange = Float.parseFloat(payment.getText())-total;

        changeAnswer.setText("P" + yourChange);
   }
}
}
