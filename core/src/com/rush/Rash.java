package com.rush;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.IOException;
import java.util.Random;

public class Rash extends ApplicationAdapter {
    SpriteBatch batch;
    BitmapFont[] font = new BitmapFont[10];
    Texture img, shadow, trava, trava_shadow, grib, grib_shadow, slot, collect, grib_glow, korobka, korobka_s, derevob, topor, topor_s, der_kr, brevno, kraft, kraft1, kraft_bar, syp, syp_item, zemlya, hp_texture, hp_texture_low, enemy, sypp_bar, sypp, biom, ej, iron, iron_m, arb_bar, attack, attack_s, shoot, hungry_texture, hungry_texture_low, big_ej_t, poop, big_hp, ej_hpp_full, ej_hpp_low, chistka, mag, fireball, topori, kirkai, arbi, nebo, penek, badplace, locator, locator2, tar, tarflower, fly, magshadow, kapkan, build_kapkan, build_kapkan_s,img_nakaval,skull;
    TextureRegion toporiRegion, kirkaiRegion, arbiRegion;
    Persik persik[] = new Persik[69]; ///// КОЛ-ВО МАТРАСИКОВ
    ShapeRenderer drawer;
    Random random = new Random();
    Stalker stalker;
    int ym = 0;
    int seed = 0;
    boolean initialized = false;
    HollowSplash[] hs = new HollowSplash[200];
    ThroughServerPacket initializationData;
    boolean online = false; /////////////////////////////////// ДЛЯ ОФЛАЙН РЕЖИМА ПЕРЕКЛЮЧИТЬ НА FALSE!!!!!!!!!!
    int gribochkov = random.nextInt(20) + 20;
    int derevov = random.nextInt(20) + 80;
    int ironovv = random.nextInt(20) + 20;
    int ejj = 44;
    int magg = 44;
    float w, h;
    float state_korobka = 0;
    float rotateAnim = 0;
    float state_topor = 0;
    float cx = 0, cy = 0;
    float[] flyx = new float[40];
    float[] flyy = new float[40];
    float[] flyd = new float[40];
    int[] flys = new int[40];
    float[] tarflowerx = new float[20];
    float[] tarflowery = new float[20];
    float[] tarx = new float[20];
    float[] tary = new float[20];
    float[] locatorx = new float[20];
    float[] locatory = new float[20];
    float[] locator2x = new float[20];
    float[] locator2y = new float[20];
    float[] badplacex = new float[20];
    float[] badplacey = new float[20];
    float[] travax = new float[5000];
    float[] travay = new float[5000];
    float[] travas = new float[5000];
    float[] travad = new float[5000];
    float[] travaa = new float[5000];
    int i4 = 0;
    float[] gribx = new float[gribochkov];
    float[] griby = new float[gribochkov];
    float[] kapkanx = new float[ejj];
    float[] kapkany = new float[ejj];
    float[] kapkanhp = new float[ejj];
    float[] ironx = new float[ironovv];
    float[] irony = new float[ironovv];
    int[] ironos = new int[ironovv];
    float[] irond = new float[ironovv];
    float[] ironhp = new float[ironovv];
    float[] ejx = new float[ejj];
    float[] ejy = new float[ejj];
    float[] magx = new float[ejj];
    Part[] p = new Part[1069]; ///////////////////////////////////////////////////
    float[] magy = new float[ejj];
    float[] mag_hp = new float[ejj];
    float[] magd = new float[ejj];
    int[] mags = new int[ejj];
    float[] magz = new float[ejj];
    float[] ej_hp = new float[ejj];
    int[] ejs = new int[ejj];
    float[] ejn = new float[ejj];
    float big_ejx = 111100;
    float big_ejy = 111100;
    float big_hpy = big_ejx;
    float big_hpx = big_ejy + 210;
    float chet_big_ej = 1;
    float big_ej_hp = 15;
    float[] enemyx = new float[gribochkov];
    float[] enemyy = new float[gribochkov];
    float[] penekx = new float[derevov];
    float[] peneky = new float[derevov];
    float[] derevox = new float[derevov];
    float[] derevoy = new float[derevov];
    Texture[] derevoa = new Texture[6];
    Texture[] hollow = new Texture[8];
    Texture[] irona = new Texture[9];
    float[] derevod = new float[derevov];
    float[] derevohp = new float[derevov];
    int[] derevos = new int[derevov];
    float[][] slots = new float[10][2];
    Texture[] dash = new Texture[4];
    Texture[] eja = new Texture[5];
    Texture[] maga = new Texture[12];
    Texture[] kapkana = new Texture[4];
    Texture[] flya = new Texture[4];
    int[] kapkans = new int[ejj];
    float[] kapkand = new float[ejj];
    float[] dashx = new float[20];
    float[] dashy = new float[20];
    float[] dashs = new float[20];
    float[] dashz = new float[20];
    float[] hps = new float[10];
    float[] hungrys = new float[10];
    float kryg1 = 50 * ejx.length;
    float kryg2 = 0;
    float kryg3 = 0;
    float kryg4 = 0;
    float kryg5 = 50 * magx.length;
    float kryg6 = 0;
    float kryg7 = 0;
    float kryg8 = 0;
    float chet = 0;//////////////
    int num = 9;/////////////////
    float[][] point = new float[2][5];
    Texture[] boim = new Texture[10];
    float der = 0;
    float gr = 0;
    float big_ej = 0;
    float gr_j = 0;
    float der_kr123 = 0;
    float state_kraft = 0;
    float sypchik = 0;
    float barx = 9999;
    float bary = 9999;
    float sypx = 9999;
    float sypy = 9999;
    float sypx_bar = 9999;
    float sypy_bar = 9999;
    float syppx_bar = 9999;
    float syppy_bar = 9999;
    float arbx_bar = 9999;
    float arby_bar = 9999;
    float syppx = 9999;
    float syppy = 9999;
    float breven = 0;
    float gribov = 0;
    float gribov_j = 0;
    float sypov = 0;
    int agr = 0;
    float ir = 0;
    float ironov = 0;
    float sypyara = 0;
    float syppchik = 0;
    float syppov = 0;
    float rotate = 0;
    float rotate2 = 0;
    float matras = 3;
    float atas = 0.5f;
    float arb = 0;
    //float ax = 1.37f;
    //float ay = 2.5f;
    int fx = 35;
    int fy = 20;
    int res = 64;
    float zelx = 0;
    float zely = 0;
    float state_attack = 0;
    float ax = 0f;
    float ay = 0f;
    float fireballx = 999999f;
    float firebally = 999999f;
    float chet_fireball = 1;
    float shar = 1;
    Particle[] part = new Particle[1000];
    float shootx = 9899;
    float shooty = 9899;
    float gr_topor = 210;
    float gr_arb = 210;
    boolean draw_topor = false;
    boolean draw_arb = false;
    boolean draw_kirka = false;
    float gr_kirka = 210;
    float toporn = 0;
    float kirkan = 0;
    float arbn = 0;
    float time = 13;
    float sytki = 0;
    float napad = 0;
    float wawe = 1;
    float stop = 1;
    float hp_kraft = 100;
    int chet_kapkan = 0;
    float state_kapkan = 0;
    boolean spawn = false;
    String characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890[]-=_+./#$%?!:";
    Pixmap biomm;


    Rash rash;

    Sound sound9;
    Music sound8;
    Sound sound7;
    Sound sound6;
    Sound sound5;
    Sound sound4;
    Sound sound3;
    Sound sound2;
    Sound sound1;
    Sound sound0;


    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font_1, font_2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        drawer = new ShapeRenderer();
        stalker = new Stalker(this); // ДЛЯ КРУТОГО ЭФФЕКТА УБРАТЬ КОММЕНТЫ ТУТ, НА 861, на 1811 и на 29
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        for (int i = 0; i < eja.length; i += 1) {
            eja[i] = new Texture("hog_" + (i + 1) + ".png");
        }
        for (int i = 0; i < hollow.length; i += 1) {
            hollow[i] = new Texture("strike_" + (i + 1) + ".png");
        }
        for (int i = 0; i < derevoa.length; i += 1) {
            derevoa[i] = new Texture("derebo_" + (i + 1) + ".png");
        }
        for (int i = 0; i < 4; i += 1) {
            dash[i] = new Texture("dash" + (i + 1) + ".png");
        }
        for (int i = 0; i < irona.length; i += 1) {
            irona[i] = new Texture("stone_" + (i + 1) + ".png");
        }
        for (int i = 0; i < maga.length; i += 1) {
            maga[i] = new Texture("ball" + (i + 1) + ".png");
        }
        for (int i = 0; i < kapkana.length; i += 1) {
            kapkana[i] = new Texture("trap" + (i + 1) + ".png");
        }
        for (int i = 0; i < flya.length; i += 1) {
            flya[i] = new Texture("fly" + (i + 1) + ".png");
        }
        for (int i = 0; i < 20; i += 1) {
            dashx[i] = 0;
            dashy[i] = 0;
            dashs[i] = 0;
            dashz[i] = 0;
        }
        for (int i = 0; i < part.length; i += 1) {
            part[i] = new Particle(this);
            part[i] = new Particle(this);
        }

        for (int i = 0; i < persik.length; i += 1) {
            persik[i] = new Persik(100, 100, 10, 0);
        }

        for (int i = 0; i < hs.length; i += 1) {
            hs[i] = new HollowSplash(this);
        }

        rash = this;
        if (online) {
            Thread clientThread = new Thread(() -> {
                ThroughClient client = new ThroughClient(rash);
                try {
                    client.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            clientThread.start();
        } else {
            seed = random.nextInt(1000000);
            random.setSeed(seed);
            for (int i = 0; i < point.length; i += 1) {
                point[i][0] = random.nextInt(fx * 2 * res);
                point[i][1] = random.nextInt(fy * 2 * res);
                point[i][2] = 0.1f + random.nextInt(80) / 100f;
                point[i][3] = 0.1f + random.nextInt(80) / 100f;
                point[i][4] = 0.1f + random.nextInt(80) / 100f;
            }
            while (true) {
                point[0][2] = 0.1f + random.nextInt(80) / 100f;
                point[0][3] = 0.1f + random.nextInt(80) / 100f;
                point[0][4] = 0.1f + random.nextInt(80) / 100f;
                point[1][2] = 0.1f + random.nextInt(80) / 100f;
                point[1][3] = 0.1f + random.nextInt(80) / 100f;
                point[1][4] = 0.1f + random.nextInt(80) / 100f;
                float delta = Math.abs(point[0][2] - point[1][2]) + Math.abs(point[0][3] - point[1][3]) + Math.abs(point[0][4] - point[1][4]);
                if (delta > 0f) {
                    break;
                }

            }
            for (int i = 0; i < gribx.length; i += 1) {
                gribx[i] = random.nextInt((int) w * 10) - w * 5;
                griby[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < tarflowerx.length; i += 1) {
                tarflowerx[i] = random.nextInt((int) w * 10) - w * 5;
                tarflowery[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < tarx.length; i += 1) {
                tarx[i] = random.nextInt((int) w * 10) - w * 5;
                tary[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < locatorx.length; i += 1) {
                locatorx[i] = random.nextInt((int) w * 10) - w * 5;
                locatory[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < locator2x.length; i += 1) {
                locator2x[i] = random.nextInt((int) w * 10) - w * 5;
                locator2y[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < badplacex.length; i += 1) {
                badplacex[i] = random.nextInt((int) w * 10) - w * 5;
                badplacey[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < flyx.length; i += 1) {
                flyx[i] = random.nextInt((int) w * 10) - w * 5;
                flyy[i] = random.nextInt((int) h * 10) - h * 5;
                flyd[i] = 0;
                flys[i] = 0;
            }
            for (int i = 0; i < penekx.length; i += 1) {
                penekx[i] = 9999;
                peneky[i] = 9999;
            }
            for (int i = 0; i < ej_hp.length; i += 1) {
                ej_hp[i] = 2;
            }
            for (int i = 0; i < mag_hp.length; i += 1) {
                mag_hp[i] = 2;
            }
            for (int i = 0; i < ironx.length; i += 1) {
                ironx[i] = random.nextInt((int) w * 10) - w * 5;
                irony[i] = random.nextInt((int) h * 10) - h * 5;
                irond[i] = 0;
                ironhp[i] = 6;
                ironos[i] = 0;
            }
            for (int i = 0; i < ejx.length; i += 1) {
                ejx[i] = 9999999;
                ejy[i] = 9999999;
                ejs[i] = 0;
                ejn[i] = 0;
            }
            for (int i = 0; i < magx.length; i += 1) {
                magx[i] = 9999999;
                magy[i] = 9999999;
                magd[i] = 0;
                magz[i] = 50;
                mags[i] = 0;
            }
            for (int i = 0; i < enemyx.length; i += 1) {
                enemyx[i] = random.nextInt((int) w * 10) - w * 5;
                enemyy[i] = random.nextInt((int) h * 10) - h * 5;
            }
            for (int i = 0; i < derevox.length; i += 1) {
                derevox[i] = random.nextInt((int) w * 10) - w * 5;
                derevoy[i] = random.nextInt((int) h * 10) - h * 5;
                derevod[i] = 0;
                derevohp[i] = 6;
                derevos[i] = 0;
            }
            for (int i = 0; i < travax.length; i += 1) {
                travax[i] = random.nextInt((int) w * 10) - w * 5;
                travay[i] = -fy * res * 4 + (float) (i * fy * res * 8) / travax.length;  //random.nextInt((int) h * 10) - h * 5;
                travas[i] = random.nextInt((int) 200) + 50;
                travad[i] = random.nextInt((int) 2);
                travaa[i] = random.nextInt((int) 10);

            }
            boim = generateBiom(fx * 2, fy * 2, res, boim.length, 25, 0.3f, 50000, 1100);
            initialized = true;
        }

        point[0][2] = 0.1f;
        point[0][3] = 0.5f;
        point[0][4] = 0.005f;
        //point[1][2] = 0f;
        //point[1][3] = 0.8f;
        //point[1][4] = 0f;
        img = new Texture("matrasik4.png");
        korobka = new Texture("collect.png");
        topor = new Texture("topor.png");
        topor_s = new Texture("topor1.png");
        der_kr = new Texture("derevo_kr.png");
        korobka_s = new Texture("collect1.png");
        shadow = new Texture("shadow2.png");
        slot = new Texture("slot.png");
        grib = new Texture("grib.png");
        iron = new Texture("stone.png");
        iron_m = new Texture("iron_m.png");
        derevob = new Texture("derevob.png");
        grib_glow = new Texture("grib_glow.png");
        collect = new Texture("collect.png");
        grib_shadow = new Texture("grib_shadow.png");
        trava = new Texture("trava.png");
        trava_shadow = new Texture("trava_shadow.png");
        brevno = new Texture("brevno.png");
        kraft = new Texture("kraft.png");
        kraft1 = new Texture("kraft1.png");
        kraft_bar = new Texture("slot1.png");
        syp = new Texture("syp.png");
        sypp = new Texture("green_syp.png");
        sypp_bar = new Texture("syp+_bar.png");
        syp_item = new Texture("syp_item.png");
        zemlya = new Texture("zemlya1.png");
        hp_texture = new Texture("hp_texture.png");
        hp_texture_low = new Texture("hp_texture_low.png");
        hungry_texture = new Texture("hungry_texture.png");
        hungry_texture_low = new Texture("hungry_texture_low.png");
        enemy = new Texture("enemy.png");
        ej = new Texture("test.png");
        arb_bar = new Texture("arb.png");
        attack = new Texture("attack.png");
        attack_s = new Texture("attack_s.png");
        shoot = new Texture("shoot.png");
        big_ej_t = new Texture("test.png");
        poop = new Texture("poop.png");
        big_hp = new Texture("hp.png");
        ej_hpp_full = new Texture("hpp1.png");
        ej_hpp_low = new Texture("hpp2.png");
        chistka = new Texture("chistka.png");
        mag = new Texture("mag.png");
        fireball = new Texture("fireball.png");
        topori = new Texture("topori.png");
        penek = new Texture("penek.png");
        badplace = new Texture("badplace.png");
        locator = new Texture("locator.png");
        locator2 = new Texture("locator2.png");
        tar = new Texture("tar.png");
        fly = new Texture("fly1.png");
        tarflower = new Texture("tarflower.png");
        magshadow = new Texture("magshadow.png");
        kapkan = new Texture("trap1.png");
        build_kapkan = new Texture("build_kapkan.png");
        build_kapkan_s = new Texture("build_kapkan_s.png");
        toporiRegion = new TextureRegion(topori);
        kirkai = new Texture("kirkai.png");
        kirkaiRegion = new TextureRegion(kirkai);
        arbi = new Texture("arbi.png");
        arbiRegion = new TextureRegion(arbi);
        nebo = new Texture("nebo.png");
        img_nakaval = new Texture("img_nakaval.png");
        skull = new Texture("skull.png");
        //kirkai = new Texture("kirkai .png");
        //arbi = new Texture("arbi.png");
        // biomm = new Pixmap(64,64, Pixmap.Format.RGBA8888);

        sound9 = Gdx.audio.newSound(Gdx.files.internal("kapkan.mp3"));
        sound8 = Gdx.audio.newMusic(Gdx.files.internal("ULTRABITFEAR.mp3"));
        sound7 = Gdx.audio.newSound(Gdx.files.internal("shoot.mp3"));
        sound6 = Gdx.audio.newSound(Gdx.files.internal("grib.mp3"));
        sound5 = Gdx.audio.newSound(Gdx.files.internal("grib.mp3"));
        sound4 = Gdx.audio.newSound(Gdx.files.internal("kraft.mp3"));
        sound3 = Gdx.audio.newSound(Gdx.files.internal("kirka.mp3"));
        sound2 = Gdx.audio.newSound(Gdx.files.internal("derevo.mp3"));
        sound1 = Gdx.audio.newSound(Gdx.files.internal("knopka.mp3"));
        sound0 = Gdx.audio.newSound(Gdx.files.internal("hit.mp3"));

        sound8.play();
        sound8.setLooping(true);
        sound8.setPosition(18);

        parameter.characters = characters;
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));

        parameter.borderWidth = 1f;
        parameter.color = new Color(1, 1, 1, 1);
        parameter.borderColor = new Color(0.1f, 0.1f, 0.1f, 1);
        parameter.size = 64;
        font_1 = generator.generateFont(parameter);
        for (int i = 0; i < font.length; i++) {
            parameter.size = (int) (4f + i * 4f);
            parameter.borderWidth = 1 + i * 0.2f;
            parameter.borderColor = new Color(0, 0, 0, 1);
            parameter.color = new Color(1, 1, 1, 1);
            font[i] = generator.generateFont(parameter);
        }


        float korobkax = w / 1.38f;
        float korobkay = h / 5.5f;
        float toporx = w / 1.2f;
        float topory = h / 3.5f;
        float attackx = w / ax;
        float attacky = h / ay;
        float kraftx = w / 2f;
        float krafty = h / 2f;
        float build_kapkanx = w / 1.21f;
        float build_kapkany = h / 15f;
        float chistkax = (w / 2 - 300 + 60 * 10) + 5;
        float chistkay = (20 + random.nextInt(2) - 2) + 5;
        zelx = random.nextInt((int) w * 10) - w * 10;
        zely = random.nextInt((int) h * 10) - h * 10;
        for (int i = 0; i < kapkanx.length; i += 1) {
            kapkanx[i] = 99999;
            kapkany[i] = 99999;
            kapkand[i] = 0;
            kapkans[i] = 3;
            kapkanhp[i] = 2;
        }
        for (int i = 0; i < p.length; i += 1) {
            p[i] = new Part(this);
        }
        for (int i = 0; i < hps.length; i += 1) {
            hps[i] = 1;
        }
        for (int i = 0; i < hungrys.length; i += 1) {
            hungrys[i] = 1;
        }
        for (int i = 0; i < slots.length; i += 1) {
            slots[i][0] = 0;
            slots[i][1] = 0;
        }
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (hit(screenX, h - screenY, korobkax + 112, korobkay + 112, 50, 60) | hit(screenX, h - screenY, toporx + 112, topory + 112, 50, 60) | hit(screenX, h - screenY, sypx_bar, sypy_bar, 200, 50) | hit(screenX, h - screenY, syppx_bar, syppy_bar, 200, 50) | hit(screenX, h - screenY, arbx_bar, arby_bar, 200, 50) | hit(screenX, h - screenY, w / ax + 112, h / ay + 112, 50, 60) | hit(screenX, h - screenY, chistkax + 20, chistkay + 20, 50, 60) | hit(screenX, h - screenY, build_kapkanx + 112, build_kapkany + 112, 50, 60)) {
//                    Gdx.app.log("", "КОРОБКА! или ТОПОР!");
                    sound1.play(1.0f);
                } else {
                    for (int i = 0; i < 20; i += 1) {
                        setP(persik[ym].x, persik[ym].y, persik[ym].xz, 0.5f, 0.5f, 0.5f, 1, 1, 0.1f, 89, 0.9f, random.nextInt(11) - 5, random.nextInt(11) - 5, 2);
                    }
                    persik[ym].sx += (screenX - (persik[ym].x - cx)) / 10;
                    persik[ym].sy += (h - screenY - (persik[ym].y - cy)) / 10;
                    persik[ym].sz += 15;
                    int index = -1;
                    for (int i = 0; i < 20; i += 1) {
                        if (dashs[i] == 0) {
                            index = i;
                            break;
                        }
                    }
                    if (index != -1) {
                        dashs[index] = 3;
                        dashx[index] = persik[ym].x;
                        dashy[index] = persik[ym].y;
                        dashz[index] = persik[ym].xz;
                    }
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                for (int i = 0; i < kapkanx.length; i += 1) {
                    if (hit(screenX, h - screenY, build_kapkanx + 112, build_kapkany + 112, 50, 60)) {
                        state_kapkan = 10;
                        if (breven >= 2 & ironov >= 1) {
                            if (kapkand[chet_kapkan] == 0) {
                                kapkanx[chet_kapkan] = persik[ym].x;
                                kapkany[chet_kapkan] = persik[ym].y;
                                kapkand[chet_kapkan] = -1;
                                chet_kapkan += 1;
                            }
                            breven -= 2;
                            ironov -= 1;
                            float chet = 0;
                            float chet2 = 0;
                            for (int i2 = 0; i2 < slots.length; i2 += 1) {
                                if (slots[i2][0] == 2 & chet < 2) {
                                    slots[i2][0] = 0;
                                    chet += 1;
                                }
                                if (slots[i2][0] == 6 & chet2 < 1) {
                                    slots[i2][0] = 0;
                                    chet2 += 1;
                                }
                            }
                            strikes(persik[ym].x, persik[ym].y, 1);
                            break;
                        }
                    }
                }
                for (int i = 0; i < derevox.length; i += 1) {
                    if (hit(screenX, h - screenY, toporx + 112, topory + 112, 50, 60)) {
                        state_topor = 10;

                        if (hit(persik[ym].x, persik[ym].y, derevox[i], derevoy[i], 50, 300)) {
                            for (int i2 = 0; i2 < 20; i2 += 1) {
                                setP(derevox[i] + 50, derevoy[i] + 50, 20, 0.6f + (float) random.nextInt(15) / 100f, 0.4f + (float) random.nextInt(15) / 100f, 0.05f + (float) random.nextInt(15) / 100f, 2, 2, 0.1f, 89, 0.9f, random.nextInt(11) - 5, random.nextInt(11) - 5, 2);
                            }
                            if (derevod[i] == 0) {
                                draw_topor = true;
                                derevod[i] = 1;
                                derevohp[i] -= 1;
                                if (derevohp[i] <= 0) {
                                    setPart(derevox[i], derevoy[i], 0, brevno);
                                    penekx[i] = 0;
                                    peneky[i] = 0;
                                    derevox[i] = 99899;
                                    derevoy[i] = 99999;
                                    der += 1;
                                    der_kr123 = 20;
                                    breven += 1;
                                }
                                strikes(derevox[i], derevoy[i], 2);
                                sound2.play(0.7f);
                            }
                        }
                    }
                }
                if (hit(screenX, h - screenY, chistkax + 20, chistkay + 20, 50, 60)) {
                    ironov = 0;
                    breven = 0;
                    gribov = 0;
                    gribov_j = 0;
                    sypov = 0;
                    for (int i = 0; i < slots.length; i += 1) {
                        slots[i][0] = 0;
                    }
                }
                for (int i = 0; i < ironx.length; i += 1) {
                    if (hit(screenX, h - screenY, toporx + 112, topory + 112, 50, 60)) {
                        if (hit(persik[ym].x, persik[ym].y, ironx[i], irony[i], 50, 300)) {
                            for (int i2 = 0; i2 < 20; i2 += 1) {
                                setP(ironx[i] + 50, irony[i] + 50, 20, 0.9f + (float) random.nextInt(40) / 100f, 0.75f + (float) random.nextInt(40) / 100f, 0.3f + (float) random.nextInt(40) / 100f, 0.1f, 4, 0.1f, 70, 0.1f, (random.nextInt(11) - 5) / 10f, (random.nextInt(11) - 5) / 10f, (random.nextInt(11) - 5) / 10f + 7);
                            }
                            if (irond[i] == 0) {
                                draw_kirka = true;
                                irond[i] = 1;
                                ironhp[i] -= 1;
                                if (ironhp[i] <= 0) {
                                    setPart(ironx[i], irony[i], 0, iron);
                                    ironx[i] = 99899;
                                    irony[i] = 99999;
                                    ir += 1;
                                    ironov += 1;
                                }
                                sound3.play(0.7f);
                            }
                        }
                    }
                }
                if (hit(screenX, h - screenY, syppx_bar, syppy_bar, 100, 100)) {
                    if (breven >= 1 & gr_j >= 3) {
                        syppx = 900;
                        syppy = 800;
                        breven -= 1;
                        gr_j -= 3;
                        float chet = 0;
                        float chet2 = 0;
                        for (int i = 0; i < slots.length; i += 1) {
                            if (slots[i][0] == 3 & chet < 1) {
                                slots[i][0] = 0;
                                chet += 1;
                            }
                            if (slots[i][0] == 4 & chet2 < 3) {
                                slots[i][0] = 0;
                                chet2 += 1;
                            }
                        }
                    }
                }
                if (hit(screenX, h - screenY, arbx_bar, arby_bar, 100, 100)) {
                    if (breven >= 3 & ironov >= 3) {
                        breven -= 3;
                        ironov -= 3;
                        arb += 1;
                        ax = 1.37f;
                        ay = 2.5f;
                        float chet = 0;
                        float chet2 = 0;
                        for (int i = 0; i < slots.length; i += 1) {
                            if (slots[i][0] == 2 | chet < 3) {
                                slots[i][0] = 0;
                                chet += 1;
                            }
                            if (slots[i][0] == 6 | chet2 < 3) {
                                slots[i][0] = 0;
                                chet2 += 1;
                            }
                        }
                    }
                }
                if (hit(screenX, h - screenY, sypx_bar, sypy_bar, 100, 100)) {
                    if (breven >= 3 & gribov >= 3) {
                        sypx = 900;
                        sypy = 700;
                        breven -= 3;
                        gribov -= 3;
                        sypchik += 1;
                        sypyara += 1;
                        float chet = 0;
                        float chet2 = 0;
                        float chet3 = 0;
                        for (int i2 = 0; i2 < hungrys.length; i2 += 1) {
                            if (hungrys[i2] == 0 & chet3 < 2) {
                                hungrys[i2] = 1;
                                num += 1;
                                chet3 += 1;
                            }
                        }
                        for (int i = 0; i < slots.length; i += 1) {
                            if (slots[i][0] == 1 & chet < 5) {
                                slots[i][0] = 0;
                                chet += 1;
                            }
                            if (slots[i][0] == 2 & chet2 < 5) {
                                slots[i][0] = 0;
                                chet2 += 1;
                            }
                        }
                    }
                }
                if (hit(persik[ym].x, persik[ym].y, kraftx, krafty, 100, 300)) {
                    barx = 0;
                    bary = 0;
                    sypx_bar = 0;
                    sypy_bar = 0;
                    syppx_bar = 0;
                    syppy_bar = 198;
                    arbx_bar = 0;
                    arby_bar = 398;
                    state_kraft = 1;
                    sound4.play(1.0f);
                } else {
                    barx = 9999;
                    bary = 9999;
                    sypx_bar = 9999;
                    sypy_bar = 9999;
                    syppx_bar = 9999;
                    syppy_bar = 9999;
                    arbx_bar = 9999;
                    arby_bar = 9999;
                    state_kraft = 0;
                }


                for (int i = 0; i < ejx.length; i += 1) {
                    if (hit(screenX, h - screenY, w / ax + 112, h / ay + 112, 50, 60) & hit(persik[ym].x, persik[ym].y, ejx[i], ejy[i], 300, 300)) {
                        shootx = persik[ym].x;
                        shooty = persik[ym].y;
                        draw_arb = true;
                    }
                    if (hit(screenX, h - screenY, w / ax + 112, h / ay + 112, 50, 60) & hit(persik[ym].x, persik[ym].y, big_ejx, big_ejy, 300, 300)) {
                        shootx = persik[ym].x;
                        shooty = persik[ym].y;
                        draw_arb = true;
                    }
                }
                for (int i = 0; i < magx.length; i += 1) {
                    if (hit(screenX, h - screenY, w / ax + 112, h / ay + 112, 50, 60) & hit(persik[ym].x, persik[ym].y, magx[i], magy[i], 300, 300)) {
                        shootx = persik[ym].x;
                        shooty = persik[ym].y;
                        draw_arb = true;
                    }
                    if (hit(screenX, h - screenY, w / ax + 112, h / ay + 112, 50, 60)) {
                        state_attack = 10;
                    }
                }

                for (int i = 0; i < gribx.length; i += 1) {
                    if (hit(screenX, h - screenY, korobkax + 112, korobkay + 112, 50, 60)) {
                        state_korobka = 10;
                        if (hit(persik[ym].x, persik[ym].y, gribx[i], griby[i], 50, 150)) {
                            setPart(gribx[i], griby[i], 0, grib);
                            gribx[i] = 99999;
                            griby[i] = 99999;
                            gr += 1;
                            gribov += 1;
                            sound5.play(1.0f);
                            for (int i2 = 0; i2 < hungrys.length; i2 += 1) {
                                if (hungrys[i2] == 0) {
                                    hungrys[i2] = 1;
                                    num += 1;
                                    break;
                                }
                            }
                            for (int i2 = 0; i2 < hps.length; i2 += 1) {
                                if (hps[i2] == 0) {
                                    hps[i2] = 1;
                                    break;
                                }
                            }
                        }
                        if (hit(persik[ym].x, persik[ym].y, enemyx[i], enemyy[i], 50, 150)) {
                            setPart(enemyx[i], enemyy[i], 0, enemy);
                            enemyx[i] = 99999;
                            enemyy[i] = 99999;
                            gr_j += 1;
                            gribov_j += 1;
                            sound6.play(1.0f);
                            for (int i2 = 0; i2 < hungrys.length; i2 += 1) {
                                if (hungrys[i2] == 0) {
                                    hungrys[i2] = 1;
                                    num += 1;
                                    break;
                                }
                            }
                            for (int i2 = 9; i2 < hps.length; i2 -= 1) {
                                if (hps[i2] == 1) {
                                    hps[i2] = 0;
                                    break;
                                }
                            }
                        }

                        if (hit(persik[ym].x, persik[ym].y, zelx, zely, 500, 1500)) {
                            setPart(zelx, zely, 0, sypp);
                            zelx = 99999;
                            zely = 99999;
                            matras += 5;
                            atas += 3;
                            sound6.play(1.0f);
                            //zel += 1;
                        }
                        if (hit(persik[ym].x, persik[ym].y, syppx, syppy, 50, 150)) {
                            setPart(syppx, syppy, 0, sypp);
                            syppx = 99999;
                            syppy = 99999;
                            syppchik += 1;
                            matras += 5;
                            atas += 3;
                            sound6.play(1.0f);
                            syppov += 1;
                        }
                        if (hit(persik[ym].x, persik[ym].y, sypx, sypy, 50, 150)) {
                            setPart(sypx, sypy, 0, syp_item);
                            sypx = 99999;
                            sypy = 99999;
                            sypchik += 1;
                            matras = 3f;
                            atas = 0.5f;
                            sound6.play(1.0f);
                            sypov += 1;
                            float chet = 0;
                            for (int i2 = 0; i2 < hps.length; i2 += 1) {
                                if (hps[i2] == 0) {
                                    hps[i2] = 1;
                                    chet += 1;
                                    if (chet == 2) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            @Override
            public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });
        Thread math = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (!initialized) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        continue;
                    }
                    stalker.math();

                    for (int i = 0; i < hs.length; i += 1) {
                        hs[i].math();
                    }

                    for (int i = 0; i < p.length; i += 1) {
                        p[i].math();
                    }

                    for (int g = 0; g < persik.length; g += 1) {
                        persik[g].x += persik[g].sx;
                        persik[g].y += persik[g].sy;
                        persik[g].xz += persik[g].sz;
                        persik[g].sx += (-persik[g].sx) / persik[g].speed;
                        persik[g].sy += (-persik[g].sy) / persik[g].speed;
                        persik[g].sz += (-5 - persik[g].sz) / persik[g].speed - 1;
                        if (persik[g].xz < 0) {
                            persik[g].xz = 0;
                            persik[g].sz = persik[g].sz / -2;
                        }


                        for (int i = persik[g].tx.length - 1; i > 0; i -= 1) {
                            persik[g].tx[i] = persik[g].tx[i - 1];
                            persik[g].ty[i] = persik[g].ty[i - 1];
                            persik[g].tz[i] = persik[g].tz[i - 1];
                            persik[g].ts[i] = persik[g].ts[i - 1];
                            if (persik[g].tz[i] > 1) {
                                persik[g].tz[i] -= 0.5f;
                            }
                        }
                        persik[g].tx[0] = persik[g].x;
                        persik[g].ty[0] = persik[g].y;
                        persik[g].tz[0] = persik[g].xz;
                        if (agr >= 1) {
                            persik[g].ts[0] = agr * 2;
                        } else {
                            persik[g].ts[0] = 0;
                        }
                    }
                    agr = 0;

                    for (int i = 0; i < derevod.length; i += 1) {
                        if (random.nextInt(2) == 1) {
                            if (derevod[i] == -1) {
                                derevos[i] -= 1;
                                if (derevos[i] == 0) {
                                    derevod[i] = 0;
                                }
                            }
                            if (derevod[i] == 1) {
                                derevos[i] += 1;
                                if (derevos[i] == 5) {
                                    derevod[i] = -1;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < flyd.length; i += 1) {
                        if (random.nextInt(2) == 1) {
                            if (flyd[i] == -1) {
                                flys[i] -= 1;
                                if (flys[i] == 0) {
                                    flyd[i] = 0;
                                }
                            }
                            if (flyd[i] == 1) {
                                flys[i] += 1;
                                if (flys[i] == 3) {
                                    flyd[i] = -1;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < kapkand.length; i += 1) {
                        if (random.nextInt(2) == 1) {
                            if (kapkand[i] == -1) {
                                kapkans[i] -= 1;
                                if (kapkans[i] == 0) {
                                    kapkand[i] = 0;
                                }
                            }
                            if (kapkand[i] == 1) {
                                kapkans[i] += 1;
                                if (kapkans[i] == 3) {
                                    kapkand[i] = -1;
                                }
                            }
                        }
                    }

                    rotate2 += 0.08f;
                    if (rotate2 >= 270 & napad == 0) {
                        napad = 1;
                        //sound8.stop();
                        //try {
                        //    Thread.sleep(30);
                        //} catch (InterruptedException e) {
                        //    throw new RuntimeException(e);
                        //}
                        //sound8.play();
                        if (wawe == 1 & stop == 1) {
                            wawe += 1;
                            for (int i = 0; i < 3; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 2000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 2000;
                            }
                            stop = 0;
                        }
                        if (wawe == 2 & stop == 1) {
                            wawe += 1;
                            for (int i = 3; i < 10; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 3000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 3000;
                            }
                            stop = 0;
                        }
                        if (wawe == 3 & stop == 1) {
                            wawe += 1;
                            for (int i = 10; i < 12; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 5000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 5000;
                                magx[i] = (float) Math.sin(r * Math.PI / 180) * 5000;
                                magy[i] = (float) Math.cos(r * Math.PI / 180) * 5000;
                            }
                            stop = 0;
                        }
                        if (wawe == 4 & stop == 1) {
                            wawe += 1;
                            for (int i = 12; i < 15; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                                magx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                magy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        if (wawe == 5 & stop == 1) {
                            wawe += 1;
                            for (int i = 15; i < 18; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                                magx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                magy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        if (wawe == 6 & stop == 1) {
                            wawe += 1;
                            for (int i = 18; i < 25; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        if (wawe == 7 & stop == 1) {
                            wawe += 1;
                            for (int i = 25; i < 28; i += 1) {
                                float r = random.nextInt(360);
                                magx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                magy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        if (wawe == 8 & stop == 1) {
                            wawe += 1;
                            for (int i = 28; i < 32; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                                magx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                magy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        if (wawe == 9 & stop == 1) {
                            wawe += 1;
                            for (int i = 32; i < 40; i += 1) {
                                float r = random.nextInt(360);
                                ejx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                ejy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        if (wawe == 10 & stop == 1) {
                            wawe += 1;
                            for (int i = 40; i < 44; i += 1) {
                                float r = random.nextInt(360);
                                magx[i] = (float) Math.sin(r * Math.PI / 180) * 6000;
                                magy[i] = (float) Math.cos(r * Math.PI / 180) * 6000;
                            }
                            stop = 0;
                        }
                        stop = 1;
                    }
                    if (rotate2 >= 360) {
                        rotate2 = 0;
                        napad = 0;
                    }

                    for (int i = 0; i < irond.length; i += 1) {
                        if (random.nextInt(2) == 1) {
                            if (irond[i] == -1) {
                                ironos[i] -= 1;
                                if (ironos[i] == 0) {
                                    irond[i] = 0;
                                }
                            }
                            if (irond[i] == 1) {
                                ironos[i] += 1;
                                if (ironos[i] == 8) {
                                    irond[i] = -1;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < flyx.length; i += 1) {
                        if (random.nextInt(3) == 1) {
                            int or = random.nextInt(4);
                            if (flyd[i] == 0) {
                                flyd[i] = 1;
                            }
                            if (or == 0) {
                                flyx[i] += random.nextInt(10) + 4;
                                flyy[i] += random.nextInt(10) + 4;
                            }
                            if (or == 1) {
                                flyx[i] -= random.nextInt(10) + 4;
                                flyy[i] -= random.nextInt(10) + 4;
                            }
                            if (or == 2) {
                                flyx[i] += random.nextInt(10) + 4;
                                flyy[i] -= random.nextInt(10) + 4;
                            }
                            if (or == 3) {
                                flyx[i] -= random.nextInt(10) + 4;
                                flyy[i] += random.nextInt(10) + 4;
                            }
                        }
                    }

                    for (int i = 0; i < ejx.length; i += 1) {
                        for (int i2 = 0; i2 < kapkanx.length; i2 += 1) {
                            if (hit(kapkanx[i2], kapkany[i2], ejx[i], ejy[i], 50, 50)) {
                                for (int i3 = 0; i3 < 20; i3 += 1) {
                                    setP(ejx[i] + 50, ejy[i] + 50, 20, 0.7f + (float) random.nextInt(15) / 100f, 0.1f + (float) random.nextInt(15) / 100f, 0.1f + (float) random.nextInt(15) / 100f, 2, 2, 0.1f, 89, 0.9f, random.nextInt(11) - 5, random.nextInt(11) - 5, 5);
                                }
                                ejx[i] = 9999999;
                                ejy[i] = 9999999;
                                sound9.play(1f);
                                if (kapkand[i2] == 0) {
                                    kapkand[i2] = 1;
                                }
                                if (kapkanhp[i2] == 1) {
                                    kapkanx[i2] = 999999;
                                    kapkany[i2] = 999999;
                                    ;
                                }
                                if (kapkanhp[i2] > 1) {
                                    kapkanhp[i2] -= 1;
                                }
                                strikes(kapkanx[i], kapkany[i], 10);
                            }
                        }
                    }

                    for (int i = 0; i < magx.length; i += 1) {
                        for (int i2 = 0; i2 < kapkanx.length; i2 += 1) {
                            if (hit(kapkanx[i2], kapkany[i2], magx[i], magy[i], 50, 50)) {
                                for (int i3 = 0; i3 < 20; i3 += 1) {
                                    setP(magx[i] + 50, magy[i] + 50, 20, 0.7f + (float) random.nextInt(15) / 100f, 0.1f + (float) random.nextInt(15) / 100f, 0.1f + (float) random.nextInt(15) / 100f, 2, 2, 0.1f, 89, 0.9f, random.nextInt(11) - 5, random.nextInt(11) - 5, 5);
                                }
                                magx[i] = 9999999;
                                magy[i] = 9999999;
                                sound9.play(1f);
                                if (kapkand[i2] == 0) {
                                    kapkand[i2] = 1;
                                }
                                if (kapkanhp[i2] == 1) {
                                    kapkanx[i2] = 999999;
                                    kapkany[i2] = 999999;
                                    ;
                                }
                                if (kapkanhp[i2] > 1) {
                                    kapkanhp[i2] -= 1;
                                }
                                strikes(kapkanx[i], kapkany[i], 10);
                            }
                        }
                    }

                    for (int i = 0; i < ejx.length; i += 1) {
                        if (hit(persik[ym].x, persik[ym].y, big_ejx, big_ejy, 50, 50)) {
                            hps[11] = 0;
                        }
                        if (hit(shootx, shooty, ejx[i], ejy[i], 20, 20)) {
                            for (int i2 = 0; i2 < 10; i2 += 1) {
                                setP(ejx[i] + 50, ejy[i] + 50, 20, 0.7f + (float) random.nextInt(15) / 100f, 0.1f + (float) random.nextInt(15) / 100f, 0.1f + (float) random.nextInt(15) / 100f, 2, 2, 0.1f, 89, 0.9f, random.nextInt(11) - 5, random.nextInt(11) - 5, 2);
                            }
                            if (ej_hp[i] >= 1) {
                                ej_hp[i] -= 1;
                                shootx = 888888;
                                shooty = 888888;
                            }
                            if (ej_hp[i] < 1) {
                                //big_ej += 1;
                                ejx[i] = 9999999;
                                ejy[i] = 9999999;
                                shootx = 888888;
                                shooty = 888888;
                            }
                            strikes(ejx[i], ejy[i], 5);
                            sound7.play(1.0f);
                        }
                    }
                    for (int i = 0; i < magx.length; i += 1) {
                        if (hit(shootx, shooty, magx[i], magy[i], 20, 20)) {
                            for (int i2 = 0; i2 < 10; i2 += 1) {
                                setP(magx[i] + 50, magy[i] + 50, 20, 0.7f + (float) random.nextInt(15) / 100f, 0.2f + (float) random.nextInt(15) / 100f, 0.2f + (float) random.nextInt(15) / 100f, 2, 2, 0.1f, 89, 0.9f, random.nextInt(11) - 5, random.nextInt(11) - 5, 2);
                            }
                            if (mag_hp[i] >= 1) {
                                mag_hp[i] -= 1;
                                shootx = 888888;
                                shooty = 888888;
                            }
                            if (mag_hp[i] < 1) {
                                magx[i] = 9999;
                                magy[i] = 9999;
                                shootx = 888888;
                                shooty = 888888;
                            }
                            strikes(magx[i], magy[i], 5);
                            sound7.play(1.0f);
                        }
                    }
                    if (hit(shootx, shooty, big_ejx, big_ejy, 20, 20)) {
                        shootx = 888888;
                        shooty = 888888;
                        big_ej_hp -= 1;
                        sound7.play(1.0f);
                        if (big_ej_hp <= 0) {
                            big_ejx = 11100;
                            big_ejy = 11100;
                            big_ej_hp = 15;
                        }
                        if (big_ej_hp <= 15 & big_ej_hp >= 10) {
                            big_hp = new Texture("hp.png");
                        }
                        if (big_ej_hp <= 10 & big_ej_hp >= 5) {
                            big_hp = new Texture("hp2.png");
                        }
                        if (big_ej_hp <= 5 & big_ej_hp >= 0) {
                            big_hp = new Texture("hp3.png");
                        }
                    }

                    if (hit(fireballx, firebally, persik[ym].x, persik[ym].y, 20, 20)) {
                        chet = 1;
                        sound0.play(1.0f);
                    }
                    for (int i = 0; i < ejx.length; i += 1) {
                        if (hit(persik[ym].x, persik[ym].y, ejx[i], ejy[i], 50, 50)) {
                            ejx[i] = 9999999;
                            ejy[i] = 9999999;
                            sound0.play(1.0f);
                            int i3 = 9;
                            strikes(persik[ym].x, persik[ym].y, 2);
                            for (int i2 = 9; i2 > 4; ) {
                                if (hps[i3] == 1) {
                                    hps[i3] = 0;
                                    i2 -= 1;
                                }
                                if (hps[i3] == 0) {
                                    i3 -= 1;
                                }
                            }
                        }
                    }
                    for (int i = 0; i < ejx.length; i += 1) {
                        if (hit(kraftx, krafty, ejx[i], ejy[i], 50, 50)) {
                            ejx[i] = 9999999;
                            ejy[i] = 9999999;
                            strikes(kraftx, krafty, 2);
                            hp_kraft -= 10;
                            sound0.play(1.0f);
                        }
                        if (random.nextInt(3) == 0) {
                            ejs[i] += 1;
                        }
                        if (ejs[i] == 10) {
                            ejs[i] = 0;
                        }

                        if (hit2(kraftx, krafty, ejx[i], ejy[i]) <= 10000) {
                            agr = 1;
                            if (ejx[i] > kraftx) {
                                ejx[i] -= 3 + random.nextInt(3) - 1;
                                ejn[i] = -1;
                            }
                            if (ejx[i] < kraftx) {
                                ejx[i] += 3 + random.nextInt(3) - 1;
                                ejn[i] = 1;
                            }
                            if (ejy[i] > krafty) { //// следование за персиком
                                ejy[i] -= 3 + random.nextInt(3) - 1;
                            }
                            if (ejy[i] < krafty) {
                                ejy[i] += 3 + random.nextInt(3) - 1;
                            }
                            //ejx[i] += 10;
                            //ejy[i] += 10;
                        }
                        if (hit(kraftx, krafty, magx[i], magy[i], 50, 50)) {
                            hp_kraft -= 20;
                            sound0.play(1.0f);
                        }
                    }
                    for (int i = 0; i < magx.length; i += 1) {
                        if (hit2(persik[ym].x, persik[ym].y, magx[i], magy[i]) >= 700) {
                            if (magx[i] > kraftx) {
                                magx[i] -= 3 + random.nextInt(3) - 1;
                            }
                            if (magx[i] < kraftx) {
                                magx[i] += 3 + random.nextInt(3) - 1;
                            }
                            if (magy[i] > krafty) { //// следование за персиком
                                magy[i] -= 3 + random.nextInt(3) - 1;
                            }
                            if (magy[i] < krafty) {
                                magy[i] += 3 + random.nextInt(3) - 1;
                            }
                        }
                        if (hit2(persik[ym].x, persik[ym].y, magx[i], magy[i]) <= 700 & shar == 1) {
                            if (chet_fireball == 1) {
                                if (magd[i] == 0) {
                                    magd[i] = 1;
                                }
                                if (magd[i] == -1) {
                                    fireballx = magx[i];
                                    firebally = magy[i];
                                    chet_fireball = 0;
                                }
                            }
                            magz[i] = (float) Math.sin(rotate * 5 / 180f * Math.PI) * 50 + 50;
                            if (magd[i] == 1) {
                                mags[i] += 1;
                                if (mags[i] >= maga.length - 1) {
                                    magd[i] = -1;
                                }
                            }
                            if (magd[i] == -1) {
                                mags[i] -= 1;
                                if (mags[i] <= 0) {
                                    magd[i] = 0;
                                }
                            }
                            if (fireballx > persik[ym].x) {
                                fireballx -= 5 + random.nextInt(3) - 1;
                            }
                            if (fireballx < persik[ym].x) {
                                fireballx += 5 + random.nextInt(3) - 1;
                            }
                            if (firebally > persik[ym].y) { //// следование fireballa за персиком
                                firebally -= 5 + random.nextInt(3) - 1;
                            }
                            if (firebally < persik[ym].y) {
                                firebally += 5 + random.nextInt(3) - 1;
                            }
                        }
                        if (hit2(persik[ym].x, persik[ym].y, fireballx, firebally) >= 600) {
                            fireballx = 9999;
                            firebally = 9999;
                            chet_fireball = 1;
                        }
                        if (hit(persik[ym].x, persik[ym].y, fireballx, firebally, 30, 30)) {
                            int i3 = 9;
                            for (int i2 = 9; i2 > 4; ) {
                                if (hps[i3] == 1) {
                                    hps[i3] = 0;
                                    i2 -= 1;
                                }
                                if (hps[i3] == 0) {
                                    i3 -= 1;
                                }
                            }
                            fireballx = 9999;
                            firebally = 9999;
                            sound0.play(1.0f);
                        }
                    }
                    for (int i = 0; i < ejx.length; i += 1) {
                        if (hit(shootx, shooty, ejx[i], ejy[i], 300, 300)) {
                            //shootx = persik.x;
                            //shooty = persik.y;
                            if (shootx > ejx[i]) {
                                shootx -= 10;
                            }
                            if (shootx < ejx[i]) {
                                shootx += 10;
                            }
                            if (shooty > ejy[i]) { //// следование за ЕЖОМ
                                shooty -= 10;
                            }
                            if (shooty < ejy[i]) {
                                shooty += 10;
                            }
                        }
                    }
                    for (int i = 0; i < ejx.length; i += 1) {
                        if (hit(shootx, shooty, big_ejx, big_ejy, 250, 250)) {
                            //shootx = persik.x;
                            //shooty = persik.y;
                            if (shootx > big_ejx) {
                                shootx -= 10;
                            }
                            if (shootx < big_ejx) {
                                shootx += 10;
                            }
                            if (shooty > big_ejy) { //// следование за ЕЖОМ
                                shooty -= 10;
                            }
                            if (shooty < big_ejy) {
                                shooty += 10;
                            }
                        }
                    }
                    for (int i = 0; i < magx.length; i += 1) {
                        if (hit(shootx, shooty, magx[i], magy[i], 300, 300)) {
                            //shootx = persik.x;
                            //shooty = persik.y;
                            if (shootx > magx[i]) {
                                shootx -= 10;
                            }
                            if (shootx < magx[i]) {
                                shootx += 10;
                            }
                            if (shooty > magy[i]) { //// следование за МАГОМ
                                shooty -= 10;
                            }
                            if (shooty < magy[i]) {
                                shooty += 10;
                            }
                        }
                    }
                    for (int i = 0; i < travax.length; i += 1) {
                        if (travad[i] == 0) {
                            travaa[i] += random.nextInt(3) / 3f;
                            if (travaa[i] > 30) {
                                travad[i] = 1;
                            }
                        } else {
                            travaa[i] -= random.nextInt(3) / 3f;
                            if (travaa[i] < -30) {
                                travad[i] = 0;
                            }
                        }
                    }

                    for (int i = 0; i < 20; i += 1) {
                        dashx[i] += random.nextInt(5) - 2;
                        dashy[i] += random.nextInt(5) - 2;
                        dashz[i] += random.nextInt(5) - 4;
                        dashs[i] -= 0.1f;
                        if (dashs[i] < 0) {
                            dashs[i] = 0;
                        }
                    }

                    for (int i = 0; i < 100; i += 1) {
                        part[i].math(rash);
                    }

                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        math.start();
    }

    public boolean hit(float x1, float y1, float x2, float y2, float r1, float r2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= r1 + r2;
    }

    public float hit2(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public void setPart(float x, float y, float z, Texture t) {
        int index = -1;
        for (int i = 0; i < gribx.length; i += 1) {
            if (part[i].state == 0) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            part[index].state = 1;
            part[index].x = x;
            part[index].y = y;
            part[index].z = z;
            t.getTextureData().prepare();
            Pixmap p = t.getTextureData().consumePixmap();
            for (int ix = 0; ix < part[index].w1; ix += 1) {
                for (int iy = 0; iy < part[index].w1; iy += 1) {
                    Color c = new Color(p.getPixel(ix * 4, 100 - iy * 4));
                    part[index].f[ix][iy][0] = c.r;
                    part[index].f[ix][iy][1] = c.g;
                    part[index].f[ix][iy][2] = c.b;
                    part[index].f[ix][iy][3] = c.a;
                }
            }
            for (int i = 0; i < part[index].tq; i += 1) {
                part[index].tx[i] = x;
                part[index].ty[i] = y;
                part[index].tz[i] = z;

            }
        }
    }

    public void setP(float x, float y, float z, float cr, float cg, float cb, float e, float s, float gravity, int l, float power, float vx, float vy, float vz) {
        int index = -1;
        for (int i = 0; i < p.length; i += 1) {
            if (p[i].s == 0) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            p[index].s = s;
            p[index].x = x;
            p[index].y = y;
            p[index].z = z;
            p[index].cr = cr;
            p[index].cg = cg;
            p[index].cb = cb;
            p[index].e = e;
            p[index].gravity = gravity;
            p[index].l = l;
            p[index].p = power;
            for (int i = 0; i < p[index].l; i += 1) {
                p[index].tx[i] = x;
                p[index].ty[i] = y;
                p[index].tz[i] = z;
                p[index].vx[i] = vx;
                p[index].vy[i] = vy;
                p[index].vz[i] = vz;

            }
        }
    }

    public void setH(float x, float y) {
        int index = -1;
        for (int i = 0; i < hs.length; i += 1) {
            if (hs[i].t == -1) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            hs[index].s = 150;
            hs[index].x = x;
            hs[index].y = y;
            hs[index].r = random.nextInt(360);
            hs[index].speed = random.nextInt(5) / 20f + 0.3f;
            hs[index].vx = sin(hs[index].r) * 5;
            hs[index].vy = cos(hs[index].r) * 5;
            hs[index].t = 0;
        }
    }

    public void strikes(float x, float y, int n) {
        for (int i = 0; i <= n; i += 1) {
            setH(x + random.nextInt(30) - 15 + 100, y + random.nextInt(30) - 15 + 100);
        }
    }


    public void colorSet(float x, float y) {
        float r = 0;
        float g = 0;
        float b = 0;
        int ix = (int) ((x) / 32f);  ////// 8,4
        int iy = (int) ((y) / 32f);  ////// 8,4
        float d = 0;
        for (int i3 = 0; i3 < point.length; i3 += 1) {
            d += hit2(ix, iy, point[i3][0], point[i3][1]);
        }
        for (int i3 = 0; i3 < point.length; i3 += 1) {
            float k = hit2(ix, iy, point[i3][0], point[i3][1]) / d;
            r += point[i3][2] * k;
            g += point[i3][3] * k;
            b += point[i3][4] * k;
        }
        batch.setColor(r, g, b, 1f);
    }

    public void initialization() {
        ThroughServerPacket data = initializationData;
        seed = data.seed;
        random.setSeed(seed);
        for (int i = 0; i < point.length; i += 1) {
            point[i][0] = random.nextInt(fx * 2 * res);
            point[i][1] = random.nextInt(fy * 2 * res);
            point[i][2] = 0.1f + random.nextInt(80) / 100f;
            point[i][3] = 0.1f + random.nextInt(80) / 100f;
            point[i][4] = 0.1f + random.nextInt(80) / 100f;
        }
        while (true) {
            point[0][2] = 0.1f + random.nextInt(80) / 100f;
            point[0][3] = 0.1f + random.nextInt(80) / 100f;
            point[0][4] = 0.1f + random.nextInt(80) / 100f;
            point[1][2] = 0.1f + random.nextInt(80) / 100f;
            point[1][3] = 0.1f + random.nextInt(80) / 100f;
            point[1][4] = 0.1f + random.nextInt(80) / 100f;
            float delta = Math.abs(point[0][2] - point[1][2]) + Math.abs(point[0][3] - point[1][3]) + Math.abs(point[0][4] - point[1][4]);
            if (delta > 0f) {
                break;
            }

        }
        for (int i = 0; i < gribx.length; i += 1) {
            gribx[i] = random.nextInt((int) w * 10) - w * 5;
            griby[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < tarflowerx.length; i += 1) {
            tarflowerx[i] = random.nextInt((int) w * 10) - w * 5;
            tarflowery[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < tarx.length; i += 1) {
            tarx[i] = random.nextInt((int) w * 10) - w * 5;
            tary[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < locatorx.length; i += 1) {
            locatorx[i] = random.nextInt((int) w * 10) - w * 5;
            locatory[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < locator2x.length; i += 1) {
            locator2x[i] = random.nextInt((int) w * 10) - w * 5;
            locator2y[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < badplacex.length; i += 1) {
            badplacex[i] = random.nextInt((int) w * 10) - w * 5;
            badplacey[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < flyx.length; i += 1) {
            flyx[i] = random.nextInt((int) w * 10) - w * 5;
            flyy[i] = random.nextInt((int) h * 10) - h * 5;
            flyd[i] = 0;
            flys[i] = 0;
        }
        for (int i = 0; i < penekx.length; i += 1) {
            penekx[i] = 9999;
            peneky[i] = 9999;
        }
        for (int i = 0; i < ej_hp.length; i += 1) {
            ej_hp[i] = 2;
        }
        for (int i = 0; i < mag_hp.length; i += 1) {
            mag_hp[i] = 2;
        }
        for (int i = 0; i < ironx.length; i += 1) {
            ironx[i] = random.nextInt((int) w * 10) - w * 5;
            irony[i] = random.nextInt((int) h * 10) - h * 5;
            irond[i] = 0;
            ironhp[i] = 6;
            ironos[i] = 0;
        }
        for (int i = 0; i < ejx.length; i += 1) {
            ejx[i] = 9999999;
            ejy[i] = 9999999;
            ejs[i] = 0;
            ejn[i] = 0;
        }
        for (int i = 0; i < magx.length; i += 1) {
            magx[i] = 9999999;
            magy[i] = 9999999;
            magd[i] = 0;
            magz[i] = 50;
            mags[i] = 0;
        }
        for (int i = 0; i < enemyx.length; i += 1) {
            enemyx[i] = random.nextInt((int) w * 10) - w * 5;
            enemyy[i] = random.nextInt((int) h * 10) - h * 5;
        }
        for (int i = 0; i < derevox.length; i += 1) {
            derevox[i] = random.nextInt((int) w * 10) - w * 5;
            derevoy[i] = random.nextInt((int) h * 10) - h * 5;
            derevod[i] = 0;
            derevohp[i] = 6;
            derevos[i] = 0;
        }
        for (int i = 0; i < travax.length; i += 1) {
            travax[i] = random.nextInt((int) w * 10) - w * 5;
            travay[i] = -fy * res * 4 + (float) (i * fy * res * 8) / travax.length;  //random.nextInt((int) h * 10) - h * 5;
            travas[i] = random.nextInt((int) 200) + 50;
            travad[i] = random.nextInt((int) 2);
            travaa[i] = random.nextInt((int) 10);

        }
        boim = generateBiom(fx * 2, fy * 2, res, boim.length, 25, 0.3f, 50000, 1100);
        for (int i = 0; i < data.x.length; i++) {
            persik[i] = new Persik(data.x[i], data.y[i], 10, data.z[i]);
            persik[i].sx = data.vx[i];
            persik[i].sy = data.vy[i];
            persik[i].sz = data.vz[i];
            persik[i].cr = data.cr[i];
            persik[i].cg = data.cg[i];
            persik[i].cb = data.cb[i];
            //persik[i].health = data.health[i];
            //persik[i].maxHealth = data.maxHealth[i];
            persik[i].nameT = data.t[i];
            persik[i].name = data.name[i];
        }
        ym = data.index;
        initialized = true;
    }

    public void updateData(ThroughServerPacket data) {
        for (int i = 0; i < persik.length; i += 1) {
            persik[i].active = false;
        }
        for (int i = 0; i < data.x.length; i++) {
            if (i != ym) {
                persik[i].x = data.x[i];
                persik[i].y = data.y[i];
                persik[i].xz = data.z[i];
                persik[i].sx = data.vx[i];
                persik[i].sy = data.vy[i];
                persik[i].sz = data.vz[i];
                persik[i].cr = data.cr[i];
                persik[i].cg = data.cg[i];
                persik[i].cb = data.cb[i];
                //persik[i].health = data.health[i];
                //persik[i].maxHealth = data.maxHealth[i];
                persik[i].nameT = data.t[i];
                persik[i].name = data.name[i];
            }
            persik[i].active = true;
        }
        ym = data.index;
    }

    @Override
    public void render() {
        rotateAnim += 2;
        if (rotateAnim >= 360) {
            rotateAnim -= 360;
        }
        if (!initialized) {
            if (initializationData != null) {
                initialization();
            }
            return;
        }
        big_hpx = big_ejx;
        big_hpy = big_ejy + 200;
        float korobkax = w / 1.38f;
        float korobkay = h / 5.5f;
        float toporx = w / 1.2f;
        float topory = h / 3.5f;
        float kraftx = w / 2f;
        float krafty = h / 2f;
        float build_kapkanx = w / 1.21f;
        float build_kapkany = h / 15f;
        float attackx = w / ax;
        float attacky = h / ay;
        float chistkax = (w / 2 - 300 + 60 * 10) + 5;
        float chistkay = 30;
        float s = 100;
        float v = matras;
        cx += w / 2;
        cy += h / 2;
        cx += (persik[ym].x - cx) / 8f;
        cy += (persik[ym].y - cy) / 8f;
        cx -= w / 2;
        cy -= h / 2;
        rotate += atas;
        if (rotate >= 360) {
            rotate = 1;
        }
        if (chet >= 1650) {
            hungrys[num] = 0;
            num -= 1;
            chet = 0;
        }
        if (sytki >= 250) {
            time += 0.1f;
            sytki = 0;
        }
        if (time >= 24) {
            time = 0;
        }
        chet += 1;
        sytki += 1;
        if (big_ej >= 5) {
            if (chet_big_ej == 1) {
                big_ejx = persik[ym].x + 200;
                big_ejy = persik[ym].y + 200;
                chet_big_ej = 0;
            }
            if (big_ejx > persik[ym].x) {
                big_ejx -= 2;
            }
            if (big_ejx < persik[ym].x) {
                big_ejx += 2;
            }
            if (big_ejy > persik[ym].y) { //// следование биг ежа за персиком
                big_ejy -= 2;
            }
            if (big_ejy < persik[ym].y) {
                big_ejy += 2;
            }
        }
        float atas_sin = (float) Math.sin((rotate - 10 * v * 3) / 180f * Math.PI) * v * 10;
        float atas_cos = (float) Math.cos((rotate - 10 * v * 3) / 180f * Math.PI) * v * 10;
        batch.enableBlending();
        //Gdx.gl.glClearColor(0.27f, 0.45f, 0.09f, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < boim.length; i += 1) {
            batch.draw(boim[i], (-cx) - fx * res * 4 + (float) Math.sin((rotate - i * v * 3) / 180f * Math.PI) * v * i, (-cy) - fy * res * 4 + (float) Math.cos((rotate - i * v * 3) / 180f * Math.PI) * v * i, fx * res * 8, fy * res * 8);
        }
        //Random random2 = new Random(52);
        //TextureRegion zemlyar = new TextureRegion(zemlya);
        //for (int ix = -39; ix < 39; ix += 1) {
        //    for (int iy = -22; iy < 22; iy += 1) {
        //        batch.setColor(0.8f + random2.nextInt(10) / 10f, 0.8f + random2.nextInt(10) / 10f, 0.8f + random2.nextInt(10) / 10f, 1);
        //        batch.draw(zemlyar, -cx + ix * s, -cy + iy * s, s / 2, s / 2, s, s, 1f, 1f, random2.nextInt(4) * 90);
        //    }
        //}
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < travax.length; i += 1) {
            batch.draw(trava_shadow, -cx + travax[i] - travas[i] / 2 - travaa[i] / 2 + atas_sin, -cy + travay[i] - travas[i] / 2 - travaa[i] / 2 + atas_cos, travas[i] + travaa[i] + 10, travas[i] + travaa[i] + 10);
        }
        for (int i = 0; i < persik.length; i += 1) {
            batch.draw(shadow, -cx + persik[i].x, -cy + persik[i].y, persik[i].w, persik[i].h);
        }
        for (int i = 0; i < gribx.length; i += 1) {
            batch.draw(grib_shadow, -cx + gribx[i], -cy + griby[i], 70, 70);
        }

        for (int i = 0; i < magx.length; i += 1) {
            batch.draw(magshadow, -cx + magx[i] - magz[i] / 8f, -cy + magy[i] - magz[i] / 8f, 260 + magz[i] / 4f, 260 + magz[i] / 4f);
        }


        for (int i = 0; i < travax.length; i += 1) {
            if (travay[i] > persik[ym].y + 20) {
                colorSet(travax[i] - travas[i] / 2 - travaa[i] / 2, travay[i] - travas[i] / 2 - travaa[i] / 2);
                batch.draw(trava, -cx + travax[i] - travas[i] / 2 - travaa[i] / 2 + atas_sin, -cy + travay[i] - travas[i] / 2 - travaa[i] / 2 + atas_cos, travas[i] + travaa[i] + 10, travas[i] + travaa[i] + 10);
            }
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < gribx.length; i += 1) {
            batch.draw(grib, -cx + gribx[i], -cy + griby[i], 70, 70);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < gribx.length; i += 1) {
            batch.draw(flya[flys[i]], -cx + flyx[i], -cy + flyy[i], 60, 60);
        }
        batch.setColor(1, 1, 1, 1);

        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < tarx.length; i += 1) {
            batch.draw(tar, -cx + tarx[i], -cy + tary[i], 150, 150);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < locator2x.length; i += 1) {
            batch.draw(locator2, -cx + locator2x[i], -cy + locator2y[i], 150, 150);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < locatorx.length; i += 1) {
            batch.draw(locator, -cx + locatorx[i], -cy + locatory[i], 150, 150);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < badplacex.length; i += 1) {
            batch.draw(badplace, -cx + badplacex[i], -cy + badplacey[i], 200, 200);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < tarflowerx.length; i += 1) {
            batch.draw(tarflower, -cx + tarflowerx[i], -cy + tarflowery[i], 150, 150);
        }
        batch.setColor(1, 1, 1, 1);

        for (int i = 0; i < ejx.length; i += 1) {
            Texture t = eja[0];
            if (ejs[i] > 4) {
                t = eja[9 - ejs[i]];
            } else {
                t = eja[ejs[i]];
            }
            batch.draw(new TextureRegion(t), -cx + ejx[i], -cy + ejy[i], 60, 60, 120, 120, -1 * ejn[i], 1, ejs[i] * 1 - 10);
            if (ej_hp[i] == 2) {
                batch.draw(ej_hpp_full, -cx + ejx[i], -cy + ejy[i] + 120, 120, 10);
            }
            if (ej_hp[i] == 1) {
                batch.draw(ej_hpp_low, -cx + ejx[i], -cy + ejy[i] + 120, 120, 10);
            }
        }
        for (int i = 0; i < magx.length; i += 1) {
            batch.draw(ej_hpp_full, -cx + magx[i] + 30, -cy + magy[i] + 140 + magz[i] + 120, 120 * mag_hp[i] / 2, 10);
        }

        for (int i = 0; i < kapkanx.length; i += 1) {
            batch.draw(kapkana[kapkans[i]], -cx + kapkanx[i], -cy + kapkany[i], 100, 100);
        }

        for (int i = 0; i < enemyx.length; i += 1) {
            batch.draw(enemy, -cx + enemyx[i], -cy + enemyy[i], 70, 70);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < ironx.length; i += 1) {
            batch.draw(irona[ironos[i]], -cx + ironx[i], -cy + irony[i], 150, 150);
        }
        for (int i = 0; i < derevox.length; i += 1) {
            if (derevoy[i] > persik[ym].y + 5) {
                colorSet(derevox[i], derevoy[i]);
                batch.draw(derevoa[derevos[i]], -cx + derevox[i], -cy + derevoy[i], 220, 300);
            }
        }
        for (int i = 0; i < penekx.length; i += 1) {
            colorSet(penekx[i], peneky[i]);
            batch.draw(penek, -cx + penekx[i], -cy + peneky[i], 70, 100);
        }
        batch.setColor(1, 1, 1, 1);
        for (int i = 0; i < magx.length; i += 1) {
            batch.draw(maga[mags[i]], -cx + magx[i] - magz[i] / 8f, -cy + magy[i] - magz[i] / 8f + magz[i], 260 + magz[i] / 4f, 260 + magz[i] / 4f);
        }

        batch.end();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        drawer.begin(ShapeRenderer.ShapeType.Filled);

        s = 2.8f;
        for (int i = 0; i < part.length; i += 1) {
            if (part[i].state == 1) {
                for (int it = part[i].tq - 2; it >= 0; it -= 1) {
                    for (int ix = 0; ix < part[i].w1; ix += 1) {
                        for (int iy = 0; iy < part[i].w1; iy += 1) {
                            if (part[i].f[ix][iy][0] != 0) {
                                if (it != 0) {
                                    float dx = (part[i].tx[it + 1] - part[i].tx[it]) / 2;
                                    float dy = (part[i].ty[it + 1] - part[i].ty[it]) / 2;
                                    drawer.setColor(part[i].f[ix][iy][0], part[i].f[ix][iy][1], part[i].f[ix][iy][2], part[i].f[ix][iy][3] / (it) + (random.nextInt(30) - 15) / 500f);
                                    drawer.rect(part[i].tx[it] + s * ix - cx + random.nextInt(10) / 10f * dx, part[i].ty[it] + s * iy - cy + random.nextInt(10) / 10f * dy, s, s);
                                } else {
                                    float dx = 0;
                                    float dy = 0;
                                    drawer.setColor(part[i].f[ix][iy][0], part[i].f[ix][iy][1], part[i].f[ix][iy][2], 1f);
                                    drawer.rect(part[i].tx[it] + s * ix - cx + random.nextInt(10) / 10f * dx, part[i].ty[it] + s * iy - cy + random.nextInt(10) / 10f * dy, s, s);
                                }
                            }
                        }
                    }
                }
            }
        }
        drawer.end();
        batch.begin();

        for (int i = 0; i < 20; i += 1) {
            if (dashs[i] != 0) {
                float m = (1 - dashs[i] / 3) * 35;
                batch.setColor(1f, 1f, 1f, dashs[i] / 3f);
                batch.draw(dash[(int) dashs[i]], -cx + dashx[i] - dashz[i] / 8 - m / 2, -cy + dashy[i] - dashz[i] / 8 - m / 2 + dashz[i], persik[ym].w + dashz[i] / 4 + m, persik[ym].h + dashz[i] / 4 + m);
                batch.setColor(1f, 1f, 1f, 1);
            }

        }
        if (state_kraft == 1) {
            batch.draw(kraft, -cx + kraftx, -cy + krafty, 200, 200);
        } else {
            batch.draw(kraft1, -cx + kraftx, -cy + krafty, 200, 200);
        }
        batch.setColor(1, 1, 1, 1);
        colorSet(sypx, sypy);
        batch.draw(syp_item, -cx + sypx, -cy + sypy, 100, 100);
        batch.setColor(1, 1, 1, 1);
        batch.draw(sypp, -cx + zelx, -cy + zely, 150, 150);
        colorSet(syppx, syppy);
        batch.draw(sypp, -cx + syppx, -cy + syppy, 100, 100);
        batch.setColor(1, 1, 1, 1);
        batch.draw(big_ej_t, -cx + big_ejx, -cy + big_ejy, 200, 200);
        batch.draw(big_hp, -cx + big_hpx, -cy + big_hpy, 200, 20);
        batch.draw(fireball, -cx + fireballx, -cy + firebally, 60, 60);

        for (int g = 0; g < persik.length; g += 1) {
            batch.setColor(1f * persik[g].cr, 1f * persik[g].cg, 1f * persik[g].cb, 1f);
            for (int i = persik[g].tx.length - 1; i > 0; i -= 1) {
                if (persik[g].ts[i] >= 1) {
                    batch.draw(poop, -cx + persik[g].tx[i] - persik[g].tz[i] / 8 + 50, -cy + persik[g].ty[i] + persik[g].tz[i] - persik[g].tz[i] / 8 + 50, persik[g].tz[i] / 4 + 20 * persik[g].ts[i] + 10, persik[g].tz[i] / 4 + 20 * persik[g].ts[i] + 10);
                }
            }

            if (persik[g].active) {
                batch.draw(img, -cx + persik[g].x - persik[g].xz / 8, -cy + persik[g].y + persik[g].xz - persik[g].xz / 8, persik[g].w + persik[g].xz / 4, persik[g].h + persik[g].xz / 4);
            }
            else{
                batch.draw(img_nakaval, -cx + persik[g].x - persik[g].xz / 8, -cy + persik[g].y + persik[g].xz - persik[g].xz / 8, persik[g].w + persik[g].xz / 4, persik[g].h + persik[g].xz / 4);
            }
        }
        batch.setColor(1, 1, 1, 1);
        batch.draw(shoot, -cx + shootx, -cy + shooty, 100, 100);


        stalker.draw();

        for (int i = 0; i < travax.length; i += 1) {
            if (travay[i] <= persik[ym].y + 20) {
                colorSet(travax[i] - travas[i] / 2 - travaa[i] / 2, travay[i] - travas[i] / 2 - travaa[i] / 2);
                batch.draw(trava, -cx + travax[i] - travas[i] / 2 - travaa[i] / 2 + atas_sin, -cy + travay[i] - travas[i] / 2 - travaa[i] / 2 + atas_cos, travas[i] + travaa[i] + 10, travas[i] + travaa[i] + 10);
            }
        }
        for (int i = 0; i < derevox.length; i += 1) {
            if (derevoy[i] < persik[ym].y + 5) {
                colorSet(derevox[i], derevoy[i]);
                batch.draw(derevoa[derevos[i]], -cx + derevox[i], -cy + derevoy[i], 220, 300);
            }
        }
        batch.setColor(1, 1, 1, 1);
        if (draw_topor) {
            if (toporn <= 45) {
                gr_topor += 2;
                toporn += 1;
            }
            if (toporn >= 45) {
                toporn = 0;
                draw_topor = false;
                gr_topor = 210;
            }
            colorSet(100, 100);
            batch.draw(toporiRegion, w / 2 + 50, h / 2 - 20, 50, 50, 100, 100, 1, 1, gr_topor);
        }
        batch.setColor(1, 1, 1, 1);
        if (draw_kirka) {
            if (kirkan <= 45) {
                gr_kirka += 2;
                kirkan += 1;
            }
            if (kirkan >= 45) {
                kirkan = 0;
                draw_kirka = false;
                gr_kirka = 210;
            }
            colorSet(100, 100);
            batch.draw(kirkaiRegion, w / 2 + 50, h / 2 - 20, 50, 50, 100, 100, 1, 1, gr_kirka);
        }
        batch.setColor(1, 1, 1, 1);
        if (draw_arb) {
            if (arbn <= 45) {
                gr_arb += 2;
                arbn += 1;
            }
            if (arbn >= 45) {
                arbn = 0;
                draw_arb = false;
                gr_arb = 210;
            }
            colorSet(100, 100);
            batch.draw(arbiRegion, w / 2 + 50, h / 2 - 20, 50, 50, 100, 100, 1, 1, gr_arb);
        }
        for (int i = 0; i < hs.length; i += 1) {
            hs[i].draw();
        }
        batch.end();

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        drawer.begin(ShapeRenderer.ShapeType.Filled);

        for (int i = 0; i < p.length; i += 1) {
            p[i].draw();
        }

        drawer.end();

        batch.begin();

        float a = Math.abs((float) Math.sin(time * 15f / 180f * Math.PI));
        float r = Math.abs((float) Math.sin((time * 15f + 45f) / 180f * Math.PI));
        float g = Math.abs((float) Math.cos((time * 15f - 30f) / 180f * Math.PI));
        float b = Math.abs((float) Math.sin((time * 15f + 90f) / 180f * Math.PI));
        batch.setColor(r, g, b, a);
        batch.draw(nebo, 0, 0, w, h);
        batch.setColor(1, 1, 1, 1);

        batch.setColor(1, 1, 1, 1);

        batch.draw(kraft_bar, barx, bary, w / 4.5f, h);
        batch.setColor(1, 1, 1, 1);

        batch.draw(syp, sypx_bar, sypy_bar, w / 4.5f, 200);
        batch.setColor(1, 1, 1, 1);

        batch.draw(sypp_bar, syppx_bar, syppy_bar, w / 4.5f, 200);
        batch.setColor(1, 1, 1, 1);

        batch.draw(arb_bar, arbx_bar, arby_bar, w / 4.5f, 200);
        batch.setColor(1, 1, 1, 1);

        if (state_korobka == 0) {
            batch.draw(korobka, korobkax, korobkay, 224, 224);
        } else {
            batch.draw(korobka_s, korobkax - state_korobka / 2, korobkay - state_korobka / 2, 224 + state_korobka, 224 + state_korobka);
            state_korobka -= 1;
        }
        batch.setColor(1, 1, 1, 1);
        if (state_topor == 0) {
            batch.draw(topor, toporx, topory, 224, 224);
        } else {
            batch.draw(topor_s, toporx - state_topor / 2, topory - state_topor / 2, 224 + state_topor, 224 + state_topor);
            state_topor -= 1;
        }
        if (state_kapkan == 0) {
            batch.draw(build_kapkan, build_kapkanx, build_kapkany, 224, 224);
        } else {
            batch.draw(build_kapkan_s, build_kapkanx - state_kapkan / 2, build_kapkany - state_kapkan / 2, 224 + state_kapkan, 224 + state_kapkan);
            state_kapkan -= 1;
        }
        if (state_attack == 0) {
            batch.draw(attack, attackx, attacky, 224, 224);
        } else {
            batch.draw(attack_s, attackx - state_attack / 2, attacky - state_attack / 2, 224 + state_attack, 224 + state_attack);
            state_attack -= 1;
        }
        batch.setColor(1, 1, 1, 1);


        batch.draw(chistka, (w / 2 - 300 + 60 * 10) + 5, 25, 40, 40);


        for (int i = 0; i < slots.length; i += 1) {
            batch.draw(slot, w / 2 - 300 + 600 / slots.length * i, 20 + random.nextInt(2) - 2, 50, 50);
            if (slots[i][0] == 1) {
                batch.draw(grib, (w / 2 - 300 + 600 / slots.length * i) + 5, (20 + random.nextInt(2) - 2) + 5, 40, 40);
            }
            if (slots[i][0] == 2) {
                batch.draw(brevno, (w / 2 - 300 + 600 / slots.length * i) + 5, (20 + random.nextInt(2) - 2) + 5, 40, 40);
            }
            if (slots[i][0] == 3) {
                batch.draw(syp_item, (w / 2 - 300 + 600 / slots.length * i) + 5, (20 + random.nextInt(2) - 2) + 5, 40, 40);
            }
            if (slots[i][0] == 4) {
                batch.draw(enemy, (w / 2 - 300 + 600 / slots.length * i) + 5, (20 + random.nextInt(2) - 2) + 5, 40, 40);
            }
            if (slots[i][0] == 5) {
                batch.draw(sypp, (w / 2 - 300 + 600 / slots.length * i) + 5, (20 + random.nextInt(2) - 2) + 5, 40, 40);
            }
            if (slots[i][0] == 6) {
                batch.draw(iron_m, (w / 2 - 300 + 600 / slots.length * i) + 5, (20 + random.nextInt(2) - 2) + 5, 40, 40);
            }
        }
        for (int i = 0; i < hps.length; i += 1) {
            //batch.draw(hp_texture, w / 2 - 400 + 800 / slots.length * i, 1000 + random.nextInt(2) - 2, 100, 100);
            if (hps[4] == 0) {
                if (hps[i] == 1) {
                    batch.draw(hp_texture, w / 2 - 400 + 800 / slots.length * i, h / 1.1f + random.nextInt(7) - 2, 100, 100);
                }
                if (hps[i] == 0) {
                    batch.draw(hp_texture_low, w / 2 - 400 + 800 / slots.length * i, h / 1.1f + random.nextInt(7) - 2, 100, 100);
                }
            }
            if (hps[4] == 1) {
                if (hps[i] == 1) {
                    batch.draw(hp_texture, w / 2 - 400 + 800 / slots.length * i, h / 1.1f + random.nextInt(4) - 2, 100, 100);
                }
                if (hps[i] == 0) {
                    batch.draw(hp_texture_low, w / 2 - 400 + 800 / slots.length * i, h / 1.1f + random.nextInt(4) - 2, 100, 100);
                }
            }
        }
        for (int i = 0; i < hungrys.length; i += 1) {
            //batch.draw(hp_texture, w / 2 - 400 + 800 / slots.length * i, 1000 + random.nextInt(2) - 2, 100, 100);
            if (hungrys[4] == 0) {
                if (hungrys[i] == 1) {
                    batch.draw(hungry_texture, w / 2 - 400 + 800 / slots.length * i, h / 1.2f + random.nextInt(7) - 2, 100, 100);
                }
                if (hungrys[i] == 0) {
                    batch.draw(hungry_texture_low, w / 2 - 400 + 800 / slots.length * i, h / 1.2f + random.nextInt(7) - 2, 100, 100);
                }
            }
            if (hungrys[4] == 1) {
                if (hungrys[i] == 1) {
                    batch.draw(hungry_texture, w / 2 - 400 + 800 / slots.length * i, h / 1.2f + random.nextInt(4) - 2, 100, 100);
                }
                if (hungrys[i] == 0) {
                    batch.draw(hungry_texture_low, w / 2 - 400 + 800 / slots.length * i, h / 1.2f + random.nextInt(4) - 2, 100, 100);
                }
            }
        }

        for (int g2 = 0; g2 < persik.length; g2 += 1) {
            persik[g2].drawBar(this);
        }

        font_1.draw(batch, "ВОЛНА:", w / 1.3f, h / 1.1f);
        font_1.draw(batch, (int) wawe - 1 + "", w / 1.12f, h / 1.1f);
        font_1.draw(batch, "HP:", 1350, 70);
        font_1.draw(batch, (int) hp_kraft + "", 1470, 70);
        if (hp_kraft <= 0) {
            int i3 = 9;
            for (int i2 = 9; i2 > -1; ) {
                if (hps[i3] == 1) {
                    hps[i3] = 0;
                    i2 -= 1;
                }
                if (hps[i3] == 0) {
                    i3 -= 1;
                }
            }
        }

        batch.end();


        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        drawer.begin(ShapeRenderer.ShapeType.Filled);

        drawer.setColor(0.9f, 0.9f, 0.9f, 1);
        float x, y, size;
        x = w / 10;
        y = h - w / 10 - h / 21;
        size = w / 10;

        for (int i = 18; i <= 360; i += 36) {
            drawer.setColor(0.15f, 0.15f, 0.15f, 1f);
            drawer.arc(x + 10, y, size * 1f, i + 6, 12);
            drawer.setColor(0.2f, 0.2f, 0.2f, 1f);
            drawer.arc(x + 10, y, size * 0.975f, i, 24);
        }

        for (int i = 36; i >= 1; i -= 1) {
            drawer.setColor(0.9f - i * 0.01f, 0.9f - i * 0.01f, 0.9f - i * 0.01f, 1);
            drawer.circle(x + 10, y, size * i / 37f * 0.95f);
        }
        drawer.setColor(0.8f, 0.3f, 0.3f, 1);
        drawer.arc(x + 10, y, size * 0.65f, 810, 90);

        drawer.setColor(0.7f, 0.3f, 0.3f, 1);
        drawer.arc(x + 10, y, size * 0.85f, 810, 90);


        for (int i = 0; i <= 360; i += 36) {
            drawer.setColor(0.2f, 0.2f, 0.2f, 0.1f);
            drawer.arc(x + 10, y, size * 0.85f, i, 24);
        }


        drawer.setColor(0.2f, 0.2f, 0.4f, 1);
        drawer.rectLine(x + 10, y, x + (float) Math.sin(((int) (rotate2 / 4)) * 4 / 180f * Math.PI) * size * 0.85f, y + (float) Math.cos(((int) (rotate2 / 4)) * 4 / 180f * Math.PI) * size * 0.85f, 6);

        //drawer.setColor(0.4f,0.4f,0.4f,1);
        //drawer.rectLine(x,y,x+(float) Math.sin(((int) (rotate)/4)*4/180*Math.PI)*size*0.85f,y+(float) Math.cos(((int) (rotate)/4)*4/180*Math.PI)*size*0.85f,4);


        drawer.end();

    }

    public Texture[] generateBiom(int fx, int fy, int res, int fz, int v1, float v2, int v3,
                                  int v4) {
        Texture[] biomchik = new Texture[fz];
        Pixmap[] biom = new Pixmap[fz];
        float d = 0;
        for (int i = 0; i < fz; i += 1) {
            biom[i] = new Pixmap(fx * res, fy * res, Pixmap.Format.RGBA8888);
        }
        for (int i2 = 0; i2 <= v3; i2 += 1) {
            float r = 0.1f;
            float g = 0.7f;
            float b = 0.15f;
            int ix = random.nextInt(fx * res);
            int iy = random.nextInt(fy * res);
            int iz = random.nextInt(fz);
            r = 0f;
            g = 0f;
            b = 0f;
            d = 0;
            for (int i3 = 0; i3 < point.length; i3 += 1) {
                d += hit2(ix, iy, point[i3][0], point[i3][1]);
            }
            for (int i3 = 0; i3 < point.length; i3 += 1) {
                float k = hit2(ix, iy, point[i3][0], point[i3][1]) / d;
                r += point[i3][2] * k;
                g += point[i3][3] * k;
                b += point[i3][4] * k;
            }
            for (int i = 0; i <= v4; i += 1) {
                ix += random.nextInt(5) - 2;
                iy += random.nextInt(5) - 2;
                if (random.nextInt(v1) == 0) {
                    iz += random.nextInt(3) - 1;
                    r += (random.nextInt(100) - 50) / 1000f * v2;
                    g += (random.nextInt(100) - 50) / 1000f * v2;
                    b += (random.nextInt(100) - 50) / 1000f * v2;
                }

                ix = Math.max(Math.min(ix, fx * res - 1), 0);
                iy = Math.max(Math.min(iy, fy * res - 1), 0);
                iz = Math.max(Math.min(iz, fz - 1), 0);
                biom[iz].setColor((r / fz * (iz + 1) + 0.5f) / 2, (g / fz * (iz + 1) + 0.5f) / 2, (b / fz * (iz + 1) + 0.5f) / 2, 1);
                biom[iz].drawPixel(ix, iy);
            }
        }

        for (int i = 0; i < fz; i += 1) {
            biomchik[i] = new Texture(biom[i]);
        }

        return biomchik;
    }

    public float sin(float v) {
        return (float) Math.sin(v * Math.PI / 180f);
    }

    public float cos(float v) {
        return (float) Math.cos(v * Math.PI / 180f);
    }
}
