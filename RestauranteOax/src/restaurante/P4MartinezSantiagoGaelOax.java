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
    private JLabel etiqAtole, etiqTamal, etiqTlay, etiquetaDesayuno, nomAtole, nomTamal, nomTlay, tiposAtole, tiposTamal;
    private JButton butAtole, butTamal, butTlay;

    private ImageIcon sopaPiedra, cecina, chapulines;
    private JLabel etiqSopa, etiqCecina, etiquChapulin, etiqComidas, nomSopa, nomCecina, nomChapulin;
    private JButton butSopa, butCecina, butChapulin;

    private ImageIcon panes, tasajo, chocolate;
    private JLabel etiqPanes, etiqTasajo, etiqChocolate, etiqCenas, nomPanes, nomTasajo, nomChocolate;
    private JButton butPanes, butTasajo, butChocolate;

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
        
        setLayout(null);

        // instanciamos colores y fuentes a ocupar
        Font fuenteSerief  = new Font("Serief",Font.BOLD,14);
        Font fuenteSerief30  = new Font("Serief",Font.BOLD,30);
        Color colorCarnita = new Color(255, 222, 166);
        Color colorVerdeOscuro = new Color(88, 138, 39);

        // instanciamos el panel de menus y añadimos elementos
        panelMenus = new JPanel();
        panelMenus.setPreferredSize(new Dimension(500, 750));
        panelMenus.setBackground(new Color(250, 155, 40));
        panelMenus.setBounds(120, 35, 580, 620);
        panelMenus.setLayout(null);

        //---------------Espacio de desayunos------------------
        etiquetaDesayuno = new JLabel("Desayunos");
        etiquetaDesayuno.setFont(fuenteSerief30);
        etiquetaDesayuno.setBounds(210, 18, 170, 35);
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
        etiqAtole.setBounds(50,65, 128, 96);
        etiqAtole.setAlignmentX(LEFT_ALIGNMENT);
        panelMenus.add(etiqAtole);

        etiqTamal = new JLabel(); // img tamales oaxaqueños
        etiqTamal.setIcon(tamalOax);
        etiqTamal.setBounds(230,65, 128, 96);
        panelMenus.add(etiqTamal);

        etiqTlay = new JLabel(); //tlayudas
        etiqTlay.setIcon(tlayuyas);
        etiqTlay.setBounds(410,65, 128, 96);
        panelMenus.add(etiqTlay);

        // instanciamos botones para ordenar cada desayuno
        butAtole = new JButton("Ordenar");
        butAtole.setFont(fuenteSerief);
        butAtole.setBackground(colorVerdeOscuro);
        butAtole.setBounds(68, 220, 100, 25);
        butAtole.addActionListener(this);
        butTamal = new JButton("Ordenar");
        butTamal.setFont(fuenteSerief);
        butTamal.setBackground(colorVerdeOscuro);
        butTamal.setBounds(248, 220, 100, 25);
        butTamal.addActionListener(this);
        butTlay = new JButton("Ordenar");
        butTlay.setFont(fuenteSerief);
        butTlay.setBackground(colorVerdeOscuro);
        butTlay.setBounds(428, 220, 100, 25);
        butTlay.addActionListener(this);

        // botones y etiquetas de cada platillo
        nomAtole = new JLabel("Atoles $35");
        tiposAtole = new JLabel("(Choco, arroz, guayaba)");
        tiposAtole.setFont(fuenteSerief);
        tiposAtole.setOpaque(true);
        tiposAtole.setBackground(colorCarnita);
        tiposAtole.setBounds(38, 192, 170, 22);;
        nomAtole.setFont(fuenteSerief);
        nomAtole.setOpaque(true);
        nomAtole.setBackground(colorCarnita);
        nomAtole.setBounds(68, 170, 80, 22);
        panelMenus.add(tiposAtole);
        panelMenus.add(nomAtole);
        panelMenus.add(butAtole);

        nomTamal = new JLabel("Tamales Oaxaqueños $35");
        nomTamal.setFont(fuenteSerief);
        nomTamal.setOpaque(true);
        nomTamal.setBackground(colorCarnita);
        nomTamal.setBounds(185, 170, 198, 22);
        tiposTamal = new JLabel("(Mole, Verde)");
        tiposTamal.setFont(fuenteSerief);
        tiposTamal.setOpaque(true);
        tiposTamal.setBackground(colorCarnita);
        tiposTamal.setBounds(230, 192,110, 22);
        panelMenus.add(tiposTamal);
        panelMenus.add(nomTamal);
        panelMenus.add(butTamal);

        nomTlay = new JLabel("Tlayudas");
        nomTlay.setFont(fuenteSerief);
        nomTlay.setOpaque(true);
        nomTlay.setBackground(colorCarnita);
        nomTlay.setBounds(445, 181, 65, 22);
        panelMenus.add(nomTlay);
        panelMenus.add(butTlay);

        //------------------Espacio de comidas--------------------
        etiqComidas = new JLabel("Comidas");
        etiqComidas.setFont(fuenteSerief30);
        etiqComidas.setBounds(230, 258, 130, 35);
        etiqComidas.setAlignmentX(CENTER_ALIGNMENT);
        etiqComidas.setOpaque(true);
        etiqComidas.setBackground(colorCarnita);
        panelMenus.add(etiqComidas);

        //instanciamos imagenes de las comidas
        sopaPiedra = new ImageIcon(new ImageIcon("sopaPiedra.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        chapulines = new ImageIcon(new ImageIcon("chapulines.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        cecina = new ImageIcon(new ImageIcon("cecina.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));

        etiqSopa = new JLabel(); // img sopa de piedra
        etiqSopa.setIcon(sopaPiedra);
        etiqSopa.setBounds(50,305, 128, 96);
        etiqSopa.setAlignmentX(LEFT_ALIGNMENT);
        panelMenus.add(etiqSopa);

        etiquChapulin = new JLabel(); // img chapulines
        etiquChapulin.setIcon(chapulines);
        etiquChapulin.setBounds(230,305, 128, 96);
        panelMenus.add(etiquChapulin);

        etiqCecina = new JLabel(); // img cecina
        etiqCecina.setIcon(cecina);
        etiqCecina.setBounds(410,305, 128, 96);
        panelMenus.add(etiqCecina);

        // instanciamos botones para ordenar cada  comida
        butSopa = new JButton("Ordenar");
        butSopa.setFont(fuenteSerief);
        butSopa.setBackground(colorVerdeOscuro);
        butSopa.setBounds(70, 437, 100, 25);
        butSopa.addActionListener(this);
        butChapulin = new JButton("Ordenar");
        butChapulin.setFont(fuenteSerief);
        butChapulin.setBackground(colorVerdeOscuro);
        butChapulin.setBounds(250, 437, 100, 25);
        butChapulin.addActionListener(this);
        butCecina = new JButton("Ordenar");
        butCecina.setFont(fuenteSerief);
        butCecina.setBackground(colorVerdeOscuro);
        butCecina.setBounds(430, 437, 100, 25);
        butCecina.addActionListener(this);

        // botones y etiquetas de cada platillo
        nomSopa = new JLabel("Sopa de piedra $35");
        nomSopa.setFont(fuenteSerief);
        nomSopa.setOpaque(true);
        nomSopa.setBackground(colorCarnita);
        nomSopa.setBounds(40, 411, 140, 22);
        panelMenus.add(nomSopa);
        panelMenus.add(butSopa);

        nomChapulin = new JLabel("Chapulines 40$");
        nomChapulin.setFont(fuenteSerief);
        nomChapulin.setOpaque(true);
        nomChapulin.setBackground(colorCarnita);
        nomChapulin.setBounds(240, 411, 110, 22);
        panelMenus.add(nomChapulin);
        panelMenus.add(butChapulin);

        nomCecina = new JLabel("Cecina acompañada $50");
        nomCecina.setFont(fuenteSerief);
        nomCecina.setOpaque(true);
        nomCecina.setBackground(colorCarnita);
        nomCecina.setBounds(390, 411, 170, 22);
        panelMenus.add(nomCecina);
        panelMenus.add(butCecina);

        //-------------------Espacio de cenas-------------------------

        etiqCenas = new JLabel("Cenas");
        etiqCenas.setFont(fuenteSerief30);
        etiqCenas.setBounds(80, 40, 250, 20);
        etiqCenas.setAlignmentX(CENTER_ALIGNMENT);
        etiqCenas.setOpaque(true);
        etiqCenas.setBackground(colorCarnita);
        panelMenus.add(etiqCenas);

        //instanciamos imagenes de las comidas
        panes = new ImageIcon(new ImageIcon("panes.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        tasajo = new ImageIcon(new ImageIcon("tasajo.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));
        chocolate = new ImageIcon(new ImageIcon("chocoalte.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));

        etiqPanes = new JLabel(); // img panes
        etiqPanes.setIcon(panes);
        etiqPanes.setBounds(30,80, 500, 500);
        etiqPanes.setAlignmentX(LEFT_ALIGNMENT);
        panelMenus.add(etiqPanes);

        etiqTasajo = new JLabel(); // img tasajo
        etiqTasajo.setIcon(tasajo);
        etiqTasajo.setBounds(30,80, 500, 500);
        panelMenus.add(etiqTasajo);

        etiqChocolate = new JLabel(); // img chocolate
        etiqChocolate.setIcon(chocolate);
        etiqChocolate.setBounds(30,80, 500, 500);
        panelMenus.add(etiqChocolate);

        // instanciamos botones para ordenar cada comida
        butPanes = new JButton("Ordenar");
        butPanes.setFont(fuenteSerief);
        butPanes.setBackground(colorVerdeOscuro);
        butPanes.addActionListener(this);
        butTasajo = new JButton("Ordenar");
        butTasajo.setFont(fuenteSerief);
        butTasajo.setBackground(colorVerdeOscuro);
        butTasajo.addActionListener(this);
        butChocolate = new JButton("Ordenar");
        butChocolate.setFont(fuenteSerief);
        butChocolate.setBackground(colorVerdeOscuro);
        butChocolate.addActionListener(this);

        // botones y etiquetas de cada platillo
        nomPanes = new JLabel("Panes de dulce $20");
        nomPanes.setFont(fuenteSerief);
        nomPanes.setOpaque(true);
        nomPanes.setBackground(colorCarnita);
        panelMenus.add(nomPanes);
        panelMenus.add(butPanes);

        nomTasajo = new JLabel("Tasajo acompañado $50");
        nomTasajo.setFont(fuenteSerief);
        nomTasajo.setOpaque(true);
        nomTasajo.setBackground(colorCarnita);
        panelMenus.add(nomTasajo);
        panelMenus.add(butTasajo);

        nomChocolate = new JLabel("Chocolate caliente $25");
        nomChocolate.setFont(fuenteSerief);
        nomChocolate.setOpaque(true);
        nomChocolate.setBackground(colorCarnita);
        panelMenus.add(nomChocolate);
        panelMenus.add(butChocolate);

        ventana.add(panelMenus);
        panelComida = new JPanel();
        panelComida.setPreferredSize(new Dimension(500, 750));
        panelComida.setBackground(new Color(248, 63, 169));
        ventana.add(panelComida);
    }

    public void actionPerformed(ActionEvent event) {
        
    }
}
