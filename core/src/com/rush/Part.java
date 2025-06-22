package com.rush;


public class Part {

    float x, y, z;
    int tq = 200;
    float[] vx = new float[tq];
    float[] vy = new float[tq];
    float[] vz = new float[tq];
    float[] tx = new float[tq];
    float[] ty = new float[tq];
    float[] tz = new float[tq];

    float p = 0.8f;
    float s = 1;
    float e = 5;

    float gravity = 0.9f;
    int l = 19;

    float cr = 1f;
    float cg = 1f;
    float cb = 1f;
    float ca = 1f;

    Rash r;

    public Part(Rash rash) {
        r = rash;
        for (int i = 0; i < tq; i += 1) {
            vx[i] = 0;
            vy[i] = 0;
            vz[i] = 0;
            tx[i] = 0;
            ty[i] = 0;
            tz[i] = 0;
        }
    }

    public void math() {
        if (s > 0) {
            for (int i = l - 1; i > 0; i -= 1) {
                vx[i] = vx[i - 1] * p;
                vy[i] = vy[i - 1] * p;
                vz[i] = vz[i - 1] * p - gravity;
                tx[i] = tx[i - 1] + vx[i] + (r.random.nextInt(5) - 2) * e;
                ty[i] = ty[i - 1] + vy[i] + (r.random.nextInt(5) - 2) * e;
                tz[i] = tz[i - 1] + vz[i] + (r.random.nextInt(5) - 2) * e;
                if (tz[i] < 0){
                    tz[i] = 0;
                    vz[i] = -vz[i]/4f;
                }
            }
            vz[0] -= gravity;
            x += vx[0];
            y += vy[0];
            z += vz[0];

            tx[0] = x;
            ty[0] = y;
            tz[0] = z;

            s -= 0.01f;
            if (s < 0.05f) {
                s = 0;
            }
        }
    }

    public void draw() {
        if (s > 0) {
            for (int i = l - 1; i > 0; i -= 1) {
                r.drawer.setColor(cr + tz[i] / 1000f, cg + tz[i] / 1000f, cb + tz[i] / 1000f, ca);
                r.drawer.rectLine(-r.cx + tx[i], -r.cy + ty[i] + tz[i], -r.cx + tx[i - 1], -r.cy + ty[i - 1] + tz[i - 1], ((float) i / tq) * s);
            }
        }
    }
}
