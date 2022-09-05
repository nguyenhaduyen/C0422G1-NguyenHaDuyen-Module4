package com.example.service;

import com.example.model.PaperDeclaration;

import java.util.List;

public interface IPaperDeclarationService {
    void save(PaperDeclaration paperDeclaration);

    List<PaperDeclaration> show();

    PaperDeclaration findId(int id);

    void edit(PaperDeclaration paperDeclaration);
}
