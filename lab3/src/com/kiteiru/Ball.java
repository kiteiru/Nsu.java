package com.kiteiru;

public class Ball {
    public static final int SIZE = 35;
    private int x, y;
    private int xVel, yVel;
    private int speed = 5;
    private double acceleration = 1;

    public Ball() {
        ResetBall();
    }

    private void ResetBall() {
        x = (Model.WIDTH / 2) - (SIZE / 2);
        y = (Model.HEIGHT / 2) - (SIZE / 2);

        xVel = Ball.ResetStartBallDir(Math.random() * 2.0 - 1);
        yVel = Ball.ResetStartBallDir(Math.random() * 2.0 - 1);
    }

    public void ChangeBallDir() {
        x += xVel * (speed + acceleration);
        y += yVel * (speed + acceleration);
        acceleration += 0.0075;

        if ((y + SIZE) >= Model.HEIGHT || y <= 0) {
            ChangeYDir();
        }
    }

    public int UpdateScore(boolean leftPaddle, int score) {
        if (leftPaddle) {
            if ((x + SIZE) >= Model.WIDTH) {
                score++;
                acceleration = 1;
                ResetBall();
            }
        } else {
            if (x <= 0) {
                score++;
                acceleration = 1;
                ResetBall();
            }
        }
        return score;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public void ChangeXDir() {
        xVel *= -1;
    }

    public void ChangeYDir() {
        yVel *= -1;
    }

    public static int ResetStartBallDir(double digit) {
        if (digit <= 0) {
            return -1;
        }
        return 1;
    }

    public Ball GetBall() {
        return this;
    }
}




