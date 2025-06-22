package com.rush;

import com.badlogic.gdx.Gdx;

import java.awt.Color;

public class Particle {
    float particle;
    float x;
    float y;
    float z;
    float speed = 0.02f;
    float sx;
    float sy;
    float sz;
    int state;
    int tq = 40;
    int w1 = 25;
    Rash r;

    Particle(Rash r) {
        this.r = r;
    }

    float[][][] f = new float[w1][w1][4];
    float[] tx = new float[tq];
    float[] ty = new float[tq];
    float[] tz = new float[tq];

    public void math(Rash m) {
        if (state == 1) {
            for (int i2 = 0; i2 < 3; i2 += 1) {
                sx += r.random.nextInt(3) - 1 - (x - r.persik[m.ym].x) / 100f;
                sy += r.random.nextInt(3) - 1 - (y - r.persik[m.ym].y) / 100f;
                sz += r.random.nextInt(3) - 1 - (z - r.persik[m.ym].xz) / 100f;
                x += sx * speed;
                y += sy * speed;
                z += sz * speed;
                if (r.hit(x, y, r.persik[m.ym].x + r.persik[m.ym].w / 2, r.persik[m.ym].y + r.persik[m.ym].h / 2, 50, 50)) {
                    state = 0;
                    for (int i = 0; i < r.slots.length; i += 1) {
                        if (r.slots[i][0] == 0) {
                            if (r.gr >= 1) {
                                r.slots[i][0] += 1f;
                                i2 = 3;
                                r.gr -= 1;
                                break;
                            }
                            if (r.der >= 1) {
                                r.slots[i][0] += 2f;
                                i2 = 3;
                                r.der -= 1;
                                break;
                            }
                            if (r.gribov_j >= 1) {
                                r.slots[i][0] += 4f;
                                i2 = 3;
                                r.gribov_j -= 1;
                                break;
                            }
                            if (r.sypchik >= 1) {
                                r.slots[i][0] += 3f;
                                i2 = 3;
                                r.sypchik -= 1;
                                break;
                            }
                            if (r.syppchik >= 1) {
                                r.slots[i][0] += 5f;
                                i2 = 3;
                                r.syppchik -= 1;
                                break;
                            }
                            if (r.ir >= 1) {
                                r.slots[i][0] += 6f;
                                i2 = 3;
                                r.ir -= 1;
                                break;
                            }
                        }
                    }

                }
                for (int i = tq - 1; i > 0; i -= 1) {
                    tx[i] = tx[i - 1] + r.random.nextInt(5) - 2;
                    ty[i] = ty[i - 1] + r.random.nextInt(5) - 2;
                    tz[i] = tz[i - 1] + r.random.nextInt(5) - 2;
                }
                tx[0] = x;
                ty[0] = y;
                tz[0] = z;
            }
        }
    }

}
