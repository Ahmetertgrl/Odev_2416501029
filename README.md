# 🎯 Java Swing - Adam Asmaca Oyunu (P2Oyun)

Bu proje, Programlama II dersi dönem ödevi kapsamında Java Swing kütüphanesi kullanılarak geliştirilmiş masaüstü tabanlı bir **Adam Asmaca** oyunudur[cite: 1]. Oyun; şifreli giriş sistemi, dinamik harf alanları, anlık loglama ve geçmiş skor takibi gibi özelliklere sahiptir[cite: 1].

---

## 📁 Gerekli Klasör ve Dosya Yapısı

Programın koduna müdahale edilmeden çalışabilmesi için `C:\` dizininde aşağıdaki klasör yapısı ve dosyalar bulunmalıdır[cite: 1]:

* **Resim Klasörü:** `C:\P2Oyun\Resimler` (İçinde `1.jpg`den `11.jpg`ye kadar 11 adet aşama resmi olmalıdır)[cite: 1].
* **Metin Dosyaları Klasörü:** `C:\P2Oyun\TXTDosyalar`[cite: 1]
  * `kelimeler.txt` (En az 6 harfli 30 adet kelime)[cite: 1]
  * `sifre.txt` (Giriş şifresi)[cite: 1]
  * `log.txt` (Giriş denemelerinin kayıtları)[cite: 1]
  * `oyunlar.txt` (Oyun sonuçları ve süreleri)[cite: 1]

---

## 🚀 Öne Çıkan Özellikler

* **Güvenli Giriş:** İlk açılışta şifre belirlenir[cite: 1]. Sonraki girişlerde 3 kez hatalı şifre girilirse program kapanır[cite: 1].
* **Anlık Loglama:** Her giriş denemesi tarih ve saat bilgisiyle `log.txt` dosyasına kaydedilir[cite: 1].
* **Dinamik Oyun Alanı:** Seçilen kelimenin harf sayısı kadar dinamik `JLabel` oluşturulur ve harfler `*` olarak gizlenir[cite: 1].
* **Görsel Takip:** Her yanlış tahminde adam asmaca görselleri sırayla (11 adımda) ekrana gelir[cite: 1].
* **Skor ve Log Yönetimi:** Eski skorlar ve giriş logları `JTable` ile listelenir; şifre doğrulaması yapılarak temizlenebilir[cite: 1].

---

## 📸 Uygulama Ekran Görüntüleri

### 1. Giriş ve Şifre Kontrol Ekranı
![Giriş Ekranı](ekran_goruntuleri/giris.png)

### 2. Oyun Oynama Alanı (JTabbedPane)
![Oyun Alanı](ekran_goruntuleri/oyun.png)

### 3. Log Listesi (JTable)
![Loglar](ekran_goruntuleri/tablolar.png)

### 4. Geçmiş Skorlar (JTable)
![Skor](ekran_goruntuleri/skor.png)

---
**Geliştirici:** Ahmet  
**Öğrenci Numarası:** 2416501029  
**Üniversite:** Süleyman Demirel Üniversitesi - Bilgisayar Mühendisliği Bölümü
