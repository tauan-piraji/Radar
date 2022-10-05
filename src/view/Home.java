package view;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    private Font fonte;

    //Entrada de dados
    private JLabel tituloDados;
    private JPanel pDados;

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
    private JPanel pDistanciaMinAero;
    private JPanel pDistanciaMinAvioes;
    private JPanel pTempoMInEmRotaColisao;

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

        //Painel distancia min aeroporto
        pDistanciaMinAero = new JPanel();
        pDistanciaMinAero.setBounds(36, 610, 330, 120);
        pDistanciaMinAero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDistanciaMinAero);

        //Painel distancia min avioes
        pDistanciaMinAvioes = new JPanel();
        pDistanciaMinAvioes.setBounds(380, 610, 160, 120);
        pDistanciaMinAvioes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pDistanciaMinAvioes);

        //Painel tempo min em rota de colisão
        pTempoMInEmRotaColisao = new JPanel();
        pTempoMInEmRotaColisao.setBounds(590, 610, 160, 120);
        pTempoMInEmRotaColisao.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pTempoMInEmRotaColisao);




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