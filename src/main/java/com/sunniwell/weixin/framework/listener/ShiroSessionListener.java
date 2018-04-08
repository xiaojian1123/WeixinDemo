package com.sunniwell.weixin.framework.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Shiro会话监听器
 *
 * Created by xiaojian on 2018/2/2.
 */
@Component
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
        System.out.println("登录+1==" + sessionCount.get());
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
        System.out.println("登录退出-1==" + sessionCount.get());
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
        System.out.println("登录过期-1==" + sessionCount.get());
    }

    public int getSessionCount() {
        return sessionCount.get();
    }
}
