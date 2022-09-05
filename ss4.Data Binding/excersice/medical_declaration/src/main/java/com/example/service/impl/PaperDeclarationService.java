package com.example.service.impl;

import com.example.model.PaperDeclaration;
import com.example.repository.IPaperDeclarationRepository;
import com.example.service.IPaperDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperDeclarationService implements IPaperDeclarationService {
    @Autowired
    private IPaperDeclarationRepository iPaperDeclarationRepository;

    @Override
    public void save(PaperDeclaration paperDeclaration) {
        iPaperDeclarationRepository.save(paperDeclaration);
    }

    @Override
    public List<PaperDeclaration> show() {
        return iPaperDeclarationRepository.show();
    }

    @Override
    public PaperDeclaration findId(int id) {
        return iPaperDeclarationRepository.findId(id);
    }

    @Override
    public void edit(PaperDeclaration paperDeclaration) {
        iPaperDeclarationRepository.edit(paperDeclaration);
    }
}
