package com.eschool.model.parent;

import com.eschool.domain.parent.Father;
import com.eschool.domain.parent.Mother;
import com.eschool.domain.parent.Parent;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class MotherModel extends ParentModel {
    @Override
    public Parent toParent() {
        return new Mother(getName(),getCnic(),getOccupation(),getMonthlySalary(),getContactNumbers(),getAddress());
    }
}