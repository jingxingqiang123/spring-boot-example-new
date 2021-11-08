package com.example.schedule;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@EnableScheduling
@Component
@Slf4j
public class ScheduleLock {
    @Autowired
    private RedissonClient redissonClient;

    //    @Scheduled(fixedRate = 1000)
    public void schedule() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        log.info(format);
    }

//    @Scheduled(fixedRate = 10000)
//    public void testTryLock() throws InterruptedException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        log.info("------TryLock-------------获取锁: {}", simpleDateFormat.format(new Date()));
//        RLock rLock = redissonClient.getLock("test:user:lock");
//        boolean isLock = rLock.tryLock(2, 20, TimeUnit.SECONDS);
//        if (!isLock) {
//            log.warn("Failed to obtain the distributed lock. Procedure");
//            return;
//        }
//        try {
//            log.info("-------TryLock------------开始执行任务{}", simpleDateFormat.format(new Date()));
//            TimeUnit.SECONDS.sleep(3);
//            log.info("-------TryLock-----------执行完任务{}", simpleDateFormat.format(new Date()));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            log.info("-------TryLock-----------解锁: {}", simpleDateFormat.format(new Date()));
//            rLock.unlock();
//        }
//    }

//    @Scheduled(fixedRate = 10000)
//    public void scheduleSuccess() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        log.info("------lock-------------获取锁: {}", simpleDateFormat.format(new Date()));
//        RLock rLock = redissonClient.getLock("test:user:lock");
//        try {
//            rLock.lock();
//            log.info("-------lock------------开始执行任务{}", simpleDateFormat.format(new Date()));
//            TimeUnit.SECONDS.sleep(3);
//            log.info("-------lock-----------执行完任务{}", simpleDateFormat.format(new Date()));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            log.info("-------lock-----------解锁 {}", simpleDateFormat.format(new Date()));
//            rLock.unlock();
//        }
//    }

    // fixedRate单位为毫秒
    @Scheduled(fixedRate = 10000)
    public void testTryLock1() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("------TryLock1-------------获取锁: {}", simpleDateFormat.format(new Date()));
        RLock rLock = redissonClient.getLock("test:user:lock");
        boolean isLock = rLock.tryLock(2, 60 * 5, TimeUnit.SECONDS);
        if (!isLock) {
            log.warn("Failed to obtain the distributed lock. Procedure");
            return;
        }
        try {
            log.info("-------TryLock------------开始执行任务{}", simpleDateFormat.format(new Date()));
            TimeUnit.SECONDS.sleep(7);
            log.info("-------TryLock-----------执行完任务{}", simpleDateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("-------TryLock-----------解锁: {}", simpleDateFormat.format(new Date()));
            // 任务执行的时间，超过了锁过期的时间的话。解锁就会报错，必须判断锁是否还存在！！！
            if (rLock.isLocked()) {
                log.info("--------------解锁 rLock: {}", rLock.isLocked());
                rLock.unlock();
            }
        }
    }
}
