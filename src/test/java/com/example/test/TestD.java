package com.example.test;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 直接内存在读和写的性能都优于堆内内存，但是内存申请速度却不如堆内内存，所以可以归纳一下：
    直接内存适用于不常申请，但是需要频繁读取的场景，
    在需要频繁申请的场景下不应该使用直接内存(DirectMemory)，而应该使用堆内内存(HeapMemory)。
 */
public class TestD {
    @Test
    public void testDirectMemoryWriteAndReadSpeed() {
        long tsStart = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocateDirect(400);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (byte j = 0; j < 100; j++) {
                buffer.getInt();
            }
            buffer.clear();
        }
        System.out.println("DirectMemory读写耗用： " + (System.currentTimeMillis() - tsStart) + " ms");
        tsStart = System.currentTimeMillis();
        buffer = ByteBuffer.allocate(400);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100; j++) {
                buffer.putInt(j);
            }
            buffer.flip();
            for (byte j = 0; j < 100; j++) {
                buffer.getInt();
            }
            buffer.clear();
        }
        System.out.println("Heap读写耗用： " + (System.currentTimeMillis() - tsStart) + " ms");
    }

    /**
     * 测试DirectMemory和Heap内存申请速度。
     */
    @Test
    public void testDirectMemoryAllocate() {
        long tsStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(400);

        }
        System.out.println("DirectMemory申请内存耗用： " + (System.currentTimeMillis() - tsStart) + " ms");
        tsStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ByteBuffer buffer = ByteBuffer.allocate(400);
        }
        System.out.println("Heap申请内存耗用： " + (System.currentTimeMillis() - tsStart) + " ms");
    }
    }
