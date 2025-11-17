package restaurante;

/**
 * Programa: Calculadora de IMC
 * Autores: Martínez Santiago Gael 
 * 			Chávez Núñez Citlalli
 * 			
 * Fecha: 03/nov/25
 * Descripción: Consiste en un cuestionario que te solicita tu
 * peso, estatura y nombre, y con eso dar tu IMC.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class P4MartinezSantiagoGaelOax extends JFrame implements ActionListener {

    private JPanel panelMenus, panelComida;
    private ImageIcon atole, tamalOax, tlayuyas;
    private JLabel etiqAtole, etiqTamal, etiqTlay, etiquetaDesayuno, nomAtole, nomTamal, nomTlay;
    private JButton butAtole, butTamal, butTlay;

    public static void main(String[] args) {
        P4MartinezSantiagoGaelOax marco = new P4MartinezSantiagoGaelOax();
        marco.setSize(1920, 1080);
        marco.setTitle("Restaurante");
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setBackground(new Color(1, 101, 231));
        ventana.setLayout(new FlowLayout());
        //setLayout(null);

        // instanciamos colores y fuentes a ocupar
        Font fuenteSerief  = new Font("Serief",Font.BOLD,14);
        Font fuenteSerief30  = new Font("Serief",Font.BOLD,30);
        Color colorCarnita = new Color(255, 222, 166);
        Color colorVerdeOscuro = new Color(88, 138, 39);

        // instanciamos el panel de menus y añadimos elementos
        panelMenus = new JPanel();
        panelMenus.setPreferredSize(new Dimension(500, 750));
        panelMenus.setBackground(new Color(250, 155, 40));

        //---------------Espacio de desayunos------------------
        etiquetaDesayuno = new JLabel("Desayunos");
        etiquetaDesayuno.setFont(fuenteSerief30);
        etiquetaDesayuno.setBounds(80, 40, 250, 20);
        etiquetaDesayuno.setAlignmentX(CENTER_ALIGNMENT);
        etiquetaDesayuno.setOpaque(true);
        etiquetaDesayuno.setBackground(colorCarnita);
        panelMenus.add(etiquetaDesayuno);

        //instanciamos y botones imagenes de los desayunos
        tamalOax = new ImageIcon(new ImageIcon("tamalesOax.jpg").getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));
        atole = new ImageIcon(new ImageIcon("atoles.jpg").getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));
        tlayuyas = new ImageIcon(new ImageIcon("tlayudas.jpg").getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));

        butAtole = new JButton("Ordenar");
        butAtole.setFont(fuenteSerief);
        butAtole.setBackground(colorVerdeOscuro);
        butAtole.addActionListener(this);
        butTamal = new JButton("Ordenar");
        butTamal.setFont(fuenteSerief);
        butTamal.setBackground(colorVerdeOscuro);
        butTamal.addActionListener(this);
        butTlay = new JButton("Ordenar");
        butTlay.setFont(fuenteSerief);
        butTlay.setBackground(colorVerdeOscuro);
        butTlay.addActionListener(this);

        // botones y etiquetas de imagen de cada platillo
        etiqAtole = new JLabel(); // atoles
        etiqAtole.setIcon(atole);
        etiqAtole.setBounds(30,80, 500, 500);
        etiqAtole.setAlignmentX(LEFT_ALIGNMENT);
        nomAtole = new JLabel("Atoles (chocolate, arroz, guayaba)");
        nomAtole.setFont(fuenteSerief);
        nomAtole.setBackground(colorCarnita);
        panelMenus.add(etiqAtole);
        panelMenus.add(nomAtole);
        panelMenus.add(butAtole);

        etiqTamal = new JLabel(); //tamales oaxaqueños
        etiqTamal.setIcon(tamalOax);
        etiqTamal.setBounds(30,80, 500, 500);
        panelMenus.add(etiqTamal);
        panelMenus.add(butTamal);

        etiqTlay = new JLabel(); //tlayudas
        etiqTlay.setIcon(tlayuyas);
        etiqTlay.setBounds(30,80, 500, 500);
        panelMenus.add(etiqTlay);
        panelMenus.add(butTlay);

        ventana.add(panelMenus);
        
        panelComida = new JPanel();
        panelComida.setPreferredSize(new Dimension(500, 750));
        panelComida.setBackground(new Color(248, 63, 169));
        ventana.add(panelComida);
    }

    public void actionPerformed(ActionEvent event) {
        
    }
}
