package com.rush;

public class Persik {
    float cr = 1f;
    float cg = 1f;
    float cb = 1f;
    float x;
    float y;
    boolean active = true;
    String name = "atas_matras";
    int nameT = 0;
    float speed;
    float xz;
    float w = 120;
    float h = 120;
    float sx = 0;
    float sy = 0;
    float sz = 0;
    float[] tx = new float[20];
    float[] ty = new float[20];
    float[] tz = new float[20];
    float[] ts = new float[20];



    Persik(float x, float y,float speed,float xz) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.xz = xz;
        for (int i = 0; i < tx.length; i += 1) {
            tx[i] = x;
            ty[i] = y;
            tz[i] = xz;
            ts[i] = 0;
        }
    }

    public void drawBar(Rash m) {
        float s = w;
        float bs = s * 2.45f;
        float cx = m.cx, cy = m.cy;
        float bx = -cx + x, by = -cy + y + xz + s;
        if (nameT == 0) {
            String str = name;
            int size = 4;
            if (name.length() < 7) {
                size = 5;
            }
            if (name.length() > 16) {
                size = 3;
            }
            for (int i = 0; i < str.length(); i++) {
                m.font[size].setColor((cr / 2f + 0.25f) * 1.45f, (cg / 2f + 0.25f) * 1.45f, (cb / 2f + 0.25f) * 1.45f, 1);
                m.font[size].draw(m.batch, str.substring(i, i + 1), bx - bs / 1.5f + i * bs / 0.75f / str.length(), by + m.sin(m.rotateAnim + i * 10) + bs / 7.4f);
            }
        } else {
            String str = name;
            int size = 4;
            if (name.length() < 7) {
                size = 6;
            }
            if (name.length() > 16) {
                size = 3;
            }
            for (int i = 0; i < str.length(); i++) {
                float d = m.sin(m.rotateAnim + 30 * i) / 4f;
                m.font[size].setColor((cr / 1.25f + 0.1f + d / 2f) * 1.55f, (cg / 1.25f + 0.1f + d) * 1.55f, (cb / 1.25f + 0.1f + d / 5f) * 1.55f, 1);
                m.font[size].draw(m.batch, str.substring(i, i + 1), bx - bs / 1.5f + i * bs / 0.75f / str.length(), by + m.cos(m.rotateAnim + i * 15) * 4 + bs / 5f);
            }
        }
        if (!active){
            m.batch.draw(m.skull,bx-50,by+50+m.cos(m.rotateAnim + 15),50,50);
            m.font[7].setColor(0.8f, 0.1f, 0.1f, 1);
            m.font[7].draw(m.batch, "УМЕР В БОЮ",bx+10,by+100+m.cos(m.rotateAnim + 90));
        }
    }
}
