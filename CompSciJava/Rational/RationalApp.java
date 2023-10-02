import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.geom.Rectangle2D;
import java.awt.font.*;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author tgesell
 */
public class RationalApp extends JFrame {

    private JTextField wholeNumber1;
    private JTextField numerator1;
    private JTextField denominator1;

    private JTextField wholeNumber2;
    private JTextField numerator2;
    private JTextField denominator2;

    private JLabel operatorLabel;
    private ButtonGroup operatorButtons;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton calculateButton;

    private JLabel resultNumerator;
    private JLabel resultDenominator;
    private JLabel resultWhole;

    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;

    private JPanel mainPanel;

    private String operatorSelected;
    /**
     * Creates new form RationalApp
     */
    public RationalApp() {
        operatorSelected = "none";
        super.setResizable(false);
        super.setSize(400,400);
        initComponents();
    }

    private void initComponents() {
        wholeNumber1 = new JTextField();
        numerator1 = new JTextField();
        denominator1 = new JTextField();

        wholeNumber2 = new JTextField();
        numerator2 = new JTextField();
        denominator2 = new JTextField();

        operatorLabel = new JLabel();

        operatorButtons = new ButtonGroup();
        addButton = new JButton();
        subtractButton = new JButton();
        multiplyButton = new JButton();
        divideButton = new JButton();

        calculateButton = new JButton();

        resultNumerator = new JLabel();
        resultDenominator = new JLabel();
        resultWhole = new JLabel();

        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // wholeNumber1.setColumns(2);
        // numerator1.setColumns(2);
        // denominator1.setColumns(2);

        // wholeNumber2.setColumns(2);
        // numerator2.setColumns(2);
        // denominator2.setColumns(2);

        addButton.setText("+");
        operatorButtons.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        subtractButton.setText("-");
        operatorButtons.add(subtractButton);
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subtractButtonActionPerformed(evt);
            }
        });

        multiplyButton.setText("x");
        operatorButtons.add(multiplyButton);
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                multiplyButtonActionPerformed(evt);
            }
        });

        divideButton.setText("/");
        operatorButtons.add(divideButton);
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                divideButtonActionPerformed(evt);
            }
        });

        resultNumerator.setText("  ");
        resultDenominator.setText("  ");
        resultWhole.setText(" ");

        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });


        wholeNumber1.setBounds(10,50,40,25);
        numerator1.setBounds(55,35,40,25);
        jSeparator1.setBounds(55,62,40,10);
        denominator1.setBounds(55,65,40,25);

        operatorLabel.setBounds(135,62,15,15);

        wholeNumber2.setBounds(210,50,40,25);
        numerator2.setBounds(255,35,40,25);
        jSeparator2.setBounds(255,62,40,10);
        denominator2.setBounds(255,65,40,25);

        addButton.setBounds(10,150,35,25);
        subtractButton.setBounds(50,150,35,25);
        multiplyButton.setBounds(90,150,35,25);
        divideButton.setBounds(130,150,35,25);

        resultWhole.setBounds(210,150,40,25);
        resultNumerator.setBounds(255,135,80,25);
        jSeparator3.setBounds(255,162,40,10);
        resultDenominator.setBounds(255,165,80,25);

        calculateButton.setBounds(50,200,80,25);

        mainPanel.add(wholeNumber1);
        mainPanel.add(numerator1);
        mainPanel.add(jSeparator1);
        mainPanel.add(denominator1);

        mainPanel.add(operatorLabel);

        mainPanel.add(wholeNumber2);
        mainPanel.add(numerator2);
        mainPanel.add(jSeparator2);
        mainPanel.add(denominator2);

        mainPanel.add(addButton);
        mainPanel.add(subtractButton);
        mainPanel.add(multiplyButton);
        mainPanel.add(divideButton);

        mainPanel.add(resultWhole);
        mainPanel.add(resultNumerator);
        mainPanel.add(jSeparator3);
        mainPanel.add(resultDenominator);

        mainPanel.add(calculateButton);

        getContentPane().add(mainPanel);
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "+";
        operatorLabel.setText(operatorSelected);
    }

    private void subtractButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "-";
        operatorLabel.setText(operatorSelected);
    }

    private void multiplyButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "x";
        operatorLabel.setText(operatorSelected);
    }

    private void divideButtonActionPerformed(ActionEvent evt) {
        operatorSelected = "/";
        operatorLabel.setText(operatorSelected);
    }

    private void calculateButtonActionPerformed(ActionEvent evt) {
        int wholeNumber1Value, numerator1Value, denominator1Value;
        int wholeNumber2Value, numerator2Value, denominator2Value;
        int sign1 = 1;
        int sign2 = 1;

        try{
            try{
                wholeNumber1Value = Integer.parseInt(wholeNumber1.getText());
                if (Math.abs(wholeNumber1Value) > 999)
                    throw new IllegalArgumentException("Please limit values to 4 digits or less");
            }catch(NumberFormatException e){
                if (wholeNumber1.getText().equals("-"))
                    sign1 = -1;
                else{
                    wholeNumber1.setText("");
                }
                wholeNumber1Value = 0;
            }
            try{
                numerator1Value   = Integer.parseInt(numerator1.getText());
                if (Math.abs(numerator1Value) > 999)
                    throw new IllegalArgumentException("Please limit values to 4 digits or less");
            }catch(NumberFormatException e){
                numerator1Value = 0;
                numerator1.setText("0");
            }
            try{
                denominator1Value = Integer.parseInt(denominator1.getText());
                if (Math.abs(denominator1Value) > 999)
                    throw new IllegalArgumentException("Please limit values to 4 digits or less");
            }catch(NumberFormatException e){
                denominator1Value = 1;
                denominator1.setText("1");
            }
            try{
                wholeNumber2Value = Integer.parseInt(wholeNumber2.getText());
                if (Math.abs(wholeNumber2Value) > 999)
                    throw new IllegalArgumentException("Please limit values to 4 digits or less");
            }catch(NumberFormatException e){
                if (wholeNumber2.getText().equals("-"))
                    sign2 = -1;
                else{
                    wholeNumber2.setText("");
                }
                wholeNumber2Value = 0;
            }
            try{
                numerator2Value   = Integer.parseInt(numerator2.getText());
                if (Math.abs(numerator2Value) > 999)
                    throw new IllegalArgumentException("Please limit values to 4 digits or less");
            }catch(NumberFormatException e){
                numerator2Value = 0;
                numerator2.setText("0");
            }
            try{
                denominator2Value = Integer.parseInt(denominator2.getText());
                if (Math.abs(denominator2Value) > 999)
                    throw new IllegalArgumentException("Please limit values to 4 digits or less");
            }catch(NumberFormatException e){
                denominator2Value = 1;
                denominator2.setText("1");
            }

            Rational rational1;
            if (wholeNumber1Value != 0)
                rational1 = new Rational(wholeNumber1Value,numerator1Value,denominator1Value);
            else
                rational1 = new Rational(sign1 * numerator1Value, denominator1Value);
            Rational rational2;
            if (wholeNumber2Value != 0)
                rational2 = new Rational(wholeNumber2Value,numerator2Value,denominator2Value);
            else
                rational2 = new Rational(sign2 * numerator2Value, denominator2Value);

            Rational result;
            if (operatorSelected.equals("+"))
                result = rational1.add(rational2);
            else if (operatorSelected.equals("-"))
                result = rational1.subtract(rational2);
            else if (operatorSelected.equals("x"))
                result = rational1.multiply(rational2);
            else if (operatorSelected.equals("/"))
                result = rational1.divide(rational2);
            else
                result = new Rational(0);

            if (result.getDenominator() == 1){
                resultWhole.setText(result.getNumerator() + " ");
                resultNumerator.setText("");
                resultDenominator.setText("");
            }
            else if (Math.abs(result.getNumerator()) > Math.abs(result.getDenominator())) {
                resultWhole.setText(result.getNumerator() / result.getDenominator() + " ");
                resultNumerator.setText(Math.abs(result.getNumerator() % result.getDenominator()) + " ");
                resultDenominator.setText(Math.abs(result.getDenominator()) + " ");
            }
            else {
                resultWhole.setText("");
                resultNumerator.setText(result.getNumerator()+ " ");
                resultDenominator.setText(result.getDenominator()+ " ");
            }
            //resize the result Label
            Graphics2D g2 = (Graphics2D) mainPanel.getGraphics();
            Font font = g2.getFont();
            FontRenderContext context = g2.getFontRenderContext();

            Rectangle2D resultWholeBounds = font.getStringBounds(resultWhole.getText(), context);
            Rectangle2D resultNumeratorBounds = font.getStringBounds(resultNumerator.getText(), context);
            Rectangle2D resultDenominatorBounds = font.getStringBounds(resultDenominator.getText(), context);

            int resultWholeWidth = (int)resultWholeBounds.getWidth() + 1;
            int resultNumeratorWidth = (int)resultNumeratorBounds.getWidth() + 1;
            int resultDenominatorWidth = (int)resultDenominatorBounds.getWidth() + 1;
            //resize resultLabels so that the result Rational number fits/displays nicely
            {
                mainPanel.remove(resultWhole);
                mainPanel.remove(resultNumerator);
                mainPanel.remove(jSeparator3);
                mainPanel.remove(resultDenominator);

                int digits = resultWhole.getText().length();
                resultWhole.setBounds(210,150,
                        resultWholeWidth, 25);

                int startPos = 210 + resultWholeWidth + 5;
                resultNumerator.setBounds(startPos,135,resultNumeratorWidth,25);
                jSeparator3.setBounds(startPos,162,resultNumeratorWidth>resultDenominatorWidth?resultNumeratorWidth:resultDenominatorWidth,10);
                resultDenominator.setBounds(startPos,165,resultDenominatorWidth,25);

                mainPanel.add(resultWhole);
                mainPanel.add(resultNumerator);
                mainPanel.add(jSeparator3);
                mainPanel.add(resultDenominator);

                this.repaint();

            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RationalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RationalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RationalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RationalApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RationalApp().setVisible(true);
            }
        });
    }
}
