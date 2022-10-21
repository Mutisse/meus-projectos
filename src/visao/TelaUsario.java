/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.UsuarioDao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author Klesia
 */
public class TelaUsario extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public TelaUsario() {
        initComponents();
        btn_salvar.setEnabled(false);
        pf_SenhaConfimar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    void setarCodigo() {
        UsuarioDao Dao = new UsuarioDao();
        lbl_Codigo.setText("" + Dao.GerarCodigo());
        // parte da senha 
        Random random = new Random(); // onde e gerado os cod. de funcionario
        int codgo = random.nextInt(9000);
        while (codgo < 1000) {
            codgo = random.nextInt(9000);

        }// fim while
        pf_Senha.setText("@" + codgo);
        pf_SenhaConfimar.setText("@" + codgo);
    }

    void validar() {
        if (pf_Senha.getText().length() >= 8) {
            pf_SenhaConfimar.setEnabled(true);
            if (pf_Senha.getText().equals(pf_SenhaConfimar.getText())) {
                pf_SenhaConfimar.setBackground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(null, "Senha invalida.\n As Senhas são diferentes!", "Notificacao", JOptionPane.WARNING_MESSAGE);
                pf_SenhaConfimar.setBackground(Color.RED);
            }

        } else {
            //   JOptionPane.showMessageDialog(null, "Senha inválida.\nCombine pelo menos 8 caracteres!", "Notificacao", JOptionPane.INFORMATION_MESSAGE);
            pf_Senha.setBackground(Color.RED);

        }

    }

    boolean validarEmail(String email) {
        String emailRegular = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPatt = Pattern.compile(emailRegular, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPatt.matcher(email);
        return matcher.find();

    }

    void vaidarEmail() {
        if (this.validarEmail(txt_email.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Email Digitado Inválido! Por Favor Introduza um email válido", "Atenção", JOptionPane.WARNING_MESSAGE);
            txt_email.setForeground(Color.RED);
        } else {

        }
    }

    public void limparCampos() {
        txt_Nome.setText(null);

        txt_email.setText(null);
        jTxt_biografia.setText(null);
        pf_Senha.setText(null);
        pf_SenhaConfimar.setText(null);
        lbl_Codigo.setText(null);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();

    }

    void validarCampos() {
        if (txt_Nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Campo  Nome deve Ser Preenchido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Campo Apelido Deve  Ser Preenchido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (txt_username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O username!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "e-mail nao foi preenchido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (jTxt_biografia.getText() == null) {
            JOptionPane.showMessageDialog(null, " Preenche o campo biolgrafia!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (rb_Masculino.getActionCommand().isEmpty() || rb_Masculino.getActionCommand().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foi delecionado nenum genero!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            btn_salvar.setEnabled(true);
        }

    }

    void registrar() {

        try {

            Usuario add = new Usuario();
            add.setNome(txt_Nome.getText());
            add.setNomeUsuario(txt_username.getText());
            add.setEmail(txt_email.getText());
            add.setSenha(pf_Senha.getText());
            add.setBiografia(jTxt_biografia.getText());
            //
            if (rb_Masculino.isSelected()) {
                add.setGenero(rb_Masculino.getActionCommand());
            } else if (rb_Femenino.isSelected()) {
                add.setGenero(rb_Femenino.getActionCommand());
            }

            if (ch_permitido.isSelected()) {
                add.setEstado(ch_permitido.getActionCommand());
            } else if (ch_naoPermitido.isSelected()) {
                add.setEstado(ch_naoPermitido.getActionCommand());
            }

            // vai mandaa informacao para as variaves get set
            UsuarioDao Add = new UsuarioDao();
            Add.Add(add);
            limparCampos();
            this.dispose();
            new TelaLogin().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_Nome = new javax.swing.JTextField();
        pf_SenhaConfimar = new javax.swing.JPasswordField();
        pf_Senha = new javax.swing.JPasswordField();
        rb_Masculino = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCsenha = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        rb_Femenino = new javax.swing.JRadioButton();
        lbl_Codigo = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ch_naoPermitido = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        ch_permitido = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTxt_biografia = new javax.swing.JTextArea();
        btnLimpar1 = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        txt_Nome.setBackground(new java.awt.Color(204, 204, 255));
        txt_Nome.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txt_Nome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NomeKeyTyped(evt);
            }
        });
        jPanel3.add(txt_Nome);
        txt_Nome.setBounds(10, 80, 250, 30);

        pf_SenhaConfimar.setBackground(new java.awt.Color(204, 204, 255));
        pf_SenhaConfimar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        pf_SenhaConfimar.setText("1234");
        pf_SenhaConfimar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        pf_SenhaConfimar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pf_SenhaConfimarMouseEntered(evt);
            }
        });
        pf_SenhaConfimar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_SenhaConfimarKeyTyped(evt);
            }
        });
        jPanel3.add(pf_SenhaConfimar);
        pf_SenhaConfimar.setBounds(120, 200, 90, 30);

        pf_Senha.setBackground(new java.awt.Color(204, 204, 255));
        pf_Senha.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        pf_Senha.setText("1234");
        pf_Senha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        pf_Senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pf_SenhaMouseExited(evt);
            }
        });
        pf_Senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pf_SenhaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_SenhaKeyTyped(evt);
            }
        });
        jPanel3.add(pf_Senha);
        pf_Senha.setBounds(10, 200, 90, 30);

        rb_Masculino.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rb_Masculino);
        rb_Masculino.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rb_Masculino.setText("Masculino");
        rb_Masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_MasculinoActionPerformed(evt);
            }
        });
        jPanel3.add(rb_Masculino);
        rb_Masculino.setBounds(290, 220, 90, 25);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel2.setText("Género:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(280, 180, 60, 20);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel6.setText("* biografia:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(320, 110, 70, 14);

        jCsenha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCsenha.setText("Mostrar a Senha ");
        jCsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCsenhaActionPerformed(evt);
            }
        });
        jPanel3.add(jCsenha);
        jCsenha.setBounds(10, 240, 110, 23);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("ID");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 10, 30, 30);

        rb_Femenino.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rb_Femenino);
        rb_Femenino.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rb_Femenino.setText("Feminino");
        rb_Femenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_FemeninoActionPerformed(evt);
            }
        });
        jPanel3.add(rb_Femenino);
        rb_Femenino.setBounds(290, 250, 90, 20);

        lbl_Codigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_Codigo.setForeground(new java.awt.Color(255, 0, 51));
        lbl_Codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel3.add(lbl_Codigo);
        lbl_Codigo.setBounds(50, 10, 60, 25);

        txt_email.setBackground(new java.awt.Color(204, 204, 255));
        txt_email.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txt_email.setToolTipText("O email  deve conter @ dominio.com");
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });
        jPanel3.add(txt_email);
        txt_email.setBounds(10, 140, 250, 30);

        txt_username.setBackground(new java.awt.Color(204, 204, 255));
        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_usernameKeyTyped(evt);
            }
        });
        jPanel3.add(txt_username);
        txt_username.setBounds(320, 80, 190, 30);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel5.setText("* Senha:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 180, 79, 20);

        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel3.add(jLabel15);
        jLabel15.setBounds(280, 210, 110, 65);

        ch_naoPermitido.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(ch_naoPermitido);
        ch_naoPermitido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ch_naoPermitido.setText("Inativo");
        ch_naoPermitido.setEnabled(false);
        ch_naoPermitido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_naoPermitidoActionPerformed(evt);
            }
        });
        jPanel3.add(ch_naoPermitido);
        ch_naoPermitido.setBounds(440, 250, 70, 20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 10)); // NOI18N
        jLabel3.setText("* Estado");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(420, 180, 50, 20);

        ch_permitido.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(ch_permitido);
        ch_permitido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ch_permitido.setText("Activo");
        ch_permitido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_permitidoActionPerformed(evt);
            }
        });
        jPanel3.add(ch_permitido);
        ch_permitido.setBounds(440, 220, 70, 25);

        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel3.add(jLabel9);
        jLabel9.setBounds(420, 210, 110, 65);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("* e-mail:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 120, 90, 16);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setText("* Nome completo:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 60, 130, 16);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setText("* Username:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(320, 60, 130, 16);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel11.setText("* Confirmar senha:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(120, 180, 102, 16);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTxt_biografia.setColumns(20);
        jTxt_biografia.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jTxt_biografia.setRows(5);
        jTxt_biografia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxt_biografiaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTxt_biografia);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(320, 130, 210, 50);

        btnLimpar1.setBackground(new java.awt.Color(204, 255, 255));
        btnLimpar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpar1);
        btnLimpar1.setBounds(220, 290, 130, 31);

        btn_salvar.setBackground(new java.awt.Color(204, 255, 255));
        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_salvar.setText("Registar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_salvar);
        btn_salvar.setBounds(400, 290, 130, 31);

        btnLimpar.setBackground(new java.awt.Color(204, 255, 255));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpar);
        btnLimpar.setBounds(20, 290, 130, 31);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 10, 540, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(558, 357));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NomeKeyTyped

        setarCodigo();
    }//GEN-LAST:event_txt_NomeKeyTyped

    private void pf_SenhaConfimarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaConfimarKeyTyped

    }//GEN-LAST:event_pf_SenhaConfimarKeyTyped

    private void pf_SenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaKeyTyped
        pf_Senha.setBackground(new Color(204, 204, 255));
        validar();
    }//GEN-LAST:event_pf_SenhaKeyTyped

    private void rb_MasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_MasculinoActionPerformed
        validar();
    }//GEN-LAST:event_rb_MasculinoActionPerformed

    private void jCsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCsenhaActionPerformed
        if (jCsenha.isSelected()) {
            pf_SenhaConfimar.setEchoChar((char) 0);
            pf_Senha.setEchoChar((char) 0);
        } else {
            pf_Senha.setEchoChar('•');
            pf_SenhaConfimar.setEchoChar('•');

        }
    }//GEN-LAST:event_jCsenhaActionPerformed

    private void rb_FemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_FemeninoActionPerformed
        validar();
    }//GEN-LAST:event_rb_FemeninoActionPerformed

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped
        if (txt_username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo username nao foi prenchidos!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_txt_emailKeyTyped

    private void txt_usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyTyped
        if (txt_Nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O Campo  Nome deve Ser Preenchido!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_txt_usernameKeyTyped

    private void ch_naoPermitidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_naoPermitidoActionPerformed
        validar();
    }//GEN-LAST:event_ch_naoPermitidoActionPerformed

    private void ch_permitidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_permitidoActionPerformed
        validar();
        validarCampos();
    }//GEN-LAST:event_ch_permitidoActionPerformed

    private void jTxt_biografiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxt_biografiaKeyTyped

    }//GEN-LAST:event_jTxt_biografiaKeyTyped

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        registrar();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void pf_SenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_SenhaMouseExited
        if (jTxt_biografia.getText() == null) {
            JOptionPane.showMessageDialog(null, " Preenche o campo biolgrafia!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pf_SenhaMouseExited

    private void pf_SenhaConfimarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_SenhaConfimarMouseEntered

    }//GEN-LAST:event_pf_SenhaConfimarMouseEntered

    private void pf_SenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_SenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (pf_Senha.getText().length() >= 8) {
                pf_SenhaConfimar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_pf_SenhaKeyPressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaUsario.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaUsario.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaUsario.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaUsario.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaUsario().setVisible(true);
//            }
//        });
//    }
    String comprimentoDeCampo = "8";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btn_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox ch_naoPermitido;
    private javax.swing.JCheckBox ch_permitido;
    private javax.swing.JCheckBox jCsenha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTxt_biografia;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JPasswordField pf_Senha;
    private javax.swing.JPasswordField pf_SenhaConfimar;
    private javax.swing.JRadioButton rb_Femenino;
    private javax.swing.JRadioButton rb_Masculino;
    private javax.swing.JTextField txt_Nome;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}