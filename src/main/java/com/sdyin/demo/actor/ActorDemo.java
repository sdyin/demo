package com.sdyin.demo.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/17 10:10
 */
public class ActorDemo {

    static class HelloActor extends UntypedActor{
        @Override
        public void onReceive(Object message) throws Throwable {
            System.out.println("receive:" + message);
        }
    }

    public static void main(String[] args) {
        // 创建 Actor 系统
        ActorSystem actorSystem = ActorSystem.create("helloSystem");
        //创建 HelloActor
        ActorRef helloActor = actorSystem.actorOf(Props.create(HelloActor.class));
        //发送消息给 HelloActor
        helloActor.tell("Actor message",ActorRef.noSender());


    }
}
