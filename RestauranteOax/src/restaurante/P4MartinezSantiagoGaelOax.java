package restaurante;

/**
 * Programa: Antojitos oaxacos p6
 * Autores: Martí­nez Santiago Gael 
 * 			Chávez Núñez Citlalli
 * 			
 * Fecha: 18/nov/25
 * Descripción: Sistema de un restaurante en donde se puede ordenar tu pedido, se crea una factura que muestra el precio con 
 * y sin IVA, y se puede seleccionar el metodo de pago
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class P4MartinezSantiagoGaelOax extends JFrame implements ActionListener {

    private JPanel panelMenus, panelComida;

    //objetos para el desayuno
    private ImageIcon atole, tamalOax, tlayuyas;
    private JLabel etiqAtole, etiqTamal, etiqTlay, etiquetaDesayuno, nomAtole, nomTamal, nomTlay, tiposAtole, tiposTamal;
    private JButton butAtole, butTamal, butTlay;

    // Cuenta y precios
    private String strDineroDado;
    private double dineroDado = 0.0;
    private double precioAtole = 45.0;
    private double precioTamal = 30.0;
    private double precioTlay = 70.0;
    private double precioSopa = 35.0;
    private double precioChapulin = 40.0;
    private double precioCecina = 50.0;
    private double precioPan = 20.0;
    private double precioTasajo = 50.0;
    private double precioChocolate = 25.0;
    private double totalCuenta = 0.0;
    private JTextArea areaCuenta;
    private JLabel etiquetaTotalCuenta;
    private JButton butLimpiar, butPagar;

    //objetos para las comidas
    private ImageIcon sopaPiedra, cecina, chapulines;
    private JLabel etiqSopa, etiqCecina, etiquChapulin, etiqComidas, nomSopa, nomCecina, nomChapulin;
    private JButton butSopa, butCecina, butChapulin;

    //objetos para la cena
    private ImageIcon tasajo;
    private JLabel etiqTasajo, etiqCenas, nomPanes, nomTasajo, nomChocolate;
    private JButton butPanes, butTasajo, butChocolate;

    //objetos para metodos de pago
    private ButtonGroup metodosDispo;
    private  JRadioButton butEfectivo, butTarjeta, butTransferencia;
    
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
        //ventana.setLayout(new FlowLayout());
        
        setLayout(null);

        // instanciamos colores y fuentes a ocupar
        Font fuenteSerief  = new Font("Serief",Font.BOLD,14);
        Font fuenteSerief30  = new Font("Serief",Font.BOLD,30);
        Color colorCarnita = new Color(255, 222, 166);
        Color colorVerdeOscuro = new Color(88, 138, 39);

        // instanciamos el panel de menus y aÃ±adimos elementos
        panelMenus = new JPanel();
        panelMenus.setPreferredSize(new Dimension(500, 750));
        panelMenus.setBackground(new Color(250, 155, 40));
        panelMenus.setBounds(120, 5, 580, 675);
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

        etiqTamal = new JLabel(); // img tamales oaxaqueÃ±os
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
        butAtole.setActionCommand("ATOLE");
        butAtole.addActionListener(this);
        butTamal = new JButton("Ordenar");
        butTamal.setFont(fuenteSerief);
        butTamal.setBackground(colorVerdeOscuro);
        butTamal.setBounds(248, 220, 100, 25);
        butTamal.addActionListener(this);
        butTamal.setActionCommand("TAMAL");
        butTlay = new JButton("Ordenar");
        butTlay.setFont(fuenteSerief);
        butTlay.setBackground(colorVerdeOscuro);
        butTlay.setBounds(428, 220, 100, 25);
        butTlay.addActionListener(this);
        butTlay.setActionCommand("TLAYUDA");

        // botones y etiquetas de cada platillo
        nomAtole = new JLabel("Atoles $45");
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

        nomTamal = new JLabel("Tamales OaxaqueÃ±os $30");
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

        nomTlay = new JLabel("Tlayudas $70");
        nomTlay.setFont(fuenteSerief);
        nomTlay.setOpaque(true);
        nomTlay.setBackground(colorCarnita);
        nomTlay.setBounds(435, 181, 90, 22);
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
        butSopa.setActionCommand("SOPA");
        butSopa.addActionListener(this);
        butChapulin = new JButton("Ordenar");
        butChapulin.setFont(fuenteSerief);
        butChapulin.setBackground(colorVerdeOscuro);
        butChapulin.setBounds(250, 437, 100, 25);
        butChapulin.setActionCommand("CHAPULIN");
        butChapulin.addActionListener(this);
        butCecina = new JButton("Ordenar");
        butCecina.setFont(fuenteSerief);
        butCecina.setBackground(colorVerdeOscuro);
        butCecina.setBounds(430, 437, 100, 25);
        butCecina.setActionCommand("CECINA");
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

        nomCecina = new JLabel("Cecina acompaÃ±ada $50");
        nomCecina.setFont(fuenteSerief);
        nomCecina.setOpaque(true);
        nomCecina.setBackground(colorCarnita);
        nomCecina.setBounds(390, 411, 170, 22);
        panelMenus.add(nomCecina);
        panelMenus.add(butCecina);

        //-------------------Espacio de cenas-------------------------

        etiqCenas = new JLabel("Cenas");
        etiqCenas.setFont(fuenteSerief30);
        etiqCenas.setBounds(250, 472, 100, 35);
        etiqCenas.setAlignmentX(CENTER_ALIGNMENT);
        etiqCenas.setOpaque(true);
        etiqCenas.setBackground(colorCarnita);
        panelMenus.add(etiqCenas);

        //instanciamos imagenes de las cenas
        tasajo = new ImageIcon(new ImageIcon("tasajo.jpg").getImage().getScaledInstance(128, 96, Image.SCALE_DEFAULT));

        etiqTasajo = new JLabel(); // img tasajo
        etiqTasajo.setIcon(tasajo);
        etiqTasajo.setBounds(410,535, 128, 96);
        panelMenus.add(etiqTasajo);

        // instanciamos botones para ordenar cada comida
        butPanes = new JButton("Ordenar");
        butPanes.setFont(fuenteSerief);
        butPanes.setBackground(colorVerdeOscuro);
        butPanes.setBounds(200, 531, 100, 25);
        butPanes.setActionCommand("PANES");
        butPanes.addActionListener(this);
        butTasajo = new JButton("Ordenar");
        butTasajo.setFont(fuenteSerief);
        butTasajo.setBackground(colorVerdeOscuro);
        butTasajo.setBounds(200, 565, 100, 25);
        butTasajo.setActionCommand("TASAJO");
        butTasajo.addActionListener(this);
        butChocolate = new JButton("Ordenar");
        butChocolate.setFont(fuenteSerief);
        butChocolate.setBackground(colorVerdeOscuro);
        butChocolate.setBounds(200, 599, 100, 25);
        butChocolate.setActionCommand("CHOCOLATE");
        butChocolate.addActionListener(this);

        // botones y etiquetas de cada platillo
        nomPanes = new JLabel("Panes de dulce $20");
        nomPanes.setFont(fuenteSerief);
        nomPanes.setOpaque(true);
        nomPanes.setBackground(colorCarnita);
        nomPanes.setBounds(40, 531, 140, 22);
        panelMenus.add(nomPanes);
        panelMenus.add(butPanes);

        nomTasajo = new JLabel("Tasajo acompaÃ±ado $50");
        nomTasajo.setFont(fuenteSerief);
        nomTasajo.setOpaque(true);
        nomTasajo.setBackground(colorCarnita);
        nomTasajo.setBounds(40, 565, 140, 22);
        panelMenus.add(nomTasajo);
        panelMenus.add(butTasajo);

        nomChocolate = new JLabel("Chocolate caliente $25");
        nomChocolate.setFont(fuenteSerief);
        nomChocolate.setOpaque(true);
        nomChocolate.setBackground(colorCarnita);
        nomChocolate.setBounds(40, 599, 140, 22);
        panelMenus.add(nomChocolate);
        panelMenus.add(butChocolate);

        ventana.add(panelMenus);
        
        // panel de cuenta
        panelComida = new JPanel();
        panelComida.setPreferredSize(new Dimension(550, 750));
        panelComida.setBounds(710, 5, 550, 690);
        panelComida.setBackground(new Color(248, 63, 169));
        panelComida.setLayout(new BorderLayout(10,10));

        JLabel tituloCuenta = new JLabel("Cuenta");
        tituloCuenta.setFont(fuenteSerief30);
        tituloCuenta.setHorizontalAlignment(SwingConstants.CENTER);
        panelComida.add(tituloCuenta, BorderLayout.NORTH);

        areaCuenta = new JTextArea();
        areaCuenta.setEditable(false);
        areaCuenta.setFont(new Font("Serief",Font.BOLD,14));
        JScrollPane sp = new JScrollPane(areaCuenta);
        panelComida.add(sp, BorderLayout.CENTER);

        JPanel abajo = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        etiquetaTotalCuenta = new JLabel("Total: $0.00");
        etiquetaTotalCuenta.setFont(fuenteSerief);
        abajo.add(etiquetaTotalCuenta);

        butPagar = new JButton("Pagar");
        butPagar.setFont(fuenteSerief);
        butPagar.addActionListener(this);
        butPagar.setActionCommand("PAGO");
        
        abajo.add(butPagar);

        butLimpiar = new JButton("Limpiar");
        butLimpiar.setFont(fuenteSerief);
        butLimpiar.setActionCommand("LIMPIAR");
        butLimpiar.addActionListener(this);
        abajo.add(butLimpiar);
        
        //-----------------métodos de pago----------------
        metodosDispo = new ButtonGroup();
        butEfectivo = new JRadioButton("Efectivo");
        metodosDispo.add(butEfectivo);
        butTarjeta = new JRadioButton("Tarjeta");
        metodosDispo.add(butTarjeta);
        butTransferencia = new JRadioButton("Trans");
        metodosDispo.add(butTransferencia);

        abajo.add(butEfectivo);
        abajo.add(butTarjeta);
        abajo.add(butTransferencia);

        panelComida.add(abajo, BorderLayout.SOUTH);

        ventana.add(panelComida);
    }

    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        
        // se le suma precio a la cuenta o se paga
        if ("ATOLE".equals(cmd)) {
            areaCuenta.append(String.format("Atole\t - $%.2f%n", precioAtole));
            totalCuenta += precioAtole;
        } else if ("TAMAL".equals(cmd)) {
            areaCuenta.append(String.format("Tamal\t - $%.2f%n", precioTamal));
            totalCuenta += precioTamal;
        } else if ("TLAYUDA".equals(cmd)) {
            areaCuenta.append(String.format("Tlayuda - $%.2f%n", precioTlay));
            totalCuenta += precioTlay;
        } else if ("PAGO".equals(cmd)){
            if (totalCuenta > 0) {
            	if (butTarjeta.isSelected()){ // procedimiento a seguir con efectivo
            		strDineroDado = JOptionPane.showInputDialog(null, "Escribe el dinero a dar:");            	
            	}
                JOptionPane.showMessageDialog(this, "Subtotal: $" + String.format("%.2f", totalCuenta) + "\n IVA: $" + String.format("%.2f", totalCuenta*0.16) + "\n Total a pagar: $" + String.format("%.2f", totalCuenta + totalCuenta*0.16));
                areaCuenta.setText("");
                totalCuenta = 0.0;
                etiquetaTotalCuenta.setText("Total: $0.00");
            } else {
                JOptionPane.showMessageDialog(this, "La cuenta está vacía.");
            }
        }else if ("LIMPIAR".equals(cmd)){
            areaCuenta.setText("");
            totalCuenta = 0.0;
            etiquetaTotalCuenta.setText("Total: $0.00");
        } else if ("CHAPULIN".equals(cmd)){
            areaCuenta.append(String.format("Chapulines\t - $%.2f%n", precioChapulin));
            totalCuenta += precioChapulin;
        }else if ("SOPA".equals(cmd)){
            areaCuenta.append(String.format("Sopa de piedra\t - $%.2f%n", precioSopa));
            totalCuenta += precioSopa;
        } else if ("CECINA".equals(cmd)){
            areaCuenta.append(String.format("Cecina acompañada\t - $%.2f%n", precioCecina));
            totalCuenta += precioCecina;
        } else if ("PANES".equals(cmd)){
            areaCuenta.append(String.format("Pan de dulce\t - $%.2f%n", precioPan));
            totalCuenta += precioPan;
        } else if ("TASAJO".equals(cmd)){
            areaCuenta.append(String.format("Tasajo acompañado\t - $%.2f%n", precioTasajo));
            totalCuenta += precioTasajo;
        } else if ("CHOCOLATE".equals(cmd)){
            areaCuenta.append(String.format("Chocolate caliente\t - $%.2f%n", precioChocolate));
            totalCuenta += precioChocolate;
        } 
        
        etiquetaTotalCuenta.setText("Total: $" + String.format("%.2f", totalCuenta));
    }
}
