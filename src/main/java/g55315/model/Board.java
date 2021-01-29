package g55315.model;

import java.util.LinkedList;

/**
 * the class board represents the gameBoard as an array of arrays of boxes
 *
 * @author Oscar Tison
 */
public class Board {

    private final int height;
    private final int width;
    private int[][] board;

    /**
     * constructor for Board that creates a board of 4x4
     */
    public Board() {
        this.height = 4;
        this.width = 4;
        this.board = new int[this.height][this.width];
        addBox();
    }

    /**
     * constructor for Board that creates a board of a certain size
     *
     * @param height the height of the board
     * @param width the width of the board
     */
    public Board(int height, int width) {
        if (width <= 0 || height != width) {
            throw new IllegalArgumentException("a board could not be made with these arguments");
        }
        this.height = height;
        this.width = width;
        this.board = new int[this.height][this.width];
    }

    /**
     * adds a random box of value 2 or 4 into the board at a random free
     * position in the board
     */
    public void addBox() {
        double random = Math.random();
        int value = random < 0.9 ? 2 : 4;
        Position pos = new Position((int) (Math.random() * width), (int) (Math.random() * height));
        while (!isPosEmpty(pos)) {
            pos = new Position((int) (Math.random() * width), (int) (Math.random() * height));
        }
        board[pos.getRow()][pos.getColumn()] = value;
    }

    /**
     * checks wether a box at a certain position in the board is free
     *
     * @param pos the position that needs to be checked
     * @return true if this position is free, if not false
     */
    public boolean isPosEmpty(Position pos) {
        if (pos == null || pos.getRow() > getHeight() || pos.getColumn() > getWidth()) {
            throw new IllegalArgumentException("Argument was null");
        }
        return board[pos.getRow()][pos.getColumn()] == 0;
    }

    /**
     * a getter for the height of the board
     *
     * @return the height of the board
     */
    public int getHeight() {
        return height;
    }

    /**
     * a getter for the width of the board
     *
     * @return the width of the board
     */
    public int getWidth() {
        return width;
    }

    /**
     * reverses the board in other words
     */
    void reverse() {
        int [][] new_board = new int[height][width];
        for (int row = 0; row < board.length; ++row) {
            System.arraycopy(board[board.length - row - 1], 0, new_board[row], 0, board[0].length);
        }
        board = new_board;
    }

    /**
     * transposes the board
     */
    void transpose() {
        int[][] new_board = new int[height][width];
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                new_board[row][col] = board[col][row];
            }
        }
        board = new_board;
    }

    /**
     * moves the squares of the board in a certain direction, this is done by
     * rotate the board in a way that the move is always up.
     *
     * @param direction the direction in which you move
     * @return the amount of points you got by this move
     */
    public int move(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Argument was null");
        }
        int points = 0;
        switch (direction) {
            case DOWN:
                reverse();
                moveUp();
                reverse();
                break;
            case LEFT:
                transpose();
                moveUp();
                transpose();
                break;
            case RIGHT:
                transpose();
                reverse();
                moveUp();
                reverse();
                transpose();
                break;
            case UP:
                moveUp();
        }
        return points;
    }

    /**
     * sets the board to another board
     *
     * @param board the new board
     */
    void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * moves the boxes of the board up, when boxes are merged points are counted
     *
     */
    void moveUp() {
        for (int col = 0; col < board.length; ++col) {
            LinkedList<Integer> thisCol = new LinkedList<>();
            for (int row = 0; row < board[0].length; ++row) {
                if (!isPosEmpty(new Position(row, col))) {
                    thisCol.add(board[row][col]);
                    board[row][col] = 0;
                }
            }
            LinkedList<Integer> mergedCol = new LinkedList<>();
            while (thisCol.size() > 1) {
                int first = thisCol.pop();
                int second = thisCol.peek();
                if (first == second) {
                    mergedCol.add(first * 2);
                    thisCol.pop();
                } else {
                    mergedCol.add(first);
                }
            }
            mergedCol.addAll(thisCol);
            for (int row = 0; row < board[0].length; ++row) {
                if (!mergedCol.isEmpty()) {
                    board[row][col] = mergedCol.pop();
                }
            }
        }
    }

    /**
     * returns the value of the box at a certain position
     *
     * @param pos the position that needs to be checked
     * @return the value of the box at this position if there is 1, otherwise 0.
     */
    public int getValue(Position pos) {

        if (pos == null) {
            throw new IllegalArgumentException("Argument was null");
        }
        if (pos.getRow() > getHeight() || pos.getColumn() > getWidth()) {
            return 0;
        }
        return board[pos.getRow()][pos.getColumn()];
    }
    

    /**
     * a defensive getter for the board
     *
     * @return a copy of the board
     */
    public int[][] getBoardCopy() {
        int [][] copy = new int[board.length][board[0].length];
        for(int row = 0; row < board.length; row++) {
            System.arraycopy(board[row], 0, copy[row], 0, board[0].length);
        }
        return copy;
    }

    /**
     * checks wether the board is full of boxes or not
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        boolean isFull = true;
        for (int[] board1 : board) {
            for (int col = 0; col < board[0].length; col++) {
                isFull = isFull && board1[col] != 0;
            }
        }
        return isFull;
    }

    /**
     * simple getter for the board
     * @return the board
     */
    public int[][] getBoard() {
        return board;
    }

    public boolean wasMoved(int[][] old_board) {
        for(int col = 0; col < width; col++) {
            for(int row = 0; row < height; row++) {
                if (board[row][col] != old_board[row][col]) {
                return true;
                }
            }
        }
        System.out.println("mouvement possible");
        return false;
    }

    public void setCaseNull(int row,int  col){
        board[row][col] = 128;
    };



}
