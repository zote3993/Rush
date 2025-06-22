package com.rush;

import com.badlogic.gdx.Gdx;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ThroughClient {
    String ip = "89.104.66.26";
    int port = 5269;
    Rash m;
    boolean run = true;
    public ThroughClient(Rash main) {
        m = main;
    }
    public void start() throws IOException {
        Socket socket = new Socket(ip, port);
        Gdx.app.log("CLIENT", "CONNECTED TO ADDRESS " + ip + ":" + port);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)); BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            while (run) {
                // - - - ПОЛУЧЕНИЕ ИНФОРМАЦИИ - - -
                ThroughServerPacket received = mapper.readValue(in.readLine(), ThroughServerPacket.class);
                if (m.initialized) {
                    m.updateData(received);
                } else {
                    m.initializationData = received;
                    while(!m.initialized){
                        Thread.sleep(10);
                    }
                }
                // - - - ОТПРАВКА АТАСНОЙ МАТРАСНОЙ ИНФОРМАЦИИ - - -
                ThroughClientPacket sent = new ThroughClientPacket();
                Persik person = m.persik[m.ym];
                sent.x = person.x;
                sent.y = person.y;
                sent.z = person.xz;
                sent.vx = person.sx;
                sent.vy = person.sy;
                sent.vz = person.sz;
                sent.cr = person.cr;
                sent.cg = person.cg;
                sent.cb = person.cb;
                sent.health = 0;
                sent.maxHealth = 0;
                sent.t = person.nameT;
                sent.name = person.name;
                String sentString = mapper.writeValueAsString(sent);
                out.write(sentString + "\n");
                out.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            socket.close();
            Gdx.app.log("CLIENT", "DISCONNECTED");
        }
    }

}
