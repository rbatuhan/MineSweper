                            MAYIN TARLASI OYUNU
OYUNU NASIL OYNANIR
- Main Sınıfında oyunu başlatın
- Oyun alanının boyutu için en az 2 olmak üzere satır ve sütun sayısı girin
- Oyun alanı için girdiğiniz değer 2 den küçük olursa hata verip yeniden veri isteyecektir, tekrar bir satır ve sütun sayısı girebilirsiniz.
- Oyun alanı içine ((Satır Sayısı * Sütun Sayısı)/4) kadar mayın rastgele yerleştirilecek.
- Oyun alanının belirlenmesi ve mayınların rastgele yerleşmesi sonrası oyun başlar.
- Oyun başladıktan sonra açılmasını istediğiniz hücrenin sizden satır ve sütun numarası istenecektir.
- Girdiğiniz satır ve sütun sayısı eğer sınır dışarısında veya daha önce girilmiş ise size hata verip yeniden veri isteyecektir.
- Tüm boş hücreleri açmanız durumunda oyunu kazanırsınız.
- Mayına basma durumunda oyun biter ve oyunu kaybedersiniz.

OYUN İÇİN

- Random ve Scanner kütüphaneleri eklenmiştir
- 
- public void startGame => metodu ile oyun başlatılmıştır.
- public void displayInitialBoard => metodu ile mayınlı hali ekrana getirilmiştir.
- public void displayBoard => metodu ile oyun alanının mevcut durumu ekrana basılmıştır.
- public boolean isValid => metodu ile Girilen Satır ve Sütun sayısının geçerli olup olmadığının kontrolü yapılmıştır.
- public void openCell => metodu ile girilen koordinatta ki hücre açılmıştır ve mayın kontrolü yapılmıştır.
- public boolean isGameOver => metodu ile oyun bitiş kontrolü yapılmıştır.
- public boolean hasWon => metodu ile oyunun kazanılıp kazanılmadığı kontrolü yapılmıştır.
- private int findMineCount => metodu ile girilen hücrenin etrafındaki mayın sayısı bulunmuştur.


DEĞERLENDİRME FORMU

Class Main

- //Değerlendirme Formu 7 = Kullanıcıdan Matris boyutu, oyun alanı için veri isteme. => 10. Satır

- //Değerlendirme Formu 9 = Kullanıcıdan işaretlenecek satır ve sütun bilgisi isteme => 38. Satır

- //Değerlendirme Formu 15 = Oyunun kazanma - kaybetme durumu => 54. Satır

Class MineSweeper

- // Değerlendirme Formu 5 = Proje MineSweeper sınıfı içerisinde tasarlandı => 3. Satır

- // Değerlendirme Formu 8 = Mayınların oyun alanına yerleştiren metot => 31. Satır

- // Değerlendirme Formu 11 = Oyun alanının mevcut durumunu gösteren metot. => 63. Satır

- //  Değerlendirme Formu 10 = Girilen Satır ve Sütun sayısının geçerli olup olmadığının kontrolü => 78. Satır

- // Değerlendirme Formu 13 = Mayına Basma kontrolü => 88. Satır

- // Değerlendirme Formu 12 => 93. Satır

- // Değerlendirme Formu 14 = Mayın olmayan tüm hücrelerin açılma durumunun kontrolü. => 119. Satır
