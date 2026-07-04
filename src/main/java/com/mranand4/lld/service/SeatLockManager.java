package com.mranand4.lld.service;

import com.mranand4.lld.model.Screening;
import com.mranand4.lld.model.cinema.Seat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SeatLockManager {

    private class SeatLock {

        LocalDateTime expirationTime;

        SeatLock(LocalDateTime expirationTime) {
            this.expirationTime = expirationTime;
        }

        boolean isExpired() {
            return LocalDateTime.now().isAfter(expirationTime);
        }
    }

    private Map<String, SeatLock> lockedSeats;
    private Duration lockDuration;

    public SeatLockManager(Duration lockDuration) {
        this.lockDuration = lockDuration;
        lockedSeats = new ConcurrentHashMap<>();
    }

    // given that we are using uuid for id's of seat and screening
    // just returning seat id would be fine too, but I'm keeping
    // it consistent with what we have in book
    private String generateLockKey(Screening screening, Seat seat) {
        return screening.getId() + "-" + seat.getId();
    }

    private void cleanUpLockIfExpired(String lockKey) {
        SeatLock seatLock = lockedSeats.get(lockKey);
        if(seatLock != null && seatLock.isExpired()) {
            lockedSeats.remove(lockKey);
        }
    }

    private synchronized boolean isLocked(Screening screening, Seat seat) {
        String lockKey = generateLockKey(screening, seat);

        cleanUpLockIfExpired(lockKey);

        return lockedSeats.containsKey(lockKey);
    }

    public synchronized boolean lockSeat(Screening screening, Seat seat) {
        String lockKey = generateLockKey(screening, seat);

        cleanUpLockIfExpired(lockKey);

        if(isLocked(screening, seat)) {
            return false;
        }

        SeatLock seatLock = new SeatLock(LocalDateTime.now().plus(lockDuration));
        lockedSeats.put(lockKey, seatLock);
        return true;
    }
}
