import java.util.*;

public class MainGame {
    public static void main(String[] args) throws IllegalAccessException {

        FieldContent[][] board = new FieldContent[10][15];
        FieldContent blompy1 = new FieldContent("b");
        FieldContent blompy2 = new FieldContent("B");
        FieldContent topLeftCorner = new FieldContent("┏");
        FieldContent topRightCorner = new FieldContent("┓");
        FieldContent botLeftCorner = new FieldContent("┗");
        FieldContent botRightCorner = new FieldContent("┛");
        FieldContent borderWall = new FieldContent("━");
        FieldContent verticalBorderWall = new FieldContent("┃");
        FieldContent wall = new FieldContent("-");
        FieldContent door = new FieldContent("║");
        int blompyRow = 0;
        int blompyColumn = 0;
        int wisdom = 1;
        int compassion = 0;
        int courage = 0;
        int heartbreak = 0;
        Map<String,Integer> blompyCharacterTraits = new HashMap<>();
        blompyCharacterTraits.put("Wisdom", wisdom);
        blompyCharacterTraits.put("Compassion", compassion);
        blompyCharacterTraits.put("Courage", courage);
        blompyCharacterTraits.put("Heartbreak", heartbreak);

        board[0][0] = topLeftCorner;
        board[0][1] = borderWall;
        board[0][2] = borderWall;
        board[0][3] = borderWall;
        board[0][4] = borderWall;
        board[0][5] = borderWall;
        board[0][6] = borderWall;
        board[0][7] = borderWall;
        board[0][8] = borderWall;
        board[0][9] = borderWall;
        board[0][10] = borderWall;
        board[0][11] = borderWall;
        board[0][12] = borderWall;
        board[0][13] = borderWall;
        board[0][14] = topRightCorner;
        board[1][0] = verticalBorderWall;
        board[2][0] = verticalBorderWall;
        board[3][0] = verticalBorderWall;
        board[4][0] = verticalBorderWall;
        board[5][0] = verticalBorderWall;
        board[6][0] = verticalBorderWall;
        board[7][0] = verticalBorderWall;
        board[8][0] = verticalBorderWall;
        board[9][0] = botLeftCorner;

        board[1][14] = verticalBorderWall;
        board[2][14] = verticalBorderWall;
        board[3][14] = verticalBorderWall;
        board[4][14] = verticalBorderWall;
        board[5][14] = verticalBorderWall;
        board[6][14] = verticalBorderWall;
        board[7][14] = verticalBorderWall;
        board[8][14] = verticalBorderWall;
        board[9][1] = borderWall;
        board[9][2] = borderWall;
        board[9][3] = borderWall;
        board[9][4] = borderWall;
        board[9][5] = borderWall;
        board[9][6] = borderWall;
        board[9][7] = borderWall;
        board[9][8] = borderWall;
        board[9][9] = borderWall;
        board[9][10] = borderWall;
        board[9][11] = borderWall;
        board[9][12] = borderWall;
        board[9][13] = borderWall;
        board[9][14] = botRightCorner;


        while(true){
            board[blompyRow][blompyColumn] = blompy1;



        printout(board);
        String command = FieldContent.readCommandFromTheUser();
            if(FieldContent.hasWisdom(wisdom)){
                blompy1 = blompy2;
            }
        //going left
        if (command.equals("g")) {
            if(blompyRow == 0 && blompyColumn == 0 || blompyRow == 9 && blompyColumn == 0) {
                System.out.println("You cannot move any further.");
            }else if(blompyRow == 9 && blompyColumn == 0){
                blompyColumn = blompyColumn -1;
            } else if(blompyRow == 0 && blompyColumn == 14){
                blompyColumn = blompyColumn -1;
                board[blompyRow][blompyColumn +1] = topRightCorner;
            } else if(blompyRow == 9 && blompyColumn == 13){
                blompyColumn = blompyColumn -1;
                board[blompyRow][blompyColumn +1] = botRightCorner;
                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
            } else if(blompyRow == 0){
                blompyColumn = blompyColumn -1;
                board[blompyRow][blompyColumn +1] = borderWall;
            } else if(blompyColumn == 14) {
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = borderWall;
            } else if(blompyRow == 9){
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = borderWall;
            } else if (blompyRow == 5 && blompyColumn == 7) {
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
                blompyCharacterTraits.put("Compassion", compassion +2);
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = null;
                System.out.println("You have gained wisdom and compassion");
            } else {
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = null;
            }
            //going right
        } else if (command.equals("h")) {
            if(blompyRow == 0 && blompyColumn == 1) {
                System.out.println("Something bad happened!");
            } else if(blompyRow == 9 && blompyColumn == 13) {
                blompyColumn = blompyColumn +1;
                board[blompyRow][blompyColumn -1] = borderWall;
                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
            } else if((blompyRow == 0) && (blompyColumn == 0)){
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = topLeftCorner;
            } else if((blompyRow == 9) && (blompyColumn == 0)) {
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn - 1] = botLeftCorner;
            } else if(blompyColumn == 0){
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = verticalBorderWall;
            } else if(blompyRow == 0 || blompyRow == 9){
                blompyColumn = blompyColumn + 1;
                board[blompyRow][blompyColumn -1] = borderWall;
            } else if (blompyRow == 5 && blompyColumn == 7) {
                blompyColumn = blompyColumn +1;
                board[blompyRow][blompyColumn -1] = null;
                System.out.println("You have gained wisdom and compassion");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
                blompyCharacterTraits.put("Courage", courage +2);
            } else {
                blompyColumn = blompyColumn +1;
                board[blompyRow][blompyColumn -1] = null;
            }
            //going down
        } else if(command.equals("b")){
            if(blompyRow == 5 && blompyColumn == 7){
                blompyRow = blompyRow +1;
                board[blompyRow -1][blompyColumn] = null;
                System.out.println("You have gained wisdom and compassion");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
                blompyCharacterTraits.put("Courage", courage +2);
            } else if(blompyRow == 0 && blompyColumn == 0){
                blompyRow = blompyRow + 1;
                board[blompyRow - 1][blompyColumn] = topLeftCorner;
            } else if(blompyRow == 0 && blompyColumn == 14) {
                blompyRow = blompyRow +1;
                board[blompyRow -1][blompyColumn] = topRightCorner;
            } else if (blompyColumn == 0 || blompyColumn == 14){
                blompyRow = blompyRow +1;
                board[blompyRow -1][blompyColumn] = verticalBorderWall;
            } else if(blompyRow == 9 && blompyColumn == 14) {
                blompyRow = blompyRow +1;
                board[blompyRow -1][blompyColumn] = botRightCorner;
                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
            } else {
                blompyRow = blompyRow +1;
                board[blompyRow -1][blompyColumn] = null;
            }
            //going up
        } else if(command.equals("y")){
            if(blompyRow == 0){
                System.out.println("You cannot move any further.");
            }  else if(blompyColumn == 0 && blompyRow == 9){
                blompyRow = blompyRow - 1;
                board[blompyRow +1][blompyColumn] = botLeftCorner;
            } else if(blompyColumn == 14 && blompyRow == 9){
                blompyRow = blompyRow - 1;
                board[blompyRow +1][blompyColumn] = botRightCorner;
                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
            }  else if(blompyColumn == 0 || blompyColumn == 14) {
                blompyRow = blompyRow - 1;
                board[blompyRow + 1][blompyColumn] = verticalBorderWall;
            } else if (blompyRow == 5 && blompyColumn == 7) {
                blompyRow = blompyRow - 1;
                board[blompyRow + 1][blompyColumn] = null;
                System.out.println("You have gained wisdom and compassion");
                blompyCharacterTraits.put("Wisdom", blompyCharacterTraits.get("wisdom") +1);
                blompyCharacterTraits.put("Courage", courage +2);

            } else {
                blompyRow = blompyRow - 1;
                board[blompyRow + 1][blompyColumn] = null;
            }
            //checking character traits
        } else if(command.equals("q")){
            System.out.println(blompyCharacterTraits);
        }
            //why couldn't I put this in the fieldcontent class?? put wouldn't work


            Map<String, Integer> tools = new HashMap<>();
            tools.put("Keys of Light",0);


//            public int updateBlompyCharacterTraits(){
//
//            }


    }













        }
    private static void printout(FieldContent[][] board) {
        for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
            // the first index in the matrix indicates the row
            FieldContent[] row = board[rowNumber];
            for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {
                // for every 'thing' in the row we create an output
                FieldContent field = row[columnNumber];

                if(field == null){

                        System.out.print(".");

                } else {
                    System.out.print(field.getVisualRepresentation());
                }

            }
            // after each row we want a new line
            System.out.println();
        }
        System.out.println("----------------------------------");
    }



}









