package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Home extends JFrame {

    private Font fonte;

    //Entrada de dados
    private JLabel tituloDados;
    private JPanel pDados;

    private JLabel pDadosX;
    private JTextArea pDadosXText;

    private JLabel pDadosY;
    private JTextArea pDadosYText;

    private JLabel pDadosRaio;
    private JTextArea pDadosRaioText;

    private JLabel pDadosAngulo;
    private JTextArea pDadosAnguloText;

    private JLabel pDadosVelocidade;
    private JTextArea pDadosVelocidadeText;

    private JLabel pDadosDirecao;
    private JTextArea pDadosDirecaoText;
    private JButton pDadosButton;

    //funções de transformação
    private JLabel tituloTransformacao;
    private JPanel pTransformacaoTranslader;
    private JLabel pTransformacaoTransladerX;
    private JTextArea pTransformacaoTransladerXText;
    private JLabel pTransformacaoTransladerY;
    private JTextArea pTransformacaoTransladerYText;
    private JButton pTransformacaoTransladerButton;
    private JPanel pTransformacaoEscalonar;
    private JLabel pTransformacaoEscalonarX;
    private JTextArea pTransformacaoEscalonarXText;
    private JLabel pTransformacaoEscalonarY;
    private JTextArea pTransformacaoEscalonarYText;
    private JButton pTransformacaoEscalonarButton;
    private JPanel pTransformacaoRotacionar;
    private JLabel pTransformacaoRotacionarAngulo;
    private JTextArea pTransformacaoRotacionarAnguloText;
    private JLabel pTransformacaoRotacionarCentroDeRotacao;

    private JLabel pTransformacaoRotacionarX;
    private JTextArea pTransformacaoRotacionarXText;
    private JLabel pTransformacaoRotacionarY;
    private JTextArea pTransformacaoRotacionarYText;
    private JButton pTransformacaoRotacionarButton;


    //Radar
    private JLabel tituloRadar;
    private JPanel pRadar;
    private JLabel planoCartesiano;

    //funções de Rastreamento
    private JLabel tituloRastreamento;
    private JPanel pDistanciaMinAeroporto;
    private JLabel pDistanciaMinAeroportoLabel;
    private JTextField pDistanciaMinAeroportoText;
    private JButton pDistanciaMinAeroportoButton;



    private JPanel pDistanciaMinAvioes;
    private JLabel pDistanciaMinAvioesLabel;
    private JTextField pDistanciaMinAvioesText;
    private JButton pDistanciaMinAvioesButton;
    private JPanel pTempoMinEmRotaColisao;
    private JLabel pTempoMinEmRotaColisaoLabel;
    private JTextField pTempoMinEmRotaColisaoText;
    private JButton pTempoMinEmRotaColisaoButton;

    //DataGrid
    private JLabel tituloDataGrid;
    private JPanel pDataGrid;

    //Radarelatorio
    private JLabel tituloRadarelatorio;
    private JPanel pRadarelatorio;

    public Home() {
        this.setSize(1300, 1000);
        setTitle("Radar");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        inicializa();
    }

    public void inicializa() {
        fonte = new Font("Arial", Font.PLAIN, 20);
        UIManager.put("Label.font", fonte);

        ///////////////////////////ENTRADA DE DADOS/////////////////////////////

        //Titulo
        tituloDados = new JLabel("Entrada de dados");
        tituloDados.setBounds(96, 12, 180, 24);
        getContentPane().add(tituloDados);

        //Painel
        pDados = new JPanel();
        pDados.setBounds(36, 43, 350, 250);
        pDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição X
        pDadosX = new JLabel("X:");
        pDadosX.setBounds(144, 73, 30, 30);
        getContentPane().add(pDadosX);

        //input X
        pDadosXText = new JTextArea();
        pDadosXText.setBounds(170, 73, 30, 30);
        pDadosXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosXText);

        //descrição Y
        pDadosY = new JLabel("Y:");
        pDadosY.setBounds(270, 73, 30, 30);
        getContentPane().add(pDadosY);

        //input Y
        pDadosYText = new JTextArea();
        pDadosYText.setBounds(310, 73, 30, 30);
        pDadosYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosYText);

        //descrição Raio
        pDadosRaio = new JLabel("Raio:");
        pDadosRaio.setBounds(114, 113, 70, 30);
        getContentPane().add(pDadosRaio);

        //input Raio
        pDadosRaioText = new JTextArea();
        pDadosRaioText.setBounds(170, 113, 30, 30);
        pDadosRaioText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosRaioText);

        //descrição Angulo
        pDadosAngulo = new JLabel("Ângulo:");
        pDadosAngulo.setBounds(210, 113, 100, 30);
        getContentPane().add(pDadosAngulo);

        //input Angulo
        pDadosAnguloText = new JTextArea();
        pDadosAnguloText.setBounds(310, 113, 30, 30);
        pDadosAnguloText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosAnguloText);

        //descrição Velocidade
        pDadosVelocidade = new JLabel("Velocidade:");
        pDadosVelocidade.setBounds(48, 153, 130, 30);
        getContentPane().add(pDadosVelocidade);

        //input Velocidade
        pDadosVelocidadeText = new JTextArea();
        pDadosVelocidadeText.setBounds(170, 153, 30, 30);
        pDadosVelocidadeText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosVelocidadeText);

        //descrição Direção
        pDadosDirecao = new JLabel("Direção:");
        pDadosDirecao.setBounds(210, 153, 100, 30);
        getContentPane().add(pDadosDirecao);

        //input Direção
        pDadosDirecaoText = new JTextArea();
        pDadosDirecaoText.setBounds(310, 153, 30, 30);
        pDadosDirecaoText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosDirecaoText);

        //Button DESCRICAO DE DADOS
        pDadosButton = new JButton("Inserir");
        pDadosButton.setBounds(126, 223, 160, 40);
        pDadosButton.setBackground(Color.orange);
        pDadosButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pDadosButton);


        getContentPane().add(pDados);

        ////////////////////////FUNÇÔES DE TRANSFORMAÇÂO///////////////////////////

        //Titulo
        tituloTransformacao = new JLabel("Funções de transformação");
        tituloTransformacao.setBounds(76, 300, 300, 24);
        getContentPane().add(tituloTransformacao);

        ////////Painel translader
        pTransformacaoTranslader = new JPanel();
        pTransformacaoTranslader.setBounds(36, 330, 170, 110);
        pTransformacaoTranslader.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição X
        pTransformacaoTransladerX = new JLabel("X:");
        pTransformacaoTransladerX.setBounds(45, 340, 30, 30);
        getContentPane().add(pTransformacaoTransladerX);

        //input X
        pTransformacaoTransladerXText = new JTextArea();
        pTransformacaoTransladerXText.setBounds(80, 340, 30, 30);
        pTransformacaoTransladerXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoTransladerXText);

        //descrição Y
        pTransformacaoTransladerY = new JLabel("Y:");
        pTransformacaoTransladerY.setBounds(120, 340, 30, 30);
        getContentPane().add(pTransformacaoTransladerY);

        //input Y
        pTransformacaoTransladerYText = new JTextArea();
        pTransformacaoTransladerYText.setBounds(150, 340, 30, 30);
        pTransformacaoTransladerYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoTransladerYText);

        //Button
        pTransformacaoTransladerButton = new JButton("Translandar");
        pTransformacaoTransladerButton.setBounds(46, 390, 140, 30);
        pTransformacaoTransladerButton.setBackground(Color.blue);
        pTransformacaoTransladerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pTransformacaoTransladerButton);
        getContentPane().add(pTransformacaoTranslader);

        ////////Painel Escalonar
        pTransformacaoEscalonar = new JPanel();
        pTransformacaoEscalonar.setBounds(216, 330, 170, 110);
        pTransformacaoEscalonar.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        //descrição X
        pTransformacaoEscalonarX = new JLabel("X:");
        pTransformacaoEscalonarX.setBounds(225, 340, 30, 30);
        getContentPane().add(pTransformacaoEscalonarX);

        //input X
        pTransformacaoEscalonarXText = new JTextArea();
        pTransformacaoEscalonarXText.setBounds(260, 340, 30, 30);
        pTransformacaoEscalonarXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoEscalonarXText);

        //descrição Y
        pTransformacaoEscalonarY = new JLabel("Y:");
        pTransformacaoEscalonarY.setBounds(300, 340, 30, 30);
        getContentPane().add(pTransformacaoEscalonarY);

        //input Y
        pTransformacaoEscalonarYText = new JTextArea();
        pTransformacaoEscalonarYText.setBounds(330, 340, 30, 30);
        pTransformacaoEscalonarYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoEscalonarYText);

        //Button
        pTransformacaoEscalonarButton = new JButton("Escalonar");
        pTransformacaoEscalonarButton.setBounds(226, 390, 140, 30);
        pTransformacaoEscalonarButton.setBackground(Color.blue);
        pTransformacaoEscalonarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pTransformacaoEscalonarButton);
        getContentPane().add(pTransformacaoEscalonar);

        ////////Painel rotacionar
        pTransformacaoRotacionar = new JPanel();
        pTransformacaoRotacionar.setBounds(36, 460, 350, 110);
        pTransformacaoRotacionar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição Ângulo
        pTransformacaoRotacionarAngulo = new JLabel("Ângulo:");
        pTransformacaoRotacionarAngulo.setBounds(46, 470, 100, 30);
        getContentPane().add(pTransformacaoRotacionarAngulo);

        //input Ângulo
        pTransformacaoRotacionarAnguloText = new JTextArea();
        pTransformacaoRotacionarAnguloText.setBounds(150, 470, 30, 30);
        pTransformacaoRotacionarAnguloText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoRotacionarAnguloText);

        //Descrição Centro de rotação
        pTransformacaoRotacionarCentroDeRotacao = new JLabel("Centro de Rotação:");
        pTransformacaoRotacionarCentroDeRotacao.setBounds(190, 470, 200, 30);
        getContentPane().add(pTransformacaoRotacionarCentroDeRotacao);

        //descrição X
        pTransformacaoRotacionarX = new JLabel("X:");
        pTransformacaoRotacionarX.setBounds(215, 520, 30, 30);
        getContentPane().add(pTransformacaoRotacionarX);

        //input X
        pTransformacaoRotacionarXText = new JTextArea();
        pTransformacaoRotacionarXText.setBounds(250, 520, 30, 30);
        pTransformacaoRotacionarXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoRotacionarXText);

        //descrição Y
        pTransformacaoRotacionarY = new JLabel("Y:");
        pTransformacaoRotacionarY.setBounds(290, 520, 30, 30);
        getContentPane().add(pTransformacaoRotacionarY);

        //input Y
        pTransformacaoRotacionarYText = new JTextArea();
        pTransformacaoRotacionarYText.setBounds(320, 520, 30, 30);
        pTransformacaoRotacionarYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoRotacionarYText);

        //Button
        pTransformacaoRotacionarButton = new JButton("Rotacionar");
        pTransformacaoRotacionarButton.setBounds(46, 520, 140, 30);
        pTransformacaoRotacionarButton.setBackground(Color.blue);
        pTransformacaoRotacionarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pTransformacaoRotacionarButton);
        getContentPane().add(pTransformacaoRotacionar);

        //////////////////////////////RADAR///////////////////////////////////////

        //Titulo
        tituloRadar = new JLabel("Radar");
        tituloRadar.setBounds(560, 12, 180, 24);
        getContentPane().add(tituloRadar);

        //Painel Radar
        pRadar = new JPanel();
        pRadar.setBounds(400, 43, 400, 400);
        pRadar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pRadar);

        ImageIcon img = new ImageIcon("Util\\proff.png");


        planoCartesiano = new JLabel();
        try{
            planoCartesiano.setIcon(new ImageIcon(".\\Util\\proff.png"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        planoCartesiano.setLocation(400,470);
        planoCartesiano.setSize(400,120);
        getContentPane().add(planoCartesiano);

        /////////////////////////FUNÇÔES DE RASTREAMENTO/////////////////////////

        //Titulo
        tituloRastreamento = new JLabel("Funções de rastreamento");
        tituloRastreamento.setBounds(76, 580, 300,24);
        getContentPane().add(tituloRastreamento);

        //Painel distancia min aeroporto
        pDistanciaMinAeroporto = new JPanel();
        pDistanciaMinAeroporto.setBounds(36, 610, 350, 130);
        pDistanciaMinAeroporto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição input
        pDistanciaMinAeroportoLabel = new JLabel("Distância mínima:");
        pDistanciaMinAeroportoLabel.setBounds(66, 580, 200, 120);
        getContentPane().add(pDistanciaMinAeroportoLabel);

        //input
        pDistanciaMinAeroportoText = new JTextField();
        pDistanciaMinAeroportoText.setBounds(270, 625, 35, 35);
        getContentPane().add(pDistanciaMinAeroportoText);

        //Button
        pDistanciaMinAeroportoButton = new JButton("Aviões próximos ao Aeroporto");
        pDistanciaMinAeroportoButton.setBounds(66, 670, 250, 41);
        pDistanciaMinAeroportoButton.setBackground(Color.red);
        pDistanciaMinAeroportoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pDistanciaMinAeroportoButton);

        getContentPane().add(pDistanciaMinAeroporto);


        /////////////////////////////Painel distancia min avioes/////////////////////////
        pDistanciaMinAvioes = new JPanel();
        pDistanciaMinAvioes.setBounds(400, 610, 190, 130);
        pDistanciaMinAvioes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição input
        pDistanciaMinAvioesLabel = new JLabel("Distância mín:");
        pDistanciaMinAvioesLabel.setBounds(400, 580, 150, 120);
        getContentPane().add(pDistanciaMinAvioesLabel);

        //input
        pDistanciaMinAvioesText = new JTextField();
        pDistanciaMinAvioesText.setBounds(550, 625, 35, 35);
        getContentPane().add(pDistanciaMinAvioesText);

        //Button
        pDistanciaMinAvioesButton = new JButton("Aviões próximos");
        pDistanciaMinAvioesButton.setBounds(410, 670, 170, 41);
        pDistanciaMinAvioesButton.setBackground(Color.red);
        pDistanciaMinAvioesButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pDistanciaMinAvioesButton);
        getContentPane().add(pDistanciaMinAvioes);

        ////////////////////////Painel tempo min em rota de colisão////////////////////////
        pTempoMinEmRotaColisao = new JPanel();
        pTempoMinEmRotaColisao.setBounds(620, 610, 180, 130);
        pTempoMinEmRotaColisao.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição input
        pTempoMinEmRotaColisaoLabel = new JLabel("Tempo mín:");
        pTempoMinEmRotaColisaoLabel.setBounds(625, 580, 150, 120);
        getContentPane().add(pTempoMinEmRotaColisaoLabel);

        //input
        pTempoMinEmRotaColisaoText = new JTextField();
        pTempoMinEmRotaColisaoText.setBounds(760, 625, 35, 35);
        getContentPane().add(pTempoMinEmRotaColisaoText);

        //Button
        pTempoMinEmRotaColisaoButton = new JButton("Em rota de colisão");
        pTempoMinEmRotaColisaoButton.setBounds(625, 670, 170, 41);
        pTempoMinEmRotaColisaoButton.setBackground(Color.red);
        pTempoMinEmRotaColisaoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pTempoMinEmRotaColisaoButton);
        getContentPane().add(pTempoMinEmRotaColisao);

        /////////////////////////////DATAGRID//////////////////////////////////////////////

        //Titulo
        tituloDataGrid = new JLabel("DataGrid");
        tituloDataGrid.setBounds(970, 12, 180, 24);
        getContentPane().add(tituloDataGrid);

        //Painel DataGrid
        pDataGrid = new JPanel();
        pDataGrid.setBounds(820, 43, 400, 300);
        pDataGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDataGrid);

        ////////////////////////////////////RELATORIO/////////////////////////////////

        //Titulo
        tituloRadarelatorio = new JLabel("Relatório");
        tituloRadarelatorio.setBounds(970, 360, 180, 24);
        getContentPane().add(tituloRadarelatorio);

        //Painel Radar
        pRadarelatorio = new JPanel();
        pRadarelatorio.setBounds(820, 390, 400, 400);
        pRadarelatorio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pRadarelatorio);
    }

}