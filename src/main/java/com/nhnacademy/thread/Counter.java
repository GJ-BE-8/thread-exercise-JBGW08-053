/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Counter {
    private final long countMaxSize;
    private long count;

    public Counter(long countMaxSize) {
        if(countMaxSize < 0){
            throw new IllegalArgumentException("countMaxSize is less than 0");
        }
        else{
            this.countMaxSize = countMaxSize;
        }

        this.count=0;

    }

    public void run(){

        do {

            /*TODO#4 1초 간격 으로 count++ 됩니다.
              Thread.sleep method를 사용하세요.
              https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html#sleep(java.time.Duration)
            */
            try {
                Thread.sleep(1000);
                count++;
            }
            catch(InterruptedException e){
                log.error("Thread Error: {}", Thread.currentThread().getName(), e);
            }
            /*TODO#5 count 출력
                name:{Thread name}, count:{count 변수}
                Thread name : Thread.currentThread().getName();
                ex) name:my-thread, count:1
             */
            System.out.println("name:"+Thread.currentThread().getName() + ", count:" + count);

        }while (count<countMaxSize);
    }
}
