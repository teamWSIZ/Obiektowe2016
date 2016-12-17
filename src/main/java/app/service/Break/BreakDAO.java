package app.service.Break;


import app.model.Break;

import java.util.List;

public interface BreakDAO {
    public List<Break> findAll();
    public Break getById(Integer breakId);
    public void inserNew(Break b);
    public void updateBreak(Break b);
    public void deleteBreak(Integer breakId);
}
