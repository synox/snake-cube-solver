import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;


public interface Piece {

    /**
     * @param sequence - is a straight piece; . is a turn.
     * @return chain of pieces
     */
    static LinkedList<Piece> createChain(String sequence) {
        LinkedList<Piece> chain = new LinkedList<>();

        Piece before = null;
        for (char c : sequence.toCharArray()) {
            Piece piece;
            if (c == '-') {
                piece = new Straight(null);
            } else {
                piece = new Turn(null);
            }

            chain.add(piece);

            if (before != null) {
                before.setNextPiece(piece);
            }
            before = piece;
        }
        return chain;
    }

    Piece getNextPiece();

    void setNextPiece(Piece piece);

    default char getSymbol(Vector exitDirection) {
        return switch (exitDirection) {
            case X_POS -> '→';
            case X_NEG -> '←';
            case Y_POS -> '↓';
            case Y_NEG -> '↑';
            case Z_POS -> 'Z';
            case Z_NEG -> 'z';
        };

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Turn implements Piece {
        Piece nextPiece;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Straight implements Piece {
        Piece nextPiece;
    }
}




