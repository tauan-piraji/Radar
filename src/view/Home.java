package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

    //funções de transformação
    private JLabel tituloTransformacao;
    private JPanel pTransformacaoTranslader;
    private JPanel pTransformacaoEscalonar;
    private JPanel pTransformacaoRotacionar;

    //Radar
    private JLabel tituloRadar;
    private JPanel pRadar;

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

        //ENTRADA DE DADOS

        //Titulo
        tituloDados = new JLabel("Entrada de dados");
        tituloDados.setBounds(96, 12, 180, 24);
        getContentPane().add(tituloDados);

        //Painel
        pDados = new JPanel();
        pDados.setBounds(36, 43, 330, 250);
        pDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pDadosX = new JLabel("X:");
        pDadosX.setBounds(66, 73, 30, 30);
        getContentPane().add(pDadosX);

        pDadosXText = new JTextArea();
        pDadosXText.setBounds(96, 73, 30, 30);
        pDadosXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosXText);

        pDadosY = new JLabel("Y:");
        pDadosY.setBounds(196, 73, 30, 30);
        getContentPane().add(pDadosY);

        pDadosYText = new JTextArea();
        pDadosYText.setBounds(226, 73, 30, 30);
        pDadosYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDadosYText);

        getContentPane().add(pDados);

        //FUNÇÔES DE TRANSFORMAÇÂO

        //Titulo
        tituloTransformacao = new JLabel("Funções de transformação");
        tituloTransformacao.setBounds(56, 300, 300, 24);
        getContentPane().add(tituloTransformacao);

        //Painel translader
        pTransformacaoTranslader = new JPanel();
        pTransformacaoTranslader.setBounds(36, 330, 160, 110);
        pTransformacaoTranslader.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoTranslader);

        //Painel Escalonar
        pTransformacaoEscalonar = new JPanel();
        pTransformacaoEscalonar.setBounds(206, 330, 160, 110);
        pTransformacaoEscalonar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoEscalonar);

        //Painel rotacionar
        pTransformacaoRotacionar = new JPanel();
        pTransformacaoRotacionar.setBounds(36, 460, 330, 110);
        pTransformacaoRotacionar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTransformacaoRotacionar);

        //RADAR

        //Titulo
        tituloRadar = new JLabel("Radar");
        tituloRadar.setBounds(550, 12, 180, 24);
        getContentPane().add(tituloRadar);

        //Painel Radar
        pRadar = new JPanel();
        pRadar.setBounds(380, 43, 400, 400);
        pRadar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pRadar);

        //FUNÇÔES DE RASTREAMENTO

        //Titulo
        tituloRastreamento = new JLabel("Funções de rastreamento");
        tituloRastreamento.setBounds(56, 580, 300,24);
        getContentPane().add(tituloRastreamento);

        //1 - Painel distancia min aeroporto
        pDistanciaMinAeroporto = new JPanel();
        pDistanciaMinAeroporto.setBounds(36, 610, 330, 130);
        pDistanciaMinAeroporto.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //1.1 descrição input
        pDistanciaMinAeroportoLabel = new JLabel("Distância mínima:");
        pDistanciaMinAeroportoLabel.setBounds(46, 580, 200, 120);
        getContentPane().add(pDistanciaMinAeroportoLabel);

        //2.2 - input
        pDistanciaMinAeroportoText = new JTextField();
        pDistanciaMinAeroportoText.setBounds(250, 625, 35, 35);
        getContentPane().add(pDistanciaMinAeroportoText);

        //3.3 - Button
        pDistanciaMinAeroportoButton = new JButton("Aviões próximos ao Aeroporto");
        pDistanciaMinAeroportoButton.setBounds(46, 670, 250, 41);
        pDistanciaMinAeroportoButton.setBackground(Color.red);
        pDistanciaMinAeroportoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pDistanciaMinAeroportoButton);

        getContentPane().add(pDistanciaMinAeroporto);
        //2 - Painel distancia min avioes
        pDistanciaMinAvioes = new JPanel();
        pDistanciaMinAvioes.setBounds(380, 610, 190, 130);
        pDistanciaMinAvioes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //2.1 - descrição input
        pDistanciaMinAvioesLabel = new JLabel("Distância mín:");
        pDistanciaMinAvioesLabel.setBounds(380, 580, 150, 120);
        getContentPane().add(pDistanciaMinAvioesLabel);

        //2.2 - input
        pDistanciaMinAvioesText = new JTextField();
        pDistanciaMinAvioesText.setBounds(530, 625, 35, 35);
        getContentPane().add(pDistanciaMinAvioesText);

        //3.3 - Button
        pDistanciaMinAvioesButton = new JButton("Aviões próximos");
        pDistanciaMinAvioesButton.setBounds(390, 670, 170, 41);
        pDistanciaMinAvioesButton.setBackground(Color.red);
        pDistanciaMinAvioesButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pDistanciaMinAvioesButton);
        getContentPane().add(pDistanciaMinAvioes);

        //3 - Painel tempo min em rota de colisão
        pTempoMinEmRotaColisao = new JPanel();
        pTempoMinEmRotaColisao.setBounds(590, 610, 180, 130);
        pTempoMinEmRotaColisao.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //3.1 - descrição input
        pTempoMinEmRotaColisaoLabel = new JLabel("Tempo mín:");
        pTempoMinEmRotaColisaoLabel.setBounds(595, 580, 150, 120);
        getContentPane().add(pTempoMinEmRotaColisaoLabel);

        //3.2 - input
        pTempoMinEmRotaColisaoText = new JTextField();
        pTempoMinEmRotaColisaoText.setBounds(730, 625, 35, 35);
        getContentPane().add(pTempoMinEmRotaColisaoText);

        //3.3 - Button
        pTempoMinEmRotaColisaoButton = new JButton("Em rota de colisão");
        pTempoMinEmRotaColisaoButton.setBounds(595, 670, 170, 41);
        pTempoMinEmRotaColisaoButton.setBackground(Color.red);
        pTempoMinEmRotaColisaoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(pTempoMinEmRotaColisaoButton);
        getContentPane().add(pTempoMinEmRotaColisao);

        //DATAGRID

        //Titulo
        tituloDataGrid = new JLabel("DataGrid");
        tituloDataGrid.setBounds(970, 12, 180, 24);
        getContentPane().add(tituloDataGrid);

        //Painel DataGrid
        pDataGrid = new JPanel();
        pDataGrid.setBounds(820, 43, 400, 300);
        pDataGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDataGrid);

        //RELATORIO

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