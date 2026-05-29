package odev_2416501029;

import javax.swing.ImageIcon;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;





public class AnaEkran extends javax.swing.JFrame {
static String RESIMLER_YOLU = "C:\\P2Oyun\\Resimler\\";
static String TXT_YOLU = "C:\\P2Oyun\\TXTDosyalar\\";
static String KELIMELER_DOSYA = "C:\\P2Oyun\\TXTDosyalar\\kelimeler.txt";
static String SIFRE_DOSYA = "C:\\P2Oyun\\TXTDosyalar\\sifre.txt";
static String LOG_DOSYA = "C:\\P2Oyun\\TXTDosyalar\\log.txt";
static String OYUNLAR_DOSYA = "C:\\P2Oyun\\TXTDosyalar\\oyunlar.txt";


String secilenKelime = "";
int yanlisSayisi = 0;
int sure = 0;
javax.swing.Timer sureSayaci;
java.util.ArrayList<javax.swing.JLabel> harfLabelleri = new java.util.ArrayList<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AnaEkran.class.getName());

    
    public AnaEkran() {
        initComponents();
        skorlariYukle();
        loglariYukle();
    }
private void oyunuBaslat() {
    try {
        
        java.io.File dosya = new java.io.File(KELIMELER_DOSYA);
         java.util.Scanner sc = new java.util.Scanner(dosya);
        java.util.ArrayList<String> kelimeler = new java.util.ArrayList<>();
        while (sc.hasNextLine()) {
            String k = sc.nextLine().trim();
            if (!k.isEmpty()) kelimeler.add(k.toUpperCase());
        }
        sc.close();
        
        java.util.Random rnd = new java.util.Random();
        secilenKelime = kelimeler.get(rnd.nextInt(kelimeler.size()));
        

        yanlisSayisi = 0;
        lblMesaj.setText("Oyun Başladı!");
        
       
        ImageIcon resim = new ImageIcon(RESIMLER_YOLU + "11.jpg");
        lblResim.setIcon(resim);
        
       
         pnlHarfler.removeAll();
        harfLabelleri.clear();
        pnlHarfler.setLayout(new java.awt.FlowLayout());
        
        for (int i = 0; i < secilenKelime.length(); i++) {
            javax.swing.JLabel lbl = new javax.swing.JLabel("*");
            lbl.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
             lbl.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
           lbl.setPreferredSize(new java.awt.Dimension(35, 40));
            lbl.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            harfLabelleri.add(lbl);
            pnlHarfler.add(lbl);
        }
        pnlHarfler.revalidate();
        pnlHarfler.repaint();
        
       sure = 0;
        lblSure.setText("Süre: 0");
        if (sureSayaci != null) sureSayaci.stop();
         sureSayaci = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                sure++;
                lblSure.setText("Süre: " + sure);
            }
        });
        sureSayaci.start();
        
    } catch (Exception e) {
        System.out.println("Oyun başlatma hatası: " + e.getMessage());
    }
}
private void skorlariYukle() {
     try {
        java.io.File dosya = new java.io.File(OYUNLAR_DOSYA);
        if (!dosya.exists()) return;
        
        java.util.Scanner sc = new java.util.Scanner(dosya);
        String[] kolonlar = {"Tarih", "Süre", "Sonuç"};
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(kolonlar, 0);
        
         while (sc.hasNextLine()) {
            String satir = sc.nextLine();
            if (!satir.isEmpty()) {
                String[] parcalar = satir.split(";");
                if (parcalar.length == 3) {
                    model.addRow(parcalar);
                }
            }
        }
        sc.close();
        tableSkorlar.setModel(model);
    } catch (Exception e) {
        System.out.println("Skor yükleme hatası" + e.getMessage());
    }
}

private void loglariYukle() {
    try {
        java.io.File dosya = new java.io.File(LOG_DOSYA);
        if (!dosya.exists()) return;
        
        java.util.Scanner sc = new java.util.Scanner(dosya);
        String[] kolonlar = {"Tarih Saat", "İşlem"};
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(kolonlar, 0);
        
        while (sc.hasNextLine()) {
            String satir = sc.nextLine();
            if (!satir.isEmpty()) {
                String[] parcalar = satir.split(" - ");
                if (parcalar.length == 2) {
                    model.addRow(parcalar);
                }
            }
        }
        sc.close();
        tableLoglar.setModel(model);
    } catch (Exception e) {
        System.out.println("Log yükleme hatası: " + e.getMessage());
    
       }

}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlSkorlar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSkorlar = new javax.swing.JTable();
        btnSkorTemizle = new javax.swing.JButton();
        pnlLoglar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLoglar = new javax.swing.JTable();
        btnLogTemizle = new javax.swing.JButton();
        pnlOyun = new javax.swing.JPanel();
        lblResim = new javax.swing.JLabel();
        pnlHarfler = new javax.swing.JPanel();
        lblSure = new javax.swing.JLabel();
        txtHarf = new javax.swing.JTextField();
        btnHarf = new javax.swing.JButton();
        lblMesaj = new javax.swing.JLabel();
        txtKelime = new javax.swing.JTextField();
        btnKelime = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuOyun = new javax.swing.JMenu();
        menuBasla = new javax.swing.JMenuItem();
        menuYenidenBaslat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableSkorlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableSkorlar);

        btnSkorTemizle.setText("Temizle");
        btnSkorTemizle.addActionListener(this::btnSkorTemizleActionPerformed);

        javax.swing.GroupLayout pnlSkorlarLayout = new javax.swing.GroupLayout(pnlSkorlar);
        pnlSkorlar.setLayout(pnlSkorlarLayout);
        pnlSkorlarLayout.setHorizontalGroup(
            pnlSkorlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkorlarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkorlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSkorlarLayout.createSequentialGroup()
                        .addComponent(btnSkorTemizle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSkorlarLayout.setVerticalGroup(
            pnlSkorlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkorlarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSkorTemizle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eski Skorlar", pnlSkorlar);

        tableLoglar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableLoglar);

        btnLogTemizle.setText("Temizle");
        btnLogTemizle.addActionListener(this::btnLogTemizleActionPerformed);

        javax.swing.GroupLayout pnlLoglarLayout = new javax.swing.GroupLayout(pnlLoglar);
        pnlLoglar.setLayout(pnlLoglarLayout);
        pnlLoglarLayout.setHorizontalGroup(
            pnlLoglarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoglarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoglarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoglarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnLogTemizle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlLoglarLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlLoglarLayout.setVerticalGroup(
            pnlLoglarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoglarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogTemizle)
                .addContainerGap(407, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Loglar", pnlLoglar);

        lblResim.setText("lblresim");

        javax.swing.GroupLayout pnlHarflerLayout = new javax.swing.GroupLayout(pnlHarfler);
        pnlHarfler.setLayout(pnlHarflerLayout);
        pnlHarflerLayout.setHorizontalGroup(
            pnlHarflerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlHarflerLayout.setVerticalGroup(
            pnlHarflerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lblSure.setText("Süre:0");

        txtHarf.setText("Harf Tahmini Girişi");
        txtHarf.addActionListener(this::txtHarfActionPerformed);

        btnHarf.setText("Harf Tahmin Et");
        btnHarf.addActionListener(this::btnHarfActionPerformed);

        lblMesaj.setText("Oyun Bekleniyor");

        txtKelime.setText("Kelime Tahmin Girişi");
        txtKelime.addActionListener(this::txtKelimeActionPerformed);

        btnKelime.setText("Kelime Tahmin Et");
        btnKelime.addActionListener(this::btnKelimeActionPerformed);

        javax.swing.GroupLayout pnlOyunLayout = new javax.swing.GroupLayout(pnlOyun);
        pnlOyun.setLayout(pnlOyunLayout);
        pnlOyunLayout.setHorizontalGroup(
            pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOyunLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOyunLayout.createSequentialGroup()
                        .addComponent(lblResim, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 493, Short.MAX_VALUE)
                        .addComponent(pnlHarfler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(pnlOyunLayout.createSequentialGroup()
                        .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSure)
                            .addComponent(lblMesaj))
                        .addGap(13, 13, 13)
                        .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKelime, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtHarf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHarf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKelime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))))
        );
        pnlOyunLayout.setVerticalGroup(
            pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOyunLayout.createSequentialGroup()
                .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlOyunLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlHarfler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOyunLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblResim, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSure)
                        .addComponent(txtHarf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHarf))
                .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOyunLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblMesaj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOyunLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlOyunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKelime, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKelime))))
                .addContainerGap(411, Short.MAX_VALUE))
        );

        pnlHarfler.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Oyun", pnlOyun);

        menuOyun.setText("Oyun");

        menuBasla.setText("Oyuna Başla");
        menuBasla.addActionListener(this::menuBaslaActionPerformed);
        menuOyun.add(menuBasla);

        menuYenidenBaslat.setText("Oyunu Yeniden Başlat");
        menuOyun.add(menuYenidenBaslat);

        menuBar.add(menuOyun);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBaslaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBaslaActionPerformed
        oyunuBaslat();
    }//GEN-LAST:event_menuBaslaActionPerformed

    private void txtHarfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHarfActionPerformed
        
    }//GEN-LAST:event_txtHarfActionPerformed

    private void txtKelimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKelimeActionPerformed
        
    }//GEN-LAST:event_txtKelimeActionPerformed

    private void btnHarfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHarfActionPerformed
         String harf = txtHarf.getText().trim().toUpperCase();
    
    if (harf.isEmpty() || harf.length() > 1) {
        lblMesaj.setText("Tek bir harf girin!");
        return;
    }
    
    boolean bulundu = false;
    for (int i = 0; i < secilenKelime.length(); i++) {
        if (secilenKelime.charAt(i) == harf.charAt(0)) {
            harfLabelleri.get(i).setText(harf);
            bulundu = true;
        }
    }
    
    if (bulundu) {
        lblMesaj.setText("Harf bulundu");
    } else {
        yanlisSayisi++;
        lblMesaj.setText("Harf yok Yanlış " + yanlisSayisi);
        int resimNo = 11 - yanlisSayisi;
        ImageIcon resim = new ImageIcon(RESIMLER_YOLU + resimNo + ".jpg");
        lblResim.setIcon(resim);
    }
    
    txtHarf.setText("");
    kazandiMiKontrol();
    kaybettiMiKontrol();
    }//GEN-LAST:event_btnHarfActionPerformed

    private void btnKelimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelimeActionPerformed
        {
    String kelime = txtKelime.getText().trim().toUpperCase();
    
    if (kelime.isEmpty()) {
        lblMesaj.setText("Kelime girin");
        return;
    }
    
    if (kelime.equals(secilenKelime)) {
        // Tüm harfleri göster
        for (int i = 0; i < secilenKelime.length(); i++) {
            harfLabelleri.get(i).setText(String.valueOf(secilenKelime.charAt(i)));
        }
        lblMesaj.setText("Kelimeyi buldunuz");
        kazandiMiKontrol();
    } else {
        yanlisSayisi++;
        lblMesaj.setText("Yanlış kelime" + yanlisSayisi);
        int resimNo = 11 - yanlisSayisi;
        ImageIcon resim = new ImageIcon(RESIMLER_YOLU + resimNo + ".jpg");
        lblResim.setIcon(resim);
        kaybettiMiKontrol();
    }
    
    txtKelime.setText("");
}
    }//GEN-LAST:event_btnKelimeActionPerformed

    private void btnSkorTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkorTemizleActionPerformed
       
    {
    String sifre = javax.swing.JOptionPane.showInputDialog(null, "Şifre giriniz:");
    if (sifre == null) return;
    
    try {
        java.io.File sifreDosya = new java.io.File(SIFRE_DOSYA);
        java.util.Scanner sc = new java.util.Scanner(sifreDosya);
        String kayitliSifre = sc.nextLine();
        sc.close();
        
        if (sifre.equals(kayitliSifre)) {
            // Hangi butona basıldığını anla
            if (evt.getSource() == btnSkorTemizle) {
                java.io.FileWriter fw = new java.io.FileWriter(new java.io.File(OYUNLAR_DOSYA));
                fw.write("");
                fw.close();
                skorlariYukle();
                javax.swing.JOptionPane.showMessageDialog(null, "Skorlar temizlendi");
            } else {
                java.io.FileWriter fw = new java.io.FileWriter(new java.io.File(LOG_DOSYA));
                fw.write("");
                fw.close();
                loglariYukle();
                javax.swing.JOptionPane.showMessageDialog(null, "Loglar temizlendi");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Hatalı şifre");
        }
    } catch (Exception e) {
        System.out.println("Hata: " + e.getMessage());
    }
}
    }//GEN-LAST:event_btnSkorTemizleActionPerformed

    private void btnLogTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogTemizleActionPerformed
       String sifre = javax.swing.JOptionPane.showInputDialog(null, "Şifre giriniz:");
    if (sifre == null) return;
    
    try {
        java.io.File sifreDosya = new java.io.File(SIFRE_DOSYA);
        java.util.Scanner sc = new java.util.Scanner(sifreDosya);
        String kayitliSifre = sc.nextLine();
        sc.close();
        
        if (sifre.equals(kayitliSifre)) {
            java.io.FileWriter fw = new java.io.FileWriter(new java.io.File(LOG_DOSYA));
            fw.write("");
            fw.close();
            loglariYukle();
            javax.swing.JOptionPane.showMessageDialog(null, "Loglar temizlendi");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Hatalı şifre");
        }
    } catch (Exception e) {
        System.out.println("Hata: " + e.getMessage());
    }
    }//GEN-LAST:event_btnLogTemizleActionPerformed

   private void kazandiMiKontrol() {
    boolean hepsiAcik = true;
    for (javax.swing.JLabel lbl : harfLabelleri) {
        if (lbl.getText().equals("*")) {
            hepsiAcik = false;
            break;
        }
    btnHarf.setEnabled(false);
    btnKelime.setEnabled(false);
    }
    
    if (hepsiAcik) {
        sureSayaci.stop();
        lblMesaj.setText("Kazandınız! Süre: " + sure + " saniye");
        oyunuKaydet("Kazandı");
        skorlariYukle();
        javax.swing.JOptionPane.showMessageDialog(null, "Tebrikler Kelimeyi buldunuz");
    }
}

private void kaybettiMiKontrol() {
  {
    if (yanlisSayisi >= 11) {
        sureSayaci.stop();
        lblMesaj.setText("Kaybettiniz! Kelime: " + secilenKelime);
        oyunuKaydet("Kaybetti");
        skorlariYukle();
        
          btnHarf.setEnabled(false);
        btnKelime.setEnabled(false);
        javax.swing.JOptionPane.showMessageDialog(null, "Kaybettiniz! Kelime: " + secilenKelime);
    }
}
}

private void oyunuKaydet(String sonuc) {
    try {
        java.io.FileWriter fw = new java.io.FileWriter(new java.io.File(OYUNLAR_DOSYA), true);
        String tarih = new java.util.Date().toString();
        fw.write(tarih + ";" + sure + " saniye;" + sonuc + "\n");
        fw.close();
    } catch (Exception e) {
        System.out.println("Kaydetme hatası: " + e.getMessage());
    }
}
    
public static void main(String args[]) {
       

       
         java.awt.EventQueue.invokeLater(() -> new SifreEkrani().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHarf;
    private javax.swing.JButton btnKelime;
    private javax.swing.JButton btnLogTemizle;
    private javax.swing.JButton btnSkorTemizle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMesaj;
    private javax.swing.JLabel lblResim;
    private javax.swing.JLabel lblSure;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuBasla;
    private javax.swing.JMenu menuOyun;
    private javax.swing.JMenuItem menuYenidenBaslat;
    private javax.swing.JPanel pnlHarfler;
    private javax.swing.JPanel pnlLoglar;
    private javax.swing.JPanel pnlOyun;
    private javax.swing.JPanel pnlSkorlar;
    private javax.swing.JTable tableLoglar;
    private javax.swing.JTable tableSkorlar;
    private javax.swing.JTextField txtHarf;
    private javax.swing.JTextField txtKelime;
    // End of variables declaration//GEN-END:variables
}
