package org.prakarshs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheInterfaceIMPl<K,V> implements CacheInterface<K,V>{
    private ConcurrentHashMap<K,V> map = new ConcurrentHashMap<>();
    private Integer size;
    @Override
    public synchronized void put(K key, V value) {
        try{
            if(size == map.size()){
                wait();
                eviction.evict();
            }

        }catch(Exception E){
            System.out.println("Couldnt put value!");
        }
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }
}
