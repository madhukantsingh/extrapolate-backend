package com.anyaudit.service;

import com.anyaudit.models.Framework;
import com.anyaudit.models.Year;
import com.anyaudit.repository.FrameworkRepository;
import com.anyaudit.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YearManager {
    @Autowired
    private YearRepository yearRepository;

    public List<Year> getAllYear() {
        return yearRepository.findAll();
    }
}
