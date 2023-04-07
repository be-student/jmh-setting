/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.champeau.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class SampleBenchmark {
    @Fork(1)
    @Benchmark
    public void fibClassic(Blackhole bh) {
        bh.consume(func1());
    }

    @Fork(1)
    @Benchmark
    public void fibTailRec(Blackhole bh) {
        bh.consume(func2());
    }

    @Fork(1)
    @Benchmark
    public void fibTailRec2(Blackhole bh) {
        bh.consume(func3());
    }

    private Object func1(){
        try{
           return new Object();
        }catch (Exception e){
            return new Object();
        }
    }
    private Object func2(){
        try{
            return new Exception();
        }catch (Exception e){
            return new Exception();
        }
    }

    private Object func3(){
        try {
            return new NoStackTrace();
        } catch (Exception e) {
            return new NoStackTrace();
        }
    }
}
class NoStackTrace extends Throwable{
    public NoStackTrace(){
        super(null,null,false,false);
    }
}
