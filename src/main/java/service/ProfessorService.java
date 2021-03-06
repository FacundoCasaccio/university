package service;

import jdbc.ProfessorDAO;
import domain.Professor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorService {
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    public Professor getProfessorById(int id) {
        return this.professorDAO.select(id);
    }

    public List<Professor> getAllProfessors() {
        return this.professorDAO.selectAll();
    }

    public List<Professor> getAllProfessorsAlphabetically() {
        return this.professorDAO.selectAll().stream()
                .sorted(Comparator.comparing(Professor::getName))
                .collect(Collectors.toList());
    }

    public void registerProfessor(Professor professor) {
        this.professorDAO.insert(professor);
    }

    public void updateProfessorById(Professor professor, int id) {
        this.professorDAO.update(professor, id);
    }

    public void deleteProfessor(Professor professor) {
        this.professorDAO.delete(professor);
    }
}
