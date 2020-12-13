package com.sda;

public class Game {
    private static char map[][];
    private static Position heroPos;
    private static Position finishPos;

    public static void main(String[] args) {
        init();
    }


    private static void init() {
        map = FileService.loadMap();
        heroPos = findChar('H');
        finishPos = findChar('F');
    }

    private static Position findChar(char toFind){
        for (int i=0; i < map.length; i++){
            for(int j=0; j <map[i].length; j++){
                if(map[i][j]==toFind){
                    return new Position(j,i);
                }
            }
        }
        return null;
    }
}
