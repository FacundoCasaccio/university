package service;

import dao.CareerDAO;
import dao.StudentDAO;
import domain.Career;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CareerService {
    private final CareerDAO careerDAO = new CareerDAO();

    public Career getCareerById(int id) {
        return this.careerDAO.select(id);
    }

    public List<Career> getAllCareers() {
        return this.careerDAO.selectAll();
    }

    public List<Career> getAllCareersByCost() {
        return this.careerDAO.selectAll().stream()
                .sorted(Comparator.comparing(Career::getCost))
                .collect(Collectors.toList());
    }

    public void registerCarreer(Career career) {
        this.careerDAO.insert(career);
    }

    public void updateCareerById(Career career, int id) {
        this.careerDAO.update(career, id);
    }

    public void deleteCareer(Career career) {
        this.careerDAO.delete(career);
    }

    public Career retrieveStudents(Career career) {
        StudentDAO studentDAO = new StudentDAO();

        career.setStudents(studentDAO.selectAll().stream()
                .filter( student -> student.getCareer().getTitle().equalsIgnoreCase( career.getTitle() ) )
                .collect(Collectors.toList()) );

        return career;
    }
}