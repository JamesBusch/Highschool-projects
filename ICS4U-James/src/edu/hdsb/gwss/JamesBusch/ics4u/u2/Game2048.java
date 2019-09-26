/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author jamers444
 */
public class Game2048 extends javax.swing.JFrame {

    /**
     * Creates new form Game2048
     */
    private static final int EMPTY = 0;

    private static Color[] colours = {
        new Color(255, 0, 0),
        new Color(255, 0, 255),
        new Color(100, 50, 200),
        new Color(20, 255, 100)
    };
    private JLabel[][] squares;
    private int[][] values;

    public Game2048() {
        initComponents();

        squares = new JLabel[4][4];
        values = new int[4][4];

        squares[0][0] = jLabel00;
        squares[0][1] = jLabel01;
        squares[0][2] = jLabel02;
        squares[0][3] = jLabel03;

        squares[1][0] = jLabel10;
        squares[1][1] = jLabel11;
        squares[1][2] = jLabel12;
        squares[1][3] = jLabel13;

        squares[2][0] = jLabel20;
        squares[2][1] = jLabel21;
        squares[2][2] = jLabel22;
        squares[2][3] = jLabel23;

        squares[3][0] = jLabel30;
        squares[3][1] = jLabel31;
        squares[3][2] = jLabel32;
        squares[3][3] = jLabel33;

        //clear game board
        //clearBoard();
        // TEST DATA
        values[0][0] = 0;
        values[0][3] = 2;

        // TEST DATA
        values[1][0] = 2;
        values[1][2] = 2;

        // TEST DATA
        values[2][1] = 2;
        values[2][3] = 2;

        // TEST DATA
        values[3][1] = 2;
        values[3][2] = 2;
        values[3][3] = 2;

        // UPDATE BOARD
        updateBoard();

    }

    public void clearBoard() {

        values = new int[4][4];

        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                squares[r][c].setText("");
            }
        }

        placeRandomTwo();
        placeRandomTwo();

    }

    private void placeRandomTwo() {
        boolean placed = false;

        int r, c;

        while (!placed) {
            r = (int) (Math.random() * 4);
            c = (int) (Math.random() * 4);

            if (values[r][c] == EMPTY) {
                values[r][c] = 2;
                squares[r][c].setText("2");
                placed = true;
            }

        }

    }

    public void updateBoard() {
        for (int r = 0; r < squares.length; r++) {
            for (int c = 0; c < squares[r].length; c++) {
                squares[r][c].setText(values[r][c] + "");
                squares[r][c].setBackground(colours[3]);
            }
        }
        //vaulues arrat --> upadte jLabels
    }

    public void shiftLeft() {
        for (int row = 0; row < values.length; row++) {
            for (int pass = 0; pass < values.length - 1; pass++) {
                for (int col = 1; col < squares.length; col++) {
                    if (values[row][col] != 0 && values[row][col - 1] == 0) {
                        swapCells(row, col, row, col - 1);
                    }
                }
            }
        }
    }

    public void mergeLeft() {
        for (int c = 0; c < squares.length - 1; c++) {
            for (int i = 0; i < squares.length - 1; i++) {
                for (int r = 0; r < squares[c].length; r++) {
                    if (values[r][c] == values[r][c + 1]) {
                        values[r][c] = values[r][c] * 2;
                        values[r][c + 1] = 0;
                    }
                }
            }
        }
    }

    public void shiftRight() {
        for (int row = 0; row < values.length; row++) {
            for (int pass = 0; pass < values.length - 1; pass++) {
                for (int col = values.length - 2; col >= 0; col--) {
                    if (values[row][col] != 0 && values[row][col + 1] == 0) {
                        swapCells(row, col, row, col + 1);
                    }
                }
            }
        }
    }

    public void mergeRight() {
        for (int c = values.length - 2; c > 0; c--) {
            for (int i = 0; i < squares.length - 1; i++) {
                for (int r = 0; r < squares[c].length; r++) {
                    if (values[r][c] == values[r][c + 1]) {
                        values[r][c] = values[r][c] * 2;
                        values[r][c + 1] = 0;
                    }
                }
            }
        }
    }

    public void shiftUp() {
        for (int col = 0; col < values.length; col++) {
            for (int pass = 0; pass < values.length - 1; pass++) {
                for (int row = 1; row < squares.length; row++) {
                    if (values[row][col] != 0 && values[row - 1][col] == 0) {
                        swapCells(row, col, row - 1, col);
                    }
                }
            }
        }
    }

    public void mergeUp() {
        for (int r = 0; r < squares.length - 1; r++) {
            for (int i = 0; i < squares.length - 1; i++) {
                for (int c = 0; c < squares.length; c++) {
                    if (values[r][c] == values[r + 1][c]) {
                        values[r][c] = values[r][c] * 2;
                        values[r + 1][c] = 0;
                    }
                }
            }
        }
    }

    public void shiftDown() {
        for (int col = values.length - 1; col >= 0; col--) {
            for (int pass = 0; pass < values.length - 1; pass++) {
                for (int row = values.length - 2; row >= 0; row--) {
                    if (values[row][col] != 0 && values[row + 1][col] == 0) {
                        swapCells(row, col, row + 1, col);
                    }
                }
            }
        }
    }

    public void mergeDown() {//TODO FIX THIA
        for (int r = squares.length - 2; r >= 0; r--) {
            for (int i = 0; i < squares.length - 1; i++) {
                for (int c = squares.length - 1; c >= 0; c--) {
                    if (values[r][c] == values[r + 1][c]) {
                        values[r][c] = values[r][c] * 2;
                        values[r + 1][c] = 0;
                    }
                }
            }
        }
    }

    public void swapCells(int r1, int c1, int r2, int c2) {
        int holder = values[r1][c1];
        values[r1][c1] = values[r2][c2];
        values[r2][c2] = holder;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTopPanel = new javax.swing.JPanel();
        jPanelGameBoard = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2048 my d00ds");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelTopPanel.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout jPanelTopPanelLayout = new javax.swing.GroupLayout(jPanelTopPanel);
        jPanelTopPanel.setLayout(jPanelTopPanelLayout);
        jPanelTopPanelLayout.setHorizontalGroup(
            jPanelTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanelTopPanelLayout.setVerticalGroup(
            jPanelTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );

        jPanelGameBoard.setBackground(new java.awt.Color(255, 0, 51));
        jPanelGameBoard.setPreferredSize(new java.awt.Dimension(720, 720));

        jLabel00.setBackground(new java.awt.Color(255, 255, 255));
        jLabel00.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel00.setForeground(new java.awt.Color(0, 0, 0));
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setText("1024");
        jLabel00.setOpaque(true);
        jLabel00.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel00.setSize(new java.awt.Dimension(40, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("1024");
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel10.setSize(new java.awt.Dimension(40, 40));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("1024");
        jLabel20.setOpaque(true);
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel20.setSize(new java.awt.Dimension(40, 40));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("1024");
        jLabel30.setOpaque(true);
        jLabel30.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel30.setSize(new java.awt.Dimension(40, 40));

        jLabel01.setBackground(new java.awt.Color(255, 255, 255));
        jLabel01.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel01.setForeground(new java.awt.Color(0, 0, 0));
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setText("1024");
        jLabel01.setOpaque(true);
        jLabel01.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel01.setSize(new java.awt.Dimension(40, 40));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("1024");
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel11.setSize(new java.awt.Dimension(40, 40));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("1024");
        jLabel21.setOpaque(true);
        jLabel21.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel21.setSize(new java.awt.Dimension(40, 40));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("1024");
        jLabel31.setOpaque(true);
        jLabel31.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel31.setSize(new java.awt.Dimension(40, 40));

        jLabel02.setBackground(new java.awt.Color(255, 255, 255));
        jLabel02.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel02.setForeground(new java.awt.Color(0, 0, 0));
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setText("1024");
        jLabel02.setOpaque(true);
        jLabel02.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel02.setSize(new java.awt.Dimension(40, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("1024");
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel12.setSize(new java.awt.Dimension(40, 40));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("1024");
        jLabel22.setOpaque(true);
        jLabel22.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel22.setSize(new java.awt.Dimension(40, 40));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("1024");
        jLabel32.setOpaque(true);
        jLabel32.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel32.setSize(new java.awt.Dimension(40, 40));

        jLabel03.setBackground(new java.awt.Color(255, 255, 255));
        jLabel03.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel03.setForeground(new java.awt.Color(0, 0, 0));
        jLabel03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel03.setText("1024");
        jLabel03.setOpaque(true);
        jLabel03.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel03.setSize(new java.awt.Dimension(40, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("1024");
        jLabel13.setOpaque(true);
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel13.setSize(new java.awt.Dimension(40, 40));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("1024");
        jLabel23.setOpaque(true);
        jLabel23.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel23.setSize(new java.awt.Dimension(40, 40));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("1024");
        jLabel33.setOpaque(true);
        jLabel33.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel33.setSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanelGameBoardLayout = new javax.swing.GroupLayout(jPanelGameBoard);
        jPanelGameBoard.setLayout(jPanelGameBoardLayout);
        jPanelGameBoardLayout.setHorizontalGroup(
            jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGameBoardLayout.setVerticalGroup(
            jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelGameBoardLayout.createSequentialGroup()
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addComponent(jPanelTopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        System.out.print("KEY PRESSED: ");
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                shiftUp();
                mergeUp();
                shiftUp();
                updateBoard();
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                shiftDown();
                mergeDown();
                shiftDown();
                updateBoard();
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                shiftLeft();
                mergeLeft();
                shiftLeft();
                updateBoard();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                shiftRight();
                mergeRight();
                shiftRight();
                updateBoard();
                break;
        }


    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game2048.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game2048().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanelGameBoard;
    private javax.swing.JPanel jPanelTopPanel;
    // End of variables declaration//GEN-END:variables
}
