package com.example.repository;

import com.example.model.PaperDeclaration;

import java.util.List;

public interface IPaperDeclarationRepository {
    void save(PaperDeclaration paperDeclaration);

    List<PaperDeclaration> show();

    PaperDeclaration findId(int id);

    void edit(PaperDeclaration paperDeclaration);
}
