package ua.training;

import java.util.Scanner;


 class GameController implements GlobalConstants {

    private GameModel gameModel;
    private GameView gameView;
    private int userValue = 0;
    private Scanner sc = new Scanner(System.in);

    GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    void launch () {
        boolean isValueWrong = true;

        setUserBarriers();
        gameView.printRange(gameModel.getMinBarrier(), gameModel.getMaxBarrier());
        gameModel.setSecretValue();
        System.out.println(gameModel.getSecretValue());

        while (isValueWrong) {
            userValue = processUserInput(sc);
            isValueWrong = gameModel.checkUserValue(userValue);

            if (userValue == gameModel.getMinBarrier()) {
                gameView.printMessage(GameView.LESS_THAN_SECRET);
            }
            else if (userValue == gameModel.getMaxBarrier()){
                gameView.printMessage(GameView.GREATER_THAN_SECRET);
            }
        }
            gameView.printMessage(GameView.CONGRATULATION + userValue);
            gameView.printHistory(gameModel.getHistory());
    }



     private int processUserInput(Scanner sc) {

        while( true ) {
            checkIntValue();
            // check value in diapason
            if ((userValue = sc.nextInt()) < gameModel.getMinBarrier() ||
                    userValue > gameModel.getMaxBarrier()) {
                gameView.printMessage(GameView.WRONG_RANGE_DATA);
                gameView.printRange(gameModel.getMinBarrier(),gameModel.getMaxBarrier());
                continue ;
            }
            break;
        }
        return userValue;
    }

    private void checkIntValue() {
        while (!sc.hasNextInt()) {
            gameView.printMessage(GameView.WRONG_INPUT_DATA);
            sc.next();
        }
    }

    private void setUserBarriers() {

        boolean isRangeValueRight = false;
        int tmp;
        gameView.printMessage(GameView.INPUT_MIN_BARRIER);
        checkIntValue();
        gameModel.setMinBarrier(sc.nextInt());

        while (!isRangeValueRight) {
            gameView.printMessage(GameView.INPUT_MAX_BARRIER);
            checkIntValue();
            tmp = sc.nextInt();
            if (tmp>gameModel.getMinBarrier()) {
                isRangeValueRight = true;
                gameModel.setMaxBarrier(tmp);
            }
            else {gameView.printMessage(
                    gameView.concatenationString(GameView.WRONG_RANGE_VALUE,
                            GameView.SPACE_SIGN, String.valueOf(gameModel.getMinBarrier())));
            }
        }
    }
 }



