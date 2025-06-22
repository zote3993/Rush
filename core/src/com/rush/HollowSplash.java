package com.rush;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HollowSplash
{
    float x,y;
    float vx, vy;
    float s = 160;
    float speed = 0.1f;
    float r;
    float a = 0;
    int t = -1;
    Rash m;
    public HollowSplash(Rash main){
        m = main;
    }
    public void math(){
        if(t!=-1) {
            x += vx;
            y += vy;
            vx *= 0.85f;
            vy *= 0.85f;
            a += speed+0.05f;
            if (a > 7) {
                a = 0;
                t = -1;
            }
        }
    }
    public void draw(){
        if(t!=-1) {
            m.batch.setColor(1f-0.02f*a,1f-0.02f*a,1f-0.02f*a,1);
            m.batch.draw(new TextureRegion(m.hollow[(int) a]), -m.cx + x - s / 2f, -m.cy + y - s / 2, s / 2f, s / 2f, s, s, 1, 1, r);
            m.batch.setColor(1,1,1,1);
        }
    }
}
