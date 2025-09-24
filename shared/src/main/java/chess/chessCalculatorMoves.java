package chess;

import java.util.Collection;
import java.util.HashSet;

public interface chessCalculatorMoves {
    Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos);
}

class calculateKingMoves implements chessCalculatorMoves {

    @Override
    public Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos) {
        Collection<ChessMove> moves = new HashSet<>();

        int[][] directions = {
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
        };

        ChessPiece piece = board.getPiece(pos);
        int row = pos.getRow();
        int col = pos.getColumn();

        for (int[] direction : directions) {

            int dx = row + direction[0];
            int dy = col + direction[1];

            if (ChessBoard.isValidPosition(dx, dy)) {

                ChessPosition newPosition = new ChessPosition(dx, dy);
                ChessPiece newPiece = board.getPiece(newPosition);

                if (newPiece != null && piece.getTeamColor() != newPiece.getTeamColor()) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
                if (newPiece == null) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
            }
        }

        return moves;

    }
}


class calculateQueenMoves implements chessCalculatorMoves {

    @Override
    public Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos) {
        Collection<ChessMove> moves = new HashSet<>();

        ChessPiece piece = board.getPiece(pos);

        int[][] directions = {
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
        };

        int row = pos.getRow();
        int col = pos.getColumn();

        for (int[] direction : directions) {

            int dx = row + direction[0];
            int dy = col + direction[1];

            while (ChessBoard.isValidPosition(dx, dy)) {
                ChessPosition newPosition = new ChessPosition(dx, dy);
                ChessPiece newPiece = board.getPiece(newPosition);

                if (newPiece != null && piece.getTeamColor() != newPiece.getTeamColor()) {
                    moves.add(new ChessMove(pos, newPosition, null));
                    break;
                }
                if (newPiece == null) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
                if (newPiece != null && piece.getTeamColor() == newPiece.getTeamColor()) {
                    break;
                }

                dx += direction[0];
                dy += direction[1];
            }
        }

        return moves;
    }
}

class calculateBishopMoves implements chessCalculatorMoves {

    @Override
    public Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos) {
        Collection<ChessMove> moves = new HashSet<>();

        ChessPiece piece = board.getPiece(pos);

        int[][] directions = {
                {1, 1},
                {1, -1},
                {-1, -1},
                {-1, 1},
        };

        int row = pos.getRow();
        int col = pos.getColumn();

        for (int[] direction : directions) {

            int dx = row + direction[0];
            int dy = col + direction[1];

            while (ChessBoard.isValidPosition(dx, dy)) {
                ChessPosition newPosition = new ChessPosition(dx, dy);
                ChessPiece newPiece = board.getPiece(newPosition);

                if (newPiece != null && piece.getTeamColor() != newPiece.getTeamColor()) {
                    moves.add(new ChessMove(pos, newPosition, null));
                    break;
                }
                if (newPiece == null) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
                if (newPiece != null && piece.getTeamColor() == newPiece.getTeamColor()) {
                    break;
                }

                dx += direction[0];
                dy += direction[1];
            }
        }

        return moves;
    }
}

class calculateKnightMoves implements chessCalculatorMoves {

    @Override
    public Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos) {
        Collection<ChessMove> moves = new HashSet<>();

        ChessPiece piece = board.getPiece(pos);

        int[][] directions = {
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1},
                {-2, 1},
                {-1, 2},
        };

        int row = pos.getRow();
        int col = pos.getColumn();

        for (int[] direction : directions) {

            int dx = row + direction[0];
            int dy = col + direction[1];

            if (ChessBoard.isValidPosition(dx, dy)) {
                ChessPosition newPosition = new ChessPosition(dx, dy);
                ChessPiece newPiece = board.getPiece(newPosition);

                if (newPiece != null && piece.getTeamColor() != newPiece.getTeamColor()) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
                if (newPiece == null) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
            }
        }

        return moves;
    }
}

class calculateRookMoves implements chessCalculatorMoves {

    @Override
    public Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos) {
        Collection<ChessMove> moves = new HashSet<>();

        ChessPiece piece = board.getPiece(pos);

        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
        };

        int row = pos.getRow();
        int col = pos.getColumn();

        for (int[] direction : directions) {

            int dx = row + direction[0];
            int dy = col + direction[1];

            while (ChessBoard.isValidPosition(dx, dy)) {
                ChessPosition newPosition = new ChessPosition(dx, dy);
                ChessPiece newPiece = board.getPiece(newPosition);

                if (newPiece != null && piece.getTeamColor() != newPiece.getTeamColor()) {
                    moves.add(new ChessMove(pos, newPosition, null));
                    break;
                }
                if (newPiece == null) {
                    moves.add(new ChessMove(pos, newPosition, null));
                }
                if (newPiece != null && piece.getTeamColor() == newPiece.getTeamColor()) {
                    break;
                }

                dx += direction[0];
                dy += direction[1];
            }
        }

        return moves;
    }
}

class calculatePawnMoves implements chessCalculatorMoves {

    @Override
    public Collection<ChessMove> calculatorMoves(ChessBoard board, ChessPosition pos) {
        return null;
    }
}