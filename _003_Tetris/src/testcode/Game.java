package testcode;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Game extends Object {
    public static final int STATE_GETREADY = 1;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PAUSED = 3;
    public static final int STATE_GAMEOVER = 4;


    private final PropertyChangeSupport PCS = new PropertyChangeSupport(this);

    private final SquareBoard board;

    private final SquareBoard previewBoard = new SquareBoard(5, 5);

    private Figure[] figures = {
            new Figure(Figure.SQUARE_FIGURE),
            new Figure(Figure.LINE_FIGURE),
            new Figure(Figure.S_FIGURE),
            new Figure(Figure.Z_FIGURE),
            new Figure(Figure.RIGHT_ANGLE_FIGURE),
            new Figure(Figure.LEFT_ANGLE_FIGURE),
            new Figure(Figure.TRIANGLE_FIGURE)
    };

    private final GameThread thread;

    private int level = 1;

    private int score = 0;

    private Figure figure = null;

    private Figure nextFigure = null;

    private int nextRotation = 0;

    private boolean preview = true;

    private boolean moveLock = false;

    private int state;

    //화면 크기 설정
    public Game() {
        this(40, 60);
    }

    //화면 크기
    public Game(int width, int height) {
        new startendPanel();
        board = new SquareBoard(width, height);
        thread = new GameThread();
        handleGetReady();
        board.getComponent().setFocusable(true);
        board.getComponent().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                handleKeyEvent(e);
            }
        });

    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        PCS.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        PCS.removePropertyChangeListener(l);
    }

    public int getState() {
        return state;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getRemovedLines() {
        return board.getRemovedLines();
    }

    public Component getSquareBoardComponent() {
        return board.getComponent();
    }

    public Component getPreviewBoardComponent() {
        return previewBoard.getComponent();
    }
    //초기화
    public void init() {
        if (state == STATE_GAMEOVER) {
            handleGetReady();
        }
    }
    //핸들러 시작하기
    public void start() {
        handleStart();
    }

    public void pause() {
        if (state == STATE_PLAYING) {
            handlePause();
        }
    }

    public void resume() {
        if (state == STATE_PAUSED) {
            handleResume();
        }
    }

    public void terminate() {
        handleGameOver();
    }

    private void handleStart() {

        level = 1;
        score = 0;
        figure = null;
        //다음 방향으로 넘기기(랜덤으로)
        nextFigure = randomFigure();
        nextFigure.rotateRandom();
        nextRotation = nextFigure.getRotation();

        state = STATE_PLAYING;
        board.setMessage(null);
        board.clear();
        previewBoard.clear();
        handleLevelModification();
        handleScoreModification();

        PCS.firePropertyChange("state", -1, STATE_PLAYING);
        thread.reset();
    }

    //게임 오버 되었을 때
    private void handleGameOver() {

        thread.setPaused(true);

        if (figure != null) {
            figure.detach();
        }
        figure = null;
        if (nextFigure != null) {
            nextFigure.detach();
        }
        nextFigure = null;

        state = STATE_GAMEOVER;
        board.setMessage("Game Over");
        PCS.firePropertyChange("state", -1, STATE_GAMEOVER);
    }
    //게임 준비하는 코드
    private void handleGetReady() {
        board.setMessage("Get Ready");
        board.clear();
        previewBoard.clear();
        state = STATE_GETREADY;
        PCS.firePropertyChange("state", -1, STATE_GETREADY);
    }
    //게임 일시 정지하는 코드
    private void handlePause() {
        thread.setPaused(true);
        state = STATE_PAUSED;
        board.setMessage("Paused");
        PCS.firePropertyChange("state", -1, STATE_PAUSED);
    }

    private void handleResume() {
        state = STATE_PLAYING;
        board.setMessage(null);
        thread.setPaused(false);
        PCS.firePropertyChange("state", -1, STATE_PLAYING);
    }
    //핸들러로 레벨 수정하기
    private void handleLevelModification() {
        PCS.firePropertyChange("level", -1, level);
        thread.adjustSpeed();
    }
    //핸들러로 점수 수정하기
    private void handleScoreModification() {
        PCS.firePropertyChange("score", -1, score);
    }

    private void handleFigureStart() {
        int rotation;

        figure = nextFigure;
        moveLock = false;
        rotation = nextRotation;
        nextFigure = randomFigure();
        nextFigure.rotateRandom();
        nextRotation = nextFigure.getRotation();

        if (preview) {
            previewBoard.clear();
            nextFigure.attach(previewBoard, true);
            nextFigure.detach();
        }

        figure.setRotation(rotation);
        if (!figure.attach(board, false)) {
            previewBoard.clear();
            figure.attach(previewBoard, true);
            figure.detach();
            handleGameOver();
        }
    }

    private void handleFigureLanded() {

        if (figure.isAllVisible()) {
            score += 10;
            handleScoreModification();
        } else {
            handleGameOver();
            return;
        }
        figure.detach();
        figure = null;

        if (board.hasFullLines()) {
            board.removeFullLines();
            PCS.firePropertyChange("lines", -1, board.getRemovedLines());
            if (level < 9 && board.getRemovedLines() / 20 > level) {
                level = board.getRemovedLines() / 20;
                handleLevelModification();
            }
        } else {
            handleFigureStart();
        }
    }
    //핸들러 타이머
    private synchronized void handleTimer() {
        if (figure == null) {
            handleFigureStart();
        } else if (figure.hasLanded()) {
            handleFigureLanded();
        } else {
            figure.moveDown();
        }
    }
    //핸들러 일시중지 켜기,끄기
    private synchronized void handlePauseOnOff() {
        if (nextFigure == null) {
            handleStart();
        } else if (thread.isPaused()) {
            handleResume();
        } else {
            handlePause();
        }
    }

    private synchronized void handleKeyEvent(KeyEvent e) {
        if (state == STATE_GETREADY) {
            handleStart();
            return;
        }

        //테트리스 멈추기
        if (e.getKeyCode() == KeyEvent.VK_P) {
            handlePauseOnOff();
            return;
        }

        if (figure == null || moveLock || thread.isPaused()) {
            return;
        }
        //키보드로 조종하는 코드
        switch (e.getKeyCode()) {
            //왼쪽화살표키 -> 왼쪽으로 이동
            case KeyEvent.VK_LEFT:
                figure.moveLeft();
                break;
            //오른쪽화살표키 -> 오른쪽으로 이동
            case KeyEvent.VK_RIGHT:
                figure.moveRight();
                break;
            //아래쪽 화살표키 -> 아래쪽으로 내리기
            case KeyEvent.VK_DOWN:
                figure.moveAllWayDown();
                moveLock = true;
                break;
            //스페이스 -> 아래쪽으로 내리기
            case KeyEvent.VK_SPACE:
                figure.moveAllWayDown();
                moveLock = true;
                break;
            //위쪽 화살표 -> 방향 바꾸기
            case KeyEvent.VK_UP:
                if (e.isControlDown()) {
                    figure.rotateRandom();
                } else if (e.isShiftDown()) {
                    figure.rotateClockwise();
                } else {
                    figure.rotateCounterClockwise();
                }
                break;
            //S 키보드 키 -> 레벨 올리는 키 (속도 빨라짐)
            case KeyEvent.VK_S:
                if (level < 9) {
                    level++;
                    handleLevelModification();
                }
                break;
            //N 키보드 -> 잘 모르겠다.
            case KeyEvent.VK_N:
                preview = !preview;
                if (preview && figure != nextFigure) {
                    nextFigure.attach(previewBoard, true);
                    nextFigure.detach();
                } else {
                    previewBoard.clear();
                }
                break;
        }
    }

    private Figure randomFigure() {
        return figures[(int) (Math.random() * figures.length)];
    }

    //게임 스레드
    private class GameThread extends Thread {

        private boolean paused = true;

        private int sleepTime = 500;

        public GameThread() {
        }

        public void reset() {
            adjustSpeed();
            setPaused(false);
            if (!isAlive()) {
                this.start();
            }
        }

        public boolean isPaused() {
            return paused;
        }

        public void setPaused(boolean paused) {
            this.paused = paused;
        }

        public void adjustSpeed() {
            sleepTime = 4500 / (level + 5) - 250;
            if (sleepTime < 50) {
                sleepTime = 50;
            }
        }

        public void run() {
            while (thread == this) {
                handleTimer();

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ignore) {
                }

                while (paused && thread == this) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignore) {
                    }
                }
            }
        }
    }
}