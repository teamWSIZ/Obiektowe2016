package app.service.duty;

import app.model.Duty;

import java.util.List;

public interface DutyDao {
    public List<Duty> findAll();
    public Duty findById(Integer dutyId);
    public void inserNew(Duty d);
    public void updateDuty(Duty d);
    public void deleteDuty(Integer dutyId);
}
