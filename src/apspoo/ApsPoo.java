package apspoo;

//importações sendo usadas nesse programa
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;


//Classe que aplica o JFrame e uma Action
public class ApsPoo extends JFrame implements ActionListener {

    
    //variareis para manipulação do tamanho da fonte e estilo
    int tamanho = 18;
    int negrito = 0;
    String nome = "Serif";
    
    //inclusão de todos os elementos gráficos e algumas ações
    JLabel legenda = new JLabel("Bem vindo ao editor de texto!");
    JButton jb = new JButton("Diminuir Fonte");
    Font fonte = new Font("Serif",Font.PLAIN,20);
    JTextArea caixa = new JTextArea();
    JButton jb2 = new JButton("Aumentar Fonte");
    JCheckBox check = new JCheckBox(" Negrito");
    JComboBox<String> combo = new JComboBox<>();
    ItemHandler handler = new ItemHandler();
    CheckHandler handler2 = new CheckHandler();
    
/*===================================================================
   Metodo que implementa a ação dos JButtons
=====================================================================
    */  
   @Override
    public void actionPerformed (ActionEvent e) {
      if(e.getSource()==jb){
        Font nova = caixa.getFont();
        caixa.setFont(new Font(nome,negrito,--tamanho));
    }else if (e.getSource()==jb2){
        Font nova = caixa.getFont();
        caixa.setFont(new Font(nome,negrito,++tamanho));
    }    
}
    
/*===================================================================
    classe e metodo que implementa a ação do JComboBox  
=====================================================================
    */  
    
    private class ItemHandler implements ItemListener {    
    @Override
    public void itemStateChanged(ItemEvent event){
        if(combo.getSelectedItem().equals("Serif")){
           caixa.setFont(new Font(nome = "Serif",negrito,tamanho)); 
        }else if(combo.getSelectedItem().equals("SansSerif")){
           caixa.setFont(new Font(nome = "SanSerif",negrito,tamanho)); 
        }else if(combo.getSelectedItem().equals("Monospaced")){
           caixa.setFont(new Font(nome = "Monospaced",negrito,tamanho));  
        }
    }   
} 
    
/*===================================================================
    classe e metodo que implementa a ação do CheckBox
=====================================================================
    */  
 
    private class CheckHandler implements ItemListener{
        
    @Override
    public void itemStateChanged(ItemEvent event){
    Font nova = caixa.getFont();
    if (check.isSelected()){
            caixa.setFont(new Font(nome,negrito = 1,tamanho));
        } else if(check.isEnabled()) {
            caixa.setFont(new Font(nome,negrito = 0,tamanho));
        } 
    }
    }


/*===================================================================
    Metodo que configura a JFrame e seus elementos
=====================================================================
    */    
public ApsPoo(){
  //Dados que adicionam o JLabel
    add(legenda);
    legenda.setFont(fonte);
    legenda.setVisible(true);
    legenda.setBounds(130, 10, 400, 100);
    
    
  //Dados que adicionam o JCheckBox
     check.addItemListener(handler2);
     add(check);
     check.setBounds(100, 150, 150, 35);
     check.setFont(fonte);
    
  //Dados que adicionam o JComboBox
     add(combo);
     combo.addItem("Serif");
     combo.addItem("SansSerif");
     combo.addItem("Monospaced");
     combo.setBounds(250, 150, 150, 30);
     combo.setFont(fonte);   
     combo.addItemListener(handler);
    
//Dados que Adicionam os JButtons
     jb.setFont(fonte);
     setLayout(null);
     jb.setBounds(90,100,160,30);
     add(jb);
     jb.addActionListener(this);
     
     jb2.setFont(fonte);
     setLayout(null);
     jb2.setBounds(250, 100, 160, 30);
     add(jb2);
     jb2.addActionListener(this);

     
     
     
  //Dados que adicionam a caixa de texto
     add(caixa);
     caixa.setBounds(7,260,480,200);
     caixa.setFont(new Font(nome,negrito,tamanho));

  //Dados que adicionam a janela Jframe
     setTitle("Editor de texto");
     setSize(500, 500);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     setResizable(false);    
}
    public static void main(String[] args) {
        new ApsPoo();
    }
}
    
