/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLLER.FormCadastroController;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Andre
 */
public class FormCadastroView extends javax.swing.JFrame
{

    //Propriedade do Controller:
    private final FormCadastroController controller;

    /**
     * Creates new form FormCadastroView
     */
    public FormCadastroView()
    {
        initComponents();

        //Criar um controlador da view que recebe uma VIEW como parametro:
        controller = new FormCadastroController(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        LabelTituloLogin = new javax.swing.JLabel();
        LabelId = new javax.swing.JLabel();
        jTextFileldId = new javax.swing.JTextField();
        LabelUsuario = new javax.swing.JLabel();
        jTextFileldUsuario = new javax.swing.JTextField();
        LabelSenha = new javax.swing.JLabel();
        jPasswordFileldSenha = new javax.swing.JPasswordField();
        ButtonPesquisar = new javax.swing.JButton();
        ButtonExcluir = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelTituloLogin.setFont(new java.awt.Font("Courier 10 Pitch", 1, 36)); // NOI18N
        LabelTituloLogin.setForeground(new java.awt.Color(0, 153, 255));
        LabelTituloLogin.setText("Cadastro");
        jPanel1.add(LabelTituloLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 390, -1));

        LabelId.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        LabelId.setForeground(new java.awt.Color(0, 153, 255));
        LabelId.setText("ID");
        jPanel1.add(LabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jTextFileldId.setEditable(false);
        jTextFileldId.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFileldIdActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFileldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));

        LabelUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(0, 153, 255));
        LabelUsuario.setText("Usuario");
        jPanel1.add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jTextFileldUsuario.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFileldUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFileldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 400, 30));

        LabelSenha.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        LabelSenha.setForeground(new java.awt.Color(0, 153, 255));
        LabelSenha.setText("Senha");
        jPanel1.add(LabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jPasswordFileldSenha.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jPasswordFileldSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordFileldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 400, 30));

        ButtonPesquisar.setBackground(new java.awt.Color(164, 152, 152));
        ButtonPesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ButtonPesquisar.setText("Pesquisa");
        ButtonPesquisar.setActionCommand("ButtonEntrar");
        ButtonPesquisar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, 50));

        ButtonExcluir.setBackground(new java.awt.Color(164, 152, 152));
        ButtonExcluir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ButtonExcluir.setText("Excluir");
        ButtonExcluir.setActionCommand("ButtonEntrar");
        ButtonExcluir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 120, 50));

        ButtonSalvar.setBackground(new java.awt.Color(164, 152, 152));
        ButtonSalvar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ButtonSalvar.setText("Salvar");
        ButtonSalvar.setActionCommand("ButtonEntrar");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ButtonSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFileldUsuarioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFileldUsuarioActionPerformed
    {//GEN-HEADEREND:event_jTextFileldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFileldUsuarioActionPerformed

    private void jPasswordFileldSenhaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jPasswordFileldSenhaActionPerformed
    {//GEN-HEADEREND:event_jPasswordFileldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFileldSenhaActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSalvarActionPerformed
    {//GEN-HEADEREND:event_ButtonSalvarActionPerformed

        controller.salvaUsuario();

    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void jTextFileldIdActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextFileldIdActionPerformed
    {//GEN-HEADEREND:event_jTextFileldIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFileldIdActionPerformed

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonExcluirActionPerformed
    {//GEN-HEADEREND:event_ButtonExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonExcluirActionPerformed

    private void ButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonPesquisarActionPerformed
    {//GEN-HEADEREND:event_ButtonPesquisarActionPerformed
        ConsultaView telaDeConsulta = new ConsultaView();
        telaDeConsulta.setVisible(true);

    }//GEN-LAST:event_ButtonPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FormCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FormCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FormCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FormCadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new FormCadastroView().setVisible(true);
            }
        });
    }

    public JPasswordField getjPasswordFileldSenha()
    {
        return jPasswordFileldSenha;
    }

    public void setjPasswordFileldSenha(JPasswordField jPasswordFileldSenha)
    {
        this.jPasswordFileldSenha = jPasswordFileldSenha;
    }

    public JTextField getjTextFileldId()
    {
        return jTextFileldId;
    }

    public void setjTextFileldId(JTextField jTextFileldId)
    {
        this.jTextFileldId = jTextFileldId;
    }

    public JTextField getjTextFileldUsuario()
    {
        return jTextFileldUsuario;
    }

    public void setjTextFileldUsuario(JTextField jTextFileldUsuario)
    {
        this.jTextFileldUsuario = jTextFileldUsuario;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExcluir;
    private javax.swing.JButton ButtonPesquisar;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JLabel LabelId;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelTituloLogin;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFileldSenha;
    private javax.swing.JTextField jTextFileldId;
    private javax.swing.JTextField jTextFileldUsuario;
    // End of variables declaration//GEN-END:variables
}
