
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//run this program again to decrypt
public class Imageoperation {

    public static void ops(int key){
        JFileChooser jfc=new JFileChooser();
        jfc.showOpenDialog(null);
       File file=jfc.getSelectedFile();
       try {
           FileInputStream fis = new FileInputStream(file);
           byte[] data=new byte[fis.available()];
            fis.read(data);
            System.out.println(data.length);
           
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "done");
       } catch (Exception e) 
       {
        e.printStackTrace();
       }
    }
    public static void main(String args[]){
        JFrame j =new JFrame();
        j.setTitle("Image");
        j.setSize(400,350);
        j.setLocationRelativeTo(null );
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1=new Font("roboto",Font.BOLD,25);
        JButton button1=new JButton();
        button1.setText("Press to open image");
        button1.setFont(font1);
        JTextField tf=new JTextField(10);
        tf.setFont(font1);
        j.setLayout(new FlowLayout());
        j.add(button1);
        j.add(tf);
        button1.addActionListener(e->{
          String text=  tf.getText();
          int temp=Integer.parseInt(text);
            ops(temp);
        });

        j.setVisible(true);


    }

}