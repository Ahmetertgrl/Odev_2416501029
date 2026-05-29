package odev_2416501029;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SifreEkrani extends javax.swing.JFrame {
    static String TXT_YOLU = "C:\\P2Oyun\\TXTDosyalar\\";
    static String SIFRE_DOSYA = "C:\\P2Oyun\\TXTDosyalar\\sifre.txt";
    static String LOG_DOSYA = "C:\\P2Oyun\\TXTDosyalar\\log.txt";
    
    int yanlisSayisi = 0;
  

    
    public SifreEkrani() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSifreGiriniz = new javax.swing.JLabel();
        txtSifre = new javax.swing.JPasswordField();
        btnGiris = new javax.swing.JButton();
        lblMesaj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSifreGiriniz.setText("Şifre Giriniz");

        txtSifre.addActionListener(this::txtSifreActionPerformed);

        btnGiris.setText("Onayla");
        btnGiris.addActionListener(this::btnGirisActionPerformed);

        lblMesaj.setText("Mesaj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSifreGiriniz, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMesaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSifre, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblSifreGiriniz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGirisActionPerformed
         String girilenSifre = new String(txtSifre.getPassword());

        try {
            File sifreDosya = new File(SIFRE_DOSYA);

            if (!sifreDosya.exists() || sifreDosya.length() == 0) {
                FileWriter fw = new FileWriter(sifreDosya);
                fw.write(girilenSifre);
                fw.close();
                lblMesaj.setText("Şifre belirlendi Tekrar giriş yapın");
                  txtSifre.setText("");
                logYaz("Yeni sifre belirlendi");

            } else {
                Scanner sc = new Scanner(sifreDosya);
                String kayitliSifre = sc.nextLine();
                sc.close();

                if (girilenSifre.equals(kayitliSifre)) {
                    logYaz("Başarılı giriş");
                    new AnaEkran().setVisible(true);
                    this.dispose();
                } else {
                    yanlisSayisi++;
                    logYaz("Hatalı giriş denemesi: " + yanlisSayisi);
                    lblMesaj.setText("Hatalı şifre Kalan hak: " + (3 - yanlisSayisi));

                    if (yanlisSayisi >= 3) {
                        JOptionPane.showMessageDialog(this, "3 hatalı giriş yapıldı Program kapaniyor.");
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            lblMesaj.setText("Hata oluştu: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnGirisActionPerformed

    private void txtSifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSifreActionPerformed
       
    }//GEN-LAST:event_txtSifreActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new SifreEkrani().setVisible(true));
    }
private void logYaz(String mesaj) {
        try {
            FileWriter fw = new FileWriter(new File(LOG_DOSYA), true);
            fw.write(new java.util.Date() + " - " + mesaj + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Log hatası: " + e.getMessage());
        } 

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiris;
    private javax.swing.JLabel lblMesaj;
    private javax.swing.JLabel lblSifreGiriniz;
    private javax.swing.JPasswordField txtSifre;
    // End of variables declaration//GEN-END:variables

}

