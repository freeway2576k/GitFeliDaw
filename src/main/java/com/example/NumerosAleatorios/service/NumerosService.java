package com.example.NumerosAleatorios.service;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class NumerosService {
    public Set<Integer> list = new LinkedHashSet<>();
    Random random = new Random();

    public void add(){
        boolean added;
        do { added = list.add(random.nextInt(100)+1);
        } while (!added);
    }

    public void delete(Integer id){
        list.remove(id);
    }

    public Set<Integer> getList(){
        return list;
    }

    public Integer getTotalNumbers(){
        return list.size();
    }
}
