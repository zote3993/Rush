package com.rush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Stalker {
    Texture[] l = new Texture[6];
    Texture[] h = new Texture[3];
    Sound[] s = new Sound[6];
    int q = 1;
    float scale = 280f;
    float[] x = new float[q];
    float[] y = new float[q];
    float[] vx = new float[q];
    float[] vy = new float[q];
    int[] t = new int[q];
    int[] a = new int[q];
    float[] state = new float[q];
    float[] d = new float[q];
    int c = 0;
    int next = 100;
    Rash m;
    public Stalker(Rash main){
        m = main;
        scale = m.random.nextInt(120)+200;
        for (int i=0;i<l.length;i+=1){
            l[i] = new Texture("d/l"+(i+1));
        }
        for (int i=0;i<h.length;i+=1){
            h[i] = new Texture("d/h"+(i+1));
        }
        for (int i=0;i<s.length;i+=1){
            s[i] = Gdx.audio.newSound(Gdx.files.internal("d/w"+(i+1)+".mp3"));
        }
        for (int i = 0;i<q;i+=1){
            x[i] = m.random.nextInt((int)(m.fx*m.res*2));
            y[i] = m.random.nextInt((int)(m.fy*m.res*2));
            a[i] = m.random.nextInt(4);
            t[i] = m.random.nextInt(3);
            vx[i] = 0;
            vy[i] = 0;
            state[i] = 1;
            d[i] = 1;
        }
    }
    public void math(){
        next-=1;
        if (next<=0){
            next=m.random.nextInt(300)*m.random.nextInt(150);
            int r = m.random.nextInt(10);
            if (r==0){
                //s[5].play(0.35f+m.random.nextInt(10)/10f);
                scale = m.random.nextInt(120)+200;
            }
            if (r==1){
                //s[2].play(0.5f+m.random.nextInt(10)/10f);
            }
            if (r==2 && c > 0){
                //s[1].play(1f);
            }
            if (r==3 && c > 2){
                //s[0].play(0.5f);
            }
            if (r==2 && c > 4){
                //s[3].play(0.5f);
            }

        }
        for (int i = 0;i<q;i+=1){
            x[i] += vx[i];
            y[i] += vy[i];

            if (m.random.nextInt(250)==0){
                state[i] = m.random.nextInt(12);
            }

            if (state[i]<=8 && state[i]>0) {
                vx[i] = (m.random.nextInt(5) - 2) * m.random.nextInt(20);
                vy[i] = (m.random.nextInt(5) - 2) * m.random.nextInt(20) / 1.5f;
                state[i] = 0;
            }
            if (state[i]==9) {
                vx[i] = (m.persik[m.ym].x-x[i])/200f+m.random.nextInt(3)-1;
                vy[i] = (m.persik[m.ym].y-y[i])/200f+m.random.nextInt(3)-1;
            }
            if (state[i]==10) {
                vx[i] = (m.persik[m.ym].x-x[i])/80f+m.random.nextInt(5)-2;
                vy[i] = (m.persik[m.ym].y-y[i])/80f+m.random.nextInt(5)-2;
                if (distance(x[i], y[i], m.persik[m.ym].x, m.persik[m.ym].y)<850){
                    vx[i] = m.random.nextInt(5)-2;
                    vy[i] = m.random.nextInt(5)-2;
                }
            }
            if (state[i]==11) {
                state[i] = 0;
                x[i] = m.random.nextInt((int)(m.fx*m.res*2));
                y[i] = m.random.nextInt((int)(m.fy*m.res*2));
            }
            if (vx[i] <= 0) {
                d[i] += (-1-d[i])/3f;
            }
            if (vx[i] > 0) {
                d[i] += (1-d[i])/3f;
            }
            float speed = (float) Math.sqrt(vx[i]*vx[i]+vy[i]*vy[i])/6f;
            if (m.random.nextInt(Math.max((int)Math.abs(20-speed),1))<4) {
                a[i] += 1;
                if(a[i]>5){
                    a[i] = 0;
                }
            }

            if (distance(x[i], y[i], m.persik[m.ym].x, m.persik[m.ym].y)<550){
                x[i] = m.random.nextInt((int)(m.fx*m.res*2));
                y[i] = m.random.nextInt((int)(m.fy*m.res*2));
                a[i] = m.random.nextInt(4);
                t[i] = m.random.nextInt(3);
                vx[i] = 0;
                vy[i] = 0;
                state[i] = 1;
                d[i] = 0;
                c+=1;
                //s[4].play(0.1f+(m.random.nextInt(5)+1)/10f);
                Gdx.app.log("c"+c, "");
            }
        }
    }

    public void draw(){
        float rotation = 0;
        if (m.rotate>90 && m.rotate<95){
            rotation=(m.rotate-90)*72;
        }
        for (int i = 0;i<q;i+=1) {
            m.batch.draw(randomize(l[a[i]], distance(x[i], y[i], m.persik[m.ym].x, m.persik[m.ym].y)), -m.cx+x[i], -m.cy+y[i],scale/2f, scale/2f, scale, scale, -d[i], 1,  0);
            m.batch.draw(randomize(h[t[i]], distance(x[i], y[i], m.persik[m.ym].x, m.persik[m.ym].y)), -m.cx+x[i]+scale/4f*(d[i])+scale/4f, -m.cy+y[i]+scale*0.7f, scale/4f, scale/4f, scale/2f, scale/2f,d[i], 1,  rotation);

        }
    }
    public TextureRegion randomize(Texture t, float d){
        if(d<1500) {
            t.getTextureData().prepare();
            Pixmap p = t.getTextureData().consumePixmap();
            p.setBlending(Pixmap.Blending.None);
            for (int i = 0; i <(1500-d)/2;i+=1) {
                int ix = m.random.nextInt(128);
                int iy = m.random.nextInt(128);
                p.setColor(0,0,0,0);
                p.drawLine(ix, iy, ix+m.random.nextInt(50)-25, iy);
                p.drawLine(ix, iy-1, ix+m.random.nextInt(50)-25, iy-1);
                if(m.random.nextInt(5)==0) {
                    ix = m.random.nextInt(128);
                    iy = m.random.nextInt(128);
                    p.setColor(m.random.nextInt(30) / 100f, m.random.nextInt(30) / 100f, m.random.nextInt(30) / 100f, 1);
                    p.drawLine(ix, iy, ix + m.random.nextInt(10) - 5, iy);
                }
            }
            Texture result = new Texture(p);
            return new TextureRegion(result);
        }
        return new TextureRegion(t);
    }
    public float distance(float x1, float y1, float x2, float y2){
        return (float)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
