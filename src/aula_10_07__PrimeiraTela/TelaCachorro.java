/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula_10_07__PrimeiraTela;

import aula_07_0605_Outros.Cachorro;
import aula_09_07__Interface_ClasseAbstrata.crud.CRUDCachorro;
import aula_09_07__Interface_ClasseAbstrata.crud.Raca;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author italo
 */
public class TelaCachorro extends javax.swing.JFrame {

    private final CRUDCachorro controleCachorro = new CRUDCachorro();
    private ArrayList<Cachorro> listaCachorro;
    private DefaultListModel<String> listModel;
    private Cachorro cachorro;

    /**
     * Creates new form TelaCachorro
     */
    public TelaCachorro() {
        initComponents();
        preCadastrar();
        atualiza();

        //String mensagem = JOptionPane.showInputDialog("Digite uma mensagem");
        //JOptionPane.showMessageDialog(this, mensagem);
    }

    private boolean validarEntradaPesquisar(char caractere) {
        return jrbNome.isSelected() ? (caractere + "").matches("[a-zA-Z]")
                : (caractere + "").matches("[0-9]");
    }

    private void alterar() {
        String novoNomeDoAnimal = JOptionPane.showInputDialog("Digite um novo nome para o animal:");

        Cachorro doguinhoAlterar = listaCachorro.get(jlistAnimais.getSelectedIndex());

        if (controleCachorro.alterar(doguinhoAlterar.getId(), novoNomeDoAnimal)) {
            JOptionPane.showMessageDialog(this, "Alterado com sucesso");
            atualiza();
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível alterar o nome do doguinho");
        }
    }

    private void deletar() {
        int index = jlistAnimais.getSelectedIndex();

        Cachorro doguinhoDeletar = listaCachorro.get(index);

        if (controleCachorro.deletar(doguinhoDeletar.getId())) {
            JOptionPane.showMessageDialog(this, "O " + doguinhoDeletar.getNome() + " foi deletado com sucesso :'(");
            atualiza();
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível deletar a (o) " + doguinhoDeletar.getNome() + " :)");
        }
    }

    private void pesquisar() {
        if (jrbNome.isSelected()) {
            String nomeCachorro = jtfNomePesquisar.getText();

            listModel = new DefaultListModel<>();

            for (Cachorro c : controleCachorro.searchByContainsString(nomeCachorro)) {
                listModel.addElement(c.toString());
            }

            jlistAnimaisPesquisar.setModel(listModel);

        } else {
            int idCachorro = Integer.parseInt(jtfNomePesquisar.getText());

            listModel = new DefaultListModel<>();

            cachorro = controleCachorro.pesquisarPorId(idCachorro);

            if (cachorro == null) {
                listModel.addElement("Não existe este ID");

            } else {
                listModel.addElement(cachorro.toString());
            }

            jlistAnimaisPesquisar.setModel(listModel);
        }
    }

    private void preCadastrar() {
        controleCachorro.cadastrar(new Cachorro("Fred", 20, Raca.CARAMELO, "", 1, 'M'));
        controleCachorro.cadastrar(new Cachorro("Lulu", 21, Raca.CARAMELO, "", 2, 'M'));
        controleCachorro.cadastrar(new Cachorro("Zhyn", 22, Raca.CARAMELO, "", 3, 'M'));
        controleCachorro.cadastrar(new Cachorro("Spok", 23, Raca.CARAMELO, "", 4, 'M'));
        controleCachorro.cadastrar(new Cachorro("Bili", 24, Raca.PINSCHER, "", 5, 'M'));
        controleCachorro.cadastrar(new Cachorro("Bob", 25, Raca.PASTOR_ALEMAO, "", 6, 'M'));
        controleCachorro.cadastrar(new Cachorro("Zezé", 26, Raca.PASTOR_ALEMAO, "", 7, 'M'));
        controleCachorro.cadastrar(new Cachorro("Camargo", 27, Raca.PASTOR_ALEMAO, "", 8, 'M'));
        controleCachorro.cadastrar(new Cachorro("Betoven", 28, Raca.PASTOR_ALEMAO, "", 9, 'M'));
        controleCachorro.cadastrar(new Cachorro("Belinha", 29, Raca.PASTOR_ALEMAO, "", 0, 'f'));
        controleCachorro.cadastrar(new Cachorro("Totó", 30, Raca.PASTOR_ALEMAO, "", 8, 'M'));
        controleCachorro.cadastrar(new Cachorro("Tito", 31, Raca.PASTOR_ALEMAO, "", 7, 'M'));
        controleCachorro.cadastrar(new Cachorro("Santana", 32, Raca.PINSCHER, "", 6, 'M'));
        controleCachorro.cadastrar(new Cachorro("Carlos", 33, Raca.CHOW_CHOW, "", 5, 'M'));
        controleCachorro.cadastrar(new Cachorro("Neguinho", 34, Raca.CHIHUAHUHUAHUAHUA, "", 4, 'M'));
        controleCachorro.cadastrar(new Cachorro("Hércules", 35, Raca.CARAMELO, "", 3, 'M'));
    }

    private void cadastrar() {
        cachorro = new Cachorro(jtfNome.getText(), (int) jsId.getValue(), Raca.CARAMELO, "", 5, 'M');

        String message = controleCachorro.validarDados(cachorro);

        if (message.isEmpty()) {
            controleCachorro.cadastrar(cachorro);
            atualiza();
            limpaCampos();
        } else {
            JOptionPane.showMessageDialog(this, message, "Informação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpaCampos() {
        jtfNome.setText("");
        jsId.setValue((int) jsId.getValue() + 1);
    }

    private void atualiza() {
        atualizaLista();
        atualizaTabela();
    }

    private void atualizaLista() {
        listModel = new DefaultListModel<>();
        listaCachorro = controleCachorro.listarTodosOsAnimais();

        for (Cachorro cachorro : listaCachorro) {
            listModel.addElement(cachorro.toString());
        }

        jlistAnimais.setModel(listModel);
    }

    private void atualizaTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        tableModel.setRowCount(0);

        for (Cachorro cachorro : listaCachorro) {
            tableModel.addRow(new Object[]{cachorro.getId(), cachorro.getNome()});
        }

        jTable1.setModel(tableModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btPesquisar = new javax.swing.ButtonGroup();
        btSexo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jsId = new javax.swing.JSpinner();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistAnimais = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jrbNome = new javax.swing.JRadioButton();
        jrbId = new javax.swing.JRadioButton();
        jtfNomePesquisar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistAnimaisPesquisar = new javax.swing.JList<>();
        jToolBar1 = new javax.swing.JToolBar();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtfNome1 = new javax.swing.JTextField();
        jsId1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cachorro");

        jtfNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNome.setToolTipText("Nome do cachorro");
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome do cachorro:");

        jsId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jsId.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jsId.setToolTipText("identificador");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jlistAnimais.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlistAnimais.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlistAnimais.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jlistAnimaisFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jlistAnimaisFocusLost(evt);
            }
        });
        jlistAnimais.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistAnimaisValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlistAnimais);

        jTabbedPane1.addTab("Lista", jScrollPane1);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do cachorro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("Tabela", jScrollPane2);

        btPesquisar.add(jrbNome);
        jrbNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrbNome.setSelected(true);
        jrbNome.setText("nome");
        jrbNome.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jrbNomeStateChanged(evt);
            }
        });
        jrbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNomeActionPerformed(evt);
            }
        });

        btPesquisar.add(jrbId);
        jrbId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jrbId.setText("id");
        jrbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbIdActionPerformed(evt);
            }
        });

        jtfNomePesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtfNomePesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNomePesquisar.setToolTipText("Pressione enter para pesquisar");
        jtfNomePesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomePesquisarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomePesquisarKeyTyped(evt);
            }
        });

        jlistAnimaisPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlistAnimaisPesquisar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jlistAnimaisPesquisar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jrbNome)
                        .addGap(83, 83, 83)
                        .addComponent(jrbId)
                        .addGap(0, 220, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfNomePesquisar))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jtfNomePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNome)
                    .addComponent(jrbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCadastrar);

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAlterar);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisar.setText("Atualizar dados");
        btnPesquisar.setFocusable(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPesquisar);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Raça:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setToolTipText("raça do animal");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nome do dono:");

        jtfNome1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfNome1.setToolTipText("Nome do dono");
        jtfNome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNome1KeyTyped(evt);
            }
        });

        jsId1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jsId1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));
        jsId1.setToolTipText("Anos");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Idade:");

        btSexo.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Masculino");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sexo:");

        btSexo.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Feminino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jRadioButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                        .addComponent(jsId, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfNome1))
                    .addComponent(jsId1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtfNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jsId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Lista");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (jlistAnimais.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma linha da lista");
        } else {
            alterar();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jrbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNomeActionPerformed
        // TODO add your handling code here:
        jtfNomePesquisar.setText("");
    }//GEN-LAST:event_jrbNomeActionPerformed

    private void jtfNomePesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomePesquisarKeyTyped
        // TODO add your handling code here:
        System.out.println(evt.getKeyChar());

        if (validarEntradaPesquisar(evt.getKeyChar())) {
            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                System.out.println(evt.getKeyChar());
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_jtfNomePesquisarKeyTyped

    private void jlistAnimaisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlistAnimaisFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jlistAnimaisFocusGained

    private void jlistAnimaisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlistAnimaisFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jlistAnimaisFocusLost

    private void jlistAnimaisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistAnimaisValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jlistAnimaisValueChanged

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if (jlistAnimais.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma linha da lista");
        } else {
            deletar();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        atualiza();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jtfNomePesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomePesquisarKeyReleased
        // TODO add your handling code here:
        if (!jtfNomePesquisar.getText().isEmpty()) {
            pesquisar();
        }
    }//GEN-LAST:event_jtfNomePesquisarKeyReleased

    private void jrbNomeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jrbNomeStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jrbNomeStateChanged

    private void jrbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbIdActionPerformed
        // TODO add your handling code here:
        jtfNomePesquisar.setText("");
    }//GEN-LAST:event_jrbIdActionPerformed

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cadastrar();
        }
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jtfNome1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNome1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNome1KeyTyped

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
            java.util.logging.Logger.getLogger(TelaCachorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCachorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCachorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCachorro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCachorro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btPesquisar;
    private javax.swing.ButtonGroup btSexo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList<String> jlistAnimais;
    private javax.swing.JList<String> jlistAnimaisPesquisar;
    private javax.swing.JRadioButton jrbId;
    private javax.swing.JRadioButton jrbNome;
    private javax.swing.JSpinner jsId;
    private javax.swing.JSpinner jsId1;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNome1;
    private javax.swing.JTextField jtfNomePesquisar;
    // End of variables declaration//GEN-END:variables
}
