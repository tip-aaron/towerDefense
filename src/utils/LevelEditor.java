package utils;

public class LevelEditor {

    public static int[][] getLevelData() {
        int[][] levelData = new int[20][20];

        for (int i = 0; i < levelData.length; i++) {
            for (int j = 0; j < levelData[i].length; j++) {
                levelData[i][j] = 1;
            }
        }

        return levelData;
    }

}
