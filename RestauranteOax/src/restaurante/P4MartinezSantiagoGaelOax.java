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

    private ImageIcon sopaPiedra, cecina, chapulines;
    private JLabel etiqSopa, etiqCecina, etiquChapulin, etiqComidas, nomSopa, nomCecina, nomChapulin;
    private JButton butSopa, butCecina, butChapulin;

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

        //instanciamos imagenes de los desayunos
        tamalOax = new ImageIcon(new ImageIcon("tamalesOax.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        atole = new ImageIcon(new ImageIcon("atoles.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        tlayuyas = new ImageIcon(new ImageIcon("tlayudas.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));

        etiqAtole = new JLabel(); // img atoles
        etiqAtole.setIcon(atole);
        etiqAtole.setBounds(30,80, 500, 500);
        etiqAtole.setAlignmentX(LEFT_ALIGNMENT);
        panelMenus.add(etiqAtole);

        etiqTamal = new JLabel(); // img tamales oaxaqueños
        etiqTamal.setIcon(tamalOax);
        etiqTamal.setBounds(30,80, 500, 500);
        panelMenus.add(etiqTamal);

        etiqTlay = new JLabel(); //tlayudas
        etiqTlay.setIcon(tlayuyas);
        etiqTlay.setBounds(30,80, 500, 500);
        panelMenus.add(etiqTlay);

        // instanciamos botones para ordenar cada desayuno
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

        // botones y etiquetas de cada platillo
        nomAtole = new JLabel("Atoles \n (chocolate, arroz, guayaba)");
        nomAtole.setFont(fuenteSerief);
        nomAtole.setOpaque(true);
        nomAtole.setBackground(colorCarnita);
        panelMenus.add(nomAtole);
        panelMenus.add(butAtole);

        nomTamal = new JLabel("Tamales Oaxaqueños \n (verde, mole, dulce)");
        nomTamal.setFont(fuenteSerief);
        nomTamal.setOpaque(true);
        nomTamal.setBackground(colorCarnita);
        panelMenus.add(nomTamal);
        panelMenus.add(butTamal);

        nomTlay = new JLabel("Tlayudas");
        nomTlay.setFont(fuenteSerief);
        nomTlay.setOpaque(true);
        nomTlay.setBackground(colorCarnita);
        panelMenus.add(nomTlay);
        panelMenus.add(butTlay);

        //------------------Espacio de comidas--------------------
        etiqComidas = new JLabel("Comidas");
        etiqComidas.setFont(fuenteSerief30);
        etiqComidas.setBounds(80, 40, 250, 20);
        etiqComidas.setAlignmentX(CENTER_ALIGNMENT);
        etiqComidas.setOpaque(true);
        etiqComidas.setBackground(colorCarnita);
        panelMenus.add(etiqComidas);

        //instanciamos imagenes de las comidas
        sopaPiedra = new ImageIcon(new ImageIcon("sopaPiedra.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        chapulines = new ImageIcon(new ImageIcon("chapulines.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        cecina = new ImageIcon(new ImageIcon("cecina.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));

        etiqSopa = new JLabel(); // img atoles
        etiqSopa.setIcon(sopaPiedra);
        etiqSopa.setBounds(30,80, 500, 500);
        etiqSopa.setAlignmentX(LEFT_ALIGNMENT);
        panelMenus.add(etiqSopa);

        etiquChapulin = new JLabel(); // img chapulines
        etiquChapulin.setIcon(chapulines);
        etiquChapulin.setBounds(30,80, 500, 500);
        panelMenus.add(etiquChapulin);

        etiqCecina = new JLabel(); // img cecina
        etiqCecina.setIcon(cecina);
        etiqCecina.setBounds(30,80, 500, 500);
        panelMenus.add(etiqCecina);

        // instanciamos botones para ordenar cada  comida
        butSopa = new JButton("Ordenar");
        butSopa.setFont(fuenteSerief);
        butSopa.setBackground(colorVerdeOscuro);
        butSopa.addActionListener(this);
        butChapulin = new JButton("Ordenar");
        butChapulin.setFont(fuenteSerief);
        butChapulin.setBackground(colorVerdeOscuro);
        butChapulin.addActionListener(this);
        butCecina = new JButton("Ordenar");
        butCecina.setFont(fuenteSerief);
        butCecina.setBackground(colorVerdeOscuro);
        butCecina.addActionListener(this);

        // botones y etiquetas de cada platillo
        nomSopa = new JLabel("Sopa de piedra \n (Plato grande 35$) \n (Plato chico $25)");
        nomSopa.setFont(fuenteSerief);
        nomSopa.setOpaque(true);
        nomSopa.setBackground(colorCarnita);
        panelMenus.add(nomSopa);
        panelMenus.add(butSopa);

        nomChapulin = new JLabel("Chapulines 40$");
        nomChapulin.setFont(fuenteSerief);
        nomChapulin.setOpaque(true);
        nomChapulin.setBackground(colorCarnita);
        panelMenus.add(nomChapulin);
        panelMenus.add(butChapulin);

        nomCecina = new JLabel("Cecina acompañada $50");
        nomCecina.setFont(fuenteSerief);
        nomCecina.setOpaque(true);
        nomCecina.setBackground(colorCarnita);
        panelMenus.add(nomCecina);
        panelMenus.add(butCecina);

        //-------------------Espacio de cenas-------------------------

        

        ventana.add(panelMenus);
        panelComida = new JPanel();
        panelComida.setPreferredSize(new Dimension(500, 750));
        panelComida.setBackground(new Color(248, 63, 169));
        ventana.add(panelComida);
    }

    public void actionPerformed(ActionEvent event) {
        
    }
}
