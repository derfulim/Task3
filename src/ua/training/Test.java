package ua.training;

class Test {
     GameModel gameModel;

    public Test(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    void testRandom() {
        int n;
        gameModel.setMinBarrier(0);
        gameModel.setMaxBarrier(100);
        for (int i = 0; i<100; i++) {
            gameModel.setSecretValue();
            n = gameModel.getSecretValue();
            assert (n>gameModel.getMinBarrier()&&(n<gameModel.getMaxBarrier()));
            }
        }
    }


