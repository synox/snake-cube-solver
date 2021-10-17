import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.LinkedList;

@EqualsAndHashCode
@NoArgsConstructor
public class QubeModel {
    public static final char EMPTY = '^';
    LinkedList<PlacedPiece> stack = new LinkedList<>();
    char[][][] board;

    public QubeModel(int xFields, int yFields, int zFields) {
        board = new char[xFields][yFields][zFields];
        for (char[][] row : board) {
            for (char[] column : row) {
                Arrays.fill(column, EMPTY);

            }
        }
    }


    @SneakyThrows
    public QubeModel add(Piece piece, Position position, Vector exitDirection) {
        QubeModel clone = CloneUtil.clone(this);
        clone.board[position.x][position.y][position.z] = piece.getSymbol(exitDirection);
        clone.stack.add(new PlacedPiece(piece, position, exitDirection));
        return clone;
    }

    public boolean isBusyField(Position position) {
        return board[position.x][position.y][position.z] != EMPTY;
    }

    public boolean isValid(Position position) {
        return position.x >= 0 && position.y >= 0 && position.z >= 0
                && position.x < board.length && position.y < board[0].length && position.z < board[0][0].length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Y\\X  Z0     Z1     Z2\n     ");

        for (int y = 0; y < board[0].length; y++) {
            // z are groups of 3
            for (int z = 0; z < board[0][0].length; z++) {
                for (int x = 0; x < board.length; x++) {
                    sb.append(board[x][y][z]);
                }
                sb.append("    ");
            }
            sb.append("\n     ");
        }
        return sb.toString();
    }


}
