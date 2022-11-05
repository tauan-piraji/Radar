package view;

import doMain.AirPlaneTableModel;
import doMain.AirPlane;
import doMain.Radar;
import util.calculos.CordenadasRadar;
import util.calculos.FuncoesRastreamento;
import util.calculos.FuncoesTransformacao;
import util.rotacionaImg.RotacionaAviao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collection;
import java.util.Objects;

public class Home extends JFrame {

    private Font fonte;

    //Entrada de dados
    private JLabel tituloDados;
    private JPanel pDados;

    private JLabel lDadosX;
    private JTextArea tDadosXText;

    private JLabel lDadosY;
    private JTextArea tDadosYText;

    private JLabel lDadosRaio;
    private JTextArea tDadosRaioText;

    private JLabel lDadosAngulo;
    private JTextArea tDadosAnguloText;

    private JLabel lDadosVelocidade;
    private JTextArea tDadosVelocidadeText;

    private JLabel lDadosDirecao;
    private JTextArea tDadosDirecaoText;
    private JButton bDadosButton;

    //funções de transformação
    private JLabel tituloTransformacao;
    private JPanel pTransformacaoTranslader;
    private JLabel lTransformacaoTransladerX;
    private JTextArea tTransformacaoTransladerXText;
    private JLabel lTransformacaoTransladerY;
    private JTextArea tTransformacaoTransladerYText;
    private JButton bTransformacaoTransladerButton;
    private JPanel pTransformacaoEscalonar;
    private JLabel lTransformacaoEscalonarX;
    private JTextArea tTransformacaoEscalonarXText;
    private JLabel lTransformacaoEscalonarY;
    private JTextArea tTransformacaoEscalonarYText;
    private JButton bTransformacaoEscalonarButton;
    private JPanel pTransformacaoRotacionar;
    private JLabel lTransformacaoRotacionarAngulo;
    private JTextArea tTransformacaoRotacionarAnguloText;
    private JLabel lTransformacaoRotacionarCentroDeRotacao;

    private JLabel lTransformacaoRotacionarX;
    private JTextArea tTransformacaoRotacionarXText;
    private JLabel lTransformacaoRotacionarY;
    private JTextArea tTransformacaoRotacionarYText;
    private JButton bTransformacaoRotacionarButton;


    //Radar
    private JLabel tituloRadar;
    private JPanel pRadar;
    private JLabel planoCartesiano;
    //DoisPontosMedia
    private JLabel doisPontosMedia;

    //funções de Rastreamento
    private JLabel tituloRastreamento;
    private JPanel pDistanciaMinAeroporto;
    private JLabel lDistanciaMinAeroportoLabel;
    private JTextField tDistanciaMinAeroportoText;
    private JButton bDistanciaMinAeroportoButton;



    private JPanel pDistanciaMinAvioes;
    private JLabel lDistanciaMinAvioesLabel;
    private JTextField tDistanciaMinAvioesText;
    private JButton bDistanciaMinAvioesButton;
    private JPanel pTempoMinEmRotaColisao;
    private JLabel lTempoMinEmRotaColisaoLabel;
    private JTextField tTempoMinEmRotaColisaoText;
    private JButton bTempoMinEmRotaColisaoButton;

    //DataGrid
    AirPlaneTableModel airPlaneTableModel = new AirPlaneTableModel();
    private JLabel tituloDataGrid;
    private JTable tDataGrid;
    private JScrollPane sDataGridSP;

    //Radarelatorio
    private JLabel tituloRadarelatorio;
    private JScrollPane pRadarelatorio;
    private JTextArea tRelatorio;

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

        Radar radar = new Radar();

        /////////////////////////////DATAGRID//////////////////////////////////////////////

        //Titulo
        tituloDataGrid = new JLabel("DataGrid");
        tituloDataGrid.setBounds(970, 12, 180, 24);
        getContentPane().add(tituloDataGrid);

        //Painel DataGrid
        tDataGrid = new JTable(airPlaneTableModel);
        tDataGrid.setBounds(820, 43, 400, 300);
        tDataGrid.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDataGrid.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DELETE) {
                    for(int i = 0; i < airPlaneTableModel.getRowCount(); i++) {
                        if((Boolean) airPlaneTableModel.getValueAt(i, 0)) {
                            Integer id = Integer.parseInt(airPlaneTableModel.getValueAt(i, 1).toString());
                            radar.remove(id);

                            airPlaneTableModel.removeAviao(i);
                        }
                    }
                }
                radar.updateUI();
                tDataGrid.updateUI();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        tDataGrid.setModel(airPlaneTableModel);
        airPlaneTableModel.addCheckBox(0, tDataGrid);
        sDataGridSP = new JScrollPane();
        sDataGridSP.setViewportView(tDataGrid);
        sDataGridSP.setBounds(820, 43, 400, 300);
        getContentPane().add(sDataGridSP);


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
        lDadosX = new JLabel("X:");
        lDadosX.setBounds(144, 73, 30, 30);
        getContentPane().add(lDadosX);

        //input X
        tDadosXText = new JTextArea();
        tDadosXText.setBounds(170, 73, 30, 30);
        tDadosXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tDadosXText);

        //descrição Y
        lDadosY = new JLabel("Y:");
        lDadosY.setBounds(270, 73, 30, 30);
        getContentPane().add(lDadosY);

        //input Y
        tDadosYText = new JTextArea();
        tDadosYText.setBounds(310, 73, 30, 30);
        tDadosYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tDadosYText);

        //descrição Raio
        lDadosRaio = new JLabel("Raio:");
        lDadosRaio.setBounds(114, 113, 70, 30);
        getContentPane().add(lDadosRaio);

        //input Raio
        tDadosRaioText = new JTextArea();
        tDadosRaioText.setBounds(170, 113, 30, 30);
        tDadosRaioText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tDadosRaioText);

        //descrição Angulo
        lDadosAngulo = new JLabel("Ângulo:");
        lDadosAngulo.setBounds(210, 113, 100, 30);
        getContentPane().add(lDadosAngulo);

        //input Angulo
        tDadosAnguloText = new JTextArea();
        tDadosAnguloText.setBounds(310, 113, 30, 30);
        tDadosAnguloText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tDadosAnguloText);

        //descrição Velocidade
        lDadosVelocidade = new JLabel("Velocidade:");
        lDadosVelocidade.setBounds(48, 153, 130, 30);
        getContentPane().add(lDadosVelocidade);

        //input Velocidade
        tDadosVelocidadeText = new JTextArea();
        tDadosVelocidadeText.setBounds(170, 153, 30, 30);
        tDadosVelocidadeText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tDadosVelocidadeText);

        //descrição Direção
        lDadosDirecao = new JLabel("Direção:");
        lDadosDirecao.setBounds(210, 153, 100, 30);
        getContentPane().add(lDadosDirecao);

        //input Direção
        tDadosDirecaoText = new JTextArea();
        tDadosDirecaoText.setBounds(310, 153, 30, 30);
        tDadosDirecaoText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tDadosDirecaoText);

        //Button DESCRICAO DE DADOS
        bDadosButton = new JButton("Inserir");
        bDadosButton.setBounds(126, 223, 160, 40);
        bDadosButton.setBackground(Color.orange);
        bDadosButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AirPlane airPlane = new AirPlane();
                JLabel imgAviao = new JLabel();
                airPlane.setCheckBox(false);

                if(tDadosRaioText.getText().isEmpty() && tDadosAnguloText.getText().isEmpty()) {
                    imgAviao.setVisible(true);
                    imgAviao.setLocation(CordenadasRadar.cordenadaX(Integer.parseInt(tDadosXText.getText())),
                            CordenadasRadar.cordenadaY(Integer.parseInt(tDadosYText.getText())));

                    try{
                        imgAviao.setIcon(
                                new ImageIcon(
                                        RotacionaAviao.rodarImg(getClass().getResource("/util/img/aviao.png"),
                                                Integer.parseInt(tDadosDirecaoText.getText()))));
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    imgAviao.setSize(30,30);

                    airPlane.setCordX(Float.parseFloat(tDadosXText.getText()));
                    airPlane.setCordY(Float.parseFloat(tDadosYText.getText()));

                    airPlane.setRaio(CordenadasRadar.calculaRaio(Integer.parseInt(tDadosXText.getText()),
                                                                        Integer.parseInt(tDadosYText.getText())));

                    airPlane.setAngulo(CordenadasRadar.calculaAngulo(Integer.parseInt(tDadosYText.getText()),
                            CordenadasRadar.calculaRaio(Integer.parseInt(tDadosXText.getText()),
                                    Integer.parseInt(tDadosYText.getText()))));

                    airPlane.setVelocidade(Float.parseFloat(tDadosVelocidadeText.getText()));
                    airPlane.setDirecao(Float.parseFloat(tDadosDirecaoText.getText()));
                    airPlane.setImgAirplane(imgAviao);

                } else {
                    imgAviao.setVisible(true);
                    imgAviao.setLocation(CordenadasRadar.polarX(Integer.parseInt(tDadosRaioText.getText()), Integer.parseInt(tDadosAnguloText.getText())),
                            CordenadasRadar.polarY(Integer.parseInt(tDadosRaioText.getText()), Integer.parseInt(tDadosAnguloText.getText())));

                    try{
                        imgAviao.setIcon(
                                new ImageIcon(
                                        RotacionaAviao.rodarImg(getClass().getResource("/util/img/aviao.png"),
                                                Integer.parseInt(tDadosDirecaoText.getText()))));
                    }catch (Exception ex){
                        System.out.println(ex + " aqui");
                    }
                    imgAviao.setSize(30,30);

                    airPlane.setCordX(CordenadasRadar.X(Integer.parseInt(tDadosRaioText.getText()),
                            Integer.parseInt(tDadosAnguloText.getText())));

                    airPlane.setCordY(CordenadasRadar.Y(Integer.parseInt(tDadosRaioText.getText()),
                            Integer.parseInt(tDadosAnguloText.getText())));

                    airPlane.setRaio(Float.parseFloat(tDadosRaioText.getText()));
                    airPlane.setAngulo(Float.parseFloat(tDadosAnguloText.getText()));
                    airPlane.setVelocidade(Float.parseFloat(tDadosVelocidadeText.getText()));
                    airPlane.setDirecao(Float.parseFloat(tDadosDirecaoText.getText()));
                    airPlane.setImgAirplane(imgAviao);
                }

                radar.setLista_avioes(airPlane.getId(), airPlane);
                airPlaneTableModel.addAviao(airPlane);
                pRadar.add(imgAviao);
                pRadar.updateUI();
            }
        });

        getContentPane().add(bDadosButton);
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
        lTransformacaoTransladerX = new JLabel("X:");
        lTransformacaoTransladerX.setBounds(45, 340, 30, 30);
        getContentPane().add(lTransformacaoTransladerX);

        //input X
        tTransformacaoTransladerXText = new JTextArea();
        tTransformacaoTransladerXText.setBounds(80, 340, 30, 30);
        tTransformacaoTransladerXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoTransladerXText);

        //descrição Y
        lTransformacaoTransladerY = new JLabel("Y:");
        lTransformacaoTransladerY.setBounds(120, 340, 30, 30);
        getContentPane().add(lTransformacaoTransladerY);

        //input Y
        tTransformacaoTransladerYText = new JTextArea();
        tTransformacaoTransladerYText.setBounds(150, 340, 30, 30);
        tTransformacaoTransladerYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoTransladerYText);

        //Button
        bTransformacaoTransladerButton = new JButton("Translandar");
        bTransformacaoTransladerButton.setBounds(46, 390, 140, 30);
        bTransformacaoTransladerButton.setBackground(Color.blue);
        bTransformacaoTransladerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < airPlaneTableModel.getRowCount(); i++) {
                    if((Boolean) airPlaneTableModel.getValueAt(i, 0)) {

                        FuncoesTransformacao.translandar(airPlaneTableModel.getAviao(i),
                                Integer.parseInt(tTransformacaoTransladerXText.getText()),
                                Integer.parseInt(tTransformacaoTransladerYText.getText()));

                        AirPlane airplane = airPlaneTableModel.getAviao(i);

                        radar.remove(airPlaneTableModel.getAviao(i).getId());
                        airPlaneTableModel.removeAviao(i);

                        airPlaneTableModel.addAviao(airplane);
                        radar.setLista_avioes(airplane.getId(), airplane);

                    }
                }

                radar.updateUI();
                tDataGrid.setModel(airPlaneTableModel);
                tDataGrid.updateUI();
            }
        });

        getContentPane().add(bTransformacaoTransladerButton);
        getContentPane().add(pTransformacaoTranslader);

        ////////Painel Escalonar
        pTransformacaoEscalonar = new JPanel();
        pTransformacaoEscalonar.setBounds(216, 330, 170, 110);
        pTransformacaoEscalonar.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        //descrição X
        lTransformacaoEscalonarX = new JLabel("X:");
        lTransformacaoEscalonarX.setBounds(225, 340, 30, 30);
        getContentPane().add(lTransformacaoEscalonarX);

        //input X
        tTransformacaoEscalonarXText = new JTextArea();
        tTransformacaoEscalonarXText.setBounds(260, 340, 30, 30);
        tTransformacaoEscalonarXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoEscalonarXText);

        //descrição Y
        lTransformacaoEscalonarY = new JLabel("Y:");
        lTransformacaoEscalonarY.setBounds(300, 340, 30, 30);
        getContentPane().add(lTransformacaoEscalonarY);

        //input Y
        tTransformacaoEscalonarYText = new JTextArea();
        tTransformacaoEscalonarYText.setBounds(330, 340, 30, 30);
        tTransformacaoEscalonarYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoEscalonarYText);

        //Button
        bTransformacaoEscalonarButton = new JButton("Escalonar");
        bTransformacaoEscalonarButton.setBounds(226, 390, 140, 30);
        bTransformacaoEscalonarButton.setBackground(Color.blue);
        bTransformacaoEscalonarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < airPlaneTableModel.getRowCount(); i++) {
                    if((Boolean) airPlaneTableModel.getValueAt(i, 0)) {

                        FuncoesTransformacao.escalonar(airPlaneTableModel.getAviao(i),
                                Integer.parseInt(tTransformacaoEscalonarXText.getText()),
                                Integer.parseInt(tTransformacaoEscalonarYText.getText()));

                        AirPlane airplane = airPlaneTableModel.getAviao(i);

                        radar.remove(airPlaneTableModel.getAviao(i).getId());
                        airPlaneTableModel.removeAviao(i);

                        airPlaneTableModel.addAviao(airplane);
                        radar.setLista_avioes(airplane.getId(), airplane);

                    }
                }

                radar.updateUI();
                tDataGrid.setModel(airPlaneTableModel);
                tDataGrid.updateUI();
            }
        });

        getContentPane().add(bTransformacaoEscalonarButton);
        getContentPane().add(pTransformacaoEscalonar);

        ////////Painel rotacionar
        pTransformacaoRotacionar = new JPanel();
        pTransformacaoRotacionar.setBounds(36, 460, 350, 110);
        pTransformacaoRotacionar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição Ângulo
        lTransformacaoRotacionarAngulo = new JLabel("Ângulo:");
        lTransformacaoRotacionarAngulo.setBounds(46, 470, 100, 30);
        getContentPane().add(lTransformacaoRotacionarAngulo);

        //input Ângulo
        tTransformacaoRotacionarAnguloText = new JTextArea();
        tTransformacaoRotacionarAnguloText.setBounds(150, 470, 30, 30);
        tTransformacaoRotacionarAnguloText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoRotacionarAnguloText);

        //Descrição Centro de rotação
        lTransformacaoRotacionarCentroDeRotacao = new JLabel("Centro de Rotação:");
        lTransformacaoRotacionarCentroDeRotacao.setBounds(190, 470, 200, 30);
        getContentPane().add(lTransformacaoRotacionarCentroDeRotacao);

        //descrição X
        lTransformacaoRotacionarX = new JLabel("X:");
        lTransformacaoRotacionarX.setBounds(215, 520, 30, 30);
        getContentPane().add(lTransformacaoRotacionarX);

        //input X
        tTransformacaoRotacionarXText = new JTextArea();
        tTransformacaoRotacionarXText.setBounds(250, 520, 30, 30);
        tTransformacaoRotacionarXText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoRotacionarXText);

        //descrição Y
        lTransformacaoRotacionarY = new JLabel("Y:");
        lTransformacaoRotacionarY.setBounds(290, 520, 30, 30);
        getContentPane().add(lTransformacaoRotacionarY);

        //input Y
        tTransformacaoRotacionarYText = new JTextArea();
        tTransformacaoRotacionarYText.setBounds(320, 520, 30, 30);
        tTransformacaoRotacionarYText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(tTransformacaoRotacionarYText);

        //Button
        bTransformacaoRotacionarButton = new JButton("Rotacionar");
        bTransformacaoRotacionarButton.setBounds(46, 520, 140, 30);
        bTransformacaoRotacionarButton.setBackground(Color.blue);
        bTransformacaoRotacionarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < airPlaneTableModel.getRowCount(); i++) {
                    if((Boolean) airPlaneTableModel.getValueAt(i, 0)) {

                        FuncoesTransformacao.rotacionar(airPlaneTableModel.getAviao(i),
                                Integer.parseInt(tTransformacaoRotacionarXText.getText()),
                                Integer.parseInt(tTransformacaoRotacionarYText.getText()),
                                Integer.parseInt(tTransformacaoRotacionarAnguloText.getText()));

                        AirPlane airplane = airPlaneTableModel.getAviao(i);

                        radar.remove(airPlaneTableModel.getAviao(i).getId());
                        airPlaneTableModel.removeAviao(i);

                        airPlaneTableModel.addAviao(airplane);
                        radar.setLista_avioes(airplane.getId(), airplane);

                    }
                }

                radar.updateUI();
                tDataGrid.setModel(airPlaneTableModel);
                tDataGrid.updateUI();
            }
        });

        getContentPane().add(bTransformacaoRotacionarButton);
        getContentPane().add(pTransformacaoRotacionar);

        //////////////////////////////RADAR///////////////////////////////////////

        //Titulo
        tituloRadar = new JLabel("Radar");
        tituloRadar.setBounds(560, 12, 180, 24);
        getContentPane().add(tituloRadar);

        //Painel Radar
        pRadar = new JPanel();
        pRadar.setLayout(null);
        pRadar.setBounds(400, 43, 400, 400);
        pRadar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        planoCartesiano = new JLabel();
        planoCartesiano.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/util/img/planoCartesiano.png"))));
        planoCartesiano.setLocation(0,0);
        planoCartesiano.setSize(400,400);

        pRadar.add(planoCartesiano);
        pRadar.updateUI();
        getContentPane().add(pRadar);

        ////////////////////DOIS PONTOS NA MEDIA/////////////////////////////////////////

        doisPontosMedia = new JLabel();
        try{
            doisPontosMedia.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/util/img/proff.png"))));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        doisPontosMedia.setLocation(410,460);
        doisPontosMedia.setSize(400,120);
        getContentPane().add(doisPontosMedia);

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
        lDistanciaMinAeroportoLabel = new JLabel("Distância mínima:");
        lDistanciaMinAeroportoLabel.setBounds(66, 580, 200, 120);
        getContentPane().add(lDistanciaMinAeroportoLabel);

        //input
        tDistanciaMinAeroportoText = new JTextField();
        tDistanciaMinAeroportoText.setBounds(270, 625, 35, 35);
        getContentPane().add(tDistanciaMinAeroportoText);

        //Button
        bDistanciaMinAeroportoButton = new JButton("Aviões próximos ao Aeroporto");
        bDistanciaMinAeroportoButton.setBounds(66, 670, 250, 41);
        bDistanciaMinAeroportoButton.setBackground(Color.red);
        bDistanciaMinAeroportoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (AirPlane airPlane : FuncoesRastreamento.distanciaBase(radar.getLista_avioes(),
                        Float.parseFloat(tDistanciaMinAeroportoText.getText()))) {

                    tRelatorio.setText(tRelatorio.getText() + "Avião " + airPlane.getId() + " está próximo da base \n");
                }
            }
        });

        getContentPane().add(bDistanciaMinAeroportoButton);

        getContentPane().add(pDistanciaMinAeroporto);


        /////////////////////////////Painel distancia min avioes/////////////////////////
        pDistanciaMinAvioes = new JPanel();
        pDistanciaMinAvioes.setBounds(400, 610, 190, 130);
        pDistanciaMinAvioes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição input
        lDistanciaMinAvioesLabel = new JLabel("Distância mín:");
        lDistanciaMinAvioesLabel.setBounds(400, 580, 150, 120);
        getContentPane().add(lDistanciaMinAvioesLabel);

        //input
        tDistanciaMinAvioesText = new JTextField();
        tDistanciaMinAvioesText.setBounds(550, 625, 35, 35);
        getContentPane().add(tDistanciaMinAvioesText);

        //Button
        bDistanciaMinAvioesButton = new JButton("Aviões próximos");
        bDistanciaMinAvioesButton.setBounds(410, 670, 170, 41);
        bDistanciaMinAvioesButton.setBackground(Color.red);
        bDistanciaMinAvioesButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String collisionRisk : FuncoesRastreamento.distanciaEntreAvioes(radar.getLista_avioes(),
                        Float.parseFloat(tDistanciaMinAvioesText.getText()))) {

                    tRelatorio.setText(tRelatorio.getText() + collisionRisk + "\n");
                }
            }
        });

        getContentPane().add(bDistanciaMinAvioesButton);
        getContentPane().add(pDistanciaMinAvioes);

        ////////////////////////Painel tempo min em rota de colisão////////////////////////
        pTempoMinEmRotaColisao = new JPanel();
        pTempoMinEmRotaColisao.setBounds(620, 610, 180, 130);
        pTempoMinEmRotaColisao.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //descrição input
        lTempoMinEmRotaColisaoLabel = new JLabel("Tempo mín:");
        lTempoMinEmRotaColisaoLabel.setBounds(625, 580, 150, 120);
        getContentPane().add(lTempoMinEmRotaColisaoLabel);

        //input
        tTempoMinEmRotaColisaoText = new JTextField();
        tTempoMinEmRotaColisaoText.setBounds(760, 625, 35, 35);
        getContentPane().add(tTempoMinEmRotaColisaoText);

        //Button
        bTempoMinEmRotaColisaoButton = new JButton("Em rota de colisão");
        bTempoMinEmRotaColisaoButton.setBounds(625, 670, 170, 41);
        bTempoMinEmRotaColisaoButton.setBackground(Color.red);
        bTempoMinEmRotaColisaoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        getContentPane().add(bTempoMinEmRotaColisaoButton);
        getContentPane().add(pTempoMinEmRotaColisao);


        ////////////////////////////////////RELATORIO/////////////////////////////////

        //Titulo
        tituloRadarelatorio = new JLabel("Relatório");
        tituloRadarelatorio.setBounds(970, 360, 180, 24);
        getContentPane().add(tituloRadarelatorio);

        //Text relatorio
        tRelatorio = new JTextArea();
        tRelatorio.setBounds(820, 390, 400, 400);
        tRelatorio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tRelatorio.setEditable(false);

        //Painel Radar
        pRadarelatorio = new JScrollPane(tRelatorio);
        pRadarelatorio.setBounds(820, 390, 400, 400);
        pRadarelatorio.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        getContentPane().add(pRadarelatorio);
    }

}