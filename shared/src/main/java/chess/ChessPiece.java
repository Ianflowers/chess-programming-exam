package chess;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    final private ChessGame.TeamColor pieceColor;
    final private ChessPiece.PieceType type;
    final private chessCalculatorMoves calculator;

    static final public ChessPiece.PieceType[] PROMOTION_PIECES = { PieceType.QUEEN, PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK };

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
        calculator = setCalculator(type);
    }

    private chessCalculatorMoves setCalculator(ChessPiece.PieceType type) {
        return switch (type){
            case KING -> new calculateKingMoves();
            case QUEEN -> new calculateQueenMoves();
            case BISHOP -> new calculateBishopMoves();
            case KNIGHT -> new calculateKnightMoves();
            case ROOK -> new calculateRookMoves();
            case PAWN -> new calculatePawnMoves();
        };
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType { KING, QUEEN, BISHOP, KNIGHT, ROOK, PAWN }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() { return pieceColor; }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() { return type; }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        return calculator.calculatorMoves(board, myPosition);
    }


    @Override
    public String toString() {
        return "ChessPiece{" +
                "pieceColor=" + pieceColor +
                ", type=" + type +
                ", calculator=" + calculator +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ChessPiece that = (ChessPiece) o;

        if (pieceColor != that.pieceColor) {
            return false;
        }
        if (type != that.type) {
            return false;
        }
        return Objects.equals(calculator, that.calculator);
    }

    @Override
    public int hashCode() {
        int result = pieceColor != null ? pieceColor.hashCode() : 0;
        result = 31 * result + type.hashCode();
        result = 31 * result + (calculator != null ? calculator.hashCode() : 0);
        return result;
    }
}
