package com.example.repository.impl;

import com.example.model.PaperDeclaration;
import com.example.repository.IPaperDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaperDeclarationRepository implements IPaperDeclarationRepository {
    private static List<PaperDeclaration> paperDeclarationList = new ArrayList<>();

    static {
        paperDeclarationList.add(new PaperDeclaration(1, "Thao Le", "2000", "nữ", "Việt Nam", "123456789", "Ô Tô", "OT123", "4", "4", "12", "2002", "5", "3", "2003", "Đà Nẵng"));
        paperDeclarationList.add(new PaperDeclaration(2, "Ha Duyen", "2000", "nữ", "Việt Nam", "123456798", "Máy bay", "MB123", "4", "6", "8", "2013", "10", "9", "2013", "Đà Nẵng"));
        paperDeclarationList.add(new PaperDeclaration(3, "Thuan Chau", "2000", "nam", "Việt Nam", "187456789", "Tàu Thuyền", "TT143", "24", "9", "8", "2012", "5", "8", "2022", "Đà Nẵng"));
        paperDeclarationList.add(new PaperDeclaration(4, "Da Phuc", "2000", "nam", "Việt Nam", "093456789", "Ô Tô", "OT023", "12", "4", "5", "2004", "25", "8", "2022", "Đà Nẵng"));
        paperDeclarationList.add(new PaperDeclaration(5, "Thuy Tien", "2000", "nữ", "Việt Nam", "126756789", "Ô Tô", "OT193", "6", "16", "1", "2009", "17", "7", "2022", "Đà Nẵng"));
    }

    @Override
    public void save(PaperDeclaration paperDeclaration) {
        int id = (int) (Math.random() * 1000);
        paperDeclaration.setId(id);
        paperDeclarationList.add(paperDeclaration);
    }

    @Override
    public List<PaperDeclaration> show() {
        return paperDeclarationList;
    }

    @Override
    public PaperDeclaration findId(int id) {
        PaperDeclaration paperDeclaration = new PaperDeclaration();
        for (int i = 0; i < paperDeclarationList.size(); i++) {
            if (id == paperDeclarationList.get(i).getId()) {
                paperDeclaration = paperDeclarationList.get(i);
            }
        }
        return paperDeclaration;
    }

    @Override
    public void edit(PaperDeclaration paperDeclaration) {
        for (int i = 0; i < paperDeclarationList.size(); i++) {
            if (paperDeclaration.getId() == paperDeclarationList.get(i).getId()) {
                paperDeclarationList.get(i).setName(paperDeclaration.getName());
                paperDeclarationList.get(i).setYearOfBirth(paperDeclaration.getYearOfBirth());
                paperDeclarationList.get(i).setGender(paperDeclaration.getGender());
                paperDeclarationList.get(i).setNation(paperDeclaration.getNation());
                paperDeclarationList.get(i).setIdentify(paperDeclaration.getIdentify());
                paperDeclarationList.get(i).setVehicle(paperDeclaration.getVehicle());
                paperDeclarationList.get(i).setVehicleCode(paperDeclaration.getVehicleCode());
                paperDeclarationList.get(i).setNumberOfSeats(paperDeclaration.getNumberOfSeats());
                paperDeclarationList.get(i).setStartDate(paperDeclaration.getStartDate());
                paperDeclarationList.get(i).setMonthStart(paperDeclaration.getMonthStart());
                paperDeclarationList.get(i).setYearStart(paperDeclaration.getYearStart());
                paperDeclarationList.get(i).setEndDate(paperDeclaration.getEndDate());
                paperDeclarationList.get(i).setMonthEnd(paperDeclaration.getMonthEnd());
                paperDeclarationList.get(i).setYearEnd(paperDeclaration.getYearEnd());
                paperDeclarationList.get(i).setNotification(paperDeclaration.getNotification());
            }
        }
    }
}
