package com.xx;

import com.xx.socket.SocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xx.mapper")
public class IdoctorApplication {

    public static void main(String[] args) {

        //解决netty冲突
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(IdoctorApplication.class, args);

        //起socket服务
        SocketServer server = new SocketServer();
        server.startSocketServer(8001);

    }

}
