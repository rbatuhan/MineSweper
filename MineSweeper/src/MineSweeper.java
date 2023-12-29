import java.util.Random;

class MineSweeper { // Değerlendirme Formu 5

    private int rows;
    private int columns;
    private char[][] board;
    private boolean[][] mines;
    private boolean[][] revealedCells;
    private boolean gameInProgress;

    public MineSweeper(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new char[rows][columns];
        this.mines = new boolean[rows][columns];
        this.revealedCells = new boolean[rows][columns];
        this.gameInProgress = true;


        // Oyun alanının başlangıç durumuna getirme

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = '-';
                mines[i][j] = false;
                revealedCells[i][j] = false;
            }
        }

        // Değerlendirme Formu 8 = Mayınların oyun alanına yerleştiren metot

        Random random = new Random();
        int mineCount = (rows * columns) / 4; // Değerlendirme Formu 8 = Kurala uygun rastgele mayın yerleştirme
        for (int i = 0; i < mineCount; i++) {
            int row, column;
            do {
                row = random.nextInt(rows);
                column = random.nextInt(columns);
            } while (mines[row][column]);
            mines[row][column] = true;
        }
    }

    // Oyunu Başlatma metodu
    public void startGame() {
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz! :) ");
        System.out.println("======================================");
    }

    // Başta bütün haritayı gösteren metot
    public void displayInitialBoard() {
        System.out.println("Mayınların Konumu ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(mines[i][j] ? "* " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Değerlendirme Formu 11 = Oyun alanının mevcut durumunu gösteren metot.
    public void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (revealedCells[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("=====================");
    }

    //  Değerlendirme Formu 10 = Girilen Satır ve Sütun sayısının geçerli olup olmadığının kontrolü
    public boolean isValid(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns && !revealedCells[row][column];
    }

    // Girilen koordinatta ki hücreyi açma
    public void openCell(int row, int column) {
        if (mines[row][column]) {
            gameInProgress = false;

            // Değerlendirme Formu 13 = Mayına Basma kontrolü

            board[row][column] = '*';
        } else {
            int mineCount = findMineCount(row, column);
            board[row][column] = (char) (mineCount + '0'); // Değerlendirme Formu 12
            revealedCells[row][column] = true;

            if (mineCount == 0) {

                // Seçilen hücrenin boş olma durumunun kontrolü.

                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = column - 1; j <= column + 1; j++) {
                        if (isValid(i, j) && !mines[i][j] && !revealedCells[i][j]) {
                            openCell(i, j);
                        }
                    }
                }
            }
        }
    }

    // Oyunun Bitiş Kontrolü
    public boolean isGameOver() {
        return !gameInProgress || hasWon();
    }

    // Oyunun kazanılıp kazanılmadığının kontorlü
    public boolean hasWon() {

        // Değerlendirme Formu 14 = Mayın olmayan tüm hücrelerin açılma durumunun kontrolü.

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!mines[i][j] && !revealedCells[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Verilen hücrenin etrafındaki mayın sayısını bulan metot.
    private int findMineCount(int row, int column) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns && mines[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}