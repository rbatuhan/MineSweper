import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int rows, columns;

        //Değerlendirme Formu 7 = Kullanıcıdan Matris boyutu, oyun alanı için veri isteme.
        do {
            System.out.print("Oyun Alanının Satır Sayısını Giriniz ( En az 2 ) : ");
            rows = input.nextInt();

            System.out.print("Oyun Alanının Sütun Sayısını Giriniz ( En az 2 ) : ");
            columns = input.nextInt();

            if (rows < 2 || columns < 2) {
                System.out.println("Hatalı Giriş! Lütfen Geçerli Bir Satır Sayısı Giriniz.");
                System.out.println("Hatalı Giriş! Lütfen Geçerli Bir Sütun Sayısı Giriniz.");

            }
        } while (rows < 2 || columns < 2);


        MineSweeper mineSweeperGame = new MineSweeper(rows, columns);
        // Oyun Başında Mayınları Ekrana getirme
        mineSweeperGame.displayInitialBoard();

        // Oyunu Başlatma
        mineSweeperGame.startGame();

        while (!mineSweeperGame.isGameOver()) {
            mineSweeperGame.displayBoard();
            int row, column;

            do {
                //Değerlendirme Formu 9 = Kullanıcıdan işaretlenecek satır ve sütun bilgisi isteme

                System.out.print("Satır Giriniz : "); // Oyun içerisinde Satır isteme
                row = input.nextInt();
                System.out.print("Sütun Giriniz : "); // Oyun içerisinde Sütun isteme
                column = input.nextInt();

                // Girilen koordinatın sınır içerisinde olup olmadığını ve daha önce girilip girilmediğinin kontorlü
                if (!mineSweeperGame.isValid(row, column)) {
                    System.out.println("Geçersiz Giriş! Yeniden Giriniz : ");
                }
            } while (!mineSweeperGame.isValid(row, column));

            mineSweeperGame.openCell(row, column); // Girilen koordinattaki hücreyi açma
        }

        //Değerlendirme Formu 15 = Oyunun kazanma - kaybetme durumu
        mineSweeperGame.displayBoard();
        if (mineSweeperGame.hasWon()) {
            System.out.println("Oyunu Kazandınız !"); // Kazanma durumunda ekrana basılacak mesaj
        } else {
            System.out.println("Game Over!!"); // Kaybetme durumunda ekrana basılacak mesaj
        }
    }
}