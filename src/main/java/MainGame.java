import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Field;
import java.util.*;

public class MainGame {
    public static void main(String[] args) {

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
        int wisdom = 0;
        int compassion = 0;
        int courage = 0;
        int heartbreak = 0;
        //eventually, want to limit number of wise owls
        int wiseOwlCount = 0;

        int golden = 0;
        int syrup = 0;
        int gBoba = 0;
        int milk = 0;

        Map<String,Integer> blompyCharacterTraits = new HashMap<>();
        blompyCharacterTraits.put("Wisdom", wisdom);
        blompyCharacterTraits.put("Compassion", compassion);
        blompyCharacterTraits.put("Courage", courage);
        blompyCharacterTraits.put("Heartbreak", heartbreak);

        Map<String, Integer> blompyLevel1Quest = new HashMap<>();
        blompyLevel1Quest.put("Golden Tea Root", golden);
        blompyLevel1Quest.put("Golden Glass Syrup", syrup);
        blompyLevel1Quest.put("Golden Boba", gBoba);
        blompyLevel1Quest.put("Milk", milk);

        //to randomly assign traits and tools
        Random rand1 = new Random();
        int maxRow = 8,minRow =1;
        int randNumRow = rand1.nextInt(maxRow - minRow + 1);
        int maxCol = 13,minCol =1;
        int randNumColumn = rand1.nextInt(maxCol - minCol + 1);

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
            wisdom = blompyCharacterTraits.get("Wisdom");
            int quest1called = 0;


        printout(board);
        String command = FieldContent.readCommandFromTheUser();
            if(FieldContent.hasWisdom(wisdom)){
                blompy1 = blompy2;
            }

        //going left
//        if (command.equals("g")) {
//            if(blompyRow == 0 && blompyColumn == 0 || blompyRow == 9 && blompyColumn == 0) {
//                System.out.println("You cannot move any further.");
//            } else if(blompyRow == 0 && blompyColumn == 14){
//                blompyColumn = blompyColumn -1;
//                board[blompyRow][blompyColumn +1] = topRightCorner;
//            } else if(blompyRow == 9 && blompyColumn == 14){
//                blompyColumn = blompyColumn -1;
//                board[blompyRow][blompyColumn +1] = botRightCorner;
//                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//            } else if(blompyRow == 8 && blompyColumn == randNumColumn){
//                blompyColumn = blompyColumn -1;
//                board[blompyRow][blompyColumn +1] = null;
//                System.out.println("An old wise owl passed along some wisdom. +1");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//            } else if(blompyRow == 0 || blompyRow == 9){
//                blompyColumn = blompyColumn -1;
//                board[blompyRow][blompyColumn +1] = borderWall;
//            } else if(blompyColumn ==0 || blompyColumn == 14) {
//                blompyColumn = blompyColumn - 1;
//                board[blompyRow][blompyColumn + 1] = verticalBorderWall;
//            } else if (blompyRow == 5 && blompyColumn == 7) {
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//                blompyCharacterTraits.put("Compassion", compassion +2);
//                blompyColumn = blompyColumn - 1;
//                board[blompyRow][blompyColumn + 1] = null;
//                System.out.println("You have gained wisdom and compassion");
//            }
//            else {
//                blompyColumn = blompyColumn - 1;
//                board[blompyRow][blompyColumn + 1] = null;
//            }
//            //going right
//        } else if (command.equals("h")) {
//            if(blompyRow == 0 && blompyColumn == 1) {
//                blompyColumn = blompyColumn +1;
//                board[blompyRow][blompyColumn -1] = borderWall;
//                System.out.println("Something bad happened! If you're wise, you lost 1!");
//                if(blompyCharacterTraits.get("Wisdom") > 0){
//                    blompyCharacterTraits.put("Wisdom", wisdom -1);
//                }
//            } else if(blompyRow == 9 && blompyColumn == 13) {
//                blompyColumn = blompyColumn +1;
//                board[blompyRow][blompyColumn -1] = borderWall;
//                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//            } else if((blompyRow == 0) && (blompyColumn == 0)){
//                blompyColumn = blompyColumn + 1;
//                board[blompyRow][blompyColumn -1] = topLeftCorner;
//            } else if((blompyRow == 9) && (blompyColumn == 0)) {
//                blompyColumn = blompyColumn + 1;
//                board[blompyRow][blompyColumn - 1] = botLeftCorner;
//            } else if(blompyColumn == 0){
//                blompyColumn = blompyColumn + 1;
//                board[blompyRow][blompyColumn -1] = verticalBorderWall;
//            } else if(blompyRow == 0 || blompyRow == 9){
//                blompyColumn = blompyColumn + 1;
//                board[blompyRow][blompyColumn -1] = borderWall;
//            } else if(blompyRow == 13 && blompyColumn == 0) {
//                blompyQuest1Tracker(blompyLevel1Quest, board, blompy1, blompy2);
//            } else if (blompyRow == 5 && blompyColumn == 7) {
//                blompyColumn = blompyColumn +1;
//                board[blompyRow][blompyColumn -1] = null;
//                System.out.println("You have gained wisdom and compassion");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//                blompyCharacterTraits.put("Courage", courage +2);
//            } else {
//                blompyColumn = blompyColumn +1;
//                board[blompyRow][blompyColumn -1] = null;
//            }
//            //going down
//        } else if(command.equals("b")){
//            if (blompyRow == 0 && blompyColumn == 0){
//                blompyRow = blompyRow + 1;
//                board[blompyRow - 1][blompyColumn] = topLeftCorner;
//            } else if(blompyRow == 0 && blompyColumn == 14) {
//                blompyRow = blompyRow +1;
//                board[blompyRow -1][blompyColumn] = topRightCorner;
//            } else if (blompyColumn == 0 || blompyColumn == 14){
//                blompyRow = blompyRow +1;
//                board[blompyRow -1][blompyColumn] = verticalBorderWall;
//            } else if(blompyRow == 13 && blompyColumn == 0) {
//                blompyQuest1Tracker(blompyLevel1Quest, board, blompy1, blompy2);
//                blompyColumn = blompyColumn - 1;
//                board[blompyRow][blompyColumn + 1] = verticalBorderWall;
//            } else if (blompyRow == 0){
//                blompyRow = blompyRow +1;
//                board[blompyRow -1][blompyColumn] = borderWall;
//            } else if(blompyRow == 9 && blompyColumn == 14) {
//                blompyRow = blompyRow +1;
//                board[blompyRow -1][blompyColumn] = botRightCorner;
//                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//            } else if(blompyRow == 5 && blompyColumn == 7) {
//                blompyRow = blompyRow + 1;
//                board[blompyRow - 1][blompyColumn] = null;
//                System.out.println("You have gained wisdom and compassion");
//                blompyCharacterTraits.put("Wisdom", wisdom + 1);
//                blompyCharacterTraits.put("Courage", courage + 2);
//            } else if(blompyRow == randNumRow && blompyColumn == 5) {
//                blompyColumn = blompyColumn - 1;
//                board[blompyRow][blompyColumn + 1] = null;
//                System.out.println("An old wise owl passed along some wisdom. +1");
//                blompyCharacterTraits.put("Wisdom", wisdom + 1);
//            } else {
//                blompyRow = blompyRow +1;
//                board[blompyRow -1][blompyColumn] = null;
//            }
//            //going up
//        } else if(command.equals("y")){
//            if(blompyRow == 0){
//                System.out.println("You cannot move any further.");
//            }  else if(blompyColumn == 0 && blompyRow == 9){
//                blompyRow = blompyRow - 1;
//                board[blompyRow +1][blompyColumn] = botLeftCorner;
//            } else if(blompyColumn == 14 && blompyRow == 9){
//                blompyRow = blompyRow - 1;
//                board[blompyRow +1][blompyColumn] = botRightCorner;
//                System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//            }  else if(board[8][0]==blompy1 || board[8][0]==blompy2) {
//                if(quest1called == 0) {
//                    quest1called++;
//                    blompyQuest1Prompt();
//                    responseBlompyQuest1(blompyLevel1Quest);
//                }
//                    blompyQuest1Tracker(blompyLevel1Quest,board, blompy1, blompy2);
//            } else if(blompyColumn == 0 || blompyColumn == 14) {
//                blompyRow = blompyRow - 1;
//                board[blompyRow + 1][blompyColumn] = verticalBorderWall;
//
//            } else if(blompyRow == 13 && blompyColumn == 0) {
//                blompyQuest1Tracker(blompyLevel1Quest, board, blompy1, blompy2);
//            } else if (blompyRow == 5 && blompyColumn == 7) {
//                blompyRow = blompyRow - 1;
//                board[blompyRow + 1][blompyColumn] = null;
//                System.out.println("You have gained wisdom and compassion");
//                blompyCharacterTraits.put("Wisdom", wisdom +1);
//                blompyCharacterTraits.put("Courage", courage +2);
//            } else {
//                blompyRow = blompyRow - 1;
//                board[blompyRow + 1][blompyColumn] = null;
//            }
            //checking character traits
//        }
        if(command.equals("q")){
            System.out.println(blompyCharacterTraits);
        } else if(command.equals("p")){
            System.out.println(blompyLevel1Quest);
        }





            Map<String, Integer> tools = new HashMap<>();
            tools.put("Keys of Light",0);





    }


    }
    public void wisdomAndCourage(int blompyRow, int blompyColumn, int wisdom, Map<String,Integer> blompyCharacterTraits, int randNumColumn,int compassion) {
        if (blompyRow == 9 && blompyColumn == 14) {
            System.out.println("You've eaten an enlightened jelly fruit and now you're wiser.");
            blompyCharacterTraits.put("Wisdom", wisdom + 1);
        } else if (blompyRow == 8 && blompyColumn == randNumColumn) {
            System.out.println("An old wise owl passed along some wisdom. +1");
            blompyCharacterTraits.put("Wisdom", wisdom + 1);
        } else if (blompyRow == 5 && blompyColumn == 7) {
            blompyCharacterTraits.put("Wisdom", wisdom + 1);
            blompyCharacterTraits.put("Compassion", compassion + 2);
            System.out.println("You have gained wisdom and compassion");
        }
    }
















        private static void blompyQuest1Prompt() {
            System.out.println("Greetings dear reader. This scroll contains the ingredients of a special");
            System.out.println("golden drink said to give it's imbiber a special power. All it will require of you is to find");
            System.out.println("the necessary ingredients to create this drink. Would you like to set off on this quest? Please enter Yes or No.");

        }
        private static String responseBlompyQuest1(Map<String, Integer> blompyLevel1Quest){
        String response = FieldContent.validQuestResponse();
        if(response.equals("yes")){
            System.out.println("You will need to gather the following: 3 Golden Tea roots, 2 Golden Glass syrup sticks, 1 silver tin of Golden Boba, " +
                    "and 1 iridescent bottle of Golden Wispy milk.");
            System.out.println(blompyLevel1Quest);
            System.out.println("Continue on your journey and find the needed ingredients.");
            return "play";
        } else if(response.equals("no")){
            System.out.println("You will not have this opportunity again dear friend. Carry on!");
        } return "no play";
    }
    private static void blompyQuest1Tracker(Map<String, Integer> blompyLevel1Quest, FieldContent[][] board, FieldContent blompy1, FieldContent blompy2)  {
                if(board[3][8] == blompy1 || board[3][8] == blompy2) {
                    int goldenTeaCount1 = 0;
                    if(goldenTeaCount1 == 0){
                        System.out.println("You have found 2 Golden Tea roots.");
                        blompyLevel1Quest.put("Golden Tea Root", blompyLevel1Quest.get("Golden Tea Root") + 2);
                        goldenTeaCount1 ++;
                    }
                } else if(board[6][2]== blompy1 || board[6][2] == blompy2){
                    int goldenTeaCount2 = 0;
                    if(goldenTeaCount2 == 0){
                        System.out.println("You have found 1 Golden Tea root.");
                        blompyLevel1Quest.put("Golden Tea Root", blompyLevel1Quest.get("Golden Tea Root" + 1));
                        goldenTeaCount2 ++;
                    }

                } else if(board[9][0]== blompy1 || board[9][0] == blompy2) {
                    int goldenGlassCount = 0;
                    if(goldenGlassCount == 0){
                        System.out.println("You have found 2 Golden Glass syrup sticks.");
                        blompyLevel1Quest.put("Golden Glass Syrup", blompyLevel1Quest.get("Golden Glass Syrup" + 2));
                    }
                }   else if(board[1][4]== blompy1 || board[1][4] == blompy2) {
                    int goldenBobaCount =0;
                    if(goldenBobaCount == 0){
                        System.out.println("You have found Golden Boba.");
                        blompyLevel1Quest.put("Golden Boba", blompyLevel1Quest.get("Golden Boba" + 1));
                    }
                } else if (board[8][4]== blompy1 || board[8][4] == blompy2) {
                    int goldenMilk = 0;
                    if(goldenMilk == 0){
                        System.out.println("You have found an iridescent bottle of delicious Golden Wispy Milk.");
                        blompyLevel1Quest.put("Milk", blompyLevel1Quest.get("Milk" + 1));
                        goldenMilk ++;
                    }
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


    public static int[] findLocation(FieldContent[][] board, FieldContent target) {//I can use this to find anything on the board
        for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {  // Loop over rows
            for (int columnNumber = 0; columnNumber < board[rowNumber].length; rowNumber++) {  // Loop over columns
                if (board[rowNumber][columnNumber] == target) {
                    return new int[] {rowNumber, columnNumber};  // Return row and column as an array
                }
            }
        }
        return null;  // Return null if not found
    }

//    Create a function, that calculates the position that blompy whats to move to
//- assign that position to a variable
//-use that variable and pass it to another function that returns whatever is on the board at that position
//create another function that determines if that move is allowed based on what is there
public int[] whereDoesBlompyWannaGo(FieldContent[][] board, FieldContent blompy1, FieldContent blompy2, String command) {
    int[] location = findLocation(board, blompy1);
    if(location == null)
        location = findLocation(board, blompy2);
    if(command.equals("y")){
        location[0] -= 1;
        return location;
    } else if(command.equals("b")){
        location[0] += 1;
        return location;
    } else if(command.equals("g")){
            location[1] -= 1;
        return location;
    } else if(command.equals("h")){
        location[1] += 1;
        return location;
    } return location;
    }

    public FieldContent leaveTopLeftCorner(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent topLeftCorner, String command) {
        if (blompyColumn == 0 && blompyRow == 0) {
            if (command.equals("b")) {
                blompyRow = blompyRow + 1;
                return board[blompyRow -1][blompyColumn] = topLeftCorner;
            } else if (command.equals("h")) {
                blompyColumn = blompyColumn + 1;
                return board[blompyRow][blompyColumn -1] = topLeftCorner;
            }
        }
        return board[blompyRow][blompyColumn];
    }
//if (blompyRow == 0 && blompyColumn == 0){
//                blompyRow = blompyRow + 1;
//                board[blompyRow - 1][blompyColumn] = topLeftCorner;

    public int[] hitTopRightCorner(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, FieldContent topRightCorner, String command) {
        int[] location = findLocation(board, blompy1);
        if(location == null)
            location = findLocation(board, blompy2);
        if(command.equals("b")){
            blompyRow = blompyRow +1;
            board[blompyRow -1][blompyColumn] = topRightCorner;
        } else if(command.equals("g")){
            blompyColumn = blompyColumn -1;
            board[blompyRow][blompyColumn +1] = topRightCorner;
        }
        return location;
    }

    public int[] hitBotRightCorner(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, FieldContent botRightCorner, String command) {
        int[] location = findLocation(board, blompy1);
        if(location == null)
            location = findLocation(board, blompy2);
        if(command.equals("b")){
            blompyRow = blompyRow +1;
            board[blompyRow -1][blompyColumn] = botRightCorner;
        } else if(command.equals("y")){
            blompyRow = blompyRow - 1;
            board[blompyRow +1][blompyColumn] = botRightCorner;
        }
        return location;
    }

    public int[] hitBotLeftCorner(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, FieldContent botLeftCorner, String command) {
        int[] location = findLocation(board, blompy1);
        if(location == null)
            location = findLocation(board, blompy2);
        if(command.equals("h")){
            blompyColumn = blompyColumn + 1;
            board[blompyRow][blompyColumn - 1] = botLeftCorner;
        } else if(command.equals("y")){
            blompyRow = blompyRow - 1;
            board[blompyRow +1][blompyColumn] = botLeftCorner;
        }
        return location;
    }
    public int[] borderWall(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, FieldContent borderWall, String command) {
        int[] location = findLocation(board, blompy1);
        if (location == null)
            location = findLocation(board, blompy2);
        if (command.equals("g")) {
            blompyColumn = blompyColumn - 1;
            board[blompyRow][blompyColumn + 1] = borderWall;
        } else if (command.equals("h")) {
            blompyColumn = blompyColumn + 1;
            board[blompyRow][blompyColumn - 1] = borderWall;
        }
        return location;
    }
        public int[] vertBorderWall(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, FieldContent verticalBorderWall, String command) {
            int[] location = findLocation(board, blompy1);
            if(location == null)
                location = findLocation(board, blompy2);
            if(command.equals("g")){
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = verticalBorderWall;
            } else if(command.equals("b")){
                blompyColumn = blompyColumn - 1;
                board[blompyRow][blompyColumn + 1] = verticalBorderWall;
            }
            return location;
    }

    public int[] emptySpace(FieldContent[][] board, int blompyColumn, int blompyRow, FieldContent blompy1, FieldContent blompy2, String command) {
        int[] location = findLocation(board, blompy1);
        if (location == null)
            location = findLocation(board, blompy2);
        if (command.equals("y")) {
            blompyRow = blompyRow - 1;
            board[blompyRow + 1][blompyColumn] = null;
        } else if (command.equals("g")) {
            blompyColumn = blompyColumn - 1;
            board[blompyRow][blompyColumn + 1] = null;
        } else if (command.equals("b")) {
            blompyRow = blompyRow + 1;
            board[blompyRow - 1][blompyColumn] = null;
        } else if (command.equals("h")) {
            blompyColumn = blompyColumn + 1;
            board[blompyRow][blompyColumn - 1] = null;
        }
        return location;
    }



}

















