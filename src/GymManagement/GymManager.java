package GymManagement;

import javafx.scene.control.Label;

import java.util.List;

public interface GymManager {
    public void addMember(DefaultMember member);
    public boolean deleteMember(Integer membershipNumber);
    public void print();
    public List<DefaultMember> sort();
    public void save();
    public void search(String searchValue, Label lbl);
}
