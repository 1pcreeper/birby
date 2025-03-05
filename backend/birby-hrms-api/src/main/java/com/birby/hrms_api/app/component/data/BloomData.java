package com.birby.hrms_api.component.data;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Getter
public class BloomData {
    private BloomFilter<String> data;
    @Autowired
    public BloomData(){
        this.data = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                1000,
                0.01
        );
    }
}